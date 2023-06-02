/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.List;

/**
 * A description of a tensor: type and shape.
 *
 * @since 1.0.0
 */
public interface TensorInfo {

    OnnxTensorElementDataType getType();

    List<Long> getShape();

    /**
     * Get the number of elements in the buffer.
     * @return derived from shape
     */
    long getElementCount();

    /**
     * Get the size of the buffer from a memory standpoint.
     * @return the number of bytes the buffer takes up, based on shape and bytes for the type.
     */
    long getByteCount();
}
