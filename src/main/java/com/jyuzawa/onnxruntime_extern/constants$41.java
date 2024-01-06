/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$41 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$41() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("SetDimensions"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.GetTensorElementType.class, "apply", constants$15.const$2);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetTensorElementType"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.GetDimensionsCount.class, "apply", constants$15.const$2);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetDimensionsCount"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.GetDimensions.class, "apply", constants$37.const$5);
}
