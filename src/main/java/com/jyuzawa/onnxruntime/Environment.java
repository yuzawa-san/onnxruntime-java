/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

/**
 * The environment in which model evaluation sessions can be constructed. Only
 * one environment should be used in your application.
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
         * Constructs the {@link Environment}.
         *
         * @return a new instance
         */
        Environment build();
    }
}
