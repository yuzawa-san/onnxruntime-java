package com.jyuzawa.onnxruntime;

public interface SequenceInfo {

  int getSize();

  boolean isSequenceOfMaps();

  MapInfo getMapInfo();

  OnnxTensorElementDataType getSequenceType();
}
