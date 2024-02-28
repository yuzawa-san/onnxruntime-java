/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$32 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$32() {}

    static final MethodHandle const$0 =
            RuntimeHelper.upcallHandle(OrtApi.SessionGetInputName.class, "apply", constants$31.const$5);
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(constants$31.const$5);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("SessionGetInputName"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.SessionGetOutputName.class, "apply", constants$31.const$5);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("SessionGetOutputName"));
    static final MethodHandle const$5 = RuntimeHelper.upcallHandle(
            OrtApi.SessionGetOverridableInitializerName.class, "apply", constants$31.const$5);
}
