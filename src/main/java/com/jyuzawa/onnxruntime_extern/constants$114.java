/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$114 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$114() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetBuildInfoString"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.CreateROCMProviderOptions.class, "apply", constants$1.const$4);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("CreateROCMProviderOptions"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.UpdateROCMProviderOptions.class, "apply", constants$83.const$1);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("UpdateROCMProviderOptions"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.GetROCMProviderOptionsAsString.class, "apply", constants$14.const$4);
}
