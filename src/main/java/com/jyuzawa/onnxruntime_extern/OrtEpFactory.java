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
 * struct OrtEpFactory {
 *     uint32_t ort_version_supported;
 *     const char *(*GetName)(const OrtEpFactory *);
 *     const char *(*GetVendor)(const OrtEpFactory *);
 *     OrtStatusPtr (*GetSupportedDevices)(OrtEpFactory *, const OrtHardwareDevice *const *, size_t, OrtEpDevice **, size_t, size_t *);
 *     OrtStatusPtr (*CreateEp)(OrtEpFactory *, const OrtHardwareDevice *const *, const OrtKeyValuePairs *const *, size_t, const OrtSessionOptions *, const OrtLogger *, OrtEp **);
 *     void (*ReleaseEp)(OrtEpFactory *, struct OrtEp *);
 *     uint32_t (*GetVendorId)(const OrtEpFactory *);
 *     const char *(*GetVersion)(const OrtEpFactory *);
 *     OrtStatusPtr (*ValidateCompiledModelCompatibilityInfo)(OrtEpFactory *, const OrtHardwareDevice *const *, size_t, const char *, OrtCompiledModelCompatibility *);
 *     OrtStatusPtr (*CreateAllocator)(OrtEpFactory *, const OrtMemoryInfo *, const OrtKeyValuePairs *, OrtAllocator **);
 *     void (*ReleaseAllocator)(OrtEpFactory *, OrtAllocator *);
 *     OrtStatusPtr (*CreateDataTransfer)(OrtEpFactory *, OrtDataTransferImpl **);
 *     bool (*IsStreamAware)(const OrtEpFactory *);
 *     OrtStatusPtr (*CreateSyncStreamForDevice)(OrtEpFactory *, const OrtMemoryDevice *, const OrtKeyValuePairs *, OrtSyncStreamImpl **);
 *     OrtStatusPtr (*GetHardwareDeviceIncompatibilityDetails)(OrtEpFactory *, const OrtHardwareDevice *, OrtDeviceEpIncompatibilityDetails *);
 *     OrtStatusPtr (*CreateExternalResourceImporterForDevice)(OrtEpFactory *, const OrtEpDevice *, OrtExternalResourceImporterImpl **);
 *     OrtStatusPtr (*GetNumCustomOpDomains)(OrtEpFactory *, size_t *);
 *     OrtStatusPtr (*GetCustomOpDomains)(OrtEpFactory *, OrtCustomOpDomain **, size_t);
 * }
 * }
 */
public class OrtEpFactory {

    OrtEpFactory() {
        // Should not be called directly
    }

    private static final GroupLayout $LAYOUT = MemoryLayout.structLayout(
                    onnxruntime_all_h.C_INT.withName("ort_version_supported"),
                    MemoryLayout.paddingLayout(4),
                    onnxruntime_all_h.C_POINTER.withName("GetName"),
                    onnxruntime_all_h.C_POINTER.withName("GetVendor"),
                    onnxruntime_all_h.C_POINTER.withName("GetSupportedDevices"),
                    onnxruntime_all_h.C_POINTER.withName("CreateEp"),
                    onnxruntime_all_h.C_POINTER.withName("ReleaseEp"),
                    onnxruntime_all_h.C_POINTER.withName("GetVendorId"),
                    onnxruntime_all_h.C_POINTER.withName("GetVersion"),
                    onnxruntime_all_h.C_POINTER.withName("ValidateCompiledModelCompatibilityInfo"),
                    onnxruntime_all_h.C_POINTER.withName("CreateAllocator"),
                    onnxruntime_all_h.C_POINTER.withName("ReleaseAllocator"),
                    onnxruntime_all_h.C_POINTER.withName("CreateDataTransfer"),
                    onnxruntime_all_h.C_POINTER.withName("IsStreamAware"),
                    onnxruntime_all_h.C_POINTER.withName("CreateSyncStreamForDevice"),
                    onnxruntime_all_h.C_POINTER.withName("GetHardwareDeviceIncompatibilityDetails"),
                    onnxruntime_all_h.C_POINTER.withName("CreateExternalResourceImporterForDevice"),
                    onnxruntime_all_h.C_POINTER.withName("GetNumCustomOpDomains"),
                    onnxruntime_all_h.C_POINTER.withName("GetCustomOpDomains"))
            .withName("OrtEpFactory");

