/* Copyright (c) 2022 yuzawa-san, Licensed under the MIT License. */
package com.jyuzawa.onnxruntime;

import com.jyuzawa.onnxruntime.Transaction.Builder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class TransactionBuilderImpl implements Transaction.Builder {

  private final Map<String, float[]> inputs = new LinkedHashMap<>();
  private final List<String> outputs = new ArrayList<>();

  @Override
  public Transaction build() {
    return new TransactionImpl(inputs, outputs);
  }

  @Override
  public Builder addInput(String name, float[] input) {
    inputs.put(name, input);
    return this;
  }

  @Override
  public Builder addOutput(String name) {
    outputs.add(name);
    return this;
  }
}
