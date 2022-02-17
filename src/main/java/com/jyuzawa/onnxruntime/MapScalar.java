/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.util.List;

interface MapScalar<T> {

    void put(int index, T scalar);

    List<T> getValues();
}
