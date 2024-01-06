/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$87 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$87() {}

    static final MethodHandle const$0 =
            RuntimeHelper.upcallHandle(OrtApi.FillSparseTensorCsr.class, "apply", constants$86.const$5);
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(constants$86.const$5);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("FillSparseTensorCsr"));
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            JAVA_LONG,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            JAVA_LONG,
            RuntimeHelper.POINTER);
    static final MethodHandle const$4 =
            RuntimeHelper.upcallHandle(OrtApi.FillSparseTensorBlockSparse.class, "apply", constants$87.const$3);
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(constants$87.const$3);
}
