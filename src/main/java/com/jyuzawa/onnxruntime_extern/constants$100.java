/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$100 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$100() {}

    static final MethodHandle const$0 =
            RuntimeHelper.upcallHandle(OrtApi.InvokeOp.class, "apply", constants$99.const$5);
    static final MethodHandle const$1 = RuntimeHelper.downcallHandle(constants$99.const$5);
    static final VarHandle const$2 = constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("InvokeOp"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.ReleaseOp.class, "apply", constants$13.const$5);
    static final VarHandle const$4 = constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("ReleaseOp"));
    static final MethodHandle const$5 = RuntimeHelper.upcallHandle(
            OrtApi.SessionOptionsAppendExecutionProvider.class, "apply", constants$50.const$5);
}
