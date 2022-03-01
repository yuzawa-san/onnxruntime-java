/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

public class OrtException extends RuntimeException {
    private static final int UNKNOWN_CODE = -1;
    private final int code;

    private static final long serialVersionUID = 1322802709564007780L;

    public OrtException(int code) {
        super();
        this.code = code;
    }

    public OrtException() {
        this(UNKNOWN_CODE);
    }

    public OrtException(int code, String message) {
        super(message);
        this.code = code;
    }

    public OrtException(String message) {
        this(UNKNOWN_CODE, message);
    }

    public OrtException(String message, Throwable cause) {
        super(message, cause);
        this.code = UNKNOWN_CODE;
    }

    public int getCode() {
        return code;
    }
}
