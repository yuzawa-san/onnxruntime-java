/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

final class NodeInfoImpl implements NodeInfo {

    private final String name;
    private final TypeInfo typeInfo;

    NodeInfoImpl(String name, TypeInfo typeInfo) {
        this.name = name;
        this.typeInfo = typeInfo;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public TypeInfo getTypeInfo() {
        return typeInfo;
    }

    @Override
    public String toString() {
        return "{NodeInfo: name=" + name + ", typeInfo=" + typeInfo + "}";
    }
}
