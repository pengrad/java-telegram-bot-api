package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.ChatMember;
import com.pengrad.telegrambot.model.InlineQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.*;
import com.pengrad.telegrambot.response.*;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * stas
 * 5/2/16.
 */
public class TelegramBotTest {

    TelegramBot bot;
    Integer chatId, forwardMessageId;
    String channelName = "@bottest";
    Long channelId = -1001002720332L;
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
    public void getMe() {
        bot.execute(new GetMe());
    }

    @Test
    public void kickChatMember() {
        BaseResponse response = bot.execute(new KickChatMember(channelName, chatId));
        System.out.println(response);
    }

    @Test
    public void editMessageText() {
        String text = "Update " + System.currentTimeMillis();
        BaseResponse response = bot.execute(new EditMessageText(chatId, 925, text));
        System.out.println(response);
        bot.execute(new EditMessageText(channelName, 306, text));
        System.out.println(response);
        bot.execute(new EditMessageText("AgAAAJUtAQCj_Q4D87e3E-gkx2A", text));
        System.out.println(response);
    }

    @Test
    public void answerInline() {
        String inlineQueryId = getLastInlineQuery().id();
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(new InlineKeyboardButton[]{new InlineKeyboardButton("inline ok").callbackData("callback ok"), new InlineKeyboardButton("inline cancel").callbackData("callback cancel")});
        InlineQueryResult r1 = new InlineQueryResultArticle("1", "title", "message").replyMarkup(keyboardMarkup);
        InlineQueryResult r2 = new InlineQueryResultArticle("2", "2 title", "2 message").replyMarkup(keyboardMarkup);
        bot.execute(new AnswerInlineQuery(inlineQueryId, r1, r2));
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

    @Test
    public void answerCallback() {
        bot.execute(new AnswerCallbackQuery("220392309269028729").text("answer callback"));
    }

    @Test
    public void getChat() {
        GetChatResponse getChatResponse = bot.execute(new GetChat(chatId));
        ChatTest.checkChat(getChatResponse.chat());
    }

    @Test
    public void leaveChat() {
        BaseResponse response = bot.execute(new LeaveChat(chatId));
        System.out.println(response);
    }

    @Test
    public void getChatAdministrators() {
        GetChatAdministratorsResponse response = bot.execute(new GetChatAdministrators(channelName));
        System.out.println(response);
        for (ChatMember chatMember : response.administrators()) ChatMemberTest.check(chatMember);
    }

    @Test
    public void getChatMember() {
        GetChatMemberResponse response = bot.execute(new GetChatMember(chatId, chatId));
        System.out.println(response);
        ChatMemberTest.check(response.chatMember());
    }

    @Test
    public void getChatMembersCount() {
        BaseResponse response = bot.execute(new GetChatMembersCount(chatId));
        System.out.println(response);
    }

    @Test
    public void sendAudio() {
        SendAudio request = new SendAudio(chatId, new File(audioFile));
        SendResponse sendResponse = bot.execute(request);
        Message message = sendResponse.message();
        MessageTest.checkAudioMessage(message);
    }

    @Test
    public void sendDocument() {
        SendDocument request = new SendDocument(chatId, new File(docFile)).fileName("my doc.zip").caption("caption");
        SendResponse sendResponse = bot.execute(request);
        Message message = sendResponse.message();
        MessageTest.checkDocumentMessage(message);
    }

    @Test
    public void sendPhoto() {
        SendPhoto request = new SendPhoto(chatId, new File(imagefile)).caption("caption");
        SendResponse sendResponse = bot.execute(request);
        Message message = sendResponse.message();
        MessageTest.checkPhotoMessage(message);
    }

    @Test
    public void sendSticker() {
        SendResponse sendResponse = bot.execute(new SendSticker(chatId, stickerId));
        Message message = sendResponse.message();
        MessageTest.checkStickerMessage(message);
    }

    @Test
    public void sendVideo() {
        SendResponse sendResponse = bot.execute(new SendVideo(chatId, new File(videoFile)));
        Message message = sendResponse.message();
        MessageTest.checkVideoMessage(message);
    }

    @Test
    public void sendVoice() throws IOException {
        byte[] array = Files.readAllBytes(new File(audioFile).toPath());
        SendVoice request = new SendVoice(chatId, array);
        SendResponse sendResponse = bot.execute(request);
        Message message = sendResponse.message();
        MessageTest.checkVoiceMessage(message);
    }
}
