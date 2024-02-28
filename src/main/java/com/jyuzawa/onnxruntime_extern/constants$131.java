/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$131 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$131() {}

    static final VarHandle const$0 =
            constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("GetStartVersion"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetEndVersion.class, "apply", constants$17.const$3);
    static final VarHandle const$2 =
            constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("GetEndVersion"));
    static final MethodHandle const$3 =
            RuntimeHelper.downcallHandle("OrtSessionOptionsAppendExecutionProvider_CUDA", constants$23.const$3);
    static final MethodHandle const$4 =
            RuntimeHelper.downcallHandle("OrtSessionOptionsAppendExecutionProvider_ROCM", constants$23.const$3);
    static final MethodHandle const$5 =
            RuntimeHelper.downcallHandle("OrtSessionOptionsAppendExecutionProvider_MIGraphX", constants$23.const$3);
}
