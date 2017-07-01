package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Chat;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class ChatTest {

    public static void checkChat(Chat chat) {
        assertNotNull(chat.id());
        assertNotNull(chat.type());
        if (chat.photo() != null) ChatPhotoTest.check(chat.photo());
    }

}
