/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
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

    static final MethodHandle const$0 =
            RuntimeHelper.upcallHandle(OrtApi.CreateTensorWithDataAsOrtValue.class, "apply", constants$36.const$5);
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(constants$36.const$5);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("CreateTensorWithDataAsOrtValue"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.IsTensor.class, "apply", constants$15.const$4);
    static final VarHandle const$4 = constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("IsTensor"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.GetTensorMutableData.class, "apply", constants$15.const$4);
}
