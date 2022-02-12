/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

public interface OnnxValue {

    OnnxType getType();

    boolean isTensor();

    OnnxTensor asTensor();

    boolean isSequence();

    OnnxSequence asSequence();

    boolean isMap();

    OnnxMap<Byte> asByteMap();

    OnnxMap<Short> asShortMap();

    OnnxMap<Integer> asIntegerMap();

    OnnxMap<Long> asLongMap();

    OnnxMap<String> asStringMap();

    boolean isOpaque();

    OnnxOpaque asOpaque();

    boolean isSparseTensor();

    OnnxSparseTensor asSparseTensor();

    boolean isOptional();

    OnnxOptional asOptional();
}
