#!/bin/sh

jextract (){
	docker run --rm -v `pwd`:/workdir `docker build -q .` $@
}

GENERATED_DIR=build/generated/source/jextract
OS_ARCH=linux-x64-gpu
HEADER_DIR=build/onnxruntime-${ORT_VERSION}/onnxruntime-${OS_ARCH}-${ORT_VERSION}/include
HEADER_FILE=${HEADER_DIR}/onnxruntime_c_api.h
jextract --output ${GENERATED_DIR} -l onnxruntime --source --target-package com.jyuzawa.onnxruntime_extern -I /usr/include -I ${HEADER_DIR} --dump-includes symbols.conf onnxruntime_all.h
# strip out the irrelevant symbols
csplit symbols.conf "/onnxruntime_c_api.h/"
rm xx00
mv xx01 symbols.conf
jextract --output ${GENERATED_DIR} -l onnxruntime --source --target-package com.jyuzawa.onnxruntime_extern -I /usr/include -I ${HEADER_DIR} @symbols.conf onnxruntime_all.h
# strip out loads since we'll manage load
RUNTIME_HELPER=${GENERATED_DIR}/com/jyuzawa/onnxruntime_extern/RuntimeHelper.java
sed -i ".bak" "/System.loadLibrary/d" "${RUNTIME_HELPER}"
rm ${RUNTIME_HELPER}.bak