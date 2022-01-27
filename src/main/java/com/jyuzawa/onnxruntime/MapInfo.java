package com.jyuzawa.onnxruntime;

public interface MapInfo {
	
	int getSize();
	
	OnnxTensorElementDataType getKeyType();
	
	TypeInfo getValueType();
}
