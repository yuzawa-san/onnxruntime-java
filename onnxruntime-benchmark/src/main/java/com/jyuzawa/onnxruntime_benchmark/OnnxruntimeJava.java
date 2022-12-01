/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_benchmark;

import com.jyuzawa.onnxruntime.Environment;
import com.jyuzawa.onnxruntime.NamedCollection;
import com.jyuzawa.onnxruntime.OnnxRuntime;
import com.jyuzawa.onnxruntime.OnnxRuntimeLoggingLevel;
import com.jyuzawa.onnxruntime.OnnxValue;
import com.jyuzawa.onnxruntime.Session;
import com.jyuzawa.onnxruntime.Transaction;
import java.io.IOException;

final class OnnxruntimeJava implements Wrapper {

    private static final Environment ENVIRONMENT = OnnxRuntime.get()
            .getApi()
            .newEnvironment()
            .setLogSeverityLevel(OnnxRuntimeLoggingLevel.WARNING)
            .build();

    private final Session session;

    OnnxruntimeJava(byte[] bytes) throws IOException {
        this.session = ENVIRONMENT.newSession().setByteArray(bytes).build();
    }

    @Override
    public void close() throws Exception {
        session.close();
    }

    @Override
    public long[] evaluate(long[] input) {
        try (Transaction txn = session.newTransaction().build()) {
            txn.addInput(0).asTensor().getLongBuffer().put(input);
            txn.addOutput(0);
            NamedCollection<OnnxValue> result = txn.run();
            long[] output = new long[input.length];
            result.get(0).asTensor().getLongBuffer().get(output);
            return output;
        }
    }
}
