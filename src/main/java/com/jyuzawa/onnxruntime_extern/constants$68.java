/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$68 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$68() {}

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("AddSessionConfigEntry"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.CreateAllocator.class, "apply", constants$15.const$0);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("CreateAllocator"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.ReleaseAllocator.class, "apply", constants$14.const$1);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("ReleaseAllocator"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.RunWithBinding.class, "apply", constants$15.const$0);
}
