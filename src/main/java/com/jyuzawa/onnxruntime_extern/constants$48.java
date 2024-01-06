/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$48 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$48() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetAllocatorWithDefaultOptions"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.AddFreeDimensionOverride.class, "apply", constants$37.const$5);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("AddFreeDimensionOverride"));
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(
            RuntimeHelper.POINTER, RuntimeHelper.POINTER, JAVA_INT, RuntimeHelper.POINTER, RuntimeHelper.POINTER);
    static final MethodHandle const$4 =
            RuntimeHelper.upcallHandle(OrtApi.GetValue.class, "apply", constants$48.const$3);
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(constants$48.const$3);
}
