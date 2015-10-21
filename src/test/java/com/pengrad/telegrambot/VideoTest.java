package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Video;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class VideoTest {

    public static void check(Video video) {
        assertNotNull(video.fileId());
        assertNotNull(video.duration());
        assertNotNull(video.width());
        assertNotNull(video.height());
        assertNotNull(video.fileSize());
    }
}
