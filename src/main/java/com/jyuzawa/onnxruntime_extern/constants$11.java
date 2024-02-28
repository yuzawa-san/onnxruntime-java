/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

final class constants$11 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$11() {}

    static final StructLayout const$0 = MemoryLayout.structLayout(
                    RuntimeHelper.POINTER.withName("device_type"),
                    JAVA_BYTE.withName("enable_npu_fast_compile"),
                    MemoryLayout.paddingLayout(7),
                    RuntimeHelper.POINTER.withName("device_id"),
                    JAVA_LONG.withName("num_of_threads"),
                    RuntimeHelper.POINTER.withName("cache_dir"),
                    RuntimeHelper.POINTER.withName("context"),
                    JAVA_BYTE.withName("enable_opencl_throttling"),
                    JAVA_BYTE.withName("enable_dynamic_shapes"),
                    MemoryLayout.paddingLayout(6))
            .withName("OrtOpenVINOProviderOptions");
    static final VarHandle const$1 =
            constants$11.const$0.varHandle(MemoryLayout.PathElement.groupElement("device_type"));
    static final VarHandle const$2 =
            constants$11.const$0.varHandle(MemoryLayout.PathElement.groupElement("enable_npu_fast_compile"));
    static final VarHandle const$3 = constants$11.const$0.varHandle(MemoryLayout.PathElement.groupElement("device_id"));
    static final VarHandle const$4 =
            constants$11.const$0.varHandle(MemoryLayout.PathElement.groupElement("num_of_threads"));
    static final VarHandle const$5 = constants$11.const$0.varHandle(MemoryLayout.PathElement.groupElement("cache_dir"));
}
