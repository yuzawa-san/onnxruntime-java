/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_CHAR;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_INT;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_LONG;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;
import static java.lang.foreign.ValueLayout.JAVA_BYTE;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.lang.foreign.Addressable;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;
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

    private final MemoryAddress address;
    private final NamedCollection<NodeInfoImpl> overridableInitializers;
    final NamedCollection<NodeInfoImpl> inputs;
    final NamedCollection<NodeInfoImpl> outputs;
    final EnvironmentImpl environment;
    private final ModelMetadata modelMetadata;
    private final MemoryAddress ortAllocator;

    SessionImpl(Builder builder) throws IOException {
        super(builder.api, MemorySession.openShared());
        try (MemorySession tempMemorySession = MemorySession.openConfined()) {
            this.environment = builder.environment;
            this.ortAllocator = environment.ortAllocator;
            MemoryAddress sessionOptions = builder.newSessionOptions(tempMemorySession);

            final MemorySegment mappedBuf;
            ByteBuffer buffer = builder.buffer;
            byte[] bytes = builder.bytes;
            Path path = builder.path;
            if (path != null) {
                LOG.log(Level.DEBUG, "Loading session from " + path);
                this.address = api.create(
                        memorySession,
                        out -> api.CreateSession.apply(
                                environment.address(), createPath(tempMemorySession, path), sessionOptions, out));
            } else {
                if (buffer != null) {
                    if (buffer.isDirect()) {
                        mappedBuf = MemorySegment.ofBuffer(buffer);

                    } else {
                        mappedBuf = tempMemorySession.allocateArray(C_CHAR, buffer.remaining());
                        mappedBuf.copyFrom(MemorySegment.ofBuffer(buffer));
                    }
                } else if (bytes != null) {
                    mappedBuf = tempMemorySession.allocateArray(C_CHAR, bytes);
                } else {
                    throw new IllegalArgumentException("missing model source");
                }
                this.address = api.create(
                        memorySession,
                        out -> api.CreateSessionFromArray.apply(
                                environment.address(), mappedBuf.address(), mappedBuf.byteSize(), sessionOptions, out));
            }

            memorySession.addCloseAction(() -> api.ReleaseSession.apply(address));

            this.overridableInitializers = createMap(
                    api,
                    tempMemorySession,
                    memorySession,
                    ortAllocator,
                    address,
                    api.SessionGetOverridableInitializerCount::apply,
                    api.SessionGetOverridableInitializerName::apply,
                    api.SessionGetOverridableInitializerTypeInfo::apply);
            this.inputs = createMap(
                    api,
                    tempMemorySession,
                    memorySession,
                    ortAllocator,
                    address,
                    api.SessionGetInputCount::apply,
                    api.SessionGetInputName::apply,
                    api.SessionGetInputTypeInfo::apply);
            this.outputs = createMap(
                    api,
                    tempMemorySession,
                    memorySession,
                    ortAllocator,
                    address,
                    api.SessionGetOutputCount::apply,
                    api.SessionGetOutputName::apply,
                    api.SessionGetOutputTypeInfo::apply);
            this.modelMetadata = new ModelMetadataImpl(api, tempMemorySession, address, ortAllocator);
        }
    }

    private static final MemoryAddress createPath(SegmentAllocator segmentAllocator, Path path) {
        String pathString = path.toAbsolutePath().toString();
        if (IS_WINDOWS) {
            // treat segment as wchar_t
            byte[] bytes = pathString.getBytes(StandardCharsets.UTF_16LE);
            MemorySegment addr = segmentAllocator.allocate(bytes.length + 2);
            MemorySegment heapSegment = MemorySegment.ofArray(bytes);
            addr.copyFrom(heapSegment);
            addr.set(JAVA_BYTE, bytes.length, (byte) 0);
            addr.set(JAVA_BYTE, bytes.length + 1, (byte) 0);
            return addr.address();
        }
        return segmentAllocator.allocateUtf8String(pathString).address();
    }

    @Override
    MemoryAddress address() {
        return address;
    }

    private interface GetCount {
        Addressable apply(MemoryAddress session, MemoryAddress out);
    }

    private interface GetName {
        Addressable apply(MemoryAddress session, long idx, MemoryAddress ortAllocator, MemoryAddress out);
    }

    private interface GetTypeInfo {
        Addressable apply(MemoryAddress session, long idx, MemoryAddress out);
    }

    private static NamedCollection<NodeInfoImpl> createMap(
            ApiImpl api,
            MemorySession allocator,
            MemorySession sessionAllocator,
            MemoryAddress ortAllocator,
            MemoryAddress session,
            GetCount getCount,
            GetName getName,
            GetTypeInfo getTypeInfo) {
        MemorySegment numInputsSegment = allocator.allocate(C_LONG);
        api.checkStatus(getCount.apply(session, numInputsSegment.address()));
        long numInputs = numInputsSegment.getAtIndex(C_LONG, 0);
        LinkedHashMap<String, NodeInfoImpl> inputs = new LinkedHashMap<>();
        for (long i = 0; i < numInputs; i++) {
            final long j = i;
            MemoryAddress nameSegment = api.create(allocator, out -> getName.apply(session, j, ortAllocator, out));
            String name = nameSegment.getUtf8String(0);
            api.checkStatus(api.AllocatorFree.apply(ortAllocator, nameSegment));
            MemoryAddress typeInfoAddress = api.create(allocator, out -> getTypeInfo.apply(session, j, out));
            TypeInfoImpl typeInfo = new TypeInfoImpl(api, typeInfoAddress, allocator, sessionAllocator, ortAllocator);
            inputs.put(name, new NodeInfoImpl(name, sessionAllocator.allocateUtf8String(name), typeInfo));
        }
        return new NamedCollectionImpl<>(inputs);
    }

    @Override
    public long getProfilingStartTimeInNs() {
        try (MemorySession session = MemorySession.openConfined()) {
            return api.extractLong(session, out -> api.SessionGetProfilingStartTimeNs.apply(address, out));
        }
    }

    @Override
    public Path endProfiling() {
        try (MemorySession session = MemorySession.openConfined()) {
            MemoryAddress path = api.create(session, out -> api.SessionEndProfiling.apply(address, ortAllocator, out));
            return Path.of(path.getUtf8String(0));
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

    static final class Builder implements Session.Builder {

        private static final MethodHandle CLOSE_LIBRARY;

        static {
            Addressable symbol;
            if (IS_WINDOWS) {
                System.loadLibrary("Kernel32");
                symbol = SymbolLookup.loaderLookup().lookup("FreeLibrary").get();
            } else {
                symbol = SymbolLookup.loaderLookup().lookup("dlclose").get();
            }
            CLOSE_LIBRARY = Linker.nativeLinker().downcallHandle(symbol, FunctionDescriptor.of(C_INT, C_POINTER));
        }

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

        private MemoryAddress newSessionOptions(MemorySession memorySession) {
            MemoryAddress sessionOptions = api.create(memorySession, out -> api.CreateSessionOptions.apply(out));
            memorySession.addCloseAction(() -> api.ReleaseSessionOptions.apply(sessionOptions));
            if (logSeverityLevel != null) {
                api.checkStatus(api.SetSessionLogSeverityLevel.apply(sessionOptions, logSeverityLevel.getNumber()));
            }
            if (logVerbosityLevel != null) {
                api.checkStatus(api.SetSessionLogVerbosityLevel.apply(sessionOptions, logVerbosityLevel));
            }
            if (loggerId != null) {
                api.checkStatus(api.SetSessionLogId.apply(
                        sessionOptions,
                        memorySession.allocateUtf8String(loggerId).address()));
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
            if (optimizedFilePath != null) {
                api.checkStatus(api.SetOptimizedModelFilePath.apply(
                        sessionOptions, createPath(memorySession, optimizedFilePath)));
            }
            if (profilingOutput != null) {
                api.checkStatus(api.EnableProfiling.apply(sessionOptions, createPath(memorySession, profilingOutput)));
            }
            if (config != null && !config.isEmpty()) {
                for (Map.Entry<String, String> entry : config.entrySet()) {
                    api.checkStatus(api.AddSessionConfigEntry.apply(
                            sessionOptions,
                            memorySession.allocateUtf8String(entry.getKey()).address(),
                            memorySession.allocateUtf8String(entry.getValue()).address()));
                }
            }

            LOG.log(Level.DEBUG, "Execution Providers: " + executionProviderAppenders);
            for (ExecutionProviderConfig executionProviderAppender : executionProviderAppenders.values()) {
                executionProviderAppender.appendToSessionOptions(memorySession, api, sessionOptions);
            }
            for (Path customOpsLibrary : customOpsLibraries) {
                LOG.log(Level.DEBUG, "Adding custom op library: " + customOpsLibrary);
                MemoryAddress libraryHandle = api.create(
                        memorySession,
                        out -> api.RegisterCustomOpsLibrary.apply(
                                sessionOptions,
                                memorySession
                                        .allocateUtf8String(customOpsLibrary
                                                .toAbsolutePath()
                                                .toString())
                                        .address(),
                                out));
                memorySession.addCloseAction(() -> {
                    closeLibrary(libraryHandle);
                });
            }
            return sessionOptions;
        }

        private static int closeLibrary(Addressable libraryHandler) {
            try {
                return (int) CLOSE_LIBRARY.invokeExact(libraryHandler);
            } catch (Throwable ex) {
                throw new AssertionError("should not reach here", ex);
            }
        }

        @Override
        public Session build() throws IOException {
            return new SessionImpl(this);
        }
    }
}
