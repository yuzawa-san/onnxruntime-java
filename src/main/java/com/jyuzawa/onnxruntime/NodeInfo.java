/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

/**
 * A tuple of name and type information.
 *
 * @since 1.0.0
 */
public interface NodeInfo {

    /**
     * Get the node's name.
     * @return name
     */
    String getName();

    /**
     * Get the type information for this node.
     * @return type information
     */
    TypeInfo getTypeInfo();
}
