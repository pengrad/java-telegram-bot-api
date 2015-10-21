package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Audio;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class AudioTest {

    public static void checkAudio(Audio audio) {
        assertNotNull(audio.file_id);
        assertNotNull(audio.duration);
        assertNotNull(audio.file_size);
        assertNotNull(audio.mime_type);
    }

}
