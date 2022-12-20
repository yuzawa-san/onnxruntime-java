/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_benchmark;

import java.util.Map;

import ai.onnxruntime.OnnxTensor;
import ai.onnxruntime.OrtEnvironment;
import ai.onnxruntime.OrtLoggingLevel;
import ai.onnxruntime.OrtSession;
import ai.onnxruntime.OrtSession.Result;

final class Microsoft implements Wrapper {

    private static final OrtEnvironment ENVIRONMENT =
            OrtEnvironment.getEnvironment(OrtLoggingLevel.ORT_LOGGING_LEVEL_WARNING);

    private final OrtSession session;
    private final String inputName;

    Microsoft(byte[] bytes) throws Exception {
        this.session = ENVIRONMENT.createSession(bytes);
        this.inputName = session.getInputNames().iterator().next();
    }

    @Override
    public void close() throws Exception {
        session.close();
    }

    @Override
    public long[] evaluate(long[] input) throws Exception {
    	
        try (OnnxTensor tensor = OnnxTensor.createTensor(ENVIRONMENT, new long[][] {input});
                Result result = session.run(Map.of(inputName, tensor))) {
            return ((long[][]) result.get(0).getValue())[0];
        }
    }
}
