/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$84 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$84() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetTensorRTProviderOptionsAsString"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.ReleaseTensorRTProviderOptions.class, "apply", constants$13.const$5);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("ReleaseTensorRTProviderOptions"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.EnableOrtCustomOps.class, "apply", constants$1.const$4);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("EnableOrtCustomOps"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.RegisterAllocator.class, "apply", constants$15.const$2);
}
