/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import static jdk.incubator.foreign.CLinker.C_LONG;
import static jdk.incubator.foreign.CLinker.C_POINTER;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.List;
import java.util.function.IntFunction;
import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

abstract class OnnxTensorImpl<T extends Buffer> extends OnnxValueImpl implements OnnxTensor {

    protected final TensorInfo tensorInfo;
    protected final T buffer;

    OnnxTensorImpl(TensorInfo tensorInfo, IntFunction<T> factory) {
        super(OnnxType.TENSOR);
        this.tensorInfo = tensorInfo;
        this.buffer = factory.apply(Math.toIntExact(tensorInfo.getElementCount()));
    }
    
    public String toString() {
    	return "{OnnxTensor: info="+tensorInfo+", buffer="+buffer+"}";
    }

    @Override
    public OnnxTensor asTensor() {
        return this;
    }

    @Override
    public TensorInfo getInfo() {
        return tensorInfo;
    }

    private final IllegalStateException fail() {
        return new IllegalStateException("OnnxTensor with type " + tensorInfo.getType() + " only uses "
                + buffer.getClass().getSimpleName());
    }

    public ByteBuffer getByteBuffer() {
        throw fail();
    }

    public ShortBuffer getShortBuffer() {
        throw fail();
    }

    public IntBuffer getIntBuffer() {
        throw fail();
    }

    public LongBuffer getLongBuffer() {
        throw fail();
    }

    public FloatBuffer getFloatBuffer() {
        throw fail();
    }

    public DoubleBuffer getDoubleBuffer() {
        throw fail();
    }

    public String[] getStringBuffer() {
        throw fail();
    }

    protected static final long[] shape(List<Long> original) {
        int shapeSize = original.size();
        long[] shapeArray = new long[shapeSize];
        for (int i = 0; i < shapeSize; i++) {
            shapeArray[i] = original.get(i);
        }
        return shapeArray;
    }

    final MemoryAddress toNative(ApiImpl api, MemoryAddress memoryInfo, SegmentAllocator allocator) {
        MemorySegment rawInputData = getMemorySegment();
        // TODO: move value layout to this class?
        MemorySegment inputData =
                allocator.allocateArray(tensorInfo.getType().getValueLayout(), rawInputData.byteSize());
        inputData.copyFrom(rawInputData);
        List<Long> shape = tensorInfo.getShape();
        int shapeSize = shape.size();
        MemorySegment shapeData = allocator.allocateArray(C_LONG, shape(shape));
        return api.create(
                allocator,
                out -> api.CreateTensorWithDataAsOrtValue.apply(
                        memoryInfo,
                        inputData.address(),
                        inputData.byteSize(),
                        shapeData.address(),
                        shapeSize,
                        tensorInfo.getType().getNumber(),
                        out));
    }

    final void fromNative(ApiImpl api, MemoryAddress address, ResourceScope scope, SegmentAllocator allocator) {
        MemorySegment floatOutput = allocator.allocate(C_POINTER);
        api.checkStatus(api.GetTensorMutableData.apply(address, floatOutput.address()));
        MemorySegment segment = MemoryAccess.getAddress(floatOutput).asSegment(tensorInfo.getByteCount(), scope);
        getMemorySegment().copyFrom(segment);
    }

    protected abstract MemorySegment getMemorySegment();

    static final OnnxTensorImpl<?> fromTypeInfo(TensorInfo tensorInfo) {
        OnnxTensorElementDataType type = tensorInfo.getType();
        switch (type) {
            case FLOAT:
                return new OnnxTensorFloatImpl(tensorInfo);
            default:
                throw new UnsupportedOperationException("OnnxTensor with type " + type + " is not supported");
        }
    }
}
