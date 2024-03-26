/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$44 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$44() {}

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("GetValueType"));
    static final FunctionDescriptor const$1 = FunctionDescriptor.of(
            RuntimeHelper.POINTER, RuntimeHelper.POINTER, JAVA_INT, JAVA_INT, JAVA_INT, RuntimeHelper.POINTER);
    static final MethodHandle const$2 =
            RuntimeHelper.upcallHandle(OrtApi.CreateMemoryInfo.class, "apply", constants$44.const$1);
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(constants$44.const$1);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("CreateMemoryInfo"));
    static final FunctionDescriptor const$5 =
            FunctionDescriptor.of(RuntimeHelper.POINTER, JAVA_INT, JAVA_INT, RuntimeHelper.POINTER);
}
