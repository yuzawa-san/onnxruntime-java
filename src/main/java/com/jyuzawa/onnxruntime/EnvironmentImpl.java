/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySession;

final class EnvironmentImpl extends ManagedImpl implements Environment {

    EnvironmentImpl(ApiImpl api, MemorySession scope, MemoryAddress address) {
        super(api, scope, address);
    }

    @Override
    public Session.Builder newSession() {
        return new SessionBuilderImpl(api, address);
    }

    @Override
    public void setTelemetryEvents(boolean enabled) {
        if (enabled) {
            api.checkStatus(api.EnableTelemetryEvents.apply(address));
        } else {
            api.checkStatus(api.DisableTelemetryEvents.apply(address));
        }
    }

    //    @Override
    //    public void setLanguageProjection(int languageProjection) {
    //        api.checkStatus(api.SetLanguageProjection.apply(address, languageProjection));
    //    }
}
