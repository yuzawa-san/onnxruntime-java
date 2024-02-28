/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$96 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$96() {}

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("SynchronizeBoundOutputs"));
    static final MethodHandle const$1 = RuntimeHelper.upcallHandle(
            OrtApi.SessionOptionsAppendExecutionProvider_CUDA_V2.class, "apply", constants$15.const$4);
    static final VarHandle const$2 = constants$16.const$4.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_CUDA_V2"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.CreateCUDAProviderOptions.class, "apply", constants$1.const$4);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("CreateCUDAProviderOptions"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.UpdateCUDAProviderOptions.class, "apply", constants$83.const$3);
}
