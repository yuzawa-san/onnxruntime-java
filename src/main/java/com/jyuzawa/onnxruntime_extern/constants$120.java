/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$120 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$120() {}

    static final VarHandle const$0 = constants$16.const$4.varHandle(
            MemoryLayout.PathElement.groupElement("ShapeInferContext_GetInputTypeShape"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.ShapeInferContext_GetAttribute.class, "apply", constants$15.const$0);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("ShapeInferContext_GetAttribute"));
    static final MethodHandle const$3 = RuntimeHelper.upcallHandle(
            OrtApi.ShapeInferContext_SetOutputTypeShape.class, "apply", constants$30.const$3);
    static final VarHandle const$4 = constants$16.const$4.varHandle(
            MemoryLayout.PathElement.groupElement("ShapeInferContext_SetOutputTypeShape"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.SetSymbolicDimensions.class, "apply", constants$38.const$1);
}
