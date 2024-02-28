/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$30 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$30() {}

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("SessionGetOutputCount"));
    static final MethodHandle const$1 = RuntimeHelper.upcallHandle(
            OrtApi.SessionGetOverridableInitializerCount.class, "apply", constants$15.const$4);
    static final VarHandle const$2 = constants$16.const$4.varHandle(
            MemoryLayout.PathElement.groupElement("SessionGetOverridableInitializerCount"));
    static final FunctionDescriptor const$3 =
            FunctionDescriptor.of(RuntimeHelper.POINTER, RuntimeHelper.POINTER, JAVA_LONG, RuntimeHelper.POINTER);
    static final MethodHandle const$4 =
            RuntimeHelper.upcallHandle(OrtApi.SessionGetInputTypeInfo.class, "apply", constants$30.const$3);
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(constants$30.const$3);
}
