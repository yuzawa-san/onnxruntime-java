/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

public interface OnnxValue {

    OnnxType getType();

    OnnxTensor asTensor();

    OnnxSequence asSequence();

    OnnxMap asMap();

    //    OnnxOpaque asOpaque();

    //    OnnxSparseTensor asSparseTensor();

    //    OnnxOptional asOptional();
}
