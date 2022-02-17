/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import static jdk.incubator.foreign.CLinker.C_POINTER;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;
import jdk.incubator.foreign.Addressable;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

abstract class OnnxMapImpl<K, T extends OnnxTensorImpl> extends OnnxValueImpl implements OnnxMap, OnnxTypedMap<K> {

    private final Function<TensorInfo, T> keyVectorFactory;
    private final Map<K, OnnxTensorImpl> data;
    private final Map<K, OnnxValue> unmodifiableData;
    protected final MapInfo mapInfo;

    protected OnnxMapImpl(MapInfo mapInfo, Function<TensorInfo, T> keyVectorFactory) {
        super(OnnxType.MAP);
        this.keyVectorFactory = keyVectorFactory;
        this.data = new LinkedHashMap<>();
        this.unmodifiableData = Collections.unmodifiableMap(data);
        this.mapInfo = mapInfo;
    }

    static final OnnxValueImpl fromTypeInfo(MapInfo mapInfo) {
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

    private final T newKeyVector(int size) {
        return keyVectorFactory.apply(new TensorInfoImpl(mapInfo.getKeyType(), size));
    }

    private final OnnxTensorImpl newValueVector(int size) {
        return OnnxTensorImpl.fromTypeInfo(
                new TensorInfoImpl(mapInfo.getValueType().getTensorInfo().getType(), size));
    }

    protected abstract void implodeKeyVector(T keyVector, Set<K> keys);

    protected abstract List<K> explodeKeyVector(T keyVector);

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
            ApiImpl api,
            MemoryAddress ortAllocator,
            MemoryAddress memoryInfo,
            ResourceScope scope,
            SegmentAllocator allocator) {
        int size = data.size();
        T keyVector = newKeyVector(size);
        implodeKeyVector(keyVector, data.keySet());
        OnnxTensorImpl valueVector = OnnxTensorImpl.fromTypeInfo(
                new TensorInfoImpl(mapInfo.getValueType().getTensorInfo().getType(), size));
        valueVector.putScalars(data.values());
        MemoryAddress keyAddress = keyVector.toNative(api, ortAllocator, memoryInfo, scope, allocator);
        MemoryAddress valueAddress = valueVector.toNative(api, ortAllocator, memoryInfo, scope, allocator);
        MemorySegment kvArray = allocator.allocateArray(C_POINTER, new Addressable[] {keyAddress, valueAddress});
        return api.create(allocator, out -> api.CreateValue.apply(kvArray.address(), 2, OnnxType.MAP.getNumber(), out));
    }

    @Override
    public void fromNative(
            ApiImpl api,
            MemoryAddress ortAllocator,
            MemoryAddress address,
            ResourceScope scope,
            SegmentAllocator allocator) {
        MemoryAddress keyAddress = api.create(allocator, out -> api.GetValue.apply(address, 0, ortAllocator, out));
        MemoryAddress valueAddress = api.create(allocator, out -> api.GetValue.apply(address, 1, ortAllocator, out));
        MemoryAddress keyInfo = api.create(allocator, out -> api.GetTensorTypeAndShape.apply(keyAddress, out));
        int size =
                Math.toIntExact(api.extractLong(allocator, out -> api.GetTensorShapeElementCount.apply(keyInfo, out)));
        T keyVector = newKeyVector(size);
        OnnxTensorImpl valueVector = newValueVector(size);
        keyVector.fromNative(api, ortAllocator, keyAddress, scope, allocator);
        valueVector.fromNative(api, ortAllocator, valueAddress, scope, allocator);
        List<OnnxTensorImpl> values = new ArrayList<>(size);
        for (K key : explodeKeyVector(keyVector)) {
            values.add(set(key));
        }
        valueVector.getScalars(values);
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
