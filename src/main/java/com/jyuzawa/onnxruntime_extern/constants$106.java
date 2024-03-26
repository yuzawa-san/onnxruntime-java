/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$106 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$106() {}

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("KernelInfo_GetInputCount"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.KernelInfo_GetOutputCount.class, "apply", constants$15.const$4);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("KernelInfo_GetOutputCount"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.KernelInfo_GetInputName.class, "apply", constants$31.const$5);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("KernelInfo_GetInputName"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.KernelInfo_GetOutputName.class, "apply", constants$31.const$5);
}
