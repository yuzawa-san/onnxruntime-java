/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.nio.LongBuffer;
import java.util.Collection;
import java.util.stream.Stream;
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
    public void putScalars(Collection<OnnxTensorImpl> scalars) {
        for (OnnxTensorImpl scalar : scalars) {
            buffer.put(scalar.getLongBuffer().get());
        }
    }

    @Override
    public void getScalars(Stream<OnnxTensorImpl> scalars) {
        scalars.forEach(scalar -> scalar.getLongBuffer().put(buffer.get()).flip());
    }
}
