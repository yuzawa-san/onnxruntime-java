/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.example.onnxruntime_sample_application;

import com.example.onnxruntime_sample_library.MyOracle;
import java.util.Random;

public final class Application {

    public static final void main(String[] args) throws Exception {
        try (MyOracle oracle = new MyOracle()) {
            Random random = new Random();
            for (int i = 0; i < 1000; i++) {
                float expected = random.nextFloat();
                float output = oracle.getIdentity(expected);
                if (expected != output) {
                    throw new IllegalArgumentException("invalid output");
                }
            }
        }
    }
}
