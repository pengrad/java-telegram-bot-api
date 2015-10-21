package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Document;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class DocumentTest {

    public static void check(Document document) {
        assertNotNull(document.file_id);
        assertNotNull(document.file_name);
        assertNotNull(document.file_size);
        assertNotNull(document.mime_type);
    }

}
