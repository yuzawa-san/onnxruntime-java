#!/bin/sh

# TODO: enable jextract
# GENERATED_DIR=build/generated/source/jextract
GENERATED_DIR=src/main/java
OS_ARCH=linux-x86_64-gpu
HEADER_DIR=build/onnxruntime-${ORT_VERSION}/${OS_ARCH}/include
HEADER_FILE=${HEADER_DIR}/onnxruntime_c_api.h
rm -rf 'symbols.conf' 'src/main/java/com/jyuzawa/onnxruntime_extern'
/Users/jtyuzawa/Downloads/jextract-panama/build/jextract/bin/jextract --output ${GENERATED_DIR} -l onnxruntime --source --target-package com.jyuzawa.onnxruntime_extern -I /Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk/usr/include -I ${HEADER_DIR} --dump-includes symbols.conf ${HEADER_FILE}
# strip out the irrelevant symbols
csplit symbols.conf "/onnxruntime_c_api.h/"
rm xx00
mv xx01 symbols.conf
/Users/jtyuzawa/Downloads/jextract-panama/build/jextract/bin/jextract --output ${GENERATED_DIR} -l onnxruntime --source --target-package com.jyuzawa.onnxruntime_extern -I /Applications/Xcode.app/Contents/Developer/Platforms/MacOSX.platform/Developer/SDKs/MacOSX.sdk/usr/include -I ${HEADER_DIR} @symbols.conf ${HEADER_FILE}
# strip out loads since we'll manage load
RUNTIME_HELPER=${GENERATED_DIR}/com/jyuzawa/onnxruntime_extern/RuntimeHelper.java
grep -v "System.loadLibrary" < ${RUNTIME_HELPER} > ${RUNTIME_HELPER}.bak
mv ${RUNTIME_HELPER}.bak ${RUNTIME_HELPER}