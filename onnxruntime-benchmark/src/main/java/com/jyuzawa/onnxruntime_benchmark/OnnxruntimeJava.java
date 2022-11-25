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
import java.nio.file.Path;

final class OnnxruntimeJava implements Wrapper {

    private static final Environment ENVIRONMENT = OnnxRuntime.get()
            .getApi()
            .newEnvironment()
            .setLogSeverityLevel(OnnxRuntimeLoggingLevel.WARNING)
            .build();

    private final Session session;

    OnnxruntimeJava(Path modelPath) throws IOException {
        this.session = ENVIRONMENT.newSession().setPath(modelPath).build();
    }

    @Override
    public void close() throws Exception {
        session.close();
    }

    @Override
    public long[] evaluate(long[] input) {
        Transaction.Builder txn = session.newTransaction();
        txn.addInput(0).asTensor().getLongBuffer().put(input);
        txn.addOutput(0);
        NamedCollection<OnnxValue> result = txn.build().run();
        long[] output = new long[input.length];
        result.get(0).asTensor().getLongBuffer().get(output);
        return output;
    }
}
