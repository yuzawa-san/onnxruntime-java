package com.jyuzawa.onnxruntime;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.util.Map;

public interface Session extends Managed {
  Map<String, NodeInfo> getInputs();

  ModelMetadata getModelMetadata();

  Map<String, NodeInfo> getOutputs();

  Map<String, NodeInfo> getOverridableInitializers();

  Output run(Transaction transaction);

  public interface Builder {
    Builder setPath(Path path);

    default Builder setBytes(byte[] bytes) {
      return setBuffer(ByteBuffer.wrap(bytes));
    }

    Builder setBuffer(ByteBuffer byteBuffer);

    Session build() throws IOException;
  }
}
