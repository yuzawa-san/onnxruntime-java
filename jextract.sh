#!/bin/sh

GENERATED_DIR=build/generated/source/jextract
OS_ARCH=linux-x64-gpu
HEADER_DIR=build/onnxruntime-${ORT_VERSION}/onnxruntime-${OS_ARCH}-${ORT_VERSION}/include
HEADER_FILE=${HEADER_DIR}/onnxruntime_c_api.h
sed -i .bak 's/size_t/unsigned long long/g' ${HEADER_FILE}
sed -i .bak 's/uint64_t/unsigned long long/g' ${HEADER_FILE}
sed -i .bak 's/int64_t/long long/g' ${HEADER_FILE}
rm ${HEADER_FILE}.bak
docker run --rm -v $(PWD):/workdir `docker build -q .` --output ${GENERATED_DIR} -l onnxruntime --source --target-package com.jyuzawa.onnxruntime_extern -I /usr/include -I ${HEADER_DIR} --dump-includes symbols.conf onnxruntime_all.h
# strip out the irrelevant symbols
csplit symbols.conf "/onnxruntime_c_api.h/"
rm xx00
mv xx01 symbols.conf
docker run --rm -v $(PWD):/workdir `docker build -q .` --output ${GENERATED_DIR} -l onnxruntime --source --target-package com.jyuzawa.onnxruntime_extern -I /usr/include -I ${HEADER_DIR} @symbols.conf onnxruntime_all.h
# strip out loads since we'll manage load
RUNTIME_HELPER=${GENERATED_DIR}/com/jyuzawa/onnxruntime_extern/RuntimeHelper.java
sed -i .bak '/System.loadLibrary/d' ${RUNTIME_HELPER}
rm ${RUNTIME_HELPER}.bak