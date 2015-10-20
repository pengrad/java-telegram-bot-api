package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.InputFile;
import com.pengrad.telegrambot.response.SendResponse;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * stas
 * 10/20/15.
 */
public class TelegramBotTest {

    Integer chatId;
    TelegramBot bot;
    String imagefile = getClass().getClassLoader().getResource("image.png").getFile();

    public TelegramBotTest() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("local.properties"));
        chatId = Integer.parseInt(properties.getProperty("CHAT_ID"));
        bot = TelegramBotAdapter.buildDebug(properties.getProperty("TEST_TOKEN"));
    }

    @Test
    public void testGetFullFilePath() throws Exception {

    }

    @Test
    public void testGetFullFilePath1() throws Exception {

    }

    @Test
    public void testGetMe() throws Exception {

    }

    @Test
    public void testGetMeRx() throws Exception {

    }

    @Test
    public void testForwardMessage() throws Exception {

    }

    @Test
    public void testSendMessage() throws Exception {
        SendResponse sendResponse = bot.sendMessage(chatId, "simple message", false, null, null);
        System.out.println(sendResponse.result);
    }

    @Test
    public void testSendPhoto() throws Exception {
        bot.sendPhoto(chatId, InputFile.photo(new File(imagefile)), null, null, null);
    }


    @Test
    public void testSendAudio() throws Exception {

    }

    @Test
    public void testSendDocument() throws Exception {

    }

    @Test
    public void testSendSticker() throws Exception {

    }


    @Test
    public void testSendVideo() throws Exception {

    }

    @Test
    public void testSendLocation() throws Exception {

    }

    @Test
    public void testSendChatAction() throws Exception {

    }

    @Test
    public void testGetUserProfilePhotos() throws Exception {

    }

    @Test
    public void testGetUpdates() throws Exception {

    }

    @Test
    public void testSetWebhook() throws Exception {

    }

    @Test
    public void testGetFile() throws Exception {

    }
}