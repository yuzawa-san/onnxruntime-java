/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import java.lang.foreign.MemorySegment;
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

    OnnxSequenceImpl(TypeInfoImpl typeInfo, ValueContext valueContext, MemorySegment ortValueAddress) {
        super(OnnxType.SEQUENCE, valueContext, ortValueAddress);
        if (ortValueAddress == null) {
            this.data = new ArrayList<>();
        } else {
            ApiImpl api = valueContext.api();
            int outputs = Math.toIntExact(api.extractLong(arena, out -> api.GetValueCount.apply(ortValueAddress, out)));
            this.data = new ArrayList<>(outputs);
            for (int i = 0; i < outputs; i++) {
                final int index = i;
                MemorySegment valueAddress = api.create(
                        arena,
                        out -> api.GetValue.apply(ortValueAddress, index, valueContext.ortAllocatorAddress(), out));
                OnnxValueImpl value = typeInfo.newValue(valueContext, valueAddress);
                data.add(value);
            }
        }
        this.unmodifiableData = Collections.unmodifiableList(data);
        this.typeInfo = typeInfo;
    }

    @Override
    void dispose() {
        super.dispose();
        int size = data.size();
        for (int i = 0; i < size; i++) {
            data.get(i).dispose();
        }
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
        return typeInfo.newValue(valueContext, null);
    }

    @Override
    public OnnxValue add() {
        OnnxValueImpl item = newItem();
        data.add(item);
        return item;
    }

    @Override
    public MemorySegment toNative() {
        ApiImpl api = valueContext.api();
        int size = data.size();
        MemorySegment valuesArray = arena.allocate(C_POINTER, size);
        for (int i = 0; i < size; i++) {
            OnnxValueImpl value = data.get(i);
            valuesArray.setAtIndex(C_POINTER, i, value.getNative());
        }
        return api.create(arena, out -> api.CreateValue.apply(valuesArray, size, OnnxType.SEQUENCE.getNumber(), out));
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
