/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.util.Arrays;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

final class OnnxTensorStringImpl extends OnnxTensorImpl {

    private final String[] buffer;

    OnnxTensorStringImpl(TensorInfo tensorInfo) {
        super(tensorInfo);
        this.buffer = new String[Math.toIntExact(tensorInfo.getElementCount())];
    }

    @Override
    public String toString() {
        return "{OnnxTensor: info=" + tensorInfo + ", buffer=" + Arrays.toString(buffer) + "}";
    }

    @Override
    public String[] getStringBuffer() {
        return buffer;
    }

    @Override
    MemoryAddress toNative(ApiImpl api, MemoryAddress memoryInfo, SegmentAllocator allocator) {
        // TODO: implement this
        return null;
    }

    @Override
    void fromNative(ApiImpl api, MemoryAddress address, ResourceScope scope, SegmentAllocator allocator) {
        // TODO: implement this
    }
}
