package com.jyuzawa.onnxruntime;

import java.util.Collection;

final class TensorInfoImpl implements TensorInfo {
	
	// TODO: symbolic dims
	private final OnnxTensorElementDataType type;
	private final Collection<Long> shape;
	private final long elementCount;
	
	TensorInfoImpl(OnnxTensorElementDataType type, Collection<Long> shape, long elementCount){
		this.type = type;
		this.shape = shape;
		this.elementCount = elementCount;
	}

	@Override
	public OnnxTensorElementDataType getType() {
		return type;
	}

	@Override
	public Collection<Long> getShape() {
		return shape;
	}

	@Override
	public long getElementCount() {
		return elementCount;
	}
	
	public String toString() {
		return "{TensorInfo: type="+type+", shape="+shape+", elementCount="+elementCount+"}";
	}

}
