package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Voice;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class VoiceTest {

    public static void check(Voice voice) {
        assertNotNull(voice.fileId());
        assertNotNull(voice.fileSize());
        assertNotNull(voice.mimeType());
        assertNotNull(voice.duration());
    }

}
