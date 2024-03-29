/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.ORT_API_VERSION;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.OrtGetApiBase;

import com.jyuzawa.onnxruntime_extern.OrtApi;
import com.jyuzawa.onnxruntime_extern.OrtApiBase;
import java.lang.System.Logger.Level;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;

// NOTE: this class actually is more like OrtApiBase
enum OnnxRuntimeImpl implements OnnxRuntime {
    INSTANCE;

    private final String version;
    private final ApiImpl api;
    private final int ortApiVersion;

    private OnnxRuntimeImpl() {
        Loader.load();
        MemorySession scope = MemorySession.global();
        MemorySegment segment = MemorySegment.ofAddress(OrtGetApiBase(), OrtApiBase.sizeof(), scope);
        this.ortApiVersion = ORT_API_VERSION();
        MemoryAddress apiAddress =
                OrtApiBase.GetApi(segment, scope).apply(ortApiVersion).address();
        if (apiAddress == MemoryAddress.NULL) {
            throw new UnsatisfiedLinkError(
                    "Onnxruntime native library present, but does not provide API version " + ortApiVersion);
        }
        this.version =
                OrtApiBase.GetVersionString(segment, scope).apply().address().getUtf8String(0);
        this.api = new ApiImpl(MemorySegment.ofAddress(apiAddress, OrtApi.sizeof(), scope));
        System.getLogger(OnnxRuntimeImpl.class.getName())
                .log(
                        Level.DEBUG,
                        "Version: {0}, API Version: {1}, Build Info: {2}",
                        version,
                        ortApiVersion,
                        api.getBuildString());
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public Api getApi() {
        return api;
    }

    @Override
    public int getApiVersion() {
        return ortApiVersion;
    }
}
