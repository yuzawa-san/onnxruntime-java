/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static jdk.incubator.foreign.CLinker.*;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import jdk.incubator.foreign.*;

public class OrtCustomOp {

    static final MemoryLayout $struct$LAYOUT = MemoryLayout.structLayout(
                    C_INT.withName("version"),
                    MemoryLayout.paddingLayout(32),
                    C_POINTER.withName("CreateKernel"),
                    C_POINTER.withName("GetName"),
                    C_POINTER.withName("GetExecutionProviderType"),
                    C_POINTER.withName("GetInputType"),
                    C_POINTER.withName("GetInputTypeCount"),
                    C_POINTER.withName("GetOutputType"),
                    C_POINTER.withName("GetOutputTypeCount"),
                    C_POINTER.withName("KernelCompute"),
                    C_POINTER.withName("KernelDestroy"),
                    C_POINTER.withName("GetInputCharacteristic"),
                    C_POINTER.withName("GetOutputCharacteristic"))
            .withName("OrtCustomOp");

    public static MemoryLayout $LAYOUT() {
        return OrtCustomOp.$struct$LAYOUT;
    }

    static final VarHandle version$VH =
            $struct$LAYOUT.varHandle(int.class, MemoryLayout.PathElement.groupElement("version"));

    public static VarHandle version$VH() {
        return OrtCustomOp.version$VH;
    }

    public static int version$get(MemorySegment seg) {
        return (int) OrtCustomOp.version$VH.get(seg);
    }

    public static void version$set(MemorySegment seg, int x) {
        OrtCustomOp.version$VH.set(seg, x);
    }

    public static int version$get(MemorySegment seg, long index) {
        return (int) OrtCustomOp.version$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void version$set(MemorySegment seg, long index, int x) {
        OrtCustomOp.version$VH.set(seg.asSlice(index * sizeof()), x);
    }

    static final FunctionDescriptor CreateKernel$FUNC =
            FunctionDescriptor.of(C_POINTER, C_POINTER, C_POINTER, C_POINTER);
    static final MethodHandle CreateKernel$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtCustomOp.CreateKernel$FUNC,
            false);

    public interface CreateKernel {

        jdk.incubator.foreign.MemoryAddress apply(
                jdk.incubator.foreign.MemoryAddress x0,
                jdk.incubator.foreign.MemoryAddress x1,
                jdk.incubator.foreign.MemoryAddress x2);

        static MemoryAddress allocate(CreateKernel fi) {
            return RuntimeHelper.upcallStub(
                    CreateKernel.class,
                    fi,
                    OrtCustomOp.CreateKernel$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(CreateKernel fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    CreateKernel.class,
                    fi,
                    OrtCustomOp.CreateKernel$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static CreateKernel ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0,
                    jdk.incubator.foreign.MemoryAddress x1,
                    jdk.incubator.foreign.MemoryAddress x2) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtCustomOp.CreateKernel$MH.invokeExact((Addressable) addr, x0, x1, x2);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle CreateKernel$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("CreateKernel")));

    public static VarHandle CreateKernel$VH() {
        return OrtCustomOp.CreateKernel$VH;
    }

    public static MemoryAddress CreateKernel$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCustomOp.CreateKernel$VH.get(seg);
    }

