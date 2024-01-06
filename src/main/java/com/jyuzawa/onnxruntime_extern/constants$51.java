/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$51 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$51() {}

    static final MethodHandle const$0 =
            RuntimeHelper.upcallHandle(OrtApi.GetOpaqueValue.class, "apply", constants$50.const$5);
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(constants$50.const$5);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetOpaqueValue"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.KernelInfoGetAttribute_float.class, "apply", constants$14.const$4);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("KernelInfoGetAttribute_float"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.KernelInfoGetAttribute_int64.class, "apply", constants$14.const$4);
}
