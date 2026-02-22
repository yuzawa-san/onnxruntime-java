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
 * An evaluation session loaded from an ONNX file or bytes. This class is thread safe.
 *
 * @since 1.0.0
 */
public interface Session extends AutoCloseable {

    /**
     * Release native resources.
     */
    @Override
    void close();

    /**
     * Get additional information about this session.
     * @return a read-only view of the session's metadata
     */
    ModelMetadata getModelMetadata();

    /**
     * Get the session's named inputs.
     * @return a named collection to access by name or index
     */
    NamedCollection<NodeInfo> getInputs();

    /**
     * Get the session's named outputs.
     * @return a named collection to access by name or index
     */
    NamedCollection<NodeInfo> getOutputs();

    /**
     * Get a session's named initializers.
     * @return a named collection to access by name or index
     */
    NamedCollection<NodeInfo> getOverridableInitializers();

    /**
     * A high precision monotonically increasing clock for use in profiling.
     * @return nanoseconds
     */
    long getProfilingStartTimeInNs();

    /**
     * Stop profile and get the resulting JSON file's location.
     * @return a path to the output
     */
    Path endProfiling();

    /**
     * Create a new transaction.
     * @return a builder
     */
    Transaction.Builder newTransaction();

    /**
     * Create a new I/O Binding.
     * @return a builder
     * @since 1.4.0
     */
    IoBinding.Builder newIoBinding();

    /**
     * Set DynamicOptions for EPs (Execution Providers)
     * @param epDynamicOptions
     * @since 2.0.0
     */
    void setEpDynamicOptions(Map<String, String> epDynamicOptions);

    /**
     * A builder of a {@link Session}. Must provide either bytes or a path.
     *
     * @since 1.0.0
     */
    public interface Builder {
        /**
         * Load the session from a file.
         * @param path
         * @return the builder
         */
        Builder setPath(Path path);

        /**
         * Load the session from a byte array.
         * @param bytes
         * @return the builder
         */
        Builder setByteArray(byte[] bytes);

        /**
         * Load the session from a buffer.
         * @param byteBuffer
         * @return the builder
         */
        Builder setByteBuffer(ByteBuffer byteBuffer);

        /**
         * Use the global thread pool.
         * @return the builder
         */
        Builder disablePerSessionThreads();

        /**
         * Set the prefix for the unique profile output files.
         * @param prefix the prefix from which a timestamp will be appended
         * @return the builder
         */
        Builder setProfilingOutputPath(Path prefix);

        /**
         * Set the severity for logging for this entire session.
         * Can override the environment's logger's severity.
         * @param level
         * @return the builder
         */
        Builder setLogSeverityLevel(OnnxRuntimeLoggingLevel level);

        /**
         * Set the verbosity for logging for this entire session.
         * Can override the environment's logger's verbosity.
         * @param level
         * @return the builder
         */
        Builder setLogVerbosityLevel(int level);

        /**
         * Set custom parameters for this session.
         * @param config
         * @return the builder
         */
        Builder setConfigMap(Map<String, String> config);

        /**
         * Set sequential vs parallel execution.
         * @param mode
         * @return the builder
         */
        Builder setExecutionMode(OnnxRuntimeExecutionMode mode);

        /**
         * Set the number of inter op threads in this session's own thread pool.
         * @param numThreads
         * @return the builder
         */
        Builder setInterOpNumThreads(int numThreads);

        /**
         * Set the number of intra op threads in this session's own thread pool.
         * @param numThreads
         * @return the builder
         */
        Builder setIntraOpNumThreads(int numThreads);

        /**
         * Set the logging identifier.
         *
         * @param id the identifier
         * @return the builder
         */
        Builder setLogId(String id);

        /**
         * Enable or disable memory pattern optimization.
         * @param memoryPatternOptimization
         * @return the builder
         */
        Builder setMemoryPatternOptimization(boolean memoryPatternOptimization);

        /**
         * Set the desired level of optimization.
         * @param level
         * @return the builder
         */
        Builder setOptimizationLevel(OnnxRuntimeOptimizationLevel level);

        /**
         * Set the location of the optimized model.
         * @param optimizedFile
         * @return the builder
         */
        Builder setOptimizationOutputPath(Path optimizedFile);

        /**
         * Enable deterministic compute.
         * @param value
         * @return the builder
         * @since 1.5.0
         */
        Builder setDeterministicCompute(boolean value);

        /**
         * Add an execution provider with custom properties.
         * @param provider
         * @param properties
         * @return the builder
         */
        Builder addProvider(ExecutionProvider provider, Map<String, String> properties);

        default Builder addProvider(ExecutionProvider provider) {
            return addProvider(provider, Collections.emptyMap());
        }

        /**
         * Add an execution provider with all default properties.
         * @param path
         * @return the builder.
         */
        Builder addCustomOpsLibrary(Path path);

        /**
         * Specify proper sizes for dimensions with dim_param on this session.
         * @param symbolicDimensionsMap a mapping of dim_param to concrete size
         * @return the builder
         * @since 2.1.0
         */
        Builder setFreeDimensionOverrideByName(Map<String, Integer> symbolicDimensionsMap);

        /**
         * Specify proper sizes for dimensions with denotation on this session.
         * @param denotationsMap a mapping of dim_param to concrete size
         * @return the builder
         * @since 2.1.0
         */
        Builder setFreeDimensionOverride(Map<String, Integer> denotationsMap);

        /**
         * Construct a {@link Session}.
         * @return a new instance
         * @throws IOException
         */
        Session build() throws IOException;
    }
}
