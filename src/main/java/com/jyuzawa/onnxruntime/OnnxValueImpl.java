/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.util.NoSuchElementException;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

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

    //    @Override
    //    public OnnxOpaque asOpaque() {
    //        throw new NoSuchElementException("OnnxValue is not an opaque");
    //    }
    //
    //    @Override
    //    public OnnxSparseTensor asSparseTensor() {
    //        throw new NoSuchElementException("OnnxValue is not a sparse tensor");
    //    }
    //
    //    @Override
    //    public OnnxOptional asOptional() {
    //        throw new NoSuchElementException("OnnxValue is not an optional");
    //    }

    abstract MemoryAddress toNative(ApiImpl api, MemoryAddress memoryInfo, SegmentAllocator allocator);

    abstract void fromNative(ApiImpl api, MemoryAddress address, ResourceScope scope, SegmentAllocator allocator);

    static final OnnxValueImpl fromTypeInfo(TypeInfo typeInfo) {
        OnnxType type = typeInfo.getType();
        switch (type) {
            case TENSOR:
                return OnnxTensorImpl.fromTypeInfo(typeInfo.getTensorInfo());
            case SEQUENCE:
                return new OnnxSequenceImpl(typeInfo.getSequenceInfo());
            case MAP:
                return OnnxMapImpl.fromTypeInfo(typeInfo.getMapInfo());
                //            case OPAQUE:
                //                return new OnnxOpaqueImpl(typeInfo.getOpaqueInfo());
                //            case OPTIONAL:
                //                return new OnnxOptionalImpl(typeInfo.getOptionalInfo());
            default:
                throw new UnsupportedOperationException("OnnxValue with type " + type + " is not supported");
        }
    }
}
