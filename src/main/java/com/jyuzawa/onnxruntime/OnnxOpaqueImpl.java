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

    //    @Override
    //    public OnnxOpaque asOpaque() {
    //        return this;
    //    }

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
            ApiImpl api,
            MemoryAddress ortAllocator,
            MemoryAddress memoryInfo,
            ResourceScope scope,
            SegmentAllocator allocator) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void fromNative(
            ApiImpl api,
            MemoryAddress ortAllocator,
            MemoryAddress address,
            ResourceScope scope,
            SegmentAllocator allocator) {
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
