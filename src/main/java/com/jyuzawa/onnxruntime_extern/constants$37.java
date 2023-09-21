/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$37 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$37() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("CreateTensorWithDataAsOrtValue"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.IsTensor.class, "apply", constants$15.const$2);
    static final VarHandle const$2 = constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("IsTensor"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.GetTensorMutableData.class, "apply", constants$15.const$2);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetTensorMutableData"));
    static final FunctionDescriptor const$5 =
            FunctionDescriptor.of(RuntimeHelper.POINTER, RuntimeHelper.POINTER, RuntimeHelper.POINTER, JAVA_LONG);
}
