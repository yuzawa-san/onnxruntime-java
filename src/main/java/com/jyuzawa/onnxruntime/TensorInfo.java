package com.jyuzawa.onnxruntime;

import java.util.List;

public interface TensorInfo {

  OnnxTensorElementDataType getType();

  List<Long> getShape();

  long getElementCount();
}
