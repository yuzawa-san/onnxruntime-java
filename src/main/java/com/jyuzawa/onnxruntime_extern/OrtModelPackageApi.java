/*
 * Copyright (c) 2026 James Yuzawa (https://www.jyuzawa.com/)
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
 * struct OrtModelPackageApi {
 *     OrtStatusPtr (*CreateModelPackageOptionsFromSessionOptions)(const OrtEnv *, const OrtSessionOptions *, OrtModelPackageOptions **);
 *     void (*ReleaseModelPackageOptions)(OrtModelPackageOptions *);
 *     OrtStatusPtr (*CreateModelPackageContext)(const char *, OrtModelPackageContext **);
 *     void (*ReleaseModelPackageContext)(OrtModelPackageContext *);
 *     OrtStatusPtr (*ModelPackage_GetSchemaVersion)(const OrtModelPackageContext *, int64_t *);
 *     OrtStatusPtr (*ModelPackage_GetComponentCount)(const OrtModelPackageContext *, size_t *);
 *     OrtStatusPtr (*ModelPackage_GetComponentNames)(const OrtModelPackageContext *, const char *const **, size_t *);
 *     OrtStatusPtr (*ModelPackage_GetVariantCount)(const OrtModelPackageContext *, const char *, size_t *);
 *     OrtStatusPtr (*ModelPackage_GetVariantNames)(const OrtModelPackageContext *, const char *, const char *const **, size_t *);
 *     OrtStatusPtr (*ModelPackage_GetVariantEpName)(const OrtModelPackageContext *, const char *, const char *, const char **);
 *     OrtStatusPtr (*ModelPackage_ResolveStringRef)(const OrtModelPackageContext *, const char *, const char *, int, const char **);
 *     OrtStatusPtr (*SelectComponent)(const OrtModelPackageContext *, const char *, const OrtModelPackageOptions *, OrtModelPackageComponentContext **);
 *     void (*ReleaseModelPackageComponentContext)(OrtModelPackageComponentContext *);
 *     OrtStatusPtr (*ModelPackageComponent_GetSelectedVariantName)(const OrtModelPackageComponentContext *, const char **);
 *     OrtStatusPtr (*ModelPackageComponent_GetSelectedVariantFolderPath)(const OrtModelPackageComponentContext *, const char **);
 *     OrtStatusPtr (*CreateSession)(const OrtEnv *, OrtModelPackageComponentContext *, const OrtSessionOptions *, OrtSession **);
 * }
 * }
 */
public class OrtModelPackageApi {

