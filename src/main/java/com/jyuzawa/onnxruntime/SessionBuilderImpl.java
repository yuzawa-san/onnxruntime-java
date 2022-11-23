/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_CHAR;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_INT;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import com.jyuzawa.onnxruntime.Session.Builder;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.foreign.Addressable;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class SessionBuilderImpl implements Session.Builder {

    private static final MethodHandle CLOSE_LIBRARY = Linker.nativeLinker()
            .downcallHandle(
                    SymbolLookup.loaderLookup().lookup("dlclose").orElseGet(() -> SymbolLookup.loaderLookup()
                            .lookup("_FreeLibrary@4")
                            .get()),
                    FunctionDescriptor.of(C_INT, C_POINTER));

    private final ApiImpl api;
    private final MemoryAddress environment;
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

    SessionBuilderImpl(ApiImpl api, MemoryAddress environment) {
        this.api = api;
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
    public Session.Builder setPath(Path path) {
        this.path = path;
        return this;
    }

    @Override
    public Session.Builder setByteBuffer(ByteBuffer buffer) {
        this.buffer = buffer;
        return this;
    }

    @Override
    public Session.Builder setProfilingOutputPath(Path outputPathPrefix) {
        this.profilingOutput = outputPathPrefix;
        return this;
    }

    @Override
    public Session.Builder setOptimizationOutputPath(Path outputPath) {
        this.optimizedFilePath = outputPath;
        return this;
    }

    @Override
    public Session.Builder disablePerSessionThreads() {
        this.disablePerSessionThreads = true;
        return this;
    }

    @Override
    public Session.Builder setExecutionMode(OnnxRuntimeExecutionMode mode) {
        this.executionMode = mode;
        return this;
    }

    @Override
    public Session.Builder setOptimizationLevel(OnnxRuntimeOptimizationLevel level) {
        this.optimizationLevel = level;
        return this;
    }

    @Override
    public Session.Builder setLogSeverityLevel(OnnxRuntimeLoggingLevel level) {
        this.logSeverityLevel = level;
        return this;
    }

    @Override
    public Session.Builder setLogVerbosityLevel(int level) {
        this.logVerbosityLevel = level;
        return this;
    }

    @Override
    public Session.Builder setLogId(String loggerId) {
        this.loggerId = loggerId;
        return this;
    }

    @Override
    public Session.Builder setMemoryPatternOptimization(boolean memoryPatternOptimization) {
        this.memoryPatternOptimization = memoryPatternOptimization;
        return this;
    }

    @Override
    public Session.Builder setConfigMap(Map<String, String> config) {
        this.config = config;
        return this;
    }

    @Override
    public Session.Builder setInterOpNumThreads(int numThreads) {
        this.interOpNumThreads = numThreads;
        return this;
    }

    @Override
    public Session.Builder setIntraOpNumThreads(int numThreads) {
        this.intraOpNumThreads = numThreads;
        return this;
    }

    @Override
    public Session.Builder addProvider(ExecutionProvider provider, Map<String, String> properties) {
        if (!provider.isSupported()) {
            throw new UnsupportedOperationException("Provider " + provider + " not implemented.");
        }
        this.executionProviderAppenders.put(provider, provider.factory.apply(properties));
        return this;
    }

    @Override
    public Session.Builder addCustomOpsLibrary(Path path) {
        this.customOpsLibraries.add(path);
        return this;
    }

    private MemoryAddress newSessionOptions(MemorySession allocator) {
        MemoryAddress sessionOptions = api.create(allocator, out -> api.CreateSessionOptions.apply(out));

        if (logSeverityLevel != null) {
            api.checkStatus(api.SetSessionLogSeverityLevel.apply(sessionOptions, logSeverityLevel.getNumber()));
        }
        if (logVerbosityLevel != null) {
            api.checkStatus(api.SetSessionLogVerbosityLevel.apply(sessionOptions, logVerbosityLevel));
        }
        if (loggerId != null) {
            api.checkStatus(api.SetSessionLogId.apply(
                    sessionOptions, allocator.allocateUtf8String(loggerId).address()));
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
            api.checkStatus(api.SetSessionGraphOptimizationLevel.apply(sessionOptions, optimizationLevel.getNumber()));
        }
        if (optimizedFilePath != null) {
            api.checkStatus(api.SetOptimizedModelFilePath.apply(
                    sessionOptions,
                    allocator
                            .allocateUtf8String(
                                    optimizedFilePath.toAbsolutePath().toString())
                            .address()));
        }
        if (profilingOutput != null) {
            api.checkStatus(api.EnableProfiling.apply(
                    sessionOptions,
                    allocator
                            .allocateUtf8String(profilingOutput.toAbsolutePath().toString())
                            .address()));
        }
        if (config != null && !config.isEmpty()) {
            for (Map.Entry<String, String> entry : config.entrySet()) {
                api.checkStatus(api.AddSessionConfigEntry.apply(
                        sessionOptions,
                        allocator.allocateUtf8String(entry.getKey()).address(),
                        allocator.allocateUtf8String(entry.getValue()).address()));
            }
        }
        for (ExecutionProviderConfig executionProviderAppender : executionProviderAppenders.values()) {
            executionProviderAppender.appendToSessionOptions(allocator, api, sessionOptions);
        }
        for (Path customOpsLibrary : customOpsLibraries) {
            MemoryAddress libraryHandle = api.create(
                    allocator,
                    out -> api.RegisterCustomOpsLibrary.apply(
                            sessionOptions,
                            allocator
                                    .allocateUtf8String(
                                            customOpsLibrary.toAbsolutePath().toString())
                                    .address(),
                            out));
            allocator.addCloseAction(() -> {
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

        try (MemorySession allocator = MemorySession.openConfined()) {

            final MemorySegment mappedBuf;
            if (buffer != null) {
                if (buffer.isDirect()) {
                    mappedBuf = MemorySegment.ofBuffer(buffer);

                } else {
                    mappedBuf = allocator.allocateArray(C_CHAR, buffer.remaining());
                    mappedBuf.copyFrom(MemorySegment.ofBuffer(buffer));
                }
            } else if (bytes != null) {
                mappedBuf = allocator.allocateArray(C_CHAR, bytes);
            } else if (path != null) {
                try (RandomAccessFile file = new RandomAccessFile(path.toFile(), "r")) {
                    FileChannel fileChannel = file.getChannel();
                    long size = fileChannel.size();
                    MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, size);
                    mappedBuf = MemorySegment.ofBuffer(mappedByteBuffer);
                }
            } else {
                throw new IllegalArgumentException("missing model source");
            }

            MemoryAddress sessionOptions = newSessionOptions(allocator);
            allocator.addCloseAction(() -> {
                api.ReleaseSessionOptions.apply(sessionOptions);
            });

            MemorySession sessionAllocator = MemorySession.openShared();

            MemoryAddress session = api.create(
                    sessionAllocator,
                    out -> api.CreateSessionFromArray.apply(
                            environment, mappedBuf.address(), mappedBuf.byteSize(), sessionOptions, out));
            sessionAllocator.addCloseAction(() -> {
                api.ReleaseSession.apply(session);
            });

            return new SessionImpl(api, sessionAllocator, session);
        }
    }
}
