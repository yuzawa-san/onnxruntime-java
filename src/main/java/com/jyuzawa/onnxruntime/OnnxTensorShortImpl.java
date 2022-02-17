/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.ShortBuffer;
import java.util.Collection;
import jdk.incubator.foreign.MemorySegment;

final class OnnxTensorShortImpl extends OnnxTensorBufferImpl<ShortBuffer> {

    OnnxTensorShortImpl(TensorInfo tensorInfo) {
        super(tensorInfo, ShortBuffer::allocate);
    }

    @Override
    public ShortBuffer getShortBuffer() {
        return buffer;
    }

    @Override
    protected MemorySegment getMemorySegment() {
        return MemorySegment.ofArray(buffer.array());
    }

    @Override
    public void implodeValues(Collection<OnnxTensorImpl> values) {
        for (OnnxTensorImpl value : values) {
            buffer.put(value.getShortBuffer().get());
        }
    }

    @Override
    public void loadScalarFromVector(int index, OnnxTensorImpl scalar) {
        scalar.getShortBuffer().put(0, buffer.get(index));
    }
}
