/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$26 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$26() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("SetSessionLogId"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.SetSessionLogVerbosityLevel.class, "apply", constants$23.const$1);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("SetSessionLogVerbosityLevel"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.SetSessionLogSeverityLevel.class, "apply", constants$23.const$1);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("SetSessionLogSeverityLevel"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.SetSessionGraphOptimizationLevel.class, "apply", constants$23.const$1);
}
