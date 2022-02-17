/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.DoubleBuffer;
import java.util.Collection;
import jdk.incubator.foreign.MemorySegment;

final class OnnxTensorDoubleImpl extends OnnxTensorBufferImpl<DoubleBuffer> {

    OnnxTensorDoubleImpl(TensorInfo tensorInfo) {
        super(tensorInfo, DoubleBuffer::allocate);
    }

    @Override
    public DoubleBuffer getDoubleBuffer() {
        return buffer;
    }

    @Override
    protected MemorySegment getMemorySegment() {
        return MemorySegment.ofArray(buffer.array());
    }

    @Override
    public void implodeValues(Collection<OnnxTensorImpl> values) {
        for (OnnxTensorImpl value : values) {
            buffer.put(value.getDoubleBuffer().get());
        }
    }

    @Override
    public void loadScalarFromVector(int index, OnnxTensorImpl scalar) {
        scalar.getDoubleBuffer().put(0, buffer.get(index));
    }
}
