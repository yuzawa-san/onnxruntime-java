/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

public interface MapInfo {

    OnnxTensorElementDataType getKeyType();

    TypeInfo getValueType();
}
