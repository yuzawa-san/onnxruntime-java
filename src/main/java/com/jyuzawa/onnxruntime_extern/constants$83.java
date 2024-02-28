/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$83 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$83() {}

    static final VarHandle const$0 = constants$16.const$4.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_TensorRT_V2"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.CreateTensorRTProviderOptions.class, "apply", constants$1.const$4);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("CreateTensorRTProviderOptions"));
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(
            RuntimeHelper.POINTER, RuntimeHelper.POINTER, RuntimeHelper.POINTER, RuntimeHelper.POINTER, JAVA_LONG);
    static final MethodHandle const$4 =
            RuntimeHelper.upcallHandle(OrtApi.UpdateTensorRTProviderOptions.class, "apply", constants$83.const$3);
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(constants$83.const$3);
}
