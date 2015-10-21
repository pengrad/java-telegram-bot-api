package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.model.request.InputFile;
import com.pengrad.telegrambot.model.request.InputFileBytes;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.response.*;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * stas
 * 10/20/15.
 */
public class TelegramBotTest {

    TelegramBot bot;
    Integer chatId, forwardMessageId;
    String stickerId;
    String imagefile = getClass().getClassLoader().getResource("image.png").getFile();
    String audioFile = getClass().getClassLoader().getResource("beep.mp3").getFile();
    String docFile = getClass().getClassLoader().getResource("doc.txt").getFile();
    String videoFile = getClass().getClassLoader().getResource("tabs.mp4").getFile();

    public TelegramBotTest() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("local.properties"));
        bot = TelegramBotAdapter.buildDebug(properties.getProperty("TEST_TOKEN"));
        chatId = Integer.parseInt(properties.getProperty("CHAT_ID"));
        forwardMessageId = Integer.parseInt(properties.getProperty("FORWARD_MESSAGE"));
        stickerId = properties.getProperty("STICKER_FILE_ID");
    }

    @Test
    public void testGetFullFilePath() throws Exception {
        String path1 = bot.getFullFilePath(bot.getFile(stickerId).result);
        String path2 = bot.getFullFilePath(stickerId);
        assertNotNull(path1);
        assertEquals(path1, path2);
    }

    @Test
    public void testGetMe() throws Exception {
        GetMeResponse getMeResponse = bot.getMe();
        User user = getMeResponse.result;
        UserTest.checkUser(user);
    }

    @Test
    public void testForwardMessage() throws Exception {
        SendResponse sendResponse = bot.forwardMessage(chatId, chatId, forwardMessageId);
        Message message = sendResponse.result;
        MessageTest.checkForwardedMessage(message);
    }

    @Test
    public void testSendMessage() throws Exception {
        bot.sendMessage(chatId, "sendMessage with reply and keyboard", false, forwardMessageId, new ReplyKeyboardMarkup(new String[]{"ok", "test"}));
        SendResponse sendResponse = bot.sendMessage(chatId, "sendMessage", false, null, null);
        Message message = sendResponse.result;
        MessageTest.checkTextdMessage(message);
    }

    @Test
    public void testSendPhoto() throws Exception {
        InputFile inputFile = InputFile.photo(new File(imagefile));
        SendResponse sendResponse = bot.sendPhoto(chatId, inputFile, "caption", null, null);
        Message message = sendResponse.result;
        MessageTest.checkPhotoMessage(message);
    }

    @Test
    public void testSendAudio() throws Exception {
        InputFile inputFile = InputFile.audio(new File(audioFile));
        SendResponse sendResponse = bot.sendAudio(chatId, inputFile, null, null, null);
        Message message = sendResponse.result;
        MessageTest.checkAudioMessage(message);
    }

    @Test
    public void testSendDocument() throws Exception {
        InputFile inputFile = new InputFile("text/plain", new File(docFile));
        SendResponse sendResponse = bot.sendDocument(chatId, inputFile, null, null);
        Message message = sendResponse.result;
        MessageTest.checkDocumentMessage(message);
    }

    @Test
    public void testSendSticker() throws Exception {
        SendResponse sendResponse = bot.sendSticker(chatId, stickerId, null, null);
        Message message = sendResponse.result;
        MessageTest.checkStickerMessage(message);
    }

    @Test
    public void testSendVideo() throws Exception {
        InputFile inputFile = InputFile.video(new File(videoFile));
        SendResponse sendResponse = bot.sendVideo(chatId, inputFile, null, "caption", null, null);
        Message message = sendResponse.result;
        MessageTest.checkVideoMessage(message);
    }

    @Test
    public void testSendVoice() throws Exception {
        byte[] array = Files.readAllBytes(new File(audioFile).toPath());
        InputFileBytes inputFileBytes = InputFileBytes.voice(array);
        SendResponse sendResponse = bot.sendVoice(chatId, inputFileBytes, null, null, null);
        Message message = sendResponse.result;
        MessageTest.checkVoiceMessage(message);
    }

    @Test
    public void testSendLocation() throws Exception {
        SendResponse sendResponse = bot.sendLocation(chatId, 55.1f, 38.2f, null, null);
        MessageTest.checkLocationMessage(sendResponse.result);
    }

    @Test
    public void testSendChatAction() throws Exception {
        //todo: add additional actions, make Action class
        bot.sendChatAction(chatId, "typing");
    }

    @Test
    public void testGetUserProfilePhotos() throws Exception {
        GetUserProfilePhotosResponse userProfilePhotosResponse = bot.getUserProfilePhotos(chatId, 0, 5);
        UserProfilePhotosTest.check(userProfilePhotosResponse.result);
    }

    @Test
    public void testGetUpdates() throws Exception {
        GetUpdatesResponse updatesResponse = bot.getUpdates(0, 10, 0);
        List<Update> update = updatesResponse.result;
        UpdateTest.check(update);
    }

    @Test
    public void testSetWebhook() throws Exception {
        SetWebhookResponse webhookResponse = bot.setWebhook("");
        assertNotNull(webhookResponse.description);
    }

    @Test
    public void testGetFile() throws Exception {
        GetFileResponse fileResponse = bot.getFile(stickerId);
        FileTest.check(fileResponse.result);
    }
}