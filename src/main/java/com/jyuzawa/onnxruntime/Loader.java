/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * All rights reserved. Licensed under the MIT License.
 */
package com.jyuzawa.onnxruntime;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

final class Loader {

    static void load() {
        try {
            String arch = normalizeArch(System.getProperty("os.arch", ""));
            String os = normalizeOs(System.getProperty("os.name", ""));
            String resourcePrefix = "com/jyuzawa/onnxruntime/native/" + os + "-" + arch + "/";

            ClassLoader classLoader = Loader.class.getClassLoader();
            try (InputStream inputStream = classLoader.getResourceAsStream(resourcePrefix + "libraries")) {
                if (inputStream == null) {
                    // not found, fall back to lib path
                    System.loadLibrary("onnxruntime");
                    return;
                }
                Path tempDir = Files.createTempDirectory("onnxruntime-java");
                tempDir.toAbsolutePath().toFile().deleteOnExit();
                try (Scanner scanner = new Scanner(inputStream)) {
                    while (scanner.hasNext()) {
                        String fileName = scanner.next();
                        String resource = resourcePrefix + fileName;
                        Path filePath = tempDir.resolve(fileName);
                        filePath.toAbsolutePath().toFile().deleteOnExit();
                        try (InputStream objStream = classLoader.getResourceAsStream(resource)) {
                            Files.copy(objStream, filePath);
                        }
                    }
                }
                String libraryPath = tempDir.resolve(System.mapLibraryName("onnxruntime"))
                        .toAbsolutePath()
                        .toString();
                System.load(libraryPath);
            }
        } catch (IOException e) {
            throw new UnsatisfiedLinkError("Failed to load onnxruntime");
        }
    }

    private static String normalize(String value) {
        return value.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
    }

    private static String normalizeArch(String value) {
        value = normalize(value);
        if (value.matches("^(x8664|amd64|ia32e|em64t|x64)$")) {
            return "x86_64";
        }
        if ("aarch64".equals(value)) {
            return "aarch_64";
        }
        throw new UnsupportedOperationException("Architecture is not supported");
    }

    private static String normalizeOs(String value) {
        value = normalize(value);
        if (value.startsWith("linux")) {
            return "linux";
        }
        if (value.startsWith("macosx") || value.startsWith("osx") || value.startsWith("darwin")) {
            return "osx";
        }
        if (value.startsWith("windows")) {
            return "windows";
        }
        throw new UnsupportedOperationException("Operating system is not supported");
    }
}
