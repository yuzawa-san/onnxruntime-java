/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$57 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$57() {}

    static final VarHandle const$0 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("ReleaseSessionOptions"));
    static final MethodHandle const$1 =
            RuntimeHelper.upcallHandle(OrtApi.ReleaseCustomOpDomain.class, "apply", constants$13.const$5);
    static final VarHandle const$2 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("ReleaseCustomOpDomain"));
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtApi.GetDenotationFromTypeInfo.class, "apply", constants$14.const$4);
    static final VarHandle const$4 =
            constants$16.const$2.varHandle(MemoryLayout.PathElement.groupElement("GetDenotationFromTypeInfo"));
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApi.CastTypeInfoToMapTypeInfo.class, "apply", constants$15.const$2);
}
