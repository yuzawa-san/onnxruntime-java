/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_LONG;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.NoSuchElementException;

final class TypeInfoImpl implements TypeInfo {

    // TODO: denotation
    private final OnnxType type;
    private final TensorInfoImpl tensorInfo;
    private final MapInfoImpl mapInfo;
    private final TypeInfoImpl sequenceInfo;

    TypeInfoImpl(ApiImpl api, MemorySegment typeInfo, Arena arena, Arena sessionArena, MemorySegment ortAllocator) {
        try {
            this.type =
                    OnnxType.forNumber(api.extractInt(arena, out -> api.GetOnnxTypeFromTypeInfo.apply(typeInfo, out)));
            TensorInfoImpl tensorInfo = null;
            MapInfoImpl mapInfo = null;
            TypeInfoImpl sequenceInfo = null;

            if (type == OnnxType.TENSOR || type == OnnxType.SPARSETENSOR) {
                MemorySegment ortTensorInfo =
                        api.create(arena, out -> api.CastTypeInfoToTensorInfo.apply(typeInfo, out));
                OnnxTensorElementDataType dataType = OnnxTensorElementDataType.forNumber(
                        api.extractInt(arena, out -> api.GetTensorElementType.apply(ortTensorInfo, out)));
                int dimCount = api.extractInt(arena, out -> api.GetDimensionsCount.apply(ortTensorInfo, out));
                MemorySegment dims = sessionArena.allocate(C_LONG, dimCount);
                api.checkStatus(api.GetDimensions.apply(ortTensorInfo, dims, dimCount));
                long elementCount =
                        api.extractInt(arena, out -> api.GetTensorShapeElementCount.apply(ortTensorInfo, out));
                tensorInfo = new TensorInfoImpl(dataType, dims, dimCount, elementCount);
            } else if (type == OnnxType.MAP) {
                MemorySegment ortMapInfo = api.create(arena, out -> api.CastTypeInfoToMapTypeInfo.apply(typeInfo, out));
                OnnxTensorElementDataType keyType = OnnxTensorElementDataType.forNumber(
                        api.extractInt(arena, out -> api.GetMapKeyType.apply(ortMapInfo, out)));
                MemorySegment valueTypeAddress = api.create(arena, out -> api.GetMapValueType.apply(ortMapInfo, out));
                mapInfo = new MapInfoImpl(
                        keyType, new TypeInfoImpl(api, valueTypeAddress, arena, sessionArena, ortAllocator));
            } else if (type == OnnxType.SEQUENCE) {
                MemorySegment ortSequenceInfo =
                        api.create(arena, out -> api.CastTypeInfoToSequenceTypeInfo.apply(typeInfo, out));
                MemorySegment valueTypeAddress =
                        api.create(arena, out -> api.GetSequenceElementType.apply(ortSequenceInfo, out));
                sequenceInfo = new TypeInfoImpl(api, valueTypeAddress, arena, sessionArena, ortAllocator);
            } else {
                throw new UnsupportedOperationException("unsupported type: " + type);
            }
            this.tensorInfo = tensorInfo;
            this.mapInfo = mapInfo;
            this.sequenceInfo = sequenceInfo;
        } finally {
            api.ReleaseTypeInfo.apply(typeInfo);
        }
    }

    @Override
    public OnnxType getType() {
        return type;
    }

    @Override
    public TensorInfoImpl getTensorInfo() {
        if (tensorInfo == null) {
            throw new NoSuchElementException("tensor");
        }
        return tensorInfo;
    }

    @Override
    public MapInfoImpl getMapInfo() {
        if (mapInfo == null) {
            throw new NoSuchElementException("map");
        }
        return mapInfo;
    }

    @Override
    public String toString() {
        if (tensorInfo != null) {
            return tensorInfo.toString();
        } else if (mapInfo != null) {
            return mapInfo.toString();
        } else if (sequenceInfo != null) {
            return "sequence(" + sequenceInfo + ")";
        }
        return "{TypeInfo: type=" + type + "}";
    }

    @Override
    public TypeInfoImpl getSequenceInfo() {
        if (sequenceInfo == null) {
            throw new NoSuchElementException("sequence");
        }
        return sequenceInfo;
    }

    final OnnxValueImpl newValue(ValueContext valueContext, MemorySegment ortValueAddress) {
        switch (type) {
            case TENSOR:
                return tensorInfo.newValue(valueContext, ortValueAddress);
            case SEQUENCE:
                return new OnnxSequenceImpl(sequenceInfo, valueContext, ortValueAddress);
            case MAP:
                return mapInfo.newValue(valueContext, ortValueAddress);
                // case OPAQUE:
                // return new OnnxOpaqueImpl(typeInfo.getOpaqueInfo());
                // case OPTIONAL:
                // return new OnnxOptionalImpl(typeInfo.getOptionalInfo());
            default:
                throw new UnsupportedOperationException("OnnxValue with type " + type + " is not supported");
        }
    }
}
