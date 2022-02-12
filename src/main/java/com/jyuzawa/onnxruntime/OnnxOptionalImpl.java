/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.util.NoSuchElementException;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

final class OnnxOptionalImpl extends OnnxValueImpl implements OnnxOptional {

    private OnnxValueImpl data;
    private final TypeInfo typeInfo;

    OnnxOptionalImpl(TypeInfo typeInfo) {
        super(OnnxType.OPTIONAL);
        this.typeInfo = typeInfo;
    }

    public String toString() {
        return "{OnnxOptional: info=" + typeInfo + ", data=" + data + "}";
    }

    public OnnxOptional asOptional() {
        return this;
    }

    public TypeInfo getInfo() {
        return typeInfo;
    }

    public boolean isPresent() {
        return data != null;
    }

    @Override
    public OnnxValue get() {
        if (data == null) {
            throw new NoSuchElementException();
        }
        return data;
    }

    @Override
    public OnnxValue set() {
        OnnxValueImpl item = OnnxValueImpl.fromTypeInfo(typeInfo);
        this.data = item;
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
}
