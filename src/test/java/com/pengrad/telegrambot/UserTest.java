package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.User;

import static org.junit.Assert.assertNotNull;


/**
 * stas
 * 10/20/15.
 */
public class UserTest {

    public static void checkUser(User user) {
        assertNotNull(user.id());
        assertNotNull(user.firstName());
        assertNotNull(user.username());
    }

}
