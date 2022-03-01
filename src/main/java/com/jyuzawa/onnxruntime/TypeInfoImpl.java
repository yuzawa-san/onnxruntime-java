/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static jdk.incubator.foreign.CLinker.C_LONG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

final class TypeInfoImpl implements TypeInfo {

    // TODO: denotation
    private final OnnxType type;
    private final TensorInfo tensorInfo;
    private final MapInfo mapInfo;
    private final TypeInfo sequenceInfo;

    TypeInfoImpl(ApiImpl api, MemoryAddress typeInfo, MemoryAddress ortAllocator) {
        try (ResourceScope scope = ResourceScope.newConfinedScope()) {
            scope.addCloseAction(() -> {
                api.ReleaseTypeInfo.apply(typeInfo);
            });
            SegmentAllocator allocator = SegmentAllocator.ofScope(scope);
            this.type = OnnxType.forNumber(
                    api.extractInt(allocator, out -> api.GetOnnxTypeFromTypeInfo.apply(typeInfo, out)));
            TensorInfo tensorInfo = null;
            MapInfo mapInfo = null;
            TypeInfo sequenceInfo = null;

            if (type == OnnxType.TENSOR || type == OnnxType.SPARSETENSOR) {
                MemoryAddress ortTensorInfo =
                        api.create(allocator, out -> api.CastTypeInfoToTensorInfo.apply(typeInfo, out));
                OnnxTensorElementDataType dataType = OnnxTensorElementDataType.forNumber(
                        api.extractInt(allocator, out -> api.GetTensorElementType.apply(ortTensorInfo, out)));
                int dimCount = api.extractInt(allocator, out -> api.GetDimensionsCount.apply(ortTensorInfo, out));
                MemorySegment dims = allocator.allocateArray(C_LONG, dimCount);
                api.checkStatus(api.GetDimensions.apply(ortTensorInfo, dims.address(), dimCount));
                long elementCount =
                        api.extractInt(allocator, out -> api.GetTensorShapeElementCount.apply(ortTensorInfo, out));
                List<Long> shape = new ArrayList<>(dimCount);
                for (long value : dims.toLongArray()) {
                    shape.add(value);
                }
                tensorInfo = new TensorInfoImpl(dataType, Collections.unmodifiableList(shape), elementCount);
            } else if (type == OnnxType.MAP) {
                MemoryAddress ortMapInfo =
                        api.create(allocator, out -> api.CastTypeInfoToMapTypeInfo.apply(typeInfo, out));
                OnnxTensorElementDataType keyType = OnnxTensorElementDataType.forNumber(
                        api.extractInt(allocator, out -> api.GetMapKeyType.apply(ortMapInfo, out)));
                MemoryAddress valueTypeAddress =
                        api.create(allocator, out -> api.GetMapValueType.apply(ortMapInfo, out));
                mapInfo = new MapInfoImpl(keyType, new TypeInfoImpl(api, valueTypeAddress, ortAllocator));
            } else if (type == OnnxType.SEQUENCE) {
                MemoryAddress ortSequenceInfo =
                        api.create(allocator, out -> api.CastTypeInfoToSequenceTypeInfo.apply(typeInfo, out));
                MemoryAddress valueTypeAddress =
                        api.create(allocator, out -> api.GetSequenceElementType.apply(ortSequenceInfo, out));
                sequenceInfo = new TypeInfoImpl(api, valueTypeAddress, ortAllocator);
            } else {
                throw new UnsupportedOperationException("unsupported type: " + type);
            }
            this.tensorInfo = tensorInfo;
            this.mapInfo = mapInfo;
            this.sequenceInfo = sequenceInfo;
        }
    }

    @Override
    public OnnxType getType() {
        return type;
    }

    @Override
    public TensorInfo getTensorInfo() {
        if (tensorInfo == null) {
            throw new NoSuchElementException("tensor");
        }
        return tensorInfo;
    }

    @Override
    public MapInfo getMapInfo() {
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
    public TypeInfo getSequenceInfo() {
        if (sequenceInfo == null) {
            throw new NoSuchElementException("sequence");
        }
        return sequenceInfo;
    }
}
