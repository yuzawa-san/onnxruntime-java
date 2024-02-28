/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$78 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$78() {}

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("CreateArenaCfg"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.ReleaseArenaCfg.class, "apply", constants$14.const$1);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("ReleaseArenaCfg"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.ModelMetadataGetGraphDescription.class, "apply", constants$15.const$0);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("ModelMetadataGetGraphDescription"));
    static final MethodHandle const$5 = RuntimeHelper.upcallHandle(
            OrtApi.SessionOptionsAppendExecutionProvider_TensorRT.class, "apply", constants$15.const$4);
}