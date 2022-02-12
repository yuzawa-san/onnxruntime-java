/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Path;

public interface Session extends Managed {
    ModelMetadata getModelMetadata();

    NamedCollection<NodeInfo> getInputs();

    NamedCollection<NodeInfo> getOutputs();

    NamedCollection<NodeInfo> getOverridableInitializers();

    Transaction.Builder newTransaction();

    public interface Builder {
        Builder setPath(Path path);

        Builder setByteArray(byte[] bytes);

        Builder setByteBuffer(ByteBuffer byteBuffer);
        // TODO: more session options

        Session build() throws IOException;
    }
}
