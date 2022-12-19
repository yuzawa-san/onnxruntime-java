#!/bin/sh

mkdir -p build/jfr
JFR=build/jfr/ort-`date +"%Y-%m-%dT%H-%M-%S%z"`.jfr
echo "writing output to ${JFR}";
export JAVA_HOME=/Users/jtyuzawa/Documents/personal_repos/jdk/build/macosx-x86_64-server-release/jdk
java -version
export ONNXRUNTIME_BENCHMARK_OPTS="-agentpath:/Users/jtyuzawa/Downloads/async-profiler-2.9-macos/build/libasyncProfiler.dylib=start,event=cpu,alloc,lock,file=${JFR}"
exec build/install/onnxruntime-benchmark/bin/onnxruntime-benchmark