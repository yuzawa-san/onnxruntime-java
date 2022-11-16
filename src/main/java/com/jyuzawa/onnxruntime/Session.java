/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Path;

/**
 * An evaluation session loaded from an ONNX file or bytes.
 */
public interface Session extends AutoCloseable {

    /**
     * Release native resources.
     */
    @Override
    void close();

    ModelMetadata getModelMetadata();

    NamedCollection<NodeInfo> getInputs();

    NamedCollection<NodeInfo> getOutputs();

    NamedCollection<NodeInfo> getOverridableInitializers();
    
    /**
     * Create a new transaction.
     * @return a builder
     */
    Transaction.Builder newTransaction();

    /**
     * A builder of a {@link Session}. Must provide either bytes or a path.
     *
     */
    public interface Builder {
        Builder setPath(Path path);

        Builder setByteArray(byte[] bytes);

        Builder setByteBuffer(ByteBuffer byteBuffer);
       
        SessionOptions.Builder getSessionOptionsBuilder();
        
        /**
         * Construct a {@link Session}.
         * @return a new instance
         * @throws IOException
         */
        Session build() throws IOException;
    }
}
