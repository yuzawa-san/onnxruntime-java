/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.ByteBuffer;

final class InputBuilderImpl implements Input.Builder {

    final NodeInfo nodeInfo;
    ByteBuffer tensorBuffer;

    InputBuilderImpl(NodeInfo nodeInfo) {
        this.nodeInfo = nodeInfo;
        TensorInfo tensorInfo = nodeInfo.getTypeInfo().getTensorInfo();
        // TODO: pooling
        this.tensorBuffer = ByteBuffer.allocateDirect(Math.toIntExact(tensorInfo.getByteCount()));
    }

    @Override
    public ByteBuffer getTensorBuffer() {
        return tensorBuffer;
    }
}
