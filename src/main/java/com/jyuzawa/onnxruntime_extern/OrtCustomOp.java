/*
 * Copyright (c) 2023 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

/**
 * {@snippet :
 * struct OrtCustomOp {
 *     uint32_t version;
 *     void* (*CreateKernel)(struct OrtCustomOp*,const OrtApi*,const OrtKernelInfo*);
 *     char* (*GetName)(struct OrtCustomOp*);
 *     char* (*GetExecutionProviderType)(struct OrtCustomOp*);
 *     ONNXTensorElementDataType (*GetInputType)(struct OrtCustomOp*,size_t);
 *     size_t (*GetInputTypeCount)(struct OrtCustomOp*);
 *     ONNXTensorElementDataType (*GetOutputType)(struct OrtCustomOp*,size_t);
 *     size_t (*GetOutputTypeCount)(struct OrtCustomOp*);
 *     void (*KernelCompute)(void*,OrtKernelContext*);
 *     void (*KernelDestroy)(void*);
 *     OrtCustomOpInputOutputCharacteristic (*GetInputCharacteristic)(struct OrtCustomOp*,size_t);
 *     OrtCustomOpInputOutputCharacteristic (*GetOutputCharacteristic)(struct OrtCustomOp*,size_t);
 *     OrtMemType (*GetInputMemoryType)(struct OrtCustomOp*,size_t);
 *     int (*GetVariadicInputMinArity)(struct OrtCustomOp*);
 *     int (*GetVariadicInputHomogeneity)(struct OrtCustomOp*);
 *     int (*GetVariadicOutputMinArity)(struct OrtCustomOp*);
 *     int (*GetVariadicOutputHomogeneity)(struct OrtCustomOp*);
 * };
 * }
 */
public class OrtCustomOp {

    static final StructLayout $struct$LAYOUT = MemoryLayout.structLayout(
                    Constants$root.C_INT$LAYOUT.withName("version"),
                    MemoryLayout.paddingLayout(32),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateKernel"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetName"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetExecutionProviderType"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetInputType"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetInputTypeCount"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetOutputType"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetOutputTypeCount"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelCompute"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelDestroy"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetInputCharacteristic"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetOutputCharacteristic"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetInputMemoryType"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetVariadicInputMinArity"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetVariadicInputHomogeneity"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetVariadicOutputMinArity"),
                    Constants$root.C_POINTER$LAYOUT.withName("GetVariadicOutputHomogeneity"),
                    Constants$root.C_POINTER$LAYOUT.withName("CreateKernelV2"),
                    Constants$root.C_POINTER$LAYOUT.withName("KernelComputeV2"))
            .withName("OrtCustomOp");

    public static MemoryLayout $LAYOUT() {
        return OrtCustomOp.$struct$LAYOUT;
    }

