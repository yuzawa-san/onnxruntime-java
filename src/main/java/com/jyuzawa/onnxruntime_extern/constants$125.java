/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$125 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$125() {}

    static final VarHandle const$0 =
            constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("GetVariadicOutputHomogeneity"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtCustomOp.CreateKernelV2.class, "apply", constants$20.const$1);
    static final VarHandle const$2 =
            constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("CreateKernelV2"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtCustomOp.KernelComputeV2.class, "apply", constants$15.const$2);
    static final VarHandle const$4 =
            constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("KernelComputeV2"));
    static final MethodHandle const$5 =
            RuntimeHelper.downcallHandle("OrtSessionOptionsAppendExecutionProvider_CUDA", constants$23.const$1);
}
