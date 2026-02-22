/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_CHAR;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class SessionImpl extends ManagedImpl implements Session {

    private static final Logger LOG = System.getLogger(SessionImpl.class.getName());
    private static final boolean IS_WINDOWS =
            System.getProperty("os.name").toLowerCase().contains("windows");

    private final MemorySegment address;
    private final NamedCollection<NodeInfoImpl> overridableInitializers;
    final NamedCollection<NodeInfoImpl> inputs;
    final NamedCollection<NodeInfoImpl> outputs;
    final EnvironmentImpl environment;
    private final ModelMetadata modelMetadata;
    private final MemorySegment ortAllocator;

    SessionImpl(Builder builder) throws IOException {
        super(builder.api, Arena.ofShared());
        try (Arena tempArena = Arena.ofConfined()) {
            this.environment = builder.environment;
            this.ortAllocator = environment.ortAllocator;
            MemorySegment sessionOptions = builder.newSessionOptions(tempArena);
            final MemorySegment mappedBuf;
            ByteBuffer buffer = builder.buffer;
            byte[] bytes = builder.bytes;
            Path path = builder.path;
            if (path != null) {
                LOG.log(Level.DEBUG, "Loading session from " + path);
                this.address = api.create(
                        arena,
                        out -> api.CreateSession.apply(
                                environment.address(), createPath(tempArena, path), sessionOptions, out),
                        api.ReleaseSession::apply);

            } else {
                if (buffer != null) {
                    if (buffer.isDirect()) {
                        mappedBuf = MemorySegment.ofBuffer(buffer);

                    } else {
                        mappedBuf = tempArena.allocate(C_CHAR, buffer.remaining());
                        mappedBuf.copyFrom(MemorySegment.ofBuffer(buffer));
                    }
                } else if (bytes != null) {
                    mappedBuf = tempArena.allocateFrom(C_CHAR, bytes);
                } else {
                    throw new IllegalArgumentException("missing model source");
                }
                this.address = api.create(
                        arena,
                        out -> api.CreateSessionFromArray.apply(
                                environment.address(), mappedBuf, mappedBuf.byteSize(), sessionOptions, out),
                        api.ReleaseSession::apply);
            }

            this.overridableInitializers = createMap(
                    api,
                    tempArena,
                    arena,
                    ortAllocator,
                    address,
                    api.SessionGetOverridableInitializerCount::apply,
                    api.SessionGetOverridableInitializerName::apply,
                    api.SessionGetOverridableInitializerTypeInfo::apply);
            this.inputs = createMap(
                    api,
                    tempArena,
                    arena,
                    ortAllocator,
                    address,
                    api.SessionGetInputCount::apply,
                    api.SessionGetInputName::apply,
                    api.SessionGetInputTypeInfo::apply);
            this.outputs = createMap(
                    api,
                    tempArena,
                    arena,
                    ortAllocator,
                    address,
                    api.SessionGetOutputCount::apply,
                    api.SessionGetOutputName::apply,
                    api.SessionGetOutputTypeInfo::apply);
            MemorySegment metadataAddress = api.create(
                    arena, out -> api.SessionGetModelMetadata.apply(address, out), api.ReleaseModelMetadata::apply);
            this.modelMetadata = new ModelMetadataImpl(api, tempArena, metadataAddress, ortAllocator);
        }
    }

    private static final MemorySegment createPath(Arena arena, Path path) {
        String pathString = path.toAbsolutePath().toString();
        if (IS_WINDOWS) {
            // treat segment as wchar_t
            return arena.allocateFrom(pathString, StandardCharsets.UTF_16LE);
        }
        return arena.allocateFrom(pathString);
    }

    @Override
    MemorySegment address() {
        return address;
    }

    private interface GetCount {
        MemorySegment apply(MemorySegment session, MemorySegment out);
    }

    private interface GetName {
        MemorySegment apply(MemorySegment session, long idx, MemorySegment ortAllocator, MemorySegment out);
    }

    private interface GetTypeInfo {
        MemorySegment apply(MemorySegment session, long idx, MemorySegment out);
    }

    private static NamedCollection<NodeInfoImpl> createMap(
            ApiImpl api,
            Arena arena,
            Arena sessionArena,
            MemorySegment ortAllocator,
            MemorySegment session,
            GetCount getCount,
            GetName getName,
            GetTypeInfo getTypeInfo) {
        long numInputs = api.extractLong(sessionArena, numInputsSegment -> getCount.apply(session, numInputsSegment));
        LinkedHashMap<String, NodeInfoImpl> inputs = new LinkedHashMap<>();
        for (long i = 0; i < numInputs; i++) {
            final long j = i;
            MemorySegment nameSegment = api.create(arena, out -> getName.apply(session, j, ortAllocator, out));
            String name = nameSegment.getString(0);
            api.checkStatus(api.AllocatorFree.apply(ortAllocator, nameSegment));
            MemorySegment typeInfoAddress =
                    api.create(arena, out -> getTypeInfo.apply(session, j, out), api.ReleaseTypeInfo::apply);
            TypeInfoImpl typeInfo = new TypeInfoImpl(api, typeInfoAddress, arena, sessionArena, ortAllocator);
            inputs.put(name, new NodeInfoImpl(name, sessionArena.allocateFrom(name), typeInfo));
        }
        return new NamedCollectionImpl<>(inputs);
    }

    @Override
    public long getProfilingStartTimeInNs() {
        try (Arena session = Arena.ofConfined()) {
            return api.extractLong(session, out -> api.SessionGetProfilingStartTimeNs.apply(address, out));
        }
    }

    @Override
    public Path endProfiling() {
        try (Arena session = Arena.ofConfined()) {
            MemorySegment path = api.create(session, out -> api.SessionEndProfiling.apply(address, ortAllocator, out));
            return Path.of(path.getString(0));
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public NamedCollection<NodeInfo> getOverridableInitializers() {
        return (NamedCollection<NodeInfo>) (NamedCollection<?>) overridableInitializers;
    }

    @SuppressWarnings("unchecked")
    @Override
    public NamedCollection<NodeInfo> getInputs() {
        return (NamedCollection<NodeInfo>) (NamedCollection<?>) inputs;
    }

    @Override
    public ModelMetadata getModelMetadata() {
        return modelMetadata;
    }

    @SuppressWarnings("unchecked")
    @Override
    public NamedCollection<NodeInfo> getOutputs() {
        return (NamedCollection<NodeInfo>) (NamedCollection<?>) outputs;
    }

    @Override
    public Transaction.Builder newTransaction() {
        return new TransactionImpl.Builder(this);
    }

    @Override
    public IoBinding.Builder newIoBinding() {
        return new IoBindingImpl.Builder(this);
    }

    @Override
    public void setEpDynamicOptions(Map<String, String> epDynamicOptions) {
        try (Arena tmpArena = Arena.ofConfined()) {
            int size = epDynamicOptions.size();
            MemorySegment keyArray = tmpArena.allocate(C_POINTER, size);
            MemorySegment valueArray = tmpArena.allocate(C_POINTER, size);
            int i = 0;
            for (Map.Entry<String, String> entry : epDynamicOptions.entrySet()) {
                keyArray.setAtIndex(C_POINTER, i, tmpArena.allocateFrom(entry.getKey()));
                valueArray.setAtIndex(C_POINTER, i, tmpArena.allocateFrom(entry.getValue()));
                i++;
            }
            api.checkStatus(api.SetEpDynamicOptions.apply(address, keyArray, valueArray, size));
        }
    }

    static final class Builder implements Session.Builder {
        private final ApiImpl api;
        private final EnvironmentImpl environment;
        private Path path;
        private byte[] bytes;
        private ByteBuffer buffer;
        private OnnxRuntimeLoggingLevel logSeverityLevel;
        private Integer logVerbosityLevel;
        private String loggerId;
        private Boolean memoryPatternOptimization;
        private Map<String, String> config;
        private Integer interOpNumThreads;
        private Integer intraOpNumThreads;
        private Path optimizedFilePath;
        private Path profilingOutput;
        private boolean disablePerSessionThreads;
        private OnnxRuntimeExecutionMode executionMode;
        private OnnxRuntimeOptimizationLevel optimizationLevel;
        private Map<ExecutionProvider, ExecutionProviderConfig> executionProviderAppenders;
        private List<Path> customOpsLibraries;
        private boolean deterministicCompute;
        private Map<String, Integer> symbolicDimensionsMap;
        private Map<String, Integer> denotationsMap;

        Builder(EnvironmentImpl environment) {
            this.api = environment.api;
            this.environment = environment;
            this.executionProviderAppenders = new LinkedHashMap<>();
            this.customOpsLibraries = new ArrayList<>();
        }

        @Override
        public Builder setByteArray(byte[] bytes) {
            this.bytes = bytes;
            return this;
        }

        @Override
        public Builder setPath(Path path) {
            this.path = path;
            return this;
        }

        @Override
        public Builder setByteBuffer(ByteBuffer buffer) {
            this.buffer = buffer;
            return this;
        }

        @Override
        public Builder setProfilingOutputPath(Path outputPathPrefix) {
            this.profilingOutput = outputPathPrefix;
            return this;
        }

        @Override
        public Builder setOptimizationOutputPath(Path outputPath) {
            this.optimizedFilePath = outputPath;
            return this;
        }

        @Override
        public Builder disablePerSessionThreads() {
            this.disablePerSessionThreads = true;
            return this;
        }

        @Override
        public Builder setExecutionMode(OnnxRuntimeExecutionMode mode) {
            this.executionMode = mode;
            return this;
        }

        @Override
        public Builder setOptimizationLevel(OnnxRuntimeOptimizationLevel level) {
            this.optimizationLevel = level;
            return this;
        }

        @Override
        public Builder setLogSeverityLevel(OnnxRuntimeLoggingLevel level) {
            this.logSeverityLevel = level;
            return this;
        }

        @Override
        public Builder setLogVerbosityLevel(int level) {
            this.logVerbosityLevel = level;
            return this;
        }

        @Override
        public Builder setLogId(String loggerId) {
            this.loggerId = loggerId;
            return this;
        }

        @Override
        public Builder setMemoryPatternOptimization(boolean memoryPatternOptimization) {
            this.memoryPatternOptimization = memoryPatternOptimization;
            return this;
        }

        @Override
        public Builder setConfigMap(Map<String, String> config) {
            this.config = config;
            return this;
        }

        @Override
        public Builder setInterOpNumThreads(int numThreads) {
            this.interOpNumThreads = numThreads;
            return this;
        }

        @Override
        public Builder setIntraOpNumThreads(int numThreads) {
            this.intraOpNumThreads = numThreads;
            return this;
        }

        @Override
        public Builder setDeterministicCompute(boolean value) {
            this.deterministicCompute = value;
            return this;
        }

        @Override
        public Builder addProvider(ExecutionProvider provider, Map<String, String> properties) {
            if (!provider.isSupported()) {
                throw new UnsupportedOperationException("Provider " + provider + " not implemented.");
            }
            this.executionProviderAppenders.put(provider, provider.factory.apply(properties));
            return this;
        }

        @Override
        public Builder addCustomOpsLibrary(Path path) {
            this.customOpsLibraries.add(path);
            return this;
        }

        @Override
        public Builder setFreeDimensionOverrideByName(Map<String, Integer> symbolicDimensionsMap) {
            this.symbolicDimensionsMap = symbolicDimensionsMap;
            return this;
        }

        @Override
        public Builder setFreeDimensionOverride(Map<String, Integer> denotationsMap) {
            this.denotationsMap = denotationsMap;
            return this;
        }

        private MemorySegment newSessionOptions(Arena arena) {
            MemorySegment sessionOptions =
                    api.create(arena, out -> api.CreateSessionOptions.apply(out), api.ReleaseSessionOptions::apply);
            if (logSeverityLevel != null) {
                api.checkStatus(api.SetSessionLogSeverityLevel.apply(sessionOptions, logSeverityLevel.getNumber()));
            }
            if (logVerbosityLevel != null) {
                api.checkStatus(api.SetSessionLogVerbosityLevel.apply(sessionOptions, logVerbosityLevel));
            }
            if (loggerId != null) {
                api.checkStatus(api.SetSessionLogId.apply(sessionOptions, arena.allocateFrom(loggerId)));
            }
            if (memoryPatternOptimization != null) {
                if (memoryPatternOptimization) {
                    api.checkStatus(api.EnableMemPattern.apply(sessionOptions));
                } else {
                    api.checkStatus(api.DisableMemPattern.apply(sessionOptions));
                }
            }
            if (interOpNumThreads != null) {
                api.checkStatus(api.SetInterOpNumThreads.apply(sessionOptions, interOpNumThreads));
            }
            if (intraOpNumThreads != null) {
                api.checkStatus(api.SetIntraOpNumThreads.apply(sessionOptions, intraOpNumThreads));
            }
            if (disablePerSessionThreads) {
                api.checkStatus(api.DisablePerSessionThreads.apply(sessionOptions));
            }
            if (executionMode != null) {
                api.checkStatus(api.SetSessionExecutionMode.apply(sessionOptions, executionMode.getNumber()));
            }
            if (optimizationLevel != null) {
                api.checkStatus(
                        api.SetSessionGraphOptimizationLevel.apply(sessionOptions, optimizationLevel.getNumber()));
            }
            if (deterministicCompute) {
                api.checkStatus(api.SetDeterministicCompute.apply(sessionOptions, deterministicCompute));
            }
            if (optimizedFilePath != null) {
                api.checkStatus(
                        api.SetOptimizedModelFilePath.apply(sessionOptions, createPath(arena, optimizedFilePath)));
            }
            if (profilingOutput != null) {
                api.checkStatus(api.EnableProfiling.apply(sessionOptions, createPath(arena, profilingOutput)));
            }
            if (config != null && !config.isEmpty()) {
                for (Map.Entry<String, String> entry : config.entrySet()) {
                    api.checkStatus(api.AddSessionConfigEntry.apply(
                            sessionOptions, arena.allocateFrom(entry.getKey()), arena.allocateFrom(entry.getValue())));
                }
            }
            if (symbolicDimensionsMap != null) {
                for (Map.Entry<String, Integer> entry : symbolicDimensionsMap.entrySet()) {
                    api.checkStatus(api.AddFreeDimensionOverrideByName.apply(
                            sessionOptions, arena.allocateFrom(entry.getKey()), entry.getValue()));
                }
            }
            if (denotationsMap != null) {
                for (Map.Entry<String, Integer> entry : denotationsMap.entrySet()) {
                    api.checkStatus(api.AddFreeDimensionOverride.apply(
                            sessionOptions, arena.allocateFrom(entry.getKey()), entry.getValue()));
                }
            }

            LOG.log(Level.DEBUG, "Execution Providers: " + executionProviderAppenders);
            for (ExecutionProviderConfig executionProviderAppender : executionProviderAppenders.values()) {
                executionProviderAppender.appendToSessionOptions(arena, api, sessionOptions);
            }
            for (Path customOpsLibrary : customOpsLibraries) {
                LOG.log(Level.DEBUG, "Adding custom op library: " + customOpsLibrary);
                api.checkStatus(
                        api.RegisterCustomOpsLibrary_V2.apply(sessionOptions, createPath(arena, customOpsLibrary)));
            }
            return sessionOptions;
        }

        @Override
        public Session build() throws IOException {
            return new SessionImpl(this);
        }
    }
}
