package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.*;
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

import static com.pengrad.telegrambot.request.ContentTypes.VIDEO_MIME_TYPE;
import static org.junit.Assert.*;

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
    String someUrl = "http://google.com";
    String audioFileId = "CQADAgADYgADuYNZSaVFYCI0kF7kAg";
    String voiceFileId = "AwADAgADYwADuYNZSZww_hkrzCIpAg";
    String videoFileId = "BAADAgADZAADuYNZSXhLnzJTZ2yvAg";
    String photoFileId = "AgADAgADDKgxG7mDWUlvyFIJ9XfF9yszSw0ABBhVadWwbAK1z-wIAAEC";

    public TelegramBotTest() throws IOException {
        String token, chat, forwardMessage, sticker;

        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("local.properties"));

            token = properties.getProperty("TEST_TOKEN");
            chat = properties.getProperty("CHAT_ID");
            forwardMessage = properties.getProperty("FORWARD_MESSAGE");
            sticker = properties.getProperty("STICKER_FILE_ID");

        } catch (Exception e) {
            token = System.getenv("TEST_TOKEN");
            chat = System.getenv("CHAT_ID");
            forwardMessage = System.getenv("FORWARD_MESSAGE");
            sticker = System.getenv("STICKER_FILE_ID");
        }

        bot = TelegramBotAdapter.buildDebug(token);
        chatId = Integer.parseInt(chat);
        forwardMessageId = Integer.parseInt(forwardMessage);
        stickerId = sticker;
    }

    @Test
    public void getMe() {
        GetMeResponse response = bot.execute(new GetMe());
        System.out.println(response);
        UserTest.checkUser(response.user());
    }

    @Test
    public void getUpdates() {
        GetUpdates getUpdates = new GetUpdates()
                .offset(499018234)
                .allowedUpdates("")
                .timeout(0)
                .limit(10);
        assertEquals(10, getUpdates.getLimit());
        GetUpdatesResponse response = bot.execute(getUpdates);
        System.out.println(response);
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
        InlineQuery lastInlineQuery = getLastInlineQuery();
        String inlineQueryId = lastInlineQuery != null ? lastInlineQuery.id() : "invalid_query_id";
        boolean checkSuccess = lastInlineQuery != null;

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(new InlineKeyboardButton[]{
                new InlineKeyboardButton("inline game").callbackGame("pengrad test game description"),
                new InlineKeyboardButton("inline ok").callbackData("callback ok"),
                new InlineKeyboardButton("cancel").callbackData("callback cancel"),
                new InlineKeyboardButton("url").url(someUrl),
                new InlineKeyboardButton("switch inline").switchInlineQuery("query"),
                new InlineKeyboardButton("switch inline current").switchInlineQueryCurrentChat("query"),
        });

        InlineQueryResult[] results = new InlineQueryResult[]{
                new InlineQueryResultArticle("1", "title",
                        new InputTextMessageContent("message").disableWebPagePreview(false).parseMode(ParseMode.HTML))
                        .url(someUrl).hideUrl(true).description("desc").thumbUrl(someUrl).thumbHeight(100).thumbWidth(100),
                new InlineQueryResultArticle("1", "title",
                        new InputContactMessageContent("123123123", "na,e").lastName("lastName")),
                new InlineQueryResultArticle("1", "title", new InputLocationMessageContent(50f, 50f)),
                new InlineQueryResultArticle("1", "title",
                        new InputVenueMessageContent(50f, 50f, "title", "address").foursquareId("sqrId")),
                new InlineQueryResultArticle("1", "title", "message"),
                new InlineQueryResultAudio("1", someUrl, "title").caption("cap").performer("perf").audioDuration(100),
                new InlineQueryResultContact("1", "123123123", "name").lastName("lastName")
                        .thumbUrl(someUrl).thumbHeight(100).thumbWidth(100),
                new InlineQueryResultDocument("1", someUrl, "title", "application/pdf").caption("cap").description("desc")
                        .thumbUrl(someUrl).thumbHeight(100).thumbWidth(100),
                new InlineQueryResultGame("1", "pengrad_test_game").replyMarkup(keyboardMarkup),
                new InlineQueryResultGif("1", someUrl, someUrl).caption("cap").title("title")
                        .gifHeight(100).gifWidth(100).gifDuration(100),
                new InlineQueryResultLocation("1", 50f, 50f, "title").thumbUrl(someUrl).thumbHeight(100).thumbWidth(100),
                new InlineQueryResultMpeg4Gif("1", someUrl, someUrl).caption("cap").title("title")
                        .mpeg4Height(100).mpeg4Width(100).mpeg4Duration(100),
                new InlineQueryResultPhoto("1", someUrl, someUrl).photoWidth(100).photoHeight(100).title("title")
                        .description("desc").caption("cap"),
                new InlineQueryResultVenue("1", 54f, 55f, "title", "address").foursquareId("frsqrId")
                        .thumbUrl(someUrl).thumbHeight(100).thumbWidth(100),
                new InlineQueryResultVideo("1", someUrl, VIDEO_MIME_TYPE, "text", someUrl, "title").caption("cap")
                        .videoWidth(100).videoHeight(100).videoDuration(100).description("desc"),
                new InlineQueryResultVoice("1", someUrl, "title").caption("cap").voiceDuration(100),
                new InlineQueryResultCachedAudio("1", audioFileId).caption("cap"),
                new InlineQueryResultCachedDocument("1", stickerId, "title").caption("cap").description("desc"),
                new InlineQueryResultCachedGif("1", stickerId).caption("cap").title("title"),
                new InlineQueryResultCachedMpeg4Gif("1", stickerId).caption("cap").title("title"),
                new InlineQueryResultCachedPhoto("1", photoFileId).caption("cap").description("desc").title("title"),
                new InlineQueryResultCachedSticker("1", stickerId),
                new InlineQueryResultCachedVideo("1", videoFileId, "title").caption("cap").description("desc"),
                new InlineQueryResultCachedVoice("1", voiceFileId, "title").caption("cap"),
        };

        BaseResponse response = bot.execute(new AnswerInlineQuery(inlineQueryId, results)
                .cacheTime(0)
                .isPersonal(true)
                .nextOffset("offset")
                .switchPmText("go pm")
                .switchPmParameter("pm parameter")
        );

        if (checkSuccess) {
            assertTrue(response.isOk());
        } else {
            assertFalse(response.isOk());
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: QUERY_ID_INVALID", response.description());
        }
    }

    private InlineQuery getLastInlineQuery() {
        GetUpdatesResponse updatesResponse = bot.execute(new GetUpdates());
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
        CallbackQuery callbackQuery = getLastCallbackQuery();
        if (callbackQuery == null) return;

        System.out.println(callbackQuery);

        bot.execute(new AnswerCallbackQuery(callbackQuery.id())
                .text("answer callback")
                .url("telegram.me/pengrad_test_bot?game=pengrad_test_game"));
    }

    private CallbackQuery getLastCallbackQuery() {
        GetUpdatesResponse updatesResponse = bot.execute(new GetUpdates());
        List<Update> updates = updatesResponse.updates();
        Collections.reverse(updates);
        for (Update update : updates) {
            if (update.callbackQuery() != null) {
                return update.callbackQuery();
            }
        }
        return null;
    }

    @Test
    public void getChat() {
        GetChatResponse getChatResponse = bot.execute(new GetChat(chatId));
        assertTrue(getChatResponse.toString().contains(chatId.toString()));
        ChatTest.checkChat(getChatResponse.chat());
    }

    @Test
    public void leaveChat() {
        BaseResponse response = bot.execute(new LeaveChat(chatId));
        System.out.println(response);
        assertFalse(response.isOk());
        assertEquals(400, response.errorCode());
        assertEquals("Bad Request: chat member status can't be changed in private chats", response.description());
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
        GetChatMembersCountResponse response = bot.execute(new GetChatMembersCount(chatId));
        System.out.println(response);
        assertEquals(2, response.count());
    }

    @Test
    public void sendMessage() {
        SendResponse sendResponse = bot.execute(new SendMessage(chatId, "reply this message").replyMarkup(new ForceReply()));
        MessageTest.checkTextMessage(sendResponse.message());

        sendResponse = bot.execute(new SendMessage(chatId, "remove keyboard").replyMarkup(new ReplyKeyboardRemove()));
        MessageTest.checkTextMessage(sendResponse.message());

        sendResponse = bot.execute(new SendMessage(chatId, "message with keyboard")
                .replyMarkup(new ReplyKeyboardMarkup(new KeyboardButton[]{
                        new KeyboardButton("contact").requestContact(true),
                        new KeyboardButton("location").requestLocation(true)})
                        .oneTimeKeyboard(true)
                        .resizeKeyboard(true)
                        .selective(true)));
        MessageTest.checkTextMessage(sendResponse.message());

        sendResponse = bot.execute(new SendMessage(chatId, "simple buttons")
                .replyMarkup(new ReplyKeyboardMarkup(new String[]{"ok", "cancel"})));
        MessageTest.checkTextMessage(sendResponse.message());
    }

    @Test
    public void sendMessageToChannel() {
        SendMessage request = new SendMessage(channelName, "channel message");
        SendResponse sendResponse = bot.execute(request);
        Message message = sendResponse.message();
        MessageTest.checkTextMessage(message);
    }

    @Test
    public void sendMessageToChannelId() {
        SendMessage request = new SendMessage(channelId, "channel by id message");
        SendResponse sendResponse = bot.execute(request);
        Message message = sendResponse.message();
        MessageTest.checkTextMessage(message);
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
        SendResponse sendResponse = bot.execute(new SendVideo(chatId, new File(videoFile)).caption("my video"));
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

    @Test
    public void getWebhookInfo() {
        GetWebhookInfoResponse response = bot.execute(new GetWebhookInfo());
        assertTrue(response.toString().contains(response.webhookInfo().toString()));
        WebhookInfoTest.check(response.webhookInfo());
    }

    @Test
    public void setWebhook() {
        BaseResponse response = bot.execute(
                new SetWebhook()
                        .url("https://google.com")
                        .maxConnections(100)
                        .allowedUpdates("message", "callback_query")
        );
        assertTrue(response.isOk());

        response = bot.execute(new SetWebhook());
        assertTrue(response.isOk());
    }

    @Test
    public void deleteWebhook() {
        BaseResponse response = bot.execute(new DeleteWebhook());
        assertTrue(response.isOk());
    }

    @Test
    public void sendGame() {
        SendResponse response = bot.execute(new SendGame(chatId, "pengrad_test_game"));
        MessageTest.checkGameMessage(response.message());
    }

    @Test
    public void sendLocation() {
        SendResponse response = bot.execute(new SendLocation(chatId, 22.3f, 105.2f));
    }

    @Test
    public void deleteMessage() {
        Message message = bot.execute(new SendMessage(chatId, "message for delete")).message();
        BaseResponse response = bot.execute(new DeleteMessage(chatId, message.messageId()));
        assertTrue(response.isOk());
    }

    @Test
    public void sendChatAction() {
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.typing)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.upload_photo)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.record_video)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.upload_video)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.record_audio)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.upload_audio)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.upload_document)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.find_location)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.record_video_note)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.upload_video_note)).isOk());
    }

    @Test
    public void sendVideoNote() {
        SendResponse response = bot.execute(new SendVideoNote(chatId, "DQADAgADmQADYgwpSbum1JrxPsbmAg"));
        VideoNoteCheck.check(response.message().videoNote());
    }

    @Test
    public void sendVideoNoteFile() {
        SendResponse response = bot.execute(new SendVideoNote(chatId, new File(videoFile)).length(20).duration(30));
        VideoNoteCheck.check(response.message().videoNote(), true);
    }

    @Test
    public void sendInvoice() {
        SendResponse response = bot.execute(new SendInvoice(chatId, "title", "desc", "my_payload",
                "284685063:TEST:NThlNWQ3NDk0ZDQ5", "my_start_param", "USD", new LabeledPrice("label", 200))
                .photoUrl("https://telegram.org/img/t_logo.png").photoSize(100).photoHeight(100).photoWidth(100)
                .needPhoneNumber(true).needShippingAddress(true).needEmail(true).needName(true)
                .isFlexible(true)
                .replyMarkup(new InlineKeyboardMarkup(new InlineKeyboardButton[]{
                        new InlineKeyboardButton("just pay").pay(),
                        new InlineKeyboardButton("google it").url("www.google.com")

                }))
        );
        InvoiceCheck.check(response.message().invoice());
    }

    @Test
    public void answerShippingQuery() {
        ShippingQuery shippingQuery = getLastShippingQuery();
        String shippingQueryId = shippingQuery != null ? shippingQuery.id() : "invalid_query_id";
        boolean checkSuccess = shippingQuery != null;

        BaseResponse response = bot.execute(new AnswerShippingQuery(shippingQueryId,
                new ShippingOption("1", "VNPT", new LabeledPrice("delivery", 100), new LabeledPrice("tips", 50)),
                new ShippingOption("2", "FREE", new LabeledPrice("free delivery", 0))
        ));

        if (checkSuccess) {
            assertTrue(response.isOk());
        } else {
            assertFalse(response.isOk());
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: QUERY_ID_INVALID", response.description());
        }
    }

    @Test
    public void answerShippingQueryError() {
        ShippingQuery shippingQuery = getLastShippingQuery();
        String shippingQueryId = shippingQuery != null ? shippingQuery.id() : "invalid_query_id";
        boolean checkSuccess = shippingQuery != null;

        BaseResponse response = bot.execute(new AnswerShippingQuery(shippingQueryId, "cant delivery so far"));

        if (checkSuccess) {
            assertTrue(response.isOk());
        } else {
            assertFalse(response.isOk());
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: QUERY_ID_INVALID", response.description());
        }
    }

    private ShippingQuery getLastShippingQuery() {
        GetUpdatesResponse updatesResponse = bot.execute(new GetUpdates());
        List<Update> updates = updatesResponse.updates();
        Collections.reverse(updates);
        for (Update update : updates) {
            if (update.shippingQuery() != null) {
                return update.shippingQuery();
            }
        }
        return null;
    }

    @Test
    public void answerPreCheckoutQuery() {
        PreCheckoutQuery preCheckoutQuery = getLastPreCheckoutQuery();
        String preCheckoutQueryId = preCheckoutQuery != null ? preCheckoutQuery.id() : "invalid_query_id";
        boolean checkSuccess = preCheckoutQuery != null;

        BaseResponse response = bot.execute(new AnswerPreCheckoutQuery(preCheckoutQueryId));

        if (checkSuccess) {
            assertTrue(response.isOk());
        } else {
            assertFalse(response.isOk());
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: QUERY_ID_INVALID", response.description());
        }
    }

    @Test
    public void answerPreCheckoutQueryError() {
        PreCheckoutQuery preCheckoutQuery = getLastPreCheckoutQuery();
        String preCheckoutQueryId = preCheckoutQuery != null ? preCheckoutQuery.id() : "invalid_query_id";
        boolean checkSuccess = preCheckoutQuery != null;

        BaseResponse response = bot.execute(new AnswerPreCheckoutQuery(preCheckoutQueryId, "cant sell to you"));

        if (checkSuccess) {
            assertTrue(response.isOk());
        } else {
            assertFalse(response.isOk());
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: QUERY_ID_INVALID", response.description());
        }
    }

    private PreCheckoutQuery getLastPreCheckoutQuery() {
        GetUpdatesResponse updatesResponse = bot.execute(new GetUpdates());
        List<Update> updates = updatesResponse.updates();
        Collections.reverse(updates);
        for (Update update : updates) {
            if (update.preCheckoutQuery() != null) {
                return update.preCheckoutQuery();
            }
        }
        return null;
    }

}
