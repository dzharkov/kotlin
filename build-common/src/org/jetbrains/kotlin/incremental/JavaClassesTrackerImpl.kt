/*
 * Copyright 2010-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.incremental

import com.intellij.psi.PsiJavaFile
import com.intellij.util.io.DataExternalizer
import org.jetbrains.kotlin.load.java.JavaClassesTracker
import org.jetbrains.kotlin.load.java.descriptors.JavaClassDescriptor
import org.jetbrains.kotlin.name.ClassId
import org.jetbrains.kotlin.protobuf.ExtensionRegistryLite
import org.jetbrains.kotlin.resolve.descriptorUtil.classId
import org.jetbrains.kotlin.resolve.jvm.JvmClassName
import org.jetbrains.kotlin.resolve.source.PsiSourceElement
import org.jetbrains.kotlin.serialization.DescriptorSerializer
import org.jetbrains.kotlin.serialization.ProtoBuf
import org.jetbrains.kotlin.serialization.builtins.BuiltInsProtoBuf
import org.jetbrains.kotlin.serialization.deserialization.NameResolverImpl
import org.jetbrains.kotlin.serialization.java.JavaClassProtoBuf
import org.jetbrains.kotlin.utils.addToStdlib.safeAs
import org.jetbrains.kotlin.utils.sure
import java.io.DataInput
import java.io.DataOutput
import java.io.File

class JavaClassesTrackerImpl(private val cache: IncrementalJvmCache) : JavaClassesTracker {
    private val classToSourceSerialized: MutableMap<JvmClassName, SerializedJavaClassWithSource> = hashMapOf()

    val javaClassesUpdates
        get() = classToSourceSerialized.values

    private val classDescriptors: MutableList<JavaClassDescriptor> = mutableListOf()

    override fun reportClass(classDescriptor: JavaClassDescriptor) {
        val classId = classDescriptor.classId!!
        if (!cache.isJavaClassToTrack(classId) || classDescriptor.javaSourceFile == null) return

        classDescriptors.add(classDescriptor)
    }

    override fun onCompletedAnalysis() {
        for (classDescriptor in classDescriptors.toList()) {
            classToSourceSerialized[JvmClassName.byClassId(classDescriptor.classId!!)] =
                    classDescriptor.convertToProto()
        }
        classDescriptors.clear()
    }

    override fun getAdditionalClassesToReport(): Collection<ClassId> = cache.getObsoleteJavaClasses()
}

private val JavaClassDescriptor.javaSourceFile: File?
    get() = source.safeAs<PsiSourceElement>()
            ?.psi?.containingFile?.takeIf { it is PsiJavaFile }
            ?.virtualFile?.path?.let(::File)

fun JavaClassDescriptor.convertToProto(): SerializedJavaClassWithSource {
    val file = javaSourceFile.sure { "convertToProto should only be called for source based classes" }

    val extension = JavaClassesSerializerExtension()
    val serializer = DescriptorSerializer.createTopLevel(extension)
    val classProto = serializer.classProto(this).build()

    val (stringTable, qualifiedNameTable) = extension.stringTable.buildProto()

    return SerializedJavaClassWithSource(file, SerializedJavaClass(classProto, stringTable, qualifiedNameTable))
}

class SerializedJavaClass(
        val proto: ProtoBuf.Class,
        val stringTable: ProtoBuf.StringTable,
        val qualifiedNameTable: ProtoBuf.QualifiedNameTable
) {
    val classId: ClassId
        get() = NameResolverImpl(stringTable, qualifiedNameTable).getClassId(proto.fqName)
}

data class SerializedJavaClassWithSource(
        val source: File,
        val proto: SerializedJavaClass
)

fun SerializedJavaClass.toProtoData() = ClassProtoData(proto, NameResolverImpl(stringTable, qualifiedNameTable))

val JAVA_CLASS_PROTOBUF_REGISTRY =
        ExtensionRegistryLite.newInstance()
                .also(JavaClassProtoBuf::registerAllExtensions)
                .also(BuiltInsProtoBuf::registerAllExtensions)

object JavaClassProtoMapValueExternalizer : DataExternalizer<SerializedJavaClass> {
    override fun save(output: DataOutput, value: SerializedJavaClass) {
        output.writeBytesWithSize(value.proto.toByteArray())
        output.writeBytesWithSize(value.stringTable.toByteArray())
        output.writeBytesWithSize(value.qualifiedNameTable.toByteArray())
    }

    private fun DataOutput.writeBytesWithSize(bytes: ByteArray) {
        writeInt(bytes.size)
        write(bytes)
    }

    private fun DataInput.readBytesWithSize(): ByteArray {
        val bytesLength = readInt()
        return ByteArray(bytesLength).also {
            readFully(it, 0, bytesLength)
        }
    }

    override fun read(input: DataInput): SerializedJavaClass {
        val proto = ProtoBuf.Class.parseFrom(input.readBytesWithSize(), JAVA_CLASS_PROTOBUF_REGISTRY)
        val stringTable = ProtoBuf.StringTable.parseFrom(input.readBytesWithSize(), JAVA_CLASS_PROTOBUF_REGISTRY)
        val qualifiedNameTable = ProtoBuf.QualifiedNameTable.parseFrom(input.readBytesWithSize(), JAVA_CLASS_PROTOBUF_REGISTRY)

        return SerializedJavaClass(proto, stringTable, qualifiedNameTable)
    }
}
