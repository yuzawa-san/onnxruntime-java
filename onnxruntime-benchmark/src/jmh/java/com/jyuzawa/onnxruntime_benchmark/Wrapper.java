/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_benchmark;

public interface Wrapper extends AutoCloseable {

    long[] evaluate(long[] input) throws Exception;
}
