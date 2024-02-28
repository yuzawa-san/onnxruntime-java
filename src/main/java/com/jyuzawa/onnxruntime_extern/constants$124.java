/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
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
            constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("CreateKernel"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetName.class, "apply", constants$1.const$4);
    static final VarHandle const$2 = constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("GetName"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtCustomOp.GetExecutionProviderType.class, "apply", constants$1.const$4);
    static final VarHandle const$4 =
            constants$123.const$3.varHandle(MemoryLayout.PathElement.groupElement("GetExecutionProviderType"));
    static final FunctionDescriptor const$5 = FunctionDescriptor.of(JAVA_INT, RuntimeHelper.POINTER, JAVA_LONG);
}
