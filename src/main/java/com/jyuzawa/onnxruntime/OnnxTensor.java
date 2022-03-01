/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.NoSuchElementException;

/**
 * A representation of a dense tensor. Use {@link #getInfo()} to select the proper buffer type. A {@link NoSuchElementException} will be thrown if a view does not exist for this instance's type.
 *
 */
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
