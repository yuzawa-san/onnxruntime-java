/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.ByteBuffer;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

final class OnnxOpaqueImpl extends OnnxValueImpl implements OnnxOpaque {

    private ByteBuffer buffer;
    private final OpaqueInfo opaqueInfo;

    OnnxOpaqueImpl(OpaqueInfo opaqueInfo) {
        super(OnnxType.OPAQUE);
        this.opaqueInfo = opaqueInfo;
    }

    public OnnxOpaque asOpaque() {
        return this;
    }

    public OpaqueInfo getInfo() {
        return opaqueInfo;
    }

    public String toString() {
        return "{OnnxOpaque: info=" + opaqueInfo + ", buffer=" + buffer + "}";
    }

    @Override
    MemoryAddress toNative(ApiImpl api, MemoryAddress memoryInfo, SegmentAllocator allocator) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    void fromNative(ApiImpl api, MemoryAddress address, ResourceScope scope, SegmentAllocator allocator) {
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
