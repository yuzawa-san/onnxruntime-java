/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

final class OnnxMapImpl extends OnnxValueImpl implements OnnxMap {

    private final Map<Object, OnnxValueImpl> data;
    private final MapInfo mapInfo;
    private final Class<?> keyClass;

    OnnxMapImpl(MapInfo mapInfo) {
        super(OnnxType.MAP);
        this.data = new LinkedHashMap<>();
        this.mapInfo = mapInfo;
        this.keyClass = getKeyClass(mapInfo.getKeyType());
    }

    private static Class<?> getKeyClass(OnnxTensorElementDataType type) {
        switch (type) {
            case INT8:
                return Byte.class;
            case INT16:
                return Short.class;
            case INT32:
                return Integer.class;
            case INT64:
                return Long.class;
            case STRING:
                return String.class;
            default:
                throw new UnsupportedOperationException("OnnxMap does not support keys of type " + type);
        }
    }
    
    public String toString() {
        return "{OnnxMap: info=" + mapInfo + ", data=" + data + "}";
    }

    public OnnxMap asMap() {
        return this;
    }

    public MapInfo getInfo() {
        return mapInfo;
    }

    private <T> OnnxValue put0(T key, Class<T> keyClass) {
        if (!this.keyClass.equals(keyClass)) {
            throw new IllegalArgumentException("OnnxMap expects keys of type " + this.keyClass);
        }
        return data.computeIfAbsent(key, k -> OnnxValueImpl.fromTypeInfo(mapInfo.getValueType()));
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
    public OnnxValue get(Byte key) {
        return put0(key, Byte.class);
    }

    @Override
    public OnnxValue get(Short key) {
        return put0(key, Short.class);
    }

    @Override
    public OnnxValue get(Integer key) {
        return put0(key, Integer.class);
    }

    @Override
    public OnnxValue get(Long key) {
        return put0(key, Long.class);
    }

    @Override
    public OnnxValue get(String key) {
        return put0(key, String.class);
    }
}
