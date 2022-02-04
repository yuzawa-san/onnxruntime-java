/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
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

    public void close() {
        scope.close();
    }

    public String toString() {
        return "{" + getClass().getSimpleName() + ": " + address + "}";
    }
}
