/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.ORT_API_VERSION;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.OrtGetApiBase;
import static jdk.incubator.foreign.CLinker.toJavaString;

import com.jyuzawa.onnxruntime_extern.OrtApi;
import com.jyuzawa.onnxruntime_extern.OrtApiBase;
import io.netty.util.internal.NativeLibraryLoader;
import io.netty.util.internal.PlatformDependent;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;

enum ApiBaseImpl implements ApiBase {
    INSTANCE;

    private final String version;
    private final ApiImpl api;

    private ApiBaseImpl() {
        String os = PlatformDependent.normalizedOs();
        String arch = PlatformDependent.isOsx() ? "universal2" : PlatformDependent.normalizedArch();
        NativeLibraryLoader.load("onnxruntime_" + os + "_" + arch, ApiBase.class.getClassLoader());
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
