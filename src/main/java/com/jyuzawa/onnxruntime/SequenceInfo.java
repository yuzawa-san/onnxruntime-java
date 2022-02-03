/* Copyright (c) 2022 yuzawa-san, Licensed under the MIT License. */
package com.jyuzawa.onnxruntime;

public interface SequenceInfo {

  int getSize();

  boolean isSequenceOfMaps();

  MapInfo getMapInfo();

  OnnxTensorElementDataType getSequenceType();
}
