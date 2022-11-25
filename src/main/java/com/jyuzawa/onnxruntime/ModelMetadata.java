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
    /**
     * Access the description
     * @return description
     */
    String getDescription();

    /**
     * Access the domain
     * @return domain
     */
    String getDomain();

    /**
     * Access the graph description
     * @return graph description
     */
    String getGraphDescription();

    /**
     * Access the graph name
     * @return graph name
     */
    String getGraphName();

    /**
     * Access the producer name
     * @return producer
     */
    String getProducerName();

    /**
     * Access the version
     * @return version
     */
    long getVersion();

    /**
     * Access the custom metadata map.
     * @return an immutable map of custom key-value pairs.
     */
    Map<String, String> getCustomMetadata();
}
