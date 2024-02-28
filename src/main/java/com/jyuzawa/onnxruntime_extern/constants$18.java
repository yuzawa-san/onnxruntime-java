/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$18 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$18() {}

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("GetErrorCode"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.GetErrorMessage.class, "apply", constants$1.const$4);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("GetErrorMessage"));
    static final FunctionDescriptor const$3 =
            FunctionDescriptor.of(RuntimeHelper.POINTER, JAVA_INT, RuntimeHelper.POINTER, RuntimeHelper.POINTER);
    static final MethodHandle const$4 =
            RuntimeHelper.upcallHandle(OrtApi.CreateEnv.class, "apply", constants$18.const$3);
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(constants$18.const$3);
}
