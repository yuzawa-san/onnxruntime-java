/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$91 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$91() {}

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("GetSparseTensorValues"));
    static final FunctionDescriptor const$1 =
            FunctionDescriptor.of(RuntimeHelper.POINTER, RuntimeHelper.POINTER, JAVA_INT, RuntimeHelper.POINTER);
    static final MethodHandle const$2 =
            RuntimeHelper.upcallHandle(OrtApi.GetSparseTensorIndicesTypeShape.class, "apply", constants$91.const$1);
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(constants$91.const$1);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("GetSparseTensorIndicesTypeShape"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.GetSparseTensorIndices.class, "apply", constants$48.const$5);
}
