/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$121 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$121() {}

    static final MethodHandle const$0 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetInputTypeCount.class, "apply", constants$120.const$5);
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(constants$120.const$5);
    static final VarHandle const$2 =
            constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("GetInputTypeCount"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetOutputType.class, "apply", constants$120.const$1);
    static final VarHandle const$4 =
            constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("GetOutputType"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetOutputTypeCount.class, "apply", constants$120.const$5);
}
