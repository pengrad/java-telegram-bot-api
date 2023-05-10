package com.pengrad.telegrambot;

import com.pengrad.telegrambot.checks.*;
import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.model.*;
import com.pengrad.telegrambot.model.botcommandscope.BotCommandScopeAllChatAdministrators;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.passport.*;
import com.pengrad.telegrambot.request.*;
import com.pengrad.telegrambot.response.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static com.pengrad.telegrambot.request.ContentTypes.VIDEO_MIME_TYPE;
import static org.junit.Assert.*;

/**
 * stas
 * 5/2/16.
 */
public class TelegramBotTest {

    private static final Properties props = new Properties();

    static String getProp(String key) {
        return props.getProperty(key, System.getenv(key));
    }

    static {
        try {
            props.load(Files.newInputStream(Paths.get("local.properties")));
        } catch (Exception ignored) {
        }

        String chat = getProp("CHAT_ID");
        String group = getProp("GROUP_ID");
        chatId = Long.parseLong(chat);
        groupId = Long.parseLong(group);

        privateKey = getProp("PRIVATE_KEY");
        testPassportData = getProp("TEST_PASSPORT_DATA");
        testCallbackQuery = getProp("TEST_CALLBACK_QUERY");
        testInlineQuery = getProp("TEST_INLINE_QUERY");
        testChosenInlineResult = getProp("TEST_CHOSEN_INLINE_RESULT");
        testPollAnswer = getProp("TEST_POLL_ANSWER");
    }

    public static TelegramBot createTestBot() {
        boolean localBuild = new File("local.properties").exists();
        String token = getProp("TEST_TOKEN");

        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder()
                .connectTimeout(75, TimeUnit.SECONDS)
                .writeTimeout(75, TimeUnit.SECONDS)
                .readTimeout(75, TimeUnit.SECONDS)
                .addInterceptor(new RetryInterceptor(1000));
        if (localBuild) {
            okHttpBuilder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }
        return new TelegramBot.Builder(token).okHttpClient(okHttpBuilder.build()).build();
    }

    static TelegramBot bot = createTestBot();
    static Long chatId;
    static Long groupId;
    Integer forwardMessageId = 33263;
    Integer forwardMessageIdUser = 23714;
    String stickerId = "BQADAgAD4AAD9HsZAAGVRXVaYXiJVAI";
    String channelName = "@bottest";
    Long channelId = -1001002720332L;
    Long memberBot = 215003245L;
    Long localGroup = -1001431704825L;
    Long forum = -1001833520519L;
    Integer forumEditThread = 3;
    static String privateKey;
    static String testPassportData;
    static String testCallbackQuery;
    static String testInlineQuery;
    static String testChosenInlineResult;
    static String testPollAnswer;

    static Path resourcePath = Paths.get("src/test/resources");
    static File imageFile = resourcePath.resolve("image.jpg").toFile();
    static byte[] imageBytes;
    static File stickerFile = resourcePath.resolve("imageSticker.png").toFile();
    static File stickerFileAnim = resourcePath.resolve("sticker_anim.tgs").toFile();
    static File stickerFileVid = resourcePath.resolve("sticker_vid.webm").toFile();
    static File audioFile = resourcePath.resolve("beep.mp3").toFile();
    static byte[] audioBytes;
    static File docFile = resourcePath.resolve("dummy.pdf").toFile();
    static byte[] docBytes;
    static File videoFile = resourcePath.resolve("tabs.mp4").toFile();
    static byte[] videoBytes;
    static File videoNoteFile = resourcePath.resolve("video_note.mp4").toFile();
    static byte[] videoNoteBytes;
    static String certificateFile = resourcePath.resolve("cert.pem").toString();
    static String someUrl = "http://google.com/";
    static String audioFileId = "CQADAgADXAADgNqgSevw7NljQE4lAg";
    static String docFileId = "BQADAgADuwADgNqYSaVAUsHMq6hqAg";
    static String voiceFileId = "AwADAgADYwADuYNZSZww_hkrzCIpAg";
    static String videoFileId = "BAADAgADZAADuYNZSXhLnzJTZ2yvAg";
    static String photoFileId = "AgADAgADDKgxG7mDWUlvyFIJ9XfF9yszSw0ABBhVadWwbAK1z-wIAAEC";
    static String gifFileId = "CgADAgADfQADgNqgSTt9SzatJhc3FgQ";
    static String withSpaceFileId = "BAADAgADZwADkg-4SQI5WM0SPNHrAg";
    static String stickerSet = "testset_by_pengrad_test_bot";
    static String stickerSetAnim = "testset_anim_by_pengrad_test_bot";
    //    static String imageUrl = "https://telegram.org/img/t_logo.png";
    static File thumbFile = resourcePath.resolve("thumb.jpg").toFile();
    static byte[] thumbBytes;
    static Long thumbSize = 3718L;
    static File gifFile = resourcePath.resolve("anim3.gif").toFile();
    static byte[] gifBytes;

    static {
        try {
            imageBytes = Files.readAllBytes(imageFile.toPath());
            audioBytes = Files.readAllBytes(audioFile.toPath());
            docBytes = Files.readAllBytes(docFile.toPath());
            videoBytes = Files.readAllBytes(videoFile.toPath());
            videoNoteBytes = Files.readAllBytes(videoNoteFile.toPath());
            thumbBytes = Files.readAllBytes(thumbFile.toPath());
            gifBytes = Files.readAllBytes(gifFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getMe() {
        GetMeResponse response = bot.getMe().execute();
        User user = response.user();
        UserTest.checkUser(user);
        assertTrue(user.isBot());
        assertFalse(user.canJoinGroups()); // can be changed via BotFather
        assertTrue(user.canReadAllGroupMessages());
        assertTrue(user.supportsInlineQueries());
        assertFalse(user.isPremium());
        assertFalse(user.addedToAttachmentMenu());
    }

    @Test
    public void getUpdates() {
        GetUpdates getUpdates = bot.getUpdates()
                .offset(874227176)
                .allowedUpdates("")
                .timeout(0)
                .limit(100);
        assertEquals(100, getUpdates.getLimit());
        GetUpdatesResponse response = getUpdates.execute();
        UpdateTest.check(response.updates());
    }

    @Test
    public void getFile() throws IOException {
        GetFileResponse response = bot.getFile(withSpaceFileId).execute();
        FileTest.check(response.file());
        String path = bot.getFullFilePath(response.file());

        Request request = new Request.Builder().head().url(path).build();
        Response pathResponse = new OkHttpClient().newCall(request).execute();
        assertTrue(pathResponse.isSuccessful());
    }

    @Test
    public void kickChatMember() {
        BaseResponse response = bot.kickChatMember(channelName, chatId).untilDate(123).revokeMessages(true).execute();
        assertFalse(response.isOk());
        assertEquals(400, response.errorCode());
        assertEquals("Bad Request: can't remove chat owner", response.description());
    }

    @Test
    public void banChatMember() {
        BaseResponse response = bot.banChatMember(channelName, chatId).untilDate(123).revokeMessages(true).execute();
        assertFalse(response.isOk());
        assertEquals(400, response.errorCode());
        assertEquals("Bad Request: can't remove chat owner", response.description());
    }

    @Test
    public void unbanChatMember() {
        BaseResponse response = bot.unbanChatMember(channelName, chatId).execute();
        assertFalse(response.isOk());
        assertEquals(400, response.errorCode());
        assertEquals("Bad Request: can't remove chat owner", response.description());

        // returns true for non-banned member with onlyIfBanned(true)
        response = bot.unbanChatMember(channelName, chatId).onlyIfBanned(true).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void restrictChatMember() {
        ChatPermissions permissions = new ChatPermissions()
                .canChangeInfo(true)
                .canInviteUsers(true)
                .canPinMessages(true)
                .canSendAudios(true)
                .canSendDocuments(true)
                .canSendPhotos(true)
                .canSendVideos(true)
                .canSendVideoNotes(true)
                .canSendVoiceNotes(true)
                .canSendPolls(true); // implies can_send_messages

        BaseResponse response = bot.restrictChatMember(groupId, memberBot, permissions)
                        .untilDate((int) (System.currentTimeMillis() / 1000) + 5)
                        .useIndependentChatPermissions(false)
                        .execute();
        assertTrue(response.isOk());
    }

    @Test
    public void promoteChatMember() {
        BaseResponse response = bot.promoteChatMember(groupId, memberBot)
                        .isAnonymous(false)
                        .canChangeInfo(false)
                        .canPostMessages(false)
                        .canEditMessages(false)
                        .canDeleteMessages(false)
                        .canInviteUsers(false)
                        .canRestrictMembers(false)
                        .canPinMessages(false)
                        .canManageChat(false)
                        .canManageVoiceChats(false)
                        .canManageVideoChats(false)
                        .canManageTopics(false)
                        .canPromoteMembers(true)
                        .execute();
        assertTrue(response.isOk());
    }

    @Test
    public void editMessageText() {
        String text = "Update " + System.currentTimeMillis();

        BaseResponse response = bot.editMessageText(chatId, 925, text)
                .parseMode(ParseMode.Markdown)
                .disableWebPagePreview(true)
                .replyMarkup(new InlineKeyboardMarkup())
                .execute();
        assertTrue(response.isOk());
        assertNotNull(((SendResponse) response).message().editDate());

        response = bot.editMessageText(channelName, 306, text).execute();
        assertTrue(response.isOk());

        response = bot.editMessageText("AgAAAN3wAQCj_Q4DjX4ok5VEUZU", text).execute();
        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: MESSAGE_ID_INVALID", response.description());
        }
    }

    @Test
    public void editMessageCaption() {
        String text = "Update " + System.currentTimeMillis() + " <b>bold</b>";

        SendResponse sendResponse = (SendResponse) bot.editMessageCaption(chatId, 8124)
                .caption(text)
                .parseMode(ParseMode.HTML)
                .replyMarkup(new InlineKeyboardMarkup())
                .execute();
        assertTrue(sendResponse.isOk());

        Message message = sendResponse.message();
        assertEquals(text.replace("<b>", "").replace("</b>", ""), message.caption());

        MessageEntity captionEntity = message.captionEntities()[0];
        assertEquals(MessageEntity.Type.bold, captionEntity.type());
        assertEquals((Integer) 21, captionEntity.offset());
        assertEquals((Integer) 4, captionEntity.length());

        BaseResponse response = bot.editMessageCaption(channelName, 511).caption(text).execute();
        assertTrue(response.isOk());

        response = bot.editMessageCaption("AgAAAPrwAQCj_Q4D2s-51_8jsuU").caption(text).execute();
        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: MESSAGE_ID_INVALID", response.description());
        }
    }

    @Test
    public void editMessageReplyMarkup() {
        String text = "Update" + System.currentTimeMillis();

        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup(new InlineKeyboardButton(text).url("https://google.com"));
        InlineKeyboardMarkup gameKeyboard = new InlineKeyboardMarkup(new InlineKeyboardButton(text).callbackGame("test game"));

        BaseResponse response = bot.editMessageReplyMarkup(chatId, 8124).replyMarkup(keyboard).execute();
        assertTrue(response.isOk());

        response = bot.editMessageReplyMarkup(channelName, 511).replyMarkup(keyboard).execute();
        assertTrue(response.isOk());

        response = bot.editMessageReplyMarkup("AgAAAPrwAQCj_Q4D2s-51_8jsuU").replyMarkup(gameKeyboard).execute();
        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: MESSAGE_ID_INVALID", response.description());
        }
    }

    @Test
    public void answerInline() {
        // inlineQuery sent by client after typing "@bot query" in message field
        InlineQuery inlineQuery = BotUtils.parseUpdate(testInlineQuery).inlineQuery();

        String inlineQueryId = inlineQuery.id();
        assertFalse(inlineQueryId.isEmpty());
        UserTest.checkUser(inlineQuery.from(), true);
        assertEquals(Long.valueOf(12345), inlineQuery.from().id());
        assertEquals("if", inlineQuery.query());
        assertEquals("offset", inlineQuery.offset());
        assertNull(inlineQuery.location());


        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(
                new InlineKeyboardButton("inline game").callbackGame("pengrad test game description"),
                new InlineKeyboardButton("inline ok").callbackData("callback ok"),
                new InlineKeyboardButton("cancel").callbackData("callback cancel"),
                new InlineKeyboardButton("url").url(someUrl),
                new InlineKeyboardButton("switch inline").switchInlineQuery("query"),
                new InlineKeyboardButton("switch inline current").switchInlineQueryCurrentChat("query"));

        InlineQueryResult<?>[] results = new InlineQueryResult[]{
                new InlineQueryResultArticle("1", "title",
                        new InputTextMessageContent("message")
                                .entities(new MessageEntity(MessageEntity.Type.bold, 0, 2))
                                .disableWebPagePreview(false).parseMode(ParseMode.HTML))
                        .url(someUrl).hideUrl(true).description("desc")
                        .thumbUrl(someUrl).thumbHeight(100).thumbWidth(100),
                new InlineQueryResultArticle("2", "title",
                        new InputContactMessageContent("123123123", "na,e").lastName("lastName").vcard("qr vcard")),
                new InlineQueryResultArticle("3", "title", new InputLocationMessageContent(50f, 50f)
                        .livePeriod(60).heading(100).horizontalAccuracy(10f).proximityAlertRadius(500)),
                new InlineQueryResultArticle("4", "title",
                        new InputVenueMessageContent(50f, 50f, "title", "address")
                                .googlePlaceId("ggId").googlePlaceType("gType")
                                .foursquareId("sqrId").foursquareType("frType")),
                new InlineQueryResultArticle("4b", "title",
                        new InputInvoiceMessageContent("title", "desc", "payload", "token", "USD",
                                new LabeledPrice[]{new LabeledPrice("delivery", 100)})
                                .maxTipAmount(0).suggestedTipAmount(new Integer[]{0}).providerData("provider_data")
                                .photoUrl(someUrl).photoSize(100).photoWidth(100).photoHeight(100)
                                .needName(false).needPhoneNumber(false).needEmail(false).needShippingAddress(false)
                                .sendPhoneNumberToProvider(false).sendEmailToProvider(false)
                                .isFlexible(false)),
                new InlineQueryResultArticle("5", "title", "message"),
                new InlineQueryResultAudio("6", someUrl, "title").caption("cap <b>bold</b>").parseMode(ParseMode.HTML).performer("perf").audioDuration(100),
                new InlineQueryResultContact("7", "123123123", "name").lastName("lastName").vcard("tt vcard")
                        .thumbUrl(someUrl).thumbHeight(100).thumbWidth(100),
                new InlineQueryResultDocument("8", someUrl, "title", "application/pdf").caption("cap <b>bold</b>").parseMode(ParseMode.HTML).description("desc")
                        .thumbUrl(someUrl).thumbHeight(100).thumbWidth(100),
                new InlineQueryResultGame("9", "pengrad_test_game").replyMarkup(keyboardMarkup),
                new InlineQueryResultGif("10", someUrl, someUrl).caption("cap <b>bold</b>").parseMode(ParseMode.HTML).title("title")
                        .thumbMimeType("image/gif")
                        .gifHeight(100).gifWidth(100).gifDuration(100),
                new InlineQueryResultLocation("11", 50f, 50f, "title").livePeriod(60)
                        .heading(100).horizontalAccuracy(10f).proximityAlertRadius(500)
                        .thumbUrl(someUrl).thumbHeight(100).thumbWidth(100),
                new InlineQueryResultMpeg4Gif("12", someUrl, someUrl).caption("cap <b>bold</b>").parseMode(ParseMode.HTML).title("title")
                        .thumbMimeType("image/gif")
                        .mpeg4Height(100).mpeg4Width(100).mpeg4Duration(100),
                new InlineQueryResultPhoto("13", someUrl, someUrl).photoWidth(100).photoHeight(100).title("title")
                        .description("desc").caption("cap <b>bold</b>").parseMode(ParseMode.HTML),
                new InlineQueryResultPhoto("131", someUrl, someUrl).photoWidth(100).photoHeight(100).title("title")
                        .description("desc").caption("bold").captionEntities(new MessageEntity(MessageEntity.Type.bold, 0, 2)),
                new InlineQueryResultVenue("14", 54f, 55f, "title", "address")
                        .foursquareId("frsqrId").foursquareType("frType")
                        .googlePlaceId("ggId").googlePlaceType("gType")
                        .thumbUrl(someUrl).thumbHeight(100).thumbWidth(100)
                        .thumbnailUrl(someUrl).thumbnailHeight(100).thumbnailWidth(100),
                new InlineQueryResultVideo("15", someUrl, VIDEO_MIME_TYPE, "text", someUrl, "title").caption("cap <b>bold</b>").parseMode(ParseMode.HTML)
                        .videoWidth(100).videoHeight(100).videoDuration(100).description("desc"),
                new InlineQueryResultVoice("16", someUrl, "title").caption("cap <b>bold</b>").parseMode(ParseMode.HTML).voiceDuration(100),
                new InlineQueryResultCachedAudio("17", audioFileId).caption("cap <b>bold</b>").parseMode(ParseMode.HTML),
                new InlineQueryResultCachedDocument("18", stickerId, "title").caption("cap <b>bold</b>").parseMode(ParseMode.HTML).description("desc"),
                new InlineQueryResultCachedGif("19", gifFileId).caption("cap <b>bold</b>").parseMode(ParseMode.HTML).title("title"),
                new InlineQueryResultCachedMpeg4Gif("21", gifFileId).caption("cap <b>bold</b>").parseMode(ParseMode.HTML).title("title"),
                new InlineQueryResultCachedPhoto("22", photoFileId).caption("cap <b>bold</b>").parseMode(ParseMode.HTML).description("desc").title("title"),
                new InlineQueryResultCachedSticker("23", stickerId),
                new InlineQueryResultCachedVideo("24", videoFileId, "title").caption("cap <b>bold</b>").parseMode(ParseMode.HTML).description("desc"),
                new InlineQueryResultCachedVoice("25", voiceFileId, "title").caption("cap <b>bold</b>").parseMode(ParseMode.HTML),
        };

        BaseResponse response = bot.answerInlineQuery(inlineQueryId, results)
                .cacheTime(100)
                .isPersonal(true)
                .nextOffset("offset")
                .switchPmText("go pm")
                .switchPmParameter("my_pm_parameter")
                .execute();

        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: query is too old and response timeout expired or query ID is invalid", response.description());
        }
    }

