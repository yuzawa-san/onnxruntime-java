/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$117 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$117() {}

    static final VarHandle const$0 = constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("RunAsync"));
    static final MethodHandle const$1 = RuntimeHelper.upcallHandle(
            OrtApi.UpdateTensorRTProviderOptionsWithValue.class, "apply", constants$15.const$0);
    static final VarHandle const$2 = constants$16.const$4.varHandle(
            MemoryLayout.PathElement.groupElement("UpdateTensorRTProviderOptionsWithValue"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.GetTensorRTProviderOptionsByName.class, "apply", constants$15.const$0);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("GetTensorRTProviderOptionsByName"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.UpdateCUDAProviderOptionsWithValue.class, "apply", constants$15.const$0);
}