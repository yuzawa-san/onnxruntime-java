/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$101 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$101() {}

    static final VarHandle const$0 = constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("ReleaseOp"));
    static final MethodHandle const$1 = RuntimeHelper.upcallHandle(
            OrtApi.SessionOptionsAppendExecutionProvider.class, "apply", constants$51.const$1);
    static final VarHandle const$2 = constants$16.const$4.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.CopyKernelInfo.class, "apply", constants$15.const$4);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("CopyKernelInfo"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.ReleaseKernelInfo.class, "apply", constants$14.const$1);
}
