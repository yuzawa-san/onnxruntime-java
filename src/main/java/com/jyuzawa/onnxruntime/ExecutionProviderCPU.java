/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;
import java.util.Map;

final class ExecutionProviderCPU extends ExecutionProviderAppender {

    protected ExecutionProviderCPU(Map<String, String> properties) {
        super(properties);
    }

    @Override
    void appendToSessionOptions(MemorySession memorySession, ApiImpl api, MemoryAddress sessionOptions) {
        String useArena = properties.get("use_arena");
        if ("1".equals(useArena) || "false".equals(useArena)) {
            api.checkStatus(api.EnableCpuMemArena.apply(sessionOptions));
        } else {
            api.checkStatus(api.DisableCpuMemArena.apply(sessionOptions));
        }
    }
}
