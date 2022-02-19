#!/bin/sh

ORT_VERSION=$1
OS_ARCH=$2
GPU_SUFFIX=$3
DOWNLOAD_NAME=$4
COMPRESSION=$5
LIBRARY_SUFFIX=$6


mkdir -p build/onnxruntime-${ORT_VERSION}
cd build/onnxruntime-${ORT_VERSION}
curl -OL https://github.com/microsoft/onnxruntime/releases/download/v${ORT_VERSION}/onnxruntime-${DOWNLOAD_NAME}-${ORT_VERSION}.${COMPRESSION}
if [ "$compression" = "zip" ]; then
    unzip onnxruntime-${DOWNLOAD_NAME}-${ORT_VERSION}.${COMPRESSION}
else
    tar xvzf onnxruntime-${DOWNLOAD_NAME}-${ORT_VERSION}.${COMPRESSION}
fi

mkdir -p ${OS_ARCH}${GPU_SUFFIX}/com/jyuzawa/onnxruntime/native/${OS_ARCH}
for i in $(ls onnxruntime-${DOWNLOAD_NAME}-${ORT_VERSION}/lib | grep "\.${LIBRARY_SUFFIX}" | grep -v "${ORT_VERSION}"); do
  cp onnxruntime-${DOWNLOAD_NAME}-${ORT_VERSION}/lib/$i ${OS_ARCH}${GPU_SUFFIX}/com/jyuzawa/onnxruntime/native/${OS_ARCH}
done
cd ${OS_ARCH}${GPU_SUFFIX}/com/jyuzawa/onnxruntime/native/${OS_ARCH}
ls | grep -v libraries > libraries