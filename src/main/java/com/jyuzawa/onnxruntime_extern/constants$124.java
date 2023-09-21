/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$124 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$124() {}

    static final VarHandle const$0 =
            constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("GetVariadicInputMinArity"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetVariadicInputHomogeneity.class, "apply", constants$17.const$1);
    static final VarHandle const$2 =
            constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("GetVariadicInputHomogeneity"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetVariadicOutputMinArity.class, "apply", constants$17.const$1);
    static final VarHandle const$4 =
            constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("GetVariadicOutputMinArity"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetVariadicOutputHomogeneity.class, "apply", constants$17.const$1);
}
