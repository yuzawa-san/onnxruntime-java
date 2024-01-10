/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$104 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$104() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("MemoryInfoGetDeviceType"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.UpdateEnvWithCustomLogLevel.class, "apply", constants$23.const$1);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("UpdateEnvWithCustomLogLevel"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.SetGlobalIntraOpThreadAffinity.class, "apply", constants$15.const$2);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("SetGlobalIntraOpThreadAffinity"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.RegisterCustomOpsLibrary_V2.class, "apply", constants$15.const$2);
}