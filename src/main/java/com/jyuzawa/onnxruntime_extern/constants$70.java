/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$70 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$70() {}

    static final VarHandle const$0 = constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("BindInput"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.BindOutput.class, "apply", constants$15.const$0);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("BindOutput"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.BindOutputToDevice.class, "apply", constants$15.const$0);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("BindOutputToDevice"));
    static final FunctionDescriptor const$5 = FunctionDescriptor.of(
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER);
}
