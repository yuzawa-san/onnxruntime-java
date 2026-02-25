/**
 * A Java binding of Microsoft's ONNX Runtime.
 * <p>
 * This project's goals are to provide a type-safe, lightweight, and performant binding which abstracts a lot of the
 * native and C API intricacies away behind a Java-friendly interface. This is loosely coupled to the upstream project
 * and built off of the public (and stable) C API.
 * <p>
 * This uses Java's Foreign Function &amp; Memory API. This will
 * require the runtime to have the {@code --enable-native-access=ALL-UNNAMED} or similar JVM options.
 * <ul>
 * <li>The {@code onnxruntime-cpu} artifact provides support for several common operating systems / CPU architecture
 * combinations. For use as an optional runtime dependency. Include one of the OS/Architecture classifiers like
 * {@code linux-x86_64} to provide specific support.
 * <li>The {@code onnxruntime-gpu} artifact provides GPU (CUDA) support for several common operating systems / CPU
 * architecture combinations. For use as an optional runtime dependency. Include one of the OS/Architecture classifiers
 * like {@code linux-x86_64} to provide specific support.
 * <li>The {@code onnxruntime} artifact contains only bindings and no libraries. This means the native library will need
 * to be provided. Use this artifact as a compile dependency if you want to allow your project's users to bring use
 * {@code onnxruntime-cpu}, {@code onnxruntime-gpu}, or their own native library as dependencies provided at runtime.
 * </ul>
 *
 * @since 1.0.0
 */
module com.jyuzawa.onnxruntime {
    exports com.jyuzawa.onnxruntime;
}
