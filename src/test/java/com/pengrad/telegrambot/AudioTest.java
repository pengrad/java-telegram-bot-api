package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Audio;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class AudioTest {

    public static void checkAudio(Audio audio) {
        assertNotNull(audio.fileId());
        assertNotNull(audio.duration());
        assertNotNull(audio.performer());
        assertNotNull(audio.title());
        assertNotNull(audio.fileSize());
        assertNotNull(audio.mimeType());
    }

}
