/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.Map;

/**
 * A representation of a model evaluation. Should NOT be reused.
 *
 */
public interface Transaction {
    /**
     * Run the model evaluation.
     *
     * @return the results
     */
    NamedCollection<OnnxValue> run();

    //    void cancel();

    /**
     * A builder of a {@link Transaction}.
     *
     */
    public interface Builder {
        /**
         * Add an input and get an OnnxValue to populate.
         * @param name
         * @return the builder
         */
        OnnxValue addInput(String name);

        /**
         * Add an input and get an OnnxValue to populate.
         * @param index
         * @return the builder
         */
        OnnxValue addInput(int index);

        /**
         * Request a specific output to be produced.
         * @param name
         * @return the builder
         */
        Builder addOutput(String name);

        /**
         * Request a specific output to be produced.
         * @param index
         * @return the builder
         */
        Builder addOutput(int index);

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
