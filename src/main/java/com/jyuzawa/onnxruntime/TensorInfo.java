package com.jyuzawa.onnxruntime;

import java.util.Collection;

public interface TensorInfo {
	
	OnnxTensorElementDataType getType();
	 
	Collection<Long> getShape();
	
	long getElementCount();

}
