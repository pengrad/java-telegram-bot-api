package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.PhotoSize;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class PhotoSizeTest {


    public static void checkPhotos(PhotoSize... photos) {
        for (PhotoSize photo : photos) {
            assertNotNull(photo.fileId());
            assertNotNull(photo.width());
            assertNotNull(photo.height());
        }
    }
}
