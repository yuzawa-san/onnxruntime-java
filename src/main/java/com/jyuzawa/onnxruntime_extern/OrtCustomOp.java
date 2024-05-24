/*
 * Copyright (c) 2024 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime_extern;

import static java.lang.foreign.MemoryLayout.PathElement.*;
import static java.lang.foreign.ValueLayout.*;

import java.lang.foreign.*;
import java.lang.invoke.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * {@snippet lang=c :
 * struct OrtCustomOp {
 *     uint32_t version;
 *     void *(*CreateKernel)(const struct OrtCustomOp *, const OrtApi *, const OrtKernelInfo *);
 *     const char *(*GetName)(const struct OrtCustomOp *);
 *     const char *(*GetExecutionProviderType)(const struct OrtCustomOp *);
 *     ONNXTensorElementDataType (*GetInputType)(const struct OrtCustomOp *, size_t);
 *     size_t (*GetInputTypeCount)(const struct OrtCustomOp *);
 *     ONNXTensorElementDataType (*GetOutputType)(const struct OrtCustomOp *, size_t);
 *     size_t (*GetOutputTypeCount)(const struct OrtCustomOp *);
 *     void (*KernelCompute)(void *, OrtKernelContext *);
 *     void (*KernelDestroy)(void *);
 *     OrtCustomOpInputOutputCharacteristic (*GetInputCharacteristic)(const struct OrtCustomOp *, size_t);
 *     OrtCustomOpInputOutputCharacteristic (*GetOutputCharacteristic)(const struct OrtCustomOp *, size_t);
 *     OrtMemType (*GetInputMemoryType)(const struct OrtCustomOp *, size_t);
 *     int (*GetVariadicInputMinArity)(const struct OrtCustomOp *);
 *     int (*GetVariadicInputHomogeneity)(const struct OrtCustomOp *);
 *     int (*GetVariadicOutputMinArity)(const struct OrtCustomOp *);
 *     int (*GetVariadicOutputHomogeneity)(const struct OrtCustomOp *);
 *     OrtStatusPtr (*CreateKernelV2)(const struct OrtCustomOp *, const OrtApi *, const OrtKernelInfo *, void **);
 *     OrtStatusPtr (*KernelComputeV2)(void *, OrtKernelContext *);
 *     OrtStatusPtr (*InferOutputShapeFn)(const struct OrtCustomOp *, OrtShapeInferContext *);
 *     int (*GetStartVersion)(const struct OrtCustomOp *);
 *     int (*GetEndVersion)(const struct OrtCustomOp *);
 *     size_t (*GetMayInplace)(int **, int **);
 *     void (*ReleaseMayInplace)(int *, int *);
 *     size_t (*GetAliasMap)(int **, int **);
 *     void (*ReleaseAliasMap)(int *, int *);
 * }
 * }
 */
public class OrtCustomOp {

