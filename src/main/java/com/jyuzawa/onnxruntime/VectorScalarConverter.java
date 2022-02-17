/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

interface VectorScalarConverter extends OnnxValueConverter {

    void loadVectorFromScalar(int index, OnnxTensorImpl scalar);

    void loadScalarFromVector(int index, OnnxTensorImpl scalar);
}
