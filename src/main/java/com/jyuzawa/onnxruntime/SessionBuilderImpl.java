/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static java.lang.foreign.ValueLayout.JAVA_BYTE;

import com.jyuzawa.onnxruntime.Session.Builder;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

final class SessionBuilderImpl implements Session.Builder {

    private final ApiImpl api;
    private final MemoryAddress environment;
    Path path;
    byte[] bytes;
    ByteBuffer buffer;

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
    public Session build() throws IOException {

        try (MemorySession allocator = MemorySession.openShared()) {

            final MemorySegment mappedBuf;
            if (buffer != null) {
                if (buffer.isDirect()) {
                    mappedBuf = MemorySegment.ofBuffer(buffer);

                } else {
                    mappedBuf = allocator.allocateArray(JAVA_BYTE, buffer.remaining());
                    mappedBuf.copyFrom(MemorySegment.ofBuffer(buffer));
                }
            } else if (bytes != null) {
                mappedBuf = allocator.allocateArray(JAVA_BYTE, bytes);
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
            // TODO: more session options
            MemoryAddress sessionOptions = api.create(allocator, out -> api.CreateSessionOptions.apply(out));
            // api.checkStatus(api.SetIntraOpNumThreads.apply(sessionOptions, 1));
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
