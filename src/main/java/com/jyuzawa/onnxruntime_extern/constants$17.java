/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$17 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$17() {}

    static final MethodHandle const$0 =
            RuntimeHelper.upcallHandle(OrtApi.CreateStatus.class, "apply", constants$16.const$5);
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(constants$16.const$5);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("CreateStatus"));
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(JAVA_INT, RuntimeHelper.POINTER);
    static final MethodHandle const$4 =
            RuntimeHelper.upcallHandle(OrtApi.GetErrorCode.class, "apply", constants$17.const$3);
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(constants$17.const$3);
}
