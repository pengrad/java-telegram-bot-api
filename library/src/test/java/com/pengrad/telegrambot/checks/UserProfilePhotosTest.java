package com.pengrad.telegrambot.checks;

import com.pengrad.telegrambot.model.PhotoSize;
import com.pengrad.telegrambot.model.UserProfilePhotos;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class UserProfilePhotosTest {

    public static void check(UserProfilePhotos profilePhotos) {
        assertNotNull(profilePhotos.totalCount());
        for (PhotoSize[] photos : profilePhotos.photos()) {
            PhotoSizeTest.checkPhotos(photos);
        }
    }
}
