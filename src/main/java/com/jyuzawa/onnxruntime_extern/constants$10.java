/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

final class constants$10 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$10() {}

    static final StructLayout const$0 = MemoryLayout.structLayout(
                    JAVA_INT.withName("device_id"),
                    JAVA_INT.withName("migraphx_fp16_enable"),
                    JAVA_INT.withName("migraphx_int8_enable"))
            .withName("OrtMIGraphXProviderOptions");
    static final VarHandle const$1 = constants$10.const$0.varHandle(MemoryLayout.PathElement.groupElement("device_id"));
    static final VarHandle const$2 =
            constants$10.const$0.varHandle(MemoryLayout.PathElement.groupElement("migraphx_fp16_enable"));
    static final VarHandle const$3 =
            constants$10.const$0.varHandle(MemoryLayout.PathElement.groupElement("migraphx_int8_enable"));
    static final StructLayout const$4 = MemoryLayout.structLayout(
                    RuntimeHelper.POINTER.withName("device_type"),
                    JAVA_BYTE.withName("enable_vpu_fast_compile"),
                    MemoryLayout.paddingLayout(7),
                    RuntimeHelper.POINTER.withName("device_id"),
                    JAVA_LONG.withName("num_of_threads"),
                    RuntimeHelper.POINTER.withName("cache_dir"),
                    RuntimeHelper.POINTER.withName("context"),
                    JAVA_BYTE.withName("enable_opencl_throttling"),
                    JAVA_BYTE.withName("enable_dynamic_shapes"),
                    MemoryLayout.paddingLayout(6))
            .withName("OrtOpenVINOProviderOptions");
    static final VarHandle const$5 =
            constants$10.const$4.varHandle(MemoryLayout.PathElement.groupElement("device_type"));
}
