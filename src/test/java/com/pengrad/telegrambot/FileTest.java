package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.File;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class FileTest {

    public static void check(File file) {
        assertNotNull(file.fileId());
        assertNotNull(file.fileSize());
        assertNotNull(file.filePath());
    }
}
