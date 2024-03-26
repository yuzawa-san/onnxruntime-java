/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
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

    static final MethodHandle const$0 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetInputType.class, "apply", constants$124.const$5);
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(constants$124.const$5);
    static final VarHandle const$2 =
            constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("GetInputType"));
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(JAVA_LONG, RuntimeHelper.POINTER);
    static final MethodHandle const$4 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetInputTypeCount.class, "apply", constants$125.const$3);
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(constants$125.const$3);
}
