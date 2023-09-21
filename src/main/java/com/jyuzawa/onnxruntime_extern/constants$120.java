/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$120 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$120() {}

    static final VarHandle const$0 =
            constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("GetExecutionProviderType"));
    static final FunctionDescriptor const$1 = FunctionDescriptor.of(JAVA_INT, RuntimeHelper.POINTER, JAVA_LONG);
    static final MethodHandle const$2 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetInputType.class, "apply", constants$120.const$1);
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(constants$120.const$1);
    static final VarHandle const$4 =
            constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("GetInputType"));
    static final FunctionDescriptor const$5 = FunctionDescriptor.of(JAVA_LONG, RuntimeHelper.POINTER);
}
