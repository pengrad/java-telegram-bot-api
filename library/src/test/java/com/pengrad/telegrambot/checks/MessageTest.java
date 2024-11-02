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
        assertNull(message.messageThreadId());
        assertNull(message.senderBoostCount());
        assertNull(message.senderBusinessBot());
        assertNull(message.businessConnectionId());
        assertNull(message.forwardOrigin());
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
        assertFalse(message.isTopicMessage());
        assertNull(message.isAutomaticForward());
        assertNull(message.externalReply());
        assertNull(message.quote());
        assertNull(message.replyToStory());
        assertFalse(message.isFromOffline());
        assertFalse(message.hasMediaSpoiler());
        assertNull(message.showCaptionAboveMedia());
        assertNull(message.effectId());
        assertNull(message.messageAutoDeleteTimerChanged());
        assertNull(message.refundedPayment());
        assertNull(message.story());
        assertNull(message.usersShared());
        assertNull(message.userShared());
        assertNull(message.chatShared());
        assertNull(message.proximityAlertTriggered());
        assertNull(message.boostAdded());
        assertNull(message.chatBackgroundSet());
        assertNull(message.forumTopicCreated());
        assertNull(message.forumTopicEdited());
        assertNull(message.forumTopicClosed());
        assertNull(message.forumTopicReopened());
        assertNull(message.generalForumTopicHidden());
        assertNull(message.generalForumTopicUnhidden());
        assertNull(message.giveawayCreated());
        assertNull(message.giveaway());
        assertNull(message.giveawayWinners());
        assertNull(message.giveawayCompleted());
        assertNull(message.writeAccessAllowed());
        assertNull(message.videoChatStarted());
        assertNull(message.videoChatEnded());
        assertNull(message.videoChatParticipantsInvited());
        assertNull(message.videoChatScheduled());
        assertNull(message.webAppData());
    }
}