    OrtCustomOp() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
                    onnxruntime_all_h.C_INT.withName("version"),
                    MemoryLayout.paddingLayout(4),
                    onnxruntime_all_h.C_POINTER.withName("CreateKernel"),
                    onnxruntime_all_h.C_POINTER.withName("GetName"),
                    onnxruntime_all_h.C_POINTER.withName("GetExecutionProviderType"),
                    onnxruntime_all_h.C_POINTER.withName("GetInputType"),
                    onnxruntime_all_h.C_POINTER.withName("GetInputTypeCount"),
                    onnxruntime_all_h.C_POINTER.withName("GetOutputType"),
                    onnxruntime_all_h.C_POINTER.withName("GetOutputTypeCount"),
                    onnxruntime_all_h.C_POINTER.withName("KernelCompute"),
                    onnxruntime_all_h.C_POINTER.withName("KernelDestroy"),
                    onnxruntime_all_h.C_POINTER.withName("GetInputCharacteristic"),
                    onnxruntime_all_h.C_POINTER.withName("GetOutputCharacteristic"),
                    onnxruntime_all_h.C_POINTER.withName("GetInputMemoryType"),
                    onnxruntime_all_h.C_POINTER.withName("GetVariadicInputMinArity"),
                    onnxruntime_all_h.C_POINTER.withName("GetVariadicInputHomogeneity"),
                    onnxruntime_all_h.C_POINTER.withName("GetVariadicOutputMinArity"),
                    onnxruntime_all_h.C_POINTER.withName("GetVariadicOutputHomogeneity"),
                    onnxruntime_all_h.C_POINTER.withName("CreateKernelV2"),
                    onnxruntime_all_h.C_POINTER.withName("KernelComputeV2"),
                    onnxruntime_all_h.C_POINTER.withName("InferOutputShapeFn"),
                    onnxruntime_all_h.C_POINTER.withName("GetStartVersion"),
                    onnxruntime_all_h.C_POINTER.withName("GetEndVersion"),
                    onnxruntime_all_h.C_POINTER.withName("GetMayInplace"),
                    onnxruntime_all_h.C_POINTER.withName("ReleaseMayInplace"),
                    onnxruntime_all_h.C_POINTER.withName("GetAliasMap"),
                    onnxruntime_all_h.C_POINTER.withName("ReleaseAliasMap"))
            .withName("OrtCustomOp");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final OfInt version$LAYOUT = (OfInt) $LAYOUT.select(groupElement("version"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * uint32_t version
     * }
     */
    public static final OfInt version$layout() {
        return version$LAYOUT;
    }

    private static final long version$OFFSET = 0;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * uint32_t version
     * }
     */
    public static final long version$offset() {
        return version$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * uint32_t version
     * }
     */
    public static int version(MemorySegment struct) {
        return struct.get(version$LAYOUT, version$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * uint32_t version
     * }
     */
    public static void version(MemorySegment struct, int fieldValue) {
        struct.set(version$LAYOUT, version$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * void *(*CreateKernel)(const struct OrtCustomOp *, const OrtApi *, const OrtKernelInfo *)
     * }
     */
    public static class CreateKernel {

        CreateKernel() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            MemorySegment apply(MemorySegment _x0, MemorySegment _x1, MemorySegment _x2);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(CreateKernel.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(CreateKernel.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(
                MemorySegment funcPtr, MemorySegment _x0, MemorySegment _x1, MemorySegment _x2) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0, _x1, _x2);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static CreateKernel.Function function(MemorySegment funcPtr) {
            return (_x0, _x1, _x2) -> invoke(funcPtr, _x0, _x1, _x2);
        }
    }

    private static final AddressLayout CreateKernel$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("CreateKernel"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * void *(*CreateKernel)(const struct OrtCustomOp *, const OrtApi *, const OrtKernelInfo *)
     * }
     */
    public static final AddressLayout CreateKernel$layout() {
        return CreateKernel$LAYOUT;
    }

    private static final long CreateKernel$OFFSET = 8;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * void *(*CreateKernel)(const struct OrtCustomOp *, const OrtApi *, const OrtKernelInfo *)
     * }
     */
    public static final long CreateKernel$offset() {
        return CreateKernel$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * void *(*CreateKernel)(const struct OrtCustomOp *, const OrtApi *, const OrtKernelInfo *)
     * }
     */
    public static MemorySegment CreateKernel(MemorySegment struct) {
        return struct.get(CreateKernel$LAYOUT, CreateKernel$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * void *(*CreateKernel)(const struct OrtCustomOp *, const OrtApi *, const OrtKernelInfo *)
     * }
     */
    public static void CreateKernel(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(CreateKernel$LAYOUT, CreateKernel$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * void *(*CreateKernel)(const struct OrtCustomOp *, const OrtApi *, const OrtKernelInfo *)
     * }
     */
    public static CreateKernel.Function CreateKernelFunction(MemorySegment struct) {
        return CreateKernel.function(CreateKernel(struct));
    }

    /**
     * {@snippet lang=c :
     * const char *(*GetName)(const struct OrtCustomOp *)
     * }
     */
    public static class GetName {

        GetName() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            MemorySegment apply(MemorySegment _x0);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.of(onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetName.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetName.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetName.Function function(MemorySegment funcPtr) {
            return (_x0) -> invoke(funcPtr, _x0);
        }
    }

    private static final AddressLayout GetName$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("GetName"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * const char *(*GetName)(const struct OrtCustomOp *)
     * }
     */
    public static final AddressLayout GetName$layout() {
        return GetName$LAYOUT;
    }

    private static final long GetName$OFFSET = 16;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * const char *(*GetName)(const struct OrtCustomOp *)
     * }
     */
    public static final long GetName$offset() {
        return GetName$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * const char *(*GetName)(const struct OrtCustomOp *)
     * }
     */
    public static MemorySegment GetName(MemorySegment struct) {
        return struct.get(GetName$LAYOUT, GetName$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * const char *(*GetName)(const struct OrtCustomOp *)
     * }
     */
    public static void GetName(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetName$LAYOUT, GetName$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * const char *(*GetName)(const struct OrtCustomOp *)
     * }
     */
    public static GetName.Function GetNameFunction(MemorySegment struct) {
        return GetName.function(GetName(struct));
    }

    /**
     * {@snippet lang=c :
     * const char *(*GetExecutionProviderType)(const struct OrtCustomOp *)
     * }
     */
    public static class GetExecutionProviderType {

        GetExecutionProviderType() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            MemorySegment apply(MemorySegment _x0);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.of(onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetExecutionProviderType.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetExecutionProviderType.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetExecutionProviderType.Function function(MemorySegment funcPtr) {
            return (_x0) -> invoke(funcPtr, _x0);
        }
    }

    private static final AddressLayout GetExecutionProviderType$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetExecutionProviderType"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * const char *(*GetExecutionProviderType)(const struct OrtCustomOp *)
     * }
     */
    public static final AddressLayout GetExecutionProviderType$layout() {
        return GetExecutionProviderType$LAYOUT;
    }

    private static final long GetExecutionProviderType$OFFSET = 24;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * const char *(*GetExecutionProviderType)(const struct OrtCustomOp *)
     * }
     */
    public static final long GetExecutionProviderType$offset() {
        return GetExecutionProviderType$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * const char *(*GetExecutionProviderType)(const struct OrtCustomOp *)
     * }
     */
    public static MemorySegment GetExecutionProviderType(MemorySegment struct) {
        return struct.get(GetExecutionProviderType$LAYOUT, GetExecutionProviderType$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * const char *(*GetExecutionProviderType)(const struct OrtCustomOp *)
     * }
     */
    public static void GetExecutionProviderType(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetExecutionProviderType$LAYOUT, GetExecutionProviderType$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * const char *(*GetExecutionProviderType)(const struct OrtCustomOp *)
     * }
     */
    public static GetExecutionProviderType.Function GetExecutionProviderTypeFunction(MemorySegment struct) {
        return GetExecutionProviderType.function(GetExecutionProviderType(struct));
    }

    /**
     * {@snippet lang=c :
     * ONNXTensorElementDataType (*GetInputType)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static class GetInputType {

        GetInputType() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            int apply(MemorySegment _x0, long _x1);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.of(onnxruntime_all_h.C_INT, onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_LONG);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetInputType.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetInputType.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static int invoke(MemorySegment funcPtr, MemorySegment _x0, long _x1) {
            try {
                return (int) DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetInputType.Function function(MemorySegment funcPtr) {
            return (_x0, _x1) -> invoke(funcPtr, _x0, _x1);
        }
    }

    private static final AddressLayout GetInputType$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetInputType"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * ONNXTensorElementDataType (*GetInputType)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static final AddressLayout GetInputType$layout() {
        return GetInputType$LAYOUT;
    }

    private static final long GetInputType$OFFSET = 32;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * ONNXTensorElementDataType (*GetInputType)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static final long GetInputType$offset() {
        return GetInputType$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * ONNXTensorElementDataType (*GetInputType)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static MemorySegment GetInputType(MemorySegment struct) {
        return struct.get(GetInputType$LAYOUT, GetInputType$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * ONNXTensorElementDataType (*GetInputType)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static void GetInputType(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetInputType$LAYOUT, GetInputType$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * ONNXTensorElementDataType (*GetInputType)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static GetInputType.Function GetInputTypeFunction(MemorySegment struct) {
        return GetInputType.function(GetInputType(struct));
    }

    /**
     * {@snippet lang=c :
     * size_t (*GetInputTypeCount)(const struct OrtCustomOp *)
     * }
     */
    public static class GetInputTypeCount {

        GetInputTypeCount() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            long apply(MemorySegment _x0);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.of(onnxruntime_all_h.C_LONG, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetInputTypeCount.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetInputTypeCount.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static long invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                return (long) DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetInputTypeCount.Function function(MemorySegment funcPtr) {
            return (_x0) -> invoke(funcPtr, _x0);
        }
    }

    private static final AddressLayout GetInputTypeCount$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetInputTypeCount"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * size_t (*GetInputTypeCount)(const struct OrtCustomOp *)
     * }
     */
    public static final AddressLayout GetInputTypeCount$layout() {
        return GetInputTypeCount$LAYOUT;
    }

    private static final long GetInputTypeCount$OFFSET = 40;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * size_t (*GetInputTypeCount)(const struct OrtCustomOp *)
     * }
     */
    public static final long GetInputTypeCount$offset() {
        return GetInputTypeCount$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * size_t (*GetInputTypeCount)(const struct OrtCustomOp *)
     * }
     */
    public static MemorySegment GetInputTypeCount(MemorySegment struct) {
        return struct.get(GetInputTypeCount$LAYOUT, GetInputTypeCount$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * size_t (*GetInputTypeCount)(const struct OrtCustomOp *)
     * }
     */
    public static void GetInputTypeCount(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetInputTypeCount$LAYOUT, GetInputTypeCount$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * size_t (*GetInputTypeCount)(const struct OrtCustomOp *)
     * }
     */
    public static GetInputTypeCount.Function GetInputTypeCountFunction(MemorySegment struct) {
        return GetInputTypeCount.function(GetInputTypeCount(struct));
    }

    /**
     * {@snippet lang=c :
     * ONNXTensorElementDataType (*GetOutputType)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static class GetOutputType {

        GetOutputType() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            int apply(MemorySegment _x0, long _x1);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.of(onnxruntime_all_h.C_INT, onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_LONG);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetOutputType.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetOutputType.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static int invoke(MemorySegment funcPtr, MemorySegment _x0, long _x1) {
            try {
                return (int) DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetOutputType.Function function(MemorySegment funcPtr) {
            return (_x0, _x1) -> invoke(funcPtr, _x0, _x1);
        }
    }

    private static final AddressLayout GetOutputType$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetOutputType"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * ONNXTensorElementDataType (*GetOutputType)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static final AddressLayout GetOutputType$layout() {
        return GetOutputType$LAYOUT;
    }

    private static final long GetOutputType$OFFSET = 48;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * ONNXTensorElementDataType (*GetOutputType)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static final long GetOutputType$offset() {
        return GetOutputType$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * ONNXTensorElementDataType (*GetOutputType)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static MemorySegment GetOutputType(MemorySegment struct) {
        return struct.get(GetOutputType$LAYOUT, GetOutputType$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * ONNXTensorElementDataType (*GetOutputType)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static void GetOutputType(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetOutputType$LAYOUT, GetOutputType$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * ONNXTensorElementDataType (*GetOutputType)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static GetOutputType.Function GetOutputTypeFunction(MemorySegment struct) {
        return GetOutputType.function(GetOutputType(struct));
    }

    /**
     * {@snippet lang=c :
     * size_t (*GetOutputTypeCount)(const struct OrtCustomOp *)
     * }
     */
    public static class GetOutputTypeCount {

        GetOutputTypeCount() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            long apply(MemorySegment _x0);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.of(onnxruntime_all_h.C_LONG, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetOutputTypeCount.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetOutputTypeCount.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static long invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                return (long) DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetOutputTypeCount.Function function(MemorySegment funcPtr) {
            return (_x0) -> invoke(funcPtr, _x0);
        }
    }

    private static final AddressLayout GetOutputTypeCount$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetOutputTypeCount"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * size_t (*GetOutputTypeCount)(const struct OrtCustomOp *)
     * }
     */
    public static final AddressLayout GetOutputTypeCount$layout() {
        return GetOutputTypeCount$LAYOUT;
    }

    private static final long GetOutputTypeCount$OFFSET = 56;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * size_t (*GetOutputTypeCount)(const struct OrtCustomOp *)
     * }
     */
    public static final long GetOutputTypeCount$offset() {
        return GetOutputTypeCount$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * size_t (*GetOutputTypeCount)(const struct OrtCustomOp *)
     * }
     */
    public static MemorySegment GetOutputTypeCount(MemorySegment struct) {
        return struct.get(GetOutputTypeCount$LAYOUT, GetOutputTypeCount$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * size_t (*GetOutputTypeCount)(const struct OrtCustomOp *)
     * }
     */
    public static void GetOutputTypeCount(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetOutputTypeCount$LAYOUT, GetOutputTypeCount$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * size_t (*GetOutputTypeCount)(const struct OrtCustomOp *)
     * }
     */
    public static GetOutputTypeCount.Function GetOutputTypeCountFunction(MemorySegment struct) {
        return GetOutputTypeCount.function(GetOutputTypeCount(struct));
    }

    /**
     * {@snippet lang=c :
     * void (*KernelCompute)(void *, OrtKernelContext *)
     * }
     */
    public static class KernelCompute {

        KernelCompute() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            void apply(MemorySegment _x0, MemorySegment _x1);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.ofVoid(onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(KernelCompute.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(KernelCompute.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static void invoke(MemorySegment funcPtr, MemorySegment _x0, MemorySegment _x1) {
            try {
                DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static KernelCompute.Function function(MemorySegment funcPtr) {
            return (_x0, _x1) -> invoke(funcPtr, _x0, _x1);
        }
    }

    private static final AddressLayout KernelCompute$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("KernelCompute"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * void (*KernelCompute)(void *, OrtKernelContext *)
     * }
     */
    public static final AddressLayout KernelCompute$layout() {
        return KernelCompute$LAYOUT;
    }

    private static final long KernelCompute$OFFSET = 64;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * void (*KernelCompute)(void *, OrtKernelContext *)
     * }
     */
    public static final long KernelCompute$offset() {
        return KernelCompute$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * void (*KernelCompute)(void *, OrtKernelContext *)
     * }
     */
    public static MemorySegment KernelCompute(MemorySegment struct) {
        return struct.get(KernelCompute$LAYOUT, KernelCompute$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * void (*KernelCompute)(void *, OrtKernelContext *)
     * }
     */
    public static void KernelCompute(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(KernelCompute$LAYOUT, KernelCompute$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * void (*KernelCompute)(void *, OrtKernelContext *)
     * }
     */
    public static KernelCompute.Function KernelComputeFunction(MemorySegment struct) {
        return KernelCompute.function(KernelCompute(struct));
    }

    /**
     * {@snippet lang=c :
     * void (*KernelDestroy)(void *)
     * }
     */
    public static class KernelDestroy {

        KernelDestroy() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            void apply(MemorySegment _x0);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.ofVoid(onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(KernelDestroy.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(KernelDestroy.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static void invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static KernelDestroy.Function function(MemorySegment funcPtr) {
            return (_x0) -> invoke(funcPtr, _x0);
        }
    }

    private static final AddressLayout KernelDestroy$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("KernelDestroy"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * void (*KernelDestroy)(void *)
     * }
     */
    public static final AddressLayout KernelDestroy$layout() {
        return KernelDestroy$LAYOUT;
    }

    private static final long KernelDestroy$OFFSET = 72;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * void (*KernelDestroy)(void *)
     * }
     */
    public static final long KernelDestroy$offset() {
        return KernelDestroy$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * void (*KernelDestroy)(void *)
     * }
     */
    public static MemorySegment KernelDestroy(MemorySegment struct) {
        return struct.get(KernelDestroy$LAYOUT, KernelDestroy$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * void (*KernelDestroy)(void *)
     * }
     */
    public static void KernelDestroy(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(KernelDestroy$LAYOUT, KernelDestroy$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * void (*KernelDestroy)(void *)
     * }
     */
    public static KernelDestroy.Function KernelDestroyFunction(MemorySegment struct) {
        return KernelDestroy.function(KernelDestroy(struct));
    }

    /**
     * {@snippet lang=c :
     * OrtCustomOpInputOutputCharacteristic (*GetInputCharacteristic)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static class GetInputCharacteristic {

        GetInputCharacteristic() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            int apply(MemorySegment _x0, long _x1);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.of(onnxruntime_all_h.C_INT, onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_LONG);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetInputCharacteristic.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetInputCharacteristic.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static int invoke(MemorySegment funcPtr, MemorySegment _x0, long _x1) {
            try {
                return (int) DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetInputCharacteristic.Function function(MemorySegment funcPtr) {
            return (_x0, _x1) -> invoke(funcPtr, _x0, _x1);
        }
    }

    private static final AddressLayout GetInputCharacteristic$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetInputCharacteristic"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtCustomOpInputOutputCharacteristic (*GetInputCharacteristic)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static final AddressLayout GetInputCharacteristic$layout() {
        return GetInputCharacteristic$LAYOUT;
    }

    private static final long GetInputCharacteristic$OFFSET = 80;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtCustomOpInputOutputCharacteristic (*GetInputCharacteristic)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static final long GetInputCharacteristic$offset() {
        return GetInputCharacteristic$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtCustomOpInputOutputCharacteristic (*GetInputCharacteristic)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static MemorySegment GetInputCharacteristic(MemorySegment struct) {
        return struct.get(GetInputCharacteristic$LAYOUT, GetInputCharacteristic$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtCustomOpInputOutputCharacteristic (*GetInputCharacteristic)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static void GetInputCharacteristic(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetInputCharacteristic$LAYOUT, GetInputCharacteristic$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * OrtCustomOpInputOutputCharacteristic (*GetInputCharacteristic)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static GetInputCharacteristic.Function GetInputCharacteristicFunction(MemorySegment struct) {
        return GetInputCharacteristic.function(GetInputCharacteristic(struct));
    }

    /**
     * {@snippet lang=c :
     * OrtCustomOpInputOutputCharacteristic (*GetOutputCharacteristic)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static class GetOutputCharacteristic {

        GetOutputCharacteristic() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            int apply(MemorySegment _x0, long _x1);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.of(onnxruntime_all_h.C_INT, onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_LONG);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetOutputCharacteristic.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetOutputCharacteristic.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static int invoke(MemorySegment funcPtr, MemorySegment _x0, long _x1) {
            try {
                return (int) DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetOutputCharacteristic.Function function(MemorySegment funcPtr) {
            return (_x0, _x1) -> invoke(funcPtr, _x0, _x1);
        }
    }

    private static final AddressLayout GetOutputCharacteristic$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetOutputCharacteristic"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtCustomOpInputOutputCharacteristic (*GetOutputCharacteristic)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static final AddressLayout GetOutputCharacteristic$layout() {
        return GetOutputCharacteristic$LAYOUT;
    }

    private static final long GetOutputCharacteristic$OFFSET = 88;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtCustomOpInputOutputCharacteristic (*GetOutputCharacteristic)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static final long GetOutputCharacteristic$offset() {
        return GetOutputCharacteristic$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtCustomOpInputOutputCharacteristic (*GetOutputCharacteristic)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static MemorySegment GetOutputCharacteristic(MemorySegment struct) {
        return struct.get(GetOutputCharacteristic$LAYOUT, GetOutputCharacteristic$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtCustomOpInputOutputCharacteristic (*GetOutputCharacteristic)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static void GetOutputCharacteristic(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetOutputCharacteristic$LAYOUT, GetOutputCharacteristic$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * OrtCustomOpInputOutputCharacteristic (*GetOutputCharacteristic)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static GetOutputCharacteristic.Function GetOutputCharacteristicFunction(MemorySegment struct) {
        return GetOutputCharacteristic.function(GetOutputCharacteristic(struct));
    }

    /**
     * {@snippet lang=c :
     * OrtMemType (*GetInputMemoryType)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static class GetInputMemoryType {

        GetInputMemoryType() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            int apply(MemorySegment _x0, long _x1);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.of(onnxruntime_all_h.C_INT, onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_LONG);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetInputMemoryType.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetInputMemoryType.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static int invoke(MemorySegment funcPtr, MemorySegment _x0, long _x1) {
            try {
                return (int) DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetInputMemoryType.Function function(MemorySegment funcPtr) {
            return (_x0, _x1) -> invoke(funcPtr, _x0, _x1);
        }
    }

    private static final AddressLayout GetInputMemoryType$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetInputMemoryType"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtMemType (*GetInputMemoryType)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static final AddressLayout GetInputMemoryType$layout() {
        return GetInputMemoryType$LAYOUT;
    }

    private static final long GetInputMemoryType$OFFSET = 96;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtMemType (*GetInputMemoryType)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static final long GetInputMemoryType$offset() {
        return GetInputMemoryType$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtMemType (*GetInputMemoryType)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static MemorySegment GetInputMemoryType(MemorySegment struct) {
        return struct.get(GetInputMemoryType$LAYOUT, GetInputMemoryType$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtMemType (*GetInputMemoryType)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static void GetInputMemoryType(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetInputMemoryType$LAYOUT, GetInputMemoryType$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * OrtMemType (*GetInputMemoryType)(const struct OrtCustomOp *, size_t)
     * }
     */
    public static GetInputMemoryType.Function GetInputMemoryTypeFunction(MemorySegment struct) {
        return GetInputMemoryType.function(GetInputMemoryType(struct));
    }

    /**
     * {@snippet lang=c :
     * int (*GetVariadicInputMinArity)(const struct OrtCustomOp *)
     * }
     */
    public static class GetVariadicInputMinArity {

        GetVariadicInputMinArity() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            int apply(MemorySegment _x0);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.of(onnxruntime_all_h.C_INT, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetVariadicInputMinArity.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetVariadicInputMinArity.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static int invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                return (int) DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetVariadicInputMinArity.Function function(MemorySegment funcPtr) {
            return (_x0) -> invoke(funcPtr, _x0);
        }
    }

    private static final AddressLayout GetVariadicInputMinArity$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetVariadicInputMinArity"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int (*GetVariadicInputMinArity)(const struct OrtCustomOp *)
     * }
     */
    public static final AddressLayout GetVariadicInputMinArity$layout() {
        return GetVariadicInputMinArity$LAYOUT;
    }

    private static final long GetVariadicInputMinArity$OFFSET = 104;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int (*GetVariadicInputMinArity)(const struct OrtCustomOp *)
     * }
     */
    public static final long GetVariadicInputMinArity$offset() {
        return GetVariadicInputMinArity$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int (*GetVariadicInputMinArity)(const struct OrtCustomOp *)
     * }
     */
    public static MemorySegment GetVariadicInputMinArity(MemorySegment struct) {
        return struct.get(GetVariadicInputMinArity$LAYOUT, GetVariadicInputMinArity$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int (*GetVariadicInputMinArity)(const struct OrtCustomOp *)
     * }
     */
    public static void GetVariadicInputMinArity(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetVariadicInputMinArity$LAYOUT, GetVariadicInputMinArity$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * int (*GetVariadicInputMinArity)(const struct OrtCustomOp *)
     * }
     */
    public static GetVariadicInputMinArity.Function GetVariadicInputMinArityFunction(MemorySegment struct) {
        return GetVariadicInputMinArity.function(GetVariadicInputMinArity(struct));
    }

    /**
     * {@snippet lang=c :
     * int (*GetVariadicInputHomogeneity)(const struct OrtCustomOp *)
     * }
     */
    public static class GetVariadicInputHomogeneity {

        GetVariadicInputHomogeneity() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            int apply(MemorySegment _x0);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.of(onnxruntime_all_h.C_INT, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetVariadicInputHomogeneity.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetVariadicInputHomogeneity.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static int invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                return (int) DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetVariadicInputHomogeneity.Function function(MemorySegment funcPtr) {
            return (_x0) -> invoke(funcPtr, _x0);
        }
    }

    private static final AddressLayout GetVariadicInputHomogeneity$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetVariadicInputHomogeneity"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int (*GetVariadicInputHomogeneity)(const struct OrtCustomOp *)
     * }
     */
    public static final AddressLayout GetVariadicInputHomogeneity$layout() {
        return GetVariadicInputHomogeneity$LAYOUT;
    }

    private static final long GetVariadicInputHomogeneity$OFFSET = 112;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int (*GetVariadicInputHomogeneity)(const struct OrtCustomOp *)
     * }
     */
    public static final long GetVariadicInputHomogeneity$offset() {
        return GetVariadicInputHomogeneity$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int (*GetVariadicInputHomogeneity)(const struct OrtCustomOp *)
     * }
     */
    public static MemorySegment GetVariadicInputHomogeneity(MemorySegment struct) {
        return struct.get(GetVariadicInputHomogeneity$LAYOUT, GetVariadicInputHomogeneity$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int (*GetVariadicInputHomogeneity)(const struct OrtCustomOp *)
     * }
     */
    public static void GetVariadicInputHomogeneity(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetVariadicInputHomogeneity$LAYOUT, GetVariadicInputHomogeneity$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * int (*GetVariadicInputHomogeneity)(const struct OrtCustomOp *)
     * }
     */
    public static GetVariadicInputHomogeneity.Function GetVariadicInputHomogeneityFunction(MemorySegment struct) {
        return GetVariadicInputHomogeneity.function(GetVariadicInputHomogeneity(struct));
    }

    /**
     * {@snippet lang=c :
     * int (*GetVariadicOutputMinArity)(const struct OrtCustomOp *)
     * }
     */
    public static class GetVariadicOutputMinArity {

        GetVariadicOutputMinArity() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            int apply(MemorySegment _x0);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.of(onnxruntime_all_h.C_INT, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetVariadicOutputMinArity.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetVariadicOutputMinArity.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static int invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                return (int) DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetVariadicOutputMinArity.Function function(MemorySegment funcPtr) {
            return (_x0) -> invoke(funcPtr, _x0);
        }
    }

    private static final AddressLayout GetVariadicOutputMinArity$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetVariadicOutputMinArity"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int (*GetVariadicOutputMinArity)(const struct OrtCustomOp *)
     * }
     */
    public static final AddressLayout GetVariadicOutputMinArity$layout() {
        return GetVariadicOutputMinArity$LAYOUT;
    }

    private static final long GetVariadicOutputMinArity$OFFSET = 120;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int (*GetVariadicOutputMinArity)(const struct OrtCustomOp *)
     * }
     */
    public static final long GetVariadicOutputMinArity$offset() {
        return GetVariadicOutputMinArity$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int (*GetVariadicOutputMinArity)(const struct OrtCustomOp *)
     * }
     */
    public static MemorySegment GetVariadicOutputMinArity(MemorySegment struct) {
        return struct.get(GetVariadicOutputMinArity$LAYOUT, GetVariadicOutputMinArity$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int (*GetVariadicOutputMinArity)(const struct OrtCustomOp *)
     * }
     */
    public static void GetVariadicOutputMinArity(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetVariadicOutputMinArity$LAYOUT, GetVariadicOutputMinArity$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * int (*GetVariadicOutputMinArity)(const struct OrtCustomOp *)
     * }
     */
    public static GetVariadicOutputMinArity.Function GetVariadicOutputMinArityFunction(MemorySegment struct) {
        return GetVariadicOutputMinArity.function(GetVariadicOutputMinArity(struct));
    }

    /**
     * {@snippet lang=c :
     * int (*GetVariadicOutputHomogeneity)(const struct OrtCustomOp *)
     * }
     */
    public static class GetVariadicOutputHomogeneity {

        GetVariadicOutputHomogeneity() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            int apply(MemorySegment _x0);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.of(onnxruntime_all_h.C_INT, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetVariadicOutputHomogeneity.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetVariadicOutputHomogeneity.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static int invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                return (int) DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetVariadicOutputHomogeneity.Function function(MemorySegment funcPtr) {
            return (_x0) -> invoke(funcPtr, _x0);
        }
    }

    private static final AddressLayout GetVariadicOutputHomogeneity$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetVariadicOutputHomogeneity"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int (*GetVariadicOutputHomogeneity)(const struct OrtCustomOp *)
     * }
     */
    public static final AddressLayout GetVariadicOutputHomogeneity$layout() {
        return GetVariadicOutputHomogeneity$LAYOUT;
    }

    private static final long GetVariadicOutputHomogeneity$OFFSET = 128;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int (*GetVariadicOutputHomogeneity)(const struct OrtCustomOp *)
     * }
     */
    public static final long GetVariadicOutputHomogeneity$offset() {
        return GetVariadicOutputHomogeneity$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int (*GetVariadicOutputHomogeneity)(const struct OrtCustomOp *)
     * }
     */
    public static MemorySegment GetVariadicOutputHomogeneity(MemorySegment struct) {
        return struct.get(GetVariadicOutputHomogeneity$LAYOUT, GetVariadicOutputHomogeneity$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int (*GetVariadicOutputHomogeneity)(const struct OrtCustomOp *)
     * }
     */
    public static void GetVariadicOutputHomogeneity(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetVariadicOutputHomogeneity$LAYOUT, GetVariadicOutputHomogeneity$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * int (*GetVariadicOutputHomogeneity)(const struct OrtCustomOp *)
     * }
     */
    public static GetVariadicOutputHomogeneity.Function GetVariadicOutputHomogeneityFunction(MemorySegment struct) {
        return GetVariadicOutputHomogeneity.function(GetVariadicOutputHomogeneity(struct));
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateKernelV2)(const struct OrtCustomOp *, const OrtApi *, const OrtKernelInfo *, void **)
     * }
     */
    public static class CreateKernelV2 {

        CreateKernelV2() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            MemorySegment apply(MemorySegment _x0, MemorySegment _x1, MemorySegment _x2, MemorySegment _x3);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(CreateKernelV2.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(CreateKernelV2.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(
                MemorySegment funcPtr, MemorySegment _x0, MemorySegment _x1, MemorySegment _x2, MemorySegment _x3) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0, _x1, _x2, _x3);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static CreateKernelV2.Function function(MemorySegment funcPtr) {
            return (_x0, _x1, _x2, _x3) -> invoke(funcPtr, _x0, _x1, _x2, _x3);
        }
    }

    private static final AddressLayout CreateKernelV2$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("CreateKernelV2"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateKernelV2)(const struct OrtCustomOp *, const OrtApi *, const OrtKernelInfo *, void **)
     * }
     */
    public static final AddressLayout CreateKernelV2$layout() {
        return CreateKernelV2$LAYOUT;
    }

    private static final long CreateKernelV2$OFFSET = 136;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateKernelV2)(const struct OrtCustomOp *, const OrtApi *, const OrtKernelInfo *, void **)
     * }
     */
    public static final long CreateKernelV2$offset() {
        return CreateKernelV2$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateKernelV2)(const struct OrtCustomOp *, const OrtApi *, const OrtKernelInfo *, void **)
     * }
     */
    public static MemorySegment CreateKernelV2(MemorySegment struct) {
        return struct.get(CreateKernelV2$LAYOUT, CreateKernelV2$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateKernelV2)(const struct OrtCustomOp *, const OrtApi *, const OrtKernelInfo *, void **)
     * }
     */
    public static void CreateKernelV2(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(CreateKernelV2$LAYOUT, CreateKernelV2$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateKernelV2)(const struct OrtCustomOp *, const OrtApi *, const OrtKernelInfo *, void **)
     * }
     */
    public static CreateKernelV2.Function CreateKernelV2Function(MemorySegment struct) {
        return CreateKernelV2.function(CreateKernelV2(struct));
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*KernelComputeV2)(void *, OrtKernelContext *)
     * }
     */
    public static class KernelComputeV2 {

        KernelComputeV2() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            MemorySegment apply(MemorySegment _x0, MemorySegment _x1);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(KernelComputeV2.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(KernelComputeV2.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(MemorySegment funcPtr, MemorySegment _x0, MemorySegment _x1) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static KernelComputeV2.Function function(MemorySegment funcPtr) {
            return (_x0, _x1) -> invoke(funcPtr, _x0, _x1);
        }
    }

    private static final AddressLayout KernelComputeV2$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("KernelComputeV2"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*KernelComputeV2)(void *, OrtKernelContext *)
     * }
     */
    public static final AddressLayout KernelComputeV2$layout() {
        return KernelComputeV2$LAYOUT;
    }

    private static final long KernelComputeV2$OFFSET = 144;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*KernelComputeV2)(void *, OrtKernelContext *)
     * }
     */
    public static final long KernelComputeV2$offset() {
        return KernelComputeV2$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*KernelComputeV2)(void *, OrtKernelContext *)
     * }
     */
    public static MemorySegment KernelComputeV2(MemorySegment struct) {
        return struct.get(KernelComputeV2$LAYOUT, KernelComputeV2$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*KernelComputeV2)(void *, OrtKernelContext *)
     * }
     */
    public static void KernelComputeV2(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(KernelComputeV2$LAYOUT, KernelComputeV2$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*KernelComputeV2)(void *, OrtKernelContext *)
     * }
     */
    public static KernelComputeV2.Function KernelComputeV2Function(MemorySegment struct) {
        return KernelComputeV2.function(KernelComputeV2(struct));
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*InferOutputShapeFn)(const struct OrtCustomOp *, OrtShapeInferContext *)
     * }
     */
    public static class InferOutputShapeFn {

        InferOutputShapeFn() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            MemorySegment apply(MemorySegment _x0, MemorySegment _x1);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(InferOutputShapeFn.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(InferOutputShapeFn.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(MemorySegment funcPtr, MemorySegment _x0, MemorySegment _x1) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static InferOutputShapeFn.Function function(MemorySegment funcPtr) {
            return (_x0, _x1) -> invoke(funcPtr, _x0, _x1);
        }
    }

    private static final AddressLayout InferOutputShapeFn$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("InferOutputShapeFn"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*InferOutputShapeFn)(const struct OrtCustomOp *, OrtShapeInferContext *)
     * }
     */
    public static final AddressLayout InferOutputShapeFn$layout() {
        return InferOutputShapeFn$LAYOUT;
    }

    private static final long InferOutputShapeFn$OFFSET = 152;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*InferOutputShapeFn)(const struct OrtCustomOp *, OrtShapeInferContext *)
     * }
     */
    public static final long InferOutputShapeFn$offset() {
        return InferOutputShapeFn$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*InferOutputShapeFn)(const struct OrtCustomOp *, OrtShapeInferContext *)
     * }
     */
    public static MemorySegment InferOutputShapeFn(MemorySegment struct) {
        return struct.get(InferOutputShapeFn$LAYOUT, InferOutputShapeFn$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*InferOutputShapeFn)(const struct OrtCustomOp *, OrtShapeInferContext *)
     * }
     */
    public static void InferOutputShapeFn(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(InferOutputShapeFn$LAYOUT, InferOutputShapeFn$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*InferOutputShapeFn)(const struct OrtCustomOp *, OrtShapeInferContext *)
     * }
     */
    public static InferOutputShapeFn.Function InferOutputShapeFnFunction(MemorySegment struct) {
        return InferOutputShapeFn.function(InferOutputShapeFn(struct));
    }

    /**
     * {@snippet lang=c :
     * int (*GetStartVersion)(const struct OrtCustomOp *)
     * }
     */
    public static class GetStartVersion {

        GetStartVersion() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            int apply(MemorySegment _x0);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.of(onnxruntime_all_h.C_INT, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetStartVersion.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetStartVersion.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static int invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                return (int) DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetStartVersion.Function function(MemorySegment funcPtr) {
            return (_x0) -> invoke(funcPtr, _x0);
        }
    }

    private static final AddressLayout GetStartVersion$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetStartVersion"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int (*GetStartVersion)(const struct OrtCustomOp *)
     * }
     */
    public static final AddressLayout GetStartVersion$layout() {
        return GetStartVersion$LAYOUT;
    }

    private static final long GetStartVersion$OFFSET = 160;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int (*GetStartVersion)(const struct OrtCustomOp *)
     * }
     */
    public static final long GetStartVersion$offset() {
        return GetStartVersion$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int (*GetStartVersion)(const struct OrtCustomOp *)
     * }
     */
    public static MemorySegment GetStartVersion(MemorySegment struct) {
        return struct.get(GetStartVersion$LAYOUT, GetStartVersion$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int (*GetStartVersion)(const struct OrtCustomOp *)
     * }
     */
    public static void GetStartVersion(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetStartVersion$LAYOUT, GetStartVersion$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * int (*GetStartVersion)(const struct OrtCustomOp *)
     * }
     */
    public static GetStartVersion.Function GetStartVersionFunction(MemorySegment struct) {
        return GetStartVersion.function(GetStartVersion(struct));
    }

    /**
     * {@snippet lang=c :
     * int (*GetEndVersion)(const struct OrtCustomOp *)
     * }
     */
    public static class GetEndVersion {

        GetEndVersion() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            int apply(MemorySegment _x0);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.of(onnxruntime_all_h.C_INT, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetEndVersion.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetEndVersion.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static int invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                return (int) DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetEndVersion.Function function(MemorySegment funcPtr) {
            return (_x0) -> invoke(funcPtr, _x0);
        }
    }

    private static final AddressLayout GetEndVersion$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetEndVersion"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * int (*GetEndVersion)(const struct OrtCustomOp *)
     * }
     */
    public static final AddressLayout GetEndVersion$layout() {
        return GetEndVersion$LAYOUT;
    }

    private static final long GetEndVersion$OFFSET = 168;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * int (*GetEndVersion)(const struct OrtCustomOp *)
     * }
     */
    public static final long GetEndVersion$offset() {
        return GetEndVersion$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * int (*GetEndVersion)(const struct OrtCustomOp *)
     * }
     */
    public static MemorySegment GetEndVersion(MemorySegment struct) {
        return struct.get(GetEndVersion$LAYOUT, GetEndVersion$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * int (*GetEndVersion)(const struct OrtCustomOp *)
     * }
     */
    public static void GetEndVersion(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetEndVersion$LAYOUT, GetEndVersion$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * int (*GetEndVersion)(const struct OrtCustomOp *)
     * }
     */
    public static GetEndVersion.Function GetEndVersionFunction(MemorySegment struct) {
        return GetEndVersion.function(GetEndVersion(struct));
    }

    /**
     * {@snippet lang=c :
     * size_t (*GetMayInplace)(int **, int **)
     * }
     */
    public static class GetMayInplace {

        GetMayInplace() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            long apply(MemorySegment _x0, MemorySegment _x1);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_LONG, onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetMayInplace.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetMayInplace.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static long invoke(MemorySegment funcPtr, MemorySegment _x0, MemorySegment _x1) {
            try {
                return (long) DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetMayInplace.Function function(MemorySegment funcPtr) {
            return (_x0, _x1) -> invoke(funcPtr, _x0, _x1);
        }
    }

    private static final AddressLayout GetMayInplace$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetMayInplace"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * size_t (*GetMayInplace)(int **, int **)
     * }
     */
    public static final AddressLayout GetMayInplace$layout() {
        return GetMayInplace$LAYOUT;
    }

    private static final long GetMayInplace$OFFSET = 176;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * size_t (*GetMayInplace)(int **, int **)
     * }
     */
    public static final long GetMayInplace$offset() {
        return GetMayInplace$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * size_t (*GetMayInplace)(int **, int **)
     * }
     */
    public static MemorySegment GetMayInplace(MemorySegment struct) {
        return struct.get(GetMayInplace$LAYOUT, GetMayInplace$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * size_t (*GetMayInplace)(int **, int **)
     * }
     */
    public static void GetMayInplace(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetMayInplace$LAYOUT, GetMayInplace$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * size_t (*GetMayInplace)(int **, int **)
     * }
     */
    public static GetMayInplace.Function GetMayInplaceFunction(MemorySegment struct) {
        return GetMayInplace.function(GetMayInplace(struct));
    }

    /**
     * {@snippet lang=c :
     * void (*ReleaseMayInplace)(int *, int *)
     * }
     */
    public static class ReleaseMayInplace {

        ReleaseMayInplace() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            void apply(MemorySegment _x0, MemorySegment _x1);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.ofVoid(onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(ReleaseMayInplace.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(ReleaseMayInplace.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static void invoke(MemorySegment funcPtr, MemorySegment _x0, MemorySegment _x1) {
            try {
                DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static ReleaseMayInplace.Function function(MemorySegment funcPtr) {
            return (_x0, _x1) -> invoke(funcPtr, _x0, _x1);
        }
    }

    private static final AddressLayout ReleaseMayInplace$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("ReleaseMayInplace"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * void (*ReleaseMayInplace)(int *, int *)
     * }
     */
    public static final AddressLayout ReleaseMayInplace$layout() {
        return ReleaseMayInplace$LAYOUT;
    }

    private static final long ReleaseMayInplace$OFFSET = 184;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * void (*ReleaseMayInplace)(int *, int *)
     * }
     */
    public static final long ReleaseMayInplace$offset() {
        return ReleaseMayInplace$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * void (*ReleaseMayInplace)(int *, int *)
     * }
     */
    public static MemorySegment ReleaseMayInplace(MemorySegment struct) {
        return struct.get(ReleaseMayInplace$LAYOUT, ReleaseMayInplace$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * void (*ReleaseMayInplace)(int *, int *)
     * }
     */
    public static void ReleaseMayInplace(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(ReleaseMayInplace$LAYOUT, ReleaseMayInplace$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * void (*ReleaseMayInplace)(int *, int *)
     * }
     */
    public static ReleaseMayInplace.Function ReleaseMayInplaceFunction(MemorySegment struct) {
        return ReleaseMayInplace.function(ReleaseMayInplace(struct));
    }

    /**
     * {@snippet lang=c :
     * size_t (*GetAliasMap)(int **, int **)
     * }
     */
    public static class GetAliasMap {

        GetAliasMap() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            long apply(MemorySegment _x0, MemorySegment _x1);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_LONG, onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetAliasMap.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetAliasMap.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static long invoke(MemorySegment funcPtr, MemorySegment _x0, MemorySegment _x1) {
            try {
                return (long) DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static GetAliasMap.Function function(MemorySegment funcPtr) {
            return (_x0, _x1) -> invoke(funcPtr, _x0, _x1);
        }
    }

    private static final AddressLayout GetAliasMap$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("GetAliasMap"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * size_t (*GetAliasMap)(int **, int **)
     * }
     */
    public static final AddressLayout GetAliasMap$layout() {
        return GetAliasMap$LAYOUT;
    }

    private static final long GetAliasMap$OFFSET = 192;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * size_t (*GetAliasMap)(int **, int **)
     * }
     */
    public static final long GetAliasMap$offset() {
        return GetAliasMap$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * size_t (*GetAliasMap)(int **, int **)
     * }
     */
    public static MemorySegment GetAliasMap(MemorySegment struct) {
        return struct.get(GetAliasMap$LAYOUT, GetAliasMap$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * size_t (*GetAliasMap)(int **, int **)
     * }
     */
    public static void GetAliasMap(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetAliasMap$LAYOUT, GetAliasMap$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * size_t (*GetAliasMap)(int **, int **)
     * }
     */
    public static GetAliasMap.Function GetAliasMapFunction(MemorySegment struct) {
        return GetAliasMap.function(GetAliasMap(struct));
    }

    /**
     * {@snippet lang=c :
     * void (*ReleaseAliasMap)(int *, int *)
     * }
     */
    public static class ReleaseAliasMap {

        ReleaseAliasMap() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            void apply(MemorySegment _x0, MemorySegment _x1);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.ofVoid(onnxruntime_all_h.C_POINTER, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(ReleaseAliasMap.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(ReleaseAliasMap.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static void invoke(MemorySegment funcPtr, MemorySegment _x0, MemorySegment _x1) {
            try {
                DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }

        /**
         * Get an implementation of the function interface from a function pointer.
         */
        public static ReleaseAliasMap.Function function(MemorySegment funcPtr) {
            return (_x0, _x1) -> invoke(funcPtr, _x0, _x1);
        }
    }

    private static final AddressLayout ReleaseAliasMap$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("ReleaseAliasMap"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * void (*ReleaseAliasMap)(int *, int *)
     * }
     */
    public static final AddressLayout ReleaseAliasMap$layout() {
        return ReleaseAliasMap$LAYOUT;
    }

    private static final long ReleaseAliasMap$OFFSET = 200;

    /**
     * Offset for field:
     * {@snippet lang=c :
     * void (*ReleaseAliasMap)(int *, int *)
     * }
     */
    public static final long ReleaseAliasMap$offset() {
        return ReleaseAliasMap$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * void (*ReleaseAliasMap)(int *, int *)
     * }
     */
    public static MemorySegment ReleaseAliasMap(MemorySegment struct) {
        return struct.get(ReleaseAliasMap$LAYOUT, ReleaseAliasMap$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * void (*ReleaseAliasMap)(int *, int *)
     * }
     */
    public static void ReleaseAliasMap(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(ReleaseAliasMap$LAYOUT, ReleaseAliasMap$OFFSET, fieldValue);
    }

    /**
     * Functional interface getter for field:
     * {@snippet lang=c :
     * void (*ReleaseAliasMap)(int *, int *)
     * }
     */
    public static ReleaseAliasMap.Function ReleaseAliasMapFunction(MemorySegment struct) {
        return ReleaseAliasMap.function(ReleaseAliasMap(struct));
    }

    /**
     * Obtains a slice of {@code arrayParam} which selects the array element at {@code index}.
     * The returned segment has address {@code arrayParam.address() + index * layout().byteSize()}
     */
    public static MemorySegment asSlice(MemorySegment array, long index) {
        return array.asSlice(layout().byteSize() * index);
    }

    /**
     * The size (in bytes) of this struct
     */
    public static long sizeof() {
        return layout().byteSize();
    }

    /**
     * Allocate a segment of size {@code layout().byteSize()} using {@code allocator}
     */
    public static MemorySegment allocate(SegmentAllocator allocator) {
        return allocator.allocate(layout());
    }

    /**
     * Allocate an array of size {@code elementCount} using {@code allocator}.
     * The returned segment has size {@code elementCount * layout().byteSize()}.
     */
    public static MemorySegment allocateArray(long elementCount, SegmentAllocator allocator) {
        return allocator.allocate(MemoryLayout.sequenceLayout(elementCount, layout()));
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction} (if any).
     * The returned segment has size {@code layout().byteSize()}
     */
    public static MemorySegment reinterpret(MemorySegment addr, Arena arena, Consumer<MemorySegment> cleanup) {
        return reinterpret(addr, 1, arena, cleanup);
    }

    /**
     * Reinterprets {@code addr} using target {@code arena} and {@code cleanupAction} (if any).
     * The returned segment has size {@code elementCount * layout().byteSize()}
     */
    public static MemorySegment reinterpret(
            MemorySegment addr, long elementCount, Arena arena, Consumer<MemorySegment> cleanup) {
        return addr.reinterpret(layout().byteSize() * elementCount, arena, cleanup);
    }
}
