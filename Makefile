all: build/generated/jextract/com/jyuzawa/onnxruntime/extern/OrtApi.java

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

# get headers and mac from github releases
build/onnxruntime/onnxruntime-osx-universal2-${ORT_VERSION}/include/onnxruntime_cxx_api.h:
	mkdir -p build/onnxruntime
	mkdir -p build/jnioutput/META-INF/native/
	cd build/onnxruntime && \
	curl -OL https://github.com/microsoft/onnxruntime/releases/download/v${ORT_VERSION}/onnxruntime-osx-universal2-${ORT_VERSION}.tgz && \
	tar xvzf onnxruntime-osx-universal2-${ORT_VERSION}.tgz

build/jnioutput/META-INF/native/libonnxruntime_osx_universal2.jnilib: build/onnxruntime/onnxruntime-osx-universal2-${ORT_VERSION}/include/onnxruntime_cxx_api.h
	cp build/onnxruntime/onnxruntime-osx-universal2-${ORT_VERSION}/lib/libonnxruntime.${ORT_VERSION}.dylib build/jnioutput/META-INF/native/libonnxruntime_osx_universal2.jnilib

# manually generate the symbols (and manually strip out the irrelevant symbols)
symbols.conf: build/onnxruntime/onnxruntime-osx-universal2-${ORT_VERSION}/include/onnxruntime_cxx_api.h build/jnioutput/META-INF/native/libonnxruntime_osx_universal2.jnilib
	jextract -d build/generated/jextract -l onnxruntime --source --target-package com.jyuzawa.onnxruntime.extern -I /Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk/usr/include -I $(PWD)/build/onnxruntime/onnxruntime-osx-universal2-${ORT_VERSION}/include --dump-includes symbols.conf $(PWD)/build/onnxruntime/onnxruntime-osx-universal2-${ORT_VERSION}/include/onnxruntime_c_api.h

build/generated/jextract/com/jyuzawa/onnxruntime/extern/OrtApi.java: build/jnioutput/META-INF/native/libonnxruntime_linux_x86_64.so build/jnioutput/META-INF/native/libonnxruntime_linux_aarch_64.so build/jnioutput/META-INF/native/libonnxruntime_osx_universal2.jnilib
	jextract -d build/generated/jextract -l onnxruntime --source --target-package com.jyuzawa.onnxruntime.extern -I /Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk/usr/include -I $(PWD)/build/onnxruntime/onnxruntime-osx-universal2-${ORT_VERSION}/include @symbols.conf $(PWD)/build/onnxruntime/onnxruntime-osx-universal2-${ORT_VERSION}/include/onnxruntime_c_api.h