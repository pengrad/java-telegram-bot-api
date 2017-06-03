package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Audio;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class AudioTest {

    public static void checkAudio(Audio audio, boolean performer) {
        assertNotNull(audio.fileId());
        assertNotNull(audio.duration());
        assertNotNull(audio.title());
        assertNotNull(audio.fileSize());
        assertNotNull(audio.mimeType());
        if (performer) assertNotNull(audio.performer());
    }

}
