package com.pengrad.telegrambot.checks;

import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.ChatFullInfo;

import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/21/15.
 */
public class ChatTest {

    public static void checkFullInfoChat(ChatFullInfo chat) {
        checkFullInfoChat(chat, chat.photo() != null);
    }

    public static void checkFullInfoChat(ChatFullInfo chat, boolean photo) {
        assertNotNull(chat.id());
        assertNotNull(chat.type());
        if (photo) ChatPhotoTest.check(chat.photo());
    }

    
    public static void checkChat(Chat chat) {
        assertNotNull(chat.id());
        assertNotNull(chat.type());
    }
    

}
