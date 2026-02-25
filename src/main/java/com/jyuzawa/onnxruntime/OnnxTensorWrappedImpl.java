/*
 * Copyright (c) 2026 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemorySegment;
import java.util.Collection;
import java.util.stream.Stream;

final class OnnxTensorWrappedImpl extends OnnxTensorImpl {

    // this is kept around to ensure automatic arena's know that we are still using it
    private final MemorySegment tensorData;

    protected OnnxTensorWrappedImpl(TensorInfoImpl tensorInfo, ValueContext valueContext, MemorySegment tensorData) {
        super(tensorInfo, valueContext, null);
        if (!tensorData.isNative()) {
            tensorData = arena.allocate(tensorData.byteSize()).copyFrom(tensorData);
        }
        this.tensorData = tensorData;
    }

    @Override
    protected boolean isInitialized() {
        return true;
    }

    @Override
    void putScalars(Collection<OnnxTensorImpl> scalars) {
        throw new UnsupportedOperationException();
    }

    @Override
    void getScalars(Stream<OnnxTensorImpl> scalars) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected MemorySegment toNative() {
        ApiImpl api = valueContext.api();
        return api.create(
                arena,
                out -> api.CreateTensorWithDataAsOrtValue.apply(
                        valueContext.memoryInfoAddress(),
                        tensorData,
                        tensorData.byteSize(),
                        tensorInfo.getShapeData(arena),
                        tensorInfo.getShape().size(),
                        tensorInfo.getType().getNumber(),
                        out),
                api.ReleaseValue::apply);
    }
}
