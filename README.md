# onnxruntime-java
by [@yuzawa-san](https://github.com/yuzawa-san/)

[![build](https://github.com/yuzawa-san/onnxruntime-java/workflows/build/badge.svg)](https://github.com/yuzawa-san/onnxruntime-java/actions)
[![codecov](https://codecov.io/gh/yuzawa-san/onnxruntime-java/branch/master/graph/badge.svg)](https://codecov.io/gh/yuzawa-san/onnxruntime-java)

This is an **experimental** and **modern** Java binding to Microsoft's [ONNX Runtime](https://github.com/microsoft/onnxruntime) which uses Java's new Foreign Function & Memory API (a.k.a. Project Panama).

This project's goals are to provide a type-safe, lightweight, and performant binding which abstracts a lot of the native and C API intricacies away behind a Java-friendly interface.
This is loosely coupled to the upstream project and built off of the public (and stable) [C API](https://onnxruntime.ai/docs/api/c/struct_ort_api.html).

The supported Java version is 19, since the FFI API is in preview.
Given the limited stability guarantees of the underlying API, please use in production use cases with great care.
There are [other](https://github.com/bytedeco/javacpp-presets/tree/master/onnxruntime) [fine](https://github.com/microsoft/onnxruntime/tree/main/java) bindings which use JNI and are capable of supporting lower Java versions.

## Usage

[![maven](https://img.shields.io/maven-central/v/com.jyuzawa/onnxruntime)](https://search.maven.org/artifact/com.jyuzawa/onnxruntime)
[![javadoc](https://javadoc.io/badge2/com.jyuzawa/onnxruntime/javadoc.svg)](https://javadoc.io/doc/com.jyuzawa/onnxruntime)

This project is released to [Maven Central](https://search.maven.org/artifact/com.jyuzawa/onnxruntime) and can be used in your project. There are a few artifacts published:

* [`onnxruntime`](https://search.maven.org/artifact/com.jyuzawa/onnxruntime) - The binding with no native libraries. For use as a implementation dependency.
* [`onnxruntime-cpu`](https://search.maven.org/artifact/com.jyuzawa/onnxruntime-cpu) - A collection of native libraries with CPU support for a several common OS/architecture combinations. For use as an optional runtime dependency. Include one of the OS/Architecture classifiers like `osx-x86_64` to provide specific support.
* [`onnxruntime-gpu`](https://search.maven.org/artifact/com.jyuzawa/onnxruntime-gpu) - A collection of native libraries with GPU support for a several common OS/architecture combinations. For use as an optional runtime dependency. Include one of the OS/Architecture classifiers like `osx-x86_64` to provide specific support.

The native library (from Microsoft) will need to be provided at runtime using one of the latter two artifacts. Alternatively, the Java library path (`java.library.path`) will be used if neither of those artifacts is provided.
This allows users to "bring their own" shared library.

The library is currently built for Linux, Windows, MacOS and for arm64 and x86_64.
These were chosen since the upstream projects publishes artifacts for these enviroments.

### In your library

There is an example library in the `onnxruntime-sample-library` directory.
The library should use the `onnxruntime` as a implementation dependency.
This puts the burden of providing a native library on your end user.

### In your application

There is an example application in the `onnxruntime-sample-application` directory.
The library should use the `onnxruntime` as a implementation dependency.
The application needs to have acccess to the native library.
You have the option providing it via a runtime dependency using either a classifier variant from `onnxruntime-cpu` or `onnxruntime-gpu`
Otherwise, the Java library path will be used to load the native library.


The example application can be ran:
````bash
./gradlew onnxruntime-sample-application:run
````

#### JVM Arguments

Since this uses a native library, this will require the runtime to have the `--enable-native-access` JVM option, likely `--enable-native-access=ALL-UNNAMED`.
Since the foreign function API is in preview in Java 19, the `--enable-preview` will also be needed

### Execution Providers

Only those which are exposed in the C API are supported.
The `onnxruntime-gpu` artifact supports CUDA and TensorRT, since those are built off of the GPU artifacts from the upstream project.
If you wish to use another execution provider which is present in the C API, but not in any of the artifacts from the upstream project, you can choose to bring your own onnxruntime shared library to link against.

## Versioning

The version of the upstream project used will be reflected in the release notes.
Semantic versioning is used.
Major version will be bumped when this API or the underlying C API has backward incompatible changes.
Upstream major version changes will typically be major version changes here.
Minor version will be bumped for smaller, but compatible changes.
Upstream minor version changes will typically be minor version changes here.

The `onnxruntime-cpu` and `onnxruntime-gpu` artifacts are versioned to match the upstream versions and depend on a minimum compatible `onnxruntime` version.

### Snapshots

[![maven-snapshot](https://img.shields.io/maven-metadata/v?metadataUrl=https%3A%2F%2Fs01.oss.sonatype.org%2Fcontent%2Frepositories%2Fsnapshots%2Fcom%2Fjyuzawa%2Fonnxruntime%2Fmaven-metadata.xml)](https://s01.oss.sonatype.org/content/repositories/snapshots/com/jyuzawa/onnxruntime/)

Snapshot releases are periodically released for testing and experimentation.
