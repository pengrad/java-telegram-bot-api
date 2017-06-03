package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Game;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class GameTest {

    public static void check(Game game) {
        assertNotNull(game.title());
        assertNotNull(game.description());
        assertNull(game.text());
        assertNull(game.textEntities());
        assertNull(game.animation());
        PhotoSizeTest.checkPhotos(game.photo());
    }

}
