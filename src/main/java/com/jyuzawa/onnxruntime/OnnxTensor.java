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
 * The relevant view will depend on the number of bits of the tensor's type. Consider the following examples:
 * <ul>
 * <li>INT32 will use an IntBuffer.
 * <li>UINT32 will use a IntBuffer. It is on the caller to convert the 32 bit ints to the relevant unsigned int representation.
 * <li>DOUBLE will use a DoubleBuffer.
 * <li>FLOAT16 will use a ShortBuffer (not a FloatBuffer!). It is on the caller to convert the 16 bit shorts to the relevant 32-bit float representation.
 * <li>COMPLEX64 will use a FloatBuffer, since each of the constituent real/imaginary components are floats.
 * <li>COMPLEX128 will use a DoubleBuffer, since each of the constituent real/imaginary components are doubles.
 * <li>FLOAT8E4M3FN will use a ByteBuffer. It is on the caller to convert the 8 bit bytes to the relevant 32-bit float representation.
 * <li>INT2 will use a ByteBuffer.
 * </ul>
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
