/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.ORT_API_VERSION;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.OrtGetApiBase;

import com.jyuzawa.onnxruntime_extern.OrtApiBase;
import java.lang.System.Logger.Level;
import java.lang.foreign.MemorySegment;

// NOTE: this class actually is more like OrtApiBase
enum OnnxRuntimeImpl implements OnnxRuntime {
    INSTANCE;

    private final String version;
    private final ApiImpl api;
    private final int ortApiVersion;

    private OnnxRuntimeImpl() {
        Loader.load();
        MemorySegment segment = OrtGetApiBase();
        this.ortApiVersion = ORT_API_VERSION();
        MemorySegment apiAddress = OrtApiBase.GetApi.invoke(OrtApiBase.GetApi(segment), ortApiVersion);
        if (MemorySegment.NULL.address() == apiAddress.address()) {
            throw new UnsatisfiedLinkError(
                    "Onnxruntime native library present, but does not provide API version " + ortApiVersion);
        }
        this.version = OrtApiBase.GetVersionString.invoke(OrtApiBase.GetVersionString(segment))
                .getString(0);
        this.api = new ApiImpl(apiAddress);
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
