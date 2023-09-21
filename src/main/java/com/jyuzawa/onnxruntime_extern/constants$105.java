/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$105 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$105() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("RegisterCustomOpsLibrary_V2"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.RegisterCustomOpsUsingFunction.class, "apply", constants$15.const$2);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("RegisterCustomOpsUsingFunction"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.KernelInfo_GetInputCount.class, "apply", constants$15.const$2);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("KernelInfo_GetInputCount"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.KernelInfo_GetOutputCount.class, "apply", constants$15.const$2);
}
