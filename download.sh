#!/bin/sh

doIt () {
  OS_ARCH=$1
  GPU_SUFFIX=$2
  DOWNLOAD_NAME=$3
  COMPRESSION=$4
  LIBRARY_SUFFIX=$5
  mkdir -p build/onnxruntime-${ORT_VERSION}
  FILENAME=onnxruntime-${DOWNLOAD_NAME}-${ORT_VERSION}.${COMPRESSION}
  cd build/onnxruntime-${ORT_VERSION}
  rm -rf ${FILENAME} ${OS_ARCH}${GPU_SUFFIX} onnxruntime-${DOWNLOAD_NAME}-${ORT_VERSION}
  curl -OL https://github.com/microsoft/onnxruntime/releases/download/v${ORT_VERSION}/${FILENAME}
  if [ "${COMPRESSION}" = "zip" ]; then
    unzip ${FILENAME}
  else
    # https://github.com/msys2/MSYS2-packages/issues/1216
    # https://github.com/heroku/heroku-slugs/issues/3
    tar xvzf ${FILENAME} || tar xvzf ${FILENAME}
  fi

  mkdir -p ${OS_ARCH}${GPU_SUFFIX}/com/jyuzawa/onnxruntime/native/${OS_ARCH}
  for i in $(ls onnxruntime-${DOWNLOAD_NAME}-${ORT_VERSION}/lib | grep "\.${LIBRARY_SUFFIX}" | grep -v "${ORT_VERSION}"); do
    cp onnxruntime-${DOWNLOAD_NAME}-${ORT_VERSION}/lib/$i ${OS_ARCH}${GPU_SUFFIX}/com/jyuzawa/onnxruntime/native/${OS_ARCH}
  done
  cd ${OS_ARCH}${GPU_SUFFIX}/com/jyuzawa/onnxruntime/native/${OS_ARCH}
  ls | grep -v libraries > libraries
}

case $VARIANT in
  linux-aarch_64)
    doIt linux-aarch_64 "" linux-aarch64 tgz so
    ;;
  linux-x86_64)
    doIt linux-x86_64 "" linux-x64 tgz so
    ;;
  linux-x86_64-gpu)
    doIt linux-x86_64 -gpu linux-x64-gpu tgz so
    ;;
  osx-x86_64)
    doIt osx-x86_64 "" osx-x86_64 tgz dylib
    ;;
  osx-aarch_64)
    doIt osx-aarch_64 "" osx-arm64 tgz dylib
    ;;
  windows-aarch_64)
    doIt windows-aarch_64 "" win-arm64 zip dll
    ;;
  windows-x86_64)
    doIt windows-x86_64 "" win-x64 zip dll
    ;;
  windows-x86_64-gpu)
    doIt windows-x86_64 -gpu win-x64-gpu zip dll
    ;;
esac