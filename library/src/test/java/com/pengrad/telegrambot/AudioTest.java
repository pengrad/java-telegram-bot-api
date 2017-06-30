package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Audio;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class AudioTest {

    public static void checkAudio(Audio audio) {
        checkAudio(audio, true, true);
    }

    public static void checkAudio(Audio audio, boolean performer, boolean checkSize) {
        assertNotNull(audio.fileId());
        assertNotNull(audio.duration());
        assertNotNull(audio.title());
        assertNotNull(audio.mimeType());
        if (checkSize) assertNotNull(audio.fileSize());
        if (performer) assertNotNull(audio.performer());
    }
}
