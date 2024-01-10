/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$66 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$66() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("ReleaseAvailableProviders"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.GetStringTensorElementLength.class, "apply", constants$30.const$1);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetStringTensorElementLength"));
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(
            RuntimeHelper.POINTER, RuntimeHelper.POINTER, JAVA_LONG, JAVA_LONG, RuntimeHelper.POINTER);
    static final MethodHandle const$4 =
            RuntimeHelper.upcallHandle(OrtApi.GetStringTensorElement.class, "apply", constants$66.const$3);
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(constants$66.const$3);
}