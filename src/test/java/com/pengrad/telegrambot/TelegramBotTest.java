package com.pengrad.telegrambot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;

import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.InlineQueryResult;
import com.pengrad.telegrambot.model.request.InlineQueryResultArticle;
import com.pengrad.telegrambot.model.request.InlineQueryResultGif;
import com.pengrad.telegrambot.model.request.InlineQueryResultMpeg4Gif;
import com.pengrad.telegrambot.model.request.InlineQueryResultPhoto;
import com.pengrad.telegrambot.model.request.InlineQueryResultVideo;
import com.pengrad.telegrambot.model.request.InputFile;
import com.pengrad.telegrambot.model.request.InputFileBytes;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.model.request.ReplyKeyboardHide;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.response.GetFileResponse;
import com.pengrad.telegrambot.response.GetMeResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.GetUserProfilePhotosResponse;
import com.pengrad.telegrambot.response.SendResponse;
import com.pengrad.telegrambot.response.SetWebhookResponse;

/**
 * stas
 * 10/20/15.
 */
@Ignore
public class TelegramBotTest {

    TelegramBot bot;
    Integer chatId, forwardMessageId;
    String channelName = "@bottest";
    Long channelId = -1001002720332L;
    String stickerId;
    String imagefile = TelegramBotTest.class.getClassLoader().getResource("image.png").getPath().replaceAll("%20", " ");
    String audioFile = TelegramBotTest.class.getClassLoader().getResource("beep.mp3").getPath().replaceAll("%20", " ");
    String docFile = TelegramBotTest.class.getClassLoader().getResource("doc.txt").getPath().replaceAll("%20", " ");
    String videoFile = TelegramBotTest.class.getClassLoader().getResource("tabs.mp4").getPath().replaceAll("%20", " ");

    public TelegramBotTest() throws IOException {
    	String filePath = TelegramBotTest.class.getClassLoader().getResource("local.properties").getPath().replaceAll("%20", " ");
    	
        Properties properties = new Properties();
        properties.load(new FileInputStream(filePath));
        bot = TelegramBotAdapter.buildDebug(properties.getProperty("TEST_TOKEN"));
        chatId = Integer.parseInt(properties.getProperty("CHAT_ID"));
        forwardMessageId = Integer.parseInt(properties.getProperty("FORWARD_MESSAGE"));
        stickerId = properties.getProperty("STICKER_FILE_ID");
    }

    @Test
    public void testGetFullFilePath() throws Exception {
        String path1 = bot.getFullFilePath(bot.getFile(stickerId).file());
        String path2 = bot.getFullFilePath(stickerId);
        assertNotNull(path1);
        assertEquals(path1, path2);
    }

    @Test
    public void testGetMe() throws Exception {
        GetMeResponse getMeResponse = bot.getMe();
        User user = getMeResponse.user();
        UserTest.checkUser(user);
    }

    @Test
    public void testForwardMessage() throws Exception {
        SendResponse sendResponse = bot.forwardMessage(chatId, chatId, forwardMessageId);
        Message message = sendResponse.message();
        MessageTest.checkForwardedMessage(message);
    }

    @Test
    public void testSendMessage() throws Exception {
        SendResponse sendResponse = bot.sendMessage(chatId, "short message sending with emoji \uD83D\uDE4C");
        MessageTest.checkTextMessage(sendResponse.message());
        sendResponse = bot.sendMessage(chatId, "sendMessage _italic_ *markdown*", ParseMode.Markdown, null, forwardMessageId, new ReplyKeyboardMarkup(new String[]{"ok", "test"}).oneTimeKeyboard(true));
        MessageTest.checkTextMessage(sendResponse.message());
        sendResponse = bot.sendMessage(channelName, "to channel _italic_ *markdown*", ParseMode.Markdown, false, null, new ForceReply());
        MessageTest.checkTextMessage(sendResponse.message());
        sendResponse = bot.sendMessage(channelId, "explicit to channel id _italic_ *markdown*", ParseMode.Markdown, false, null, new ReplyKeyboardHide());
        MessageTest.checkTextMessage(sendResponse.message());
        sendResponse = bot.sendMessage(channelName, "to channel name with html <b>bold</b>, <strong>bold</strong> " +
                "<i>italic</i>, <em>italic</em> <a href=\"https://telegram.org\">inline URL</a> <code>inline fixed-width code</code> <pre>pre-formatted fixed-width code block</pre>",
                ParseMode.HTML, false, null, new ReplyKeyboardHide());
        MessageTest.checkTextMessage(sendResponse.message());
    }

    @Test
    public void testSendPhoto() throws Exception {
        InputFile inputFile = InputFile.photo(new File(imagefile));
        SendResponse sendResponse = bot.sendPhoto(chatId, inputFile, "caption", null, null);
        Message message = sendResponse.message();
        MessageTest.checkPhotoMessage(message);
    }

    @Test
    public void testSendAudio() throws Exception {
        InputFile inputFile = InputFile.audio(new File(audioFile));
        SendResponse sendResponse = bot.sendAudio(chatId, inputFile, null, null, null, null, null);
        Message message = sendResponse.message();
        MessageTest.checkAudioMessage(message);
    }

