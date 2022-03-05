# onnxruntime-java
by [@yuzawa-san](https://github.com/yuzawa-san/)

[![build](https://github.com/yuzawa-san/onnxruntime-java/workflows/build/badge.svg)](https://github.com/yuzawa-san/onnxruntime-java/actions)
[![codecov](https://codecov.io/gh/yuzawa-san/onnxruntime-java/branch/master/graph/badge.svg)](https://codecov.io/gh/yuzawa-san/onnxruntime-java)

This is an **experimental** Java binding to Microsoft's [ONNX Runtime](https://github.com/microsoft/onnxruntime).

This uses Java's Panama project. Given the incubating status of that project, this library should be considered a proof of concept and lacks the stability guarantees at this time. The minimum supported Java version is 17.

This project's goals are to provide a type-safe, performant binding which abstracts a lot of the native and C API intricacies and is loosely coupled to the upstream project.

## Usage

[![maven](https://img.shields.io/maven-central/v/com.jyuzawa/onnxruntime)](https://search.maven.org/artifact/com.jyuzawa/onnxruntime)
[![javadoc](https://javadoc.io/badge2/com.jyuzawa/onnxruntime/javadoc.svg)](https://javadoc.io/doc/com.jyuzawa/onnxruntime)

This project is released to [Maven Central](https://search.maven.org/artifact/com.jyuzawa/onnxruntime) and can be used in your project. There are a few artifacts published:

* [`onnxruntime`](https://search.maven.org/artifact/com.jyuzawa/onnxruntime) - The binding with no native libraries. For use as a compile dependency.
* [`onnxruntime-cpu`](https://search.maven.org/artifact/com.jyuzawa/onnxruntime-cpu) - A collection of native libraries with CPU support for a several common OS/architecture combinations. For use as an optional runtime dependency.
* [`onnxruntime-gpu`](https://search.maven.org/artifact/com.jyuzawa/onnxruntime-gpu) - A collection of native libraries with GPU support for a several common OS/architecture combinations. For use as an optional runtime dependency.

The native library (from Microsoft) will need to be provided at runtime using one of the latter two artifacts. Alternative, the Java library path (`java.library.path`) will be used if neither of those artifacts is provided.

### In your library

There is an example library in the `onnxruntime-sample-library` directory.
The library should use the `onnxruntime` as a compile dependency.
This puts the burden of providing a native library on your end user.

### In your application

There is an example application in the `onnxruntime-sample-application` directory.
The library should use the `onnxruntime` as a compile dependency.
The application needs to have acccess to the native library.
You have the option providing it via a runtime dependency using either `onnxruntime-cpu` or `onnxruntime-gpu`
Otherwise, the Java library path will be used to load the native library.


The example application can be ran:
````bash
./gradlew onnxruntime-sample-application:run
````

#### JVM Arguments

Since this uses a native library, this will require the runtime to have the `--enable-native-access` JVM option, likely `--enable-native-access=ALL-UNNAMED`.
If you are not using modules, you will need to also use `--add-modules jdk.incubator.foreign` as well.
