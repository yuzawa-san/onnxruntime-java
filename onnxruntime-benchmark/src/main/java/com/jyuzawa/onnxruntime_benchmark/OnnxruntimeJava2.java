/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_benchmark;

import com.jyuzawa.onnxruntime.ExecutionProvider;
import com.jyuzawa.onnxruntime.IoBinding;
import com.jyuzawa.onnxruntime.Session;
import java.io.IOException;
import java.nio.LongBuffer;
import java.util.Map;

final class OnnxruntimeJava2 implements Wrapper {

    private final Session session;
    private final IoBinding ioBinding;
    private final LongBuffer inputBuf;
    private final LongBuffer outputBuf;

    OnnxruntimeJava2(byte[] bytes, boolean arena) throws IOException {
        this.session = OnnxruntimeJava.ENVIRONMENT
                .newSession()
                .setByteArray(bytes)
                .addProvider(ExecutionProvider.CPU_EXECUTION_PROVIDER, Map.of("use_arena", arena ? "1" : "0"))
                .build();
        this.ioBinding = session.newIoBinding().bindInput(0).bindOutput(0).build();
        this.inputBuf = ioBinding.getInputs().get(0).asTensor().getLongBuffer();
        this.outputBuf = ioBinding.getOutputs().get(0).asTensor().getLongBuffer();
    }

    @Override
    public void close() throws Exception {
        ioBinding.close();
        session.close();
    }

    @Override
    public long[] evaluate(long[] input) {
        inputBuf.clear().put(input);
        ioBinding.run();
        long[] output = new long[input.length];
        outputBuf.rewind().get(output);
        return output;
    }
}
