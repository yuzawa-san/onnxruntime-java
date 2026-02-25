/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h$shared.C_POINTER;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_LONG;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.ORT_PROJECTION_JAVA;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.OrtArenaAllocator;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.OrtMemTypeDefault;

import com.jyuzawa.onnxruntime_extern.OrtEnvCreationOptions;
import com.jyuzawa.onnxruntime_extern.onnxruntime_all_h;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.HashMap;
import java.util.Map;

final class EnvironmentImpl extends ManagedImpl implements Environment {

    private final MemorySegment address;
    final MemorySegment memoryInfo;
    final MemorySegment ortAllocator;

    EnvironmentImpl(Builder builder) {
        super(builder.api, Arena.ofShared());
        try (Arena temporarySession = Arena.ofConfined()) {
            MemorySegment configKeyValuesPointer = temporarySession.allocate(C_POINTER);
            api.CreateKeyValuePairs.apply(configKeyValuesPointer);
            MemorySegment configKeyValues = configKeyValuesPointer
                    .getAtIndex(C_POINTER, 0)
                    .reinterpret(C_POINTER.byteSize(), temporarySession, api.ReleaseKeyValuePairs::apply);
            MemorySegment options = OrtEnvCreationOptions.allocate(temporarySession);
            OrtEnvCreationOptions.version(options, onnxruntime_all_h.ORT_API_VERSION());
            OrtEnvCreationOptions.logging_severity_level(options, builder.severityLevel.getNumber());
            if (builder.logId != null) {
                OrtEnvCreationOptions.log_id(options, temporarySession.allocateFrom(builder.logId));
            }
            OrtEnvCreationOptions.custom_logging_function(options, OnnxRuntimeLoggingLevel.LOG_CALLBACK);
            if (builder.logParameter != null) {
                OrtEnvCreationOptions.custom_logging_param(
                        options, temporarySession.allocateFrom(builder.logParameter));
            }
            if (builder.useThreadingOptions) {
                MemorySegment threadingOptionsAddress = builder.newThreadingOptions(temporarySession);
                OrtEnvCreationOptions.threading_options(options, threadingOptionsAddress);
            }
            for (Map.Entry<String, String> entry : builder.config.entrySet()) {
                api.AddKeyValuePair.apply(
                        configKeyValues,
                        temporarySession.allocateFrom(entry.getKey()),
                        temporarySession.allocateFrom(entry.getValue()));
            }
            OrtEnvCreationOptions.config_entries(options, configKeyValues);
            this.address =
                    api.create(arena, out -> api.CreateEnvWithOptions.apply(options, out), api.ReleaseEnv::apply);
            api.checkStatus(api.SetLanguageProjection.apply(address, ORT_PROJECTION_JAVA()));
            this.memoryInfo = api.create(
                    arena,
                    out -> api.CreateCpuMemoryInfo.apply(OrtArenaAllocator(), OrtMemTypeDefault(), out),
                    api.ReleaseMemoryInfo::apply);
            Map<String, Long> arenaConfig = builder.arenaConfig;
            int size = arenaConfig.size();
            MemorySegment keyArray = temporarySession.allocate(C_POINTER, size);
            MemorySegment valueArray = temporarySession.allocate(C_LONG, size);
            int i = 0;
            for (Map.Entry<String, Long> entry : arenaConfig.entrySet()) {
                keyArray.setAtIndex(C_POINTER, i, temporarySession.allocateFrom(entry.getKey()));
                valueArray.setAtIndex(C_LONG, i, entry.getValue());
                i++;
            }
            MemorySegment arenaConfigAddress =
                    api.create(temporarySession, out -> api.CreateArenaCfgV2.apply(keyArray, valueArray, size, out));
            api.checkStatus(api.CreateAndRegisterAllocator.apply(address, memoryInfo, arenaConfigAddress));
            this.ortAllocator = api.create(arena, out -> api.GetSharedAllocator.apply(address, memoryInfo, out));
        }
    }

    // TODO: expose this once it actually returns something
    public Map<String, String> getAllocatorStats() {
        try (Arena localArena = Arena.ofConfined()) {
            MemorySegment keyValuePairs = api.create(
                    localArena, out -> api.AllocatorGetStats.apply(ortAllocator, out), api.ReleaseKeyValuePairs::apply);
            MemorySegment keys = localArena.allocate(C_POINTER);
            MemorySegment values = localArena.allocate(C_POINTER);
            MemorySegment count = localArena.allocate(C_LONG);
            api.GetKeyValuePairs.apply(keyValuePairs, keys, values, count);
            int size = Math.toIntExact(count.get(C_LONG, 0));
            Map<String, String> out = new HashMap<>(size);
            MemorySegment theKeys = keys.getAtIndex(C_POINTER, 0);
            MemorySegment theValues = keys.getAtIndex(C_POINTER, 0);
            for (int i = 0; i < size; i++) {
                out.put(
                        theKeys.getAtIndex(C_POINTER, i).getString(0),
                        theValues.getAtIndex(C_POINTER, i).getString(0));
            }
            return out;
        }
    }

    @Override
    MemorySegment address() {
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
        private String logParameter;
        private boolean useThreadingOptions;
        private Boolean globalDenormalAsZero;
        private Integer globalInterOpNumThreads;
        private Integer globalIntraOpNumThreads;
        private Boolean globalSpinControl;
        private Map<String, Long> arenaConfig;
        private Map<String, String> config;

        Builder(ApiImpl api) {
            this.api = api;
            this.severityLevel = OnnxRuntimeLoggingLevel.DEFAULT;
            this.logId = "onnxruntime-java";
            this.arenaConfig = Map.of();
            this.config = Map.of();
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
        public Builder setLogParameter(String logParameter) {
            this.logParameter = logParameter;
            return this;
        }

        @Override
        public Builder setConfigMap(Map<String, String> config) {
            this.config = config;
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

        @Override
        public Builder setArenaConfig(Map<String, Long> config) {
            this.arenaConfig = config;
            return this;
        }

        private MemorySegment newThreadingOptions(Arena arena) {
            MemorySegment threadingOptions =
                    api.create(arena, out -> api.CreateThreadingOptions.apply(out), api.ReleaseThreadingOptions::apply);
            if (globalDenormalAsZero != null && Boolean.TRUE.equals(globalSpinControl)) {
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
