/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
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
                return new OnnxTypedMapByteImpl(mapInfo);
            case INT16:
                return new OnnxTypedMapShortImpl(mapInfo);
            case INT32:
                return new OnnxTypedMapIntImpl(mapInfo);
            case INT64:
                return new OnnxTypedMapLongImpl(mapInfo);
            case STRING:
                return new OnnxTypedMapStringImpl(mapInfo);
            default:
                throw new UnsupportedOperationException("OnnxMap does not support keys of type " + type);
        }
    }

    @Override
    public final String toString() {
        return "{OnnxMap: info=" + mapInfo + ", data=" + data + "}";
    }

    @Override
    public final OnnxMap asMap() {
        return this;
    }

    @Override
    public final MapInfo getInfo() {
        return mapInfo;
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

    private final IllegalStateException fail() {
        return new IllegalStateException("Invalid access of OnnxMap with key type " + mapInfo.getKeyType());
    }

    @Override
    public OnnxTypedMap<Byte> withByteKeys() {
        throw fail();
    }

    @Override
    public OnnxTypedMap<Short> withShortKeys() {
        throw fail();
    }

    @Override
    public OnnxTypedMap<Integer> withIntegerKeys() {
        throw fail();
    }

    @Override
    public OnnxTypedMap<Long> withLongKeys() {
        throw fail();
    }

    @Override
    public OnnxTypedMap<String> withStringKeys() {
        throw fail();
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
