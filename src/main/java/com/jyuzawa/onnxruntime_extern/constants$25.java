/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$25 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$25() {}

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("EnableMemPattern"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.DisableMemPattern.class, "apply", constants$1.const$4);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("DisableMemPattern"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.EnableCpuMemArena.class, "apply", constants$1.const$4);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("EnableCpuMemArena"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.DisableCpuMemArena.class, "apply", constants$1.const$4);
}
