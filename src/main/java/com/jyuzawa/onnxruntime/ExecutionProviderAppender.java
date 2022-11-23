/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;
import java.util.Map;

abstract class ExecutionProviderAppender {

    protected final Map<String, String> properties;

    protected ExecutionProviderAppender(Map<String, String> properties) {
        this.properties = properties;
    }

    abstract void appendToSessionOptions(MemorySession memorySession, ApiImpl api, MemoryAddress sessionOptions);
}
