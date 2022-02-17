/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.LongBuffer;
import java.util.Collection;
import jdk.incubator.foreign.MemorySegment;

final class OnnxTensorLongImpl extends OnnxTensorBufferImpl<LongBuffer> {

    OnnxTensorLongImpl(TensorInfo tensorInfo) {
        super(tensorInfo, LongBuffer::allocate);
    }

    @Override
    public LongBuffer getLongBuffer() {
        return buffer;
    }

    @Override
    protected MemorySegment getMemorySegment() {
        return MemorySegment.ofArray(buffer.array());
    }

    @Override
    public void implodeValues(Collection<OnnxTensorImpl> values) {
        for (OnnxTensorImpl value : values) {
            buffer.put(value.getLongBuffer().get());
        }
    }

    @Override
    public void loadScalarFromVector(int index, OnnxTensorImpl scalar) {
        scalar.getLongBuffer().put(0, buffer.get(index));
    }
}
