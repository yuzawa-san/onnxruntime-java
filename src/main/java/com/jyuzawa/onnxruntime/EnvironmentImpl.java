/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.ResourceScope;

final class EnvironmentImpl extends ManagedImpl implements Environment {

    EnvironmentImpl(ApiImpl api, ResourceScope scope, MemoryAddress address) {
        super(api, scope, address);
    }

    public Session.Builder newSession() {
        return new SessionBuilderImpl(api, address);
    }

    @Override
    public void setTelemetryEvents(boolean enabled) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLanguageProjection(int languageProjection) {
        // TODO Auto-generated method stub

    }
}
