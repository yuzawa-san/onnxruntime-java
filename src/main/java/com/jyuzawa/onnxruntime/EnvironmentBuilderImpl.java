/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;

final class EnvironmentBuilderImpl implements Environment.Builder {

    private final ApiImpl api;
    OnnxRuntimeLoggingLevel severityLevel;
    String logId;

    EnvironmentBuilderImpl(ApiImpl api) {
        this.api = api;
        this.severityLevel = OnnxRuntimeLoggingLevel.DEFAULT;
        this.logId = "onnxruntime-java";
    }

    @Override
    public Environment.Builder setLogSeverityLevel(OnnxRuntimeLoggingLevel severityLevel) {
        this.severityLevel = severityLevel;
        return this;
    }

    @Override
    public Environment.Builder setLogId(String id) {
        this.logId = id;
        return this;
    }

    @Override
    public Environment build() {
        MemorySession scope = MemorySession.openShared();
        MemorySegment logName = scope.allocateUtf8String(logId);
        /*
        * out -> api.CreateEnv.apply(
                       OnnxRuntimeLoggingLevel.LOG_CALLBACK,
                       MemoryAddress.NULL,
                       severityLevel.getNumber(),
                       logName.address(),
                       out)
        */
        MemoryAddress env =
                api.create(scope, out -> api.CreateEnv.apply(severityLevel.getNumber(), logName.address(), out));
        scope.addCloseAction(() -> {
            api.ReleaseEnv.apply(env);
        });
        return new EnvironmentImpl(api, scope, env);
    }
}
