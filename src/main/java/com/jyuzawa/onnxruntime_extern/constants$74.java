/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$74 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$74() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("SetGlobalIntraOpNumThreads"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.SetGlobalInterOpNumThreads.class, "apply", constants$23.const$1);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("SetGlobalInterOpNumThreads"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.SetGlobalSpinControl.class, "apply", constants$23.const$1);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("SetGlobalSpinControl"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.AddInitializer.class, "apply", constants$14.const$4);
}
