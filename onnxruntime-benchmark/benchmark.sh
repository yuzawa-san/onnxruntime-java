#!/bin/sh

mkdir -p build/jfr
JFR=build/jfr/ort-`date +"%Y-%m-%dT%H:%M:%S%z"`.jfr
echo "Hello";
#JAVA_OPTS="-agentpath:/path/to/libasyncProfiler.so=start,event=cpu,file=profile.html"
exec build/install/onnxruntime-benchmark/bin/onnxruntime-benchmark