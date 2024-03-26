/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$86 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$86() {}

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("IsSparseTensor"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.CreateSparseTensorAsOrtValue.class, "apply", constants$36.const$1);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("CreateSparseTensorAsOrtValue"));
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            JAVA_LONG,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            JAVA_LONG);
    static final MethodHandle const$4 =
            RuntimeHelper.upcallHandle(OrtApi.FillSparseTensorCoo.class, "apply", constants$86.const$3);
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(constants$86.const$3);
}
