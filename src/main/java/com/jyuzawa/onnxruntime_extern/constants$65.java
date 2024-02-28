/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$65 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$65() {}

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("ReleaseThreadingOptions"));
    static final MethodHandle const$1 = RuntimeHelper.upcallHandle(
            OrtApi.ModelMetadataGetCustomMetadataMapKeys.class, "apply", constants$20.const$3);
    static final VarHandle const$2 = constants$16.const$4.varHandle(
            MemoryLayout.PathElement.groupElement("ModelMetadataGetCustomMetadataMapKeys"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.AddFreeDimensionOverrideByName.class, "apply", constants$38.const$1);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("AddFreeDimensionOverrideByName"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.GetAvailableProviders.class, "apply", constants$15.const$4);
}