    @Test
    public void chosenInlineResult() {
        // chosenInlineResult is sent after user choose result from AnswerInlineQuery
        // should be enabled for bot https://core.telegram.org/bots/inline#collecting-feedback
        ChosenInlineResult inlineResult = BotUtils.parseUpdate(testChosenInlineResult).chosenInlineResult();

        assertNotNull(inlineResult);
        assertFalse(inlineResult.resultId().isEmpty());
        UserTest.checkUser(inlineResult.from(), true);
        assertEquals(Long.valueOf(12345), inlineResult.from().id());
        assertEquals("hi", inlineResult.query());
        assertEquals("1", inlineResult.resultId());
        assertNull(inlineResult.inlineMessageId());
        assertNull(inlineResult.location());
    }

    @Test
    public void answerCallback() {
        // callbackQuery sent by client after pressing on InlineKeyboardButton (used in sendGame() test)
        CallbackQuery callbackQuery = BotUtils.parseUpdate(testCallbackQuery).callbackQuery();

        assertNotNull(callbackQuery);
        assertFalse(callbackQuery.id().isEmpty());
        UserTest.checkUser(callbackQuery.from(), true);
        assertEquals(chatId, callbackQuery.from().id());
        MessageTest.checkMessage(callbackQuery.message());
        assertFalse(callbackQuery.chatInstance().isEmpty());
        assertEquals("pengrad_test_game", callbackQuery.gameShortName());
        assertNull(callbackQuery.inlineMessageId());
        assertNull(callbackQuery.data());

        BaseResponse response = bot.answerCallbackQuery(callbackQuery.id())
                .text("answer callback")
                .url("telegram.me/pengrad_test_bot?game=pengrad_test_game")
                .showAlert(false)
                .cacheTime(1).execute();

        assertFalse(response.isOk());
        assertEquals(400, response.errorCode());
        assertEquals("Bad Request: query is too old and response timeout expired or query ID is invalid", response.description());
    }

    @Test
    public void getChat() throws MalformedURLException, URISyntaxException {
        Chat chat = bot.getChat(groupId).execute().chat();
        ChatTest.checkChat(chat, true);
        assertEquals(Chat.Type.supergroup, chat.type());
        assertTrue(chat.title().contains("Test Bot Group"));
        assertTrue(chat.description().contains("New desc"));
        assertEquals(Integer.valueOf(10), chat.slowModeDelay());
        assertNotNull(new URL(chat.inviteLink()).toURI());
        if (chat.pinnedMessage() != null) MessageTest.checkMessage(chat.pinnedMessage());
        assertNull(chat.stickerSetName());
        assertFalse(chat.canSetStickerSet());
        assertEquals(channelId, chat.linkedChatId());
        assertFalse(chat.joinByRequest());
        assertFalse(chat.hasProtectedContent());
        assertNull(chat.messageAutoDeleteTime());
        assertFalse(chat.isForum());
        assertFalse(chat.hasRestrictedVoiceAndVideoMessages());
        assertFalse(chat.hasHiddenMembers());
        assertFalse(chat.hasAggressiveAntiSpamEnabled());
        assertNull(chat.getActiveUsernames());
        assertNull(chat.getEmojiStatusCustomEmojiId());

        chat = bot.getChat(chatId).execute().chat();
        assertNotNull(chat.firstName());
        assertNull(chat.lastName());
        assertEquals("yo", chat.bio());
        assertTrue(chat.hasPrivateForwards());

        chat = bot.getChat(localGroup).execute().chat();
        ChatLocation location = chat.location();
        assertNotNull(location);
        assertEquals(60.94062f, location.location().latitude(), 0f);
        assertEquals(76.58071f, location.location().longitude(), 0f);
        assertTrue(location.address().endsWith("Russia"));
        assertTrue(chat.joinToSendMessages());
    }

    @Test
    public void leaveChat() {
        BaseResponse response = bot.leaveChat(chatId).execute();
        assertFalse(response.isOk());
        assertEquals(400, response.errorCode());
        assertEquals("Bad Request: chat member status can't be changed in private chats", response.description());
    }

    @Test
    public void getChatAdministrators() {
        GetChatAdministratorsResponse response = bot.getChatAdministrators(groupId).execute();
        for (ChatMember chatMember : response.administrators()) {
            ChatMemberTest.check(chatMember);
            if (chatMember.user().firstName().equals("Test Bot")) {
                assertFalse(chatMember.canBeEdited());
                assertTrue(chatMember.canChangeInfo());
                assertTrue(chatMember.canDeleteMessages());
                assertTrue(chatMember.canInviteUsers());
                assertTrue(chatMember.canRestrictMembers());
                assertTrue(chatMember.canPinMessages());
                assertTrue(chatMember.canPromoteMembers());
                assertTrue(chatMember.canManageVoiceChats());
                assertTrue(chatMember.canManageChat());
            }
        }
    }

    @Test
    public void getChatMember() {
        restrictChatMember();
        ChatMember chatMember = bot.getChatMember(groupId, memberBot).execute().chatMember();
        ChatMemberTest.check(chatMember);
        assertEquals(ChatMember.Status.restricted, chatMember.status());
        assertEquals(Integer.valueOf(0), chatMember.untilDate());
        assertNull(chatMember.canPostMessages());
        assertNull(chatMember.canEditMessages());
        assertTrue(chatMember.isMember());
        assertTrue(chatMember.canChangeInfo());
        assertTrue(chatMember.canInviteUsers());
        assertTrue(chatMember.canPinMessages());
        assertTrue(chatMember.canSendPolls());
        assertTrue(chatMember.canSendMessages());
        assertTrue(chatMember.canSendAudios());
        assertTrue(chatMember.canSendDocuments());
        assertTrue(chatMember.canSendPhotos());
        assertTrue(chatMember.canSendVideos());
        assertTrue(chatMember.canSendVideoNotes());
        assertTrue(chatMember.canSendVoiceNotes());
        assertFalse(chatMember.canSendOtherMessages());
        assertFalse(chatMember.canAddWebPagePreviews());
        assertTrue(chatMember.canManageTopics());
    }

    @Test
    public void getChatMembersCount() {
        GetChatMembersCountResponse response = bot.getChatMembersCount(chatId).execute();
        assertEquals(2, response.count());
    }

    @Test
    public void getChatMemberCount() {
        GetChatMemberCountResponse response = bot.getChatMemberCount(chatId).execute();
        assertEquals(2, response.count());
    }

