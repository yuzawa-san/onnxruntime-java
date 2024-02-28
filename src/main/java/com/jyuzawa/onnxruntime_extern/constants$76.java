/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$76 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$76() {}

    static final VarHandle const$0 = constants$16.const$4.varHandle(
            MemoryLayout.PathElement.groupElement("CreateEnvWithCustomLoggerAndGlobalThreadPools"));
    static final MethodHandle const$1 = RuntimeHelper.upcallHandle(
            OrtApi.SessionOptionsAppendExecutionProvider_CUDA.class, "apply", constants$15.const$4);
    static final VarHandle const$2 = constants$16.const$4.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_CUDA"));
    static final MethodHandle const$3 = RuntimeHelper.upcallHandle(
            OrtApi.SessionOptionsAppendExecutionProvider_ROCM.class, "apply", constants$15.const$4);
    static final VarHandle const$4 = constants$16.const$4.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_ROCM"));
    static final MethodHandle const$5 = RuntimeHelper.upcallHandle(
            OrtApi.SessionOptionsAppendExecutionProvider_OpenVINO.class, "apply", constants$15.const$4);
}
