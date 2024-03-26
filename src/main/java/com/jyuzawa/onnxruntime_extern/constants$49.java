/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$49 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$49() {}

    static final MethodHandle const$0 =
            RuntimeHelper.upcallHandle(OrtApi.GetValue.class, "apply", constants$48.const$5);
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(constants$48.const$5);
    static final VarHandle const$2 = constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("GetValue"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.GetValueCount.class, "apply", constants$15.const$4);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("GetValueCount"));
    static final FunctionDescriptor const$5 = FunctionDescriptor.of(
            RuntimeHelper.POINTER, RuntimeHelper.POINTER, JAVA_LONG, JAVA_INT, RuntimeHelper.POINTER);
}
