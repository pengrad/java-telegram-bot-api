package com.pengrad.telegrambot.checks;

import com.pengrad.telegrambot.model.PhotoSize;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class PhotoSizeTest {

    public static void checkPhotos(PhotoSize... photos) {
        checkPhotos(true, photos);
    }

    public static void checkPhotos(boolean checkSize, PhotoSize... photos) {
        for (PhotoSize photo : photos) {
            assertNotNull(photo.fileId());
            assertNotNull(photo.fileUniqueId());
            assertNotNull(photo.width());
            assertNotNull(photo.height());
            if (checkSize) assertNotNull(photo.fileSize());
        }
    }
}
