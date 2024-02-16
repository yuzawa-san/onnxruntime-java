/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import com.jyuzawa.onnxruntime_extern.OrtMIGraphXProviderOptions;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.util.Map;

final class ExecutionProviderMIGraphXConfig extends ExecutionProviderConfig {

    protected ExecutionProviderMIGraphXConfig(Map<String, String> properties) {
        super(properties);
    }

    @Override
    final void appendToSessionOptions(MemorySession memorySession, ApiImpl api, MemoryAddress sessionOptions) {
        MemorySegment config = OrtMIGraphXProviderOptions.allocate(memorySession);
        copyInteger("device_id", config, OrtMIGraphXProviderOptions::device_id$set);
        copyInteger("migraphx_fp16_enable", config, OrtMIGraphXProviderOptions::migraphx_fp16_enable$set);
        copyInteger("migraphx_int8_enable", config, OrtMIGraphXProviderOptions::migraphx_int8_enable$set);
        copyInteger(
                "migraphx_use_native_calibration_table",
                config,
                OrtMIGraphXProviderOptions::migraphx_use_native_calibration_table$set);
        copyString(
                "migraphx_int8_calibration_table_name",
                config,
                memorySession,
                OrtMIGraphXProviderOptions::migraphx_int8_calibration_table_name$set);
        api.checkStatus(api.SessionOptionsAppendExecutionProvider_MIGraphX.apply(sessionOptions, config.address()));
    }
}
