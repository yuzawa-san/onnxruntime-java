/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$12 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$12() {}

    static final VarHandle const$0 = constants$11.const$0.varHandle(MemoryLayout.PathElement.groupElement("context"));
    static final VarHandle const$1 =
            constants$11.const$0.varHandle(MemoryLayout.PathElement.groupElement("enable_opencl_throttling"));
    static final VarHandle const$2 =
            constants$11.const$0.varHandle(MemoryLayout.PathElement.groupElement("enable_dynamic_shapes"));
    static final StructLayout const$3 = MemoryLayout.structLayout(
                    RuntimeHelper.POINTER.withName("GetApi"), RuntimeHelper.POINTER.withName("GetVersionString"))
            .withName("OrtApiBase");
    static final FunctionDescriptor const$4 = FunctionDescriptor.of(RuntimeHelper.POINTER, JAVA_INT);
    static final MethodHandle const$5 =
            RuntimeHelper.upcallHandle(OrtApiBase.GetApi.class, "apply", constants$12.const$4);
}
