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

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("SetSymbolicDimensions"));
    static final FunctionDescriptor const$1 = FunctionDescriptor.of(
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            JAVA_INT,
            RuntimeHelper.POINTER,
            JAVA_LONG,
            RuntimeHelper.POINTER);
    static final MethodHandle const$2 =
            RuntimeHelper.upcallHandle(OrtApi.ReadOpAttr.class, "apply", constants$121.const$1);
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(constants$121.const$1);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("ReadOpAttr"));
    static final FunctionDescriptor const$5 =
            FunctionDescriptor.of(RuntimeHelper.POINTER, RuntimeHelper.POINTER, JAVA_BOOLEAN);
}
