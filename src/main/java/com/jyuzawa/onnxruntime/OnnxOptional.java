/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

public interface OnnxOptional {

    TypeInfo getInfo();

    boolean isPresent();

    OnnxValue get();

    OnnxValue set();
}
