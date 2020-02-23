package com.pengrad.telegrambot.checks;

import com.pengrad.telegrambot.model.User;

import static org.junit.Assert.assertNotNull;


/**
 * stas
 * 10/20/15.
 */
public class UserTest {

    public static void checkUser(User user) {
        checkUser(user, false);
    }

    public static void checkUser(User user, boolean full) {
        assertNotNull(user.id());
        assertNotNull(user.isBot());
        assertNotNull(user.firstName());
        assertNotNull(user.username());
        if (full) {
            assertNotNull(user.lastName());
            assertNotNull(user.languageCode());
        }
    }

}
