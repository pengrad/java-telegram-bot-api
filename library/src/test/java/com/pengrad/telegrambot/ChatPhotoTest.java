package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.ChatPhoto;

import static org.junit.Assert.assertNotNull;

/**
 * Stas Parshin
 * 01 July 2017
 */
public class ChatPhotoTest {

    public static void check(ChatPhoto photo) {
        assertNotNull(photo.smallFileId());
        assertNotNull(photo.bigFileId());
    }

}
