/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

final class OnnxSequenceImpl extends OnnxValueImpl implements OnnxSequence {

    private final List<OnnxValueImpl> data;
    private final TypeInfo typeInfo;

    OnnxSequenceImpl(TypeInfo typeInfo) {
        super(OnnxType.SEQUENCE);
        this.data = new ArrayList<>();
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
    public OnnxValue set(int index) {
        OnnxValueImpl item = newItem();
        data.set(index, item);
        return item;
    }

    @Override
    public OnnxValue add(int index) {
        OnnxValueImpl item = newItem();
        data.add(index, item);
        return item;
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

    private List<OnnxValue> unmodifiableList() {
        return Collections.unmodifiableList(data);
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return data.contains(o);
    }

    @Override
    public Iterator<OnnxValue> iterator() {
        return unmodifiableList().iterator();
    }

    @Override
    public Object[] toArray() {
        return data.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return data.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return data.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return data.containsAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return data.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return data.retainAll(c);
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public OnnxValue get(int index) {
        return data.get(index);
    }

    @Override
    public OnnxValue remove(int index) {
        return data.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return data.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return data.lastIndexOf(o);
    }

    @Override
    public ListIterator<OnnxValue> listIterator() {
        return unmodifiableList().listIterator();
    }

    @Override
    public ListIterator<OnnxValue> listIterator(int index) {
        return unmodifiableList().listIterator(index);
    }

    @Override
    public List<OnnxValue> subList(int fromIndex, int toIndex) {
        return unmodifiableList().subList(fromIndex, toIndex);
    }
}
