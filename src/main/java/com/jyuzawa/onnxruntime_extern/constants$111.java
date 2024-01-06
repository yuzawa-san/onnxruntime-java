/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$111 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$111() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("KernelContext_GetLogger"));
    static final FunctionDescriptor const$1 = FunctionDescriptor.of(
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            JAVA_INT,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            JAVA_INT,
            RuntimeHelper.POINTER);
    static final MethodHandle const$2 =
            RuntimeHelper.upcallHandle(OrtApi.Logger_LogMessage.class, "apply", constants$111.const$1);
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(constants$111.const$1);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("Logger_LogMessage"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.Logger_GetLoggingSeverityLevel.class, "apply", constants$15.const$2);
}
