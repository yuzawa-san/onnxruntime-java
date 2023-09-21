/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

/**
 * This is the entrypoint into this library. It is a singleton that is accessible using {@link #get()}.
 *
 * @since 1.0.0
 */
public interface OnnxRuntime {

    /**
     * The Microsoft ONNX runtime version.
     * @return x.y.z version
     */
    String getVersion();

    /**
     * This function returns the value of the ORT_API_VERSION constant.
     * @return the int version number
     * @since 1.2.0
     */
    int getApiVersion();

    /**
     * This method provides a view of the latest API.
     * @return a wrapper around the main
     */
    Api getApi();

    /**
     * On first use, this attempts to automatically load the library if it is discovered on the classpath. Otherwise, the Java library path will be used.
     * @return a singleton loaded instance
     */
    static OnnxRuntime get() {
        return OnnxRuntimeImpl.INSTANCE;
    }
}
