/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
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

        Builder setByteArray(byte[] bytes);

        Builder setByteBuffer(ByteBuffer byteBuffer);

        Session build() throws IOException;
    }
}
