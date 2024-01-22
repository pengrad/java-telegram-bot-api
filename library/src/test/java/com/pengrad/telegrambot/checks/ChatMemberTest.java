package com.pengrad.telegrambot.checks;

import com.pengrad.telegrambot.model.ChatMember;

import static org.junit.Assert.assertNotNull;

/**
 * Stas Parshin
 * 29 May 2016
 */
public class ChatMemberTest {

    public static void check(ChatMember chatMember) {
        assertNotNull(chatMember.user());
        assertNotNull(chatMember.status());
        UserTest.checkUser(chatMember.user(), chatMember.status() == ChatMember.Status.creator);
    }


}
