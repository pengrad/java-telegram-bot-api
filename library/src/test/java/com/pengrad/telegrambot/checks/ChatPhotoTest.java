package com.pengrad.telegrambot.checks;

import com.pengrad.telegrambot.model.ChatPhoto;

import static org.junit.Assert.assertNotNull;

/**
 * Stas Parshin
 * 01 July 2017
 */
public class ChatPhotoTest {

    public static void check(ChatPhoto photo) {
        assertNotNull(photo.smallFileId());
        assertNotNull(photo.smallFileUniqueId());
        assertNotNull(photo.bigFileId());
        assertNotNull(photo.bigFileUniqueId());
    }

}
