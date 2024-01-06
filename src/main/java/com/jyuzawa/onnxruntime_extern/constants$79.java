/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$79 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$79() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("SetCurrentGpuDeviceId"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.GetCurrentGpuDeviceId.class, "apply", constants$1.const$4);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetCurrentGpuDeviceId"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.KernelInfoGetAttributeArray_float.class, "apply", constants$20.const$1);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("KernelInfoGetAttributeArray_float"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.KernelInfoGetAttributeArray_int64.class, "apply", constants$20.const$1);
}
