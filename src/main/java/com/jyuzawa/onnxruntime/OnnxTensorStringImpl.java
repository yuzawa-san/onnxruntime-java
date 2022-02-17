/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import static jdk.incubator.foreign.CLinker.C_CHAR;
import static jdk.incubator.foreign.CLinker.C_LONG;
import static jdk.incubator.foreign.CLinker.C_POINTER;
import static jdk.incubator.foreign.CLinker.toCString;

import io.netty.util.CharsetUtil;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import jdk.incubator.foreign.Addressable;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
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
    public MemoryAddress toNative(
            ApiImpl api,
            MemoryAddress ortAllocator,
            MemoryAddress memoryInfo,
            ResourceScope scope,
            SegmentAllocator allocator) {

        int numOutputs = buffer.length;
        Addressable[] stringsAddresses = new Addressable[numOutputs];
        for (int i = 0; i < numOutputs; i++) {
            stringsAddresses[i] = toCString(buffer[i], scope);
        }
        MemorySegment stringArray = allocator.allocateArray(C_POINTER, stringsAddresses);

        List<Long> shape = tensorInfo.getShape();
        int shapeSize = shape.size();
        MemorySegment shapeData = allocator.allocateArray(C_LONG, shape(shape));
        MemoryAddress tensor = api.create(
                allocator,
                out -> api.CreateTensorAsOrtValue.apply(
                        ortAllocator,
                        shapeData.address(),
                        shapeSize,
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
            ResourceScope scope,
            SegmentAllocator allocator) {
        int numOutputs = buffer.length;
        for (int i = 0; i < numOutputs; i++) {
            final long index = i;
            long length =
                    api.extractLong(allocator, out -> api.GetStringTensorElementLength.apply(address, index, out));
            MemorySegment output = allocator.allocateArray(C_CHAR, length);
            api.checkStatus(api.GetStringTensorElement.apply(address, length, index, output.address()));
            buffer[i] = new String(output.toByteArray(), CharsetUtil.UTF_8);
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
    public void getScalars(List<OnnxTensorImpl> scalars) {
        int i = 0;
        for (OnnxTensorImpl scalar : scalars) {
            scalar.getStringBuffer()[0] = buffer[i++];
        }
    }
}
