/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;

class ManagedImpl {

    protected final ApiImpl api;
    protected final MemorySession scope;
    protected final MemoryAddress address;

    protected ManagedImpl(ApiImpl api, MemorySession scope, MemoryAddress address) {
        this.api = api;
        this.scope = scope;
        this.address = address;
    }

    public void close() {
        scope.close();
    }

    @Override
    public String toString() {
        return "{" + getClass().getSimpleName() + ": " + address + "}";
    }
}
