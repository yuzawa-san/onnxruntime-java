/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$77 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$77() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("SetGlobalDenormalAsZero"));
    static final FunctionDescriptor const$1 = FunctionDescriptor.of(
            RuntimeHelper.POINTER, JAVA_LONG, JAVA_INT, JAVA_INT, JAVA_INT, RuntimeHelper.POINTER);
    static final MethodHandle const$2 =
            RuntimeHelper.upcallHandle(OrtApi.CreateArenaCfg.class, "apply", constants$77.const$1);
    static final MethodHandle const$3 = RuntimeHelper.downcallHandle(constants$77.const$1);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("CreateArenaCfg"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.ReleaseArenaCfg.class, "apply", constants$13.const$5);
}
