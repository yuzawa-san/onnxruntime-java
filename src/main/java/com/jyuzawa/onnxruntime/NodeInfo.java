/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

/**
 * A tuple of name and type information.
 *
 */
public interface NodeInfo {

    String getName();

    TypeInfo getTypeInfo();
}
