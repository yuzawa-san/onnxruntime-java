/* Copyright (c) 2022 yuzawa-san, Licensed under the MIT License. */
package com.jyuzawa.onnxruntime;

import java.util.Map;

public interface ModelMetadata {
  String getDescription();

  String getDomain();

  String getGraphDescription();

  String getGraphName();

  String getProducerName();

  long getVersion();

  Map<String, String> getCustomMetadata();
}
