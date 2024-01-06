/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$90 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$90() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetSparseTensorFormat"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.GetSparseTensorValuesTypeAndShape.class, "apply", constants$15.const$2);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetSparseTensorValuesTypeAndShape"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.GetSparseTensorValues.class, "apply", constants$15.const$2);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetSparseTensorValues"));
    static final FunctionDescriptor const$5 =
            FunctionDescriptor.of(RuntimeHelper.POINTER, RuntimeHelper.POINTER, JAVA_INT, RuntimeHelper.POINTER);
}
