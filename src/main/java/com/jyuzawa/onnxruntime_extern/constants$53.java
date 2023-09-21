/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$53 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$53() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("KernelContext_GetOutputCount"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.KernelContext_GetInput.class, "apply", constants$30.const$1);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("KernelContext_GetInput"));
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            JAVA_LONG,
            RuntimeHelper.POINTER,
            JAVA_LONG,
            RuntimeHelper.POINTER);
    static final MethodHandle const$4 =
            RuntimeHelper.upcallHandle(OrtApi.KernelContext_GetOutput.class, "apply", constants$53.const$3);
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(constants$53.const$3);
}
