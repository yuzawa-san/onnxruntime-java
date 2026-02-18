/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.List;
import java.util.NoSuchElementException;

abstract class OnnxValueImpl implements OnnxValue {

    protected final Arena arena;
    protected final OnnxType type;
    protected final ValueContext valueContext;
    protected MemorySegment ortValueAddress;

    protected OnnxValueImpl(OnnxType type, ValueContext valueContext, MemorySegment ortValueAddress) {
        this.arena = valueContext.autoRelease() ? Arena.ofAuto() : Arena.ofShared();
        this.type = type;
        this.valueContext = valueContext;
        if (ortValueAddress != null) {
            ortValueAddress = ortValueAddress.reinterpret(arena, valueContext.api().ReleaseValue::apply);
        }
        this.ortValueAddress = ortValueAddress;
    }

    @Override
    public final OnnxType getType() {
        return type;
    }

    @Override
    public OnnxTensor asTensor() {
        throw new NoSuchElementException("OnnxValue is not a tensor");
    }

    @Override
    public OnnxTensor asTensor(List<Long> shape) {
        throw new NoSuchElementException("OnnxValue is not a tensor");
    }

    @Override
    public OnnxSequence asSequence() {
        throw new NoSuchElementException("OnnxValue is not a sequence");
    }

    @Override
    public OnnxMap asMap() {
        throw new NoSuchElementException("OnnxValue is not a map");
    }

    // @Override
    // public OnnxOpaque asOpaque() {
    // throw new NoSuchElementException("OnnxValue is not an opaque");
    // }
    //
    // @Override
    // public OnnxSparseTensor asSparseTensor() {
    // throw new NoSuchElementException("OnnxValue is not a sparse tensor");
    // }
    //
    // @Override
    // public OnnxOptional asOptional() {
    // throw new NoSuchElementException("OnnxValue is not an optional");
    // }

    protected abstract MemorySegment toNative();

    final MemorySegment getNative() {
        if (!arena.scope().isAlive()) {
            throw new IllegalStateException("value has already been disposed");
        }
        if (ortValueAddress == null) {
            ortValueAddress = toNative();
        }
        return ortValueAddress;
    }

    void dispose() {
        if (!valueContext.autoRelease()) {
            arena.close();
        }
    }
}
