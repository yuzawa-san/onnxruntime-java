/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$108 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$108() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("HasSessionConfigEntry"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.GetSessionConfigEntry.class, "apply", constants$20.const$1);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetSessionConfigEntry"));
    static final MethodHandle const$3 = RuntimeHelper.upcallHandle(
            OrtApi.SessionOptionsAppendExecutionProvider_Dnnl.class, "apply", constants$15.const$2);
    static final VarHandle const$4 = constants$16.const$2.varHandle(
            MemoryLayout.PathElement.groupElement("SessionOptionsAppendExecutionProvider_Dnnl"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.CreateDnnlProviderOptions.class, "apply", constants$1.const$4);
}
