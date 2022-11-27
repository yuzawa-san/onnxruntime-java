/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.util.NoSuchElementException;

abstract class OnnxValueImpl implements OnnxValue {

    protected final OnnxType type;
    protected final ValueContext valueContext;

    protected OnnxValueImpl(OnnxType type, ValueContext valueContext) {
        this.type = type;
        this.valueContext = valueContext;
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

    abstract MemoryAddress toNative();
}
