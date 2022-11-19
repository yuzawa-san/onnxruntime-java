/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.Set;

/**
 * The top-level API of the ONNX runtime.
 *
 */
public interface Api {

    /**
     * Create a new environment.
     * @return a builder
     */
    Environment.Builder newEnvironment();

    Set<String> getAvailableProviders();
}
