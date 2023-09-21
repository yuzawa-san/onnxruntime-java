/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$81 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$81() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("CreatePrepackedWeightsContainer"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.ReleasePrepackedWeightsContainer.class, "apply", constants$13.const$5);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("ReleasePrepackedWeightsContainer"));
    static final MethodHandle const$3 = RuntimeHelper.upcallHandle(
            OrtApi.CreateSessionWithPrepackedWeightsContainer.class, "apply", constants$70.const$3);
    static final VarHandle const$4 = constants$16.const$2.varHandle(
            MemoryLayout.PathElement.groupElement("CreateSessionWithPrepackedWeightsContainer"));
    static final FunctionDescriptor const$5 = FunctionDescriptor.of(
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            JAVA_LONG,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER);
}
