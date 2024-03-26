/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$126 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$126() {}

    static final VarHandle const$0 =
            constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("GetInputTypeCount"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetOutputType.class, "apply", constants$124.const$5);
    static final VarHandle const$2 =
            constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("GetOutputType"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetOutputTypeCount.class, "apply", constants$125.const$3);
    static final VarHandle const$4 =
            constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("GetOutputTypeCount"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtCustomOp.KernelCompute.class, "apply", constants$1.const$0);
}
