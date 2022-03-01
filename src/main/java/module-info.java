/**
 * A Java binding of Microsoft's ONNX Runtime.
 * <p>
 * This library wraps their native library and tries to obscure the various nuances of native memory from the Java developer.
 * <p>
 * This is experimental and uses Java's "Panama" FFI integration.
 * This will require the runtime to have the {@code --enable-native-access=ALL-UNNAMED} JVM option.
 * If you are not using modules, you will need to also use {@code --add-modules jdk.incubator.foreign} as well.
 * <ul>
 * <li>The {@code onnxruntime-cpu} artifact provides support for several common operating systems / CPU architecture combinations.
 * <li>The {@code onnxruntime-gpu} artifact provides GPU (CUDA) support for several common operating systems / CPU architecture combinations.
 * <li>The {@code onnxruntime} artifact contains only bindings and no libraries.
 * This means the native library will need to be provided.
 * Use this artifact as a compile dependency if you want to allow your project's users to bring use {@code onnxruntime-cpu}, {@code onnxruntime-gpu}, or their own native library as dependencies provided at runtime.
 * </ul>
 */
module com.jyuzawa.onnxruntime {
    exports com.jyuzawa.onnxruntime;

    requires jdk.incubator.foreign;
}
