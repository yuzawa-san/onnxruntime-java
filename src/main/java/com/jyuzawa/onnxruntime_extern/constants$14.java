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

    static final MethodHandle const$0 = RuntimeHelper.downcallHandle("OrtGetApiBase", constants$13.const$2);
    static final FunctionDescriptor const$1 = FunctionDescriptor.ofVoid(RuntimeHelper.POINTER);
    static final MethodHandle const$2 =
            RuntimeHelper.upcallHandle(OrtThreadWorkerFn.class, "apply", constants$14.const$1);
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(constants$14.const$1);
    static final StructLayout const$4 =
            MemoryLayout.structLayout(JAVA_BYTE.withName("__place_holder")).withName("OrtCustomHandleType");
    static final VarHandle const$5 =
            constants$14.const$4.varHandle(MemoryLayout.PathElement.groupElement("__place_holder"));
}
