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
 * @since 1.0.0
 */
public interface OnnxTensor {

    /**
     * Get tensor information: shape, type, etc.
     * @return type info
     */
    TensorInfo getInfo();

    /**
     * Get a byte view.
     * @return buffer
     * @throws NoSuchElementException if this typed view does not exist
     */
    ByteBuffer getByteBuffer();

    /**
     * Get a short view.
     * @return buffer
     * @throws NoSuchElementException if this typed view does not exist
     */
    ShortBuffer getShortBuffer();

    /**
     * Get a int view.
     * @return buffer
     * @throws NoSuchElementException if this typed view does not exist
     */
    IntBuffer getIntBuffer();

    /**
     * Get a long view.
     * @return buffer
     * @throws NoSuchElementException if this typed view does not exist
     */
    LongBuffer getLongBuffer();

    /**
     * Get a float view.
     * @return buffer
     * @throws NoSuchElementException if this typed view does not exist
     */
    FloatBuffer getFloatBuffer();

    /**
     * Get a double view.
     * @return buffer
     * @throws NoSuchElementException if this typed view does not exist
     */
    DoubleBuffer getDoubleBuffer();

    /**
     * Get a string view.
     * @return string array
     * @throws NoSuchElementException if this typed view does not exist
     */
    String[] getStringBuffer();
}
