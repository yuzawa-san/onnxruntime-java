/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.util.List;

public interface TensorInfo {

    OnnxTensorElementDataType getType();

    List<Long> getShape();

    long getElementCount();

    long getByteCount();
}
