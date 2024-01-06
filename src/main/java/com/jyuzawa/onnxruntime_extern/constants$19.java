/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$19 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$19() {}

    static final MethodHandle const$0 =
            RuntimeHelper.upcallHandle(OrtApi.CreateEnvWithCustomLogger.class, "apply", constants$18.const$5);
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(constants$18.const$5);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("CreateEnvWithCustomLogger"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.EnableTelemetryEvents.class, "apply", constants$1.const$4);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("EnableTelemetryEvents"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.DisableTelemetryEvents.class, "apply", constants$1.const$4);
}
