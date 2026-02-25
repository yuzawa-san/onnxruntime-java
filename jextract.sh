#!/bin/sh

# TODO: enable jextract
# GENERATED_DIR=build/generated/source/jextract
GENERATED_DIR=src/main/java
HEADER_DIR=build/jextract-headers
rm -rf ${HEADER_DIR}
mkdir -p ${HEADER_DIR}
cp build/onnxruntime-${ORT_VERSION}/osx-aarch_64/include/*.h ${HEADER_DIR}
cp build/onnxruntime-${ORT_VERSION}/linux-x86_64-gpu/include/*.h ${HEADER_DIR}
HEADER_FILE=onnxruntime_all.h
rm -rf 'symbols.conf' 'src/main/java/com/jyuzawa/onnxruntime_extern'
jextract --use-system-load-library --output ${GENERATED_DIR} -l onnxruntime --target-package com.jyuzawa.onnxruntime_extern -I /usr/include -I ${HEADER_DIR} --dump-includes symbols.conf ${HEADER_FILE}
# strip out the irrelevant symbols
grep jextract-headers symbols.conf > symbols-filtered.conf
jextract --use-system-load-library --output ${GENERATED_DIR} -l onnxruntime --target-package com.jyuzawa.onnxruntime_extern -I /usr/include -I ${HEADER_DIR} @symbols-filtered.conf ${HEADER_FILE}
# strip out loads since we'll manage load
RUNTIME_HELPER=${GENERATED_DIR}/com/jyuzawa/onnxruntime_extern/onnxruntime_all_h.java
grep -v "System.loadLibrary" < ${RUNTIME_HELPER} > ${RUNTIME_HELPER}.bak
mv ${RUNTIME_HELPER}.bak ${RUNTIME_HELPER}
# windows is weird with longs
sed -i -e 's/"long"/System.getProperty("os.name").contains("indows") ? "long long" : "long"/g' "${GENERATED_DIR}/com/jyuzawa/onnxruntime_extern/onnxruntime_all_h\$shared.java"
