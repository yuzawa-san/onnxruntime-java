/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$122 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$122() {}

    static final VarHandle const$0 =
            constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("GetOutputTypeCount"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtCustomOp.KernelCompute.class, "apply", constants$1.const$0);
    static final VarHandle const$2 =
            constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("KernelCompute"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtCustomOp.KernelDestroy.class, "apply", constants$13.const$5);
    static final VarHandle const$4 =
            constants$118.const$5.varHandle(MemoryLayout.PathElement.groupElement("KernelDestroy"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetInputCharacteristic.class, "apply", constants$120.const$1);
}
