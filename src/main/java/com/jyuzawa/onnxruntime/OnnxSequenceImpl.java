/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

final class OnnxSequenceImpl extends OnnxValueImpl implements OnnxSequence {

    private final List<OnnxValueImpl> data;
    private final TypeInfo typeInfo;

    OnnxSequenceImpl(TypeInfo typeInfo) {
        super(OnnxType.SEQUENCE);
        this.data = new ArrayList<>();
        this.typeInfo = typeInfo;
    }
    
    public String toString() {
        return "{OnnxSequence: info=" + typeInfo + ", data=" + data + "}";
    }

    public OnnxSequence asSequence() {
        return this;
    }

    public TypeInfo getInfo() {
        return typeInfo;
    }

    @Override
    public OnnxValue add() {
        OnnxValueImpl item = OnnxValueImpl.fromTypeInfo(typeInfo);
        data.add(item);
        return item;
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
    public List<OnnxValue> getData() {
        return Collections.unmodifiableList(data);
    }
}