    @Test
    public void getUserProfilePhotos() {
        int offset = 0;
        GetUserProfilePhotosResponse response = bot.getUserProfilePhotos(chatId).limit(100).offset(offset).execute();
        UserProfilePhotos photos = response.photos();
        assertEquals(photos.totalCount() - offset, photos.photos().length);
        for (PhotoSize[] photo : photos.photos()) {
            PhotoSizeTest.checkPhotos(photo);
        }

        if (photos.totalCount() > 1) {
            photos = bot.getUserProfilePhotos(chatId).limit(1).execute().photos();
            assertEquals(1, photos.photos().length);
        }
    }

    @Test
    public void sendMessage() {
        SendResponse sendResponse = bot.sendMessage(chatId, "reply this message")
                .replyMarkup(new ForceReply().inputFieldPlaceholder("input-placeholder").selective(true))
                .execute();
        MessageTest.checkTextMessage(sendResponse.message());
        assertNotNull(sendResponse.message().from());

        sendResponse = bot.sendMessage(chatId, "remove keyboard")
                .replyMarkup(new ReplyKeyboardRemove())
                .disableNotification(true)
                .replyToMessageId(8087)
                .execute();
        MessageTest.checkTextMessage(sendResponse.message());
        assertNotNull(sendResponse.message().replyToMessage());

        sendResponse = bot.sendMessage(chatId, "message with keyboard")
                .parseMode(ParseMode.HTML)
                .disableWebPagePreview(false)
                .protectContent(true)
                .replyMarkup(new ReplyKeyboardMarkup(
                        new KeyboardButton("contact").requestContact(true),
                        new KeyboardButton("location").requestLocation(true),
                        new KeyboardButton("user").requestUser(
                                new KeyboardButtonRequestUser(123).userIsBot(false).userIsPremium(false)),
                        new KeyboardButton("chat").requestChat(
                                new KeyboardButtonRequestChat(321, false)
                                        .chatIsForum(false).chatHasUsername(false).chatIsCreated(true)
                                        .userAdministratorRights(new ChatAdministratorRights().canChangeInfo(true))
                                        .botAdministratorRights(new ChatAdministratorRights().canChangeInfo(true))
                                        .botIsMember(true)))
                        .oneTimeKeyboard(true)
                        .resizeKeyboard(true)
                        .inputFieldPlaceholder("input-placeholder")
                        .isPersistent(false)
                        .selective(true))
                .execute();
        assertTrue(sendResponse.message().hasProtectedContent());
        MessageTest.checkTextMessage(sendResponse.message());

        sendResponse = bot.sendMessage(chatId, "simple buttons")
                .replyMarkup(new ReplyKeyboardMarkup("ok", "cancel"))
                .execute();
        MessageTest.checkTextMessage(sendResponse.message());
    }

    @Test
    public void sendMessageToChannel() {
        String url = "https://google.com/";
        SendMessage request = bot.sendMessage(channelName, "channel message [GG](" + url + ")").parseMode(ParseMode.Markdown);
        SendResponse sendResponse = request.execute();
        Message message = sendResponse.message();
        MessageTest.checkTextMessage(message);
        assertEquals(url, message.entities()[0].url());
        assertEquals(channelId, message.senderChat().id());
    }

    @Test
    public void sendMessageToChannelId() {
        SendMessage request = bot.sendMessage(channelId, "channel by id message");
        SendResponse sendResponse = request.execute();
        Message message = sendResponse.message();
        MessageTest.checkTextMessage(message);
    }

    @Test
    public void forwardMessage() {
        SendResponse response = bot.forwardMessage(chatId, chatId, forwardMessageId).disableNotification(true).execute();
        Message message = response.message();
        MessageTest.checkMessage(message);
        assertNotNull(message.forwardDate());
        assertNotNull(message.forwardSenderName());
        assertNull(message.forwardFrom());
        User viaBot = message.viaBot();
        UserTest.checkUser(viaBot);
        assertEquals("gif", viaBot.username());

        // message from user with open account
        message = bot.forwardMessage(chatId, chatId, forwardMessageIdUser).execute().message();
        MessageTest.checkMessage(message);
        assertNotNull(message.forwardDate());
        assertNull(message.forwardSenderName());
        assertNotNull(message.forwardFrom());

        message = bot.forwardMessage(channelName, channelName, 651).execute().message();
        assertNotNull(message.authorSignature());
        assertNotNull(message.forwardSignature());
        assertEquals(Integer.valueOf(651), message.forwardFromMessageId());
        Chat chat = message.forwardFromChat();
        assertEquals(channelName, "@" + chat.username());
        assertEquals(Chat.Type.channel, chat.type());
        assertNull(message.forwardSenderName());

        message = bot.forwardMessage(chatId, groupId, 352).messageThreadId(0).execute().message();
        assertEquals(MessageEntity.Type.text_mention, message.entities()[0].type());
        assertNotNull(message.entities()[0].user());
        assertNotNull(message.forwardSenderName());
    }

    @Test
    public void copyMessage() {
        MessageIdResponse response = bot.copyMessage(chatId, chatId, forwardMessageId)
                .messageThreadId(0)
                .caption("new **caption**")
                .parseMode(ParseMode.MarkdownV2)
                .captionEntities(new MessageEntity(MessageEntity.Type.bold, 0, 1))
                .allowSendingWithoutReply(false)
                .replyToMessageId(1)
                .disableNotification(true)
                .execute();
        assertTrue(response.messageId() > 0);
    }

    @Test
    public void sendAudio() {
        Message message = bot.sendAudio(chatId, audioFileId)
                .caption("caption").captionEntities(new MessageEntity(MessageEntity.Type.italic, 0, 7))
                .execute().message();
        MessageTest.checkMessage(message);
        AudioTest.checkAudio(message.audio(), false);
        MessageEntity captionEntity = message.captionEntities()[0];
        assertEquals(MessageEntity.Type.italic, captionEntity.type());
        assertEquals((Integer) 0, captionEntity.offset());
        assertEquals((Integer) 7, captionEntity.length());

        message = bot.sendAudio(chatId, audioFile).thumb(thumbFile).execute().message();
        MessageTest.checkMessage(message);
        AudioTest.checkAudio(message.audio());
        assertEquals(thumbSize, message.audio().thumb().fileSize());

        String cap = "http://ya.ru  <b>bold</b> #audio @pengrad_test_bot", title = "title", performer = "performer";
        ParseMode parseMode = ParseMode.HTML;
        int duration = 100;
        SendAudio sendAudio = bot.sendAudio(chatId, audioBytes).thumb(thumbBytes).duration(duration)
                .caption(cap).parseMode(parseMode).performer(performer).title(title);
        message = sendAudio.execute().message();
        MessageTest.checkMessage(message);

        Audio audio = message.audio();
        AudioTest.checkAudio(audio);
        assertEquals(cap.replace("<b>", "").replace("</b>", ""), message.caption());
        assertEquals((Integer) 100, audio.duration());
        assertEquals(performer, audio.performer());
        assertEquals(title, audio.title());
        assertEquals(thumbSize, audio.thumb().fileSize());

        captionEntity = message.captionEntities()[0];
        assertEquals(MessageEntity.Type.url, captionEntity.type());
        assertEquals((Integer) 0, captionEntity.offset());
        assertEquals((Integer) 12, captionEntity.length());

        captionEntity = message.captionEntities()[1];
        assertEquals(MessageEntity.Type.bold, captionEntity.type());
        assertEquals((Integer) 14, captionEntity.offset());
        assertEquals((Integer) 4, captionEntity.length());

        assertEquals(MessageEntity.Type.hashtag, message.captionEntities()[2].type());
    }

    @Test
    public void underlineStrikethroughMessageEntity() {
        String cap = "<u>under1</u> <ins>under2</ins> <s>strike1</s> <strike>strike2</strike> <del>strike3</del>";
        cap += " <u><del>nested-tag</del></u>";
        ParseMode parseMode = ParseMode.HTML;
        SendAudio sendAudio = bot.sendAudio(chatId, audioFileId).caption(cap).parseMode(parseMode);
        Message message = sendAudio.execute().message();
        MessageTest.checkMessage(message);

        String htmlCaption = cap
                .replace("<u>", "").replace("</u>", "")
                .replace("<ins>", "").replace("</ins>", "")
                .replace("<s>", "").replace("</s>", "")
                .replace("<strike>", "").replace("</strike>", "")
                .replace("<del>", "").replace("</del>", "");
        assertEquals(htmlCaption, message.caption());

        assertEquals(7, message.captionEntities().length);

        MessageEntity captionEntity = message.captionEntities()[0];
        assertEquals(MessageEntity.Type.underline, captionEntity.type());
        assertEquals((Integer) 0, captionEntity.offset());
        assertEquals((Integer) 6, captionEntity.length());

        captionEntity = message.captionEntities()[1];
        assertEquals(MessageEntity.Type.underline, captionEntity.type());
        assertEquals((Integer) 7, captionEntity.offset());
        assertEquals((Integer) 6, captionEntity.length());

        captionEntity = message.captionEntities()[2];
        assertEquals(MessageEntity.Type.strikethrough, captionEntity.type());
        assertEquals((Integer) 14, captionEntity.offset());
        assertEquals((Integer) 7, captionEntity.length());

        captionEntity = message.captionEntities()[3];
        assertEquals(MessageEntity.Type.strikethrough, captionEntity.type());
        assertEquals((Integer) 22, captionEntity.offset());
        assertEquals((Integer) 7, captionEntity.length());

        captionEntity = message.captionEntities()[4];
        assertEquals(MessageEntity.Type.strikethrough, captionEntity.type());
        assertEquals((Integer) 30, captionEntity.offset());
        assertEquals((Integer) 7, captionEntity.length());

        captionEntity = message.captionEntities()[5];
        assertEquals(MessageEntity.Type.underline, captionEntity.type());
        assertEquals((Integer) 38, captionEntity.offset());
        assertEquals((Integer) 10, captionEntity.length());

        captionEntity = message.captionEntities()[6];
        assertEquals(MessageEntity.Type.strikethrough, captionEntity.type());
        assertEquals((Integer) 38, captionEntity.offset());
        assertEquals((Integer) 10, captionEntity.length());
    }

    @Test
    public void underlineStrikethroughMarkdown() {
        String cap = "__under1__ ~strike1~ __~nested~__";
        ParseMode parseMode = ParseMode.MarkdownV2;
        SendAudio sendAudio = bot.sendAudio(chatId, audioFileId).caption(cap).parseMode(parseMode);
        Message message = sendAudio.execute().message();
        MessageTest.checkMessage(message);

        String htmlCaption = cap.replace("__", "").replace("~", "");
        assertEquals(htmlCaption, message.caption());

        assertEquals(4, message.captionEntities().length);

        MessageEntity captionEntity = message.captionEntities()[0];
        assertEquals(MessageEntity.Type.underline, captionEntity.type());
        assertEquals((Integer) 0, captionEntity.offset());
        assertEquals((Integer) 6, captionEntity.length());

        captionEntity = message.captionEntities()[1];
        assertEquals(MessageEntity.Type.strikethrough, captionEntity.type());
        assertEquals((Integer) 7, captionEntity.offset());
        assertEquals((Integer) 7, captionEntity.length());

        captionEntity = message.captionEntities()[2];
        assertEquals(MessageEntity.Type.underline, captionEntity.type());
        assertEquals((Integer) 15, captionEntity.offset());
        assertEquals((Integer) 6, captionEntity.length());

        captionEntity = message.captionEntities()[3];
        assertEquals(MessageEntity.Type.strikethrough, captionEntity.type());
        assertEquals((Integer) 15, captionEntity.offset());
        assertEquals((Integer) 6, captionEntity.length());
    }

    @Test
    public void sendSpoilerMessage() {
        SendResponse response = bot.sendMessage(chatId, "ok this is spoiler ha-ha-ha")
                .entities(new MessageEntity(MessageEntity.Type.spoiler, 19, 8)).execute();

        MessageEntity entity = response.message().entities()[0];
        assertEquals(MessageEntity.Type.spoiler, entity.type());
        assertEquals((Integer) 19, entity.offset());
        assertEquals((Integer) 8, entity.length());
    }

    @Test
    public void preMessageEntity() {
        String cap = "```java\n" +
                "String s = new String();\n" +
                "```";
        ParseMode parseMode = ParseMode.MarkdownV2;
        SendAudio sendAudio = bot.sendAudio(chatId, audioFileId).caption(cap).parseMode(parseMode);
        Message message = sendAudio.execute().message();
        MessageTest.checkMessage(message);
        assertEquals(1, message.captionEntities().length);
        assertEquals("java", message.captionEntities()[0].language());
    }

