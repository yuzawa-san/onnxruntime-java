/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.util.Collection;
import java.util.List;

/**
 * A sequence view of an {@link OnnxValue}. Extends {@link java.util.List} but
 * 1) add/set operations are restricted to respect ONNX type information 2)
 * views are immutable.
 *
 */
public interface OnnxSequence extends List<OnnxValue> {

    /**
     *
     * @return The description of the type of the elements in the sequence.
     */
    TypeInfo getInfo();

    /**
     *
     * @return A new OnnxValue of correct type added to the end of the sequence.
     */
    OnnxValue add();

    /**
     *
     * @param index
     * @return A new OnnxValue of correct type set at the index in the sequence.
     */
    OnnxValue set(int index);

    /**
     *
     * @param index
     * @return A new OnnxValue of correct type added to the sequence at the index.
     */
    OnnxValue add(int index);

    /**
     * WARNING: Elements can only be added using {@link OnnxSequence#add()}.
     *
     * @throws UnsupportedOperationException
     */
    @Override
    default boolean add(OnnxValue e) {
        throw new UnsupportedOperationException("Elements can only be added using OnnxSequence.add()");
    }

    /**
     * WARNING: Elements can only be added using {@link OnnxSequence#add()}.
     *
     * @throws UnsupportedOperationException
     */
    @Override
    default boolean addAll(Collection<? extends OnnxValue> c) {
        throw new UnsupportedOperationException("Elements can only be added using OnnxSequence.add()");
    }

    /**
     * WARNING: Elements can only be added using {@link OnnxSequence#add()}.
     *
     * @throws UnsupportedOperationException
     */
    @Override
    default boolean addAll(int index, Collection<? extends OnnxValue> c) {
        throw new UnsupportedOperationException("Elements can only be added using OnnxSequence.add()");
    }

    /**
     * WARNING: Elements can only be set using {@link OnnxSequence#set(int)}.
     *
     * @throws UnsupportedOperationException
     */
    @Override
    default OnnxValue set(int index, OnnxValue element) {
        throw new UnsupportedOperationException("Elements can only be set using OnnxSequence.set(int)");
    }

    /**
     * WARNING: Elements can only be added at index using
     * {@link OnnxSequence#add(int)}.
     *
     * @throws UnsupportedOperationException
     */
    @Override
    default void add(int index, OnnxValue element) {
        throw new UnsupportedOperationException("Elements can only be added at index using OnnxSequence.add(int)");
    }
}
