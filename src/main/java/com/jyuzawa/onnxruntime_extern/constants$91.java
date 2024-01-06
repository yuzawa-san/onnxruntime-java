/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$91 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$91() {}

    static final MethodHandle const$0 =
            RuntimeHelper.upcallHandle(OrtApi.GetSparseTensorIndicesTypeShape.class, "apply", constants$90.const$5);
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(constants$90.const$5);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetSparseTensorIndicesTypeShape"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.GetSparseTensorIndices.class, "apply", constants$48.const$3);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetSparseTensorIndices"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.HasValue.class, "apply", constants$15.const$2);
}
