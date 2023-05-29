/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import com.jyuzawa.onnxruntime_extern.OrtROCMProviderOptions;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.util.Map;

final class ExecutionProviderROCMConfig extends ExecutionProviderConfig {

    protected ExecutionProviderROCMConfig(Map<String, String> properties) {
        super(properties);
    }

    @Override
    final void appendToSessionOptions(MemorySession memorySession, ApiImpl api, MemoryAddress sessionOptions) {
        MemorySegment config = OrtROCMProviderOptions.allocate(memorySession);
        copyInteger("device_id", config, OrtROCMProviderOptions::device_id$set);
        copyInteger("miopen_conv_exhaustive_search", config, OrtROCMProviderOptions::miopen_conv_exhaustive_search$set);
        copyLong("gpu_mem_limit", config, OrtROCMProviderOptions::gpu_mem_limit$set);
        copyInteger("arena_extend_strategy", config, OrtROCMProviderOptions::arena_extend_strategy$set);
        copyInteger("do_copy_in_default_stream", config, OrtROCMProviderOptions::do_copy_in_default_stream$set);
        copyInteger("has_user_compute_stream", config, OrtROCMProviderOptions::has_user_compute_stream$set);
        // TODO: user_compute_stream
        // TODO: default_memory_arena_cfg
        copyInteger("tunable_op_enable", config, OrtROCMProviderOptions::tunable_op_enable$set);
        copyInteger("tunable_op_tuning_enable", config, OrtROCMProviderOptions::tunable_op_tuning_enable$set);
        api.checkStatus(api.SessionOptionsAppendExecutionProvider_ROCM.apply(sessionOptions, config.address()));
    }
}
