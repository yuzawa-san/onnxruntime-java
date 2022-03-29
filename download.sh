#!/bin/sh

ORT_VERSION=$1
OS_ARCH=$2
GPU_SUFFIX=$3
DOWNLOAD_NAME=$4
COMPRESSION=$5
LIBRARY_SUFFIX=$6


mkdir -p build/onnxruntime-${ORT_VERSION}
FILENAME=onnxruntime-${DOWNLOAD_NAME}-${ORT_VERSION}.${COMPRESSION}
cd cache/
if [ -f "${FILENAME}" ]; then
  echo "HIT ${FILENAME}"
else
  echo "MISS ${FILENAME}"
  curl -OL https://github.com/microsoft/onnxruntime/releases/download/v${ORT_VERSION}/${FILENAME}
fi
cd ../build/onnxruntime-${ORT_VERSION}
ln -s ../../cache/${FILENAME} ${FILENAME}
if [ "${COMPRESSION}" = "zip" ]; then
  unzip ${FILENAME}
else
  set MSYS=winsymlinks:lnk
  tar xvzf ${FILENAME}
fi

mkdir -p ${OS_ARCH}${GPU_SUFFIX}/com/jyuzawa/onnxruntime/native/${OS_ARCH}
for i in $(ls onnxruntime-${DOWNLOAD_NAME}-${ORT_VERSION}/lib | grep "\.${LIBRARY_SUFFIX}" | grep -v "${ORT_VERSION}"); do
  cp onnxruntime-${DOWNLOAD_NAME}-${ORT_VERSION}/lib/$i ${OS_ARCH}${GPU_SUFFIX}/com/jyuzawa/onnxruntime/native/${OS_ARCH}
done
cd ${OS_ARCH}${GPU_SUFFIX}/com/jyuzawa/onnxruntime/native/${OS_ARCH}
ls | grep -v libraries > libraries