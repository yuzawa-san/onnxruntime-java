/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

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
    public final boolean isTensor() {
        return type == OnnxType.TENSOR;
    }

    @Override
    public OnnxTensor asTensor() {
        throw new IllegalStateException("OnnxValue is not a tensor");
    }

    @Override
    public final boolean isSequence() {
        return type == OnnxType.SEQUENCE;
    }

    @Override
    public OnnxSequence asSequence() {
        throw new IllegalStateException("OnnxValue is not a sequence");
    }

    @Override
    public final boolean isMap() {
        return type == OnnxType.MAP;
    }

    @Override
    public OnnxMap<Byte> asByteMap() {
        throw new IllegalStateException("OnnxValue is not a map with byte keys.");
    }

    @Override
    public OnnxMap<Short> asShortMap() {
        throw new IllegalStateException("OnnxValue is not a map with short keys.");
    }

    @Override
    public OnnxMap<Integer> asIntegerMap() {
        throw new IllegalStateException("OnnxValue is not a map with integer keys.");
    }

    @Override
    public OnnxMap<Long> asLongMap() {
        throw new IllegalStateException("OnnxValue is not a map with long keys.");
    }

    @Override
    public OnnxMap<String> asStringMap() {
        throw new IllegalStateException("OnnxValue is not a map with string keys.");
    }

    @Override
    public final boolean isOpaque() {
        return type == OnnxType.OPAQUE;
    }

    @Override
    public OnnxOpaque asOpaque() {
        throw new IllegalStateException("OnnxValue is not an opaque");
    }

    @Override
    public final boolean isSparseTensor() {
        return type == OnnxType.SPARSETENSOR;
    }

    @Override
    public OnnxSparseTensor asSparseTensor() {
        throw new IllegalStateException("OnnxValue is not a sparse tensor");
    }

    @Override
    public final boolean isOptional() {
        return type == OnnxType.OPTIONAL;
    }

    @Override
    public OnnxOptional asOptional() {
        throw new IllegalStateException("OnnxValue is not an optional");
    }

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
            case OPAQUE:
                return new OnnxOpaqueImpl(typeInfo.getOpaqueInfo());
            case OPTIONAL:
                return new OnnxOptionalImpl(typeInfo.getOptionalInfo());
            default:
                throw new UnsupportedOperationException("OnnxValue with type " + type + " is not supported");
        }
    }
}
