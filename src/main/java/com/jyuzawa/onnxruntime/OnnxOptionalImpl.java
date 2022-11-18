/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;
import java.util.NoSuchElementException;

final class OnnxOptionalImpl extends OnnxValueImpl implements OnnxOptional {

    private OnnxValueImpl data;
    private final TypeInfoImpl typeInfo;

    OnnxOptionalImpl(TypeInfoImpl typeInfo) {
        super(OnnxType.OPTIONAL);
        this.typeInfo = typeInfo;
    }

    @Override
    public String toString() {
        return "{OnnxOptional: info=" + typeInfo + ", data=" + data + "}";
    }

    // @Override
    // public OnnxOptional asOptional() {
    // return this;
    // }

    @Override
    public TypeInfo getInfo() {
        return typeInfo;
    }

    @Override
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
    public MemoryAddress toNative(
            ApiImpl api, MemoryAddress ortAllocator, MemoryAddress memoryInfo, MemorySession allocator) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void fromNative(ApiImpl api, MemoryAddress ortAllocator, MemoryAddress address, MemorySession allocator) {
        // TODO Auto-generated method stub

    }
}
