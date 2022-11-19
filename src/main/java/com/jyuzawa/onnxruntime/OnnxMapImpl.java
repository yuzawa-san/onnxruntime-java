/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

abstract class OnnxMapImpl<K, T extends OnnxTensorImpl> extends OnnxValueImpl implements OnnxMap, OnnxTypedMap<K> {

    private final Function<TensorInfoImpl, T> keyVectorFactory;
    private final Map<K, OnnxTensorImpl> data;
    private final Map<K, OnnxValue> unmodifiableData;
    protected final MapInfoImpl mapInfo;

    protected OnnxMapImpl(MapInfoImpl mapInfo, Function<TensorInfoImpl, T> keyVectorFactory) {
        super(OnnxType.MAP);
        this.keyVectorFactory = keyVectorFactory;
        this.data = new LinkedHashMap<>();
        this.unmodifiableData = Collections.unmodifiableMap(data);
        this.mapInfo = mapInfo;
    }

    static final OnnxValueImpl fromTypeInfo(MapInfoImpl mapInfo) {
        TypeInfo valueType = mapInfo.getValueType();
        if (valueType.getType() != OnnxType.TENSOR || valueType.getTensorInfo().getElementCount() != 1) {
            throw new UnsupportedOperationException("OnnxMap only supports scalar values");
        }
        OnnxTensorElementDataType type = mapInfo.getKeyType();
        switch (type) {
            case INT64:
                return new OnnxMapLongImpl(mapInfo);
            case STRING:
                return new OnnxMapStringImpl(mapInfo);
            default:
                throw new UnsupportedOperationException("OnnxMap does not support keys of type " + type);
        }
    }

    private final T newKeyVector(int size, SegmentAllocator scope) {
        return keyVectorFactory.apply(TensorInfoImpl.of(mapInfo.getKeyType(), size, scope));
    }

    private final OnnxTensorImpl newValueVector(int size, SegmentAllocator scope) {
        return OnnxTensorImpl.fromTypeInfo(
                TensorInfoImpl.of(mapInfo.getValueType().getTensorInfo().getType(), size, scope));
    }

    protected abstract void implodeKeyVector(T keyVector, Set<K> keys);

    protected abstract Stream<K> explodeKeyVector(T keyVector);

    @Override
    public final String toString() {
        return "{OnnxMap: info=" + mapInfo + ", data=" + data + "}";
    }

    @Override
    public final MapInfo getInfo() {
        return mapInfo;
    }

    @Override
    public final OnnxMap asMap() {
        return this;
    }

    private final NoSuchElementException fail() {
        return new NoSuchElementException("Invalid access of OnnxMap with key type " + mapInfo.getKeyType());
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
    public MemoryAddress toNative(
            ApiImpl api, MemoryAddress ortAllocator, MemoryAddress memoryInfo, SegmentAllocator allocator) {
        int size = data.size();
        T keyVector = newKeyVector(size, allocator);
        implodeKeyVector(keyVector, data.keySet());
        OnnxTensorImpl valueVector = OnnxTensorImpl.fromTypeInfo(
                TensorInfoImpl.of(mapInfo.getValueType().getTensorInfo().getType(), size, allocator));
        valueVector.putScalars(data.values());
        MemoryAddress keyAddress = keyVector.toNative(api, ortAllocator, memoryInfo, allocator);
        MemoryAddress valueAddress = valueVector.toNative(api, ortAllocator, memoryInfo, allocator);
        MemorySegment kvArray = allocator.allocateArray(C_POINTER, 2);
        kvArray.setAtIndex(C_POINTER, 0, keyAddress);
        kvArray.setAtIndex(C_POINTER, 1, valueAddress);
        return api.create(allocator, out -> api.CreateValue.apply(kvArray.address(), 2, OnnxType.MAP.getNumber(), out));
    }

    @Override
    public void fromNative(
            ApiImpl api,
            MemoryAddress ortAllocator,
            MemoryAddress address,
            SegmentAllocator allocator,
            MemorySession session) {
        MemoryAddress keyAddress = api.create(allocator, out -> api.GetValue.apply(address, 0, ortAllocator, out));
        MemoryAddress valueAddress = api.create(allocator, out -> api.GetValue.apply(address, 1, ortAllocator, out));
        MemoryAddress keyInfo = api.create(allocator, out -> api.GetTensorTypeAndShape.apply(keyAddress, out));
        int size =
                Math.toIntExact(api.extractLong(allocator, out -> api.GetTensorShapeElementCount.apply(keyInfo, out)));
        T keyVector = newKeyVector(size, allocator);
        OnnxTensorImpl valueVector = newValueVector(size, allocator);
        keyVector.fromNative(api, ortAllocator, keyAddress, allocator, session);
        valueVector.fromNative(api, ortAllocator, valueAddress, allocator, session);
        valueVector.getScalars(explodeKeyVector(keyVector).map(this::set));
    }

    @Override
    public final OnnxTensorImpl set(K key) {
        OnnxTensorImpl input =
                OnnxTensorImpl.fromTypeInfo(mapInfo.getValueType().getTensorInfo());
        data.put(key, input);
        return input;
    }

    @Override
    public final OnnxValue put(K key, OnnxValue value) {
        return unmodifiableData.put(key, value);
    }

    @Override
    public final void putAll(Map<? extends K, ? extends OnnxValue> m) {
        unmodifiableData.putAll(m);
    }

    @Override
    public final int size() {
        return unmodifiableData.size();
    }

    @Override
    public final boolean isEmpty() {
        return unmodifiableData.isEmpty();
    }

    @Override
    public final boolean containsKey(Object key) {
        return unmodifiableData.containsKey(key);
    }

    @Override
    public final boolean containsValue(Object value) {
        return unmodifiableData.containsValue(value);
    }

    @Override
    public final OnnxValue get(Object key) {
        return unmodifiableData.get(key);
    }

    @Override
    public final OnnxValue remove(Object key) {
        return unmodifiableData.remove(key);
    }

    @Override
    public final void clear() {
        unmodifiableData.clear();
    }

    @Override
    public final Set<K> keySet() {
        return unmodifiableData.keySet();
    }

    @Override
    public final Collection<OnnxValue> values() {
        return unmodifiableData.values();
    }

    @Override
    public final Set<Entry<K, OnnxValue>> entrySet() {
        return unmodifiableData.entrySet();
    }
}
