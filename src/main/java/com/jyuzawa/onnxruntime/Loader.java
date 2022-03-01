/*
 * Copyright (c) 2022 James Yuzawa (https://www.jyuzawa.com/)
 * SPDX-License-Identifier: MIT
 */
package com.jyuzawa.onnxruntime;

import java.io.IOException;
import java.io.InputStream;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

final class Loader {

    private static final Logger LOG = System.getLogger(Loader.class.getName());

    static void load() {
        try {
            String arch = normalizeArch(System.getProperty("os.arch", ""));
            String os = normalizeOs(System.getProperty("os.name", ""));
            LOG.log(Level.DEBUG, "OS: " + os + ", Architecture: " + arch);
            Class<Loader> clazz = Loader.class;
            String packagePath = clazz.getPackage().getName().replaceAll("\\.", "/");
            String resourcePrefix = packagePath + "/native/" + os + "-" + arch + "/";
            LOG.log(Level.DEBUG, "Searching for distributed libraries using resource prefix " + resourcePrefix);
            ClassLoader classLoader = clazz.getClassLoader();
            try (InputStream inputStream = classLoader.getResourceAsStream(resourcePrefix + "libraries")) {
                if (inputStream == null) {
                    LOG.log(Level.DEBUG, "No distributed packages, falling back to System.loadLibrary()");
                    // not found, fall back to lib path
                    System.loadLibrary("onnxruntime");
                    return;
                }
                Path tempDir = Files.createTempDirectory("onnxruntime-java").toAbsolutePath();
                tempDir.toFile().deleteOnExit();
                try (Scanner scanner = new Scanner(inputStream)) {
                    while (scanner.hasNext()) {
                        String fileName = scanner.next();
                        String resource = resourcePrefix + fileName;
                        Path filePath = tempDir.resolve(fileName).toAbsolutePath();
                        LOG.log(Level.DEBUG, "Copying " + filePath);
                        filePath.toFile().deleteOnExit();
                        try (InputStream objStream = classLoader.getResourceAsStream(resource)) {
                            Files.copy(objStream, filePath);
                        }
                    }
                }
                String libraryPath = tempDir.resolve(System.mapLibraryName("onnxruntime"))
                        .toAbsolutePath()
                        .toString();
                LOG.log(Level.DEBUG, "Loading " + libraryPath);
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
