/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$52 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$52() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("KernelInfoGetAttribute_int64"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.KernelInfoGetAttribute_string.class, "apply", constants$20.const$1);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("KernelInfoGetAttribute_string"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.KernelContext_GetInputCount.class, "apply", constants$15.const$2);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("KernelContext_GetInputCount"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.KernelContext_GetOutputCount.class, "apply", constants$15.const$2);
}
