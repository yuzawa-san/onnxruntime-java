/* Copyright (c) 2022 yuzawa-san, Licensed under the MIT License. */
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

  public String toString() {
    return "{NodeInfo: name=" + name + ", typeInfo=" + typeInfo + "}";
  }
}
