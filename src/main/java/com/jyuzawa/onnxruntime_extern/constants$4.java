/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.VarHandle;

final class constants$4 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$4() {}

    static final VarHandle const$0 =
            constants$2.const$5.varHandle(MemoryLayout.PathElement.groupElement("user_compute_stream"));
    static final VarHandle const$1 =
            constants$2.const$5.varHandle(MemoryLayout.PathElement.groupElement("default_memory_arena_cfg"));
    static final VarHandle const$2 =
            constants$2.const$5.varHandle(MemoryLayout.PathElement.groupElement("tunable_op_enable"));
    static final VarHandle const$3 =
            constants$2.const$5.varHandle(MemoryLayout.PathElement.groupElement("tunable_op_tuning_enable"));
    static final VarHandle const$4 =
            constants$2.const$5.varHandle(MemoryLayout.PathElement.groupElement("tunable_op_max_tuning_duration_ms"));
    static final StructLayout const$5 = MemoryLayout.structLayout(
                    JAVA_INT.withName("device_id"),
                    JAVA_INT.withName("miopen_conv_exhaustive_search"),
                    JAVA_LONG.withName("gpu_mem_limit"),
                    JAVA_INT.withName("arena_extend_strategy"),
                    JAVA_INT.withName("do_copy_in_default_stream"),
                    JAVA_INT.withName("has_user_compute_stream"),
                    MemoryLayout.paddingLayout(4),
                    RuntimeHelper.POINTER.withName("user_compute_stream"),
                    RuntimeHelper.POINTER.withName("default_memory_arena_cfg"),
                    JAVA_INT.withName("tunable_op_enable"),
                    JAVA_INT.withName("tunable_op_tuning_enable"),
                    JAVA_INT.withName("tunable_op_max_tuning_duration_ms"),
                    MemoryLayout.paddingLayout(4))
            .withName("OrtROCMProviderOptions");
}
