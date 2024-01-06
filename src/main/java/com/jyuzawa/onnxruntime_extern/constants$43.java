/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$43 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$43() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetTensorTypeAndShape"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.GetTypeInfo.class, "apply", constants$15.const$2);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetTypeInfo"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.GetValueType.class, "apply", constants$15.const$2);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetValueType"));
    static final FunctionDescriptor const$5 = FunctionDescriptor.of(
            RuntimeHelper.POINTER, RuntimeHelper.POINTER, JAVA_INT, JAVA_INT, JAVA_INT, RuntimeHelper.POINTER);
}
