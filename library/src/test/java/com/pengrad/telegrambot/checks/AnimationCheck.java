package com.pengrad.telegrambot.checks;

import com.pengrad.telegrambot.model.Animation;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Stas Parshin
 * 04 June 2017
 */
public class AnimationCheck {

    public static void check(Animation animation) {
        assertNotNull(animation.fileId());
        assertNotNull(animation.fileUniqueId());
        assertNotNull(animation.fileName());
        assertNotNull(animation.mimeType());
        assertTrue(animation.fileSize() > 0);
        PhotoSizeTest.checkPhotos(animation.thumb());
    }

}