    static final VarHandle version$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("version"));

    public static VarHandle version$VH() {
        return OrtCustomOp.version$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * uint32_t version;
     * }
     */
    public static int version$get(MemorySegment seg) {
        return (int) OrtCustomOp.version$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * uint32_t version;
     * }
     */
    public static void version$set(MemorySegment seg, int x) {
        OrtCustomOp.version$VH.set(seg, x);
    }

    public static int version$get(MemorySegment seg, long index) {
        return (int) OrtCustomOp.version$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void version$set(MemorySegment seg, long index, int x) {
        OrtCustomOp.version$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final FunctionDescriptor CreateKernel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateKernel$MH = RuntimeHelper.downcallHandle(OrtCustomOp.CreateKernel$FUNC);
    /**
     * {@snippet :
     * void* (*CreateKernel)(struct OrtCustomOp*,const OrtApi*,const OrtKernelInfo*);
     * }
     */
    public interface CreateKernel {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment ort_custom_thread_creation_options,
                java.lang.foreign.MemorySegment ort_thread_worker_fn,
                java.lang.foreign.MemorySegment ort_worker_fn_param);

        static MemorySegment allocate(CreateKernel fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(CreateKernel.class, fi, OrtCustomOp.CreateKernel$FUNC, scope);
        }

        static CreateKernel ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtCustomOp.CreateKernel$MH.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateKernel$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateKernel"));

    public static VarHandle CreateKernel$VH() {
        return OrtCustomOp.CreateKernel$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void* (*CreateKernel)(struct OrtCustomOp*,const OrtApi*,const OrtKernelInfo*);
     * }
     */
    public static MemorySegment CreateKernel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.CreateKernel$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void* (*CreateKernel)(struct OrtCustomOp*,const OrtApi*,const OrtKernelInfo*);
     * }
     */
    public static void CreateKernel$set(MemorySegment seg, MemorySegment x) {
        OrtCustomOp.CreateKernel$VH.set(seg, x);
    }

    public static MemorySegment CreateKernel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.CreateKernel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateKernel$set(MemorySegment seg, long index, MemorySegment x) {
        OrtCustomOp.CreateKernel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateKernel CreateKernel(MemorySegment segment, SegmentScope scope) {
        return CreateKernel.ofAddress(CreateKernel$get(segment), scope);
    }

    static final FunctionDescriptor GetName$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetName$MH = RuntimeHelper.downcallHandle(OrtCustomOp.GetName$FUNC);
    /**
     * {@snippet :
     * char* (*GetName)(struct OrtCustomOp*);
     * }
     */
    public interface GetName {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetName fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetName.class, fi, OrtCustomOp.GetName$FUNC, scope);
        }

        static GetName ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) OrtCustomOp.GetName$MH.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetName$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetName"));

    public static VarHandle GetName$VH() {
        return OrtCustomOp.GetName$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* (*GetName)(struct OrtCustomOp*);
     * }
     */
    public static MemorySegment GetName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetName$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* (*GetName)(struct OrtCustomOp*);
     * }
     */
    public static void GetName$set(MemorySegment seg, MemorySegment x) {
        OrtCustomOp.GetName$VH.set(seg, x);
    }

    public static MemorySegment GetName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetName$set(MemorySegment seg, long index, MemorySegment x) {
        OrtCustomOp.GetName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetName GetName(MemorySegment segment, SegmentScope scope) {
        return GetName.ofAddress(GetName$get(segment), scope);
    }

    static final FunctionDescriptor GetExecutionProviderType$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetExecutionProviderType$MH =
            RuntimeHelper.downcallHandle(OrtCustomOp.GetExecutionProviderType$FUNC);
    /**
     * {@snippet :
     * char* (*GetExecutionProviderType)(struct OrtCustomOp*);
     * }
     */
    public interface GetExecutionProviderType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetExecutionProviderType fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetExecutionProviderType.class, fi, OrtCustomOp.GetExecutionProviderType$FUNC, scope);
        }

        static GetExecutionProviderType ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            OrtCustomOp.GetExecutionProviderType$MH.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetExecutionProviderType$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetExecutionProviderType"));

    public static VarHandle GetExecutionProviderType$VH() {
        return OrtCustomOp.GetExecutionProviderType$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* (*GetExecutionProviderType)(struct OrtCustomOp*);
     * }
     */
    public static MemorySegment GetExecutionProviderType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetExecutionProviderType$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* (*GetExecutionProviderType)(struct OrtCustomOp*);
     * }
     */
    public static void GetExecutionProviderType$set(MemorySegment seg, MemorySegment x) {
        OrtCustomOp.GetExecutionProviderType$VH.set(seg, x);
    }

    public static MemorySegment GetExecutionProviderType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtCustomOp.GetExecutionProviderType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetExecutionProviderType$set(MemorySegment seg, long index, MemorySegment x) {
        OrtCustomOp.GetExecutionProviderType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetExecutionProviderType GetExecutionProviderType(MemorySegment segment, SegmentScope scope) {
        return GetExecutionProviderType.ofAddress(GetExecutionProviderType$get(segment), scope);
    }

    static final FunctionDescriptor GetInputType$FUNC = FunctionDescriptor.of(
            Constants$root.C_INT$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle GetInputType$MH = RuntimeHelper.downcallHandle(OrtCustomOp.GetInputType$FUNC);
    /**
     * {@snippet :
     * ONNXTensorElementDataType (*GetInputType)(struct OrtCustomOp*,size_t);
     * }
     */
    public interface GetInputType {

        int apply(java.lang.foreign.MemorySegment _x0, long _x1);

        static MemorySegment allocate(GetInputType fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetInputType.class, fi, OrtCustomOp.GetInputType$FUNC, scope);
        }

        static GetInputType ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, long __x1) -> {
                try {
                    return (int) OrtCustomOp.GetInputType$MH.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetInputType$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetInputType"));

    public static VarHandle GetInputType$VH() {
        return OrtCustomOp.GetInputType$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * ONNXTensorElementDataType (*GetInputType)(struct OrtCustomOp*,size_t);
     * }
     */
    public static MemorySegment GetInputType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetInputType$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * ONNXTensorElementDataType (*GetInputType)(struct OrtCustomOp*,size_t);
     * }
     */
    public static void GetInputType$set(MemorySegment seg, MemorySegment x) {
        OrtCustomOp.GetInputType$VH.set(seg, x);
    }

    public static MemorySegment GetInputType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetInputType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetInputType$set(MemorySegment seg, long index, MemorySegment x) {
        OrtCustomOp.GetInputType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetInputType GetInputType(MemorySegment segment, SegmentScope scope) {
        return GetInputType.ofAddress(GetInputType$get(segment), scope);
    }

    static final FunctionDescriptor GetInputTypeCount$FUNC =
            FunctionDescriptor.of(Constants$root.C_LONG_LONG$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetInputTypeCount$MH = RuntimeHelper.downcallHandle(OrtCustomOp.GetInputTypeCount$FUNC);
    /**
     * {@snippet :
     * size_t (*GetInputTypeCount)(struct OrtCustomOp*);
     * }
     */
    public interface GetInputTypeCount {

        long apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetInputTypeCount fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetInputTypeCount.class, fi, OrtCustomOp.GetInputTypeCount$FUNC, scope);
        }

        static GetInputTypeCount ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (long) OrtCustomOp.GetInputTypeCount$MH.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetInputTypeCount$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetInputTypeCount"));

    public static VarHandle GetInputTypeCount$VH() {
        return OrtCustomOp.GetInputTypeCount$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * size_t (*GetInputTypeCount)(struct OrtCustomOp*);
     * }
     */
    public static MemorySegment GetInputTypeCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetInputTypeCount$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * size_t (*GetInputTypeCount)(struct OrtCustomOp*);
     * }
     */
    public static void GetInputTypeCount$set(MemorySegment seg, MemorySegment x) {
        OrtCustomOp.GetInputTypeCount$VH.set(seg, x);
    }

    public static MemorySegment GetInputTypeCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetInputTypeCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetInputTypeCount$set(MemorySegment seg, long index, MemorySegment x) {
        OrtCustomOp.GetInputTypeCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetInputTypeCount GetInputTypeCount(MemorySegment segment, SegmentScope scope) {
        return GetInputTypeCount.ofAddress(GetInputTypeCount$get(segment), scope);
    }

    static final FunctionDescriptor GetOutputType$FUNC = FunctionDescriptor.of(
            Constants$root.C_INT$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle GetOutputType$MH = RuntimeHelper.downcallHandle(OrtCustomOp.GetOutputType$FUNC);
    /**
     * {@snippet :
     * ONNXTensorElementDataType (*GetOutputType)(struct OrtCustomOp*,size_t);
     * }
     */
    public interface GetOutputType {

        int apply(java.lang.foreign.MemorySegment _x0, long _x1);

        static MemorySegment allocate(GetOutputType fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetOutputType.class, fi, OrtCustomOp.GetOutputType$FUNC, scope);
        }

        static GetOutputType ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, long __x1) -> {
                try {
                    return (int) OrtCustomOp.GetOutputType$MH.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetOutputType$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetOutputType"));

    public static VarHandle GetOutputType$VH() {
        return OrtCustomOp.GetOutputType$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * ONNXTensorElementDataType (*GetOutputType)(struct OrtCustomOp*,size_t);
     * }
     */
    public static MemorySegment GetOutputType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetOutputType$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * ONNXTensorElementDataType (*GetOutputType)(struct OrtCustomOp*,size_t);
     * }
     */
    public static void GetOutputType$set(MemorySegment seg, MemorySegment x) {
        OrtCustomOp.GetOutputType$VH.set(seg, x);
    }

    public static MemorySegment GetOutputType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetOutputType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetOutputType$set(MemorySegment seg, long index, MemorySegment x) {
        OrtCustomOp.GetOutputType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetOutputType GetOutputType(MemorySegment segment, SegmentScope scope) {
        return GetOutputType.ofAddress(GetOutputType$get(segment), scope);
    }

    static final FunctionDescriptor GetOutputTypeCount$FUNC =
            FunctionDescriptor.of(Constants$root.C_LONG_LONG$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetOutputTypeCount$MH = RuntimeHelper.downcallHandle(OrtCustomOp.GetOutputTypeCount$FUNC);
    /**
     * {@snippet :
     * size_t (*GetOutputTypeCount)(struct OrtCustomOp*);
     * }
     */
    public interface GetOutputTypeCount {

        long apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetOutputTypeCount fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetOutputTypeCount.class, fi, OrtCustomOp.GetOutputTypeCount$FUNC, scope);
        }

        static GetOutputTypeCount ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (long) OrtCustomOp.GetOutputTypeCount$MH.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetOutputTypeCount$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetOutputTypeCount"));

    public static VarHandle GetOutputTypeCount$VH() {
        return OrtCustomOp.GetOutputTypeCount$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * size_t (*GetOutputTypeCount)(struct OrtCustomOp*);
     * }
     */
    public static MemorySegment GetOutputTypeCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetOutputTypeCount$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * size_t (*GetOutputTypeCount)(struct OrtCustomOp*);
     * }
     */
    public static void GetOutputTypeCount$set(MemorySegment seg, MemorySegment x) {
        OrtCustomOp.GetOutputTypeCount$VH.set(seg, x);
    }

    public static MemorySegment GetOutputTypeCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetOutputTypeCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetOutputTypeCount$set(MemorySegment seg, long index, MemorySegment x) {
        OrtCustomOp.GetOutputTypeCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetOutputTypeCount GetOutputTypeCount(MemorySegment segment, SegmentScope scope) {
        return GetOutputTypeCount.ofAddress(GetOutputTypeCount$get(segment), scope);
    }

    static final FunctionDescriptor KernelCompute$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelCompute$MH = RuntimeHelper.downcallHandle(OrtCustomOp.KernelCompute$FUNC);
    /**
     * {@snippet :
     * void (*KernelCompute)(void*,OrtKernelContext*);
     * }
     */
    public interface KernelCompute {

        void apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(KernelCompute fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(KernelCompute.class, fi, OrtCustomOp.KernelCompute$FUNC, scope);
        }

        static KernelCompute ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    OrtCustomOp.KernelCompute$MH.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelCompute$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelCompute"));

    public static VarHandle KernelCompute$VH() {
        return OrtCustomOp.KernelCompute$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*KernelCompute)(void*,OrtKernelContext*);
     * }
     */
    public static MemorySegment KernelCompute$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.KernelCompute$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*KernelCompute)(void*,OrtKernelContext*);
     * }
     */
    public static void KernelCompute$set(MemorySegment seg, MemorySegment x) {
        OrtCustomOp.KernelCompute$VH.set(seg, x);
    }

    public static MemorySegment KernelCompute$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.KernelCompute$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelCompute$set(MemorySegment seg, long index, MemorySegment x) {
        OrtCustomOp.KernelCompute$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelCompute KernelCompute(MemorySegment segment, SegmentScope scope) {
        return KernelCompute.ofAddress(KernelCompute$get(segment), scope);
    }

    static final FunctionDescriptor KernelDestroy$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelDestroy$MH = RuntimeHelper.downcallHandle(OrtCustomOp.KernelDestroy$FUNC);
    /**
     * {@snippet :
     * void (*KernelDestroy)(void*);
     * }
     */
    public interface KernelDestroy {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(KernelDestroy fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(KernelDestroy.class, fi, OrtCustomOp.KernelDestroy$FUNC, scope);
        }

        static KernelDestroy ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    OrtCustomOp.KernelDestroy$MH.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelDestroy$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelDestroy"));

    public static VarHandle KernelDestroy$VH() {
        return OrtCustomOp.KernelDestroy$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*KernelDestroy)(void*);
     * }
     */
    public static MemorySegment KernelDestroy$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.KernelDestroy$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*KernelDestroy)(void*);
     * }
     */
    public static void KernelDestroy$set(MemorySegment seg, MemorySegment x) {
        OrtCustomOp.KernelDestroy$VH.set(seg, x);
    }

    public static MemorySegment KernelDestroy$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.KernelDestroy$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelDestroy$set(MemorySegment seg, long index, MemorySegment x) {
        OrtCustomOp.KernelDestroy$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelDestroy KernelDestroy(MemorySegment segment, SegmentScope scope) {
        return KernelDestroy.ofAddress(KernelDestroy$get(segment), scope);
    }

    static final FunctionDescriptor GetInputCharacteristic$FUNC = FunctionDescriptor.of(
            Constants$root.C_INT$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle GetInputCharacteristic$MH =
            RuntimeHelper.downcallHandle(OrtCustomOp.GetInputCharacteristic$FUNC);
    /**
     * {@snippet :
     * OrtCustomOpInputOutputCharacteristic (*GetInputCharacteristic)(struct OrtCustomOp*,size_t);
     * }
     */
    public interface GetInputCharacteristic {

        int apply(java.lang.foreign.MemorySegment _x0, long _x1);

        static MemorySegment allocate(GetInputCharacteristic fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetInputCharacteristic.class, fi, OrtCustomOp.GetInputCharacteristic$FUNC, scope);
        }

        static GetInputCharacteristic ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, long __x1) -> {
                try {
                    return (int) OrtCustomOp.GetInputCharacteristic$MH.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetInputCharacteristic$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetInputCharacteristic"));

    public static VarHandle GetInputCharacteristic$VH() {
        return OrtCustomOp.GetInputCharacteristic$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtCustomOpInputOutputCharacteristic (*GetInputCharacteristic)(struct OrtCustomOp*,size_t);
     * }
     */
    public static MemorySegment GetInputCharacteristic$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetInputCharacteristic$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtCustomOpInputOutputCharacteristic (*GetInputCharacteristic)(struct OrtCustomOp*,size_t);
     * }
     */
    public static void GetInputCharacteristic$set(MemorySegment seg, MemorySegment x) {
        OrtCustomOp.GetInputCharacteristic$VH.set(seg, x);
    }

    public static MemorySegment GetInputCharacteristic$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtCustomOp.GetInputCharacteristic$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetInputCharacteristic$set(MemorySegment seg, long index, MemorySegment x) {
        OrtCustomOp.GetInputCharacteristic$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetInputCharacteristic GetInputCharacteristic(MemorySegment segment, SegmentScope scope) {
        return GetInputCharacteristic.ofAddress(GetInputCharacteristic$get(segment), scope);
    }

    static final FunctionDescriptor GetOutputCharacteristic$FUNC = FunctionDescriptor.of(
            Constants$root.C_INT$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle GetOutputCharacteristic$MH =
            RuntimeHelper.downcallHandle(OrtCustomOp.GetOutputCharacteristic$FUNC);
    /**
     * {@snippet :
     * OrtCustomOpInputOutputCharacteristic (*GetOutputCharacteristic)(struct OrtCustomOp*,size_t);
     * }
     */
    public interface GetOutputCharacteristic {

        int apply(java.lang.foreign.MemorySegment _x0, long _x1);

        static MemorySegment allocate(GetOutputCharacteristic fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetOutputCharacteristic.class, fi, OrtCustomOp.GetOutputCharacteristic$FUNC, scope);
        }

        static GetOutputCharacteristic ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, long __x1) -> {
                try {
                    return (int) OrtCustomOp.GetOutputCharacteristic$MH.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetOutputCharacteristic$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetOutputCharacteristic"));

    public static VarHandle GetOutputCharacteristic$VH() {
        return OrtCustomOp.GetOutputCharacteristic$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtCustomOpInputOutputCharacteristic (*GetOutputCharacteristic)(struct OrtCustomOp*,size_t);
     * }
     */
    public static MemorySegment GetOutputCharacteristic$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetOutputCharacteristic$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtCustomOpInputOutputCharacteristic (*GetOutputCharacteristic)(struct OrtCustomOp*,size_t);
     * }
     */
    public static void GetOutputCharacteristic$set(MemorySegment seg, MemorySegment x) {
        OrtCustomOp.GetOutputCharacteristic$VH.set(seg, x);
    }

    public static MemorySegment GetOutputCharacteristic$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtCustomOp.GetOutputCharacteristic$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetOutputCharacteristic$set(MemorySegment seg, long index, MemorySegment x) {
        OrtCustomOp.GetOutputCharacteristic$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetOutputCharacteristic GetOutputCharacteristic(MemorySegment segment, SegmentScope scope) {
        return GetOutputCharacteristic.ofAddress(GetOutputCharacteristic$get(segment), scope);
    }

    static final FunctionDescriptor GetInputMemoryType$FUNC = FunctionDescriptor.of(
            Constants$root.C_INT$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle GetInputMemoryType$MH = RuntimeHelper.downcallHandle(OrtCustomOp.GetInputMemoryType$FUNC);
    /**
     * {@snippet :
     * OrtMemType (*GetInputMemoryType)(struct OrtCustomOp*,size_t);
     * }
     */
    public interface GetInputMemoryType {

        int apply(java.lang.foreign.MemorySegment _x0, long _x1);

        static MemorySegment allocate(GetInputMemoryType fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(GetInputMemoryType.class, fi, OrtCustomOp.GetInputMemoryType$FUNC, scope);
        }

        static GetInputMemoryType ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0, long __x1) -> {
                try {
                    return (int) OrtCustomOp.GetInputMemoryType$MH.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetInputMemoryType$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetInputMemoryType"));

    public static VarHandle GetInputMemoryType$VH() {
        return OrtCustomOp.GetInputMemoryType$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtMemType (*GetInputMemoryType)(struct OrtCustomOp*,size_t);
     * }
     */
    public static MemorySegment GetInputMemoryType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetInputMemoryType$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtMemType (*GetInputMemoryType)(struct OrtCustomOp*,size_t);
     * }
     */
    public static void GetInputMemoryType$set(MemorySegment seg, MemorySegment x) {
        OrtCustomOp.GetInputMemoryType$VH.set(seg, x);
    }

    public static MemorySegment GetInputMemoryType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetInputMemoryType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetInputMemoryType$set(MemorySegment seg, long index, MemorySegment x) {
        OrtCustomOp.GetInputMemoryType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetInputMemoryType GetInputMemoryType(MemorySegment segment, SegmentScope scope) {
        return GetInputMemoryType.ofAddress(GetInputMemoryType$get(segment), scope);
    }

    static final FunctionDescriptor GetVariadicInputMinArity$FUNC =
            FunctionDescriptor.of(Constants$root.C_INT$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetVariadicInputMinArity$MH =
            RuntimeHelper.downcallHandle(OrtCustomOp.GetVariadicInputMinArity$FUNC);
    /**
     * {@snippet :
     * int (*GetVariadicInputMinArity)(struct OrtCustomOp*);
     * }
     */
    public interface GetVariadicInputMinArity {

        int apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetVariadicInputMinArity fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetVariadicInputMinArity.class, fi, OrtCustomOp.GetVariadicInputMinArity$FUNC, scope);
        }

        static GetVariadicInputMinArity ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (int) OrtCustomOp.GetVariadicInputMinArity$MH.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetVariadicInputMinArity$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetVariadicInputMinArity"));

    public static VarHandle GetVariadicInputMinArity$VH() {
        return OrtCustomOp.GetVariadicInputMinArity$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int (*GetVariadicInputMinArity)(struct OrtCustomOp*);
     * }
     */
    public static MemorySegment GetVariadicInputMinArity$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetVariadicInputMinArity$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int (*GetVariadicInputMinArity)(struct OrtCustomOp*);
     * }
     */
    public static void GetVariadicInputMinArity$set(MemorySegment seg, MemorySegment x) {
        OrtCustomOp.GetVariadicInputMinArity$VH.set(seg, x);
    }

    public static MemorySegment GetVariadicInputMinArity$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtCustomOp.GetVariadicInputMinArity$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetVariadicInputMinArity$set(MemorySegment seg, long index, MemorySegment x) {
        OrtCustomOp.GetVariadicInputMinArity$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetVariadicInputMinArity GetVariadicInputMinArity(MemorySegment segment, SegmentScope scope) {
        return GetVariadicInputMinArity.ofAddress(GetVariadicInputMinArity$get(segment), scope);
    }

    static final FunctionDescriptor GetVariadicInputHomogeneity$FUNC =
            FunctionDescriptor.of(Constants$root.C_INT$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetVariadicInputHomogeneity$MH =
            RuntimeHelper.downcallHandle(OrtCustomOp.GetVariadicInputHomogeneity$FUNC);
    /**
     * {@snippet :
     * int (*GetVariadicInputHomogeneity)(struct OrtCustomOp*);
     * }
     */
    public interface GetVariadicInputHomogeneity {

        int apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetVariadicInputHomogeneity fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetVariadicInputHomogeneity.class, fi, OrtCustomOp.GetVariadicInputHomogeneity$FUNC, scope);
        }

        static GetVariadicInputHomogeneity ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (int) OrtCustomOp.GetVariadicInputHomogeneity$MH.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetVariadicInputHomogeneity$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetVariadicInputHomogeneity"));

    public static VarHandle GetVariadicInputHomogeneity$VH() {
        return OrtCustomOp.GetVariadicInputHomogeneity$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int (*GetVariadicInputHomogeneity)(struct OrtCustomOp*);
     * }
     */
    public static MemorySegment GetVariadicInputHomogeneity$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetVariadicInputHomogeneity$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int (*GetVariadicInputHomogeneity)(struct OrtCustomOp*);
     * }
     */
    public static void GetVariadicInputHomogeneity$set(MemorySegment seg, MemorySegment x) {
        OrtCustomOp.GetVariadicInputHomogeneity$VH.set(seg, x);
    }

    public static MemorySegment GetVariadicInputHomogeneity$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtCustomOp.GetVariadicInputHomogeneity$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetVariadicInputHomogeneity$set(MemorySegment seg, long index, MemorySegment x) {
        OrtCustomOp.GetVariadicInputHomogeneity$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetVariadicInputHomogeneity GetVariadicInputHomogeneity(MemorySegment segment, SegmentScope scope) {
        return GetVariadicInputHomogeneity.ofAddress(GetVariadicInputHomogeneity$get(segment), scope);
    }

    static final FunctionDescriptor GetVariadicOutputMinArity$FUNC =
            FunctionDescriptor.of(Constants$root.C_INT$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetVariadicOutputMinArity$MH =
            RuntimeHelper.downcallHandle(OrtCustomOp.GetVariadicOutputMinArity$FUNC);
    /**
     * {@snippet :
     * int (*GetVariadicOutputMinArity)(struct OrtCustomOp*);
     * }
     */
    public interface GetVariadicOutputMinArity {

        int apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetVariadicOutputMinArity fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetVariadicOutputMinArity.class, fi, OrtCustomOp.GetVariadicOutputMinArity$FUNC, scope);
        }

        static GetVariadicOutputMinArity ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (int) OrtCustomOp.GetVariadicOutputMinArity$MH.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetVariadicOutputMinArity$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetVariadicOutputMinArity"));

    public static VarHandle GetVariadicOutputMinArity$VH() {
        return OrtCustomOp.GetVariadicOutputMinArity$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int (*GetVariadicOutputMinArity)(struct OrtCustomOp*);
     * }
     */
    public static MemorySegment GetVariadicOutputMinArity$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetVariadicOutputMinArity$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int (*GetVariadicOutputMinArity)(struct OrtCustomOp*);
     * }
     */
    public static void GetVariadicOutputMinArity$set(MemorySegment seg, MemorySegment x) {
        OrtCustomOp.GetVariadicOutputMinArity$VH.set(seg, x);
    }

    public static MemorySegment GetVariadicOutputMinArity$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtCustomOp.GetVariadicOutputMinArity$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetVariadicOutputMinArity$set(MemorySegment seg, long index, MemorySegment x) {
        OrtCustomOp.GetVariadicOutputMinArity$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetVariadicOutputMinArity GetVariadicOutputMinArity(MemorySegment segment, SegmentScope scope) {
        return GetVariadicOutputMinArity.ofAddress(GetVariadicOutputMinArity$get(segment), scope);
    }

    static final FunctionDescriptor GetVariadicOutputHomogeneity$FUNC =
            FunctionDescriptor.of(Constants$root.C_INT$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetVariadicOutputHomogeneity$MH =
            RuntimeHelper.downcallHandle(OrtCustomOp.GetVariadicOutputHomogeneity$FUNC);
    /**
     * {@snippet :
     * int (*GetVariadicOutputHomogeneity)(struct OrtCustomOp*);
     * }
     */
    public interface GetVariadicOutputHomogeneity {

        int apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetVariadicOutputHomogeneity fi, SegmentScope scope) {
            return RuntimeHelper.upcallStub(
                    GetVariadicOutputHomogeneity.class, fi, OrtCustomOp.GetVariadicOutputHomogeneity$FUNC, scope);
        }

        static GetVariadicOutputHomogeneity ofAddress(MemorySegment addr, SegmentScope scope) {
            MemorySegment symbol = MemorySegment.ofAddress(addr.address(), 0, scope);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (int) OrtCustomOp.GetVariadicOutputHomogeneity$MH.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetVariadicOutputHomogeneity$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("GetVariadicOutputHomogeneity"));

    public static VarHandle GetVariadicOutputHomogeneity$VH() {
        return OrtCustomOp.GetVariadicOutputHomogeneity$VH;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int (*GetVariadicOutputHomogeneity)(struct OrtCustomOp*);
     * }
     */
    public static MemorySegment GetVariadicOutputHomogeneity$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) OrtCustomOp.GetVariadicOutputHomogeneity$VH.get(seg);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int (*GetVariadicOutputHomogeneity)(struct OrtCustomOp*);
     * }
     */
    public static void GetVariadicOutputHomogeneity$set(MemorySegment seg, MemorySegment x) {
        OrtCustomOp.GetVariadicOutputHomogeneity$VH.set(seg, x);
    }

    public static MemorySegment GetVariadicOutputHomogeneity$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment)
                OrtCustomOp.GetVariadicOutputHomogeneity$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetVariadicOutputHomogeneity$set(MemorySegment seg, long index, MemorySegment x) {
        OrtCustomOp.GetVariadicOutputHomogeneity$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetVariadicOutputHomogeneity GetVariadicOutputHomogeneity(MemorySegment segment, SegmentScope scope) {
        return GetVariadicOutputHomogeneity.ofAddress(GetVariadicOutputHomogeneity$get(segment), scope);
    }

    static final FunctionDescriptor CreateKernelV2$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateKernelV2$MH = RuntimeHelper.downcallHandle(OrtCustomOp.CreateKernelV2$FUNC);

    public interface CreateKernelV2 {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2,
                java.lang.foreign.MemoryAddress _x3);

        static MemorySegment allocate(CreateKernelV2 fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CreateKernelV2.class, fi, OrtCustomOp.CreateKernelV2$FUNC, session);
        }

        static CreateKernelV2 ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2,
                    java.lang.foreign.MemoryAddress __x3) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtCustomOp.CreateKernelV2$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2,
                                    (java.lang.foreign.Addressable) __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateKernelV2$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("CreateKernelV2"));

    public static VarHandle CreateKernelV2$VH() {
        return OrtCustomOp.CreateKernelV2$VH;
    }

    public static MemoryAddress CreateKernelV2$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.CreateKernelV2$VH.get(seg);
    }

    public static void CreateKernelV2$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.CreateKernelV2$VH.set(seg, x);
    }

    public static MemoryAddress CreateKernelV2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.CreateKernelV2$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateKernelV2$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.CreateKernelV2$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateKernelV2 CreateKernelV2(MemorySegment segment, MemorySession session) {
        return CreateKernelV2.ofAddress(CreateKernelV2$get(segment), session);
    }

    static final FunctionDescriptor KernelComputeV2$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelComputeV2$MH = RuntimeHelper.downcallHandle(OrtCustomOp.KernelComputeV2$FUNC);

    public interface KernelComputeV2 {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(KernelComputeV2 fi, MemorySession session) {
            return RuntimeHelper.upcallStub(KernelComputeV2.class, fi, OrtCustomOp.KernelComputeV2$FUNC, session);
        }

        static KernelComputeV2 ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtCustomOp.KernelComputeV2$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelComputeV2$VH =
            $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("KernelComputeV2"));

    public static VarHandle KernelComputeV2$VH() {
        return OrtCustomOp.KernelComputeV2$VH;
    }

    public static MemoryAddress KernelComputeV2$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.KernelComputeV2$VH.get(seg);
    }

    public static void KernelComputeV2$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.KernelComputeV2$VH.set(seg, x);
    }

    public static MemoryAddress KernelComputeV2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.KernelComputeV2$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelComputeV2$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.KernelComputeV2$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelComputeV2 KernelComputeV2(MemorySegment segment, MemorySession session) {
        return KernelComputeV2.ofAddress(KernelComputeV2$get(segment), session);
    }

    public static long sizeof() {
        return $LAYOUT().byteSize();
    }

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate($LAYOUT());
    }

    public static MemorySegment allocateArray(long len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }

    public static MemorySegment ofAddress(MemorySegment addr, SegmentScope scope) {
        return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope);
    }
}
