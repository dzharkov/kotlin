/*
 * Copyright 2010-2016 JetBrains s.r.o.
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

package org.jetbrains.kotlin.kapt3.diagnostic

import org.jetbrains.kotlin.diagnostics.rendering.DefaultErrorMessages
import org.jetbrains.kotlin.diagnostics.rendering.DiagnosticFactoryToRendererMap

class DefaultErrorMessagesKapt3 : DefaultErrorMessages.Extension {

    private companion object {
        val MAP = DiagnosticFactoryToRendererMap("AnnotationProcessing")

        init {
            MAP.put(ErrorsKapt3.KAPT3_PROCESSING_ERROR,
                    "Some error(s) occurred while processing annotations. Please see the error messages above.")
        }
    }

    override fun getMap() = MAP
}