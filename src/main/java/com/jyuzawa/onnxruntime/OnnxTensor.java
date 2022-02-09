/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public interface OnnxTensor {

    TensorInfo getInfo();

    ByteBuffer getByteBuffer();

    ShortBuffer getShortBuffer();

    IntBuffer getIntBuffer();

    LongBuffer getLongBuffer();

    FloatBuffer getFloatBuffer();

    DoubleBuffer getDoubleBuffer();

    String[] getStringBuffer();
}
