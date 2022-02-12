/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.ByteBuffer;

interface OnnxOpaque {

    OpaqueInfo getInfo();

    void set(ByteBuffer buffer);

    ByteBuffer get();
}
