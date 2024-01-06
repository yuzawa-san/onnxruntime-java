/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$60 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$60() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("ReleaseSequenceTypeInfo"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.SessionEndProfiling.class, "apply", constants$14.const$4);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("SessionEndProfiling"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.SessionGetModelMetadata.class, "apply", constants$15.const$2);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("SessionGetModelMetadata"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.ModelMetadataGetProducerName.class, "apply", constants$14.const$4);
}
