/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.ByteBuffer;

final class OutputImpl implements Output, Value {
    private final ByteBuffer byteBuffer;

    OutputImpl(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    @Override
    public ByteBuffer getTensorBuffer() {
        return byteBuffer;
    }
}
