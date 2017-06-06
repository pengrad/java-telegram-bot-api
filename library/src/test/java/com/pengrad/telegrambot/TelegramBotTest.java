package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.*;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.*;
import com.pengrad.telegrambot.response.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    Path resourcePath = Paths.get("src/test/resources");
    String imagefile = resourcePath.resolve("image.png").toString();
    String audioFile = resourcePath.resolve("beep.mp3").toString();
    String docFile = resourcePath.resolve("doc.txt").toString();
    String videoFile = resourcePath.resolve("tabs.mp4").toString();
    String videoNoteFile = resourcePath.resolve("video_note.mp4").toString();
    String certificateFile = resourcePath.resolve("cert.pem").toString();
    String someUrl = "http://google.com";
    String audioFileId = "CQADAgADXAADgNqgSevw7NljQE4lAg";
    String docFileId = "BQADAgADuwADgNqYSaVAUsHMq6hqAg";
    String voiceFileId = "AwADAgADYwADuYNZSZww_hkrzCIpAg";
    String videoFileId = "BAADAgADZAADuYNZSXhLnzJTZ2yvAg";
    String photoFileId = "AgADAgADDKgxG7mDWUlvyFIJ9XfF9yszSw0ABBhVadWwbAK1z-wIAAEC";
    String gifFileId = "CgADAgADfQADgNqgSTt9SzatJhc3Ag";
    String withSpaceFileId = "BAADAgADZwADkg-4SQI5WM0SPNHrAg";

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
        UpdateTest.check(response.updates());
    }

    @Test
    public void getFile() throws IOException {
        GetFileResponse response = bot.execute(new GetFile(withSpaceFileId));
        FileTest.check(response.file());
        String path = bot.getFullFilePath(response.file());

        Request request = new Request.Builder().head().url(path).build();
        Response pathResponse = new OkHttpClient().newCall(request).execute();
        assertTrue(pathResponse.isSuccessful());
    }

    @Test
    public void kickChatMember() {
        BaseResponse response = bot.execute(new KickChatMember(channelName, chatId));
        assertFalse(response.isOk());
        assertEquals(400, response.errorCode());
        assertEquals("Bad Request: USER_ADMIN_INVALID", response.description());
    }

    @Test
    public void unbanChatMember() {
        BaseResponse response = bot.execute(new UnbanChatMember(channelName, chatId));
        assertTrue(response.isOk());
    }

    @Test
    public void editMessageText() {
        String text = "Update " + System.currentTimeMillis();

        BaseResponse response = bot.execute(new EditMessageText(chatId, 925, text)
                .parseMode(ParseMode.Markdown)
                .disableWebPagePreview(true)
                .replyMarkup(new InlineKeyboardMarkup()));
        assertTrue(response.isOk());

        response = bot.execute(new EditMessageText(channelName, 306, text));
        assertTrue(response.isOk());

        response = bot.execute(new EditMessageText("AgAAAN3wAQCj_Q4DjX4ok5VEUZU", text));
        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: MESSAGE_ID_INVALID", response.description());
        }
    }

    @Test
    public void editMessageCaption() {
        String text = "Update " + System.currentTimeMillis();

        BaseResponse response = bot.execute(new EditMessageCaption(chatId, 8124, text)
                .caption(text)
                .replyMarkup(new InlineKeyboardMarkup()));
        assertTrue(response.isOk());

        response = bot.execute(new EditMessageCaption(channelName, 511, text).caption(text));
        assertTrue(response.isOk());

        response = bot.execute(new EditMessageCaption("AgAAAPrwAQCj_Q4D2s-51_8jsuU", "").caption(text));
        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: MESSAGE_ID_INVALID", response.description());
        }
    }

    @Test
    public void editMessageReplyMarkup() {
        String text = "Update" + System.currentTimeMillis();

        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup(new InlineKeyboardButton[]{
                new InlineKeyboardButton(text).url("https://google.com")});

        InlineKeyboardMarkup gameKeyboard = new InlineKeyboardMarkup(new InlineKeyboardButton[]{
                new InlineKeyboardButton(text).callbackGame("test game")});

        BaseResponse response = bot.execute(new EditMessageReplyMarkup(chatId, 8124, text).replyMarkup(keyboard));
        assertTrue(response.isOk());

        response = bot.execute(new EditMessageReplyMarkup(channelName, 511, text).replyMarkup(keyboard));
        assertTrue(response.isOk());

        response = bot.execute(new EditMessageReplyMarkup("AgAAAPrwAQCj_Q4D2s-51_8jsuU", "").replyMarkup(gameKeyboard));
        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: MESSAGE_ID_INVALID", response.description());
        }
    }

    @Test
    public void answerInline() {
        InlineQuery lastInlineQuery = getLastInlineQuery();
        String inlineQueryId = lastInlineQuery != null ? lastInlineQuery.id() : "invalid_query_id";

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
                new InlineQueryResultArticle("2", "title",
                        new InputContactMessageContent("123123123", "na,e").lastName("lastName")),
                new InlineQueryResultArticle("3", "title", new InputLocationMessageContent(50f, 50f)),
                new InlineQueryResultArticle("4", "title",
                        new InputVenueMessageContent(50f, 50f, "title", "address").foursquareId("sqrId")),
                new InlineQueryResultArticle("5", "title", "message"),
                new InlineQueryResultAudio("6", someUrl, "title").caption("cap").performer("perf").audioDuration(100),
                new InlineQueryResultContact("7", "123123123", "name").lastName("lastName")
                        .thumbUrl(someUrl).thumbHeight(100).thumbWidth(100),
                new InlineQueryResultDocument("8", someUrl, "title", "application/pdf").caption("cap").description("desc")
                        .thumbUrl(someUrl).thumbHeight(100).thumbWidth(100),
                new InlineQueryResultGame("9", "pengrad_test_game").replyMarkup(keyboardMarkup),
                new InlineQueryResultGif("10", someUrl, someUrl).caption("cap").title("title")
                        .gifHeight(100).gifWidth(100).gifDuration(100),
                new InlineQueryResultLocation("11", 50f, 50f, "title").thumbUrl(someUrl).thumbHeight(100).thumbWidth(100),
                new InlineQueryResultMpeg4Gif("12", someUrl, someUrl).caption("cap").title("title")
                        .mpeg4Height(100).mpeg4Width(100).mpeg4Duration(100),
                new InlineQueryResultPhoto("13", someUrl, someUrl).photoWidth(100).photoHeight(100).title("title")
                        .description("desc").caption("cap"),
                new InlineQueryResultVenue("14", 54f, 55f, "title", "address").foursquareId("frsqrId")
                        .thumbUrl(someUrl).thumbHeight(100).thumbWidth(100),
                new InlineQueryResultVideo("15", someUrl, VIDEO_MIME_TYPE, "text", someUrl, "title").caption("cap")
                        .videoWidth(100).videoHeight(100).videoDuration(100).description("desc"),
                new InlineQueryResultVoice("16", someUrl, "title").caption("cap").voiceDuration(100),
                new InlineQueryResultCachedAudio("17", audioFileId).caption("cap"),
                new InlineQueryResultCachedDocument("18", stickerId, "title").caption("cap").description("desc"),
                new InlineQueryResultCachedGif("19", gifFileId).caption("cap").title("title"),
                new InlineQueryResultCachedMpeg4Gif("21", gifFileId).caption("cap").title("title"),
                new InlineQueryResultCachedPhoto("22", photoFileId).caption("cap").description("desc").title("title"),
                new InlineQueryResultCachedSticker("23", stickerId),
                new InlineQueryResultCachedVideo("24", videoFileId, "title").caption("cap").description("desc"),
                new InlineQueryResultCachedVoice("25", voiceFileId, "title").caption("cap"),
        };

        BaseResponse response = bot.execute(new AnswerInlineQuery(inlineQueryId, results)
                .cacheTime(100)
                .isPersonal(true)
                .nextOffset("offset")
                .switchPmText("go pm")
                .switchPmParameter("my_pm_parameter")
        );

        if (!response.isOk()) {
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
        String callbackQueryId = callbackQuery != null ? callbackQuery.id() : "invalid_query_id";

        BaseResponse response = bot.execute(new AnswerCallbackQuery(callbackQueryId)
                .text("answer callback")
                .url("telegram.me/pengrad_test_bot?game=pengrad_test_game")
                .showAlert(false)
                .cacheTime(1));

        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: QUERY_ID_INVALID", response.description());
        }
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
        assertFalse(response.isOk());
        assertEquals(400, response.errorCode());
        assertEquals("Bad Request: chat member status can't be changed in private chats", response.description());
    }

    @Test
    public void getChatAdministrators() {
        GetChatAdministratorsResponse response = bot.execute(new GetChatAdministrators(channelName));
        for (ChatMember chatMember : response.administrators()) {
            ChatMemberTest.check(chatMember);
        }
    }

    @Test
    public void getChatMember() {
        GetChatMemberResponse response = bot.execute(new GetChatMember(chatId, chatId));
        ChatMemberTest.check(response.chatMember());
    }

    @Test
    public void getChatMembersCount() {
        GetChatMembersCountResponse response = bot.execute(new GetChatMembersCount(chatId));
        assertEquals(2, response.count());
    }

    @Test
    public void getUserProfilePhotos() {
        int offset = 1;
        GetUserProfilePhotosResponse response = bot.execute(new GetUserProfilePhotos(chatId).limit(100).offset(offset));
        UserProfilePhotos photos = response.photos();
        assertEquals(photos.totalCount() - offset, photos.photos().length);
        for (PhotoSize[] photo : photos.photos()) {
            PhotoSizeTest.checkPhotos(photo);
        }

        if (photos.totalCount() > 1) {
            photos = bot.execute(new GetUserProfilePhotos(chatId).limit(1)).photos();
            assertEquals(1, photos.photos().length);
        }
    }

    @Test
    public void sendMessage() {
        SendResponse sendResponse = bot.execute(new SendMessage(chatId, "reply this message").replyMarkup(new ForceReply()));
        MessageTest.checkTextMessage(sendResponse.message());

        sendResponse = bot.execute(new SendMessage(chatId, "remove keyboard")
                .replyMarkup(new ReplyKeyboardRemove())
                .disableNotification(true)
                .replyToMessageId(8087)
        );
        MessageTest.checkTextMessage(sendResponse.message());

        sendResponse = bot.execute(new SendMessage(chatId, "hide keyboard").replyMarkup(new ReplyKeyboardHide()));
        MessageTest.checkTextMessage(sendResponse.message());

        sendResponse = bot.execute(new SendMessage(chatId, "message with keyboard")
                .parseMode(ParseMode.HTML)
                .disableWebPagePreview(false)
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
    public void forwardMessage() {
        SendResponse response = bot.execute(new ForwardMessage(chatId, chatId, forwardMessageId).disableNotification(true));
        MessageTest.checkForwardedMessage(response.message());
    }

    @Test
    public void sendAudio() throws IOException {
        Message message = bot.execute(new SendAudio(chatId, audioFileId)).message();
        MessageTest.checkMessage(message);
        AudioTest.checkAudio(message.audio(), false);

        message = bot.execute(new SendAudio(chatId, new File(audioFile))).message();
        MessageTest.checkMessage(message);
        AudioTest.checkAudio(message.audio(), true);

        byte[] bytes = Files.readAllBytes(new File(audioFile).toPath());
        String cap = "cap", title = "title", performer = "performer";
        int duration = 100;
        SendAudio sendAudio = new SendAudio(chatId, bytes).duration(duration).caption(cap).performer(performer).title(title);
        message = bot.execute(sendAudio).message();
        MessageTest.checkMessage(message);

        Audio audio = message.audio();
        AudioTest.checkAudio(audio, true);
        assertEquals(cap, message.caption());
        assertEquals((Integer) 100, audio.duration());
        assertEquals(performer, audio.performer());
        assertEquals(title, audio.title());
    }

    @Test
    public void sendDocument() throws IOException {
        Message message = bot.execute(new SendDocument(chatId, docFileId)).message();
        MessageTest.checkMessage(message);
        DocumentTest.check(message.document());

        byte[] bytes = Files.readAllBytes(new File(docFile).toPath());
        message = bot.execute(new SendDocument(chatId, bytes)).message();
        MessageTest.checkMessage(message);
        DocumentTest.check(message.document());

        String caption = "caption", fileName = "my doc.zip";
        message = bot.execute(new SendDocument(chatId, new File(docFile)).fileName(fileName).caption(caption)).message();
        MessageTest.checkMessage(message);
        DocumentTest.check(message.document());
        assertEquals(caption, message.caption());
        assertEquals(fileName, message.document().fileName());
    }

    @Test
    public void sendPhoto() throws IOException {
        Message message = bot.execute(new SendPhoto(chatId, photoFileId)).message();
        MessageTest.checkMessage(message);
        PhotoSizeTest.checkPhotos(message.photo());

        message = bot.execute(new SendPhoto(chatId, new File(imagefile))).message();
        MessageTest.checkMessage(message);
        PhotoSizeTest.checkPhotos(message.photo());

        byte[] bytes = Files.readAllBytes(new File(imagefile).toPath());
        String caption = "caption";
        message = bot.execute(new SendPhoto(channelName, bytes).caption(caption)).message();
        MessageTest.checkMessage(message);
        assertEquals(caption, message.caption());
        PhotoSizeTest.checkPhotos(message.photo());
    }

    @Test
    public void sendSticker() throws IOException {
        Message message = bot.execute(new SendSticker(chatId, stickerId)).message();
        MessageTest.checkMessage(message);
        StickerTest.check(message.sticker(), true, false);

        message = bot.execute(new SendSticker(chatId, new File(imagefile))).message();
        MessageTest.checkMessage(message);
        StickerTest.check(message.sticker(), false, true);

        byte[] bytes = Files.readAllBytes(new File(imagefile).toPath());
        message = bot.execute(new SendSticker(chatId, bytes)).message();
        MessageTest.checkMessage(message);
        StickerTest.check(message.sticker(), false, true);
    }

    @Test
    public void sendVideo() throws IOException {
        Message message = bot.execute(new SendVideo(chatId, videoFileId)).message();
        MessageTest.checkMessage(message);
        VideoTest.check(message.video());

        message = bot.execute(new SendVideo(chatId, new File(videoFile))).message();
        MessageTest.checkMessage(message);
        VideoTest.check(message.video());

        byte[] bytes = Files.readAllBytes(new File(videoFile).toPath());
        String caption = "my video";
        Integer duration = 100;
        message = bot.execute(new SendVideo(chatId, bytes).caption(caption).duration(duration).height(1).width(2)).message();
        MessageTest.checkMessage(message);
        assertEquals(caption, message.caption());

        Video video = message.video();
        VideoTest.check(message.video());
        assertEquals(duration, video.duration());
        assertEquals((Integer) 120, video.height());
        assertEquals((Integer) 400, video.width());
    }

    @Test
    public void sendVoice() throws IOException {
        Message message = bot.execute(new SendVoice(chatId, voiceFileId)).message();
        MessageTest.checkMessage(message);
        VoiceTest.check(message.voice());

        message = bot.execute(new SendVoice(chatId, new File(audioFile))).message();
        MessageTest.checkMessage(message);
        VoiceTest.check(message.voice());

        byte[] array = Files.readAllBytes(new File(audioFile).toPath());
        String caption = "caption";
        Integer duration = 100;
        message = bot.execute(new SendVoice(chatId, array).caption(caption).duration(duration)).message();
        MessageTest.checkMessage(message);
        assertEquals(caption, message.caption());
        VoiceTest.check(message.voice());
        assertEquals(duration, message.voice().duration());
    }

    @Test
    public void getWebhookInfo() {
        GetWebhookInfoResponse response = bot.execute(new GetWebhookInfo());
        WebhookInfoTest.check(response.webhookInfo());
    }

    @Test
    public void setWebhook() throws IOException, InterruptedException {
        String url = "https://google.com";
        Integer maxConnections = 100;
        String[] allowedUpdates = {"message", "callback_query"};
        BaseResponse response = bot.execute(new SetWebhook().url(url).certificate(new File(certificateFile))
                .maxConnections(100).allowedUpdates(allowedUpdates));
        assertTrue(response.isOk());

        Thread.sleep(1000);

        WebhookInfo webhookInfo = bot.execute(new GetWebhookInfo()).webhookInfo();
        assertEquals(url, webhookInfo.url());
        assertTrue(webhookInfo.hasCustomCertificate());
        assertEquals(maxConnections, webhookInfo.maxConnections());
        assertEquals(allowedUpdates, webhookInfo.allowedUpdates());
        assertNotNull(webhookInfo.lastErrorDate());
        assertNotNull(webhookInfo.lastErrorMessage());

        response = bot.execute(new SetWebhook().url("https://google.com")
                .certificate(Files.readAllBytes(new File(certificateFile).toPath())).allowedUpdates(""));
        assertTrue(response.isOk());

        Thread.sleep(1000);

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
        String desc = "pengrad_test_game";
        Message message = bot.execute(new SendGame(chatId, desc)).message();
        MessageTest.checkMessage(message);
        Game game = message.game();
        GameTest.check(game);
        assertEquals(desc, game.description());
    }

    @Test
    public void setGameScore() {
        int res = (int) (System.currentTimeMillis() / 1000);
        BaseResponse response = bot.execute(new SetGameScore(chatId, res, "AgAAAPrwAQCj_Q4D2s-51_8jsuU"));
        assertTrue(response.isOk());

        SendResponse sendResponse = (SendResponse) bot.execute(
                new SetGameScore(chatId, res + 1, chatId, 8162).force(true).editMessage(false).disableEditMessage(true));
        GameTest.check(sendResponse.message().game());
    }

    @Test
    public void getGameHighScores() {
        GameHighScore[] scores = bot.execute(new GetGameHighScores(chatId, "AgAAAPrwAQCj_Q4D2s-51_8jsuU")).result();
        GameHighScoreTest.check(scores);

        scores = bot.execute(new GetGameHighScores(chatId, chatId, 8162)).result();
        GameHighScoreTest.check(scores);
    }

    @Test
    public void sendLocation() {
        Float lat = 21.999998f, lng = 105.2f;
        Location location = bot.execute(new SendLocation(chatId, lat, lng)).message().location();
        assertEquals(lat, location.latitude());
        assertEquals(lng, location.longitude());
    }

    @Test
    public void sendVenue() {
        Float lat = 21.999998f, lng = 105.2f;
        String title = "title", address = "addr", frsqrId = "asdfasdf";
        Venue venue = bot.execute(new SendVenue(chatId, lat, lng, title, address).foursquareId(frsqrId)).message().venue();
        assertEquals(lat, venue.location().latitude());
        assertEquals(lng, venue.location().longitude());
        assertEquals(address, venue.address());
        assertEquals(title, venue.title());
        assertEquals(frsqrId, venue.foursquareId());
    }

    @Test
    public void sendContact() {
        String phone = "000111", name = "first", lastName = "last";
        Contact contact = bot.execute(new SendContact(chatId, phone, name).lastName(lastName)).message().contact();
        assertEquals(phone, contact.phoneNumber());
        assertEquals(name, contact.firstName());
        assertEquals(lastName, contact.lastName());
        assertNull(contact.userId());
    }

    @Test
    public void deleteMessage() {
        Message message = bot.execute(new SendMessage(chatId, "message for delete")).message();
        BaseResponse response = bot.execute(new DeleteMessage(chatId, message.messageId()));
        assertTrue(response.isOk());
    }

    @Test
    public void sendChatAction() {
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.typing.name())).isOk());
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
    public void sendVideoNoteFile() throws IOException {
        SendResponse response = bot.execute(new SendVideoNote(chatId, new File(videoNoteFile)).length(20).duration(30));
        VideoNoteCheck.check(response.message().videoNote(), true);

        byte[] bytes = Files.readAllBytes(new File(videoNoteFile).toPath());
        response = bot.execute(new SendVideoNote(chatId, bytes));
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

        BaseResponse response = bot.execute(new AnswerShippingQuery(shippingQueryId,
                new ShippingOption("1", "VNPT", new LabeledPrice("delivery", 100), new LabeledPrice("tips", 50)),
                new ShippingOption("2", "FREE", new LabeledPrice("free delivery", 0))
        ));

        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: QUERY_ID_INVALID", response.description());
        }
    }

    @Test
    public void answerShippingQueryError() {
        ShippingQuery shippingQuery = getLastShippingQuery();
        String shippingQueryId = shippingQuery != null ? shippingQuery.id() : "invalid_query_id";

        BaseResponse response = bot.execute(new AnswerShippingQuery(shippingQueryId, "cant delivery so far"));

        if (!response.isOk()) {
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

        BaseResponse response = bot.execute(new AnswerPreCheckoutQuery(preCheckoutQueryId));

        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: QUERY_ID_INVALID", response.description());
        }
    }

    @Test
    public void answerPreCheckoutQueryError() {
        PreCheckoutQuery preCheckoutQuery = getLastPreCheckoutQuery();
        String preCheckoutQueryId = preCheckoutQuery != null ? preCheckoutQuery.id() : "invalid_query_id";

        BaseResponse response = bot.execute(new AnswerPreCheckoutQuery(preCheckoutQueryId, "cant sell to you"));

        if (!response.isOk()) {
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
