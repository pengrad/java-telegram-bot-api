package com.pengrad.telegrambot.checks;

import com.pengrad.telegrambot.model.Location;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class LocationTest {


    public static void check(Location location) {
        assertNotNull(location.latitude());
        assertNotNull(location.longitude());
    }
}
