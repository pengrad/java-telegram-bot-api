package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Sticker;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class StickerTest {

    public static void check(Sticker sticker) {
        assertNotNull(sticker.file_id);
        assertNotNull(sticker.width);
        assertNotNull(sticker.height);
        assertNotNull(sticker.file_size);
        PhotoSizeTest.checkPhotos(sticker.thumb);
    }
}
