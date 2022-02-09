/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.ByteBuffer;

public interface OnnxOpaque {

    OpaqueInfo getInfo();

    ByteBuffer getByteBuffer();
}
