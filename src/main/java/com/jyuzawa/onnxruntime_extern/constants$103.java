/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$103 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$103() {}

    static final VarHandle const$0 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("CreateCANNProviderOptions"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.UpdateCANNProviderOptions.class, "apply", constants$83.const$3);
    static final VarHandle const$2 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("UpdateCANNProviderOptions"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.GetCANNProviderOptionsAsString.class, "apply", constants$15.const$0);
    static final VarHandle const$4 =
            constants$16.const$4.varHandle(MemoryLayout.PathElement.groupElement("GetCANNProviderOptionsAsString"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.ReleaseCANNProviderOptions.class, "apply", constants$14.const$1);
}
