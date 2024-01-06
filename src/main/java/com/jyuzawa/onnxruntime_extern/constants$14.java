/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$14 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$14() {}

    static final MethodHandle const$0 =
            RuntimeHelper.upcallHandle(OrtThreadWorkerFn.class, "apply", constants$13.const$5);
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(constants$13.const$5);
    static final StructLayout const$2 =
            MemoryLayout.structLayout(JAVA_BYTE.withName("__place_holder")).withName("OrtCustomHandleType");
    static final VarHandle const$3 =
            constants$14.const$2.varHandle(MemoryLayout.PathElement.groupElement("__place_holder"));
    static final FunctionDescriptor const$4 = FunctionDescriptor.of(
            RuntimeHelper.POINTER, RuntimeHelper.POINTER, RuntimeHelper.POINTER, RuntimeHelper.POINTER);
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtCustomCreateThreadFn.class, "apply", constants$14.const$4);
}
