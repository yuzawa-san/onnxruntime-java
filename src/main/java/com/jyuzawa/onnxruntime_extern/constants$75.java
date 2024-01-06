/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$75 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$75() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("AddInitializer"));
    static final FunctionDescriptor const$1 = FunctionDescriptor.of(
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            JAVA_INT,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER);
    static final MethodHandle const$2 = RuntimeHelper.upcallHandle(
            OrtApi.CreateEnvWithCustomLoggerAndGlobalThreadPools.class, "apply", constants$75.const$1);
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(constants$75.const$1);
    static final VarHandle const$4 = constants$16.const$2.varHandle(
            MemoryLayout.PathElement.groupElement("CreateEnvWithCustomLoggerAndGlobalThreadPools"));
    static final MethodHandle const$5 = RuntimeHelper.upcallHandle(
            OrtApi.SessionOptionsAppendExecutionProvider_CUDA.class, "apply", constants$15.const$2);
}
