/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemorySegment;

final class NodeInfoImpl implements NodeInfo {

    private final String name;
    final MemorySegment nameSegment;
    private final TypeInfoImpl typeInfo;

    NodeInfoImpl(String name, MemorySegment nameSegment, TypeInfoImpl typeInfo) {
        this.name = name;
        this.nameSegment = nameSegment;
        this.typeInfo = typeInfo;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public TypeInfoImpl getTypeInfo() {
        return typeInfo;
    }

    @Override
    public String toString() {
        return "{NodeInfo: name=" + name + ", typeInfo=" + typeInfo + "}";
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof NodeInfoImpl) {
            return ((NodeInfoImpl) o).name.equals(name);
        }
        return false;
    }
}
