/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

/**
 * A preference for sequential or parallel execution.
 *
 */
public enum OnnxRuntimeExecutionMode {
    SEQUENTIAL(0),
    PARALLEL(1);

    private final int number;

    private OnnxRuntimeExecutionMode(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static final OnnxRuntimeExecutionMode forNumber(int number) {
        switch (number) {
            case 1:
                return PARALLEL;
            case 0:
            default:
                return SEQUENTIAL;
        }
    }
}
