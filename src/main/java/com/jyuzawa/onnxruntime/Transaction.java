package com.jyuzawa.onnxruntime;

import java.util.Collection;
import java.util.Map;

public interface Transaction {

  Map<String, float[]> getInputs();

  Collection<String> getOutputs();

  //	RunOptions getRunOptions();

  static Builder newBuilder() {
    return new TransactionBuilderImpl();
  }

  public interface Builder {

    Builder addInput(String name, float[] input);

    Builder addOutput(String name);

    //		Builder setRunOptions(RunOptions runOptions);

    Transaction build();
  }
}
