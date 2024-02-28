/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$127 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$127() {}

    static final VarHandle const$0 =
            constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("KernelCompute"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtCustomOp.KernelDestroy.class, "apply", constants$14.const$1);
    static final VarHandle const$2 =
            constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("KernelDestroy"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetInputCharacteristic.class, "apply", constants$124.const$5);
    static final VarHandle const$4 =
            constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("GetInputCharacteristic"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetOutputCharacteristic.class, "apply", constants$124.const$5);
}
