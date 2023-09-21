/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$44 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$44() {}

    static final MethodHandle const$0 =
            RuntimeHelper.upcallHandle(OrtApi.CreateMemoryInfo.class, "apply", constants$43.const$5);
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(constants$43.const$5);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("CreateMemoryInfo"));
    static final FunctionDescriptor const$3 =
            FunctionDescriptor.of(RuntimeHelper.POINTER, JAVA_INT, JAVA_INT, RuntimeHelper.POINTER);
    static final MethodHandle const$4 =
            RuntimeHelper.upcallHandle(OrtApi.CreateCpuMemoryInfo.class, "apply", constants$44.const$3);
    static final MethodHandle const$5 = RuntimeHelper.downcallHandle(constants$44.const$3);
}
