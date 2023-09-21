/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$82 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$82() {}

    static final MethodHandle const$0 = RuntimeHelper.upcallHandle(
            OrtApi.CreateSessionFromArrayWithPrepackedWeightsContainer.class, "apply", constants$81.const$5);
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(constants$81.const$5);
    static final VarHandle const$2 = constants$16.const$2.varHandle(
            MemoryLayout.PathElement.groupElement("CreateSessionFromArrayWithPrepackedWeightsContainer"));
    static final MethodHandle const$3 = RuntimeHelper.upcallHandle(
            OrtApi.SessionOptionsAppendExecutionProvider_TensorRT_V2.class, "apply", constants$15.const$2);
    static final VarHandle const$4 = constants$16.const$2.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_TensorRT_V2"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.CreateTensorRTProviderOptions.class, "apply", constants$1.const$4);
}
