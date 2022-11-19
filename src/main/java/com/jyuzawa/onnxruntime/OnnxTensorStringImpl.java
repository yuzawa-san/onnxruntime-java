/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_CHAR;
import static com.jyuzawa.onnxruntime_extern.onnxruntime_all_h.C_POINTER;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

final class OnnxTensorStringImpl extends OnnxTensorImpl {

    private final String[] buffer;

    OnnxTensorStringImpl(TensorInfoImpl tensorInfo) {
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
    public MemoryAddress toNative(
            ApiImpl api, MemoryAddress ortAllocator, MemoryAddress memoryInfo, SegmentAllocator allocator) {
        int numOutputs = buffer.length;
        MemorySegment stringArray = allocator.allocateArray(C_POINTER, numOutputs);
        for (int i = 0; i < numOutputs; i++) {
            stringArray.setAtIndex(C_POINTER, i, allocator.allocateUtf8String(buffer[i]));
        }
        MemoryAddress tensor = api.create(
                allocator,
                out -> api.CreateTensorAsOrtValue.apply(
                        ortAllocator,
                        tensorInfo.shapeData.address(),
                        tensorInfo.getShape().size(),
                        tensorInfo.getType().getNumber(),
                        out));
        api.checkStatus(api.FillStringTensor.apply(tensor, stringArray.address(), numOutputs));
        return tensor;
    }

    @Override
    public void fromNative(
            ApiImpl api,
            MemoryAddress ortAllocator,
            MemoryAddress address,
            SegmentAllocator allocator,
            MemorySession session) {
        int numOutputs = buffer.length;
        for (int i = 0; i < numOutputs; i++) {
            final long index = i;
            long length =
                    api.extractLong(allocator, out -> api.GetStringTensorElementLength.apply(address, index, out));
            // add a byte for the null termination
            MemorySegment output = allocator.allocateArray(C_CHAR, length + 1);
            api.checkStatus(api.GetStringTensorElement.apply(address, length, index, output.address()));
            buffer[i] = output.getUtf8String(0);
        }
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
