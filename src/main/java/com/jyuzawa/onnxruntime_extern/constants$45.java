/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$45 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$45() {}

    static final MethodHandle const$0 =
            RuntimeHelper.upcallHandle(OrtApi.CreateCpuMemoryInfo.class, "apply", constants$44.const$5);
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(constants$44.const$5);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("CreateCpuMemoryInfo"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.CompareMemoryInfo.class, "apply", constants$15.const$0);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("CompareMemoryInfo"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.MemoryInfoGetName.class, "apply", constants$15.const$4);
}
