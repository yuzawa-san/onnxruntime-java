/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$0 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$0() {}

    static final StructLayout const$0 = MemoryLayout.structLayout(
                    JAVA_INT.withName("version"),
                    MemoryLayout.paddingLayout(4),
                    RuntimeHelper.POINTER.withName("Alloc"),
                    RuntimeHelper.POINTER.withName("Free"),
                    RuntimeHelper.POINTER.withName("Info"))
            .withName("OrtAllocator");
    static final VarHandle const$1 = constants$0.const$0.varHandle(MemoryLayout.PathElement.groupElement("version"));
    static final FunctionDescriptor const$2 =
            FunctionDescriptor.of(RuntimeHelper.POINTER, RuntimeHelper.POINTER, JAVA_LONG);
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtAllocator.Alloc.class, "apply", constants$0.const$2);
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(constants$0.const$2);
    static final VarHandle const$5 = constants$0.const$0.varHandle(MemoryLayout.PathElement.groupElement("Alloc"));
}
