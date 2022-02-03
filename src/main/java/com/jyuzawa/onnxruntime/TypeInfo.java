package com.jyuzawa.onnxruntime;

public interface TypeInfo {

  OnnxType getType();

  TensorInfo getTensorInfo();

  MapInfo getMapInfo();

  SequenceInfo getSequenceInfo();
}
