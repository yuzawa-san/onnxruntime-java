/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

public interface SequenceInfo {

    int getSize();

    boolean isSequenceOfMaps();

    MapInfo getMapInfo();

    OnnxTensorElementDataType getSequenceType();
}
