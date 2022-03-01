/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.ResourceScope;

class ManagedImpl implements Managed {

    protected final ApiImpl api;
    protected final ResourceScope scope;
    protected final MemoryAddress address;

    protected ManagedImpl(ApiImpl api, ResourceScope scope, MemoryAddress address) {
        this.api = api;
        this.scope = scope;
        this.address = address;
    }

    @Override
    public void close() {
        scope.close();
    }

    @Override
    public String toString() {
        return "{" + getClass().getSimpleName() + ": " + address + "}";
    }
}
