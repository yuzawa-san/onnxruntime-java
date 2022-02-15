/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import static jdk.incubator.foreign.CLinker.C_CHAR;

import io.netty.util.CharsetUtil;
import java.util.ArrayList;
import java.util.List;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

final class OnnxMapStringImpl extends OnnxMapImpl<String> {

    OnnxMapStringImpl(MapInfo mapInfo) {
        super(mapInfo);
    }

    @Override
    public OnnxTypedMap<String> asStringMap() {
        return this;
    }

    @Override
    protected List<String> fromNativeMapKeys(
            ApiImpl api,
            MemoryAddress ortAllocator,
            MemoryAddress keysAddress,
            ResourceScope scope,
            SegmentAllocator allocator) {
        MemoryAddress keyInfo = api.create(allocator, out -> api.GetTensorTypeAndShape.apply(keysAddress, out));
        int count =
                Math.toIntExact(api.extractLong(allocator, out -> api.GetTensorShapeElementCount.apply(keyInfo, out)));
        List<String> strings = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            final long index = i;
            long length =
                    api.extractLong(allocator, out -> api.GetStringTensorElementLength.apply(keysAddress, index, out));
            MemorySegment output = allocator.allocateArray(C_CHAR, length);
            api.checkStatus(api.GetStringTensorElement.apply(keysAddress, length, index, output.address()));
            strings.add(new String(output.toByteArray(), CharsetUtil.UTF_8));
        }
        return strings;
    }
}
