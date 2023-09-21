/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$39 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$39() {}

    static final MethodHandle const$0 =
            RuntimeHelper.upcallHandle(OrtApi.GetStringTensorContent.class, "apply", constants$38.const$5);
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(constants$38.const$5);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetStringTensorContent"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.CastTypeInfoToTensorInfo.class, "apply", constants$15.const$2);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("CastTypeInfoToTensorInfo"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.GetOnnxTypeFromTypeInfo.class, "apply", constants$15.const$2);
}
