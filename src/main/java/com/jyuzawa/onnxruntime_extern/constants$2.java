/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

final class constants$2 {

    // Suppresses default constructor, ensuring non-instantiability.
    private constants$2() {}

    static final MethodHandle const$0 = RuntimeHelper.downcallHandle(constants$1.const$4);
    static final VarHandle const$1 = constants$0.const$0.varHandle(MemoryLayout.PathElement.groupElement("Info"));
    static final FunctionDescriptor const$2 = FunctionDescriptor.ofVoid(
            RuntimeHelper.POINTER,
            JAVA_INT,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER,
            RuntimeHelper.POINTER);
    static final MethodHandle const$3 =
            RuntimeHelper.upcallHandle(OrtLoggingFunction.class, "apply", constants$2.const$2);
    static final MethodHandle const$4 = RuntimeHelper.downcallHandle(constants$2.const$2);
    static final StructLayout const$5 = MemoryLayout.structLayout(
                    JAVA_INT.withName("device_id"),
                    JAVA_INT.withName("cudnn_conv_algo_search"),
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
            .withName("OrtCUDAProviderOptions");
}
