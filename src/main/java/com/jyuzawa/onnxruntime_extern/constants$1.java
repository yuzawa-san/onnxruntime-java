// Generated by jextract

package com.jyuzawa.onnxruntime_extern;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.nio.ByteOrder;
import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
class constants$1 {

    static final FunctionDescriptor OrtCustomCreateThreadFn$FUNC = FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle OrtCustomCreateThreadFn$MH = RuntimeHelper.downcallHandle(
        constants$1.OrtCustomCreateThreadFn$FUNC
    );
    static final FunctionDescriptor OrtCustomJoinThreadFn$FUNC = FunctionDescriptor.ofVoid(
        Constants$root.C_POINTER$LAYOUT
    );
    static final MethodHandle OrtCustomJoinThreadFn$MH = RuntimeHelper.downcallHandle(
        constants$1.OrtCustomJoinThreadFn$FUNC
    );
    static final FunctionDescriptor OrtSessionOptionsAppendExecutionProvider_CUDA$FUNC = FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_INT$LAYOUT
    );
    static final MethodHandle OrtSessionOptionsAppendExecutionProvider_CUDA$MH = RuntimeHelper.downcallHandle(
        "OrtSessionOptionsAppendExecutionProvider_CUDA",
        constants$1.OrtSessionOptionsAppendExecutionProvider_CUDA$FUNC
    );
    static final FunctionDescriptor OrtSessionOptionsAppendExecutionProvider_MIGraphX$FUNC = FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_INT$LAYOUT
    );
    static final MethodHandle OrtSessionOptionsAppendExecutionProvider_MIGraphX$MH = RuntimeHelper.downcallHandle(
        "OrtSessionOptionsAppendExecutionProvider_MIGraphX",
        constants$1.OrtSessionOptionsAppendExecutionProvider_MIGraphX$FUNC
    );
    static final FunctionDescriptor OrtSessionOptionsAppendExecutionProvider_Tensorrt$FUNC = FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_POINTER$LAYOUT,
        Constants$root.C_INT$LAYOUT
    );
    static final MethodHandle OrtSessionOptionsAppendExecutionProvider_Tensorrt$MH = RuntimeHelper.downcallHandle(
        "OrtSessionOptionsAppendExecutionProvider_Tensorrt",
        constants$1.OrtSessionOptionsAppendExecutionProvider_Tensorrt$FUNC
    );
}


