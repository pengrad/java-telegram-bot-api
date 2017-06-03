package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Message;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class MessageTest {

    public static void checkMessage(Message message) {
        assertNotNull(message.messageId());
        assertNotNull(message.date());
        ChatTest.checkChat(message.chat());
    }

    public static void checkForwardedMessage(Message message) {
        checkMessage(message);
        assertNotNull(message.forwardDate());
        UserTest.checkUser(message.forwardFrom());
    }

    public static void checkTextMessage(Message message) {
        checkMessage(message);
        assertNotNull(message.text());
    }
}
