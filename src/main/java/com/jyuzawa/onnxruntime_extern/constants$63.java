/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$63 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$63() {}

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("ModelMetadataGetVersion"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.ReleaseModelMetadata.class, "apply", constants$14.const$1);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("ReleaseModelMetadata"));
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(
            RuntimeHelper.POINTER, JAVA_INT, RuntimeHelper.POINTER, RuntimeHelper.POINTER, RuntimeHelper.POINTER);
    static final MethodHandle const$4 =
            RuntimeHelper.upcallHandle(OrtApi.CreateEnvWithGlobalThreadPools.class, "apply", constants$63.const$3);
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(constants$63.const$3);
}
