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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

final class OnnxSequenceImpl extends OnnxValueImpl implements OnnxSequence {

    private final List<OnnxValueImpl> data;
    private final List<OnnxValue> unmodifiableData;
    private final TypeInfoImpl typeInfo;

    OnnxSequenceImpl(TypeInfoImpl typeInfo) {
        super(OnnxType.SEQUENCE);
        this.data = new ArrayList<>();
        this.unmodifiableData = Collections.unmodifiableList(data);
        this.typeInfo = typeInfo;
    }

    @Override
    public String toString() {
        return "{OnnxSequence: info=" + typeInfo + ", data=" + data + "}";
    }

    @Override
    public OnnxSequence asSequence() {
        return this;
    }

    @Override
    public TypeInfo getInfo() {
        return typeInfo;
    }

    private OnnxValueImpl newItem() {
        return OnnxValueImpl.fromTypeInfo(typeInfo);
    }

    @Override
    public OnnxValue add() {
        OnnxValueImpl item = newItem();
        data.add(item);
        return item;
    }

    @Override
    public MemoryAddress toNative(
            ApiImpl api, MemoryAddress ortAllocator, MemoryAddress memoryInfo, SegmentAllocator allocator) {
        int size = data.size();
        MemorySegment valuesArray = allocator.allocateArray(C_POINTER, size);
        for (int i = 0; i < size; i++) {
            OnnxValueImpl value = data.get(i);
            valuesArray.setAtIndex(C_POINTER, i, value.toNative(api, ortAllocator, memoryInfo, allocator));
        }
        return api.create(
                allocator,
                out -> api.CreateValue.apply(valuesArray.address(), size, OnnxType.SEQUENCE.getNumber(), out));
    }

    @Override
    public void fromNative(
            ApiImpl api,
            MemoryAddress ortAllocator,
            MemoryAddress address,
            SegmentAllocator allocator,
            MemorySession session) {
        long outputs = api.extractLong(allocator, out -> api.GetValueCount.apply(address, out));
        for (int i = 0; i < outputs; i++) {
            final int index = i;
            MemoryAddress valueAddress =
                    api.create(allocator, out -> api.GetValue.apply(address, index, ortAllocator, out));
            OnnxValueImpl value = OnnxValueImpl.fromTypeInfo(typeInfo);
            value.fromNative(api, ortAllocator, valueAddress, allocator, session);
            data.add(value);
        }
    }

    @Override
    public boolean add(OnnxValue e) {
        return unmodifiableData.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends OnnxValue> c) {
        return unmodifiableData.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends OnnxValue> c) {
        return unmodifiableData.addAll(index, c);
    }

    @Override
    public OnnxValue set(int index, OnnxValue element) {
        return unmodifiableData.set(index, element);
    }

    @Override
    public void add(int index, OnnxValue element) {
        unmodifiableData.add(index, element);
    }

    @Override
    public int size() {
        return unmodifiableData.size();
    }

    @Override
    public boolean isEmpty() {
        return unmodifiableData.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return unmodifiableData.contains(o);
    }

    @Override
    public Iterator<OnnxValue> iterator() {
        return unmodifiableData.iterator();
    }

    @Override
    public Object[] toArray() {
        return unmodifiableData.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return unmodifiableData.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return unmodifiableData.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return unmodifiableData.containsAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return unmodifiableData.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return unmodifiableData.retainAll(c);
    }

    @Override
    public void clear() {
        unmodifiableData.clear();
    }

    @Override
    public OnnxValue get(int index) {
        return unmodifiableData.get(index);
    }

    @Override
    public OnnxValue remove(int index) {
        return unmodifiableData.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return unmodifiableData.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return unmodifiableData.lastIndexOf(o);
    }

    @Override
    public ListIterator<OnnxValue> listIterator() {
        return unmodifiableData.listIterator();
    }

    @Override
    public ListIterator<OnnxValue> listIterator(int index) {
        return unmodifiableData.listIterator(index);
    }

    @Override
    public List<OnnxValue> subList(int fromIndex, int toIndex) {
        return unmodifiableData.subList(fromIndex, toIndex);
    }
}
