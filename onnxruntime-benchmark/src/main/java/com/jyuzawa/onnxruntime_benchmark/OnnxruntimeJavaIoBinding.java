/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_benchmark;

import com.jyuzawa.onnxruntime.IoBinding;
import java.io.IOException;
import java.nio.LongBuffer;

final class OnnxruntimeJavaIoBinding extends OnnxruntimeJava {

    private final IoBinding ioBinding;
    private final LongBuffer inputBuf;
    private final LongBuffer outputBuf;

    OnnxruntimeJavaIoBinding(byte[] bytes, boolean arena, int size) throws IOException {
        super(bytes, arena, size);
        this.ioBinding = session.newIoBinding().bindInput(0).bindOutput(0).build();
        this.inputBuf = ioBinding.getInputs().get(0).asTensor().getLongBuffer();
        this.outputBuf = ioBinding.getOutputs().get(0).asTensor().getLongBuffer();
    }

    @Override
    public void close() throws Exception {
        ioBinding.close();
        super.close();
    }

    @Override
    public long[] evaluate(long[] input) {
        inputBuf.clear().put(input);
        ioBinding.run();
        outputBuf.rewind().get(out);
        return out;
    }
}
