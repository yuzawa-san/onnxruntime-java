/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.nio.ByteBuffer;

interface OnnxOpaque {

    OpaqueInfo getInfo();

    void set(ByteBuffer buffer);

    ByteBuffer get();
}
