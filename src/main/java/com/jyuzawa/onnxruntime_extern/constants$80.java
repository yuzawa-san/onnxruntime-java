/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$80 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$80() {}

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("KernelInfoGetAttributeArray_float"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.KernelInfoGetAttributeArray_int64.class, "apply", constants$20.const$3);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("KernelInfoGetAttributeArray_int64"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.CreateArenaCfgV2.class, "apply", constants$72.const$3);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("CreateArenaCfgV2"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.AddRunConfigEntry.class, "apply", constants$15.const$0);
}
