all: build/generated/jextract/com/jyuzawa/onnxruntime_extern/onnxruntime_all_h.java

clean:
	rm -rf build/jnioutput

# get linux and windows from npm package
build/onnxruntime/package/package.json:
	mkdir -p build/onnxruntime
	mkdir -p build/jnioutput/META-INF/native/
	cd build/onnxruntime && \
	curl -OL https://registry.npmjs.org/onnxruntime-node/-/onnxruntime-node-${ORT_VERSION}.tgz && \
	tar xvzf onnxruntime-node-${ORT_VERSION}.tgz

build/jnioutput/META-INF/native/libonnxruntime_linux_x86_64.so: build/onnxruntime/package/package.json
	cp build/onnxruntime/package/bin/napi-v3/linux/x64/libonnxruntime.so.${ORT_VERSION} build/jnioutput/META-INF/native/libonnxruntime_linux_x86_64.so

build/jnioutput/META-INF/native/libonnxruntime_linux_aarch_64.so: build/onnxruntime/package/package.json
	cp build/onnxruntime/package/bin/napi-v3/linux/arm64/libonnxruntime.so.${ORT_VERSION} build/jnioutput/META-INF/native/libonnxruntime_linux_aarch_64.so

build/onnxruntime/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include/onnxruntime_cxx_api.h:
	mkdir -p build/onnxruntime
	mkdir -p build/jnioutput/META-INF/native/
	cd build/onnxruntime && \
	curl -OL https://github.com/microsoft/onnxruntime/releases/download/v${ORT_VERSION}/onnxruntime-linux-x64-gpu-${ORT_VERSION}.tgz && \
	tar xvzf onnxruntime-linux-x64-gpu-${ORT_VERSION}.tgz

build/jnioutput/META-INF/native/libonnxruntime_osx_universal2.jnilib:
	mkdir -p build/onnxruntime
	mkdir -p build/jnioutput/META-INF/native/
	cd build/onnxruntime && \
	curl -OL https://github.com/microsoft/onnxruntime/releases/download/v${ORT_VERSION}/onnxruntime-osx-universal2-${ORT_VERSION}.tgz && \
	tar xvzf onnxruntime-osx-universal2-${ORT_VERSION}.tgz
	cp build/onnxruntime/onnxruntime-osx-universal2-${ORT_VERSION}/lib/libonnxruntime.${ORT_VERSION}.dylib build/jnioutput/META-INF/native/libonnxruntime_osx_universal2.jnilib

# manually generate the symbols (and manually strip out the irrelevant symbols)
onnxruntime_all.h.conf: build/onnxruntime/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include/onnxruntime_cxx_api.h
	docker run --rm -v $(PWD):/workdir jextract -d /workdir/build/generated/jextract -l onnxruntime --source --target-package com.jyuzawa.onnxruntime_extern -I /usr/include -I build/onnxruntime/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include --dump-includes symbols.conf onnxruntime_all.h

build/generated/jextract/com/jyuzawa/onnxruntime_extern/onnxruntime_all_h.java: build/onnxruntime/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include/onnxruntime_cxx_api.h build/jnioutput/META-INF/native/libonnxruntime_linux_x86_64.so build/jnioutput/META-INF/native/libonnxruntime_linux_aarch_64.so build/jnioutput/META-INF/native/libonnxruntime_osx_universal2.jnilib
	docker run --rm -v $(PWD):/workdir jextract -d /workdir/build/generated/jextract -l onnxruntime --source --target-package com.jyuzawa.onnxruntime_extern -I /usr/include -I build/onnxruntime/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include @symbols.conf onnxruntime_all.h
	# strip out loads since we'll manage load
	sed -i .bak '/System.loadLibrary/d' build/generated/jextract/com/jyuzawa/onnxruntime_extern/onnxruntime_all_h.java
