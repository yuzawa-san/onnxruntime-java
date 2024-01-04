/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;

final class NodeInfoImpl implements NodeInfo {

    private final String name;
    final MemoryAddress nameSegment;
    private final TypeInfoImpl typeInfo;

    NodeInfoImpl(String name, MemoryAddress nameSegment, TypeInfoImpl typeInfo) {
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
}
