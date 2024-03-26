/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Stream;

abstract class OnnxMapImpl<K, T extends OnnxTensorImpl> extends OnnxValueImpl implements OnnxMap, OnnxTypedMap<K> {

    private final Map<K, OnnxTensorImpl> data;
    private final Map<K, OnnxValue> unmodifiableData;
    protected final MapInfoImpl mapInfo;

    protected OnnxMapImpl(MapInfoImpl mapInfo, ValueContext valueContext, MemorySegment ortValueAddress) {
        super(OnnxType.MAP, valueContext);
        this.data = new LinkedHashMap<>();
        this.mapInfo = mapInfo;
        if (ortValueAddress != null) {
            ApiImpl api = valueContext.api();
            SegmentAllocator allocator = valueContext.segmentAllocator();
            MemorySegment ortAllocator = valueContext.ortAllocatorAddress();
            MemorySegment keyAddress =
                    api.create(allocator, out -> api.GetValue.apply(ortValueAddress, 0, ortAllocator, out));
            valueContext.closeables().add(() -> api.ReleaseValue.apply(keyAddress));
            MemorySegment valueAddress =
                    api.create(allocator, out -> api.GetValue.apply(ortValueAddress, 1, ortAllocator, out));
            valueContext.closeables().add(() -> api.ReleaseValue.apply(valueAddress));
            MemorySegment keyInfo = api.create(allocator, out -> api.GetTensorTypeAndShape.apply(keyAddress, out));
            int size = Math.toIntExact(
                    api.extractLong(allocator, out -> api.GetTensorShapeElementCount.apply(keyInfo, out)));
            api.ReleaseTensorTypeAndShapeInfo.apply(keyInfo);
            T keyVector = newKeyVector(size, keyAddress);
            OnnxTensorImpl valueVector = newValueVector(size, valueAddress);
            valueVector.getScalars(explodeKeyVector(keyVector).map(this::set));
        }
        this.unmodifiableData = Collections.unmodifiableMap(data);
    }

    private final OnnxTensorImpl newValueVector(int size, MemorySegment valueAddress) {
        return TensorInfoImpl.of(
                        mapInfo.getValueType().getTensorInfo().getType(), size, valueContext.segmentAllocator())
                .newValue(valueContext, valueAddress);
    }

    private final T newKeyVector(int size, MemorySegment keyAddress) {
        return newKeyVector(TensorInfoImpl.of(mapInfo.getKeyType(), size, valueContext.segmentAllocator()), keyAddress);
    }

    protected abstract T newKeyVector(TensorInfoImpl tensorInfo, MemorySegment keyAddress);

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
    public MemorySegment toNative() {
        ApiImpl api = valueContext.api();
        SegmentAllocator allocator = valueContext.segmentAllocator();
        int size = data.size();
        T keyVector = newKeyVector(size, null);
        implodeKeyVector(keyVector, data.keySet());
        OnnxTensorImpl valueVector = TensorInfoImpl.of(
                        mapInfo.getValueType().getTensorInfo().getType(), size, allocator)
                .newValue(valueContext, null);
        valueVector.putScalars(data.values());
        MemorySegment kvArray = allocator.allocate(C_POINTER, 2);
        kvArray.setAtIndex(C_POINTER, 0, keyVector.toNative());
        kvArray.setAtIndex(C_POINTER, 1, valueVector.toNative());
        return api.create(allocator, out -> api.CreateValue.apply(kvArray, 2, OnnxType.MAP.getNumber(), out));
    }

    @Override
    public final OnnxTensorImpl set(K key) {
        OnnxTensorImpl input = mapInfo.getValueType().getTensorInfo().newValue(valueContext, null);
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
