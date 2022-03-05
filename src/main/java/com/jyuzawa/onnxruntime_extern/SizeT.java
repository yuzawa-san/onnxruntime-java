package com.jyuzawa.onnxruntime_extern;

import java.util.function.LongFunction;

 enum SizeT {
	NIX( "J", x-> x), WINDOWS( "J", x-> Math.toIntExact(x));
	
	 static final boolean IS_WINDOWS = System.getProperty("os.name", "").toLowerCase().startsWith("windows");

 final String descriptor;
 final LongFunction<Object> cast;

private SizeT(String descriptor, LongFunction<Object> cast) {
	this.descriptor= descriptor;
	this.cast = cast;
}

static SizeT get() {
	return IS_WINDOWS? WINDOWS: NIX;
}

}
