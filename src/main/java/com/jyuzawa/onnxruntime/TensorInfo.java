/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.util.List;

public interface TensorInfo {

    OnnxTensorElementDataType getType();

    List<Long> getShape();

    long getElementCount();
}
