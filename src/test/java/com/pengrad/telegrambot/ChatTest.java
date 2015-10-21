package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.UserOrGroupChat;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class ChatTest {

    public static void checkChat(UserOrGroupChat chat) {
        assertNotNull(chat.id);
    }

}
