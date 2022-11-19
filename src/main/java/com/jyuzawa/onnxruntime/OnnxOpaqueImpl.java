/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.nio.ByteBuffer;

final class OnnxOpaqueImpl extends OnnxValueImpl implements OnnxOpaque {

    private ByteBuffer buffer;
    private final OpaqueInfo opaqueInfo;

    OnnxOpaqueImpl(OpaqueInfo opaqueInfo) {
        super(OnnxType.OPAQUE);
        this.opaqueInfo = opaqueInfo;
    }

    // @Override
    // public OnnxOpaque asOpaque() {
    // return this;
    // }

    @Override
    public OpaqueInfo getInfo() {
        return opaqueInfo;
    }

    @Override
    public String toString() {
        return "{OnnxOpaque: info=" + opaqueInfo + ", buffer=" + buffer + "}";
    }

    @Override
    public MemoryAddress toNative(
            ApiImpl api, MemoryAddress ortAllocator, MemoryAddress memoryInfo, SegmentAllocator allocator) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void fromNative(
            ApiImpl api,
            MemoryAddress ortAllocator,
            MemoryAddress address,
            SegmentAllocator allocator,
            MemorySession session) {
        // TODO Auto-generated method stub

    }

    @Override
    public void set(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public ByteBuffer get() {
        return buffer;
    }
}