    @Test
    public void sendDocument() {
        Message message = bot.sendDocument(chatId, docFileId).execute().message();
        MessageTest.checkMessage(message);
        DocumentTest.check(message.document());

        message = bot.sendDocument(chatId, docBytes).thumb(thumbBytes).contentType("application/pdf")
                                .caption("caption").captionEntities(new MessageEntity(MessageEntity.Type.italic, 0, 7))
                .execute().message();
        MessageTest.checkMessage(message);
        DocumentTest.check(message.document());
        assertEquals(thumbSize, message.document().thumb().fileSize());
        MessageEntity captionEntity = message.captionEntities()[0];
        assertEquals(MessageEntity.Type.italic, captionEntity.type());
        assertEquals((Integer) 0, captionEntity.offset());
        assertEquals((Integer) 7, captionEntity.length());

        String caption = "caption <b>bold</b>", fileName = "my doc.pdf";
        ParseMode parseMode = ParseMode.HTML;
        message = bot.sendDocument(chatId, docFile).fileName(fileName).thumb(thumbFile).caption(caption).parseMode(parseMode)
                                .disableContentTypeDetection(true).execute().message();
        MessageTest.checkMessage(message);
        DocumentTest.check(message.document());
        assertEquals(caption.replace("<b>", "").replace("</b>", ""), message.caption());
        assertEquals(fileName, message.document().fileName());
        assertEquals(thumbSize, message.document().thumb().fileSize());

        captionEntity = message.captionEntities()[0];
        assertEquals(MessageEntity.Type.bold, captionEntity.type());
        assertEquals((Integer) 8, captionEntity.offset());
        assertEquals((Integer) 4, captionEntity.length());
    }

    @Test
    public void sendPhoto() {
        Message message = bot.sendPhoto(chatId, photoFileId).execute().message();
        MessageTest.checkMessage(message);
        PhotoSizeTest.checkPhotos(false, message.photo());

        message = bot.sendPhoto(chatId, imageFile).hasSpoiler(true)
                .caption("caption").captionEntities(new MessageEntity(MessageEntity.Type.italic, 0, 7))
                .execute().message();
        MessageTest.checkMessage(message);
        PhotoSizeTest.checkPhotos(message.photo());
        MessageEntity captionEntity = message.captionEntities()[0];
        assertEquals(MessageEntity.Type.italic, captionEntity.type());
        assertEquals((Integer) 0, captionEntity.offset());
        assertEquals((Integer) 7, captionEntity.length());

        String caption = "caption <b>bold</b>";
        message = bot.sendPhoto(channelName, imageBytes).caption(caption).parseMode(ParseMode.HTML).execute().message();
        MessageTest.checkMessage(message);
        assertEquals(caption.replace("<b>", "").replace("</b>", ""), message.caption());
        PhotoSizeTest.checkPhotos(message.photo());

        captionEntity = message.captionEntities()[0];
        assertEquals(MessageEntity.Type.bold, captionEntity.type());
        assertEquals((Integer) 8, captionEntity.offset());
        assertEquals((Integer) 4, captionEntity.length());
    }

    @Test
    public void sendSticker() {
        Message message = bot.sendSticker(chatId, stickerFileAnim).emoji("\uD83D\uDE00").execute().message();
        MessageTest.checkMessage(message);
        StickerTest.check(message.sticker(), false, true);
        assertTrue(message.sticker().isAnimated());
        assertEquals("\uD83D\uDE00", message.sticker().emoji());
        assertEquals(Sticker.Type.regular, message.sticker().type());

        message = bot.sendSticker(chatId, stickerId).thumbnail(thumbFile).execute().message();
        MessageTest.checkMessage(message);
        StickerTest.check(message.sticker(), true, false);
        assertFalse(message.sticker().isAnimated());

        message = bot.sendSticker(chatId, imageBytes).thumbnail(thumbBytes).execute().message();
        MessageTest.checkMessage(message);
        StickerTest.check(message.sticker(), false, true);
    }

    @Test
    public void sendVideo() {
        Message message = bot.sendVideo(chatId, videoFileId).hasSpoiler(true).execute().message();
        MessageTest.checkMessage(message);
        VideoTest.check(message.video(), false);

        message = bot.sendVideo(chatId, videoFile)
                .thumb(thumbFile)
                .caption("caption").captionEntities(new MessageEntity(MessageEntity.Type.italic, 0, 7))
                .execute().message();
        MessageTest.checkMessage(message);
        VideoTest.check(message.video());
        assertNotEquals("telegram should generate thumb", thumbSize, message.video().thumb().fileSize());
        assertEquals("tabs.mp4", message.video().fileName());
        MessageEntity captionEntity = message.captionEntities()[0];
        assertEquals(MessageEntity.Type.italic, captionEntity.type());
        assertEquals((Integer) 0, captionEntity.offset());
        assertEquals((Integer) 7, captionEntity.length());

        String caption = "caption <b>bold</b>";
        int duration = 100;
        message = bot.sendVideo(chatId, videoBytes).thumb(thumbBytes)
                                .caption(caption).parseMode(ParseMode.HTML)
                                .duration(duration).height(1).width(2).supportsStreaming(true)
                .execute()
                .message();
        System.out.println(message);
        MessageTest.checkMessage(message);
        assertEquals(caption.replace("<b>", "").replace("</b>", ""), message.caption());

        Video video = message.video();
        VideoTest.check(message.video());
        assertEquals(duration, video.duration().intValue());
        assertEquals(120, video.height().intValue());
        assertEquals(400, video.width().intValue());
        assertEquals("video/mp4", video.mimeType());
        assertNotEquals("telegram should generate thumb", thumbSize, video.thumb().fileSize());

        captionEntity = message.captionEntities()[0];
        assertEquals(MessageEntity.Type.bold, captionEntity.type());
        assertEquals((Integer) 8, captionEntity.offset());
        assertEquals((Integer) 4, captionEntity.length());
    }

    @Test
    public void sendVoice() {
        Message message = bot.sendVoice(chatId, voiceFileId).execute().message();
        MessageTest.checkMessage(message);
        VoiceTest.check(message.voice(), false);

        message = bot.sendVoice(chatId, audioFile).execute().message();
        MessageTest.checkMessage(message);
        VoiceTest.check(message.voice());

        String caption = "caption <b>bold</b>";
        int duration = 100;
        message = bot.sendVoice(chatId, audioBytes).caption(caption).parseMode(ParseMode.HTML).duration(duration)
                .execute().message();
        MessageTest.checkMessage(message);
        assertEquals(caption.replace("<b>", "").replace("</b>", ""), message.caption());
        VoiceTest.check(message.voice());
        assertEquals(duration, message.voice().duration().intValue());

        MessageEntity captionEntity = message.captionEntities()[0];
        assertEquals(MessageEntity.Type.bold, captionEntity.type());
        assertEquals(8, captionEntity.offset().intValue());
        assertEquals(4, captionEntity.length().intValue());
    }

    @Test
    public void getWebhookInfo() {
        GetWebhookInfoResponse response = bot.getWebhookInfo().execute();
        WebhookInfo webhookInfo = response.webhookInfo();
        assertNotNull(webhookInfo.url());
        assertFalse(webhookInfo.hasCustomCertificate());
        assertTrue(webhookInfo.pendingUpdateCount() >= 0);
    }

    @Test
    public void setWebhook() throws IOException {
        String url = "https://google.com";
        Integer maxConnections = 100;
        String[] allowedUpdates = {"message", "callback_query"};
        String ipAddress = "1.1.1.1";
        BaseResponse response = bot.setWebhook()
                .url(url)
                .certificate(new File(certificateFile))
                .ipAddress(ipAddress)
                .maxConnections(100)
                .allowedUpdates(allowedUpdates)
                .secretToken("secret-token")
                .dropPendingUpdates(true)
                .execute();
        assertTrue(response.isOk());

        WebhookInfo webhookInfo = bot.getWebhookInfo().execute().webhookInfo();
        assertEquals(url, webhookInfo.url());
        assertTrue(webhookInfo.hasCustomCertificate());
        assertEquals(maxConnections, webhookInfo.maxConnections());
        assertArrayEquals(allowedUpdates, webhookInfo.allowedUpdates());
        Integer lastErrorDate = webhookInfo.lastErrorDate();
        if (lastErrorDate != null) {
            assertEquals(System.currentTimeMillis(), lastErrorDate * 1000L, 30_000L);
        }
        String lastErrorMessage = webhookInfo.lastErrorMessage();
        if (lastErrorMessage != null) {
            assertTrue(lastErrorMessage.contains("SSL"));
        }
        assertEquals(ipAddress, webhookInfo.ipAddress());
        assertTrue(webhookInfo.pendingUpdateCount() >= 0);

        response = bot.setWebhook().url("https://google.com")
                .certificate(Files.readAllBytes(new File(certificateFile).toPath())).allowedUpdates("").execute();
        assertTrue(response.isOk());

        response = bot.setWebhook().execute();
        assertTrue(response.isOk());
    }

