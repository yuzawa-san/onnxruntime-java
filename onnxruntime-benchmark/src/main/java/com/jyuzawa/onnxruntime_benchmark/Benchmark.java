/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_benchmark;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public final class Benchmark {

    public static final void main(String[] args) throws Exception {
        Path path = Path.of(Benchmark.class.getResource("/model.onnx").toURI());
        List<Wrapper> wrappers = List.of(new OnnxruntimeJava(path), new Microsoft(path));
        long[] input = new long[] {1, 2, 3};
        for (int i = 0; i < 100000000; i++) {
            for (Wrapper wrapper : wrappers) {
                long[] output = wrapper.evaluate(input);
                if(!Arrays.equals(input, output)) {
                	throw new RuntimeException("mismatch");
                }
            }
        }
    }
}
