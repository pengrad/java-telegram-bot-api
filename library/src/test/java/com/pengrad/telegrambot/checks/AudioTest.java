package com.pengrad.telegrambot.checks;

import com.pengrad.telegrambot.model.Audio;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class AudioTest {

    public static void checkAudio(Audio audio) {
        checkAudio(audio, true);
    }

    public static void checkAudio(Audio audio, boolean thumb) {
        assertNotNull(audio.fileId());
        assertNotNull(audio.fileUniqueId());
        assertNotNull(audio.duration());
        assertNotNull(audio.title());
        assertNotNull(audio.mimeType());
        assertNotNull(audio.fileSize());
        assertNotNull(audio.performer());
        if (thumb) assertNotNull(audio.thumb());
    }
}
