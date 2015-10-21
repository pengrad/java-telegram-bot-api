package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Video;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class VideoTest {

    public static void check(Video video) {
        assertNotNull(video.file_id);
        assertNotNull(video.duration);
        assertNotNull(video.width);
        assertNotNull(video.height);
        assertNotNull(video.file_size);
    }
}
