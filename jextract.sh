#!/bin/sh

# TODO: enable jextract
# GENERATED_DIR=build/generated/source/jextract
GENERATED_DIR=src/main/java
HEADER_DIR=build/onnxruntime-${ORT_VERSION}/headers
mkdir -p ${HEADER_DIR}
cp build/onnxruntime-${ORT_VERSION}/osx-x86_64/include/*.h ${HEADER_DIR}
cp build/onnxruntime-${ORT_VERSION}/linux-x86_64-gpu/include/*.h ${HEADER_DIR}
HEADER_FILE=onnxruntime_all.h
rm -rf 'symbols.conf' 'src/main/java/com/jyuzawa/onnxruntime_extern'
docker build -t onnxruntime-jextract .
 /Users/jtyuzawa/Documents/personal_repos/jextract/build/jextract/bin/jextract --use-system-load-library --output ${GENERATED_DIR} -l onnxruntime --target-package com.jyuzawa.onnxruntime_extern -I /usr/include -I /usr/include/x86_64-linux-gnu -I ${HEADER_DIR} --dump-includes symbols.conf ${HEADER_FILE}
# strip out the irrelevant symbols
csplit symbols.conf "/headers/"
rm xx00
mv xx01 symbols.conf
 /Users/jtyuzawa/Documents/personal_repos/jextract/build/jextract/bin/jextract --use-system-load-library --output ${GENERATED_DIR} -l onnxruntime --target-package com.jyuzawa.onnxruntime_extern -I /usr/include -I /usr/include/x86_64-linux-gnu -I ${HEADER_DIR} @symbols.conf ${HEADER_FILE}
 # strip out loads since we'll manage load
 RUNTIME_HELPER=${GENERATED_DIR}/com/jyuzawa/onnxruntime_extern/onnxruntime_all_h.java
 grep -v "System.loadLibrary" < ${RUNTIME_HELPER} > ${RUNTIME_HELPER}.bak
 mv ${RUNTIME_HELPER}.bak ${RUNTIME_HELPER}
 