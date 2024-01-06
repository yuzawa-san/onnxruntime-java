/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$38 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$38() {}

    static final MethodHandle const$0 =
            RuntimeHelper.upcallHandle(OrtApi.FillStringTensor.class, "apply", constants$37.const$5);
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(constants$37.const$5);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("FillStringTensor"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.GetStringTensorDataLength.class, "apply", constants$15.const$2);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetStringTensorDataLength"));
    static final FunctionDescriptor const$5 = FunctionDescriptor.of(
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            JAVA_LONG,
            RuntimeHelper.POINTER,
            JAVA_LONG);
}
