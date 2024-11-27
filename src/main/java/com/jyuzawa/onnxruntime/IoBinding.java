/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemorySegment;
import java.nio.Buffer;
import java.util.Map;

/**
 * A representation of a model evaluation. Capable of reuse in repetitive runs. More efficient than {@link Transaction}. Only supports tensors. Input and outputs are pre-allocated and must be of fixed size. This class is NOT thread-safe.
 *
 * @since 1.4.0
 */
public interface IoBinding extends AutoCloseable {

    /**
     * Set the severity for logging for this specific transaction.
     * Can override the environment's or session's logger's severity.
     * @param level
     * @return this
     */
    IoBinding setLogSeverityLevel(OnnxRuntimeLoggingLevel level);

    /**
     * Set the verbosity for logging for this specific transaction.
     * Can override the environment's or session's logger's verbosity.
     * @param level
     * @return this
     */
    IoBinding setLogVerbosityLevel(int level);

    /**
     * Set the run tag (which is the logger id)
     * @param runTag
     * @return this
     */
    IoBinding setRunTag(String runTag);

    IoBinding synchronizeBoundInputs();

    IoBinding synchronizeBoundOutputs();

    NamedCollection<OnnxValue> getInputs();

    NamedCollection<OnnxValue> getOutputs();

    /**
     * Run the model evaluation.
     */
    void run();

    /**
     * Frees the native resources (typically buffers) associated with this transaction.
     */
    @Override
    void close();

    /**
     * A builder of a {@link IoBinding}. Should NOT be reused. This class is NOT thread-safe.
     *
     * @since 1.0.0
     */
    public interface Builder {
        BindingBuilder newInput();

        BindingBuilder newOutput();

        /**
         * Set custom parameters for this transaction.
         * @param config
         * @return the builder
         */
        Builder setConfigMap(Map<String, String> config);

        /**
         * Construct a {@link IoBinding}.
         *
         * @return a new instance
         */
        IoBinding build();
    }

    public interface BindingBuilder {
        BindingBuilder index(int index);

        BindingBuilder name(String name);

        /**
         * Bind an externally managed MemorySegment. Must be a off-heap with proper endian.
         * @param memorySegment
         * @return
         */
        BindingBuilder memorySegment(MemorySegment memorySegment);

        /**
         * Bind an externally managed buffer. Must be a off-heap with proper endian.
         * @param buffer
         * @return
         */
        BindingBuilder buffer(Buffer buffer);

        Builder bind();
    }
}
