/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_c_api_h.ORT_API_VERSION;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_c_api_h.OrtGetApiBase;

import com.jyuzawa.onnxruntime_extern.OrtApi;
import com.jyuzawa.onnxruntime_extern.OrtApiBase;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;

// NOTE: this class actually is more like OrtApiBase
enum OnnxRuntimeImpl implements OnnxRuntime {
    INSTANCE;

    private final String version;
    private final ApiImpl api;

    private OnnxRuntimeImpl() {
        Loader.load();
        MemorySession scope = MemorySession.global();
        MemorySegment segment = MemorySegment.ofAddress(OrtGetApiBase().address(), OrtApiBase.sizeof(), scope);
        this.version = OrtApiBase.GetVersionString(segment, scope).apply().getUtf8String(0);
        MemorySegment apiAddress = OrtApiBase.GetApi(segment, scope).apply(ORT_API_VERSION());
        this.api = new ApiImpl(MemorySegment.ofAddress(apiAddress.address(), OrtApi.sizeof(), scope));
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public Api getApi() {
        return api;
    }
}
