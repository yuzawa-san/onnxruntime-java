/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$88 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$88() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("FillSparseTensorBlockSparse"));
    static final FunctionDescriptor const$1 = FunctionDescriptor.of(
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            JAVA_LONG,
            RuntimeHelper.POINTER,
            JAVA_LONG,
            JAVA_INT,
            RuntimeHelper.POINTER);
    static final MethodHandle const$2 = RuntimeHelper.upcallHandle(
            OrtApi.CreateSparseTensorWithValuesAsOrtValue.class, "apply", constants$88.const$1);
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(constants$88.const$1);
    static final VarHandle const$4 = constants$16.const$2.varHandle(
            MemoryLayout.PathElement.groupElement("CreateSparseTensorWithValuesAsOrtValue"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.UseCooIndices.class, "apply", constants$37.const$5);
}
