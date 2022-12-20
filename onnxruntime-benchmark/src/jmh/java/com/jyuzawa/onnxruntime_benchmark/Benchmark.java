/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_benchmark;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public final class Benchmark {

    public static final void main(String[] args) throws Exception {
        byte[] bytes;
        try (InputStream is = Benchmark.class.getResourceAsStream("/model.onnx")) {
            bytes = is.readAllBytes();
        }
        List<Wrapper> wrappers = List.of(new OnnxruntimeJava(bytes), new Microsoft(bytes));
        long[] input = new long[] {1, 2, 3};
        long i = 0;
        long startMs = System.currentTimeMillis();
        while (i >= 0) {
            for (Wrapper wrapper : wrappers) {
                long[] output = wrapper.evaluate(input);
                if (!Arrays.equals(input, output)) {
                    throw new RuntimeException("mismatch");
                }
            }
            if (i % 10000 == 0) {
                if (System.currentTimeMillis() - startMs > 60000) {
                    break;
                }
            }
            i++;
        }
    }
}
