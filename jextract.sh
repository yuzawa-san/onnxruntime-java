#!/bin/sh

sed -i .bak 's/size_t/unsigned long long/g' build/onnxruntime-${ORT_VERSION}/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include/onnxruntime_c_api.h
sed -i .bak 's/uint64_t/unsigned long long/g' build/onnxruntime-${ORT_VERSION}/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include/onnxruntime_c_api.h
sed -i .bak 's/int64_t/long long/g' build/onnxruntime-${ORT_VERSION}/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include/onnxruntime_c_api.h
rm build/onnxruntime-${ORT_VERSION}/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include/onnxruntime_c_api.h.bak
docker run --rm -v $(PWD):/workdir `docker build -q .` --output /workdir/src/main/java -l onnxruntime --source --target-package com.jyuzawa.onnxruntime_extern -I /usr/include -I build/onnxruntime-${ORT_VERSION}/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include --dump-includes symbols.conf onnxruntime_all.h
# strip out the irrelevant symbols
csplit symbols.conf "/onnxruntime_c_api.h/"
rm xx00
mv xx01 symbols.conf
docker run --rm -v $(PWD):/workdir `docker build -q .` --output /workdir/src/main/java -l onnxruntime --source --target-package com.jyuzawa.onnxruntime_extern -I /usr/include -I build/onnxruntime-${ORT_VERSION}/onnxruntime-linux-x64-gpu-${ORT_VERSION}/include @symbols.conf onnxruntime_all.h
# strip out loads since we'll manage load
sed -i .bak '/System.loadLibrary/d' src/main/java/com/jyuzawa/onnxruntime_extern/RuntimeHelper.java
rm src/main/java/com/jyuzawa/onnxruntime_extern/RuntimeHelper.java.bak