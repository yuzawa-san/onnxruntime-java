/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.Map;

/**
 * A representation of a model evaluation. Should NOT be reused. This class is NOT thread-safe.
 *
 * @since 1.0.0
 */
public interface Transaction extends AutoCloseable {
    /**
     * Add an input and get an OnnxValue to populate.
     * @param name
     * @return the value to be populated
     */
    OnnxValue addInput(String name);

    /**
     * Add an input and get an OnnxValue to populate.
     * @param index
     * @return the value to be populated
     */
    OnnxValue addInput(int index);

    /**
     * Request a specific output to be produced.
     * @param name
     */
    void addOutput(String name);

    /**
     * Request a specific output to be produced.
     * @param index
     */
    void addOutput(int index);

    /**
     * Run the model evaluation.
     *
     * @return the results
     */
    NamedCollection<OnnxValue> run();

    /**
     * Frees the native resources (typically buffers) associated with this transaction.
     */
    @Override
    void close();

    //    void cancel();

    /**
     * A builder of a {@link Transaction}. Should NOT be reused. This class is NOT thread-safe.
     *
     */
    public interface Builder {
        /**
         * Set the severity for logging for this specific transaction.
         * Can override the environment's or session's logger's severity.
         * @param level
         * @return the builder
         */
        Builder setLogSeverityLevel(OnnxRuntimeLoggingLevel level);

        /**
         * Set the verbosity for logging for this specific transaction.
         * Can override the environment's or session's logger's verbosity.
         * @param level
         * @return the builder
         */
        Builder setLogVerbosityLevel(int level);

        /**
         * Set the run tag (which is the logger id)
         * @param runTag
         * @return the builder
         */
        Builder setRunTag(String runTag);

        /**
         * Set custom parameters for this transaction.
         * @param config
         * @return the builder
         */
        Builder setConfigMap(Map<String, String> config);

        /**
         * Construct a {@link Transaction}.
         *
         * @return a new instance
         */
        Transaction build();
    }
}
