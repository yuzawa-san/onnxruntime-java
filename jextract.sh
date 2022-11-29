#!/bin/sh

GENERATED_DIR=build/generated/source/jextract
PACKAGE_DIR=${GENERATED_DIR}/com/jyuzawa/onnxruntime_extern
SYMBOLS_CONF=${GENERATED_DIR}/symbols.conf
HEADER_DIR=build/onnxruntime/linux-x86_64-gpu/include
HEADER_FILE=${HEADER_DIR}/onnxruntime_c_api.h
mkdir -p ${PACKAGE_DIR}
docker build -t onnxruntime-java-jextract .
docker run --rm -v `pwd`:/workdir onnxruntime-java-jextract --output ${GENERATED_DIR} -l onnxruntime --source --target-package com.jyuzawa.onnxruntime_extern -I /usr/include -I ${HEADER_DIR} --dump-includes ${SYMBOLS_CONF} onnxruntime_all.h
# strip out the irrelevant symbols
csplit ${SYMBOLS_CONF} "/onnxruntime_c_api.h/"
rm xx00
mv xx01 ${SYMBOLS_CONF}
docker run --rm -v `pwd`:/workdir onnxruntime-java-jextract --output ${GENERATED_DIR} -l onnxruntime --source --target-package com.jyuzawa.onnxruntime_extern -I /usr/include -I ${HEADER_DIR} @${SYMBOLS_CONF} onnxruntime_all.h
# strip out loads since we'll manage load
RUNTIME_HELPER=${PACKAGE_DIR}/RuntimeHelper.java
grep -v "System.loadLibrary" < ${RUNTIME_HELPER} > ${RUNTIME_HELPER}.bak
mv ${RUNTIME_HELPER}.bak ${RUNTIME_HELPER}