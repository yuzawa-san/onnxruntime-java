/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
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
 *     OrtStatusPtr (*CreateKernelV2)(struct OrtCustomOp*,const OrtApi*,const OrtKernelInfo*,void**);
 *     OrtStatusPtr (*KernelComputeV2)(void*,OrtKernelContext*);
 * };
 * }
 */
public class OrtCustomOp {

    public static MemoryLayout $LAYOUT() {
        return constants$118.const$5;
    }

    public static VarHandle version$VH() {
        return constants$119.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * uint32_t version;
     * }
     */
    public static int version$get(MemorySegment seg) {
        return (int) constants$119.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * uint32_t version;
     * }
     */
    public static void version$set(MemorySegment seg, int x) {
        constants$119.const$0.set(seg, 0L, x);
    }

    public static int version$get(MemorySegment seg, long index) {
        return (int) constants$119.const$0.get(seg, index * sizeof());
    }

    public static void version$set(MemorySegment seg, long index, int x) {
        constants$119.const$0.set(seg, index * sizeof(), x);
    }
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

        static MemorySegment allocate(CreateKernel fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$119.const$1, fi, constants$14.const$4, scope);
        }

        static CreateKernel ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_creation_options,
                    java.lang.foreign.MemorySegment _ort_thread_worker_fn,
                    java.lang.foreign.MemorySegment _ort_worker_fn_param) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$0.invokeExact(
                            symbol, _ort_custom_thread_creation_options, _ort_thread_worker_fn, _ort_worker_fn_param);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateKernel$VH() {
        return constants$119.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void* (*CreateKernel)(struct OrtCustomOp*,const OrtApi*,const OrtKernelInfo*);
     * }
     */
    public static MemorySegment CreateKernel$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$119.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void* (*CreateKernel)(struct OrtCustomOp*,const OrtApi*,const OrtKernelInfo*);
     * }
     */
    public static void CreateKernel$set(MemorySegment seg, MemorySegment x) {
        constants$119.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateKernel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$119.const$2.get(seg, index * sizeof());
    }

    public static void CreateKernel$set(MemorySegment seg, long index, MemorySegment x) {
        constants$119.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateKernel CreateKernel(MemorySegment segment, Arena scope) {
        return CreateKernel.ofAddress(CreateKernel$get(segment), scope);
    }
    /**
     * {@snippet :
     * char* (*GetName)(struct OrtCustomOp*);
     * }
     */
    public interface GetName {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetName fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$119.const$3, fi, constants$1.const$4, scope);
        }

        static GetName ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetName$VH() {
        return constants$119.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* (*GetName)(struct OrtCustomOp*);
     * }
     */
    public static MemorySegment GetName$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$119.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* (*GetName)(struct OrtCustomOp*);
     * }
     */
    public static void GetName$set(MemorySegment seg, MemorySegment x) {
        constants$119.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$119.const$4.get(seg, index * sizeof());
    }

    public static void GetName$set(MemorySegment seg, long index, MemorySegment x) {
        constants$119.const$4.set(seg, index * sizeof(), x);
    }

    public static GetName GetName(MemorySegment segment, Arena scope) {
        return GetName.ofAddress(GetName$get(segment), scope);
    }
    /**
     * {@snippet :
     * char* (*GetExecutionProviderType)(struct OrtCustomOp*);
     * }
     */
    public interface GetExecutionProviderType {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetExecutionProviderType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$119.const$5, fi, constants$1.const$4, scope);
        }

        static GetExecutionProviderType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$2.const$0.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetExecutionProviderType$VH() {
        return constants$120.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * char* (*GetExecutionProviderType)(struct OrtCustomOp*);
     * }
     */
    public static MemorySegment GetExecutionProviderType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$120.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * char* (*GetExecutionProviderType)(struct OrtCustomOp*);
     * }
     */
    public static void GetExecutionProviderType$set(MemorySegment seg, MemorySegment x) {
        constants$120.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetExecutionProviderType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$120.const$0.get(seg, index * sizeof());
    }

    public static void GetExecutionProviderType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$120.const$0.set(seg, index * sizeof(), x);
    }

    public static GetExecutionProviderType GetExecutionProviderType(MemorySegment segment, Arena scope) {
        return GetExecutionProviderType.ofAddress(GetExecutionProviderType$get(segment), scope);
    }
    /**
     * {@snippet :
     * ONNXTensorElementDataType (*GetInputType)(struct OrtCustomOp*,size_t);
     * }
     */
    public interface GetInputType {

        int apply(java.lang.foreign.MemorySegment _x0, long _x1);

        static MemorySegment allocate(GetInputType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$120.const$2, fi, constants$120.const$1, scope);
        }

        static GetInputType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1) -> {
                try {
                    return (int) constants$120.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetInputType$VH() {
        return constants$120.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * ONNXTensorElementDataType (*GetInputType)(struct OrtCustomOp*,size_t);
     * }
     */
    public static MemorySegment GetInputType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$120.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * ONNXTensorElementDataType (*GetInputType)(struct OrtCustomOp*,size_t);
     * }
     */
    public static void GetInputType$set(MemorySegment seg, MemorySegment x) {
        constants$120.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetInputType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$120.const$4.get(seg, index * sizeof());
    }

    public static void GetInputType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$120.const$4.set(seg, index * sizeof(), x);
    }

    public static GetInputType GetInputType(MemorySegment segment, Arena scope) {
        return GetInputType.ofAddress(GetInputType$get(segment), scope);
    }
    /**
     * {@snippet :
     * size_t (*GetInputTypeCount)(struct OrtCustomOp*);
     * }
     */
    public interface GetInputTypeCount {

        long apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetInputTypeCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$121.const$0, fi, constants$120.const$5, scope);
        }

        static GetInputTypeCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (long) constants$121.const$1.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetInputTypeCount$VH() {
        return constants$121.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * size_t (*GetInputTypeCount)(struct OrtCustomOp*);
     * }
     */
    public static MemorySegment GetInputTypeCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$121.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * size_t (*GetInputTypeCount)(struct OrtCustomOp*);
     * }
     */
    public static void GetInputTypeCount$set(MemorySegment seg, MemorySegment x) {
        constants$121.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetInputTypeCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$121.const$2.get(seg, index * sizeof());
    }

    public static void GetInputTypeCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$121.const$2.set(seg, index * sizeof(), x);
    }

    public static GetInputTypeCount GetInputTypeCount(MemorySegment segment, Arena scope) {
        return GetInputTypeCount.ofAddress(GetInputTypeCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * ONNXTensorElementDataType (*GetOutputType)(struct OrtCustomOp*,size_t);
     * }
     */
    public interface GetOutputType {

        int apply(java.lang.foreign.MemorySegment _x0, long _x1);

        static MemorySegment allocate(GetOutputType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$121.const$3, fi, constants$120.const$1, scope);
        }

        static GetOutputType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1) -> {
                try {
                    return (int) constants$120.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetOutputType$VH() {
        return constants$121.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * ONNXTensorElementDataType (*GetOutputType)(struct OrtCustomOp*,size_t);
     * }
     */
    public static MemorySegment GetOutputType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$121.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * ONNXTensorElementDataType (*GetOutputType)(struct OrtCustomOp*,size_t);
     * }
     */
    public static void GetOutputType$set(MemorySegment seg, MemorySegment x) {
        constants$121.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetOutputType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$121.const$4.get(seg, index * sizeof());
    }

    public static void GetOutputType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$121.const$4.set(seg, index * sizeof(), x);
    }

    public static GetOutputType GetOutputType(MemorySegment segment, Arena scope) {
        return GetOutputType.ofAddress(GetOutputType$get(segment), scope);
    }
    /**
     * {@snippet :
     * size_t (*GetOutputTypeCount)(struct OrtCustomOp*);
     * }
     */
    public interface GetOutputTypeCount {

        long apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetOutputTypeCount fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$121.const$5, fi, constants$120.const$5, scope);
        }

        static GetOutputTypeCount ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (long) constants$121.const$1.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetOutputTypeCount$VH() {
        return constants$122.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * size_t (*GetOutputTypeCount)(struct OrtCustomOp*);
     * }
     */
    public static MemorySegment GetOutputTypeCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$122.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * size_t (*GetOutputTypeCount)(struct OrtCustomOp*);
     * }
     */
    public static void GetOutputTypeCount$set(MemorySegment seg, MemorySegment x) {
        constants$122.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetOutputTypeCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$122.const$0.get(seg, index * sizeof());
    }

    public static void GetOutputTypeCount$set(MemorySegment seg, long index, MemorySegment x) {
        constants$122.const$0.set(seg, index * sizeof(), x);
    }

    public static GetOutputTypeCount GetOutputTypeCount(MemorySegment segment, Arena scope) {
        return GetOutputTypeCount.ofAddress(GetOutputTypeCount$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*KernelCompute)(void*,OrtKernelContext*);
     * }
     */
    public interface KernelCompute {

        void apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(KernelCompute fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$122.const$1, fi, constants$1.const$0, scope);
        }

        static KernelCompute ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    constants$1.const$2.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelCompute$VH() {
        return constants$122.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*KernelCompute)(void*,OrtKernelContext*);
     * }
     */
    public static MemorySegment KernelCompute$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$122.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*KernelCompute)(void*,OrtKernelContext*);
     * }
     */
    public static void KernelCompute$set(MemorySegment seg, MemorySegment x) {
        constants$122.const$2.set(seg, 0L, x);
    }

    public static MemorySegment KernelCompute$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$122.const$2.get(seg, index * sizeof());
    }

    public static void KernelCompute$set(MemorySegment seg, long index, MemorySegment x) {
        constants$122.const$2.set(seg, index * sizeof(), x);
    }

    public static KernelCompute KernelCompute(MemorySegment segment, Arena scope) {
        return KernelCompute.ofAddress(KernelCompute$get(segment), scope);
    }
    /**
     * {@snippet :
     * void (*KernelDestroy)(void*);
     * }
     */
    public interface KernelDestroy {

        void apply(java.lang.foreign.MemorySegment ort_custom_thread_handle);

        static MemorySegment allocate(KernelDestroy fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$122.const$3, fi, constants$13.const$5, scope);
        }

        static KernelDestroy ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment _ort_custom_thread_handle) -> {
                try {
                    constants$14.const$1.invokeExact(symbol, _ort_custom_thread_handle);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelDestroy$VH() {
        return constants$122.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * void (*KernelDestroy)(void*);
     * }
     */
    public static MemorySegment KernelDestroy$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$122.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * void (*KernelDestroy)(void*);
     * }
     */
    public static void KernelDestroy$set(MemorySegment seg, MemorySegment x) {
        constants$122.const$4.set(seg, 0L, x);
    }

    public static MemorySegment KernelDestroy$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$122.const$4.get(seg, index * sizeof());
    }

    public static void KernelDestroy$set(MemorySegment seg, long index, MemorySegment x) {
        constants$122.const$4.set(seg, index * sizeof(), x);
    }

    public static KernelDestroy KernelDestroy(MemorySegment segment, Arena scope) {
        return KernelDestroy.ofAddress(KernelDestroy$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtCustomOpInputOutputCharacteristic (*GetInputCharacteristic)(struct OrtCustomOp*,size_t);
     * }
     */
    public interface GetInputCharacteristic {

        int apply(java.lang.foreign.MemorySegment _x0, long _x1);

        static MemorySegment allocate(GetInputCharacteristic fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$122.const$5, fi, constants$120.const$1, scope);
        }

        static GetInputCharacteristic ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1) -> {
                try {
                    return (int) constants$120.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetInputCharacteristic$VH() {
        return constants$123.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtCustomOpInputOutputCharacteristic (*GetInputCharacteristic)(struct OrtCustomOp*,size_t);
     * }
     */
    public static MemorySegment GetInputCharacteristic$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$123.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtCustomOpInputOutputCharacteristic (*GetInputCharacteristic)(struct OrtCustomOp*,size_t);
     * }
     */
    public static void GetInputCharacteristic$set(MemorySegment seg, MemorySegment x) {
        constants$123.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetInputCharacteristic$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$123.const$0.get(seg, index * sizeof());
    }

    public static void GetInputCharacteristic$set(MemorySegment seg, long index, MemorySegment x) {
        constants$123.const$0.set(seg, index * sizeof(), x);
    }

    public static GetInputCharacteristic GetInputCharacteristic(MemorySegment segment, Arena scope) {
        return GetInputCharacteristic.ofAddress(GetInputCharacteristic$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtCustomOpInputOutputCharacteristic (*GetOutputCharacteristic)(struct OrtCustomOp*,size_t);
     * }
     */
    public interface GetOutputCharacteristic {

        int apply(java.lang.foreign.MemorySegment _x0, long _x1);

        static MemorySegment allocate(GetOutputCharacteristic fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$123.const$1, fi, constants$120.const$1, scope);
        }

        static GetOutputCharacteristic ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1) -> {
                try {
                    return (int) constants$120.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetOutputCharacteristic$VH() {
        return constants$123.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtCustomOpInputOutputCharacteristic (*GetOutputCharacteristic)(struct OrtCustomOp*,size_t);
     * }
     */
    public static MemorySegment GetOutputCharacteristic$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$123.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtCustomOpInputOutputCharacteristic (*GetOutputCharacteristic)(struct OrtCustomOp*,size_t);
     * }
     */
    public static void GetOutputCharacteristic$set(MemorySegment seg, MemorySegment x) {
        constants$123.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetOutputCharacteristic$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$123.const$2.get(seg, index * sizeof());
    }

    public static void GetOutputCharacteristic$set(MemorySegment seg, long index, MemorySegment x) {
        constants$123.const$2.set(seg, index * sizeof(), x);
    }

    public static GetOutputCharacteristic GetOutputCharacteristic(MemorySegment segment, Arena scope) {
        return GetOutputCharacteristic.ofAddress(GetOutputCharacteristic$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtMemType (*GetInputMemoryType)(struct OrtCustomOp*,size_t);
     * }
     */
    public interface GetInputMemoryType {

        int apply(java.lang.foreign.MemorySegment _x0, long _x1);

        static MemorySegment allocate(GetInputMemoryType fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$123.const$3, fi, constants$120.const$1, scope);
        }

        static GetInputMemoryType ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, long __x1) -> {
                try {
                    return (int) constants$120.const$3.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetInputMemoryType$VH() {
        return constants$123.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtMemType (*GetInputMemoryType)(struct OrtCustomOp*,size_t);
     * }
     */
    public static MemorySegment GetInputMemoryType$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$123.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtMemType (*GetInputMemoryType)(struct OrtCustomOp*,size_t);
     * }
     */
    public static void GetInputMemoryType$set(MemorySegment seg, MemorySegment x) {
        constants$123.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetInputMemoryType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$123.const$4.get(seg, index * sizeof());
    }

    public static void GetInputMemoryType$set(MemorySegment seg, long index, MemorySegment x) {
        constants$123.const$4.set(seg, index * sizeof(), x);
    }

    public static GetInputMemoryType GetInputMemoryType(MemorySegment segment, Arena scope) {
        return GetInputMemoryType.ofAddress(GetInputMemoryType$get(segment), scope);
    }
    /**
     * {@snippet :
     * int (*GetVariadicInputMinArity)(struct OrtCustomOp*);
     * }
     */
    public interface GetVariadicInputMinArity {

        int apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetVariadicInputMinArity fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$123.const$5, fi, constants$17.const$1, scope);
        }

        static GetVariadicInputMinArity ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (int) constants$17.const$3.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetVariadicInputMinArity$VH() {
        return constants$124.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int (*GetVariadicInputMinArity)(struct OrtCustomOp*);
     * }
     */
    public static MemorySegment GetVariadicInputMinArity$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$124.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int (*GetVariadicInputMinArity)(struct OrtCustomOp*);
     * }
     */
    public static void GetVariadicInputMinArity$set(MemorySegment seg, MemorySegment x) {
        constants$124.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetVariadicInputMinArity$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$124.const$0.get(seg, index * sizeof());
    }

    public static void GetVariadicInputMinArity$set(MemorySegment seg, long index, MemorySegment x) {
        constants$124.const$0.set(seg, index * sizeof(), x);
    }

    public static GetVariadicInputMinArity GetVariadicInputMinArity(MemorySegment segment, Arena scope) {
        return GetVariadicInputMinArity.ofAddress(GetVariadicInputMinArity$get(segment), scope);
    }
    /**
     * {@snippet :
     * int (*GetVariadicInputHomogeneity)(struct OrtCustomOp*);
     * }
     */
    public interface GetVariadicInputHomogeneity {

        int apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetVariadicInputHomogeneity fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$124.const$1, fi, constants$17.const$1, scope);
        }

        static GetVariadicInputHomogeneity ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (int) constants$17.const$3.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetVariadicInputHomogeneity$VH() {
        return constants$124.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int (*GetVariadicInputHomogeneity)(struct OrtCustomOp*);
     * }
     */
    public static MemorySegment GetVariadicInputHomogeneity$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$124.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int (*GetVariadicInputHomogeneity)(struct OrtCustomOp*);
     * }
     */
    public static void GetVariadicInputHomogeneity$set(MemorySegment seg, MemorySegment x) {
        constants$124.const$2.set(seg, 0L, x);
    }

    public static MemorySegment GetVariadicInputHomogeneity$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$124.const$2.get(seg, index * sizeof());
    }

    public static void GetVariadicInputHomogeneity$set(MemorySegment seg, long index, MemorySegment x) {
        constants$124.const$2.set(seg, index * sizeof(), x);
    }

    public static GetVariadicInputHomogeneity GetVariadicInputHomogeneity(MemorySegment segment, Arena scope) {
        return GetVariadicInputHomogeneity.ofAddress(GetVariadicInputHomogeneity$get(segment), scope);
    }
    /**
     * {@snippet :
     * int (*GetVariadicOutputMinArity)(struct OrtCustomOp*);
     * }
     */
    public interface GetVariadicOutputMinArity {

        int apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetVariadicOutputMinArity fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$124.const$3, fi, constants$17.const$1, scope);
        }

        static GetVariadicOutputMinArity ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (int) constants$17.const$3.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetVariadicOutputMinArity$VH() {
        return constants$124.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int (*GetVariadicOutputMinArity)(struct OrtCustomOp*);
     * }
     */
    public static MemorySegment GetVariadicOutputMinArity$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$124.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int (*GetVariadicOutputMinArity)(struct OrtCustomOp*);
     * }
     */
    public static void GetVariadicOutputMinArity$set(MemorySegment seg, MemorySegment x) {
        constants$124.const$4.set(seg, 0L, x);
    }

    public static MemorySegment GetVariadicOutputMinArity$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$124.const$4.get(seg, index * sizeof());
    }

    public static void GetVariadicOutputMinArity$set(MemorySegment seg, long index, MemorySegment x) {
        constants$124.const$4.set(seg, index * sizeof(), x);
    }

    public static GetVariadicOutputMinArity GetVariadicOutputMinArity(MemorySegment segment, Arena scope) {
        return GetVariadicOutputMinArity.ofAddress(GetVariadicOutputMinArity$get(segment), scope);
    }
    /**
     * {@snippet :
     * int (*GetVariadicOutputHomogeneity)(struct OrtCustomOp*);
     * }
     */
    public interface GetVariadicOutputHomogeneity {

        int apply(java.lang.foreign.MemorySegment _x0);

        static MemorySegment allocate(GetVariadicOutputHomogeneity fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$124.const$5, fi, constants$17.const$1, scope);
        }

        static GetVariadicOutputHomogeneity ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0) -> {
                try {
                    return (int) constants$17.const$3.invokeExact(symbol, __x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle GetVariadicOutputHomogeneity$VH() {
        return constants$125.const$0;
    }
    /**
     * Getter for field:
     * {@snippet :
     * int (*GetVariadicOutputHomogeneity)(struct OrtCustomOp*);
     * }
     */
    public static MemorySegment GetVariadicOutputHomogeneity$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$125.const$0.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * int (*GetVariadicOutputHomogeneity)(struct OrtCustomOp*);
     * }
     */
    public static void GetVariadicOutputHomogeneity$set(MemorySegment seg, MemorySegment x) {
        constants$125.const$0.set(seg, 0L, x);
    }

    public static MemorySegment GetVariadicOutputHomogeneity$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$125.const$0.get(seg, index * sizeof());
    }

    public static void GetVariadicOutputHomogeneity$set(MemorySegment seg, long index, MemorySegment x) {
        constants$125.const$0.set(seg, index * sizeof(), x);
    }

    public static GetVariadicOutputHomogeneity GetVariadicOutputHomogeneity(MemorySegment segment, Arena scope) {
        return GetVariadicOutputHomogeneity.ofAddress(GetVariadicOutputHomogeneity$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*CreateKernelV2)(struct OrtCustomOp*,const OrtApi*,const OrtKernelInfo*,void**);
     * }
     */
    public interface CreateKernelV2 {

        java.lang.foreign.MemorySegment apply(
                java.lang.foreign.MemorySegment _x0,
                java.lang.foreign.MemorySegment _x1,
                java.lang.foreign.MemorySegment _x2,
                java.lang.foreign.MemorySegment _x3);

        static MemorySegment allocate(CreateKernelV2 fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$125.const$1, fi, constants$20.const$1, scope);
        }

        static CreateKernelV2 ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0,
                    java.lang.foreign.MemorySegment __x1,
                    java.lang.foreign.MemorySegment __x2,
                    java.lang.foreign.MemorySegment __x3) -> {
                try {
                    return (java.lang.foreign.MemorySegment)
                            constants$20.const$3.invokeExact(symbol, __x0, __x1, __x2, __x3);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle CreateKernelV2$VH() {
        return constants$125.const$2;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateKernelV2)(struct OrtCustomOp*,const OrtApi*,const OrtKernelInfo*,void**);
     * }
     */
    public static MemorySegment CreateKernelV2$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$125.const$2.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*CreateKernelV2)(struct OrtCustomOp*,const OrtApi*,const OrtKernelInfo*,void**);
     * }
     */
    public static void CreateKernelV2$set(MemorySegment seg, MemorySegment x) {
        constants$125.const$2.set(seg, 0L, x);
    }

    public static MemorySegment CreateKernelV2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$125.const$2.get(seg, index * sizeof());
    }

    public static void CreateKernelV2$set(MemorySegment seg, long index, MemorySegment x) {
        constants$125.const$2.set(seg, index * sizeof(), x);
    }

    public static CreateKernelV2 CreateKernelV2(MemorySegment segment, Arena scope) {
        return CreateKernelV2.ofAddress(CreateKernelV2$get(segment), scope);
    }
    /**
     * {@snippet :
     * OrtStatusPtr (*KernelComputeV2)(void*,OrtKernelContext*);
     * }
     */
    public interface KernelComputeV2 {

        java.lang.foreign.MemorySegment apply(java.lang.foreign.MemorySegment _x0, java.lang.foreign.MemorySegment _x1);

        static MemorySegment allocate(KernelComputeV2 fi, Arena scope) {
            return RuntimeHelper.upcallStub(constants$125.const$3, fi, constants$15.const$2, scope);
        }

        static KernelComputeV2 ofAddress(MemorySegment addr, Arena arena) {
            MemorySegment symbol = addr.reinterpret(arena, null);
            return (java.lang.foreign.MemorySegment __x0, java.lang.foreign.MemorySegment __x1) -> {
                try {
                    return (java.lang.foreign.MemorySegment) constants$15.const$4.invokeExact(symbol, __x0, __x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    public static VarHandle KernelComputeV2$VH() {
        return constants$125.const$4;
    }
    /**
     * Getter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelComputeV2)(void*,OrtKernelContext*);
     * }
     */
    public static MemorySegment KernelComputeV2$get(MemorySegment seg) {
        return (java.lang.foreign.MemorySegment) constants$125.const$4.get(seg, 0L);
    }
    /**
     * Setter for field:
     * {@snippet :
     * OrtStatusPtr (*KernelComputeV2)(void*,OrtKernelContext*);
     * }
     */
    public static void KernelComputeV2$set(MemorySegment seg, MemorySegment x) {
        constants$125.const$4.set(seg, 0L, x);
    }

    public static MemorySegment KernelComputeV2$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemorySegment) constants$125.const$4.get(seg, index * sizeof());
    }

    public static void KernelComputeV2$set(MemorySegment seg, long index, MemorySegment x) {
        constants$125.const$4.set(seg, index * sizeof(), x);
    }

    public static KernelComputeV2 KernelComputeV2(MemorySegment segment, Arena scope) {
        return KernelComputeV2.ofAddress(KernelComputeV2$get(segment), scope);
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

    public static MemorySegment ofAddress(MemorySegment addr, Arena scope) {
        return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope);
    }
}