    public static void CreateKernel$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.CreateKernel$VH.set(seg, x);
    }

    public static MemoryAddress CreateKernel$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCustomOp.CreateKernel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateKernel$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.CreateKernel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateKernel CreateKernel(MemorySegment segment) {
        return CreateKernel.ofAddress(CreateKernel$get(segment));
    }

    static final FunctionDescriptor GetName$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle GetName$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtCustomOp.GetName$FUNC,
            false);

    public interface GetName {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(GetName fi) {
            return RuntimeHelper.upcallStub(
                    GetName.class,
                    fi,
                    OrtCustomOp.GetName$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetName fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetName.class,
                    fi,
                    OrtCustomOp.GetName$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetName ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtCustomOp.GetName$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetName$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetName")));

    public static VarHandle GetName$VH() {
        return OrtCustomOp.GetName$VH;
    }

    public static MemoryAddress GetName$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCustomOp.GetName$VH.get(seg);
    }

    public static void GetName$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.GetName$VH.set(seg, x);
    }

    public static MemoryAddress GetName$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCustomOp.GetName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.GetName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetName GetName(MemorySegment segment) {
        return GetName.ofAddress(GetName$get(segment));
    }

    static final FunctionDescriptor GetExecutionProviderType$FUNC = FunctionDescriptor.of(C_POINTER, C_POINTER);
    static final MethodHandle GetExecutionProviderType$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            OrtCustomOp.GetExecutionProviderType$FUNC,
            false);

    public interface GetExecutionProviderType {

        jdk.incubator.foreign.MemoryAddress apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(GetExecutionProviderType fi) {
            return RuntimeHelper.upcallStub(
                    GetExecutionProviderType.class,
                    fi,
                    OrtCustomOp.GetExecutionProviderType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;");
        }

        static MemoryAddress allocate(GetExecutionProviderType fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetExecutionProviderType.class,
                    fi,
                    OrtCustomOp.GetExecutionProviderType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
                    scope);
        }

        static GetExecutionProviderType ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (jdk.incubator.foreign.MemoryAddress)
                            OrtCustomOp.GetExecutionProviderType$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetExecutionProviderType$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetExecutionProviderType")));

    public static VarHandle GetExecutionProviderType$VH() {
        return OrtCustomOp.GetExecutionProviderType$VH;
    }

    public static MemoryAddress GetExecutionProviderType$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCustomOp.GetExecutionProviderType$VH.get(seg);
    }

    public static void GetExecutionProviderType$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.GetExecutionProviderType$VH.set(seg, x);
    }

    public static MemoryAddress GetExecutionProviderType$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtCustomOp.GetExecutionProviderType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetExecutionProviderType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.GetExecutionProviderType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetExecutionProviderType GetExecutionProviderType(MemorySegment segment) {
        return GetExecutionProviderType.ofAddress(GetExecutionProviderType$get(segment));
    }

    static final FunctionDescriptor GetInputType$FUNC = FunctionDescriptor.of(C_INT, C_POINTER, C_LONG);
    static final MethodHandle GetInputType$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;J)I", OrtCustomOp.GetInputType$FUNC, false);

    public interface GetInputType {

        int apply(jdk.incubator.foreign.MemoryAddress x0, long x1);

        static MemoryAddress allocate(GetInputType fi) {
            return RuntimeHelper.upcallStub(
                    GetInputType.class, fi, OrtCustomOp.GetInputType$FUNC, "(Ljdk/incubator/foreign/MemoryAddress;J)I");
        }

        static MemoryAddress allocate(GetInputType fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetInputType.class,
                    fi,
                    OrtCustomOp.GetInputType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;J)I",
                    scope);
        }

        static GetInputType ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, long x1) -> {
                try {
                    return (int) OrtCustomOp.GetInputType$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetInputType$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetInputType")));

    public static VarHandle GetInputType$VH() {
        return OrtCustomOp.GetInputType$VH;
    }

    public static MemoryAddress GetInputType$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCustomOp.GetInputType$VH.get(seg);
    }

    public static void GetInputType$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.GetInputType$VH.set(seg, x);
    }

    public static MemoryAddress GetInputType$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCustomOp.GetInputType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetInputType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.GetInputType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetInputType GetInputType(MemorySegment segment) {
        return GetInputType.ofAddress(GetInputType$get(segment));
    }

    static final FunctionDescriptor GetInputTypeCount$FUNC = FunctionDescriptor.of(C_LONG, C_POINTER);
    static final MethodHandle GetInputTypeCount$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)J", OrtCustomOp.GetInputTypeCount$FUNC, false);

    public interface GetInputTypeCount {

        long apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(GetInputTypeCount fi) {
            return RuntimeHelper.upcallStub(
                    GetInputTypeCount.class,
                    fi,
                    OrtCustomOp.GetInputTypeCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)J");
        }

        static MemoryAddress allocate(GetInputTypeCount fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetInputTypeCount.class,
                    fi,
                    OrtCustomOp.GetInputTypeCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)J",
                    scope);
        }

        static GetInputTypeCount ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (long) OrtCustomOp.GetInputTypeCount$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetInputTypeCount$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetInputTypeCount")));

    public static VarHandle GetInputTypeCount$VH() {
        return OrtCustomOp.GetInputTypeCount$VH;
    }

    public static MemoryAddress GetInputTypeCount$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCustomOp.GetInputTypeCount$VH.get(seg);
    }

    public static void GetInputTypeCount$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.GetInputTypeCount$VH.set(seg, x);
    }

    public static MemoryAddress GetInputTypeCount$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtCustomOp.GetInputTypeCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetInputTypeCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.GetInputTypeCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetInputTypeCount GetInputTypeCount(MemorySegment segment) {
        return GetInputTypeCount.ofAddress(GetInputTypeCount$get(segment));
    }

    static final FunctionDescriptor GetOutputType$FUNC = FunctionDescriptor.of(C_INT, C_POINTER, C_LONG);
    static final MethodHandle GetOutputType$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;J)I", OrtCustomOp.GetOutputType$FUNC, false);

    public interface GetOutputType {

        int apply(jdk.incubator.foreign.MemoryAddress x0, long x1);

        static MemoryAddress allocate(GetOutputType fi) {
            return RuntimeHelper.upcallStub(
                    GetOutputType.class,
                    fi,
                    OrtCustomOp.GetOutputType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;J)I");
        }

        static MemoryAddress allocate(GetOutputType fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetOutputType.class,
                    fi,
                    OrtCustomOp.GetOutputType$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;J)I",
                    scope);
        }

        static GetOutputType ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, long x1) -> {
                try {
                    return (int) OrtCustomOp.GetOutputType$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetOutputType$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetOutputType")));

    public static VarHandle GetOutputType$VH() {
        return OrtCustomOp.GetOutputType$VH;
    }

    public static MemoryAddress GetOutputType$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCustomOp.GetOutputType$VH.get(seg);
    }

    public static void GetOutputType$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.GetOutputType$VH.set(seg, x);
    }

    public static MemoryAddress GetOutputType$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCustomOp.GetOutputType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetOutputType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.GetOutputType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetOutputType GetOutputType(MemorySegment segment) {
        return GetOutputType.ofAddress(GetOutputType$get(segment));
    }

    static final FunctionDescriptor GetOutputTypeCount$FUNC = FunctionDescriptor.of(C_LONG, C_POINTER);
    static final MethodHandle GetOutputTypeCount$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)J", OrtCustomOp.GetOutputTypeCount$FUNC, false);

    public interface GetOutputTypeCount {

        long apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(GetOutputTypeCount fi) {
            return RuntimeHelper.upcallStub(
                    GetOutputTypeCount.class,
                    fi,
                    OrtCustomOp.GetOutputTypeCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)J");
        }

        static MemoryAddress allocate(GetOutputTypeCount fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetOutputTypeCount.class,
                    fi,
                    OrtCustomOp.GetOutputTypeCount$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)J",
                    scope);
        }

        static GetOutputTypeCount ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    return (long) OrtCustomOp.GetOutputTypeCount$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetOutputTypeCount$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetOutputTypeCount")));

    public static VarHandle GetOutputTypeCount$VH() {
        return OrtCustomOp.GetOutputTypeCount$VH;
    }

    public static MemoryAddress GetOutputTypeCount$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCustomOp.GetOutputTypeCount$VH.get(seg);
    }

    public static void GetOutputTypeCount$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.GetOutputTypeCount$VH.set(seg, x);
    }

    public static MemoryAddress GetOutputTypeCount$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtCustomOp.GetOutputTypeCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetOutputTypeCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.GetOutputTypeCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetOutputTypeCount GetOutputTypeCount(MemorySegment segment) {
        return GetOutputTypeCount.ofAddress(GetOutputTypeCount$get(segment));
    }

    static final FunctionDescriptor KernelCompute$FUNC = FunctionDescriptor.ofVoid(C_POINTER, C_POINTER);
    static final MethodHandle KernelCompute$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
            OrtCustomOp.KernelCompute$FUNC,
            false);

    public interface KernelCompute {

        void apply(jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1);

        static MemoryAddress allocate(KernelCompute fi) {
            return RuntimeHelper.upcallStub(
                    KernelCompute.class,
                    fi,
                    OrtCustomOp.KernelCompute$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(KernelCompute fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelCompute.class,
                    fi,
                    OrtCustomOp.KernelCompute$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static KernelCompute ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1) -> {
                try {
                    OrtCustomOp.KernelCompute$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelCompute$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("KernelCompute")));

    public static VarHandle KernelCompute$VH() {
        return OrtCustomOp.KernelCompute$VH;
    }

    public static MemoryAddress KernelCompute$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCustomOp.KernelCompute$VH.get(seg);
    }

    public static void KernelCompute$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.KernelCompute$VH.set(seg, x);
    }

    public static MemoryAddress KernelCompute$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCustomOp.KernelCompute$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelCompute$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.KernelCompute$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelCompute KernelCompute(MemorySegment segment) {
        return KernelCompute.ofAddress(KernelCompute$get(segment));
    }

    static final FunctionDescriptor KernelDestroy$FUNC = FunctionDescriptor.ofVoid(C_POINTER);
    static final MethodHandle KernelDestroy$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;)V", OrtCustomOp.KernelDestroy$FUNC, false);

    public interface KernelDestroy {

        void apply(jdk.incubator.foreign.MemoryAddress x0);

        static MemoryAddress allocate(KernelDestroy fi) {
            return RuntimeHelper.upcallStub(
                    KernelDestroy.class,
                    fi,
                    OrtCustomOp.KernelDestroy$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V");
        }

        static MemoryAddress allocate(KernelDestroy fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    KernelDestroy.class,
                    fi,
                    OrtCustomOp.KernelDestroy$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;)V",
                    scope);
        }

        static KernelDestroy ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0) -> {
                try {
                    OrtCustomOp.KernelDestroy$MH.invokeExact((Addressable) addr, x0);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle KernelDestroy$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("KernelDestroy")));

    public static VarHandle KernelDestroy$VH() {
        return OrtCustomOp.KernelDestroy$VH;
    }

    public static MemoryAddress KernelDestroy$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCustomOp.KernelDestroy$VH.get(seg);
    }

    public static void KernelDestroy$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.KernelDestroy$VH.set(seg, x);
    }

    public static MemoryAddress KernelDestroy$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCustomOp.KernelDestroy$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelDestroy$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.KernelDestroy$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelDestroy KernelDestroy(MemorySegment segment) {
        return KernelDestroy.ofAddress(KernelDestroy$get(segment));
    }

    static final FunctionDescriptor GetInputCharacteristic$FUNC = FunctionDescriptor.of(C_INT, C_POINTER, C_LONG);
    static final MethodHandle GetInputCharacteristic$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;J)I", OrtCustomOp.GetInputCharacteristic$FUNC, false);

    public interface GetInputCharacteristic {

        int apply(jdk.incubator.foreign.MemoryAddress x0, long x1);

        static MemoryAddress allocate(GetInputCharacteristic fi) {
            return RuntimeHelper.upcallStub(
                    GetInputCharacteristic.class,
                    fi,
                    OrtCustomOp.GetInputCharacteristic$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;J)I");
        }

        static MemoryAddress allocate(GetInputCharacteristic fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetInputCharacteristic.class,
                    fi,
                    OrtCustomOp.GetInputCharacteristic$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;J)I",
                    scope);
        }

        static GetInputCharacteristic ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, long x1) -> {
                try {
                    return (int) OrtCustomOp.GetInputCharacteristic$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetInputCharacteristic$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetInputCharacteristic")));

    public static VarHandle GetInputCharacteristic$VH() {
        return OrtCustomOp.GetInputCharacteristic$VH;
    }

    public static MemoryAddress GetInputCharacteristic$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCustomOp.GetInputCharacteristic$VH.get(seg);
    }

    public static void GetInputCharacteristic$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.GetInputCharacteristic$VH.set(seg, x);
    }

    public static MemoryAddress GetInputCharacteristic$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtCustomOp.GetInputCharacteristic$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetInputCharacteristic$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.GetInputCharacteristic$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetInputCharacteristic GetInputCharacteristic(MemorySegment segment) {
        return GetInputCharacteristic.ofAddress(GetInputCharacteristic$get(segment));
    }

    static final FunctionDescriptor GetOutputCharacteristic$FUNC = FunctionDescriptor.of(C_INT, C_POINTER, C_LONG);
    static final MethodHandle GetOutputCharacteristic$MH = RuntimeHelper.downcallHandle(
            "(Ljdk/incubator/foreign/MemoryAddress;J)I", OrtCustomOp.GetOutputCharacteristic$FUNC, false);

    public interface GetOutputCharacteristic {

        int apply(jdk.incubator.foreign.MemoryAddress x0, long x1);

        static MemoryAddress allocate(GetOutputCharacteristic fi) {
            return RuntimeHelper.upcallStub(
                    GetOutputCharacteristic.class,
                    fi,
                    OrtCustomOp.GetOutputCharacteristic$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;J)I");
        }

        static MemoryAddress allocate(GetOutputCharacteristic fi, ResourceScope scope) {
            return RuntimeHelper.upcallStub(
                    GetOutputCharacteristic.class,
                    fi,
                    OrtCustomOp.GetOutputCharacteristic$FUNC,
                    "(Ljdk/incubator/foreign/MemoryAddress;J)I",
                    scope);
        }

        static GetOutputCharacteristic ofAddress(MemoryAddress addr) {
            return (jdk.incubator.foreign.MemoryAddress x0, long x1) -> {
                try {
                    return (int) OrtCustomOp.GetOutputCharacteristic$MH.invokeExact((Addressable) addr, x0, x1);
                } catch (Throwable ex$) {
                    throw new AssertionError("should not reach here", ex$);
                }
            };
        }
    }

    static final VarHandle GetOutputCharacteristic$VH = MemoryHandles.asAddressVarHandle(
            $struct$LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("GetOutputCharacteristic")));

    public static VarHandle GetOutputCharacteristic$VH() {
        return OrtCustomOp.GetOutputCharacteristic$VH;
    }

    public static MemoryAddress GetOutputCharacteristic$get(MemorySegment seg) {
        return (jdk.incubator.foreign.MemoryAddress) OrtCustomOp.GetOutputCharacteristic$VH.get(seg);
    }

    public static void GetOutputCharacteristic$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.GetOutputCharacteristic$VH.set(seg, x);
    }

    public static MemoryAddress GetOutputCharacteristic$get(MemorySegment seg, long index) {
        return (jdk.incubator.foreign.MemoryAddress)
                OrtCustomOp.GetOutputCharacteristic$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetOutputCharacteristic$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.GetOutputCharacteristic$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetOutputCharacteristic GetOutputCharacteristic(MemorySegment segment) {
        return GetOutputCharacteristic.ofAddress(GetOutputCharacteristic$get(segment));
    }

    public static long sizeof() {
        return $LAYOUT().byteSize();
    }

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate($LAYOUT());
    }

    public static MemorySegment allocate(ResourceScope scope) {
        return allocate(SegmentAllocator.ofScope(scope));
    }

    public static MemorySegment allocateArray(int len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }

    public static MemorySegment allocateArray(int len, ResourceScope scope) {
        return allocateArray(len, SegmentAllocator.ofScope(scope));
    }

    public static MemorySegment ofAddress(MemoryAddress addr, ResourceScope scope) {
        return RuntimeHelper.asArray(addr, $LAYOUT(), 1, scope);
    }
}
