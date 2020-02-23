package com.pengrad.telegrambot.checks;

import com.pengrad.telegrambot.model.Message;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

    public static void checkTextMessage(Message message) {
        checkMessage(message);
        assertNotNull(message.text());
        assertNull(message.newChatMembers());
        assertNull(message.leftChatMember());
        assertNull(message.newChatTitle());
        assertNull(message.newChatPhoto());
        assertNull(message.deleteChatPhoto());
        assertNull(message.groupChatCreated());
        assertNull(message.supergroupChatCreated());
        assertNull(message.channelChatCreated());
        assertNull(message.migrateToChatId());
        assertNull(message.migrateFromChatId());
        assertNull(message.pinnedMessage());
        assertNull(message.successfulPayment());
        assertNull(message.connectedWebsite());
    }
}
