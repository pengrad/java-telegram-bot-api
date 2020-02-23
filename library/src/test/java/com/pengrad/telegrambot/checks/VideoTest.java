package com.pengrad.telegrambot.checks;

import com.pengrad.telegrambot.model.Video;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class VideoTest {

    public static void check(Video video) {
        check(video, true);
    }

    public static void check(Video video, boolean checkSize) {
        assertNotNull(video.fileId());
        assertNotNull(video.fileUniqueId());
        assertNotNull(video.duration());
        assertNotNull(video.width());
        assertNotNull(video.height());
        if (checkSize) assertNotNull(video.fileSize());
        PhotoSizeTest.checkPhotos(video.thumb());
    }
}