    /**
     * The layout of this struct
     */
    public static final GroupLayout layout() {
        return $LAYOUT;
    }

    private static final OfInt ort_version_supported$LAYOUT =
            (OfInt) $LAYOUT.select(groupElement("ort_version_supported"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * uint32_t ort_version_supported
     * }
     */
    public static final OfInt ort_version_supported$layout() {
        return ort_version_supported$LAYOUT;
    }

    private static final long ort_version_supported$OFFSET = $LAYOUT.byteOffset(groupElement("ort_version_supported"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * uint32_t ort_version_supported
     * }
     */
    public static final long ort_version_supported$offset() {
        return ort_version_supported$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * uint32_t ort_version_supported
     * }
     */
    public static int ort_version_supported(MemorySegment struct) {
        return struct.get(ort_version_supported$LAYOUT, ort_version_supported$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * uint32_t ort_version_supported
     * }
     */
    public static void ort_version_supported(MemorySegment struct, int fieldValue) {
        struct.set(ort_version_supported$LAYOUT, ort_version_supported$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * const char *(*GetName)(const OrtEpFactory *)
     * }
     */
    public static final class GetName {

        private GetName() {
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
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout GetName$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("GetName"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * const char *(*GetName)(const OrtEpFactory *)
     * }
     */
    public static final AddressLayout GetName$layout() {
        return GetName$LAYOUT;
    }

    private static final long GetName$OFFSET = $LAYOUT.byteOffset(groupElement("GetName"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * const char *(*GetName)(const OrtEpFactory *)
     * }
     */
    public static final long GetName$offset() {
        return GetName$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * const char *(*GetName)(const OrtEpFactory *)
     * }
     */
    public static MemorySegment GetName(MemorySegment struct) {
        return struct.get(GetName$LAYOUT, GetName$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * const char *(*GetName)(const OrtEpFactory *)
     * }
     */
    public static void GetName(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetName$LAYOUT, GetName$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * const char *(*GetVendor)(const OrtEpFactory *)
     * }
     */
    public static final class GetVendor {

        private GetVendor() {
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
                onnxruntime_all_h.upcallHandle(GetVendor.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetVendor.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout GetVendor$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("GetVendor"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * const char *(*GetVendor)(const OrtEpFactory *)
     * }
     */
    public static final AddressLayout GetVendor$layout() {
        return GetVendor$LAYOUT;
    }

    private static final long GetVendor$OFFSET = $LAYOUT.byteOffset(groupElement("GetVendor"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * const char *(*GetVendor)(const OrtEpFactory *)
     * }
     */
    public static final long GetVendor$offset() {
        return GetVendor$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * const char *(*GetVendor)(const OrtEpFactory *)
     * }
     */
    public static MemorySegment GetVendor(MemorySegment struct) {
        return struct.get(GetVendor$LAYOUT, GetVendor$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * const char *(*GetVendor)(const OrtEpFactory *)
     * }
     */
    public static void GetVendor(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetVendor$LAYOUT, GetVendor$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*GetSupportedDevices)(OrtEpFactory *, const OrtHardwareDevice *const *, size_t, OrtEpDevice **, size_t, size_t *)
     * }
     */
    public static final class GetSupportedDevices {

        private GetSupportedDevices() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            MemorySegment apply(
                    MemorySegment _x0, MemorySegment _x1, long _x2, MemorySegment _x3, long _x4, MemorySegment _x5);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_LONG,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_LONG,
                onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetSupportedDevices.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetSupportedDevices.Function fi, Arena arena) {
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
                long _x2,
                MemorySegment _x3,
                long _x4,
                MemorySegment _x5) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0, _x1, _x2, _x3, _x4, _x5);
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout GetSupportedDevices$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetSupportedDevices"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*GetSupportedDevices)(OrtEpFactory *, const OrtHardwareDevice *const *, size_t, OrtEpDevice **, size_t, size_t *)
     * }
     */
    public static final AddressLayout GetSupportedDevices$layout() {
        return GetSupportedDevices$LAYOUT;
    }

    private static final long GetSupportedDevices$OFFSET = $LAYOUT.byteOffset(groupElement("GetSupportedDevices"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*GetSupportedDevices)(OrtEpFactory *, const OrtHardwareDevice *const *, size_t, OrtEpDevice **, size_t, size_t *)
     * }
     */
    public static final long GetSupportedDevices$offset() {
        return GetSupportedDevices$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*GetSupportedDevices)(OrtEpFactory *, const OrtHardwareDevice *const *, size_t, OrtEpDevice **, size_t, size_t *)
     * }
     */
    public static MemorySegment GetSupportedDevices(MemorySegment struct) {
        return struct.get(GetSupportedDevices$LAYOUT, GetSupportedDevices$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*GetSupportedDevices)(OrtEpFactory *, const OrtHardwareDevice *const *, size_t, OrtEpDevice **, size_t, size_t *)
     * }
     */
    public static void GetSupportedDevices(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetSupportedDevices$LAYOUT, GetSupportedDevices$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateEp)(OrtEpFactory *, const OrtHardwareDevice *const *, const OrtKeyValuePairs *const *, size_t, const OrtSessionOptions *, const OrtLogger *, OrtEp **)
     * }
     */
    public static final class CreateEp {

        private CreateEp() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            MemorySegment apply(
                    MemorySegment _x0,
                    MemorySegment _x1,
                    MemorySegment _x2,
                    long _x3,
                    MemorySegment _x4,
                    MemorySegment _x5,
                    MemorySegment _x6);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_LONG,
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
                onnxruntime_all_h.upcallHandle(CreateEp.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(CreateEp.Function fi, Arena arena) {
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
                long _x3,
                MemorySegment _x4,
                MemorySegment _x5,
                MemorySegment _x6) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0, _x1, _x2, _x3, _x4, _x5, _x6);
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout CreateEp$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("CreateEp"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateEp)(OrtEpFactory *, const OrtHardwareDevice *const *, const OrtKeyValuePairs *const *, size_t, const OrtSessionOptions *, const OrtLogger *, OrtEp **)
     * }
     */
    public static final AddressLayout CreateEp$layout() {
        return CreateEp$LAYOUT;
    }

    private static final long CreateEp$OFFSET = $LAYOUT.byteOffset(groupElement("CreateEp"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateEp)(OrtEpFactory *, const OrtHardwareDevice *const *, const OrtKeyValuePairs *const *, size_t, const OrtSessionOptions *, const OrtLogger *, OrtEp **)
     * }
     */
    public static final long CreateEp$offset() {
        return CreateEp$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateEp)(OrtEpFactory *, const OrtHardwareDevice *const *, const OrtKeyValuePairs *const *, size_t, const OrtSessionOptions *, const OrtLogger *, OrtEp **)
     * }
     */
    public static MemorySegment CreateEp(MemorySegment struct) {
        return struct.get(CreateEp$LAYOUT, CreateEp$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateEp)(OrtEpFactory *, const OrtHardwareDevice *const *, const OrtKeyValuePairs *const *, size_t, const OrtSessionOptions *, const OrtLogger *, OrtEp **)
     * }
     */
    public static void CreateEp(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(CreateEp$LAYOUT, CreateEp$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * void (*ReleaseEp)(OrtEpFactory *, struct OrtEp *)
     * }
     */
    public static final class ReleaseEp {

        private ReleaseEp() {
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
                onnxruntime_all_h.upcallHandle(ReleaseEp.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(ReleaseEp.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static void invoke(MemorySegment funcPtr, MemorySegment _x0, MemorySegment _x1) {
            try {
                DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout ReleaseEp$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("ReleaseEp"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * void (*ReleaseEp)(OrtEpFactory *, struct OrtEp *)
     * }
     */
    public static final AddressLayout ReleaseEp$layout() {
        return ReleaseEp$LAYOUT;
    }

    private static final long ReleaseEp$OFFSET = $LAYOUT.byteOffset(groupElement("ReleaseEp"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * void (*ReleaseEp)(OrtEpFactory *, struct OrtEp *)
     * }
     */
    public static final long ReleaseEp$offset() {
        return ReleaseEp$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * void (*ReleaseEp)(OrtEpFactory *, struct OrtEp *)
     * }
     */
    public static MemorySegment ReleaseEp(MemorySegment struct) {
        return struct.get(ReleaseEp$LAYOUT, ReleaseEp$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * void (*ReleaseEp)(OrtEpFactory *, struct OrtEp *)
     * }
     */
    public static void ReleaseEp(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(ReleaseEp$LAYOUT, ReleaseEp$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * uint32_t (*GetVendorId)(const OrtEpFactory *)
     * }
     */
    public static final class GetVendorId {

        private GetVendorId() {
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
                onnxruntime_all_h.upcallHandle(GetVendorId.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetVendorId.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static int invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                return (int) DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout GetVendorId$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("GetVendorId"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * uint32_t (*GetVendorId)(const OrtEpFactory *)
     * }
     */
    public static final AddressLayout GetVendorId$layout() {
        return GetVendorId$LAYOUT;
    }

    private static final long GetVendorId$OFFSET = $LAYOUT.byteOffset(groupElement("GetVendorId"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * uint32_t (*GetVendorId)(const OrtEpFactory *)
     * }
     */
    public static final long GetVendorId$offset() {
        return GetVendorId$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * uint32_t (*GetVendorId)(const OrtEpFactory *)
     * }
     */
    public static MemorySegment GetVendorId(MemorySegment struct) {
        return struct.get(GetVendorId$LAYOUT, GetVendorId$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * uint32_t (*GetVendorId)(const OrtEpFactory *)
     * }
     */
    public static void GetVendorId(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetVendorId$LAYOUT, GetVendorId$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * const char *(*GetVersion)(const OrtEpFactory *)
     * }
     */
    public static final class GetVersion {

        private GetVersion() {
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
                onnxruntime_all_h.upcallHandle(GetVersion.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetVersion.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout GetVersion$LAYOUT = (AddressLayout) $LAYOUT.select(groupElement("GetVersion"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * const char *(*GetVersion)(const OrtEpFactory *)
     * }
     */
    public static final AddressLayout GetVersion$layout() {
        return GetVersion$LAYOUT;
    }

    private static final long GetVersion$OFFSET = $LAYOUT.byteOffset(groupElement("GetVersion"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * const char *(*GetVersion)(const OrtEpFactory *)
     * }
     */
    public static final long GetVersion$offset() {
        return GetVersion$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * const char *(*GetVersion)(const OrtEpFactory *)
     * }
     */
    public static MemorySegment GetVersion(MemorySegment struct) {
        return struct.get(GetVersion$LAYOUT, GetVersion$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * const char *(*GetVersion)(const OrtEpFactory *)
     * }
     */
    public static void GetVersion(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetVersion$LAYOUT, GetVersion$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*ValidateCompiledModelCompatibilityInfo)(OrtEpFactory *, const OrtHardwareDevice *const *, size_t, const char *, OrtCompiledModelCompatibility *)
     * }
     */
    public static final class ValidateCompiledModelCompatibilityInfo {

        private ValidateCompiledModelCompatibilityInfo() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            MemorySegment apply(MemorySegment _x0, MemorySegment _x1, long _x2, MemorySegment _x3, MemorySegment _x4);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_LONG,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(ValidateCompiledModelCompatibilityInfo.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(ValidateCompiledModelCompatibilityInfo.Function fi, Arena arena) {
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
                long _x2,
                MemorySegment _x3,
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

    private static final AddressLayout ValidateCompiledModelCompatibilityInfo$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("ValidateCompiledModelCompatibilityInfo"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ValidateCompiledModelCompatibilityInfo)(OrtEpFactory *, const OrtHardwareDevice *const *, size_t, const char *, OrtCompiledModelCompatibility *)
     * }
     */
    public static final AddressLayout ValidateCompiledModelCompatibilityInfo$layout() {
        return ValidateCompiledModelCompatibilityInfo$LAYOUT;
    }

    private static final long ValidateCompiledModelCompatibilityInfo$OFFSET =
            $LAYOUT.byteOffset(groupElement("ValidateCompiledModelCompatibilityInfo"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ValidateCompiledModelCompatibilityInfo)(OrtEpFactory *, const OrtHardwareDevice *const *, size_t, const char *, OrtCompiledModelCompatibility *)
     * }
     */
    public static final long ValidateCompiledModelCompatibilityInfo$offset() {
        return ValidateCompiledModelCompatibilityInfo$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ValidateCompiledModelCompatibilityInfo)(OrtEpFactory *, const OrtHardwareDevice *const *, size_t, const char *, OrtCompiledModelCompatibility *)
     * }
     */
    public static MemorySegment ValidateCompiledModelCompatibilityInfo(MemorySegment struct) {
        return struct.get(ValidateCompiledModelCompatibilityInfo$LAYOUT, ValidateCompiledModelCompatibilityInfo$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*ValidateCompiledModelCompatibilityInfo)(OrtEpFactory *, const OrtHardwareDevice *const *, size_t, const char *, OrtCompiledModelCompatibility *)
     * }
     */
    public static void ValidateCompiledModelCompatibilityInfo(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(
                ValidateCompiledModelCompatibilityInfo$LAYOUT,
                ValidateCompiledModelCompatibilityInfo$OFFSET,
                fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateAllocator)(OrtEpFactory *, const OrtMemoryInfo *, const OrtKeyValuePairs *, OrtAllocator **)
     * }
     */
    public static final class CreateAllocator {

        private CreateAllocator() {
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
                onnxruntime_all_h.upcallHandle(CreateAllocator.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(CreateAllocator.Function fi, Arena arena) {
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

    private static final AddressLayout CreateAllocator$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("CreateAllocator"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateAllocator)(OrtEpFactory *, const OrtMemoryInfo *, const OrtKeyValuePairs *, OrtAllocator **)
     * }
     */
    public static final AddressLayout CreateAllocator$layout() {
        return CreateAllocator$LAYOUT;
    }

    private static final long CreateAllocator$OFFSET = $LAYOUT.byteOffset(groupElement("CreateAllocator"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateAllocator)(OrtEpFactory *, const OrtMemoryInfo *, const OrtKeyValuePairs *, OrtAllocator **)
     * }
     */
    public static final long CreateAllocator$offset() {
        return CreateAllocator$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateAllocator)(OrtEpFactory *, const OrtMemoryInfo *, const OrtKeyValuePairs *, OrtAllocator **)
     * }
     */
    public static MemorySegment CreateAllocator(MemorySegment struct) {
        return struct.get(CreateAllocator$LAYOUT, CreateAllocator$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateAllocator)(OrtEpFactory *, const OrtMemoryInfo *, const OrtKeyValuePairs *, OrtAllocator **)
     * }
     */
    public static void CreateAllocator(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(CreateAllocator$LAYOUT, CreateAllocator$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * void (*ReleaseAllocator)(OrtEpFactory *, OrtAllocator *)
     * }
     */
    public static final class ReleaseAllocator {

        private ReleaseAllocator() {
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
                onnxruntime_all_h.upcallHandle(ReleaseAllocator.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(ReleaseAllocator.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static void invoke(MemorySegment funcPtr, MemorySegment _x0, MemorySegment _x1) {
            try {
                DOWN$MH.invokeExact(funcPtr, _x0, _x1);
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout ReleaseAllocator$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("ReleaseAllocator"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * void (*ReleaseAllocator)(OrtEpFactory *, OrtAllocator *)
     * }
     */
    public static final AddressLayout ReleaseAllocator$layout() {
        return ReleaseAllocator$LAYOUT;
    }

    private static final long ReleaseAllocator$OFFSET = $LAYOUT.byteOffset(groupElement("ReleaseAllocator"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * void (*ReleaseAllocator)(OrtEpFactory *, OrtAllocator *)
     * }
     */
    public static final long ReleaseAllocator$offset() {
        return ReleaseAllocator$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * void (*ReleaseAllocator)(OrtEpFactory *, OrtAllocator *)
     * }
     */
    public static MemorySegment ReleaseAllocator(MemorySegment struct) {
        return struct.get(ReleaseAllocator$LAYOUT, ReleaseAllocator$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * void (*ReleaseAllocator)(OrtEpFactory *, OrtAllocator *)
     * }
     */
    public static void ReleaseAllocator(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(ReleaseAllocator$LAYOUT, ReleaseAllocator$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateDataTransfer)(OrtEpFactory *, OrtDataTransferImpl **)
     * }
     */
    public static final class CreateDataTransfer {

        private CreateDataTransfer() {
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
                onnxruntime_all_h.upcallHandle(CreateDataTransfer.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(CreateDataTransfer.Function fi, Arena arena) {
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

    private static final AddressLayout CreateDataTransfer$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("CreateDataTransfer"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateDataTransfer)(OrtEpFactory *, OrtDataTransferImpl **)
     * }
     */
    public static final AddressLayout CreateDataTransfer$layout() {
        return CreateDataTransfer$LAYOUT;
    }

    private static final long CreateDataTransfer$OFFSET = $LAYOUT.byteOffset(groupElement("CreateDataTransfer"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateDataTransfer)(OrtEpFactory *, OrtDataTransferImpl **)
     * }
     */
    public static final long CreateDataTransfer$offset() {
        return CreateDataTransfer$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateDataTransfer)(OrtEpFactory *, OrtDataTransferImpl **)
     * }
     */
    public static MemorySegment CreateDataTransfer(MemorySegment struct) {
        return struct.get(CreateDataTransfer$LAYOUT, CreateDataTransfer$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateDataTransfer)(OrtEpFactory *, OrtDataTransferImpl **)
     * }
     */
    public static void CreateDataTransfer(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(CreateDataTransfer$LAYOUT, CreateDataTransfer$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * bool (*IsStreamAware)(const OrtEpFactory *)
     * }
     */
    public static final class IsStreamAware {

        private IsStreamAware() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            boolean apply(MemorySegment _x0);
        }

        private static final FunctionDescriptor $DESC =
                FunctionDescriptor.of(onnxruntime_all_h.C_BOOL, onnxruntime_all_h.C_POINTER);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(IsStreamAware.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(IsStreamAware.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static boolean invoke(MemorySegment funcPtr, MemorySegment _x0) {
            try {
                return (boolean) DOWN$MH.invokeExact(funcPtr, _x0);
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout IsStreamAware$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("IsStreamAware"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * bool (*IsStreamAware)(const OrtEpFactory *)
     * }
     */
    public static final AddressLayout IsStreamAware$layout() {
        return IsStreamAware$LAYOUT;
    }

    private static final long IsStreamAware$OFFSET = $LAYOUT.byteOffset(groupElement("IsStreamAware"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * bool (*IsStreamAware)(const OrtEpFactory *)
     * }
     */
    public static final long IsStreamAware$offset() {
        return IsStreamAware$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * bool (*IsStreamAware)(const OrtEpFactory *)
     * }
     */
    public static MemorySegment IsStreamAware(MemorySegment struct) {
        return struct.get(IsStreamAware$LAYOUT, IsStreamAware$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * bool (*IsStreamAware)(const OrtEpFactory *)
     * }
     */
    public static void IsStreamAware(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(IsStreamAware$LAYOUT, IsStreamAware$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateSyncStreamForDevice)(OrtEpFactory *, const OrtMemoryDevice *, const OrtKeyValuePairs *, OrtSyncStreamImpl **)
     * }
     */
    public static final class CreateSyncStreamForDevice {

        private CreateSyncStreamForDevice() {
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
                onnxruntime_all_h.upcallHandle(CreateSyncStreamForDevice.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(CreateSyncStreamForDevice.Function fi, Arena arena) {
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

    private static final AddressLayout CreateSyncStreamForDevice$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("CreateSyncStreamForDevice"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateSyncStreamForDevice)(OrtEpFactory *, const OrtMemoryDevice *, const OrtKeyValuePairs *, OrtSyncStreamImpl **)
     * }
     */
    public static final AddressLayout CreateSyncStreamForDevice$layout() {
        return CreateSyncStreamForDevice$LAYOUT;
    }

    private static final long CreateSyncStreamForDevice$OFFSET =
            $LAYOUT.byteOffset(groupElement("CreateSyncStreamForDevice"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateSyncStreamForDevice)(OrtEpFactory *, const OrtMemoryDevice *, const OrtKeyValuePairs *, OrtSyncStreamImpl **)
     * }
     */
    public static final long CreateSyncStreamForDevice$offset() {
        return CreateSyncStreamForDevice$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateSyncStreamForDevice)(OrtEpFactory *, const OrtMemoryDevice *, const OrtKeyValuePairs *, OrtSyncStreamImpl **)
     * }
     */
    public static MemorySegment CreateSyncStreamForDevice(MemorySegment struct) {
        return struct.get(CreateSyncStreamForDevice$LAYOUT, CreateSyncStreamForDevice$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateSyncStreamForDevice)(OrtEpFactory *, const OrtMemoryDevice *, const OrtKeyValuePairs *, OrtSyncStreamImpl **)
     * }
     */
    public static void CreateSyncStreamForDevice(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(CreateSyncStreamForDevice$LAYOUT, CreateSyncStreamForDevice$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*GetHardwareDeviceIncompatibilityDetails)(OrtEpFactory *, const OrtHardwareDevice *, OrtDeviceEpIncompatibilityDetails *)
     * }
     */
    public static final class GetHardwareDeviceIncompatibilityDetails {

        private GetHardwareDeviceIncompatibilityDetails() {
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
                onnxruntime_all_h.upcallHandle(GetHardwareDeviceIncompatibilityDetails.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetHardwareDeviceIncompatibilityDetails.Function fi, Arena arena) {
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

    private static final AddressLayout GetHardwareDeviceIncompatibilityDetails$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetHardwareDeviceIncompatibilityDetails"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*GetHardwareDeviceIncompatibilityDetails)(OrtEpFactory *, const OrtHardwareDevice *, OrtDeviceEpIncompatibilityDetails *)
     * }
     */
    public static final AddressLayout GetHardwareDeviceIncompatibilityDetails$layout() {
        return GetHardwareDeviceIncompatibilityDetails$LAYOUT;
    }

    private static final long GetHardwareDeviceIncompatibilityDetails$OFFSET =
            $LAYOUT.byteOffset(groupElement("GetHardwareDeviceIncompatibilityDetails"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*GetHardwareDeviceIncompatibilityDetails)(OrtEpFactory *, const OrtHardwareDevice *, OrtDeviceEpIncompatibilityDetails *)
     * }
     */
    public static final long GetHardwareDeviceIncompatibilityDetails$offset() {
        return GetHardwareDeviceIncompatibilityDetails$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*GetHardwareDeviceIncompatibilityDetails)(OrtEpFactory *, const OrtHardwareDevice *, OrtDeviceEpIncompatibilityDetails *)
     * }
     */
    public static MemorySegment GetHardwareDeviceIncompatibilityDetails(MemorySegment struct) {
        return struct.get(
                GetHardwareDeviceIncompatibilityDetails$LAYOUT, GetHardwareDeviceIncompatibilityDetails$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*GetHardwareDeviceIncompatibilityDetails)(OrtEpFactory *, const OrtHardwareDevice *, OrtDeviceEpIncompatibilityDetails *)
     * }
     */
    public static void GetHardwareDeviceIncompatibilityDetails(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(
                GetHardwareDeviceIncompatibilityDetails$LAYOUT,
                GetHardwareDeviceIncompatibilityDetails$OFFSET,
                fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateExternalResourceImporterForDevice)(OrtEpFactory *, const OrtEpDevice *, OrtExternalResourceImporterImpl **)
     * }
     */
    public static final class CreateExternalResourceImporterForDevice {

        private CreateExternalResourceImporterForDevice() {
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
                onnxruntime_all_h.upcallHandle(CreateExternalResourceImporterForDevice.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(CreateExternalResourceImporterForDevice.Function fi, Arena arena) {
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

    private static final AddressLayout CreateExternalResourceImporterForDevice$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("CreateExternalResourceImporterForDevice"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateExternalResourceImporterForDevice)(OrtEpFactory *, const OrtEpDevice *, OrtExternalResourceImporterImpl **)
     * }
     */
    public static final AddressLayout CreateExternalResourceImporterForDevice$layout() {
        return CreateExternalResourceImporterForDevice$LAYOUT;
    }

    private static final long CreateExternalResourceImporterForDevice$OFFSET =
            $LAYOUT.byteOffset(groupElement("CreateExternalResourceImporterForDevice"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateExternalResourceImporterForDevice)(OrtEpFactory *, const OrtEpDevice *, OrtExternalResourceImporterImpl **)
     * }
     */
    public static final long CreateExternalResourceImporterForDevice$offset() {
        return CreateExternalResourceImporterForDevice$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateExternalResourceImporterForDevice)(OrtEpFactory *, const OrtEpDevice *, OrtExternalResourceImporterImpl **)
     * }
     */
    public static MemorySegment CreateExternalResourceImporterForDevice(MemorySegment struct) {
        return struct.get(
                CreateExternalResourceImporterForDevice$LAYOUT, CreateExternalResourceImporterForDevice$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*CreateExternalResourceImporterForDevice)(OrtEpFactory *, const OrtEpDevice *, OrtExternalResourceImporterImpl **)
     * }
     */
    public static void CreateExternalResourceImporterForDevice(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(
                CreateExternalResourceImporterForDevice$LAYOUT,
                CreateExternalResourceImporterForDevice$OFFSET,
                fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*GetNumCustomOpDomains)(OrtEpFactory *, size_t *)
     * }
     */
    public static final class GetNumCustomOpDomains {

        private GetNumCustomOpDomains() {
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
                onnxruntime_all_h.upcallHandle(GetNumCustomOpDomains.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetNumCustomOpDomains.Function fi, Arena arena) {
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

    private static final AddressLayout GetNumCustomOpDomains$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetNumCustomOpDomains"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*GetNumCustomOpDomains)(OrtEpFactory *, size_t *)
     * }
     */
    public static final AddressLayout GetNumCustomOpDomains$layout() {
        return GetNumCustomOpDomains$LAYOUT;
    }

    private static final long GetNumCustomOpDomains$OFFSET = $LAYOUT.byteOffset(groupElement("GetNumCustomOpDomains"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*GetNumCustomOpDomains)(OrtEpFactory *, size_t *)
     * }
     */
    public static final long GetNumCustomOpDomains$offset() {
        return GetNumCustomOpDomains$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*GetNumCustomOpDomains)(OrtEpFactory *, size_t *)
     * }
     */
    public static MemorySegment GetNumCustomOpDomains(MemorySegment struct) {
        return struct.get(GetNumCustomOpDomains$LAYOUT, GetNumCustomOpDomains$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*GetNumCustomOpDomains)(OrtEpFactory *, size_t *)
     * }
     */
    public static void GetNumCustomOpDomains(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetNumCustomOpDomains$LAYOUT, GetNumCustomOpDomains$OFFSET, fieldValue);
    }

    /**
     * {@snippet lang=c :
     * OrtStatusPtr (*GetCustomOpDomains)(OrtEpFactory *, OrtCustomOpDomain **, size_t)
     * }
     */
    public static final class GetCustomOpDomains {

        private GetCustomOpDomains() {
            // Should not be called directly
        }

        /**
         * The function pointer signature, expressed as a functional interface
         */
        public interface Function {
            MemorySegment apply(MemorySegment _x0, MemorySegment _x1, long _x2);
        }

        private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_POINTER,
                onnxruntime_all_h.C_LONG);

        /**
         * The descriptor of this function pointer
         */
        public static FunctionDescriptor descriptor() {
            return $DESC;
        }

        private static final MethodHandle UP$MH =
                onnxruntime_all_h.upcallHandle(GetCustomOpDomains.Function.class, "apply", $DESC);

        /**
         * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
         * The lifetime of the returned segment is managed by {@code arena}
         */
        public static MemorySegment allocate(GetCustomOpDomains.Function fi, Arena arena) {
            return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
        }

        private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

        /**
         * Invoke the upcall stub {@code funcPtr}, with given parameters
         */
        public static MemorySegment invoke(MemorySegment funcPtr, MemorySegment _x0, MemorySegment _x1, long _x2) {
            try {
                return (MemorySegment) DOWN$MH.invokeExact(funcPtr, _x0, _x1, _x2);
            } catch (Error | RuntimeException ex) {
                throw ex;
            } catch (Throwable ex$) {
                throw new AssertionError("should not reach here", ex$);
            }
        }
    }

    private static final AddressLayout GetCustomOpDomains$LAYOUT =
            (AddressLayout) $LAYOUT.select(groupElement("GetCustomOpDomains"));

    /**
     * Layout for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*GetCustomOpDomains)(OrtEpFactory *, OrtCustomOpDomain **, size_t)
     * }
     */
    public static final AddressLayout GetCustomOpDomains$layout() {
        return GetCustomOpDomains$LAYOUT;
    }

    private static final long GetCustomOpDomains$OFFSET = $LAYOUT.byteOffset(groupElement("GetCustomOpDomains"));

    /**
     * Offset for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*GetCustomOpDomains)(OrtEpFactory *, OrtCustomOpDomain **, size_t)
     * }
     */
    public static final long GetCustomOpDomains$offset() {
        return GetCustomOpDomains$OFFSET;
    }

    /**
     * Getter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*GetCustomOpDomains)(OrtEpFactory *, OrtCustomOpDomain **, size_t)
     * }
     */
    public static MemorySegment GetCustomOpDomains(MemorySegment struct) {
        return struct.get(GetCustomOpDomains$LAYOUT, GetCustomOpDomains$OFFSET);
    }

    /**
     * Setter for field:
     * {@snippet lang=c :
     * OrtStatusPtr (*GetCustomOpDomains)(OrtEpFactory *, OrtCustomOpDomain **, size_t)
     * }
     */
    public static void GetCustomOpDomains(MemorySegment struct, MemorySegment fieldValue) {
        struct.set(GetCustomOpDomains$LAYOUT, GetCustomOpDomains$OFFSET, fieldValue);
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
