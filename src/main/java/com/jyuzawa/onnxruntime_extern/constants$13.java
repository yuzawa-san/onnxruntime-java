/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
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

    static final FunctionDescriptor const$0 = FunctionDescriptor.of(RuntimeHelper.POINTER);
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApiBase.GetVersionString.class, "apply", constants$13.const$0);
    static final MethodHandle const$2 = RuntimeHelper.downcallHandle(constants$13.const$0);
    static final VarHandle const$3 =
            constants$12.const$1.varHandle(MemoryLayout.PathElement.groupElement("GetVersionString"));
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle("OrtGetApiBase", constants$13.const$0);
    static final FunctionDescriptor const$5 = FunctionDescriptor.ofVoid(RuntimeHelper.POINTER);
}
