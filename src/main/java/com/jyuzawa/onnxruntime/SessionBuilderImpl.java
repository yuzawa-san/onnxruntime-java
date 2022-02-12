/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import com.jyuzawa.onnxruntime.Session.Builder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

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

        try (ResourceScope scope = ResourceScope.newConfinedScope(); ) {
            SegmentAllocator allocator = SegmentAllocator.ofScope(scope);
            final MemorySegment mappedBuf;
            if (buffer != null) {
                if (buffer.isDirect()) {
                    mappedBuf = MemorySegment.ofByteBuffer(buffer);
                } else {
                    mappedBuf = allocator.allocateArray(CLinker.C_CHAR, buffer.remaining());
                    mappedBuf.copyFrom(MemorySegment.ofByteBuffer(buffer));
                }
            } else if (bytes != null) {
                mappedBuf = allocator.allocateArray(CLinker.C_CHAR, bytes);
            } else if (path != null) {
                long size = Files.size(path);
                mappedBuf = MemorySegment.mapFile(path, 0, size, FileChannel.MapMode.READ_ONLY, scope);
            } else {
                throw new IllegalArgumentException("missing model source");
            }

            MemoryAddress sessionOptions = api.create(allocator, out -> api.CreateSessionOptions.apply(out));
            api.checkStatus(api.SetIntraOpNumThreads.apply(sessionOptions, 1));
            scope.addCloseAction(() -> {
                api.ReleaseSessionOptions.apply(sessionOptions);
            });

            ResourceScope sessionScope = ResourceScope.newConfinedScope();
            SegmentAllocator sessionAllocator = SegmentAllocator.ofScope(sessionScope);

            MemoryAddress session = api.create(
                    sessionAllocator,
                    out -> api.CreateSessionFromArray.apply(
                            environment, mappedBuf.address(), mappedBuf.byteSize(), sessionOptions, out));
            sessionScope.addCloseAction(() -> {
                api.ReleaseSession.apply(session);
            });

            return new SessionImpl(api, sessionScope, session);
        }
    }
}
