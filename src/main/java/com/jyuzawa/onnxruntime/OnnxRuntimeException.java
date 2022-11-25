/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

/**
 * An exception thrown from within the ONNX runtime.
 *
 */
public class OnnxRuntimeException extends RuntimeException {
    private static final int UNKNOWN_CODE = -1;
    private final int code;

    private static final long serialVersionUID = 1322802709564007780L;

    public OnnxRuntimeException(int code) {
        super();
        this.code = code;
    }

    public OnnxRuntimeException() {
        this(UNKNOWN_CODE);
    }

    public OnnxRuntimeException(int code, String message) {
        super(message + " (code=" + code + ")");
        this.code = code;
    }

    public OnnxRuntimeException(String message) {
        this(UNKNOWN_CODE, message);
    }

    public OnnxRuntimeException(String message, Throwable cause) {
        super(message, cause);
        this.code = UNKNOWN_CODE;
    }

    public int getCode() {
        return code;
    }
}
