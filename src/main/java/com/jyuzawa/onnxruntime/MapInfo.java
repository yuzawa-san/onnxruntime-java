/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

/**
 * A description of the type information related to ONNX's "Map" type.
 *
 */
public interface MapInfo {

    /**
     * Get the key information.
     * @return the key type
     */
    OnnxTensorElementDataType getKeyType();

    /**
     * Get the value information.
     * @return the value type
     */
    TypeInfo getValueType();
}
