/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

public class OrtCustomOp {

    static final GroupLayout $struct$LAYOUT = MemoryLayout.structLayout(
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
                    Constants$root.C_POINTER$LAYOUT.withName("GetOutputCharacteristic"))
            .withName("OrtCustomOp");

    public static MemoryLayout $LAYOUT() {
        return OrtCustomOp.$struct$LAYOUT;
    }

    static final VarHandle version$VH = $struct$LAYOUT.varHandle(MemoryLayout.PathElement.groupElement("version"));

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

    static final FunctionDescriptor CreateKernel$FUNC = FunctionDescriptor.of(
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT,
            Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle CreateKernel$MH = RuntimeHelper.downcallHandle(OrtCustomOp.CreateKernel$FUNC);

    public interface CreateKernel {

        java.lang.foreign.Addressable apply(
                java.lang.foreign.MemoryAddress _x0,
                java.lang.foreign.MemoryAddress _x1,
                java.lang.foreign.MemoryAddress _x2);

        static MemorySegment allocate(CreateKernel fi, MemorySession session) {
            return RuntimeHelper.upcallStub(CreateKernel.class, fi, OrtCustomOp.CreateKernel$FUNC, session);
        }

        static CreateKernel ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0,
                    java.lang.foreign.MemoryAddress __x1,
                    java.lang.foreign.MemoryAddress __x2) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtCustomOp.CreateKernel$MH.invokeExact(
                                    (Addressable) symbol,
                                    (java.lang.foreign.Addressable) __x0,
                                    (java.lang.foreign.Addressable) __x1,
                                    (java.lang.foreign.Addressable) __x2);
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

    public static MemoryAddress CreateKernel$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.CreateKernel$VH.get(seg);
    }

