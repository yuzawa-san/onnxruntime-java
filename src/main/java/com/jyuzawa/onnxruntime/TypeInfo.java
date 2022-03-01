/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

public interface TypeInfo {

    OnnxType getType();

    TensorInfo getTensorInfo();

    MapInfo getMapInfo();

    TypeInfo getSequenceInfo();

    //  TypeInfo getOptionalInfo();

    // OpaqueInfo getOpaqueInfo();
}
