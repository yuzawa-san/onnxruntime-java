all: build/onnxruntime-${ORT_VERSION}/linux-aarch_64/com/jyuzawa/onnxruntime/native/linux-aarch_64/libraries build/onnxruntime-${ORT_VERSION}/linux-x86_64/com/jyuzawa/onnxruntime/native/linux-x86_64/libraries build/onnxruntime-${ORT_VERSION}/linux-x86_64-gpu/com/jyuzawa/onnxruntime/native/linux-x86_64/libraries build/onnxruntime-${ORT_VERSION}/osx-x86_64/com/jyuzawa/onnxruntime/native/osx-x86_64/libraries build/onnxruntime-${ORT_VERSION}/osx-aarch_64/com/jyuzawa/onnxruntime/native/osx-aarch_64/libraries build/onnxruntime-${ORT_VERSION}/windows-aarch_64/com/jyuzawa/onnxruntime/native/windows-aarch_64/libraries build/onnxruntime-${ORT_VERSION}/windows-x86_64/com/jyuzawa/onnxruntime/native/windows-x86_64/libraries build/onnxruntime-${ORT_VERSION}/windows-x86_64-gpu/com/jyuzawa/onnxruntime/native/windows-x86_64/libraries

clean:
	rm -rf build/onnxruntime*

# linux aarch64 shim, since its not in the main releases
build/onnxruntime-${ORT_VERSION}/linux-aarch_64/com/jyuzawa/onnxruntime/native/linux-aarch_64/libraries:
	mkdir -p build/onnxruntime-${ORT_VERSION}
	cd build/onnxruntime-${ORT_VERSION} && \
	curl -OL https://registry.npmjs.org/onnxruntime-node/-/onnxruntime-node-${ORT_VERSION}.tgz && \
	tar xvzf onnxruntime-node-${ORT_VERSION}.tgz
	mkdir -p build/onnxruntime-${ORT_VERSION}/linux-aarch_64/com/jyuzawa/onnxruntime/native/linux-aarch_64
	cp build/onnxruntime-${ORT_VERSION}/package/bin/napi-v3/linux/arm64/libonnxruntime.so.${ORT_VERSION} build/onnxruntime-${ORT_VERSION}/linux-aarch_64/com/jyuzawa/onnxruntime/native/linux-aarch_64/libonnxruntime.so
	echo libonnxruntime.so > build/onnxruntime-${ORT_VERSION}/linux-aarch_64/com/jyuzawa/onnxruntime/native/linux-aarch_64/libraries

build/onnxruntime-${ORT_VERSION}/linux-x86_64/com/jyuzawa/onnxruntime/native/linux-x86_64/libraries:
	./download.sh ${ORT_VERSION} linux-x86_64 "" linux-x64 tgz so

build/onnxruntime-${ORT_VERSION}/linux-x86_64-gpu/com/jyuzawa/onnxruntime/native/linux-x86_64/libraries:
	./download.sh ${ORT_VERSION} linux-x86_64 -gpu linux-x64-gpu tgz so

build/onnxruntime-${ORT_VERSION}/osx-x86_64/com/jyuzawa/onnxruntime/native/osx-x86_64/libraries:
	./download.sh ${ORT_VERSION} osx-x86_64 "" osx-x86_64 tgz dylib

build/onnxruntime-${ORT_VERSION}/osx-aarch_64/com/jyuzawa/onnxruntime/native/osx-aarch_64/libraries:
	./download.sh ${ORT_VERSION} osx-aarch_64 "" osx-arm64 tgz dylib

build/onnxruntime-${ORT_VERSION}/windows-aarch_64/com/jyuzawa/onnxruntime/native/windows-aarch_64/libraries:
	./download.sh ${ORT_VERSION} windows-aarch_64 "" win-arm64 zip dll

build/onnxruntime-${ORT_VERSION}/windows-x86_64/com/jyuzawa/onnxruntime/native/windows-x86_64/libraries:
	./download.sh ${ORT_VERSION} windows-x86_64 "" win-x64 zip dll

build/onnxruntime-${ORT_VERSION}/windows-x86_64-gpu/com/jyuzawa/onnxruntime/native/windows-x86_64/libraries:
	./download.sh ${ORT_VERSION} windows-x86_64 -gpu win-x64-gpu zip dll

# manually generate the symbols (and manually strip out the irrelevant symbols)
src/main/java/com/jyuzawa/onnxruntime_extern/onnxruntime_all_h.java: build/onnxruntime-${ORT_VERSION}/linux-x86_64-gpu/com/jyuzawa/onnxruntime/native/linux-x86_64/libraries
	sed -i .bak 's/size_t/unsigned long long/g' build/onnxruntime-${ORT_VERSION}/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include/onnxruntime_c_api.h
	sed -i .bak 's/uint64_t/unsigned long long/g' build/onnxruntime-${ORT_VERSION}/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include/onnxruntime_c_api.h
	sed -i .bak 's/int64_t/long long/g' build/onnxruntime-${ORT_VERSION}/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include/onnxruntime_c_api.h
	rm build/onnxruntime-${ORT_VERSION}/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include/onnxruntime_c_api.h.bak
	docker run --rm -v $(PWD):/workdir `docker build -q .` -d /workdir/src/main/java -l onnxruntime --source --target-package com.jyuzawa.onnxruntime_extern -I /usr/include -I build/onnxruntime-${ORT_VERSION}/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include --dump-includes symbols.conf onnxruntime_all.h
	# strip out the irrelevant symbols
	csplit symbols.conf "/onnxruntime_c_api.h/"
	rm xx00
	mv xx01 symbols.conf
	docker run --rm -v $(PWD):/workdir `docker build -q .` -d /workdir/src/main/java -l onnxruntime --source --target-package com.jyuzawa.onnxruntime_extern -I /usr/include -I build/onnxruntime-${ORT_VERSION}/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include @symbols.conf onnxruntime_all.h
	# strip out loads since we'll manage load
	sed -i .bak '/System.loadLibrary/d' src/main/java/com/jyuzawa/onnxruntime_extern/onnxruntime_all_h.java
	rm src/main/java/com/jyuzawa/onnxruntime_extern/onnxruntime_all_h.java.bak