    public static void CreateKernel$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.CreateKernel$VH.set(seg, x);
    }

    public static MemoryAddress CreateKernel$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.CreateKernel$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void CreateKernel$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.CreateKernel$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static CreateKernel CreateKernel(MemorySegment segment, MemorySession session) {
        return CreateKernel.ofAddress(CreateKernel$get(segment), session);
    }

    static final FunctionDescriptor GetName$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetName$MH = RuntimeHelper.downcallHandle(OrtCustomOp.GetName$FUNC);

    public interface GetName {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(GetName fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetName.class, fi, OrtCustomOp.GetName$FUNC, session);
        }

        static GetName ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtCustomOp.GetName$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
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

    public static MemoryAddress GetName$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.GetName$VH.get(seg);
    }

    public static void GetName$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.GetName$VH.set(seg, x);
    }

    public static MemoryAddress GetName$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.GetName$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetName$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.GetName$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetName GetName(MemorySegment segment, MemorySession session) {
        return GetName.ofAddress(GetName$get(segment), session);
    }

    static final FunctionDescriptor GetExecutionProviderType$FUNC =
            FunctionDescriptor.of(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetExecutionProviderType$MH =
            RuntimeHelper.downcallHandle(OrtCustomOp.GetExecutionProviderType$FUNC);

    public interface GetExecutionProviderType {

        java.lang.foreign.Addressable apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(GetExecutionProviderType fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetExecutionProviderType.class, fi, OrtCustomOp.GetExecutionProviderType$FUNC, session);
        }

        static GetExecutionProviderType ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (java.lang.foreign.Addressable)
                            (java.lang.foreign.MemoryAddress) OrtCustomOp.GetExecutionProviderType$MH.invokeExact(
                                    (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
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

    public static MemoryAddress GetExecutionProviderType$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.GetExecutionProviderType$VH.get(seg);
    }

    public static void GetExecutionProviderType$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.GetExecutionProviderType$VH.set(seg, x);
    }

    public static MemoryAddress GetExecutionProviderType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtCustomOp.GetExecutionProviderType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetExecutionProviderType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.GetExecutionProviderType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetExecutionProviderType GetExecutionProviderType(MemorySegment segment, MemorySession session) {
        return GetExecutionProviderType.ofAddress(GetExecutionProviderType$get(segment), session);
    }

    static final FunctionDescriptor GetInputType$FUNC = FunctionDescriptor.of(
            Constants$root.C_INT$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle GetInputType$MH = RuntimeHelper.downcallHandle(OrtCustomOp.GetInputType$FUNC);

    public interface GetInputType {

        int apply(java.lang.foreign.MemoryAddress _x0, long _x1);

        static MemorySegment allocate(GetInputType fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetInputType.class, fi, OrtCustomOp.GetInputType$FUNC, session);
        }

        static GetInputType ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, long __x1) -> {
                try {
                    return (int) OrtCustomOp.GetInputType$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
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

    public static MemoryAddress GetInputType$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.GetInputType$VH.get(seg);
    }

    public static void GetInputType$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.GetInputType$VH.set(seg, x);
    }

    public static MemoryAddress GetInputType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.GetInputType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetInputType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.GetInputType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetInputType GetInputType(MemorySegment segment, MemorySession session) {
        return GetInputType.ofAddress(GetInputType$get(segment), session);
    }

    static final FunctionDescriptor GetInputTypeCount$FUNC =
            FunctionDescriptor.of(Constants$root.C_LONG_LONG$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetInputTypeCount$MH = RuntimeHelper.downcallHandle(OrtCustomOp.GetInputTypeCount$FUNC);

    public interface GetInputTypeCount {

        long apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(GetInputTypeCount fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetInputTypeCount.class, fi, OrtCustomOp.GetInputTypeCount$FUNC, session);
        }

        static GetInputTypeCount ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (long) OrtCustomOp.GetInputTypeCount$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
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

    public static MemoryAddress GetInputTypeCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.GetInputTypeCount$VH.get(seg);
    }

    public static void GetInputTypeCount$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.GetInputTypeCount$VH.set(seg, x);
    }

    public static MemoryAddress GetInputTypeCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.GetInputTypeCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetInputTypeCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.GetInputTypeCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetInputTypeCount GetInputTypeCount(MemorySegment segment, MemorySession session) {
        return GetInputTypeCount.ofAddress(GetInputTypeCount$get(segment), session);
    }

    static final FunctionDescriptor GetOutputType$FUNC = FunctionDescriptor.of(
            Constants$root.C_INT$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle GetOutputType$MH = RuntimeHelper.downcallHandle(OrtCustomOp.GetOutputType$FUNC);

    public interface GetOutputType {

        int apply(java.lang.foreign.MemoryAddress _x0, long _x1);

        static MemorySegment allocate(GetOutputType fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetOutputType.class, fi, OrtCustomOp.GetOutputType$FUNC, session);
        }

        static GetOutputType ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, long __x1) -> {
                try {
                    return (int) OrtCustomOp.GetOutputType$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
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

    public static MemoryAddress GetOutputType$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.GetOutputType$VH.get(seg);
    }

    public static void GetOutputType$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.GetOutputType$VH.set(seg, x);
    }

    public static MemoryAddress GetOutputType$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.GetOutputType$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetOutputType$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.GetOutputType$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetOutputType GetOutputType(MemorySegment segment, MemorySession session) {
        return GetOutputType.ofAddress(GetOutputType$get(segment), session);
    }

    static final FunctionDescriptor GetOutputTypeCount$FUNC =
            FunctionDescriptor.of(Constants$root.C_LONG_LONG$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle GetOutputTypeCount$MH = RuntimeHelper.downcallHandle(OrtCustomOp.GetOutputTypeCount$FUNC);

    public interface GetOutputTypeCount {

        long apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(GetOutputTypeCount fi, MemorySession session) {
            return RuntimeHelper.upcallStub(GetOutputTypeCount.class, fi, OrtCustomOp.GetOutputTypeCount$FUNC, session);
        }

        static GetOutputTypeCount ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    return (long) OrtCustomOp.GetOutputTypeCount$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
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

    public static MemoryAddress GetOutputTypeCount$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.GetOutputTypeCount$VH.get(seg);
    }

    public static void GetOutputTypeCount$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.GetOutputTypeCount$VH.set(seg, x);
    }

    public static MemoryAddress GetOutputTypeCount$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.GetOutputTypeCount$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetOutputTypeCount$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.GetOutputTypeCount$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetOutputTypeCount GetOutputTypeCount(MemorySegment segment, MemorySession session) {
        return GetOutputTypeCount.ofAddress(GetOutputTypeCount$get(segment), session);
    }

    static final FunctionDescriptor KernelCompute$FUNC =
            FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT, Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelCompute$MH = RuntimeHelper.downcallHandle(OrtCustomOp.KernelCompute$FUNC);

    public interface KernelCompute {

        void apply(java.lang.foreign.MemoryAddress _x0, java.lang.foreign.MemoryAddress _x1);

        static MemorySegment allocate(KernelCompute fi, MemorySession session) {
            return RuntimeHelper.upcallStub(KernelCompute.class, fi, OrtCustomOp.KernelCompute$FUNC, session);
        }

        static KernelCompute ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, java.lang.foreign.MemoryAddress __x1) -> {
                try {
                    OrtCustomOp.KernelCompute$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0, (java.lang.foreign.Addressable)
                                    __x1);
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

    public static MemoryAddress KernelCompute$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.KernelCompute$VH.get(seg);
    }

    public static void KernelCompute$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.KernelCompute$VH.set(seg, x);
    }

    public static MemoryAddress KernelCompute$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.KernelCompute$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelCompute$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.KernelCompute$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelCompute KernelCompute(MemorySegment segment, MemorySession session) {
        return KernelCompute.ofAddress(KernelCompute$get(segment), session);
    }

    static final FunctionDescriptor KernelDestroy$FUNC = FunctionDescriptor.ofVoid(Constants$root.C_POINTER$LAYOUT);
    static final MethodHandle KernelDestroy$MH = RuntimeHelper.downcallHandle(OrtCustomOp.KernelDestroy$FUNC);

    public interface KernelDestroy {

        void apply(java.lang.foreign.MemoryAddress _x0);

        static MemorySegment allocate(KernelDestroy fi, MemorySession session) {
            return RuntimeHelper.upcallStub(KernelDestroy.class, fi, OrtCustomOp.KernelDestroy$FUNC, session);
        }

        static KernelDestroy ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0) -> {
                try {
                    OrtCustomOp.KernelDestroy$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0);
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

    public static MemoryAddress KernelDestroy$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.KernelDestroy$VH.get(seg);
    }

    public static void KernelDestroy$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.KernelDestroy$VH.set(seg, x);
    }

    public static MemoryAddress KernelDestroy$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.KernelDestroy$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void KernelDestroy$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.KernelDestroy$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static KernelDestroy KernelDestroy(MemorySegment segment, MemorySession session) {
        return KernelDestroy.ofAddress(KernelDestroy$get(segment), session);
    }

    static final FunctionDescriptor GetInputCharacteristic$FUNC = FunctionDescriptor.of(
            Constants$root.C_INT$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle GetInputCharacteristic$MH =
            RuntimeHelper.downcallHandle(OrtCustomOp.GetInputCharacteristic$FUNC);

    public interface GetInputCharacteristic {

        int apply(java.lang.foreign.MemoryAddress _x0, long _x1);

        static MemorySegment allocate(GetInputCharacteristic fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetInputCharacteristic.class, fi, OrtCustomOp.GetInputCharacteristic$FUNC, session);
        }

        static GetInputCharacteristic ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, long __x1) -> {
                try {
                    return (int) OrtCustomOp.GetInputCharacteristic$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
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

    public static MemoryAddress GetInputCharacteristic$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.GetInputCharacteristic$VH.get(seg);
    }

    public static void GetInputCharacteristic$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.GetInputCharacteristic$VH.set(seg, x);
    }

    public static MemoryAddress GetInputCharacteristic$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtCustomOp.GetInputCharacteristic$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetInputCharacteristic$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.GetInputCharacteristic$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetInputCharacteristic GetInputCharacteristic(MemorySegment segment, MemorySession session) {
        return GetInputCharacteristic.ofAddress(GetInputCharacteristic$get(segment), session);
    }

    static final FunctionDescriptor GetOutputCharacteristic$FUNC = FunctionDescriptor.of(
            Constants$root.C_INT$LAYOUT, Constants$root.C_POINTER$LAYOUT, Constants$root.C_LONG_LONG$LAYOUT);
    static final MethodHandle GetOutputCharacteristic$MH =
            RuntimeHelper.downcallHandle(OrtCustomOp.GetOutputCharacteristic$FUNC);

    public interface GetOutputCharacteristic {

        int apply(java.lang.foreign.MemoryAddress _x0, long _x1);

        static MemorySegment allocate(GetOutputCharacteristic fi, MemorySession session) {
            return RuntimeHelper.upcallStub(
                    GetOutputCharacteristic.class, fi, OrtCustomOp.GetOutputCharacteristic$FUNC, session);
        }

        static GetOutputCharacteristic ofAddress(MemoryAddress addr, MemorySession session) {
            MemorySegment symbol = MemorySegment.ofAddress(addr, 0, session);
            return (java.lang.foreign.MemoryAddress __x0, long __x1) -> {
                try {
                    return (int) OrtCustomOp.GetOutputCharacteristic$MH.invokeExact(
                            (Addressable) symbol, (java.lang.foreign.Addressable) __x0, __x1);
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

    public static MemoryAddress GetOutputCharacteristic$get(MemorySegment seg) {
        return (java.lang.foreign.MemoryAddress) OrtCustomOp.GetOutputCharacteristic$VH.get(seg);
    }

    public static void GetOutputCharacteristic$set(MemorySegment seg, MemoryAddress x) {
        OrtCustomOp.GetOutputCharacteristic$VH.set(seg, x);
    }

    public static MemoryAddress GetOutputCharacteristic$get(MemorySegment seg, long index) {
        return (java.lang.foreign.MemoryAddress)
                OrtCustomOp.GetOutputCharacteristic$VH.get(seg.asSlice(index * sizeof()));
    }

    public static void GetOutputCharacteristic$set(MemorySegment seg, long index, MemoryAddress x) {
        OrtCustomOp.GetOutputCharacteristic$VH.set(seg.asSlice(index * sizeof()), x);
    }

    public static GetOutputCharacteristic GetOutputCharacteristic(MemorySegment segment, MemorySession session) {
        return GetOutputCharacteristic.ofAddress(GetOutputCharacteristic$get(segment), session);
    }

    public static long sizeof() {
        return $LAYOUT().byteSize();
    }

    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate($LAYOUT());
    }

    public static MemorySegment allocateArray(int len, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(len, $LAYOUT()));
    }

    public static MemorySegment ofAddress(MemoryAddress addr, MemorySession session) {
        return RuntimeHelper.asArray(addr, $LAYOUT(), 1, session);
    }
}
