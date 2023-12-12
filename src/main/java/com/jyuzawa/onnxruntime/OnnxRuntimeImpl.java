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
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

// NOTE: this class actually is more like OrtApiBase
enum OnnxRuntimeImpl implements OnnxRuntime {
    INSTANCE;

    private final String version;
    private final ApiImpl api;
    private final int ortApiVersion;

    private OnnxRuntimeImpl() {
        Loader.load();
        Arena scope = Arena.global();
        MemorySegment segment = OrtGetApiBase().reinterpret(OrtApiBase.sizeof());
        this.ortApiVersion = ORT_API_VERSION();
        MemorySegment apiAddress = OrtApiBase.GetApi(segment, scope).apply(ortApiVersion);
        if (MemorySegment.NULL.equals(apiAddress)) {
            throw new UnsatisfiedLinkError(
                    "Onnxruntime native library present, but does not provide API version " + ortApiVersion);
        }
        this.version = OrtApiBase.GetVersionString(segment, scope).apply().getUtf8String(0);
        MemorySegment apiSegment = OrtApiBase.GetApi(segment, scope).apply(ORT_API_VERSION());
        this.api = new ApiImpl(apiSegment.reinterpret(OrtApi.sizeof()));
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