    OrtModelPackageApi() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
                    onnxruntime_all_h.C_POINTER.withName("CreateModelPackageOptionsFromSessionOptions"),
                    onnxruntime_all_h.C_POINTER.withName("ReleaseModelPackageOptions"),
                    onnxruntime_all_h.C_POINTER.withName("CreateModelPackageContext"),
                    onnxruntime_all_h.C_POINTER.withName("ReleaseModelPackageContext"),
                    onnxruntime_all_h.C_POINTER.withName("ModelPackage_GetSchemaVersion"),
                    onnxruntime_all_h.C_POINTER.withName("ModelPackage_GetComponentCount"),
                    onnxruntime_all_h.C_POINTER.withName("ModelPackage_GetComponentNames"),
                    onnxruntime_all_h.C_POINTER.withName("ModelPackage_GetVariantCount"),
                    onnxruntime_all_h.C_POINTER.withName("ModelPackage_GetVariantNames"),
                    onnxruntime_all_h.C_POINTER.withName("ModelPackage_GetVariantEpName"),
                    onnxruntime_all_h.C_POINTER.withName("ModelPackage_ResolveStringRef"),
                    onnxruntime_all_h.C_POINTER.withName("SelectComponent"),
                    onnxruntime_all_h.C_POINTER.withName("ReleaseModelPackageComponentContext"),
                    onnxruntime_all_h.C_POINTER.withName("ModelPackageComponent_GetSelectedVariantName"),
                    onnxruntime_all_h.C_POINTER.withName("ModelPackageComponent_GetSelectedVariantFolderPath"),
                    onnxruntime_all_h.C_POINTER.withName("CreateSession"))
            .withName("OrtModelPackageApi");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateModelPackageOptionsFromSessionOptions)(const OrtEnv *, const OrtSessionOptions *, OrtModelPackageOptions **)
     * }
     */
    public static final class CreateModelPackageOptionsFromSessionOptions {

        private CreateModelPackageOptionsFromSessionOptions() {
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

        private static final MethodHandle UP$MH = onnxruntime_all_h.upcallHandle(
                CreateModelPackageOptionsFromSessionOptions.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(CreateModelPackageOptionsFromSessionOptions.Function fi, Arena arena) {
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
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout CreateModelPackageOptionsFromSessionOptions$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("CreateModelPackageOptionsFromSessionOptions"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateModelPackageOptionsFromSessionOptions)(const OrtEnv *, const OrtSessionOptions *, OrtModelPackageOptions **)
     * }
     */
    public static final AddressLayout CreateModelPackageOptionsFromSessionOptions$layout() {
        return CreateModelPackageOptionsFromSessionOptions$LAYOUT;
    }

    private static final long CreateModelPackageOptionsFromSessionOptions$OFFSET =
            $LAYOUT.byteOffset(groupElement("CreateModelPackageOptionsFromSessionOptions"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateModelPackageOptionsFromSessionOptions)(const OrtEnv *, const OrtSessionOptions *, OrtModelPackageOptions **)
     * }
     */
    public static final long CreateModelPackageOptionsFromSessionOptions$offset() {
        return CreateModelPackageOptionsFromSessionOptions$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateModelPackageOptionsFromSessionOptions)(const OrtEnv *, const OrtSessionOptions *, OrtModelPackageOptions **)
     * }
     */
    public static MemorySegment CreateModelPackageOptionsFromSessionOptions(MemorySegment struct) {
        return struct.get(
                CreateModelPackageOptionsFromSessionOptions$LAYOUT, CreateModelPackageOptionsFromSessionOptions$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateModelPackageOptionsFromSessionOptions)(const OrtEnv *, const OrtSessionOptions *, OrtModelPackageOptions **)
     * }
     */
    public static void CreateModelPackageOptionsFromSessionOptions(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(
                CreateModelPackageOptionsFromSessionOptions$LAYOUT,
                CreateModelPackageOptionsFromSessionOptions$OFFSET,
                fieldValue);
    }

    /**
     * {@snippet lang=c :
     * void (*ReleaseModelPackageOptions)(OrtModelPackageOptions *)
     * }
     */
    public static final class ReleaseModelPackageOptions {

        private ReleaseModelPackageOptions() {
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
                onnxruntime_all_h.upcallHandle(ReleaseModelPackageOptions.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(ReleaseModelPackageOptions.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static void invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout ReleaseModelPackageOptions$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("ReleaseModelPackageOptions"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * void (*ReleaseModelPackageOptions)(OrtModelPackageOptions *)
     * }
     */
    public static final AddressLayout ReleaseModelPackageOptions$layout() {
        return ReleaseModelPackageOptions$LAYOUT;
    }

    private static final long ReleaseModelPackageOptions$OFFSET =
            $LAYOUT.byteOffset(groupElement("ReleaseModelPackageOptions"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * void (*ReleaseModelPackageOptions)(OrtModelPackageOptions *)
     * }
     */
    public static final long ReleaseModelPackageOptions$offset() {
        return ReleaseModelPackageOptions$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * void (*ReleaseModelPackageOptions)(OrtModelPackageOptions *)
     * }
     */
    public static MemorySegment ReleaseModelPackageOptions(MemorySegment struct) {
        return struct.get(ReleaseModelPackageOptions$LAYOUT, ReleaseModelPackageOptions$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * void (*ReleaseModelPackageOptions)(OrtModelPackageOptions *)
     * }
     */
    public static void ReleaseModelPackageOptions(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(ReleaseModelPackageOptions$LAYOUT, ReleaseModelPackageOptions$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateModelPackageContext)(const char *, OrtModelPackageContext **)
     * }
     */
    public static final class CreateModelPackageContext {

        private CreateModelPackageContext() {
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
                onnxruntime_all_h.upcallHandle(CreateModelPackageContext.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(CreateModelPackageContext.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(MemorySegment funcPtr, MemorySegment _x0, MemorySegment _x1) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout CreateModelPackageContext$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("CreateModelPackageContext"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateModelPackageContext)(const char *, OrtModelPackageContext **)
     * }
     */
    public static final AddressLayout CreateModelPackageContext$layout() {
        return CreateModelPackageContext$LAYOUT;
    }

    private static final long CreateModelPackageContext$OFFSET =
            $LAYOUT.byteOffset(groupElement("CreateModelPackageContext"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateModelPackageContext)(const char *, OrtModelPackageContext **)
     * }
     */
    public static final long CreateModelPackageContext$offset() {
        return CreateModelPackageContext$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateModelPackageContext)(const char *, OrtModelPackageContext **)
     * }
     */
    public static MemorySegment CreateModelPackageContext(MemorySegment struct) {
        return struct.get(CreateModelPackageContext$LAYOUT, CreateModelPackageContext$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateModelPackageContext)(const char *, OrtModelPackageContext **)
     * }
     */
    public static void CreateModelPackageContext(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(CreateModelPackageContext$LAYOUT, CreateModelPackageContext$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * void (*ReleaseModelPackageContext)(OrtModelPackageContext *)
     * }
     */
    public static final class ReleaseModelPackageContext {

        private ReleaseModelPackageContext() {
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
                onnxruntime_all_h.upcallHandle(ReleaseModelPackageContext.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(ReleaseModelPackageContext.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static void invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout ReleaseModelPackageContext$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("ReleaseModelPackageContext"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * void (*ReleaseModelPackageContext)(OrtModelPackageContext *)
     * }
     */
    public static final AddressLayout ReleaseModelPackageContext$layout() {
        return ReleaseModelPackageContext$LAYOUT;
    }

    private static final long ReleaseModelPackageContext$OFFSET =
            $LAYOUT.byteOffset(groupElement("ReleaseModelPackageContext"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * void (*ReleaseModelPackageContext)(OrtModelPackageContext *)
     * }
     */
    public static final long ReleaseModelPackageContext$offset() {
        return ReleaseModelPackageContext$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * void (*ReleaseModelPackageContext)(OrtModelPackageContext *)
     * }
     */
    public static MemorySegment ReleaseModelPackageContext(MemorySegment struct) {
        return struct.get(ReleaseModelPackageContext$LAYOUT, ReleaseModelPackageContext$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * void (*ReleaseModelPackageContext)(OrtModelPackageContext *)
     * }
     */
    public static void ReleaseModelPackageContext(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(ReleaseModelPackageContext$LAYOUT, ReleaseModelPackageContext$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetSchemaVersion)(const OrtModelPackageContext *, int64_t *)
     * }
     */
    public static final class ModelPackage_GetSchemaVersion {

        private ModelPackage_GetSchemaVersion() {
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
                onnxruntime_all_h.upcallHandle(ModelPackage_GetSchemaVersion.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(ModelPackage_GetSchemaVersion.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(MemorySegment funcPtr, MemorySegment _x0, MemorySegment _x1) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout ModelPackage_GetSchemaVersion$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("ModelPackage_GetSchemaVersion"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetSchemaVersion)(const OrtModelPackageContext *, int64_t *)
     * }
     */
    public static final AddressLayout ModelPackage_GetSchemaVersion$layout() {
        return ModelPackage_GetSchemaVersion$LAYOUT;
    }

    private static final long ModelPackage_GetSchemaVersion$OFFSET =
            $LAYOUT.byteOffset(groupElement("ModelPackage_GetSchemaVersion"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetSchemaVersion)(const OrtModelPackageContext *, int64_t *)
     * }
     */
    public static final long ModelPackage_GetSchemaVersion$offset() {
        return ModelPackage_GetSchemaVersion$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetSchemaVersion)(const OrtModelPackageContext *, int64_t *)
     * }
     */
    public static MemorySegment ModelPackage_GetSchemaVersion(MemorySegment struct) {
        return struct.get(ModelPackage_GetSchemaVersion$LAYOUT, ModelPackage_GetSchemaVersion$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetSchemaVersion)(const OrtModelPackageContext *, int64_t *)
     * }
     */
    public static void ModelPackage_GetSchemaVersion(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(ModelPackage_GetSchemaVersion$LAYOUT, ModelPackage_GetSchemaVersion$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetComponentCount)(const OrtModelPackageContext *, size_t *)
     * }
     */
    public static final class ModelPackage_GetComponentCount {

        private ModelPackage_GetComponentCount() {
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
                onnxruntime_all_h.upcallHandle(ModelPackage_GetComponentCount.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(ModelPackage_GetComponentCount.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(MemorySegment funcPtr, MemorySegment _x0, MemorySegment _x1) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout ModelPackage_GetComponentCount$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("ModelPackage_GetComponentCount"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetComponentCount)(const OrtModelPackageContext *, size_t *)
     * }
     */
    public static final AddressLayout ModelPackage_GetComponentCount$layout() {
        return ModelPackage_GetComponentCount$LAYOUT;
    }

    private static final long ModelPackage_GetComponentCount$OFFSET =
            $LAYOUT.byteOffset(groupElement("ModelPackage_GetComponentCount"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetComponentCount)(const OrtModelPackageContext *, size_t *)
     * }
     */
    public static final long ModelPackage_GetComponentCount$offset() {
        return ModelPackage_GetComponentCount$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetComponentCount)(const OrtModelPackageContext *, size_t *)
     * }
     */
    public static MemorySegment ModelPackage_GetComponentCount(MemorySegment struct) {
        return struct.get(ModelPackage_GetComponentCount$LAYOUT, ModelPackage_GetComponentCount$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetComponentCount)(const OrtModelPackageContext *, size_t *)
     * }
     */
    public static void ModelPackage_GetComponentCount(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(ModelPackage_GetComponentCount$LAYOUT, ModelPackage_GetComponentCount$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetComponentNames)(const OrtModelPackageContext *, const char *const **, size_t *)
     * }
     */
    public static final class ModelPackage_GetComponentNames {

        private ModelPackage_GetComponentNames() {
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
                onnxruntime_all_h.upcallHandle(ModelPackage_GetComponentNames.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(ModelPackage_GetComponentNames.Function fi, Arena arena) {
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
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout ModelPackage_GetComponentNames$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("ModelPackage_GetComponentNames"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetComponentNames)(const OrtModelPackageContext *, const char *const **, size_t *)
     * }
     */
    public static final AddressLayout ModelPackage_GetComponentNames$layout() {
        return ModelPackage_GetComponentNames$LAYOUT;
    }

    private static final long ModelPackage_GetComponentNames$OFFSET =
            $LAYOUT.byteOffset(groupElement("ModelPackage_GetComponentNames"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetComponentNames)(const OrtModelPackageContext *, const char *const **, size_t *)
     * }
     */
    public static final long ModelPackage_GetComponentNames$offset() {
        return ModelPackage_GetComponentNames$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetComponentNames)(const OrtModelPackageContext *, const char *const **, size_t *)
     * }
     */
    public static MemorySegment ModelPackage_GetComponentNames(MemorySegment struct) {
        return struct.get(ModelPackage_GetComponentNames$LAYOUT, ModelPackage_GetComponentNames$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetComponentNames)(const OrtModelPackageContext *, const char *const **, size_t *)
     * }
     */
    public static void ModelPackage_GetComponentNames(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(ModelPackage_GetComponentNames$LAYOUT, ModelPackage_GetComponentNames$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetVariantCount)(const OrtModelPackageContext *, const char *, size_t *)
     * }
     */
    public static final class ModelPackage_GetVariantCount {

        private ModelPackage_GetVariantCount() {
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
                onnxruntime_all_h.upcallHandle(ModelPackage_GetVariantCount.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(ModelPackage_GetVariantCount.Function fi, Arena arena) {
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
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout ModelPackage_GetVariantCount$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("ModelPackage_GetVariantCount"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetVariantCount)(const OrtModelPackageContext *, const char *, size_t *)
     * }
     */
    public static final AddressLayout ModelPackage_GetVariantCount$layout() {
        return ModelPackage_GetVariantCount$LAYOUT;
    }

    private static final long ModelPackage_GetVariantCount$OFFSET =
            $LAYOUT.byteOffset(groupElement("ModelPackage_GetVariantCount"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetVariantCount)(const OrtModelPackageContext *, const char *, size_t *)
     * }
     */
    public static final long ModelPackage_GetVariantCount$offset() {
        return ModelPackage_GetVariantCount$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetVariantCount)(const OrtModelPackageContext *, const char *, size_t *)
     * }
     */
    public static MemorySegment ModelPackage_GetVariantCount(MemorySegment struct) {
        return struct.get(ModelPackage_GetVariantCount$LAYOUT, ModelPackage_GetVariantCount$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetVariantCount)(const OrtModelPackageContext *, const char *, size_t *)
     * }
     */
    public static void ModelPackage_GetVariantCount(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(ModelPackage_GetVariantCount$LAYOUT, ModelPackage_GetVariantCount$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetVariantNames)(const OrtModelPackageContext *, const char *, const char *const **, size_t *)
     * }
     */
    public static final class ModelPackage_GetVariantNames {

        private ModelPackage_GetVariantNames() {
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
                onnxruntime_all_h.upcallHandle(ModelPackage_GetVariantNames.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(ModelPackage_GetVariantNames.Function fi, Arena arena) {
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
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout ModelPackage_GetVariantNames$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("ModelPackage_GetVariantNames"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetVariantNames)(const OrtModelPackageContext *, const char *, const char *const **, size_t *)
     * }
     */
    public static final AddressLayout ModelPackage_GetVariantNames$layout() {
        return ModelPackage_GetVariantNames$LAYOUT;
    }

    private static final long ModelPackage_GetVariantNames$OFFSET =
            $LAYOUT.byteOffset(groupElement("ModelPackage_GetVariantNames"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetVariantNames)(const OrtModelPackageContext *, const char *, const char *const **, size_t *)
     * }
     */
    public static final long ModelPackage_GetVariantNames$offset() {
        return ModelPackage_GetVariantNames$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetVariantNames)(const OrtModelPackageContext *, const char *, const char *const **, size_t *)
     * }
     */
    public static MemorySegment ModelPackage_GetVariantNames(MemorySegment struct) {
        return struct.get(ModelPackage_GetVariantNames$LAYOUT, ModelPackage_GetVariantNames$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetVariantNames)(const OrtModelPackageContext *, const char *, const char *const **, size_t *)
     * }
     */
    public static void ModelPackage_GetVariantNames(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(ModelPackage_GetVariantNames$LAYOUT, ModelPackage_GetVariantNames$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetVariantEpName)(const OrtModelPackageContext *, const char *, const char *, const char **)
     * }
     */
    public static final class ModelPackage_GetVariantEpName {

        private ModelPackage_GetVariantEpName() {
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
                onnxruntime_all_h.upcallHandle(ModelPackage_GetVariantEpName.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(ModelPackage_GetVariantEpName.Function fi, Arena arena) {
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
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout ModelPackage_GetVariantEpName$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("ModelPackage_GetVariantEpName"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetVariantEpName)(const OrtModelPackageContext *, const char *, const char *, const char **)
     * }
     */
    public static final AddressLayout ModelPackage_GetVariantEpName$layout() {
        return ModelPackage_GetVariantEpName$LAYOUT;
    }

    private static final long ModelPackage_GetVariantEpName$OFFSET =
            $LAYOUT.byteOffset(groupElement("ModelPackage_GetVariantEpName"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetVariantEpName)(const OrtModelPackageContext *, const char *, const char *, const char **)
     * }
     */
    public static final long ModelPackage_GetVariantEpName$offset() {
        return ModelPackage_GetVariantEpName$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetVariantEpName)(const OrtModelPackageContext *, const char *, const char *, const char **)
     * }
     */
    public static MemorySegment ModelPackage_GetVariantEpName(MemorySegment struct) {
        return struct.get(ModelPackage_GetVariantEpName$LAYOUT, ModelPackage_GetVariantEpName$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_GetVariantEpName)(const OrtModelPackageContext *, const char *, const char *, const char **)
     * }
     */
    public static void ModelPackage_GetVariantEpName(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(ModelPackage_GetVariantEpName$LAYOUT, ModelPackage_GetVariantEpName$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_ResolveStringRef)(const OrtModelPackageContext *, const char *, const char *, int, const char **)
     * }
     */
    public static final class ModelPackage_ResolveStringRef {

        private ModelPackage_ResolveStringRef() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            MemorySegment apply(MemorySegment _x0, MemorySegment _x1, MemorySegment _x2, int _x3, MemorySegment _x4);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_INT,
                onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(ModelPackage_ResolveStringRef.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(ModelPackage_ResolveStringRef.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(
                MemorySegment funcPtr,
                MemorySegment _x0,
                MemorySegment _x1,
                MemorySegment _x2,
                int _x3,
                MemorySegment _x4) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0, _x1, _x2, _x3, _x4);
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout ModelPackage_ResolveStringRef$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("ModelPackage_ResolveStringRef"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_ResolveStringRef)(const OrtModelPackageContext *, const char *, const char *, int, const char **)
     * }
     */
    public static final AddressLayout ModelPackage_ResolveStringRef$layout() {
        return ModelPackage_ResolveStringRef$LAYOUT;
    }

    private static final long ModelPackage_ResolveStringRef$OFFSET =
            $LAYOUT.byteOffset(groupElement("ModelPackage_ResolveStringRef"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_ResolveStringRef)(const OrtModelPackageContext *, const char *, const char *, int, const char **)
     * }
     */
    public static final long ModelPackage_ResolveStringRef$offset() {
        return ModelPackage_ResolveStringRef$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_ResolveStringRef)(const OrtModelPackageContext *, const char *, const char *, int, const char **)
     * }
     */
    public static MemorySegment ModelPackage_ResolveStringRef(MemorySegment struct) {
        return struct.get(ModelPackage_ResolveStringRef$LAYOUT, ModelPackage_ResolveStringRef$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackage_ResolveStringRef)(const OrtModelPackageContext *, const char *, const char *, int, const char **)
     * }
     */
    public static void ModelPackage_ResolveStringRef(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(ModelPackage_ResolveStringRef$LAYOUT, ModelPackage_ResolveStringRef$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*SelectComponent)(const OrtModelPackageContext *, const char *, const OrtModelPackageOptions *, OrtModelPackageComponentContext **)
     * }
     */
    public static final class SelectComponent {

        private SelectComponent() {
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
                onnxruntime_all_h.upcallHandle(SelectComponent.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(SelectComponent.Function fi, Arena arena) {
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
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout SelectComponent$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("SelectComponent"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*SelectComponent)(const OrtModelPackageContext *, const char *, const OrtModelPackageOptions *, OrtModelPackageComponentContext **)
     * }
     */
    public static final AddressLayout SelectComponent$layout() {
        return SelectComponent$LAYOUT;
    }

    private static final long SelectComponent$OFFSET = $LAYOUT.byteOffset(groupElement("SelectComponent"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*SelectComponent)(const OrtModelPackageContext *, const char *, const OrtModelPackageOptions *, OrtModelPackageComponentContext **)
     * }
     */
    public static final long SelectComponent$offset() {
        return SelectComponent$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*SelectComponent)(const OrtModelPackageContext *, const char *, const OrtModelPackageOptions *, OrtModelPackageComponentContext **)
     * }
     */
    public static MemorySegment SelectComponent(MemorySegment struct) {
        return struct.get(SelectComponent$LAYOUT, SelectComponent$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*SelectComponent)(const OrtModelPackageContext *, const char *, const OrtModelPackageOptions *, OrtModelPackageComponentContext **)
     * }
     */
    public static void SelectComponent(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(SelectComponent$LAYOUT, SelectComponent$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * void (*ReleaseModelPackageComponentContext)(OrtModelPackageComponentContext *)
     * }
     */
    public static final class ReleaseModelPackageComponentContext {

        private ReleaseModelPackageComponentContext() {
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
                onnxruntime_all_h.upcallHandle(ReleaseModelPackageComponentContext.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(ReleaseModelPackageComponentContext.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static void invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout ReleaseModelPackageComponentContext$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("ReleaseModelPackageComponentContext"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * void (*ReleaseModelPackageComponentContext)(OrtModelPackageComponentContext *)
     * }
     */
    public static final AddressLayout ReleaseModelPackageComponentContext$layout() {
        return ReleaseModelPackageComponentContext$LAYOUT;
    }

    private static final long ReleaseModelPackageComponentContext$OFFSET =
            $LAYOUT.byteOffset(groupElement("ReleaseModelPackageComponentContext"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * void (*ReleaseModelPackageComponentContext)(OrtModelPackageComponentContext *)
     * }
     */
    public static final long ReleaseModelPackageComponentContext$offset() {
        return ReleaseModelPackageComponentContext$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * void (*ReleaseModelPackageComponentContext)(OrtModelPackageComponentContext *)
     * }
     */
    public static MemorySegment ReleaseModelPackageComponentContext(MemorySegment struct) {
        return struct.get(ReleaseModelPackageComponentContext$LAYOUT, ReleaseModelPackageComponentContext$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * void (*ReleaseModelPackageComponentContext)(OrtModelPackageComponentContext *)
     * }
     */
    public static void ReleaseModelPackageComponentContext(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(ReleaseModelPackageComponentContext$LAYOUT, ReleaseModelPackageComponentContext$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackageComponent_GetSelectedVariantName)(const OrtModelPackageComponentContext *, const char **)
     * }
     */
    public static final class ModelPackageComponent_GetSelectedVariantName {

        private ModelPackageComponent_GetSelectedVariantName() {
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

        private static final MethodHandle UP$MH = onnxruntime_all_h.upcallHandle(
                ModelPackageComponent_GetSelectedVariantName.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(ModelPackageComponent_GetSelectedVariantName.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(MemorySegment funcPtr, MemorySegment _x0, MemorySegment _x1) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout ModelPackageComponent_GetSelectedVariantName$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("ModelPackageComponent_GetSelectedVariantName"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackageComponent_GetSelectedVariantName)(const OrtModelPackageComponentContext *, const char **)
     * }
     */
    public static final AddressLayout ModelPackageComponent_GetSelectedVariantName$layout() {
        return ModelPackageComponent_GetSelectedVariantName$LAYOUT;
    }

    private static final long ModelPackageComponent_GetSelectedVariantName$OFFSET =
            $LAYOUT.byteOffset(groupElement("ModelPackageComponent_GetSelectedVariantName"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackageComponent_GetSelectedVariantName)(const OrtModelPackageComponentContext *, const char **)
     * }
     */
    public static final long ModelPackageComponent_GetSelectedVariantName$offset() {
        return ModelPackageComponent_GetSelectedVariantName$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackageComponent_GetSelectedVariantName)(const OrtModelPackageComponentContext *, const char **)
     * }
     */
    public static MemorySegment ModelPackageComponent_GetSelectedVariantName(MemorySegment struct) {
        return struct.get(
                ModelPackageComponent_GetSelectedVariantName$LAYOUT,
                ModelPackageComponent_GetSelectedVariantName$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackageComponent_GetSelectedVariantName)(const OrtModelPackageComponentContext *, const char **)
     * }
     */
    public static void ModelPackageComponent_GetSelectedVariantName(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(
                ModelPackageComponent_GetSelectedVariantName$LAYOUT,
                ModelPackageComponent_GetSelectedVariantName$OFFSET,
                fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackageComponent_GetSelectedVariantFolderPath)(const OrtModelPackageComponentContext *, const char **)
     * }
     */
    public static final class ModelPackageComponent_GetSelectedVariantFolderPath {

        private ModelPackageComponent_GetSelectedVariantFolderPath() {
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

        private static final MethodHandle UP$MH = onnxruntime_all_h.upcallHandle(
                ModelPackageComponent_GetSelectedVariantFolderPath.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(
                ModelPackageComponent_GetSelectedVariantFolderPath.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(MemorySegment funcPtr, MemorySegment _x0, MemorySegment _x1) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout ModelPackageComponent_GetSelectedVariantFolderPath$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("ModelPackageComponent_GetSelectedVariantFolderPath"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackageComponent_GetSelectedVariantFolderPath)(const OrtModelPackageComponentContext *, const char **)
     * }
     */
    public static final AddressLayout ModelPackageComponent_GetSelectedVariantFolderPath$layout() {
        return ModelPackageComponent_GetSelectedVariantFolderPath$LAYOUT;
    }

    private static final long ModelPackageComponent_GetSelectedVariantFolderPath$OFFSET =
            $LAYOUT.byteOffset(groupElement("ModelPackageComponent_GetSelectedVariantFolderPath"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackageComponent_GetSelectedVariantFolderPath)(const OrtModelPackageComponentContext *, const char **)
     * }
     */
    public static final long ModelPackageComponent_GetSelectedVariantFolderPath$offset() {
        return ModelPackageComponent_GetSelectedVariantFolderPath$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackageComponent_GetSelectedVariantFolderPath)(const OrtModelPackageComponentContext *, const char **)
     * }
     */
    public static MemorySegment ModelPackageComponent_GetSelectedVariantFolderPath(MemorySegment struct) {
        return struct.get(
                ModelPackageComponent_GetSelectedVariantFolderPath$LAYOUT,
                ModelPackageComponent_GetSelectedVariantFolderPath$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ModelPackageComponent_GetSelectedVariantFolderPath)(const OrtModelPackageComponentContext *, const char **)
     * }
     */
    public static void ModelPackageComponent_GetSelectedVariantFolderPath(
            MemorySegment struct, MemorySegment fieldValue) {
        struct.set(
                ModelPackageComponent_GetSelectedVariantFolderPath$LAYOUT,
                ModelPackageComponent_GetSelectedVariantFolderPath$OFFSET,
                fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateSession)(const OrtEnv *, OrtModelPackageComponentContext *, const OrtSessionOptions *, OrtSession **)
     * }
     */
    public static final class CreateSession {

        private CreateSession() {
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
                onnxruntime_all_h.upcallHandle(CreateSession.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(CreateSession.Function fi, Arena arena) {
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
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout CreateSession$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("CreateSession"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateSession)(const OrtEnv *, OrtModelPackageComponentContext *, const OrtSessionOptions *, OrtSession **)
     * }
     */
    public static final AddressLayout CreateSession$layout() {
        return CreateSession$LAYOUT;
    }

    private static final long CreateSession$OFFSET = $LAYOUT.byteOffset(groupElement("CreateSession"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateSession)(const OrtEnv *, OrtModelPackageComponentContext *, const OrtSessionOptions *, OrtSession **)
     * }
     */
    public static final long CreateSession$offset() {
        return CreateSession$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateSession)(const OrtEnv *, OrtModelPackageComponentContext *, const OrtSessionOptions *, OrtSession **)
     * }
     */
    public static MemorySegment CreateSession(MemorySegment struct) {
        return struct.get(CreateSession$LAYOUT, CreateSession$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateSession)(const OrtEnv *, OrtModelPackageComponentContext *, const OrtSessionOptions *, OrtSession **)
     * }
     */
    public static void CreateSession(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(CreateSession$LAYOUT, CreateSession$OFFSET, fieldValue);
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
