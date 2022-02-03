/* Copyright (c) 2022 yuzawa-san, Licensed under the MIT License. */
package com.jyuzawa.onnxruntime;

public interface TypeInfo {

  OnnxType getType();

  TensorInfo getTensorInfo();

  MapInfo getMapInfo();

  SequenceInfo getSequenceInfo();
}
