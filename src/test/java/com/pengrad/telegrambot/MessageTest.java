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

    public static void checkPhotoMessage(Message message) {
        checkMessage(message);
        assertNotNull(message.caption());
        PhotoSizeTest.checkPhotos(message.photo());
    }

    public static void checkAudioMessage(Message message) {
        checkMessage(message);
        AudioTest.checkAudio(message.audio());
    }

    public static void checkDocumentMessage(Message message) {
        checkMessage(message);
        DocumentTest.check(message.document());
    }

    public static void checkStickerMessage(Message message) {
        checkMessage(message);
        StickerTest.check(message.sticker());
    }

    public static void checkVideoMessage(Message message) {
        checkMessage(message);
        assertNotNull(message.caption());
        VideoTest.check(message.video());
    }

    public static void checkVoiceMessage(Message message) {
        checkMessage(message);
        VoiceTest.check(message.voice());
    }

    public static void checkLocationMessage(Message message) {
        checkMessage(message);
        LocationTest.check(message.location());
    }
}
