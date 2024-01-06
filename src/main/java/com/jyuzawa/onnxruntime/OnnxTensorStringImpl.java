/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_CHAR;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

final class OnnxTensorStringImpl extends OnnxTensorImpl {

    private final String[] buffer;

    OnnxTensorStringImpl(TensorInfoImpl tensorInfo, ValueContext valueContext, MemorySegment ortValueAddress) {
        super(tensorInfo, valueContext);
        this.buffer = new String[Math.toIntExact(tensorInfo.getElementCount())];
        if (ortValueAddress != null) {
            ApiImpl api = valueContext.api();
            SegmentAllocator segmentAllocator = valueContext.segmentAllocator();
            int numOutputs = buffer.length;
            for (int i = 0; i < numOutputs; i++) {
                final long index = i;
                long length = api.extractLong(
                        segmentAllocator, out -> api.GetStringTensorElementLength.apply(ortValueAddress, index, out));
                // add a byte for the null termination
                MemorySegment output = segmentAllocator.allocate(C_CHAR, length + 1);
                api.checkStatus(api.GetStringTensorElement.apply(ortValueAddress, length, index, output));
                buffer[i] = output.getString(0);
            }
        }
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
    public MemorySegment toNative() {
        int numOutputs = buffer.length;
        ApiImpl api = valueContext.api();
        SegmentAllocator allocator = valueContext.segmentAllocator();
        MemorySegment stringArray = allocator.allocate(C_POINTER, numOutputs);
        for (int i = 0; i < numOutputs; i++) {
            stringArray.setAtIndex(C_POINTER, i, allocator.allocateFrom(buffer[i]));
        }
        MemorySegment tensor = api.create(
                allocator,
                out -> api.CreateTensorAsOrtValue.apply(
                        valueContext.ortAllocatorAddress(),
                        tensorInfo.shapeData,
                        tensorInfo.getShape().size(),
                        tensorInfo.getType().getNumber(),
                        out));
        api.checkStatus(api.FillStringTensor.apply(tensor, stringArray, numOutputs));
        return tensor;
    }

    @Override
    public void putScalars(Collection<OnnxTensorImpl> scalars) {
        int i = 0;
        for (OnnxTensorImpl scalar : scalars) {
            buffer[i++] = scalar.getStringBuffer()[0];
        }
    }

    @Override
    public void getScalars(Stream<OnnxTensorImpl> scalars) {
        int i = 0;
        Iterator<OnnxTensorImpl> iter = scalars.iterator();
        while (iter.hasNext()) {
            OnnxTensorImpl scalar = iter.next();
            scalar.getStringBuffer()[0] = buffer[i++];
        }
    }
}
