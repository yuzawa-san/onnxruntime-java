/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$129 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$129() {}

    static final VarHandle const$0 =
            constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("GetVariadicInputHomogeneity"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetVariadicOutputMinArity.class, "apply", constants$17.const$3);
    static final VarHandle const$2 =
            constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("GetVariadicOutputMinArity"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetVariadicOutputHomogeneity.class, "apply", constants$17.const$3);
    static final VarHandle const$4 =
            constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("GetVariadicOutputHomogeneity"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtCustomOp.CreateKernelV2.class, "apply", constants$20.const$3);
}
