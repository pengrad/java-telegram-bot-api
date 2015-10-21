package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Update;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class UpdateTest {

    public static void check(List<Update> updates) {
        for (Update update : updates) {
            assertNotNull(update.updateId());
            MessageTest.checkMessage(update.message());
        }
    }

}
