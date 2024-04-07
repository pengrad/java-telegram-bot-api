package com.pengrad.telegrambot.checks;

import com.pengrad.telegrambot.model.Message;

import static org.junit.Assert.*;

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
        assertNull(message.messageThreadId());
        assertFalse(message.isTopicMessage());
        assertNull(message.isAutomaticForward());
        assertFalse(message.hasMediaSpoiler());
        assertNull(message.messageAutoDeleteTimerChanged());
        assertNull(message.chatShared());
        assertNull(message.proximityAlertTriggered());
        assertNull(message.forumTopicCreated());
        assertNull(message.forumTopicEdited());
        assertNull(message.forumTopicClosed());
        assertNull(message.forumTopicReopened());
        assertNull(message.generalForumTopicHidden());
        assertNull(message.generalForumTopicUnhidden());
        assertNull(message.writeAccessAllowed());
        assertNull(message.videoChatStarted());
        assertNull(message.videoChatEnded());
        assertNull(message.videoChatParticipantsInvited());
        assertNull(message.videoChatScheduled());
        assertNull(message.webAppData());
    }
}
