/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

public enum OnnxType {
    UNKNOWN(0),
    TENSOR(1),
    SEQUENCE(2),
    MAP(3),
    OPAQUE(4),
    SPARSETENSOR(5),
    OPTIONAL(6);

    private final int number;

    private OnnxType(int number) {
        this.number = number;
    }

    int getNumber() {
        return number;
    }

    static final OnnxType forNumber(int number) {
        switch (number) {
            case 1:
                return TENSOR;
            case 2:
                return SEQUENCE;
            case 3:
                return MAP;
            case 4:
                return OPAQUE;
            case 5:
                return SPARSETENSOR;
            case 6:
                return OPTIONAL;
            case 0:
            default:
                return UNKNOWN;
        }
    }
}
