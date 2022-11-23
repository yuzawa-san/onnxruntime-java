/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Map;

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

    long getProfilingStartTimeInNs();

    Path endProfiling();

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

        Builder disablePerSessionThreads();

        Builder setProfilingOutputPath(Path prefix);

        Builder setLogSeverityLevel(OnnxRuntimeLoggingLevel level);

        Builder setLogVerbosityLevel(int level);

        Builder setConfigMap(Map<String, String> config);

        Builder setExecutionMode(OnnxRuntimeExecutionMode mode);

        Builder setInterOpNumThreads(int numThreads);

        Builder setIntraOpNumThreads(int numThreads);

        Builder setLogId(String loggerId);

        Builder setMemoryPatternOptimization(boolean memoryPatternOptimization);

        Builder setOptimizationLevel(OnnxRuntimeOptimizationLevel level);

        Builder setOptimizationOutputPath(Path optimizedFile);

        Builder addProvider(ExecutionProvider provider, Map<String, String> properties);

        default Builder addProvider(ExecutionProvider provider) {
            return addProvider(provider, Collections.emptyMap());
        }

        // TODO: custom op library

        /**
         * Construct a {@link Session}.
         * @return a new instance
         * @throws IOException
         */
        Session build() throws IOException;
    }
}
