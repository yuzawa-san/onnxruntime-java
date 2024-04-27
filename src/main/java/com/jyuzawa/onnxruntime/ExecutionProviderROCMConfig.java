/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import com.jyuzawa.onnxruntime_extern.OrtROCMProviderOptions;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Map;

final class ExecutionProviderROCMConfig extends ExecutionProviderConfig {

    protected ExecutionProviderROCMConfig(Map<String, String> properties) {
        super(properties);
    }

    @Override
    final void appendToSessionOptions(Arena memorySession, ApiImpl api, MemorySegment sessionOptions) {
        MemorySegment config = OrtROCMProviderOptions.allocate(memorySession);
        copyInteger("device_id", config, OrtROCMProviderOptions::device_id);
        copyInteger("miopen_conv_exhaustive_search", config, OrtROCMProviderOptions::miopen_conv_exhaustive_search);
        copyLong("gpu_mem_limit", config, OrtROCMProviderOptions::gpu_mem_limit);
        copyInteger("arena_extend_strategy", config, OrtROCMProviderOptions::arena_extend_strategy);
        copyInteger("do_copy_in_default_stream", config, OrtROCMProviderOptions::do_copy_in_default_stream);
        copyInteger("has_user_compute_stream", config, OrtROCMProviderOptions::has_user_compute_stream);
        // TODO: user_compute_stream
        // TODO: default_memory_arena_cfg
        copyInteger("tunable_op_enable", config, OrtROCMProviderOptions::tunable_op_enable);
        copyInteger("tunable_op_tuning_enable", config, OrtROCMProviderOptions::tunable_op_tuning_enable);
        copyInteger(
                "tunable_op_max_tuning_duration_ms", config, OrtROCMProviderOptions::tunable_op_max_tuning_duration_ms);
        api.checkStatus(api.SessionOptionsAppendExecutionProvider_ROCM.apply(sessionOptions, config));
    }
}
