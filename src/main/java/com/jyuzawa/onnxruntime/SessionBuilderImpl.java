/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_CHAR;

import com.jyuzawa.onnxruntime.Session.Builder;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.Map;

final class SessionBuilderImpl implements Session.Builder {

    private final ApiImpl api;
    private final MemoryAddress environment;
    private Path path;
    private byte[] bytes;
    private ByteBuffer buffer;
    private OnnxRuntimeLoggingLevel logSeverityLevel;
    private Integer logVerbosityLevel;
    private String loggerId;
    private Boolean memoryPatternOptimization;
    private Boolean cpuArena;
    private Map<String, String> config;
    private Integer interOpNumThreads;
    private Integer intraOpNumThreads;
    private File optimizedFilePath;
    private File profilingOutput;
    private boolean disablePerSessionThreads;
    private OnnxRuntimeExecutionMode executionMode;
    private OnnxRuntimeOptimizationLevel optimizationLevel;

    SessionBuilderImpl(ApiImpl api, MemoryAddress environment) {
        this.api = api;
        this.environment = environment;
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
    public Session.Builder enableProfiling(File filePath) {
        this.profilingOutput = filePath;
        return this;
    }

    @Override
    public Session.Builder setOptimizedModelFilePath(File outputPath) {
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
    public Session.Builder setLoggerId(String loggerId) {
        this.loggerId = loggerId;
        return this;
    }

    @Override
    public Session.Builder setMemoryPatternOptimization(boolean memoryPatternOptimization) {
        this.memoryPatternOptimization = memoryPatternOptimization;
        return this;
    }

    @Override
    public Session.Builder setSessionConfigMap(Map<String, String> config) {
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
    public Session.Builder setCpuMemoryArena(boolean useMemoryArena) {
        this.cpuArena = useMemoryArena;
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
        if (cpuArena != null) {
            if (cpuArena) {
                api.checkStatus(api.EnableCpuMemArena.apply(sessionOptions));
            } else {
                api.checkStatus(api.DisableCpuMemArena.apply(sessionOptions));
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
                            .allocateUtf8String(optimizedFilePath.getAbsolutePath())
                            .address()));
        }
        if (profilingOutput != null) {
            api.checkStatus(api.EnableProfiling.apply(
                    sessionOptions,
                    allocator
                            .allocateUtf8String(optimizedFilePath.getAbsolutePath())
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

        return sessionOptions;
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
