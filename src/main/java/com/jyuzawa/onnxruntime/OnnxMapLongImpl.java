/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.util.ArrayList;
import java.util.List;
import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

final class OnnxMapLongImpl extends OnnxMapImpl<Long> {

    OnnxMapLongImpl(MapInfo mapInfo) {
        super(mapInfo);
    }

    @Override
    public OnnxTypedMap<Long> asLongMap() {
        return this;
    }

    @Override
    protected List<Long> fromNativeMapKeys(
            ApiImpl api,
            MemoryAddress ortAllocator,
            MemoryAddress keysAddress,
            ResourceScope scope,
            SegmentAllocator allocator) {
        MemoryAddress keyInfo = api.create(allocator, out -> api.GetTensorTypeAndShape.apply(keysAddress, out));
        int count =
                Math.toIntExact(api.extractLong(allocator, out -> api.GetTensorShapeElementCount.apply(keyInfo, out)));
        MemoryAddress keyContentAddress =
                api.create(allocator, out -> api.GetTensorMutableData.apply(keysAddress, out));
        MemorySegment keySegment = keyContentAddress.asSegment(
                mapInfo.getKeyType().getValueLayout().byteSize() * count, scope);
        List<Long> out = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            out.add(MemoryAccess.getLongAtIndex(keySegment, i));
        }
        return out;
    }
}
