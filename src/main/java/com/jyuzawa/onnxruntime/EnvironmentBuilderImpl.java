/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static jdk.incubator.foreign.CLinker.toCString;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

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
        ResourceScope scope = ResourceScope.newConfinedScope();
        SegmentAllocator allocator = SegmentAllocator.ofScope(scope);
        MemorySegment logName = toCString(logId, scope);
        MemoryAddress env = api.create(
                allocator,
                out -> api.CreateEnvWithCustomLogger.apply(
                        OnnxRuntimeLoggingLevel.LOG_CALLBACK,
                        MemoryAddress.NULL,
                        severityLevel.getNumber(),
                        logName.address(),
                        out));
        scope.addCloseAction(() -> {
            api.ReleaseEnv.apply(env);
        });
        return new EnvironmentImpl(api, scope, env);
    }
}
