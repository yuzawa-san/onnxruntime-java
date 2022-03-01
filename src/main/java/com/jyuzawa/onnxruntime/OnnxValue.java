/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.NoSuchElementException;

/**
 * A representation of a value provided as an input or output. Use {@link #getType()} to find out which more specific view is present. A {@link NoSuchElementException} will be thrown if a view does not exist for this instance's type.
 *
 */
public interface OnnxValue {

    OnnxType getType();

    OnnxTensor asTensor();

    OnnxSequence asSequence();

    OnnxMap asMap();

    //    OnnxOpaque asOpaque();

    //    OnnxSparseTensor asSparseTensor();

    //    OnnxOptional asOptional();
}
