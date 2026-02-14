/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * A representation of a value provided as an input or output. Use {@link #getType()} to find out which more specific view is present. A {@link NoSuchElementException} will be thrown if a view does not exist for this instance's type.
 *
 * @since 1.0.0
 */
public interface OnnxValue {

    /**
     * Get type
     * @return type enum value
     */
    OnnxType getType();

    /**
     * A view as a tensor
     * @return tensor
     * @throws NoSuchElementException if the value is not a tensor
     */
    OnnxTensor asTensor();

    /**
     * A view as a tensor of specified shape. Must be used when inputs have dynamic shape.
     * @return tensor
     * @throws NoSuchElementException if the value is not a tensor
     * @since 2.1.0
     */
    OnnxTensor asTensor(List<Long> shape);

    /**
     * A view as a sequence
     * @return sequence
     * @throws NoSuchElementException if the value is not a sequence
     */
    OnnxSequence asSequence();

    /**
     * A view as a map
     * @return map
     * @throws NoSuchElementException if the value is not a map
     */
    OnnxMap asMap();

    //    OnnxOpaque asOpaque();

    //    OnnxSparseTensor asSparseTensor();

    //    OnnxOptional asOptional();
}
