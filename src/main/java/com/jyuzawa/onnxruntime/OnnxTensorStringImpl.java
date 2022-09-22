/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_CHAR;
import static java.lang.foreign.ValueLayout.JAVA_LONG;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

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
    public MemoryAddress toNative(
            ApiImpl api, MemoryAddress ortAllocator, MemoryAddress memoryInfo, MemorySession allocator) {

        int numOutputs = buffer.length;
        MemorySegment stringArray = allocator.allocateArray(ADDRESS, numOutputs);
        for (int i = 0; i < numOutputs; i++) {
            stringArray.setAtIndex(ADDRESS, i, allocator.allocateUtf8String(buffer[i]));
        }
        List<Long> shape = tensorInfo.getShape();
        int shapeSize = shape.size();
        MemorySegment shapeData = allocator.allocateArray(JAVA_LONG, shape(shape));
        MemoryAddress tensor = api.create(
                allocator,
                out -> api.CreateTensorAsOrtValue.apply(
                        ortAllocator,
                        shapeData.address(),
                        shapeSize,
                        tensorInfo.getType().getNumber(),
                        out));
        api.checkStatus(api.FillStringTensor.apply(tensor, stringArray.address(), numOutputs));
        allocator.addCloseAction(() -> {
            api.ReleaseValue.apply(tensor);
        });
        return tensor;
    }

    @Override
    public void fromNative(ApiImpl api, MemoryAddress ortAllocator, MemoryAddress address, MemorySession allocator) {
        int numOutputs = buffer.length;
        for (int i = 0; i < numOutputs; i++) {
            final long index = i;
            long length =
                    api.extractLong(allocator, out -> api.GetStringTensorElementLength.apply(address, index, out));
            MemorySegment output = allocator.allocateArray(JAVA_CHAR, length);
            api.checkStatus(api.GetStringTensorElement.apply(address, length, index, output.address()));
            buffer[i] = output.getUtf8String(0);
        }
        allocator.addCloseAction(() -> {
            api.ReleaseValue.apply(address);
        });
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
