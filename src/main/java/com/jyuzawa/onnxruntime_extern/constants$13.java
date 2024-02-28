/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$13 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$13() {}

    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(constants$12.const$4);
    static final VarHandle const$1 = constants$12.const$3.varHandle(MemoryLayout.PathElement.groupElement("GetApi"));
    static final FunctionDescriptor const$2 = FunctionDescriptor.of(RuntimeHelper.POINTER);
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApiBase.GetVersionString.class, "apply", constants$13.const$2);
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(constants$13.const$2);
    static final VarHandle const$5 =
            constants$12.const$3.varHandle(MemoryLayout.PathElement.groupElement("GetVersionString"));
}
