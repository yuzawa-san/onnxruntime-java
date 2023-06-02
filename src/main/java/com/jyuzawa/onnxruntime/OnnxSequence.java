/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.List;

/**
 * A sequence view of an {@link OnnxValue}. Extends {@link java.util.List} to provide an UNMODIFIABLE view.
 * Use {@link #add()} to populate the sequence.
 *
 * @since 1.0.0
 */
public interface OnnxSequence extends List<OnnxValue> {

    /**
     *
     * @return The description of the type of the elements in the sequence.
     */
    TypeInfo getInfo();

    /**
     *
     * @return A new OnnxValue of correct type added to the end of the sequence.
     */
    OnnxValue add();
}
