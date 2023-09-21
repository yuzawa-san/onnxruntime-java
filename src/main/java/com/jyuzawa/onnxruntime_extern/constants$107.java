/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$107 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$107() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("KernelInfo_GetInputTypeInfo"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.KernelInfo_GetOutputTypeInfo.class, "apply", constants$30.const$1);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("KernelInfo_GetOutputTypeInfo"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.KernelInfoGetAttribute_tensor.class, "apply", constants$20.const$1);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("KernelInfoGetAttribute_tensor"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.HasSessionConfigEntry.class, "apply", constants$14.const$4);
}
