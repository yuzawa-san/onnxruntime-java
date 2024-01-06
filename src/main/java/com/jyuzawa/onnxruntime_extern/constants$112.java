/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$112 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$112() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("Logger_GetLoggingSeverityLevel"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.KernelInfoGetConstantInput_tensor.class, "apply", constants$31.const$3);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("KernelInfoGetConstantInput_tensor"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.CastTypeInfoToOptionalTypeInfo.class, "apply", constants$15.const$2);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("CastTypeInfoToOptionalTypeInfo"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.GetOptionalContainedTypeInfo.class, "apply", constants$15.const$2);
}
