/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

abstract class OnnxMapImpl<K> extends OnnxValueImpl implements OnnxMap, OnnxTypedMap<K> {

    private final Map<K, OnnxValueImpl> data;
    private final MapInfo mapInfo;

    protected OnnxMapImpl(MapInfo mapInfo) {
        super(OnnxType.MAP);
        this.data = new LinkedHashMap<>();
        this.mapInfo = mapInfo;
    }

    static final OnnxValueImpl fromTypeInfo(MapInfo mapInfo) {
        OnnxTensorElementDataType type = mapInfo.getKeyType();
        switch (type) {
            case INT8:
                return new OnnxMapByteImpl(mapInfo);
            case INT16:
                return new OnnxMapShortImpl(mapInfo);
            case INT32:
                return new OnnxMapIntImpl(mapInfo);
            case INT64:
                return new OnnxMapLongImpl(mapInfo);
            case STRING:
                return new OnnxMapStringImpl(mapInfo);
            default:
                throw new UnsupportedOperationException("OnnxMap does not support keys of type " + type);
        }
    }

    @Override
    public final String toString() {
        return "{OnnxMap: info=" + mapInfo + ", data=" + data + "}";
    }

    @Override
    public final MapInfo getInfo() {
        return mapInfo;
    }

    private final NoSuchElementException fail() {
        return new NoSuchElementException("Invalid access of OnnxMap with key type " + mapInfo.getKeyType());
    }

    @Override
    public OnnxTypedMap<Byte> asByteMap() {
        throw fail();
    }

    @Override
    public OnnxTypedMap<Short> asShortMap() {
        throw fail();
    }

    @Override
    public OnnxTypedMap<Integer> asIntegerMap() {
        throw fail();
    }

    @Override
    public OnnxTypedMap<Long> asLongMap() {
        throw fail();
    }

    @Override
    public OnnxTypedMap<String> asStringMap() {
        throw fail();
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
    public final OnnxValue put(K key) {
        OnnxValueImpl input = OnnxValueImpl.fromTypeInfo(mapInfo.getValueType());
        data.put(key, input);
        return input;
    }

    private final Map<K, OnnxValue> unmodifiableMap() {
        return Collections.unmodifiableMap(data);
    }

    @Override
    public final int size() {
        return data.size();
    }

    @Override
    public final boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public final boolean containsKey(Object key) {
        return data.containsKey(key);
    }

    @Override
    public final boolean containsValue(Object value) {
        return data.containsValue(value);
    }

    @Override
    public final OnnxValue get(Object key) {
        return data.get(key);
    }

    @Override
    public final OnnxValue remove(Object key) {
        return data.remove(key);
    }

    @Override
    public final void clear() {
        data.clear();
    }

    @Override
    public final Set<K> keySet() {
        return unmodifiableMap().keySet();
    }

    @Override
    public final Collection<OnnxValue> values() {
        return unmodifiableMap().values();
    }

    @Override
    public final Set<Entry<K, OnnxValue>> entrySet() {
        return unmodifiableMap().entrySet();
    }
}
