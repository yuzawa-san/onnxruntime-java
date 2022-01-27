package com.jyuzawa.onnxruntime;

public interface Managed extends AutoCloseable {
	void close();
}
