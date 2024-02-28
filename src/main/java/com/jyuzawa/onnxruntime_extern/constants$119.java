/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$119 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$119() {}

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("KernelContext_GetResource"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.SetUserLoggingFunction.class, "apply", constants$15.const$0);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("SetUserLoggingFunction"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.ShapeInferContext_GetInputCount.class, "apply", constants$15.const$4);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("ShapeInferContext_GetInputCount"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.ShapeInferContext_GetInputTypeShape.class, "apply", constants$30.const$3);
}
