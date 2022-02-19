all: build/generated/jextract/com/jyuzawa/onnxruntime_extern/onnxruntime_all_h.java build/jnioutput/linux-x86_64/META-INF/native/libonnxruntime-linux-x86_64.so build/jnioutput/linux-aarch_64/META-INF/native/libonnxruntime-linux-aarch_64.so build/jnioutput/windows-x86_64/META-INF/native/onnxruntime-windows-x86_64.dll build/jnioutput/windows-aarch_64/META-INF/native/onnxruntime-windows-aarch_64.dll build/jnioutput/osx-x86_64/META-INF/native/libonnxruntime-osx-x86_64.jnilib build/jnioutput/osx-aarch_64/META-INF/native/libonnxruntime-osx-aarch_64.jnilib build/jnioutput/linux-x86_64-gpu/META-INF/native/libonnxruntime-linux-x86_64.so build/jnioutput/windows-x86_64-gpu/META-INF/native/onnxruntime-windows-x86_64.dll

clean:
	rm -rf build/jnioutput

# get linux and windows from npm package
build/onnxruntime/package/package.json:
	mkdir -p build/onnxruntime
	cd build/onnxruntime && \
	curl -OL https://registry.npmjs.org/onnxruntime-node/-/onnxruntime-node-${ORT_VERSION}.tgz && \
	tar xvzf onnxruntime-node-${ORT_VERSION}.tgz

build/jnioutput/linux-x86_64/META-INF/native/libonnxruntime-linux-x86_64.so: build/onnxruntime/package/package.json
	mkdir -p build/jnioutput/linux-x86_64/META-INF/native && \
	cp build/onnxruntime/package/bin/napi-v3/linux/x64/libonnxruntime.so.${ORT_VERSION} build/jnioutput/linux-x86_64/META-INF/native/libonnxruntime-linux-x86_64.so

build/jnioutput/linux-aarch_64/META-INF/native/libonnxruntime-linux-aarch_64.so: build/onnxruntime/package/package.json
	mkdir -p build/jnioutput/linux-aarch_64/META-INF/native
	cp build/onnxruntime/package/bin/napi-v3/linux/arm64/libonnxruntime.so.${ORT_VERSION} build/jnioutput/linux-aarch_64/META-INF/native/libonnxruntime-linux-aarch_64.so

build/jnioutput/windows-x86_64/META-INF/native/onnxruntime-windows-x86_64.dll: build/onnxruntime/package/package.json
	mkdir -p build/jnioutput/windows-x86_64/META-INF/native
	cp build/onnxruntime/package/bin/napi-v3/win32/x64/onnxruntime.dll build/jnioutput/windows-x86_64/META-INF/native/onnxruntime-windows-x86_64.dll

build/jnioutput/windows-aarch_64/META-INF/native/onnxruntime-windows-aarch_64.dll: build/onnxruntime/package/package.json
	mkdir -p build/jnioutput/windows-aarch_64/META-INF/native
	cp build/onnxruntime/package/bin/napi-v3/win32/arm64/onnxruntime.dll build/jnioutput/windows-aarch_64/META-INF/native/onnxruntime-windows-aarch_64.dll

build/jnioutput/osx-x86_64/META-INF/native/libonnxruntime-osx-x86_64.jnilib: build/onnxruntime/package/package.json
	mkdir -p build/jnioutput/osx-x86_64/META-INF/native && \
	cp build/onnxruntime/package/bin/napi-v3/darwin/x64/libonnxruntime.${ORT_VERSION}.dylib build/jnioutput/osx-x86_64/META-INF/native/libonnxruntime-osx-x86_64.jnilib

build/jnioutput/osx-aarch_64/META-INF/native/libonnxruntime-osx-aarch_64.jnilib: build/onnxruntime/package/package.json
	mkdir -p build/jnioutput/osx-aarch_64/META-INF/native
	cp build/onnxruntime/package/bin/napi-v3/darwin/arm64/libonnxruntime.${ORT_VERSION}.dylib build/jnioutput/osx-aarch_64/META-INF/native/libonnxruntime-osx-aarch_64.jnilib

build/onnxruntime/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include/onnxruntime_cxx_api.h:
	mkdir -p build/onnxruntime
	cd build/onnxruntime && \
	curl -OL https://github.com/microsoft/onnxruntime/releases/download/v${ORT_VERSION}/onnxruntime-linux-x64-gpu-${ORT_VERSION}.tgz && \
	tar xvzf onnxruntime-linux-x64-gpu-${ORT_VERSION}.tgz

build/jnioutput/linux-x86_64-gpu/META-INF/native/libonnxruntime-linux-x86_64.so: build/onnxruntime/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include/onnxruntime_cxx_api.h
	mkdir -p build/jnioutput/linux-x86_64-gpu/META-INF/native && \
	cp build/onnxruntime/onnxruntime-linux-x64-gpu-1.10.0/lib/libonnxruntime.so build/jnioutput/linux-x86_64-gpu/META-INF/native/libonnxruntime-linux-x86_64.so

build/onnxruntime/onnxruntime-win-x64-gpu-${ORT_VERSION}/include/onnxruntime_cxx_api.h:
	mkdir -p build/onnxruntime
	cd build/onnxruntime && \
	curl -OL https://github.com/microsoft/onnxruntime/releases/download/v${ORT_VERSION}/onnxruntime-win-x64-gpu-${ORT_VERSION}.zip && \
	unzip onnxruntime-win-x64-gpu-${ORT_VERSION}.zip

build/jnioutput/windows-x86_64-gpu/META-INF/native/onnxruntime-windows-x86_64.dll: build/onnxruntime/onnxruntime-win-x64-gpu-${ORT_VERSION}/include/onnxruntime_cxx_api.h
	mkdir -p build/jnioutput/windows-x86_64-gpu/META-INF/native && \
	cp build/onnxruntime/onnxruntime-win-x64-gpu-1.10.0/lib/onnxruntime.dll build/jnioutput/windows-x86_64-gpu/META-INF/native/onnxruntime-windows-x86_64.dll

# manually generate the symbols (and manually strip out the irrelevant symbols)
onnxruntime_all.h.conf: build/onnxruntime/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include/onnxruntime_cxx_api.h
	docker run --rm -v $(PWD):/workdir jextract -d /workdir/build/generated/jextract -l onnxruntime --source --target-package com.jyuzawa.onnxruntime_extern -I /usr/include -I build/onnxruntime/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include --dump-includes symbols.conf onnxruntime_all.h

build/generated/jextract/com/jyuzawa/onnxruntime_extern/onnxruntime_all_h.java: build/onnxruntime/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include/onnxruntime_cxx_api.h
	docker run --rm -v $(PWD):/workdir jextract -d /workdir/build/generated/jextract -l onnxruntime --source --target-package com.jyuzawa.onnxruntime_extern -I /usr/include -I build/onnxruntime/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include @symbols.conf onnxruntime_all.h
	# strip out loads since we'll manage load
	sed -i .bak '/System.loadLibrary/d' build/generated/jextract/com/jyuzawa/onnxruntime_extern/onnxruntime_all_h.java
