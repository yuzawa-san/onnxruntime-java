/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

final class constants$6 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$6() {}

    static final VarHandle const$0 =
            constants$4.const$5.varHandle(MemoryLayout.PathElement.groupElement("user_compute_stream"));
    static final VarHandle const$1 =
            constants$4.const$5.varHandle(MemoryLayout.PathElement.groupElement("default_memory_arena_cfg"));
    static final VarHandle const$2 =
            constants$4.const$5.varHandle(MemoryLayout.PathElement.groupElement("tunable_op_enable"));
    static final VarHandle const$3 =
            constants$4.const$5.varHandle(MemoryLayout.PathElement.groupElement("tunable_op_tuning_enable"));
    static final VarHandle const$4 =
            constants$4.const$5.varHandle(MemoryLayout.PathElement.groupElement("tunable_op_max_tuning_duration_ms"));
    static final StructLayout const$5 = MemoryLayout.structLayout(
                    JAVA_INT.withName("device_id"),
                    JAVA_INT.withName("has_user_compute_stream"),
                    RuntimeHelper.POINTER.withName("user_compute_stream"),
                    JAVA_INT.withName("trt_max_partition_iterations"),
                    JAVA_INT.withName("trt_min_subgraph_size"),
                    JAVA_LONG.withName("trt_max_workspace_size"),
                    JAVA_INT.withName("trt_fp16_enable"),
                    JAVA_INT.withName("trt_int8_enable"),
                    RuntimeHelper.POINTER.withName("trt_int8_calibration_table_name"),
                    JAVA_INT.withName("trt_int8_use_native_calibration_table"),
                    JAVA_INT.withName("trt_dla_enable"),
                    JAVA_INT.withName("trt_dla_core"),
                    JAVA_INT.withName("trt_dump_subgraphs"),
                    JAVA_INT.withName("trt_engine_cache_enable"),
                    MemoryLayout.paddingLayout(4),
                    RuntimeHelper.POINTER.withName("trt_engine_cache_path"),
                    JAVA_INT.withName("trt_engine_decryption_enable"),
                    MemoryLayout.paddingLayout(4),
                    RuntimeHelper.POINTER.withName("trt_engine_decryption_lib_path"),
                    JAVA_INT.withName("trt_force_sequential_engine_build"),
                    MemoryLayout.paddingLayout(4))
            .withName("OrtTensorRTProviderOptions");
}
