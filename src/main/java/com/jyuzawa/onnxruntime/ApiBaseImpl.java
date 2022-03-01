/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.ORT_API_VERSION;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.OrtGetApiBase;
import static jdk.incubator.foreign.CLinker.toJavaString;

import com.jyuzawa.onnxruntime_extern.OrtApi;
import com.jyuzawa.onnxruntime_extern.OrtApiBase;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;

enum ApiBaseImpl implements ApiBase {
    INSTANCE;

    private final String version;
    private final ApiImpl api;

    private ApiBaseImpl() {
        Loader.load();
        ResourceScope scope = ResourceScope.globalScope();
        MemorySegment segment = OrtGetApiBase().asSegment(OrtApiBase.sizeof(), scope);
        this.version = toJavaString(OrtApiBase.GetVersionString(segment).apply());
        MemoryAddress apiAddress = OrtApiBase.GetApi(segment).apply(ORT_API_VERSION());
        this.api = new ApiImpl(apiAddress.asSegment(OrtApi.sizeof(), scope));
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
