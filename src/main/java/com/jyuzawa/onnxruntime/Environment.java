/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemorySegment;
import java.util.List;
import java.util.Map;

/**
 * The environment in which model evaluation sessions can be constructed. Only
 * one environment should be used in your application. This class is thread safe.
 *
 * @since 1.0.0
 */
public interface Environment extends AutoCloseable {

    /**
     * Releases native resources.
     */
    @Override
    void close();

    /**
     * Change the telemetry events.
     *
     * @param enabled true if telemetry events should be enabled.
     */
    void setTelemetryEvents(boolean enabled);

    // TODO: allocator
    // void createAndRegisterAllocator();

    /**
     * Create a new session for model evaluation.
     *
     * @return a builder
     */
    Session.Builder newSession();

    /**
     * A builder of an {@link Environment}. The default severity level is determined
     * from the logger level of the logger of {@link Environment}.
     *
     * @since 1.0.0
     */
    public interface Builder {
        /**
         * Set the severity for logging.
         *
         * @param level the severity
         * @return the builder
         */
        Builder setLogSeverityLevel(OnnxRuntimeLoggingLevel level);

        /**
         * Set the logging identifier.
         *
         * @param id the identifier
         * @return the builder
         */
        Builder setLogId(String id);

        /**
         * Set the shared thread pool's "denormal as zero" setting.
         * @param globalDenormalAsZero whether to denormal as zero
         * @return the builder
         */
        Builder setGlobalDenormalAsZero(boolean globalDenormalAsZero);

        /**
         * Set the shared thread pool's "inter op" thread count.
         * @param numThreads a number of threads to use, or 0 to have the library use a default
         * @return the builder
         */
        Builder setGlobalInterOpNumThreads(int numThreads);

        /**
         * Set the shared thread pool's "intra op" thread count.
         * @param numThreads a number of threads to use, or 0 to have the library use a default
         * @return the builder
         */
        Builder setGlobalIntraOpNumThreads(int numThreads);

        /**
         * Set whether the shared thread pool's should spin when idle.
         * @param globalSpinControl whether to spin or not
         * @return the builder
         */
        Builder setGlobalSpinControl(boolean globalSpinControl);

        /**
         * Set whether the environment's shared allocator for CPU should be arena-based
         * @param config the key/value configuration of the arena
         * @return the builder
         * @since 1.2.0
         */
        Builder setArenaConfig(Map<String, Long> config);

        /**
         * Constructs the {@link Environment}.
         *
         * @return a new instance
         */
        Environment build();
    }

    /**
     * Create a new tensor around an existing piece of memory.
     *
     * Direct segments will be wrapped and must remain allocated for the lifetime this value is utilized.
     * This is not an issue for segments from automatic arenas.
     * It would cause a runtime exception from confined or shared arenas if they are closed prior to this value's utilization.
     * However, if the memory comes from elsewhere, care must be taken to not release the memory.
     * Heap segments will require an intermediate copy, which will be done internally.
     * If you have the data on the heap, it is recommended to use {@link #newTensor(OnnxTensorElementDataType, List)}.
     *
     * This will have "automatic" scope and may be treated like normal a Java object, since they are managed by the garbage collector (albeit with slight overhead for tracking and cleaning).
     * @param type the element type
     * @param shape the dimensions
     * @param memorySegment a piece of memory which will be wrapped to create the tensor
     * @return a value that can be used as a model input
     * @since 2.1.0
     */
    OnnxTensor newTensor(OnnxTensorElementDataType type, List<Long> shape, MemorySegment memorySegment);

    /**
     * Create a new tensor.
     *
     * The onnruntime library will own the underlying tensor data.
     * The default allocator will be used.
     * The caller is responsible to copy whatever memory into this empty tensor.
     *
     * This will have "automatic" scope and may be treated like normal a Java object, since they are managed by the garbage collector (albeit with slight overhead for tracking and cleaning).
     * @param type the element type
     * @param shape the dimensions
     * @return a value that can be used as a model input
     * @since 2.1.0
     */
    OnnxTensor newTensor(OnnxTensorElementDataType type, List<Long> shape);
}
