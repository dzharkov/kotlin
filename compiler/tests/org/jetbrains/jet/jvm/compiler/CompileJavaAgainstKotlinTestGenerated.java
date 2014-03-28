/*
 * Copyright 2010-2014 JetBrains s.r.o.
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

package org.jetbrains.jet.jvm.compiler;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestSuite;

import java.io.File;
import java.util.regex.Pattern;
import org.jetbrains.jet.JetTestUtils;
import org.jetbrains.jet.test.InnerTestClasses;
import org.jetbrains.jet.test.TestMetadata;

import org.jetbrains.jet.jvm.compiler.AbstractCompileJavaAgainstKotlinTest;

/** This class is generated by {@link org.jetbrains.jet.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/compileJavaAgainstKotlin")
@InnerTestClasses({CompileJavaAgainstKotlinTestGenerated.Class.class, CompileJavaAgainstKotlinTestGenerated.Method.class, CompileJavaAgainstKotlinTestGenerated.Property.class, CompileJavaAgainstKotlinTestGenerated.StaticFields.class})
public class CompileJavaAgainstKotlinTestGenerated extends AbstractCompileJavaAgainstKotlinTest {
    public void testAllFilesPresentInCompileJavaAgainstKotlin() throws Exception {
        JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/compileJavaAgainstKotlin"), Pattern.compile("^(.+)\\.kt$"), true);
    }
    
    @TestMetadata("compiler/testData/compileJavaAgainstKotlin/class")
    public static class Class extends AbstractCompileJavaAgainstKotlinTest {
        public void testAllFilesPresentInClass() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/compileJavaAgainstKotlin/class"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("ClassObject.kt")
        public void testClassObject() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/class/ClassObject.kt");
        }
        
        @TestMetadata("DefaultConstructor.kt")
        public void testDefaultConstructor() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/class/DefaultConstructor.kt");
        }
        
        @TestMetadata("DefaultConstructorWithTwoArgs.kt")
        public void testDefaultConstructorWithTwoArgs() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/class/DefaultConstructorWithTwoArgs.kt");
        }
        
        @TestMetadata("ExtendsAbstractListT.kt")
        public void testExtendsAbstractListT() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/class/ExtendsAbstractListT.kt");
        }
        
        @TestMetadata("ImplementsListString.kt")
        public void testImplementsListString() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/class/ImplementsListString.kt");
        }
        
        @TestMetadata("ImplementsMapPP.kt")
        public void testImplementsMapPP() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/class/ImplementsMapPP.kt");
        }
        
        @TestMetadata("InnerClass.kt")
        public void testInnerClass() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/class/InnerClass.kt");
        }
        
        @TestMetadata("InnerClassConstructors.kt")
        public void testInnerClassConstructors() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/class/InnerClassConstructors.kt");
        }
        
        @TestMetadata("InnerClassOfGeneric.kt")
        public void testInnerClassOfGeneric() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/class/InnerClassOfGeneric.kt");
        }
        
        @TestMetadata("kt3561.kt")
        public void testKt3561() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/class/kt3561.kt");
        }
        
        @TestMetadata("kt4050.kt")
        public void testKt4050() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/class/kt4050.kt");
        }
        
        @TestMetadata("Simple.kt")
        public void testSimple() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/class/Simple.kt");
        }
        
    }
    
    @TestMetadata("compiler/testData/compileJavaAgainstKotlin/method")
    @InnerTestClasses({Method.PrimitiveOverride.class, Method.Throws.class})
    public static class Method extends AbstractCompileJavaAgainstKotlinTest {
        @TestMetadata("AccessorGenericSignature.kt")
        public void testAccessorGenericSignature() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/AccessorGenericSignature.kt");
        }
        
        public void testAllFilesPresentInMethod() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/compileJavaAgainstKotlin/method"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("Any.kt")
        public void testAny() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/Any.kt");
        }
        
        @TestMetadata("ArrayOfIntArray.kt")
        public void testArrayOfIntArray() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/ArrayOfIntArray.kt");
        }
        
        @TestMetadata("ArrayOfIntegerArray.kt")
        public void testArrayOfIntegerArray() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/ArrayOfIntegerArray.kt");
        }
        
        @TestMetadata("DefaultMethod.kt")
        public void testDefaultMethod() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/DefaultMethod.kt");
        }
        
        @TestMetadata("Delegation.kt")
        public void testDelegation() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/Delegation.kt");
        }
        
        @TestMetadata("GenericArray.kt")
        public void testGenericArray() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/GenericArray.kt");
        }
        
        @TestMetadata("Hello.kt")
        public void testHello() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/Hello.kt");
        }
        
        @TestMetadata("Int.kt")
        public void testInt() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/Int.kt");
        }
        
        @TestMetadata("IntArray.kt")
        public void testIntArray() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/IntArray.kt");
        }
        
        @TestMetadata("IntWithDefault.kt")
        public void testIntWithDefault() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/IntWithDefault.kt");
        }
        
        @TestMetadata("IntegerArray.kt")
        public void testIntegerArray() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/IntegerArray.kt");
        }
        
        @TestMetadata("ListOfInt.kt")
        public void testListOfInt() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/ListOfInt.kt");
        }
        
        @TestMetadata("ListOfString.kt")
        public void testListOfString() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/ListOfString.kt");
        }
        
        @TestMetadata("ListOfT.kt")
        public void testListOfT() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/ListOfT.kt");
        }
        
        @TestMetadata("MapOfKString.kt")
        public void testMapOfKString() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/MapOfKString.kt");
        }
        
        @TestMetadata("MapOfStringIntQ.kt")
        public void testMapOfStringIntQ() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/MapOfStringIntQ.kt");
        }
        
        @TestMetadata("QExtendsListString.kt")
        public void testQExtendsListString() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/QExtendsListString.kt");
        }
        
        @TestMetadata("QExtendsString.kt")
        public void testQExtendsString() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/QExtendsString.kt");
        }
        
        @TestMetadata("Vararg.kt")
        public void testVararg() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/Vararg.kt");
        }
        
        @TestMetadata("Void.kt")
        public void testVoid() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/method/Void.kt");
        }
        
        @TestMetadata("compiler/testData/compileJavaAgainstKotlin/method/primitiveOverride")
        public static class PrimitiveOverride extends AbstractCompileJavaAgainstKotlinTest {
            public void testAllFilesPresentInPrimitiveOverride() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/compileJavaAgainstKotlin/method/primitiveOverride"), Pattern.compile("^(.+)\\.kt$"), true);
            }
            
            @TestMetadata("ByteOverridesObject.kt")
            public void testByteOverridesObject() throws Exception {
                doTest("compiler/testData/compileJavaAgainstKotlin/method/primitiveOverride/ByteOverridesObject.kt");
            }
            
            @TestMetadata("CallFinalNotInSubclass.kt")
            public void testCallFinalNotInSubclass() throws Exception {
                doTest("compiler/testData/compileJavaAgainstKotlin/method/primitiveOverride/CallFinalNotInSubclass.kt");
            }
            
            @TestMetadata("CallNotInSubclass.kt")
            public void testCallNotInSubclass() throws Exception {
                doTest("compiler/testData/compileJavaAgainstKotlin/method/primitiveOverride/CallNotInSubclass.kt");
            }
            
            @TestMetadata("CovariantReturnTypeOverride.kt")
            public void testCovariantReturnTypeOverride() throws Exception {
                doTest("compiler/testData/compileJavaAgainstKotlin/method/primitiveOverride/CovariantReturnTypeOverride.kt");
            }
            
            @TestMetadata("FinalOverride.kt")
            public void testFinalOverride() throws Exception {
                doTest("compiler/testData/compileJavaAgainstKotlin/method/primitiveOverride/FinalOverride.kt");
            }
            
            @TestMetadata("IntOverridesComparable.kt")
            public void testIntOverridesComparable() throws Exception {
                doTest("compiler/testData/compileJavaAgainstKotlin/method/primitiveOverride/IntOverridesComparable.kt");
            }
            
            @TestMetadata("IntOverridesNumber.kt")
            public void testIntOverridesNumber() throws Exception {
                doTest("compiler/testData/compileJavaAgainstKotlin/method/primitiveOverride/IntOverridesNumber.kt");
            }
            
            @TestMetadata("IntOverridesObject.kt")
            public void testIntOverridesObject() throws Exception {
                doTest("compiler/testData/compileJavaAgainstKotlin/method/primitiveOverride/IntOverridesObject.kt");
            }
            
            @TestMetadata("ManyClassesHierarchy.kt")
            public void testManyClassesHierarchy() throws Exception {
                doTest("compiler/testData/compileJavaAgainstKotlin/method/primitiveOverride/ManyClassesHierarchy.kt");
            }
            
            @TestMetadata("NullableIntOverridesObject.kt")
            public void testNullableIntOverridesObject() throws Exception {
                doTest("compiler/testData/compileJavaAgainstKotlin/method/primitiveOverride/NullableIntOverridesObject.kt");
            }
            
            @TestMetadata("OverrideInJava.kt")
            public void testOverrideInJava() throws Exception {
                doTest("compiler/testData/compileJavaAgainstKotlin/method/primitiveOverride/OverrideInJava.kt");
            }
            
        }
        
        @TestMetadata("compiler/testData/compileJavaAgainstKotlin/method/throws")
        public static class Throws extends AbstractCompileJavaAgainstKotlinTest {
            public void testAllFilesPresentInThrows() throws Exception {
                JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/compileJavaAgainstKotlin/method/throws"), Pattern.compile("^(.+)\\.kt$"), true);
            }
            
            @TestMetadata("ClassMembers.kt")
            public void testClassMembers() throws Exception {
                doTest("compiler/testData/compileJavaAgainstKotlin/method/throws/ClassMembers.kt");
            }
            
            @TestMetadata("Constructor.kt")
            public void testConstructor() throws Exception {
                doTest("compiler/testData/compileJavaAgainstKotlin/method/throws/Constructor.kt");
            }
            
            @TestMetadata("DefaultArgs.kt")
            public void testDefaultArgs() throws Exception {
                doTest("compiler/testData/compileJavaAgainstKotlin/method/throws/DefaultArgs.kt");
            }
            
            @TestMetadata("Delegation.kt")
            public void testDelegation() throws Exception {
                doTest("compiler/testData/compileJavaAgainstKotlin/method/throws/Delegation.kt");
            }
            
            @TestMetadata("GenericSubstitution.kt")
            public void testGenericSubstitution() throws Exception {
                doTest("compiler/testData/compileJavaAgainstKotlin/method/throws/GenericSubstitution.kt");
            }
            
            @TestMetadata("TopLevel.kt")
            public void testTopLevel() throws Exception {
                doTest("compiler/testData/compileJavaAgainstKotlin/method/throws/TopLevel.kt");
            }
            
            @TestMetadata("TraitMembers.kt")
            public void testTraitMembers() throws Exception {
                doTest("compiler/testData/compileJavaAgainstKotlin/method/throws/TraitMembers.kt");
            }
            
        }
        
        public static Test innerSuite() {
            TestSuite suite = new TestSuite("Method");
            suite.addTestSuite(Method.class);
            suite.addTestSuite(PrimitiveOverride.class);
            suite.addTestSuite(Throws.class);
            return suite;
        }
    }
    
    @TestMetadata("compiler/testData/compileJavaAgainstKotlin/property")
    public static class Property extends AbstractCompileJavaAgainstKotlinTest {
        public void testAllFilesPresentInProperty() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/compileJavaAgainstKotlin/property"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("GenericProperty.kt")
        public void testGenericProperty() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/property/GenericProperty.kt");
        }
        
    }
    
    @TestMetadata("compiler/testData/compileJavaAgainstKotlin/staticFields")
    public static class StaticFields extends AbstractCompileJavaAgainstKotlinTest {
        public void testAllFilesPresentInStaticFields() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/compileJavaAgainstKotlin/staticFields"), Pattern.compile("^(.+)\\.kt$"), true);
        }
        
        @TestMetadata("AnnotationClass.kt")
        public void testAnnotationClass() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/staticFields/AnnotationClass.kt");
        }
        
        @TestMetadata("AnnotationTrait.kt")
        public void testAnnotationTrait() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/staticFields/AnnotationTrait.kt");
        }
        
        @TestMetadata("kt3698.kt")
        public void testKt3698() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/staticFields/kt3698.kt");
        }
        
        @TestMetadata("staticClassProperty.kt")
        public void testStaticClassProperty() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/staticFields/staticClassProperty.kt");
        }
        
        @TestMetadata("staticTraitProperty.kt")
        public void testStaticTraitProperty() throws Exception {
            doTest("compiler/testData/compileJavaAgainstKotlin/staticFields/staticTraitProperty.kt");
        }
        
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite("CompileJavaAgainstKotlinTestGenerated");
        suite.addTestSuite(CompileJavaAgainstKotlinTestGenerated.class);
        suite.addTestSuite(Class.class);
        suite.addTest(Method.innerSuite());
        suite.addTestSuite(Property.class);
        suite.addTestSuite(StaticFields.class);
        return suite;
    }
}