    @Test
    public void deleteWebhook() {
        BaseResponse response = bot.deleteWebhook().dropPendingUpdates(true).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void sendGame() {
        InlineKeyboardButton[] buttons = {
                new InlineKeyboardButton("inline game").callbackGame("pengrad test game description"),
                new InlineKeyboardButton("inline ok").callbackData("callback ok"),
                new InlineKeyboardButton("cancel").callbackData("callback cancel"),
                new InlineKeyboardButton("url").url(someUrl),
                new InlineKeyboardButton("switch inline").switchInlineQuery("query"),
                new InlineKeyboardButton("switch inline current").switchInlineQueryCurrentChat("query"),
        };

        InlineKeyboardButton[][] inlineKeyboard = new InlineKeyboardButton[1][];
        inlineKeyboard[0] = buttons;
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup(inlineKeyboard);

        String desc = "pengrad_test_game";
        Message message = bot.sendGame(chatId, desc).replyMarkup(keyboardMarkup).execute().message();
        MessageTest.checkMessage(message);
        Game game = message.game();
        GameTest.check(game);
        assertEquals(desc, game.description());

        InlineKeyboardButton[] actualButtons = message.replyMarkup().inlineKeyboard()[0];
        assertEquals(buttons.length, actualButtons.length);
        assertNotNull(actualButtons[0].callbackGame());
        for (int i = 1; i < buttons.length; i++) {
            assertEquals(buttons[i].text(), actualButtons[i].text());
            assertFalse(buttons[i].isPay());
        }
        assertEquals(buttons[1].callbackData(), actualButtons[1].callbackData());
        assertEquals(buttons[2].callbackData(), actualButtons[2].callbackData());
        assertEquals(buttons[3].url(), actualButtons[3].url());
        assertEquals(buttons[4].switchInlineQuery(), actualButtons[4].switchInlineQuery());
        assertEquals(buttons[5].switchInlineQueryCurrentChat(), actualButtons[5].switchInlineQueryCurrentChat());
    }

    @Test
    public void setGameScore() {
        int res = (int) (System.currentTimeMillis() / 1000);
        BaseResponse response = bot.setGameScore(chatId, res, "AgAAAPrwAQCj_Q4D2s-51_8jsuU").execute();
        assertTrue(response.isOk());

        SendResponse sendResponse = (SendResponse) bot.setGameScore(chatId, res + 1, chatId, 8162)
                .force(true).disableEditMessage(true).execute();
        GameTest.check(sendResponse.message().game());
    }

    @Test
    public void getGameHighScores() {
        GameHighScore[] scores = bot.getGameHighScores(chatId, "AgAAAPrwAQCj_Q4D2s-51_8jsuU")
                .execute().result();
        GameHighScoreTest.check(scores);

        scores = bot.getGameHighScores(chatId, chatId, 8162).execute().result();
        GameHighScoreTest.check(scores);
    }

    @Test
    public void sendLocation() {
        float lat = 21.999998f, lng = 105.2f, horizontalAccuracy = 1.9f;
        int livePeriod = 60, heading = 120, proximityAlertRadius = 50000;
        Location location = bot.sendLocation(chatId, lat, lng)
                .horizontalAccuracy(horizontalAccuracy)
                .livePeriod(livePeriod)
                .heading(heading)
                .proximityAlertRadius(proximityAlertRadius)
                .execute().message().location();
        assertEquals(lat, location.latitude(), 0.00001f);
        assertEquals(lng, location.longitude(), 0.00001f);
        assertEquals(horizontalAccuracy, location.horizontalAccuracy(), 0.11f);
        assertEquals(livePeriod, location.livePeriod().intValue());
        assertEquals(heading, location.heading().intValue());
        assertEquals(proximityAlertRadius, location.proximityAlertRadius().intValue());
    }

    @Test
    public void sendVenue() {
        float lat = 21.999998f, lng = 105.2f;
        String title = "title", address = "addr", frsqrId = "asdfasdf", frsqrType = "frType";
        Venue venue = bot.sendVenue(chatId, lat, lng, title, address)
                .foursquareId(frsqrId).foursquareType(frsqrType)
                .execute().message().venue();
        assertEquals(lat, venue.location().latitude(), 0f);
        assertEquals(lng, venue.location().longitude(), 0f);
        assertEquals(address, venue.address());
        assertEquals(title, venue.title());
        assertEquals(frsqrId, venue.foursquareId());
        assertEquals(frsqrType, venue.foursquareType());

        String ggId = "ggId", ggType = "library";
        venue = bot.sendVenue(chatId, lat, lng, title, address)
                .googlePlaceId(ggId).googlePlaceType(ggType)
                .execute().message().venue();
        assertEquals(ggId, venue.googlePlaceId());
        assertEquals(ggType, venue.googlePlaceType());
    }

    @Test
    public void sendContact() {
        String phone = "000111", name = "first", lastName = "last", vcard = "ok vcard";
        Contact contact = bot.sendContact(chatId, phone, name).lastName(lastName).vcard(vcard)
                .execute().message().contact();
        assertEquals(phone, contact.phoneNumber());
        assertEquals(name, contact.firstName());
        assertEquals(lastName, contact.lastName());
        assertEquals(vcard, contact.vcard());
        assertNull(contact.userId());
    }

    @Test
    public void deleteMessage() {
        Message message = bot.sendMessage(chatId, "message for delete").execute().message();
        BaseResponse response = bot.deleteMessage(chatId, message.messageId()).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void sendChatAction() {
        assertTrue(bot.sendChatAction(chatId, ChatAction.typing.name()).execute().isOk());
        assertTrue(bot.sendChatAction(chatId, ChatAction.typing).execute().isOk());
        assertTrue(bot.sendChatAction(chatId, ChatAction.upload_photo).execute().isOk());
        assertTrue(bot.sendChatAction(chatId, ChatAction.record_video).execute().isOk());
        assertTrue(bot.sendChatAction(chatId, ChatAction.upload_video).execute().isOk());
        assertTrue(bot.sendChatAction(chatId, ChatAction.record_voice).execute().isOk());
        assertTrue(bot.sendChatAction(chatId, ChatAction.upload_voice).execute().isOk());
        assertTrue(bot.sendChatAction(chatId, ChatAction.upload_document).execute().isOk());
        assertTrue(bot.sendChatAction(chatId, ChatAction.find_location).execute().isOk());
        assertTrue(bot.sendChatAction(chatId, ChatAction.record_video_note).execute().isOk());
        assertTrue(bot.sendChatAction(chatId, ChatAction.upload_video_note).execute().isOk());
        assertTrue(bot.sendChatAction(chatId, ChatAction.choose_sticker).execute().isOk());
        assertTrue(bot.sendChatAction(forum, ChatAction.choose_sticker).messageThreadId(forumEditThread).execute().isOk());
    }

    @Test
    public void sendVideoNote() {
        SendResponse response = bot.sendVideoNote(chatId, "DQADAgADmQADYgwpSbum1JrxPsbmAg").execute();
        VideoNoteCheck.check(response.message().videoNote());
    }

    @Test
    public void sendVideoNoteFile() {
        SendResponse response = bot.sendVideoNote(chatId, videoNoteFile).thumb(thumbFile).length(20).duration(30).execute();
        VideoNoteCheck.check(response.message().videoNote(), true);
        assertNotEquals("telegram should generate thumb", thumbSize, response.message().videoNote().thumb().fileSize());

        response = bot.sendVideoNote(chatId, videoNoteBytes).thumb(thumbBytes).execute();
        VideoNoteCheck.check(response.message().videoNote(), true);
        assertNotEquals("telegram should generate thumb", thumbSize, response.message().videoNote().thumb().fileSize());
    }

    @Test
    public void setChatAdministratorCustomTitle() {
        BaseResponse response = bot.promoteChatMember(groupId, memberBot).canPromoteMembers(true).execute();
        assertTrue(response.isOk());

        String customTitle = "aqi " + new Random().nextInt(999999);
        response = bot.setChatAdministratorCustomTitle(groupId, memberBot, customTitle).execute();
        assertTrue(response.isOk());

        ChatMember member = bot.getChatMember(groupId, memberBot).execute().chatMember();
        ChatMemberTest.check(member);
        assertEquals(customTitle, member.customTitle());
        assertFalse(member.isAnonymous());
    }

    @Test
    public void setChatPermissions() {
        for (boolean bool : new boolean[]{false, true}) {
            ChatPermissions setPerms = new ChatPermissions();
            setPerms.canSendMessages(bool);
            setPerms.canSendAudios(bool);
            setPerms.canSendDocuments(bool);
            setPerms.canSendPhotos(bool);
            setPerms.canSendVideos(bool);
            setPerms.canSendVideoNotes(bool);
            setPerms.canSendVoiceNotes(bool);
            setPerms.canSendPolls(bool);
            setPerms.canSendOtherMessages(bool);
            setPerms.canAddWebPagePreviews(bool);
            setPerms.canChangeInfo(bool);
            setPerms.canInviteUsers(bool);
            setPerms.canPinMessages(bool);
            setPerms.canManageTopics(bool);
            BaseResponse response = bot.setChatPermissions(groupId, setPerms)
                    .useIndependentChatPermissions(false).execute();
            assertTrue(response.isOk());

            Chat chat = bot.getChat(groupId).execute().chat();
            ChatPermissions permissions = chat.permissions();
            if (bool) {
                assertTrue(permissions.canSendMessages());
                assertTrue(permissions.canSendAudios());
                assertTrue(permissions.canSendDocuments());
                assertTrue(permissions.canSendPhotos());
                assertTrue(permissions.canSendVideos());
                assertTrue(permissions.canSendVideoNotes());
                assertTrue(permissions.canSendVoiceNotes());
                assertTrue(permissions.canSendPolls());
                assertTrue(permissions.canSendOtherMessages());
                assertTrue(permissions.canAddWebPagePreviews());
                assertFalse(permissions.canChangeInfo());
                assertTrue(permissions.canInviteUsers());
                assertFalse(permissions.canPinMessages());
                assertFalse(permissions.canManageTopics());
            } else {
                assertFalse(permissions.canSendMessages());
                assertFalse(permissions.canSendAudios());
                assertFalse(permissions.canSendDocuments());
                assertFalse(permissions.canSendPhotos());
                assertFalse(permissions.canSendVideos());
                assertFalse(permissions.canSendVideoNotes());
                assertFalse(permissions.canSendVoiceNotes());
                assertFalse(permissions.canSendPolls());
                assertFalse(permissions.canSendOtherMessages());
                assertFalse(permissions.canAddWebPagePreviews());
                assertFalse(permissions.canChangeInfo());
                assertFalse(permissions.canInviteUsers());
                assertFalse(permissions.canPinMessages());
                assertFalse(permissions.canManageTopics());
            }
        }
    }

    @Test
    public void exportChatInviteLink() {
        StringResponse response = bot.exportChatInviteLink(groupId).execute();
        assertTrue(response.isOk());
        assertNotNull(response.result());
    }

    @Test
    public void setChatPhoto() throws IOException {
        BaseResponse response = bot.setChatPhoto(groupId, imageFile).execute();
        assertTrue(response.isOk());

        byte[] bytes = Files.readAllBytes(imageFile.toPath());
        response = bot.setChatPhoto(groupId, bytes).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void deleteChatPhoto() {
        BaseResponse response = bot.deleteChatPhoto(groupId).execute();
        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: CHAT_NOT_MODIFIED", response.description());
        }
    }

    @Test
    public void setChatTitle() {
        BaseResponse response = bot.setChatTitle(groupId, "Test Bot Group " + System.currentTimeMillis()).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void setChatDescription() {
        BaseResponse response = bot.setChatDescription(groupId, "New desc " + System.currentTimeMillis()).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void pinChatMessage() {
        BaseResponse response = bot.pinChatMessage(groupId, 18).disableNotification(false).execute();
        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: CHAT_NOT_MODIFIED", response.description());
        }
    }

    @Test
    public void unpinChatMessage() {
        BaseResponse response = bot.unpinChatMessage(groupId).messageId(3600).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void unpinAllChatMessages() {
        BaseResponse response = bot.unpinAllChatMessages(groupId).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void getStickerSet() {
        GetStickerSetResponse response = bot.getStickerSet(stickerSet).execute();
        StickerSet stickerSet = response.stickerSet();
        for (Sticker sticker : response.stickerSet().stickers()) {
            StickerTest.check(sticker, true, true);
        }
        // clean up stickers, max 120 allowed
        if (stickerSet.stickers().length > 50) {
            for (int i = stickerSet.stickers().length - 1; i > stickerSet.stickers().length - 10; i--) {
                bot.deleteStickerFromSet(stickerSet.stickers()[i].fileId()).execute();
            }
        }
        assertTrue(stickerSet.containsMasks());
        assertEquals(stickerSet.stickerType(), Sticker.Type.mask);
        assertEquals(TelegramBotTest.stickerSet, stickerSet.name());
        assertEquals("test1", stickerSet.title());
        assertFalse(stickerSet.isAnimated());

        Sticker sticker = stickerSet.stickers()[0];
        assertEquals(TelegramBotTest.stickerSet, sticker.setName());
        MaskPosition maskPosition = sticker.maskPosition();
        assertEquals(MaskPosition.Point.forehead.name(), maskPosition.point());
        assertEquals(0f, maskPosition.xShift(), 0);
        assertEquals(0f, maskPosition.yShift(), 0);
        assertEquals(1f, maskPosition.scale(), 0);
    }

    @Test
    public void uploadStickerFile() throws IOException {
        byte[] bytes = Files.readAllBytes(stickerFile.toPath());
        GetFileResponse response = bot.uploadStickerFile(chatId, bytes).execute();
        FileTest.check(response.file(), false);

        response = bot.uploadStickerFile(chatId, bytes, Sticker.Format.Static).execute();
        FileTest.check(response.file(), false);
    }

    @Test
    public void createNewPngStickerSet() {
        String name = "test" + System.currentTimeMillis() + "_by_pengrad_test_bot";
        BaseResponse response = bot.createNewStaticStickerSet(chatId, name, "test1", "\uD83D\uDE00", stickerFile)
                        .stickerType(Sticker.Type.mask)
                        .maskPosition(new MaskPosition(MaskPosition.Point.forehead, 0f, 0f, 1f))
                        .execute();
        assertTrue(response.isOk());

        response = bot.addStickerToSet(chatId, name,
                new InputSticker(stickerId, new String[]{"\uD83D\uDE00"}))
                .maskPosition(new MaskPosition("eyes", 0f, 0f, 1f)).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void createNewWebmStickerSetAndAddSticker() {
        String setName = "test" + System.currentTimeMillis() + "_by_pengrad_test_bot";
        BaseResponse response = bot.createNewVideoStickerSet(chatId, setName,
                                "test1", "\uD83D\uDE00", stickerFileVid)
                        .stickerType(Sticker.Type.mask)
                        .maskPosition(new MaskPosition(MaskPosition.Point.forehead, 0f, 0f, 1f))
                        .execute();
        assertTrue(response.isOk());

        response = bot.addVideoStickerToSet(chatId, setName, "\uD83D\uDE15", stickerFileVid).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void addStickerToSet() {
        BaseResponse response = bot.addStaticStickerToSet(chatId, stickerSet, "\uD83D\uDE15", "BQADAgADuAAD7yupS4eB23UmZhGuAg")
                        .maskPosition(new MaskPosition("eyes", 0f, 0f, 1f)).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void createSetAndAddStickerTgs() {
        String setName = "test" + System.currentTimeMillis() + "_by_pengrad_test_bot";
        BaseResponse response = bot.createNewAnimatedStickerSet(chatId, setName, "test1", "\uD83D\uDE00", stickerFileAnim).execute();
        assertTrue(response.isOk());

        response = bot.addAnimatedStickerToSet(chatId, setName, "\uD83D\uDE15", stickerFileAnim).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void createNewStickerSet() {
        String setName = "testNEW" + System.currentTimeMillis() + "_by_pengrad_test_bot";
        String title = "test112312312";
        BaseResponse response = bot.createNewStickerSet(chatId, setName, title, new InputSticker[]{
                        new InputSticker(stickerFile, new String[]{"\uD83D\uDE00"})
                                .keywords(new String[]{"yes", "no"})
                                .maskPosition(new MaskPosition(MaskPosition.Point.forehead, 10f, 20f, 1f))
                }, Sticker.Format.Static)
                .containsMasks(false)
                .needsRepainting(false)
                .execute();
        assertTrue(response.isOk());

        StickerSet set = bot.getStickerSet(setName).execute().stickerSet();
        assertEquals(setName, set.name());
        assertEquals(title, set.title());
        assertFalse(set.isVideo());
        Sticker[] stickers = set.stickers();
        assertEquals(1, stickers.length);
        assertEquals("\uD83D\uDE00", stickers[0].emoji());
        assertFalse(stickers[0].isVideo());
        assertNull(stickers[0].needsRepainting());
        assertNull(stickers[0].premiumAnimation());
        assertNull(stickers[0].customEmojiId());

        response = bot.setStickerSetTitle(setName, "new title").execute();
        assertTrue(response.isOk());

        String stickerId = stickers[0].fileId();
        response = bot.setStickerEmojiList(stickerId, new String[]{"\uD83D\uDE00"}).execute();
        assertTrue(response.isOk());

        response = bot.setStickerKeywords(stickerId).keywords(new String[]{"ok"}).execute();
        assertTrue(response.isOk());

        response = bot.setStickerMaskPosition(stickerId)
                .maskPosition(new MaskPosition(MaskPosition.Point.mouth, 0f, 0f, 0f)).execute();
        assertFalse(response.isOk());
        assertEquals("Bad Request: STICKER_MASK_COORDS_NOT_SUPPORTED", response.description());

        response = bot.deleteStickerSet(setName).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void setStickerPositionInSet() {
        GetStickerSetResponse setResponse = bot.getStickerSet(stickerSet).execute();
        Sticker sticker = setResponse.stickerSet().stickers()[0];

        BaseResponse response = bot.setStickerPositionInSet(sticker.fileId(), 0).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void deleteStickerFromSet() {
        BaseResponse response = bot.addStaticStickerToSet(chatId, stickerSet, "\uD83D\uDE15", stickerFile).execute();
        assertTrue(response.isOk());

        GetStickerSetResponse setResponse = bot.getStickerSet(stickerSet).execute();
        int size = setResponse.stickerSet().stickers().length;
        Sticker sticker = setResponse.stickerSet().stickers()[size - 1];

        response = bot.deleteStickerFromSet(sticker.fileId()).execute();
        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: STICKERSET_NOT_MODIFIED", response.description());
        }
    }

    @Test
    public void setStickerSetThumb() {
        String thumbFile = "CAACAgIAAxkBAAJ0ll6DO4bNCynpfZmS6g-YcGY2zrP5AAIBAAPANk8TGC5zMKs_LVEYBA";
        BaseResponse response = bot.setStickerSetThumb(stickerSetAnim, chatId, thumbFile).execute();
        assertTrue(response.isOk());

        response = bot.setStickerSetThumbnail(stickerSetAnim, chatId, thumbFile).execute();
        assertTrue(response.isOk());

        StickerSet set = bot.getStickerSet(stickerSetAnim).execute().stickerSet();
        assertTrue(set.isAnimated());
        PhotoSize thumb = set.thumb();
        PhotoSizeTest.checkPhotos(thumb);
        assertEquals(Integer.valueOf(100), thumb.width());
        assertEquals(Integer.valueOf(100), thumb.height());
        assertEquals(Long.valueOf(8244), thumb.fileSize());

        // clear thumb by not sending it
        response = bot.setStickerSetThumb(stickerSetAnim, chatId).execute();
        assertTrue(response.isOk());

        response = bot.setStickerSetThumbnail(stickerSetAnim, chatId).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void getCustomEmojiStickers() {
        GetCustomEmojiStickersResponse response = bot.getCustomEmojiStickers("5434144690511290129").execute();
        assertTrue(response.isOk());
        assertEquals(1, response.result().length);
    }

    @Test
    public void setCustomEmojiStickerSetThumbnail() {
        String setName = "custom_emoji_set_by_pengrad_test_bot";
        BaseResponse response = bot.createNewStickerSet(chatId, setName, "title",
                        new InputSticker[]{new InputSticker(stickerFileAnim, new String[]{"\uD83D\uDE15"})},
                        Sticker.Format.animated).stickerType(Sticker.Type.custom_emoji)
                .execute();
        assertTrue(response.isOk());

        response = bot.setCustomEmojiStickerSetThumbnail(setName).customEmojiId("123").execute();
        assertTrue(response.isOk());

        response = bot.deleteStickerSet(setName).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void editMessageLiveLocation() {
        BaseResponse response = bot.editMessageLiveLocation(chatId, 10009, 21, 105)
                .replyMarkup(new InlineKeyboardMarkup()).execute();
        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: message can't be edited", response.description());
        }

        String buttonText = "btn_" + System.currentTimeMillis();
        response = bot.editMessageLiveLocation("AgAAAPrwAQCj_Q4D2s-51_8jsuU", 21, 102)
                        .horizontalAccuracy(1f)
                        .heading(10)
                        .proximityAlertRadius(100)
                        .replyMarkup(new InlineKeyboardMarkup(new InlineKeyboardButton(buttonText).callbackGame(buttonText)))
                        .execute();
        assertTrue(response.isOk());
    }

    @Test
    public void stopMessageLiveLocation() {
        BaseResponse response = bot.stopMessageLiveLocation(chatId, 10009).execute();
        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: message can't be edited", response.description());
        }

        response = bot.stopMessageLiveLocation("AgAAAPrwAQCj_Q4D2s-51_8jsuU").execute();
        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: message is not modified: specified new message content and reply markup are exactly the same as a current content and reply markup of the message",
                    response.description());
        }
    }

    @Test
    public void setChatStickerSet() {
        BaseResponse response = bot.setChatStickerSet(groupId, "PengradTest").execute();
        assertFalse(response.isOk());
        assertEquals(400, response.errorCode());
    }

    @Test
    public void deleteChatStickerSet() {
        BaseResponse response = bot.deleteChatStickerSet(groupId).execute();
        assertFalse(response.isOk());
        assertEquals(400, response.errorCode());
    }

    @Test
    public void sendMediaGroup() {
        String url = "https://google.com/";
        User user = new User(memberBot);
        String language = "ru";
        MessagesResponse response = bot.sendMediaGroup(chatId,
                new InputMediaPhoto(photoFileId).thumbnail(thumbFile),
                new InputMediaPhoto(imageFile).caption("some caption bold")
                        .captionEntities(
                                new MessageEntity(MessageEntity.Type.bold, 0, 4),
                                new MessageEntity(MessageEntity.Type.text_link, 5, 1).url(url),
                                new MessageEntity(MessageEntity.Type.text_mention, 6, 1).user(user),
                                new MessageEntity(MessageEntity.Type.pre, 7, 1).language(language)
                        ),
                new InputMediaPhoto(imageBytes).thumbnail(thumbBytes).hasSpoiler(true),
                new InputMediaVideo(videoFileId).hasSpoiler(true),
                new InputMediaVideo(videoFile),
                new InputMediaVideo(videoBytes).caption("my video <b>bold</b>").parseMode(ParseMode.HTML)
                        .duration(10).width(11).height(12).supportsStreaming(true))
                .messageThreadId(0).disableNotification(false).allowSendingWithoutReply(false).replyToMessageId(1)
                .execute();
        assertTrue(response.isOk());
        assertEquals(6, response.messages().length);

        String mediaGroupId = response.messages()[0].mediaGroupId();
        assertNotNull(mediaGroupId);

        int messagesWithCaption = 0;
        for (Message message : response.messages()) {
            assertEquals(mediaGroupId, message.mediaGroupId());
            if (message.caption() != null) {
                assertEquals(MessageEntity.Type.bold, message.captionEntities()[0].type());
                messagesWithCaption++;
            }
        }
        assertEquals(2, messagesWithCaption);

        MessageEntity[] entities = response.messages()[1].captionEntities();
        assertEquals(MessageEntity.Type.bold, entities[0].type());
        assertEquals(MessageEntity.Type.text_link, entities[1].type());
        assertEquals(MessageEntity.Type.text_mention, entities[2].type());
        assertEquals(MessageEntity.Type.pre, entities[3].type());
        assertEquals(url, entities[1].url());
        assertEquals(user.id(), entities[2].user().id());
        assertEquals(language, entities[3].language());
    }

    @Test
    public void sendMediaGroupDocuments() {
        MessagesResponse response = bot.sendMediaGroup(chatId,
                new InputMediaDocument(docFile),
                new InputMediaDocument(docBytes).fileName("test.pdf").contentType("application/pdf")
        ).execute();
        assertTrue(response.isOk());
        assertEquals(2, response.messages().length);
        assertNotNull(response.messages()[0].mediaGroupId());
        System.out.println(response.messages()[0].document());
        System.out.println(response.messages()[1].document());
    }

    @Test
    public void editMessageMedia() {
        int messageId = 13541;
        SendResponse response;

        response = (SendResponse) bot.editMessageMedia(chatId, messageId,
                new InputMediaDocument(docFile)
                        .thumb(thumbFile)
                        .disableContentTypeDetection(true)
        ).replyMarkup(new InlineKeyboardMarkup()).execute();
        assertEquals((Long) 13264L, response.message().document().fileSize());
        assertEquals(thumbSize, response.message().document().thumb().fileSize());

        response = (SendResponse) bot.editMessageMedia(chatId, messageId,
                new InputMediaDocument(docBytes).thumb(thumbBytes)).execute();
        assertEquals((Long) 13264L, response.message().document().fileSize());
        assertEquals(thumbSize, response.message().document().thumb().fileSize());

        response = (SendResponse) bot.editMessageMedia(chatId, messageId, new InputMediaDocument(docFileId)).execute();
        MessageTest.checkMessage(response.message());
        DocumentTest.check(response.message().document());


        response = (SendResponse) bot.editMessageMedia(chatId, messageId, new InputMediaAnimation(gifFile)).execute();
        assertEquals(Integer.valueOf(1), response.message().animation().duration());

        int expectedSize = 160; // idk why?
        Integer durationAnim = 17, width = 21, height = 22;
        response = (SendResponse) bot.editMessageMedia(chatId, messageId,
                new InputMediaAnimation(gifBytes).duration(durationAnim).width(width).height(height).hasSpoiler(true))
                .execute();
        Animation animation = response.message().animation();
        assertEquals(1, animation.duration().intValue());
        assertEquals(expectedSize, animation.width().intValue());
        assertEquals(expectedSize, animation.height().intValue());

        response = (SendResponse) bot.editMessageMedia(chatId, messageId, new InputMediaAnimation(gifFileId)).execute();
        assertTrue(response.isOk());
        AnimationCheck.check(response.message().animation());
        assertEquals(Integer.valueOf(3), response.message().animation().duration());
        assertNotEquals(gifFileId, response.message().animation().fileId());
        assertNotNull(response.message().document());
        assertEquals(Long.valueOf(57527), response.message().document().fileSize());
        assertEquals("video/mp4", response.message().document().mimeType());

        response = (SendResponse) bot.editMessageMedia(chatId, messageId, new InputMediaAudio(audioFileId)).execute();
        assertEquals(Long.valueOf(10286), response.message().audio().fileSize());
        response = (SendResponse) bot.editMessageMedia(chatId, messageId, new InputMediaAudio(audioFile)).execute();
        assertEquals(Long.valueOf(10286), response.message().audio().fileSize());
        response = (SendResponse) bot.editMessageMedia(chatId, messageId, new InputMediaAudio(audioBytes)).execute();
        assertEquals(Long.valueOf(10286), response.message().audio().fileSize());
        Integer duration = 34;
        String performer = "some performer", title = "just a title", fileName = "beep.mp3";
        response = (SendResponse) bot.editMessageMedia(chatId, messageId,
                new InputMediaAudio(audioFile).duration(duration).performer(performer).title(title))
                .execute();
        Audio audio = response.message().audio();
        assertEquals(Long.valueOf(10286), audio.fileSize());
        assertEquals(duration, audio.duration());
        assertEquals(performer, audio.performer());
        assertEquals(title, audio.title());
        assertEquals(fileName, audio.fileName());

        // send multipart InputMediaPhoto, InputMediaVideo to cover getFileName and getContentType
        response = (SendResponse) bot.editMessageMedia(chatId, messageId, new InputMediaPhoto(photoFileId).thumb(thumbFile)).execute();
        assertNotNull(response.message().photo());
        response = (SendResponse) bot.editMessageMedia(chatId, messageId, new InputMediaVideo(videoFileId).thumb(thumbFile)).execute();
        assertNotNull(response.message().video());
    }

    @Test
    public void sendAnimation() {
        int expectedSize = 160; // idk why?
        int width = 340, height = 240;
        String caption = "gif *file*", captionCheck = "gif file";
        SendResponse response = bot.sendAnimation(chatId, gifFile)
                .duration(222).width(width).height(height).thumb(thumbFile)
                .caption(caption).parseMode(ParseMode.Markdown).hasSpoiler(true)
                .execute();
        assertTrue(response.isOk());
        Animation animation = response.message().animation();
        assertEquals((Integer) 1, animation.duration());
        assertEquals(expectedSize, animation.width().intValue());
        assertEquals(expectedSize, animation.height().intValue());
        assertNotEquals("telegram should generate thumb", thumbSize, animation.thumb().fileSize());
        assertEquals(captionCheck, response.message().caption());
        assertEquals(MessageEntity.Type.bold, response.message().captionEntities()[0].type());

        response = bot.sendAnimation(chatId, gifBytes).thumb(thumbBytes)
                .caption("caption").captionEntities(new MessageEntity(MessageEntity.Type.italic, 0, 7))
                .execute();
        animation = response.message().animation();
        assertEquals((Integer) 1, animation.duration());
        assertEquals(expectedSize, animation.width().intValue());
        assertEquals(expectedSize, animation.height().intValue());
        assertNotEquals("telegram should generate thumb", thumbSize, animation.thumb().fileSize());
        MessageEntity captionEntity = response.message().captionEntities()[0];
        assertEquals(MessageEntity.Type.italic, captionEntity.type());
        assertEquals((Integer) 0, captionEntity.offset());
        assertEquals((Integer) 7, captionEntity.length());

        response = bot.sendAnimation(chatId, gifFileId).execute();
        animation = response.message().animation();
        assertEquals((Integer) 3, animation.duration());
        assertEquals((Integer) 128, animation.width());
        assertEquals((Integer) 128, animation.height());
    }

    @Test
    public void setPassportDataErrors() {
        BaseResponse response = bot.setPassportDataErrors(chatId,
                new PassportElementErrorDataField("personal_details", "first_name",
                        "TueU2/SswOD5wgQ6uXQ62mJrr0Jdf30r/QQ/jyETHFM=",
                        "error in page 1"))
                .execute();
        System.out.println(response);
        assertTrue(response.isOk());
    }

    @Test
    public void decryptPassport() throws Exception {
        PassportData passportData = BotUtils.parseUpdate(testPassportData).message().passportData();
        assertNotNull(passportData);

        Credentials credentials = passportData.credentials().decrypt(privateKey);
        assertNull(credentials.nonce());

        SecureData secureData = credentials.secureData();
        assertNotNull(secureData.personalDetails());
        assertNull(secureData.internalPassport());
        assertNull(secureData.driverLicense());
        assertNull(secureData.identityCard());
        assertNull(secureData.address());
        assertNull(secureData.utilityBill());
        assertNull(secureData.bankStatement());
        assertNull(secureData.rentalAgreement());
        assertNull(secureData.passportRegistration());
        assertNull(secureData.temporaryRegistration());

        SecureValue securePassport = secureData.passport();
        assertNull(securePassport.reverseSide());
        assertNull(securePassport.selfie());
        assertNull(securePassport.files());

        for (EncryptedPassportElement encElement : passportData.data()) {
            assertNotNull(encElement.data());
            if (encElement.type() == EncryptedPassportElement.Type.personal_details) {
                assertEquals("DVUCaJq6oU/hItqZjuclmKL1bWwMSACR9w0Kx8PjoHg=", encElement.hash());
                assertNull(encElement.phoneNumber());
                assertNull(encElement.email());
                PersonalDetails pd = (PersonalDetails) encElement.decryptData(credentials);
                assertEquals("Sz2", pd.firstName());
                assertEquals("P", pd.lastName());
                assertEquals("smid", pd.middleName());
                assertEquals("1.1.1980", pd.birthDate());
                assertEquals("male", pd.gender());
                assertEquals("RU", pd.countryCode());
                assertEquals("RU", pd.residenceCountryCode());
                assertEquals("имя", pd.firstNameNative());
                assertEquals("фамилия", pd.lastNameNative());
                assertEquals("среднее", pd.middleNameNative());
            }

            if (encElement.type() == EncryptedPassportElement.Type.passport) {
                assertEquals(Long.valueOf(260608), encElement.frontSide().fileSize());
                assertEquals(Integer.valueOf(1535386777), encElement.frontSide().fileDate());

                List<PassportFile> files = new ArrayList<>();
                files.add(encElement.frontSide());
                files.add(encElement.reverseSide());
                files.add(encElement.selfie());
                if (encElement.files() != null) {
                    files.addAll(Arrays.asList(encElement.files()));
                }
                if (encElement.translation() != null) {
                    files.addAll(Arrays.asList(encElement.translation()));
                }
                for (PassportFile file : files) {
                    if (file == null) continue;
                    byte[] data = encElement.decryptFile(file, credentials, bot);
                    assertTrue(data.length > 0);
                    // new FileOutputStream(Paths.get("build/" + encElement.type() + i + ".jpg").toFile()).write(data);
                }
            }
        }
    }

    @Test
    public void sendPoll() {
        String question = "Question ?";
        String[] answers = {"Answer 1", "Answer 2"};
        SendResponse sendResponse = bot.sendPoll(groupId, question, answers)
                        .isAnonymous(false)
                        .type(Poll.Type.quiz)
                        .allowsMultipleAnswers(false)
                        .correctOptionId(1)
                        .isClosed(false)
                        .explanation("Some __explanation__ of poll")
                        .explanationParseMode(ParseMode.MarkdownV2)
                        .openPeriod(500)
                        .execute();
        Poll poll = sendResponse.message().poll();
        if (poll == null) {
            // sometimes response is success but poll is empty
            return;
        }
        assertFalse(poll.id().isEmpty());
        assertEquals(question, poll.question());
        assertEquals(answers.length, poll.options().length);
        for (int i = 0; i < answers.length; i++) {
            PollOption option = poll.options()[i];
            assertEquals(answers[i], option.text());
            assertEquals(Integer.valueOf(0), option.voterCount());
        }
        assertFalse(poll.isAnonymous());
        assertEquals(poll.type(), Poll.Type.quiz);
        assertFalse(poll.allowsMultipleAnswers());
        assertEquals(poll.totalVoterCount(), Integer.valueOf(0));
        assertEquals(poll.correctOptionId(), Integer.valueOf(1));
        assertFalse(poll.isClosed());
        assertEquals("Some explanation of poll", poll.explanation());
        assertEquals(1, poll.explanationEntities().length);
        assertEquals(MessageEntity.Type.underline, poll.explanationEntities()[0].type());
        assertTrue(poll.openPeriod() >= 495 && poll.openPeriod() <= 500);
    }

    @Test
    public void sendPollWithKeyboard() {
        String question = "Question ?";
        String[] answers = {"Answer 1", "Answer 2"};
        long closeDate = System.currentTimeMillis() / 1000 + 500;
        SendResponse sendResponse = bot.sendPoll(chatId, question, answers)
                        .type("regular")
                        .allowsMultipleAnswers(true)
                        .replyMarkup(new ReplyKeyboardMarkup(
                                new KeyboardButton("all polls").requestPoll(new KeyboardButtonPollType()),
                                new KeyboardButton("quiz").requestPoll(new KeyboardButtonPollType(Poll.Type.quiz)),
                                new KeyboardButton("regular").requestPoll(new KeyboardButtonPollType("regular"))))
                        .closeDate(closeDate)
                        .execute();
        Poll poll = sendResponse.message().poll();
        assertEquals(question, poll.question());
        assertEquals(answers.length, poll.options().length);
        assertTrue(poll.isAnonymous());
        assertEquals(poll.totalVoterCount(), Integer.valueOf(0));
        assertEquals(poll.type(), Poll.Type.regular);
        assertTrue(poll.allowsMultipleAnswers());
        assertEquals(closeDate, poll.closeDate().longValue());
    }

    @Test
    public void stopPoll() {
        String question = "Question ?";
        String[] answers = {"Answer 1", "Answer 2"};
        SendResponse sendResponse = bot.sendPoll(groupId, question, answers).messageThreadId(0).execute();
        Integer messageId = sendResponse.message().messageId();

        PollResponse response = bot.stopPoll(groupId, messageId).execute();
        Poll poll = response.poll();
        assertTrue(poll.isClosed());
        assertEquals(question, poll.question());
        assertEquals(answers.length, poll.options().length);
        for (int i = 0; i < answers.length; i++) {
            PollOption option = poll.options()[i];
            assertEquals(answers[i], option.text());
            assertEquals(Integer.valueOf(0), option.voterCount());
        }
    }

    @Test
    public void pollAnswer() {
        // pollAnswer is sent when user answers in a non-anonymous poll
        PollAnswer pollAnswer = BotUtils.parseUpdate(testPollAnswer).pollAnswer();

        assertNotNull(pollAnswer);
        assertFalse(pollAnswer.pollId().isEmpty());
        UserTest.checkUser(pollAnswer.user(), true);
        assertEquals(Long.valueOf(12345), pollAnswer.user().id());
        assertArrayEquals(new Integer[]{0, 2}, pollAnswer.optionIds());
    }

    @Test
    public void testAsyncCallback() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        bot.getMe().execute(new Callback<GetMe, GetMeResponse>() {
            @Override
            public void onResponse(GetMe request, GetMeResponse response) {
                latch.countDown();
            }

            @Override
            public void onFailure(GetMe request, IOException e) {
                throw new RuntimeException(e);
            }
        });
        assertTrue(latch.await(5, TimeUnit.SECONDS));
    }

    @Test
    public void botClientError() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        TelegramBotClient botClient = new TelegramBotClient(new OkHttpClient(), null, TelegramBot.Builder.API_URL);
        botClient.send(new GetMe(botClient), new Callback<GetMe, GetMeResponse>() {
            @Override
            public void onResponse(GetMe request, GetMeResponse response) {
            }

            @Override
            public void onFailure(GetMe request, IOException e) {
                latch.countDown();
            }
        });
        assertTrue(latch.await(5, TimeUnit.SECONDS));
    }

    @Test
    public void toWebhookResponse() {
        assertEquals("{\"method\":\"getMe\"}", bot.getMe().toWebhookResponse());
    }

    @Test
    public void loginButton() {
        String text = "login";
        String url = "https://pengrad.herokuapp.com/hello";
        SendResponse response = bot.sendMessage(chatId, "Login button").replyMarkup(new InlineKeyboardMarkup(
                        new InlineKeyboardButton(text).loginUrl(new LoginUrl(url)
                                .forwardText("forwarded login")
                                .botUsername("pengrad_test_bot")
                                .requestWriteAccess(true))))
                .execute();
        assertTrue(response.isOk());
        InlineKeyboardButton button = response.message().replyMarkup().inlineKeyboard()[0][0];
        assertEquals(text, button.text());
        assertEquals(url, button.url());
    }

    @Test
    public void multipartNonAscii() {
        String caption = "хорошо";
        Message message = bot.sendPhoto(chatId, imageFile).fileName("файл.txt").caption(caption)
                .execute().message();
        assertEquals(caption, message.caption());
        MessageTest.checkMessage(message);
        PhotoSizeTest.checkPhotos(message.photo());
    }

    @Test
    public void testResponseParameters() {
        String errorJson = "{\"ok\":false,\"error_code\":400,\"description\":\"Bad Request: description\",\"parameters\":{\"migrate_to_chat_id\":123456789000,\"retry_after\":3}}";
        BaseResponse response = BotUtils.fromJson(errorJson, BaseResponse.class);
        ResponseParameters parameters = response.parameters();
        assertNotNull(parameters);
        assertEquals(Long.valueOf(123456789000L), parameters.migrateToChatId());
        assertEquals(Integer.valueOf(3), parameters.retryAfter());
    }

    @Test
    public void sendDice() {
        SendResponse response = bot.sendDice(chatId).execute();
        Dice dice = response.message().dice();
        assertNotNull(dice);
        assertTrue(dice.value() >= 1 && dice.value() <= 6);
        assertEquals("🎲", dice.emoji());

        response = bot.sendDice(chatId).darts().execute();
        dice = response.message().dice();
        assertNotNull(dice);
        assertTrue(dice.value() >= 1 && dice.value() <= 6);
        assertEquals("🎯", dice.emoji());

        response = bot.sendDice(chatId).basketball().execute();
        dice = response.message().dice();
        assertNotNull(dice);
        assertTrue(dice.value() >= 1 && dice.value() <= 5);
        assertEquals("🏀", dice.emoji());

        response = bot.sendDice(chatId).football().execute();
        dice = response.message().dice();
        assertNotNull(dice);
        assertTrue(dice.value() >= 1 && dice.value() <= 5);
        assertEquals("⚽", dice.emoji());

        response = bot.sendDice(chatId).slotMachine().execute();
        dice = response.message().dice();
        assertNotNull(dice);
        assertTrue(dice.value() >= 1 && dice.value() <= 64);
        assertEquals("🎰", dice.emoji());

        response = bot.sendDice(chatId).bowling().execute();
        dice = response.message().dice();
        assertNotNull(dice);
        assertTrue(dice.value() >= 1 && dice.value() <= 6);
        assertEquals("🎳", dice.emoji());
    }

    @Test
    public void setMyCommands() {
        BotCommand[] commands = new BotCommand[]{
                new BotCommand("c1", "desc1"),
                new BotCommand("c2", "desc2"),
                new BotCommand("c3", "desc3"),
        };

        SetMyCommands cmds = bot.setMyCommands(commands);
        cmds.languageCode("en");
        cmds.scope(new BotCommandScopeAllChatAdministrators());

        BaseResponse response = cmds.execute();
        assertTrue(response.isOk());

        GetMyCommands getCmds = bot.getMyCommands();
        getCmds.languageCode("en");
        getCmds.scope(new BotCommandScopeAllChatAdministrators());

        GetMyCommandsResponse commandsResponse = getCmds.execute();
        assertTrue(commandsResponse.isOk());
        assertEquals(commands[0].command(), commandsResponse.commands()[0].command());
        assertEquals(commands[0].description(), commandsResponse.commands()[0].description());
        assertArrayEquals(commandsResponse.commands(), commands);
    }

    @Test
    public void deleteMyCommands() {
        DeleteMyCommands cmds = bot.deleteMyCommands();
        cmds.languageCode("en");
        cmds.scope(new BotCommandScopeAllChatAdministrators());

        BaseResponse response = cmds.execute();
        assertTrue(response.isOk());

        GetMyCommands getCmds = bot.getMyCommands();
        getCmds.languageCode("en");
        getCmds.scope(new BotCommandScopeAllChatAdministrators());

        GetMyCommandsResponse commandsResponse = getCmds.execute();
        assertTrue(commandsResponse.isOk());
        assertArrayEquals(commandsResponse.commands(), new BotCommand[0]);
    }

    @Test
    public void inviteLinks() {
        int memberLimit = 2;
        int expireDate = (int) (System.currentTimeMillis() / 1000) + 500;
        String name = "TestName";

        ChatInviteLinkResponse response = bot.createChatInviteLink(groupId)
                .expireDate(expireDate)
                .memberLimit(memberLimit)
                .name(name)
                .execute();
        ChatInviteLink link = response.chatInviteLink();
        assertEquals(expireDate, link.expireDate().intValue());
        assertEquals(memberLimit, link.memberLimit().intValue());
        assertFalse(link.isRevoked());
        assertTrue(link.creator().isBot());
        assertEquals(name, link.name());

        int editMemberLimit = 3;
        int editExpireDate = (int) (System.currentTimeMillis() / 1000) + 1500;
        String editName = name + "edit";
        response = bot.editChatInviteLink(groupId, link.inviteLink())
                .expireDate(editExpireDate)
                .memberLimit(editMemberLimit)
                .name(editName)
                .execute();
        link = response.chatInviteLink();
        assertEquals(editExpireDate, link.expireDate().intValue());
        assertEquals(editMemberLimit, link.memberLimit().intValue());
        assertEquals(editName, link.name());
        assertFalse(link.isRevoked());

        response = bot.revokeChatInviteLink(groupId, link.inviteLink()).execute();
        link = response.chatInviteLink();
        assertTrue(link.isRevoked());
        assertFalse(link.isPrimary());

        response = bot.createChatInviteLink(groupId).createsJoinRequest(true).execute();
        link = response.chatInviteLink();
        assertTrue(link.createsJoinRequest());
        assertNull(link.pendingJoinRequestCount());

        response = bot.editChatInviteLink(groupId, link.inviteLink()).createsJoinRequest(false).execute();
        assertFalse(response.chatInviteLink().createsJoinRequest());
    }

    @Test
    public void chatJoinRequest() {
        BaseResponse response = bot.approveChatJoinRequest(groupId, memberBot).execute();
        assertFalse(response.isOk());
        assertEquals("Bad Request: USER_ALREADY_PARTICIPANT", response.description());

        response = bot.declineChatJoinRequest(groupId, memberBot).execute();
        assertFalse(response.isOk());
        assertEquals("Bad Request: HIDE_REQUESTER_MISSING", response.description());
    }

    @Test
    public void banChatSenderChat() {
        BaseResponse response = bot.banChatSenderChat(channelName, memberBot).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void unbanChatSenderChat() {
        BaseResponse response = bot.unbanChatSenderChat(channelName, memberBot).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void setChatMenuButton() {
        BaseResponse response = bot.setChatMenuButton().chatId(chatId)
                .menuButton(new MenuButtonWebApp("webapp", new WebAppInfo("https://core.telegram.org")))
                .execute();
        assertTrue(response.isOk());

        response = bot.setChatMenuButton().chatId(chatId)
                .menuButton(new MenuButtonCommands())
                .execute();
        assertTrue(response.isOk());

        response = bot.setChatMenuButton().chatId(chatId)
                .menuButton(new MenuButtonDefault())
                .execute();
        assertTrue(response.isOk());
    }

    @Test
    public void getChatMenuButton() {
        MenuButton menu = new MenuButtonCommands();
        BaseResponse set = bot.setChatMenuButton().chatId(chatId)
                .menuButton(menu)
                .execute();
        assertTrue(set.isOk());

        GetChatMenuButtonResponse response = bot.getChatMenuButton().chatId(chatId).execute();
        assertTrue(response.isOk());
        assertEquals(menu.type(), response.result().type());
    }

    @Test
    public void sendWebAppInfo() {
        String text = "gh_app";
        String url = "https://github.com/";
        SendResponse response = bot.sendMessage(chatId, "message with webApp")
                .replyMarkup(new InlineKeyboardMarkup(new InlineKeyboardButton(text).webApp(new WebAppInfo(url))))
                .execute();
        assertTrue(response.isOk());

        InlineKeyboardMarkup markup = response.message().replyMarkup();
        assertNotNull(markup);
        assertEquals(1, markup.inlineKeyboard().length);
        assertEquals(1, markup.inlineKeyboard()[0].length);

        InlineKeyboardButton button = markup.inlineKeyboard()[0][0];
        assertEquals(text, button.text());
        assertNotNull(button.webApp());
        assertEquals(url, button.webApp().url());

        response = bot.sendMessage(chatId, "message with webApp")
                .replyMarkup(new ReplyKeyboardMarkup(new KeyboardButton(text).webAppInfo(new WebAppInfo(url))))
                .execute();
        assertTrue(response.isOk());
    }

    @Test
    public void getMyDefaultAdministratorRights() {
        bot.setMyDefaultAdministratorRights()
                .forChannels(false)
                .rights(new ChatAdministratorRights()
                        .canManageChat(false)
                        .canDeleteMessages(false)
                        .canManageVideoChats(false)
                        .canRestrictMembers(false)
                        .canPromoteMembers(false)
                        .canChangeInfo(false)
                        .canInviteUsers(false)
                        .canPostMessages(false)
                        .canEditMessages(false)
                        .canPinMessages(false)
                        .canManageTopics(false)
                ).execute();
        ChatAdministratorRights rights = bot.getMyDefaultAdministratorRights().forChannels(false).execute().result();
        assertFalse(rights.isAnonymous());
        assertFalse(rights.canManageChat());
        assertFalse(rights.canDeleteMessages());
        assertFalse(rights.canManageVideoChats());
        assertFalse(rights.canRestrictMembers());
        assertFalse(rights.canPromoteMembers());
        assertFalse(rights.canChangeInfo());
        assertFalse(rights.canInviteUsers());
        assertNull(rights.canPostMessages()); // channels only
        assertNull(rights.canEditMessages()); // channels only
        assertFalse(rights.canPinMessages());
        assertFalse(rights.canManageTopics());
    }

    @Test
    public void getForumTopicIconStickers() {
        List<Sticker> stickers = bot.getForumTopicIconStickers().execute().stickers();
        assertFalse(stickers.isEmpty());
    }

    @Test
    public void createForumTopic() {
        Integer color = 7322096;
        String emoji = "5434144690511290129";
        CreateForumTopicResponse createResponse = bot.createForumTopic(forum, "test_topic")
                .iconColor(color).iconCustomEmojiId(emoji)
                .execute();
        assertTrue(createResponse.isOk());
        ForumTopic topic = createResponse.forumTopic();
        assertNotNull(topic);
        assertEquals(color, topic.iconColor());
        assertEquals(emoji, topic.iconCustomEmojiId());

        String name = "test_topic_edit";
        BaseResponse response = bot.editForumTopic(forum, topic.messageThreadId())
                .name(name).iconCustomEmojiId("")
                .execute();
        assertTrue(response.isOk());

        response = bot.closeForumTopic(forum, topic.messageThreadId()).execute();
        assertTrue(response.isOk());

        response = bot.reopenForumTopic(forum, topic.messageThreadId()).execute();
        assertTrue(response.isOk());

        response = bot.deleteForumTopic(forum, topic.messageThreadId()).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void unpinAllForumTopicMessages() {
        String name = "edit_thread-" + System.currentTimeMillis();
        BaseResponse response = bot.editForumTopic(forum, forumEditThread, name, "").execute();
        assertTrue(response.isOk());
        response = bot.unpinAllForumTopicMessages(forum, forumEditThread).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void editGeneralForumTopic() {
        String name = "General " + System.currentTimeMillis();
        BaseResponse response = bot.editGeneralForumTopic(forum, name).execute();
        assertTrue(response.isOk());

        response = bot.closeGeneralForumTopic(forum).execute();
        assertTrue(response.isOk());

        response = bot.hideGeneralForumTopic(forum).execute();
        assertTrue(response.isOk());

        response = bot.unhideGeneralForumTopic(forum).execute();
        assertTrue(response.isOk());

        response = bot.reopenGeneralForumTopic(forum).execute();
        assertTrue(response.isOk());
    }

    @Test
    public void setMyDescription() {
        BaseResponse response = bot.setMyDescription().description("desc").languageCode("en").execute();
        assertTrue(response.isOk());

        GetMyDescriptionResponse descResponse = bot.getMyDescription().languageCode("en").execute();
        assertTrue(descResponse.isOk());
        BotDescription desc = descResponse.botDescription();
        assertNotNull(desc);
        assertEquals("desc", desc.description());
    }

    @Test
    public void setMyShortDescription() {
        BaseResponse response = bot.setMyShortDescription().description("short_desc").languageCode("en").execute();
        assertTrue(response.isOk());

        GetMyShortDescriptionResponse descResponse = bot.getMyShortDescription().languageCode("en").execute();
        assertTrue(descResponse.isOk());
        BotShortDescription desc = descResponse.botShortDescription();
        assertNotNull(desc);
        assertEquals("short_desc", desc.shortDescription());
    }

    @Test
    public void setMyName() {
        BaseResponse response = bot.setMyName().name("name").languageCode("en").execute();
        assertTrue(response.isOk());

        GetMyNameResponse nameResponse = bot.getMyName().languageCode("en").execute();
        assertTrue(nameResponse.isOk());
        assertEquals("name", nameResponse.botName().name());
    }

    @Test
    public void answerWebAppQuery() {
        SentWebAppMessageResponse response = bot.answerWebAppQuery("123", new InlineQueryResultArticle("1", "title", "text")).execute();
        assertFalse(response.isOk());
        assertEquals("Bad Request: query is too old and response timeout expired or query ID is invalid", response.description());
        assertNull(response.sentWebAppMessage());
    }
}
