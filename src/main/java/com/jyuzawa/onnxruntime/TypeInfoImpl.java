package com.jyuzawa.onnxruntime;

import static jdk.incubator.foreign.CLinker.C_POINTER;
import static jdk.incubator.foreign.CLinker.C_LONG;
import static jdk.incubator.foreign.CLinker.C_INT;


import static jdk.incubator.foreign.CLinker.toJavaString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.jyuzawa.onnxruntime.extern.OrtApi;

import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;
import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;

final class TypeInfoImpl implements TypeInfo {
	
	// TODO: denotation
	private final OnnxType type;
	private final TensorInfo tensorInfo;
	private final MapInfo mapInfo;
	private final SequenceInfo sequenceInfo;
	
	TypeInfoImpl(ApiImpl api, MemoryAddress typeInfo, MemoryAddress ortAllocator){
		try(ResourceScope scope = ResourceScope.newConfinedScope()){
			SegmentAllocator allocator = SegmentAllocator.ofScope(scope);
			MemorySegment typePointer = allocator.allocate(C_INT);
			api.checkStatus(api.GetOnnxTypeFromTypeInfo.apply(typeInfo, typePointer.address()));
			this.type = OnnxType.forNumber(MemoryAccess.getInt(typePointer));
			
			TensorInfo tensorInfo = null;
			MapInfo mapInfo = null;
			SequenceInfo sequenceInfo = null;
			
			if(type== OnnxType.TENSOR) {
				MemoryAddress ortTensorInfo = api.create(allocator, out-> api.CastTypeInfoToTensorInfo.apply(typeInfo, out));
				OnnxTensorElementDataType dataType = OnnxTensorElementDataType.forNumber(api.extractInt(allocator, out -> api.GetTensorElementType.apply(ortTensorInfo, out)));
				long dimCount = api.extractInt(allocator, out -> api.GetDimensionsCount.apply(ortTensorInfo, out));
				MemorySegment dims = allocator.allocateArray(C_LONG, dimCount);
				api.checkStatus(api.GetDimensions.apply(ortTensorInfo, dims.address(), dimCount));
				long elementCount = api.extractInt(allocator, out -> api.GetTensorShapeElementCount.apply(ortTensorInfo, out));
				List<Long> shape = new ArrayList<>(Math.toIntExact(dimCount));
				for(long value : dims.toLongArray()) {
					shape.add(value);
				}
				tensorInfo = new TensorInfoImpl(dataType, Collections.unmodifiableList(shape), elementCount);
				api.ReleaseTensorTypeAndShapeInfo.apply(ortTensorInfo);
			} else {
				throw new IllegalArgumentException("unsupported type: "+type);
			}
			
			this.tensorInfo = tensorInfo;
			this.mapInfo = mapInfo;
			this.sequenceInfo = sequenceInfo;
		}
	}

	@Override
	public OnnxType getType() {
		return type;
	}

	@Override
	public TensorInfo getTensorInfo() {
		if(tensorInfo == null) {
			throw new IllegalStateException("tensor");
		}
		return tensorInfo;
	}

	@Override
	public MapInfo getMapInfo() {
		if(mapInfo == null) {
			throw new IllegalStateException("map");
		}
		return mapInfo;
	}

	@Override
	public SequenceInfo getSequenceInfo() {
		if(sequenceInfo == null) {
			throw new IllegalStateException("sequence");
		}
		return sequenceInfo;
	}
	
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append("{TypeInfo: type=").append(type);
		if(tensorInfo!= null) {
			out.append(", tensorInfo=").append(tensorInfo);
		}else if(mapInfo!= null) {
			out.append(", mapInfo=").append(mapInfo);
		}else if(sequenceInfo!= null) {
			out.append(", sequenceInfo=").append(sequenceInfo);
		}
		return out.append("}").toString();
	}

}
