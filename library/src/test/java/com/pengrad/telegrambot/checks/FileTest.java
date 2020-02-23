package com.pengrad.telegrambot.checks;

import com.pengrad.telegrambot.model.File;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class FileTest {

    public static void check(File file) {
        check(file, true);
    }

    public static void check(File file, boolean path) {
        assertNotNull(file.fileId());
        assertNotNull(file.fileUniqueId());
        assertNotNull(file.fileSize());
        if (path) assertNotNull(file.filePath());
    }
}
