package com.pengrad.telegrambot.checks;

import com.pengrad.telegrambot.model.*;

import static org.junit.Assert.*;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class GameTest {

    public static void check(Game game) {
        assertNotNull(game.title());
        assertNotNull(game.description());
        assertNotNull(game.text());
        assertNotNull(game.textEntities());
        PhotoSizeTest.checkPhotos(game.photo());
        AnimationCheck.check(game.animation());
    }

}
