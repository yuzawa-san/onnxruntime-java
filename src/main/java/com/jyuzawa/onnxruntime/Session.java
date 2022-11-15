/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.io.File;
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
    
void endProfiling();

long getProfilingStartTimeInNs();

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
        
        Builder 	disableProfiling();
        
        Builder 	enableProfiling​(File profilePath);
        
        Builder 	setExecutionMode​(OrtSession.SessionOptions.ExecutionMode mode);
        
        Builder setInterOpNumThreads​(int numThreads);
        
        Builder setIntraOpNumThreads​(int numThreads);
        
        
        Builder setLoggerId​(java.lang.String loggerId);
        
        Builder setMemoryPatternOptimization​(boolean memoryPatternOptimization);
      Builder   setCPUArenaAllocator​(boolean useArena);
        
        Builder setOptimizationLevel​(OrtSession.SessionOptions.OptLevel level);
        
        Builder setOptimizedModelFilePath​(File outputPath);
        
        Builder 	setSessionLogLevel​(OrtLoggingLevel logLevel);
        
        
        Builder 	setSessionLogVerbosityLevel​(int logLevel);
        
        Builder 	addConfigEntry​(java.lang.String configKey, java.lang.String configValue);
        
        Builder registerCustomOpLibrary​(java.lang.String path);
        
        Builder setSymbolicDimensionValue​(java.lang.String dimensionName, long dimensionValue);

        /**
         * Construct a {@link Session}.
         * @return a new instance
         * @throws IOException
         */
        Session build() throws IOException;
    }
}
