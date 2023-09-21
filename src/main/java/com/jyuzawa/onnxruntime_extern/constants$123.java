/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$123 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$123() {}

    static final VarHandle const$0 =
            constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("GetInputCharacteristic"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetOutputCharacteristic.class, "apply", constants$120.const$1);
    static final VarHandle const$2 =
            constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("GetOutputCharacteristic"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetInputMemoryType.class, "apply", constants$120.const$1);
    static final VarHandle const$4 =
            constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("GetInputMemoryType"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetVariadicInputMinArity.class, "apply", constants$17.const$1);
}
