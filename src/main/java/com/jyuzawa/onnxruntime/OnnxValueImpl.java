/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;
import java.util.NoSuchElementException;

abstract class OnnxValueImpl implements OnnxValue {

    protected OnnxType type;

    protected OnnxValueImpl(OnnxType type) {
        this.type = type;
    }

    @Override
    public final OnnxType getType() {
        return type;
    }

    @Override
    public OnnxTensor asTensor() {
        throw new NoSuchElementException("OnnxValue is not a tensor");
    }

    @Override
    public OnnxSequence asSequence() {
        throw new NoSuchElementException("OnnxValue is not a sequence");
    }

    @Override
    public OnnxMap asMap() {
        throw new NoSuchElementException("OnnxValue is not a map");
    }

    // @Override
    // public OnnxOpaque asOpaque() {
    // throw new NoSuchElementException("OnnxValue is not an opaque");
    // }
    //
    // @Override
    // public OnnxSparseTensor asSparseTensor() {
    // throw new NoSuchElementException("OnnxValue is not a sparse tensor");
    // }
    //
    // @Override
    // public OnnxOptional asOptional() {
    // throw new NoSuchElementException("OnnxValue is not an optional");
    // }

    abstract MemoryAddress toNative(
            ApiImpl api, MemoryAddress ortAllocator, MemoryAddress memoryInfo, MemorySession scope);

    abstract void fromNative(ApiImpl api, MemoryAddress ortAllocator, MemoryAddress address, MemorySession scope);

    static final OnnxValueImpl fromTypeInfo(TypeInfoImpl typeInfo) {
        OnnxType type = typeInfo.getType();
        switch (type) {
            case TENSOR:
                return OnnxTensorImpl.fromTypeInfo(typeInfo.getTensorInfo());
            case SEQUENCE:
                return new OnnxSequenceImpl(typeInfo.getSequenceInfo());
            case MAP:
                return OnnxMapImpl.fromTypeInfo(typeInfo.getMapInfo());
                // case OPAQUE:
                // return new OnnxOpaqueImpl(typeInfo.getOpaqueInfo());
                // case OPTIONAL:
                // return new OnnxOptionalImpl(typeInfo.getOptionalInfo());
            default:
                throw new UnsupportedOperationException("OnnxValue with type " + type + " is not supported");
        }
    }
}
