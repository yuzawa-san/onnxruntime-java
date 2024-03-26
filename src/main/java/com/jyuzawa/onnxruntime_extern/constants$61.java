/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$61 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$61() {}

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("SessionGetModelMetadata"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.ModelMetadataGetProducerName.class, "apply", constants$15.const$0);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("ModelMetadataGetProducerName"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.ModelMetadataGetGraphName.class, "apply", constants$15.const$0);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("ModelMetadataGetGraphName"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.ModelMetadataGetDomain.class, "apply", constants$15.const$0);
}
