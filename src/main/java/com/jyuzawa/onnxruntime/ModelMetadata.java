/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.Map;

/**
 * A representation of the metadata stored in an ONNX model.
 *
 */
public interface ModelMetadata {
    String getDescription();

    String getDomain();

    String getGraphDescription();

    String getGraphName();

    String getProducerName();

    long getVersion();

    /**
     * @return an immutable map of custom key-value pairs.
     */
    Map<String, String> getCustomMetadata();
}
