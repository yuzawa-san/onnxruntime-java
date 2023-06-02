/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.Set;

/**
 * The top-level API of the ONNX runtime.
 *
 * @since 1.0.0
 */
public interface Api {

    /**
     * Create a new environment.
     * @return a builder
     */
    Environment.Builder newEnvironment();

    /**
     * Determine what execution providers are available.
     *
     * NOTE: not all of these execution provider may be supported by this library.
     * @return a set of execution providers.
     */
    Set<ExecutionProvider> getAvailableProviders();

    /**
     * This function returns the onnxruntime build information: including git branch, git commit id, build type(Debug/Release/RelWithDebInfo) and cmake cpp flags.
     * @return the version string
     */
    String getBuildString();
}
