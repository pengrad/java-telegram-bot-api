package com.pengrad.telegrambot.checks;

import com.pengrad.telegrambot.model.Chat;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class ChatTest {

    public static void checkChat(Chat chat) {
        checkChat(chat, chat.photo() != null);
    }

    public static void checkChat(Chat chat, boolean photo) {
        assertNotNull(chat.id());
        assertNotNull(chat.type());
        if (photo) ChatPhotoTest.check(chat.photo());
    }

}
