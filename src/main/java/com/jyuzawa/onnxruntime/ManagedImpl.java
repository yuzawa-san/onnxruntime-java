/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

abstract class ManagedImpl implements AutoCloseable {

    protected final ApiImpl api;
    protected final Arena arena;

    protected ManagedImpl(ApiImpl api, Arena arena) {
        this.api = api;
        this.arena = arena;
    }

    @Override
    public void close() {
        arena.close();
    }

    abstract MemorySegment address();

    @Override
    public String toString() {
        return "{" + getClass().getSimpleName() + ": " + address() + "}";
    }
}
