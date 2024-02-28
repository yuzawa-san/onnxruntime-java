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

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("GetTensorMutableData"));
    static final FunctionDescriptor const$1 =
            FunctionDescriptor.of(RuntimeHelper.POINTER, RuntimeHelper.POINTER, RuntimeHelper.POINTER, JAVA_LONG);
    static final MethodHandle const$2 =
            RuntimeHelper.upcallHandle(OrtApi.FillStringTensor.class, "apply", constants$38.const$1);
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(constants$38.const$1);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("FillStringTensor"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.GetStringTensorDataLength.class, "apply", constants$15.const$4);
}
