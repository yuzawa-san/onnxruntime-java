/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$62 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$62() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("ModelMetadataGetDescription"));
    static final MethodHandle const$1 = RuntimeHelper.upcallHandle(
            OrtApi.ModelMetadataLookupCustomMetadataMap.class, "apply", constants$20.const$1);
    static final VarHandle const$2 = constants$16.const$2.varHandle(
            MemoryLayout.PathElement.groupElement("ModelMetadataLookupCustomMetadataMap"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.ModelMetadataGetVersion.class, "apply", constants$15.const$2);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("ModelMetadataGetVersion"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.ReleaseModelMetadata.class, "apply", constants$13.const$5);
}
