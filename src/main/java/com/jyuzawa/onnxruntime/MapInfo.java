/* Copyright (c) 2022 yuzawa-san, Licensed under the MIT License. */
package com.jyuzawa.onnxruntime;

public interface MapInfo {

  int getSize();

  OnnxTensorElementDataType getKeyType();

  TypeInfo getValueType();
}
