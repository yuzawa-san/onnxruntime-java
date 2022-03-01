/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

interface OnnxOptional {

    TypeInfo getInfo();

    boolean isPresent();

    OnnxValue get();

    OnnxValue set();
}
