/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$98 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$98() {}

    static final VarHandle const$0 = constants$16.const$4.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_MIGraphX"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.AddExternalInitializers.class, "apply", constants$83.const$3);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("AddExternalInitializers"));
    static final FunctionDescriptor const$3 = FunctionDescriptor.of(
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            JAVA_INT,
            JAVA_INT,
            RuntimeHelper.POINTER);
    static final MethodHandle const$4 =
            RuntimeHelper.upcallHandle(OrtApi.CreateOpAttr.class, "apply", constants$98.const$3);
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(constants$98.const$3);
}
