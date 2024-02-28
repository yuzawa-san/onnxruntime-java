/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$130 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$130() {}

    static final VarHandle const$0 =
            constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("CreateKernelV2"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtCustomOp.KernelComputeV2.class, "apply", constants$15.const$4);
    static final VarHandle const$2 =
            constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("KernelComputeV2"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtCustomOp.InferOutputShapeFn.class, "apply", constants$15.const$4);
    static final VarHandle const$4 =
            constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("InferOutputShapeFn"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetStartVersion.class, "apply", constants$17.const$3);
}
