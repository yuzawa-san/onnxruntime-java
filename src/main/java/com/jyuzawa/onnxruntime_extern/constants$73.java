/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$73 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$73() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("CreateAndRegisterAllocator"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.SetLanguageProjection.class, "apply", constants$23.const$1);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("SetLanguageProjection"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.SessionGetProfilingStartTimeNs.class, "apply", constants$15.const$2);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("SessionGetProfilingStartTimeNs"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.SetGlobalIntraOpNumThreads.class, "apply", constants$23.const$1);
}
