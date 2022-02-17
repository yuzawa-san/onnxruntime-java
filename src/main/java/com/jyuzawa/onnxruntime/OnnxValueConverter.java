/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

interface OnnxValueConverter {

    MemoryAddress toNative(
            ApiImpl api,
            MemoryAddress ortAllocator,
            MemoryAddress memoryInfo,
            ResourceScope scope,
            SegmentAllocator allocator);

    void fromNative(
            ApiImpl api,
            MemoryAddress ortAllocator,
            MemoryAddress address,
            ResourceScope scope,
            SegmentAllocator allocator);
}
