/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_LONG;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.ORT_PROJECTION_JAVA;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.OrtArenaAllocator;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.OrtMemTypeDefault;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.util.Map;

final class EnvironmentImpl extends ManagedImpl implements Environment {

    private final MemoryAddress address;
    final MemoryAddress memoryInfo;
    final MemoryAddress ortAllocator;

    EnvironmentImpl(Builder builder) {
        super(builder.api, MemorySession.openShared());
        try (MemorySession temporarySession = MemorySession.openConfined()) {
            MemorySegment logName = temporarySession.allocateUtf8String(builder.logId);
            if (builder.useThreadingOptions) {
                MemoryAddress threadingOptionsAddress = builder.newThreadingOptions(temporarySession);
                this.address = api.create(
                        memorySession,
                        out -> api.CreateEnvWithCustomLoggerAndGlobalThreadPools.apply(
                                OnnxRuntimeLoggingLevel.LOG_CALLBACK,
                                MemoryAddress.NULL,
                                builder.severityLevel.getNumber(),
                                logName.address(),
                                threadingOptionsAddress,
                                out));
            } else {
                this.address = api.create(
                        memorySession,
                        out -> api.CreateEnvWithCustomLogger.apply(
                                OnnxRuntimeLoggingLevel.LOG_CALLBACK,
                                MemoryAddress.NULL,
                                builder.severityLevel.getNumber(),
                                logName.address(),
                                out));
            }
            memorySession.addCloseAction(() -> api.ReleaseEnv.apply(address));
            api.checkStatus(api.SetLanguageProjection.apply(address, ORT_PROJECTION_JAVA()));
            this.memoryInfo = api.create(
                    memorySession, out -> api.CreateCpuMemoryInfo.apply(OrtArenaAllocator(), OrtMemTypeDefault(), out));
            memorySession.addCloseAction(() -> api.ReleaseMemoryInfo.apply(memoryInfo));
            this.ortAllocator = api.create(memorySession, out -> api.GetAllocatorWithDefaultOptions.apply(out));
            Map<String, Long> arenaConfig = builder.arenaConfig;
            if (arenaConfig == null) {
                api.RegisterAllocator.apply(address, ortAllocator);
            } else {
                int size = arenaConfig.size();
                MemorySegment keyArray = temporarySession.allocateArray(C_POINTER, size);
                MemorySegment valueArray = temporarySession.allocateArray(C_LONG, size);
                int i = 0;
                for (Map.Entry<String, Long> entry : arenaConfig.entrySet()) {
                    keyArray.setAtIndex(C_POINTER, i, temporarySession.allocateUtf8String(entry.getKey()));
                    valueArray.setAtIndex(C_LONG, i, entry.getValue());
                    i++;
                }
                MemoryAddress arenaConfigAddress = api.create(
                        temporarySession,
                        out -> api.CreateArenaCfgV2.apply(keyArray.address(), valueArray.address(), size, out));
                api.checkStatus(api.CreateAndRegisterAllocator.apply(address, memoryInfo, arenaConfigAddress));
            }
        }
    }

    @Override
    MemoryAddress address() {
        return address;
    }

    @Override
    public Session.Builder newSession() {
        return new SessionImpl.Builder(this);
    }

    @Override
    public void setTelemetryEvents(boolean enabled) {
        if (enabled) {
            api.checkStatus(api.EnableTelemetryEvents.apply(address));
        } else {
            api.checkStatus(api.DisableTelemetryEvents.apply(address));
        }
    }

    static final class Builder implements Environment.Builder {

        private final ApiImpl api;
        private OnnxRuntimeLoggingLevel severityLevel;
        private String logId;
        private boolean useThreadingOptions;
        private Boolean globalDenormalAsZero;
        private Integer globalInterOpNumThreads;
        private Integer globalIntraOpNumThreads;
        private Boolean globalSpinControl;
        private Map<String, Long> arenaConfig;

        Builder(ApiImpl api) {
            this.api = api;
            this.severityLevel = OnnxRuntimeLoggingLevel.DEFAULT;
            this.logId = "onnxruntime-java";
        }

        @Override
        public Builder setLogSeverityLevel(OnnxRuntimeLoggingLevel severityLevel) {
            this.severityLevel = severityLevel;
            return this;
        }

        @Override
        public Builder setLogId(String id) {
            this.logId = id;
            return this;
        }

        @Override
        public Builder setGlobalDenormalAsZero(boolean globalDenormalAsZero) {
            this.useThreadingOptions = true;
            this.globalDenormalAsZero = globalDenormalAsZero;
            return this;
        }

        @Override
        public Builder setGlobalInterOpNumThreads(int numThreads) {
            this.useThreadingOptions = true;
            this.globalInterOpNumThreads = numThreads;
            return this;
        }

        @Override
        public Builder setGlobalIntraOpNumThreads(int numThreads) {
            this.useThreadingOptions = true;
            this.globalIntraOpNumThreads = numThreads;
            return this;
        }

        @Override
        public Builder setGlobalSpinControl(boolean globalSpinControl) {
            this.useThreadingOptions = true;
            this.globalSpinControl = globalSpinControl;
            return this;
        }

        public Builder setArenaConfig(Map<String, Long> config) {
            this.arenaConfig = config;
            return this;
        }

        private MemoryAddress newThreadingOptions(MemorySession memorySession) {
            MemoryAddress threadingOptions = api.create(memorySession, out -> api.CreateThreadingOptions.apply(out));
            memorySession.addCloseAction(() -> api.ReleaseThreadingOptions.apply(threadingOptions));
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
            return new EnvironmentImpl(this);
        }
    }
}
