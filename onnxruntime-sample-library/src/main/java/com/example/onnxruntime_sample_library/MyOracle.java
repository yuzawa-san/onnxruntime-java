/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.example.onnxruntime_sample_library;

import com.jyuzawa.onnxruntime.Environment;
import com.jyuzawa.onnxruntime.NamedCollection;
import com.jyuzawa.onnxruntime.OnnxRuntime;
import com.jyuzawa.onnxruntime.OnnxValue;
import com.jyuzawa.onnxruntime.Session;
import com.jyuzawa.onnxruntime.Transaction;
import java.io.IOException;
import java.io.InputStream;

public final class MyOracle implements AutoCloseable {

    private static final Environment ENVIRONMENT =
            OnnxRuntime.get().getApi().newEnvironment().build();
    private final Session session;

    public MyOracle() throws IOException {
        try (InputStream is = this.getClass().getResourceAsStream("/floatIdentity.onnx")) {
            this.session =
                    ENVIRONMENT.newSession().setByteArray(is.readAllBytes()).build();
        }
    }

    public float getIdentity(float input) {
        try (Transaction txn = session.newTransaction().build()) {
            txn.addInput(0).asTensor().getFloatBuffer().put(input);
            txn.addOutput(0);
            NamedCollection<OnnxValue> result = txn.run();
            return result.get(0).asTensor().getFloatBuffer().get();
        }
    }

    @Override
    public void close() {
        session.close();
    }
}
