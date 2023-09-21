/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
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

    static final VarHandle const$0 = constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("version"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtCustomOp.CreateKernel.class, "apply", constants$14.const$4);
    static final VarHandle const$2 =
            constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("CreateKernel"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetName.class, "apply", constants$1.const$4);
    static final VarHandle const$4 = constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("GetName"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetExecutionProviderType.class, "apply", constants$1.const$4);
}
