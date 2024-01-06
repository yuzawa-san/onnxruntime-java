/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$94 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$94() {}

    static final VarHandle const$0 = constants$16.const$2.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsSetCustomJoinThreadFn"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.SetGlobalCustomCreateThreadFn.class, "apply", constants$15.const$2);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("SetGlobalCustomCreateThreadFn"));
    static final MethodHandle const$3 = RuntimeHelper.upcallHandle(
            OrtApi.SetGlobalCustomThreadCreationOptions.class, "apply", constants$15.const$2);
    static final VarHandle const$4 = constants$16.const$2.varHandle(
            MemoryLayout.PathElement.groupElement("SetGlobalCustomThreadCreationOptions"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.SetGlobalCustomJoinThreadFn.class, "apply", constants$15.const$2);
}