    @Test
    public void testSendDocument() throws Exception {
        InputFile inputFile = new InputFile("text/plain", new File(docFile));
        SendResponse sendResponse = bot.sendDocument(chatId, inputFile, null, null);
        Message message = sendResponse.message();
        MessageTest.checkDocumentMessage(message);
    }

    @Test
    public void testSendSticker() throws Exception {
        SendResponse sendResponse = bot.sendSticker(chatId, stickerId, null, null);
        Message message = sendResponse.message();
        MessageTest.checkStickerMessage(message);
    }

    @Test
    public void testSendVideo() throws Exception {
        InputFile inputFile = InputFile.video(new File(videoFile));
        SendResponse sendResponse = bot.sendVideo(chatId, inputFile, null, "caption", null, null);
        Message message = sendResponse.message();
        MessageTest.checkVideoMessage(message);
    }

    @Test
    public void testSendVoice() throws Exception {
        byte[] array = Files.readAllBytes(new File(audioFile).toPath());
        InputFileBytes inputFileBytes = InputFileBytes.voice(array);
        SendResponse sendResponse = bot.sendVoice(chatId, inputFileBytes, null, null, null);
        Message message = sendResponse.message();
        MessageTest.checkVoiceMessage(message);
    }

    @Test
    public void testSendLocation() throws Exception {
        SendResponse sendResponse = bot.sendLocation(chatId, 55.1f, 38.2f, null, null);
        MessageTest.checkLocationMessage(sendResponse.message());
    }

    @Test
    public void testSendChatAction() throws Exception {
        bot.sendChatAction(chatId, ChatAction.find_location);
        bot.sendChatAction(chatId, ChatAction.typing);
        bot.sendChatAction(chatId, ChatAction.record_audio);
        bot.sendChatAction(chatId, ChatAction.record_video);
        bot.sendChatAction(channelName, ChatAction.upload_audio);
        bot.sendChatAction(channelName, ChatAction.upload_document);
        bot.sendChatAction(channelName, ChatAction.upload_photo);
        bot.sendChatAction(channelName, ChatAction.upload_video);
    }

    @Test
    public void testGetUserProfilePhotos() throws Exception {
        GetUserProfilePhotosResponse userProfilePhotosResponse = bot.getUserProfilePhotos(chatId, 0, 5);
        UserProfilePhotosTest.check(userProfilePhotosResponse.photos());
    }

    @Test
    public void testGetUpdates() throws Exception {
        GetUpdatesResponse updatesResponse = bot.getUpdates(0, 10, 0);
        List<Update> update = updatesResponse.updates();
        UpdateTest.check(update);
    }

    @Test
    public void testSetWebhook() throws Exception {
        SetWebhookResponse webhookResponse = bot.setWebhook("");
        assertNotNull(webhookResponse.description());
    }

    @Test
    public void testGetFile() throws Exception {
        GetFileResponse fileResponse = bot.getFile(stickerId);
        FileTest.check(fileResponse.file());
    }

    @Test
    public void testAnswerInlineQuery() {
        InlineQuery inlineQuery = getLastInlineQuery();
        InlineQueryResult r1 = new InlineQueryResultPhoto("1", "https://pp.vk.me/c410128/u2425605/a_f9604e14.jpg", "https://pp.vk.me/c410128/u2425605/d_fa1c9b0e.jpg");
        InlineQueryResult r2 = new InlineQueryResultArticle("2", "title", "message text").thumbUrl("https://pp.vk.me/c311925/v311925605/a0e/2Ua6hLgr71U.jpg");
        InlineQueryResult r3 = new InlineQueryResultGif("3", "https://media.giphy.com/media/bs3V7RiJ6B95e/giphy.gif", "https://pp.vk.me/c521410/u2425605/-3/m_b2d464207a.jpg");
        InlineQueryResult r4 = new InlineQueryResultMpeg4Gif("4", "https://media.giphy.com/media/YEmR6PxPQmEa4/giphy.gif", "https://pp.vk.me/c521410/u2425605/-3/m_b2d464207a.jpg");
        InlineQueryResult r5 = new InlineQueryResultVideo("5", "https://vk.com/video_ext.php?oid=2425605&id=166305236&hash=0a13db9cc2cb53b6", InlineQueryResultVideo.MIME_VIDEO_MP4, "message text", "https://pp.vk.me/c521410/u2425605/-3/m_b2d464207a.jpg", "video title");
        bot.answerInlineQuery(inlineQuery.id(), r1, r2, r3, r4, r5);
    }

    private InlineQuery getLastInlineQuery() {
        GetUpdatesResponse updatesResponse = bot.getUpdates(0, 10, 0);
        List<Update> updates = updatesResponse.updates();
        Collections.reverse(updates);
        for (Update update : updates) {
            if (update.inlineQuery() != null) {
                return update.inlineQuery();
            }
        }
        return null;
    }
}