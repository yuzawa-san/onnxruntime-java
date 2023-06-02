/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.NoSuchElementException;

/**
 * A description of the type of an input or output. Use {@link #getType()} to determine what type of additional information is present. A {@link NoSuchElementException} will be thrown from getters which are not valid for the instance's type.
 *
 * @since 1.0.0
 */
public interface TypeInfo {

    OnnxType getType();

    TensorInfo getTensorInfo();

    MapInfo getMapInfo();

    TypeInfo getSequenceInfo();

    //  TypeInfo getOptionalInfo();

    // OpaqueInfo getOpaqueInfo();
}
