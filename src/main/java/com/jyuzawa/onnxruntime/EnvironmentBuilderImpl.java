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
    private OnnxRuntimeLoggingLevel severityLevel;
    private String logId;
    private boolean useThreadingOptions;
    private Boolean globalDenormalAsZero;
    private Integer globalInterOpNumThreads;
    private Integer globalIntraOpNumThreads;
    private Boolean globalSpinControl;

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
    public Environment.Builder setGlobalDenormalAsZero(boolean globalDenormalAsZero) {
        this.useThreadingOptions = true;
        this.globalDenormalAsZero = globalDenormalAsZero;
        return this;
    }

    @Override
    public Environment.Builder setGlobalInterOpNumThreads(int numThreads) {
        this.useThreadingOptions = true;
        this.globalInterOpNumThreads = numThreads;
        return this;
    }

    @Override
    public Environment.Builder setGlobalIntraOpNumThreads(int numThreads) {
        this.useThreadingOptions = true;
        this.globalIntraOpNumThreads = numThreads;
        return this;
    }

    @Override
    public Environment.Builder setGlobalSpinControl(boolean globalSpinControl) {
        this.useThreadingOptions = true;
        this.globalSpinControl = globalSpinControl;
        return this;
    }

    private MemoryAddress newThreadingOptions(MemorySession scope) {
        MemoryAddress threadingOptions = api.create(scope, out -> api.CreateThreadingOptions.apply(out));
        if (globalDenormalAsZero != null && globalSpinControl) {
            api.checkStatus(api.SetGlobalDenormalAsZero.apply(threadingOptions));
        }
        if (globalSpinControl != null) {
            api.checkStatus(api.SetGlobalSpinControl.apply(threadingOptions, globalSpinControl ? 1 : 0));
        }
        if (globalInterOpNumThreads != null) {
            api.checkStatus(api.SetGlobalInterOpNumThreads.apply(threadingOptions, globalInterOpNumThreads));
        }
        if (globalIntraOpNumThreads != null) {
            api.checkStatus(api.SetGlobalIntraOpNumThreads.apply(threadingOptions, globalIntraOpNumThreads));
        }
        return threadingOptions;
    }

    @Override
    public Environment build() {
        MemorySession scope = MemorySession.openShared();
        MemorySegment logName = scope.allocateUtf8String(logId);
        MemoryAddress env;
        if (useThreadingOptions) {
            MemoryAddress threadingOptionsAddress = newThreadingOptions(scope);
            env = api.create(
                    scope,
                    out -> api.CreateEnvWithCustomLoggerAndGlobalThreadPools.apply(
                            OnnxRuntimeLoggingLevel.LOG_CALLBACK,
                            MemoryAddress.NULL,
                            severityLevel.getNumber(),
                            logName.address(),
                            threadingOptionsAddress,
                            out));
            api.ReleaseThreadingOptions.apply(threadingOptionsAddress);
        } else {
            env = api.create(
                    scope,
                    out -> api.CreateEnvWithCustomLogger.apply(
                            OnnxRuntimeLoggingLevel.LOG_CALLBACK,
                            MemoryAddress.NULL,
                            severityLevel.getNumber(),
                            logName.address(),
                            out));
        }
        scope.addCloseAction(() -> {
            api.ReleaseEnv.apply(env);
        });
        return new EnvironmentImpl(api, scope, env);
    }
}
