/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$110 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$110() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("ReleaseDnnlProviderOptions"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.KernelInfo_GetNodeName.class, "apply", constants$14.const$4);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("KernelInfo_GetNodeName"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.KernelInfo_GetLogger.class, "apply", constants$15.const$2);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("KernelInfo_GetLogger"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.KernelContext_GetLogger.class, "apply", constants$15.const$2);
}
