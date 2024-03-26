/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$1 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$1() {}

    static final FunctionDescriptor const$0 = FunctionDescriptor.ofVoid(RuntimeHelper.POINTER, RuntimeHelper.POINTER);
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtAllocator.Free.class, "apply", constants$1.const$0);
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(constants$1.const$0);
    static final VarHandle const$3 = constants$0.const$0.varHandle(MemoryLayout.PathElement.groupElement("Free"));
    static final FunctionDescriptor const$4 = FunctionDescriptor.of(RuntimeHelper.POINTER, RuntimeHelper.POINTER);
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtAllocator.Info.class, "apply", constants$1.const$4);
}
