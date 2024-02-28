/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$100 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$100() {}

    static final VarHandle const$0 = constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("CreateOp"));
    static final FunctionDescriptor const$1 = FunctionDescriptor.of(
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            JAVA_INT,
            RuntimeHelper.POINTER,
            JAVA_INT);
    static final MethodHandle const$2 =
            RuntimeHelper.upcallHandle(OrtApi.InvokeOp.class, "apply", constants$100.const$1);
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(constants$100.const$1);
    static final VarHandle const$4 = constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("InvokeOp"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.ReleaseOp.class, "apply", constants$14.const$1);
}
