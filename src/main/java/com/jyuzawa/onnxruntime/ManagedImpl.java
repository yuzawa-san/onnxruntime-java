/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;

abstract class ManagedImpl implements AutoCloseable {

    protected final ApiImpl api;
    protected final MemorySession memorySession;

    protected ManagedImpl(ApiImpl api, MemorySession memorySession) {
        this.api = api;
        this.memorySession = memorySession;
    }

    @Override
    public final void close() {
        memorySession.close();
    }

    abstract MemoryAddress address();

    @Override
    public String toString() {
        return "{" + getClass().getSimpleName() + ": " + address() + "}";
    }
}
