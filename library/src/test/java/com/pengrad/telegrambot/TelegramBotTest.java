package com.pengrad.telegrambot;

import com.pengrad.telegrambot.checks.*;
import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.model.*;
import com.pengrad.telegrambot.model.botcommandscope.BotCommandScopeAllChatAdministrators;
import com.pengrad.telegrambot.model.chatboost.ChatBoost;
import com.pengrad.telegrambot.model.giveaway.Giveaway;
import com.pengrad.telegrambot.model.paidmedia.PaidMediaInfo;
import com.pengrad.telegrambot.model.paidmedia.PaidMediaPhoto;
import com.pengrad.telegrambot.model.paidmedia.PaidMediaVideo;
import com.pengrad.telegrambot.model.reaction.ReactionTypeEmoji;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.passport.*;
import com.pengrad.telegrambot.request.*;
import com.pengrad.telegrambot.request.DeleteMyCommands;
import com.pengrad.telegrambot.response.*;
import com.pengrad.telegrambot.utility.BotUtils;
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
                .addInterceptor(retry);
        if (localBuild) {
            okHttpBuilder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }
        return new TelegramBot.Builder(token).okHttpClient(okHttpBuilder.build()).build();
    }

    static RetryInterceptor retry = new RetryInterceptor(1000);
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
        GetMeResponse response = bot.execute(new GetMe());
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
        GetUpdates getUpdates = new GetUpdates()
                .offset(874227176)
                .allowedUpdates("")
                .timeout(0)
                .limit(100);
        assertEquals(100, getUpdates.getLimit());
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
        BaseResponse response = bot.execute(new KickChatMember(channelName, chatId).untilDate(123).revokeMessages(true));
        assertFalse(response.isOk());
        assertEquals(400, response.errorCode());
        assertEquals("Bad Request: can't remove chat owner", response.description());
    }

    @Test
    public void banChatMember() {
        BaseResponse response = bot.execute(new BanChatMember(channelName, chatId).untilDate(123).revokeMessages(true));
        assertFalse(response.isOk());
        assertEquals(400, response.errorCode());
        assertEquals("Bad Request: can't remove chat owner", response.description());
    }

    @Test
    public void unbanChatMember() {
        BaseResponse response = bot.execute(new UnbanChatMember(channelName, chatId));
        assertFalse(response.isOk());
        assertEquals(400, response.errorCode());
        assertEquals("Bad Request: can't remove chat owner", response.description());

        // returns true for non-banned member with onlyIfBanned(true)
        response = bot.execute(new UnbanChatMember(channelName, chatId).onlyIfBanned(true));
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

        BaseResponse response = bot.execute(
                new RestrictChatMember(groupId, memberBot, permissions)
                        .untilDate((int) (System.currentTimeMillis() / 1000) + 5)
                        .useIndependentChatPermissions(false)
        );
        assertTrue(response.isOk());
    }

    @Test
    public void promoteChatMember() {
        BaseResponse response = bot.execute(
                new PromoteChatMember(groupId, memberBot)
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
                        .canPostStories(false)
                        .canEditStories(false)
                        .canDeleteStories(false)
                        .canPromoteMembers(true));
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
        assertNotNull(((SendResponse) response).message().editDate());

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
        String text = "Update " + System.currentTimeMillis() + " <b>bold</b>";

        SendResponse sendResponse = (SendResponse) bot.execute(new EditMessageCaption(chatId, 8124)
                .caption(text)
                .parseMode(ParseMode.HTML)
                .replyMarkup(new InlineKeyboardMarkup()));
        assertTrue(sendResponse.isOk());

        Message message = sendResponse.message();
        assertEquals(text.replace("<b>", "").replace("</b>", ""), message.caption());

        MessageEntity captionEntity = message.captionEntities()[0];
        assertEquals(MessageEntity.Type.bold, captionEntity.type());
        assertEquals((Integer) 21, captionEntity.offset());
        assertEquals((Integer) 4, captionEntity.length());

        BaseResponse response = bot.execute(new EditMessageCaption(channelName, 511).caption(text));
        assertTrue(response.isOk());

        response = bot.execute(new EditMessageCaption("AgAAAPrwAQCj_Q4D2s-51_8jsuU").caption(text));
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

        BaseResponse response = bot.execute(new EditMessageReplyMarkup(chatId, 8124).replyMarkup(keyboard));
        assertTrue(response.isOk());

        response = bot.execute(new EditMessageReplyMarkup(channelName, 511).replyMarkup(keyboard));
        assertTrue(response.isOk());

        response = bot.execute(new EditMessageReplyMarkup("AgAAAPrwAQCj_Q4D2s-51_8jsuU").replyMarkup(gameKeyboard));
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

        BaseResponse response = bot.execute(new AnswerInlineQuery(inlineQueryId, results)
                .cacheTime(100)
                .isPersonal(true)
                .nextOffset("offset")
                .switchPmText("go pm")
                .switchPmParameter("my_pm_parameter")
        );

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

        BaseResponse response = bot.execute(new AnswerCallbackQuery(callbackQuery.id())
                .text("answer callback")
                .url("telegram.me/pengrad_test_bot?game=pengrad_test_game")
                .showAlert(false)
                .cacheTime(1));

        assertFalse(response.isOk());
        assertEquals(400, response.errorCode());
        assertEquals("Bad Request: query is too old and response timeout expired or query ID is invalid", response.description());
    }

    @Test
    public void getChat() throws MalformedURLException, URISyntaxException {
        ChatFullInfo chat = bot.execute(new GetChat(groupId)).chat();
        ChatTest.checkFullInfoChat(chat, true);
        assertEquals(ChatFullInfo.Type.supergroup, chat.type());
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
        assertNull(chat.emojiStatusCustomEmojiId());
        assertNull(chat.emojiStatusExpirationDate());

        chat = bot.execute(new GetChat(chatId)).chat();
        assertNotNull(chat.firstName());
        assertNull(chat.lastName());
        assertNull(chat.bio());
        assertTrue(chat.hasPrivateForwards());

        chat = bot.execute(new GetChat(localGroup)).chat();
        ChatLocation location = chat.location();
        assertNotNull(location);
        assertEquals(60.94062f, location.location().latitude(), 0f);
        assertEquals(76.58071f, location.location().longitude(), 0f);
        assertTrue(location.address().endsWith("Russia"));
        assertTrue(chat.joinToSendMessages());
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
        GetChatAdministratorsResponse response = bot.execute(new GetChatAdministrators(groupId));
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
                assertTrue(chatMember.canManageVideoChats());
                assertTrue(chatMember.canManageChat());
                assertTrue(chatMember.canManageChat());
                assertTrue(chatMember.canManageChat());
                assertTrue(chatMember.canPostStories());
                assertTrue(chatMember.canEditStories());
                assertTrue(chatMember.canDeleteStories());
            }
        }
    }

    @Test
    public void getChatMember() {
        restrictChatMember();
        ChatMember chatMember = bot.execute(new GetChatMember(groupId, memberBot)).chatMember();
        ChatMemberTest.check(chatMember);
        assertEquals(ChatMember.Status.restricted, chatMember.status());
        assertEquals(Integer.valueOf(0), chatMember.untilDate());
        assertFalse(chatMember.canPostMessages());
        assertFalse(chatMember.canEditMessages());
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
        GetChatMembersCountResponse response = bot.execute(new GetChatMembersCount(chatId));
        assertEquals(2, response.count());
    }

    @Test
    public void getChatMemberCount() {
        GetChatMemberCountResponse response = bot.execute(new GetChatMemberCount(chatId));
        assertEquals(2, response.count());
    }

    @Test
    public void getUserProfilePhotos() {
        int offset = 0;
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
        SendResponse sendResponse = bot.execute(new SendMessage(chatId, "reply this message").replyMarkup(
                new ForceReply().inputFieldPlaceholder("input-placeholder").selective(true)
        ));
        MessageTest.checkTextMessage(sendResponse.message());
        assertNotNull(sendResponse.message().from());

        sendResponse = bot.execute(new SendMessage(chatId, "remove keyboard")
                .replyMarkup(new ReplyKeyboardRemove())
                .disableNotification(true)
                .replyToMessageId(8087)
        );
        MessageTest.checkTextMessage(sendResponse.message());
        assertNotNull(sendResponse.message().replyToMessage());

        sendResponse = bot.execute(new SendMessage(chatId, "message with keyboard")
                .parseMode(ParseMode.HTML)
                .disableWebPagePreview(false)
                .protectContent(true)
                .allowPaidBroadcast(false)
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
                        .selective(true)));
        assertTrue(sendResponse.message().hasProtectedContent());
        MessageTest.checkTextMessage(sendResponse.message());

        sendResponse = bot.execute(new SendMessage(chatId, "simple buttons")
                .replyMarkup(new ReplyKeyboardMarkup("ok", "cancel")));
        MessageTest.checkTextMessage(sendResponse.message());
    }

    @Test
    public void sendMessageToChannel() {
        String url = "https://google.com/";
        SendMessage request = new SendMessage(channelName, "channel message [GG](" + url + ")").parseMode(ParseMode.Markdown);
        SendResponse sendResponse = bot.execute(request);
        Message message = sendResponse.message();
        MessageTest.checkTextMessage(message);
        assertEquals(url, message.entities()[0].url());
        assertEquals(channelId, message.senderChat().id());
        LinkPreviewOptions linkPreviewOptions = message.linkPreviewOptions();
        assertTrue(linkPreviewOptions.isDisabled());
        assertNull(linkPreviewOptions.url());
        assertNull(linkPreviewOptions.preferSmallMedia());
        assertNull(linkPreviewOptions.preferLargeMedia());
        assertNull(linkPreviewOptions.showAboveText());
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
        Message message = response.message();
        MessageTest.checkMessage(message);
        assertNotNull(message.forwardDate());
        assertNotNull(message.forwardSenderName());
        assertNull(message.forwardFrom());
        User viaBot = message.viaBot();
        UserTest.checkUser(viaBot);
        assertEquals("gif", viaBot.username());

        // message from user with open account
        message = bot.execute(new ForwardMessage(chatId, chatId, forwardMessageIdUser)).message();
        MessageTest.checkMessage(message);
        assertNotNull(message.forwardDate());
        assertNull(message.forwardSenderName());
        assertNotNull(message.forwardFrom());

        message = bot.execute(new ForwardMessage(channelName, channelName, 651)).message();
        assertNotNull(message.authorSignature());
        assertNotNull(message.forwardSignature());
        assertEquals(Integer.valueOf(651), message.forwardFromMessageId());
        Chat chat = message.forwardFromChat();
        assertEquals(channelName, "@" + chat.username());
        assertEquals(Chat.Type.channel, chat.type());
        assertNull(message.forwardSenderName());

        message = bot.execute(new ForwardMessage(chatId, groupId, 352).messageThreadId(0)).message();
        assertEquals(MessageEntity.Type.text_mention, message.entities()[0].type());
        assertNotNull(message.entities()[0].user());
        assertNotNull(message.forwardSenderName());
    }

    @Test
    public void forwardMessages() {
        MessageIdsResponse response = bot.execute(new ForwardMessages(chatId, chatId, new int[]{forwardMessageId})
                .messageThreadId(0)
                .disableNotification(true)
                .protectContent(true)
        );
        assertTrue(response.result().length > 0);
    }

    @Test
    public void copyMessage() {
        MessageIdResponse response = bot.execute(new CopyMessage(chatId, chatId, forwardMessageId)
                .messageThreadId(0)
                .caption("new **caption**")
                .parseMode(ParseMode.MarkdownV2)
                .captionEntities(new MessageEntity(MessageEntity.Type.bold, 0, 1))
                .replyParameters(new ReplyParameters(forwardMessageId))
                .allowSendingWithoutReply(false)
                .replyToMessageId(1)
                .replyMarkup(new InlineKeyboardMarkup(new InlineKeyboardButton("copy").copyText("text")))
                .showCaptionAboveMedia(true)
                .disableNotification(true)
                .protectContent(true)
                .allowPaidBroadcast(false)
        );
        assertTrue(response.messageId() > 0);
    }

    @Test
    public void copyMessages() {
        MessageIdsResponse response = bot.execute(new CopyMessages(chatId, chatId, new int[]{forwardMessageId})
                .messageThreadId(0)
                .removeCaption(true)
                .disableNotification(true)
                .protectContent(true)
        );
        assertTrue(response.result().length > 0);
    }

    @Test
    public void sendAudio() {
        Message message = bot.execute(new SendAudio(chatId, audioFileId)
                .caption("caption").captionEntities(new MessageEntity(MessageEntity.Type.italic, 0, 7))
        ).message();
        MessageTest.checkMessage(message);
        AudioTest.checkAudio(message.audio(), false);
        MessageEntity captionEntity = message.captionEntities()[0];
        assertEquals(MessageEntity.Type.italic, captionEntity.type());
        assertEquals((Integer) 0, captionEntity.offset());
        assertEquals((Integer) 7, captionEntity.length());

        message = bot.execute(new SendAudio(chatId, audioFile).thumbnail(thumbFile)).message();
        MessageTest.checkMessage(message);
        AudioTest.checkAudio(message.audio());
        assertEquals(thumbSize, message.audio().thumbnail().fileSize());

        String cap = "http://ya.ru  <b>bold</b> #audio @pengrad_test_bot", title = "title", performer = "performer";
        ParseMode parseMode = ParseMode.HTML;
        int duration = 100;
        SendAudio sendAudio = new SendAudio(chatId, audioBytes).thumbnail(thumbBytes).duration(duration)
                .caption(cap).parseMode(parseMode).performer(performer).title(title);
        message = bot.execute(sendAudio).message();
        MessageTest.checkMessage(message);

        Audio audio = message.audio();
        AudioTest.checkAudio(audio);
        assertEquals(cap.replace("<b>", "").replace("</b>", ""), message.caption());
        assertEquals((Integer) 100, audio.duration());
        assertEquals(performer, audio.performer());
        assertEquals(title, audio.title());
        assertEquals(thumbSize, audio.thumbnail().fileSize());

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
        SendAudio sendAudio = new SendAudio(chatId, audioFileId).caption(cap).parseMode(parseMode);
        Message message = bot.execute(sendAudio).message();
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
        SendAudio sendAudio = new SendAudio(chatId, audioFileId).caption(cap).parseMode(parseMode);
        Message message = bot.execute(sendAudio).message();
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
        SendResponse response = bot.execute(new SendMessage(chatId, "ok this is spoiler ha-ha-ha")
                .entities(new MessageEntity(MessageEntity.Type.spoiler, 19, 8)));

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
        SendAudio sendAudio = new SendAudio(chatId, audioFileId).caption(cap).parseMode(parseMode);
        Message message = bot.execute(sendAudio).message();
        MessageTest.checkMessage(message);
        assertEquals(1, message.captionEntities().length);
        assertEquals("java", message.captionEntities()[0].language());
    }

    @Test
    public void sendDocument() {
        Message message = bot.execute(new SendDocument(chatId, docFileId)).message();
        MessageTest.checkMessage(message);
        DocumentTest.check(message.document());

        message = bot.execute(
                        new SendDocument(chatId, docBytes).thumb(thumbBytes).contentType("application/pdf")
                                .caption("caption").captionEntities(new MessageEntity(MessageEntity.Type.italic, 0, 7)))
                .message();
        MessageTest.checkMessage(message);
        DocumentTest.check(message.document());
        assertEquals(thumbSize, message.document().thumb().fileSize());
        MessageEntity captionEntity = message.captionEntities()[0];
        assertEquals(MessageEntity.Type.italic, captionEntity.type());
        assertEquals((Integer) 0, captionEntity.offset());
        assertEquals((Integer) 7, captionEntity.length());

        String caption = "caption <b>bold</b>", fileName = "my doc.pdf";
        ParseMode parseMode = ParseMode.HTML;
        message = bot.execute(
                        new SendDocument(chatId, docFile).fileName(fileName).thumb(thumbFile).caption(caption).parseMode(parseMode)
                                .disableContentTypeDetection(true))
                .message();
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
        Message message = bot.execute(new SendPhoto(chatId, photoFileId)).message();
        MessageTest.checkMessage(message);
        PhotoSizeTest.checkPhotos(false, message.photo());

        message = bot.execute(new SendPhoto(chatId, imageFile).hasSpoiler(true)
                .caption("caption").captionEntities(new MessageEntity(MessageEntity.Type.italic, 0, 7))).message();
        MessageTest.checkMessage(message);
        PhotoSizeTest.checkPhotos(message.photo());
        MessageEntity captionEntity = message.captionEntities()[0];
        assertEquals(MessageEntity.Type.italic, captionEntity.type());
        assertEquals((Integer) 0, captionEntity.offset());
        assertEquals((Integer) 7, captionEntity.length());

        String caption = "caption <b>bold</b>";
        message = bot.execute(new SendPhoto(channelName, imageBytes).caption(caption).parseMode(ParseMode.HTML)).message();
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
        Message message = bot.execute(new SendSticker(chatId, stickerFileAnim).emoji("\uD83D\uDE00")).message();
        MessageTest.checkMessage(message);
        StickerTest.check(message.sticker(), false, true);
        assertTrue(message.sticker().isAnimated());
        assertEquals("\uD83D\uDE00", message.sticker().emoji());
        assertEquals(Sticker.Type.regular, message.sticker().type());

        message = bot.execute(new SendSticker(chatId, stickerId).thumbnail(thumbFile)).message();
        MessageTest.checkMessage(message);
        StickerTest.check(message.sticker(), true, false);
        assertFalse(message.sticker().isAnimated());

        message = bot.execute(new SendSticker(chatId, imageBytes).thumbnail(thumbBytes)).message();
        MessageTest.checkMessage(message);
        StickerTest.check(message.sticker(), false, true);
    }

    @Test
    public void sendVideo() {
        Message message = bot.execute(new SendVideo(chatId, videoFileId).hasSpoiler(true)).message();
        MessageTest.checkMessage(message);
        VideoTest.check(message.video(), false);

        message = bot.execute(new SendVideo(chatId, videoFile)
                .thumb(thumbFile)
                .caption("caption").captionEntities(new MessageEntity(MessageEntity.Type.italic, 0, 7))
        ).message();
        MessageTest.checkMessage(message);
        VideoTest.check(message.video());
        assertNotEquals("telegram should generate thumb", thumbSize, message.video().thumb().fileSize());
        assertEquals("tabs.mp4", message.video().fileName());
        MessageEntity captionEntity = message.captionEntities()[0];
        assertEquals(MessageEntity.Type.italic, captionEntity.type());
        assertEquals((Integer) 0, captionEntity.offset());
        assertEquals((Integer) 7, captionEntity.length());

        String caption = "caption <b>bold</b>";
        int duration = 6;
        message = bot.execute(
                        new SendVideo(chatId, videoBytes).thumb(thumbBytes)
                                .caption(caption).parseMode(ParseMode.HTML)
                                .duration(duration).height(1).width(2).supportsStreaming(true))
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
        Message message = bot.execute(new SendVoice(chatId, voiceFileId)).message();
        MessageTest.checkMessage(message);
        VoiceTest.check(message.voice(), false);

        message = bot.execute(new SendVoice(chatId, audioFile)).message();
        MessageTest.checkMessage(message);
        VoiceTest.check(message.voice());

        String caption = "caption <b>bold</b>";
        int duration = 100;
        message = bot.execute(new SendVoice(chatId, audioBytes).caption(caption).parseMode(ParseMode.HTML).duration(duration)).message();
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
        GetWebhookInfoResponse response = bot.execute(new GetWebhookInfo());
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
        BaseResponse response = bot.execute(new SetWebhook()
                .url(url)
                .certificate(new File(certificateFile))
                .ipAddress(ipAddress)
                .maxConnections(100)
                .allowedUpdates(allowedUpdates)
                .secretToken("secret-token")
                .dropPendingUpdates(true)
        );
        assertTrue(response.isOk());

        WebhookInfo webhookInfo = bot.execute(new GetWebhookInfo()).webhookInfo();
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

        response = bot.execute(new SetWebhook().url("https://google.com")
                .certificate(Files.readAllBytes(new File(certificateFile).toPath())).allowedUpdates(""));
        assertTrue(response.isOk());

        response = bot.execute(new SetWebhook());
        assertTrue(response.isOk());
    }

    @Test
    public void deleteWebhook() {
        BaseResponse response = bot.execute(new DeleteWebhook().dropPendingUpdates(true));
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
        Message message = bot.execute(new SendGame(chatId, desc).replyMarkup(keyboardMarkup)).message();
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
        BaseResponse response = bot.execute(new SetGameScore(chatId, res, "AgAAAPrwAQCj_Q4D2s-51_8jsuU"));
        assertTrue(response.isOk());

        SendResponse sendResponse = (SendResponse) bot.execute(
                new SetGameScore(chatId, res + 1, chatId, 8162).force(true).disableEditMessage(true));
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
        float lat = 21.999998f, lng = 105.2f, horizontalAccuracy = 1.9f;
        int livePeriod = 60, heading = 120, proximityAlertRadius = 50000;
        Location location = bot.execute(new SendLocation(chatId, lat, lng)
                .horizontalAccuracy(horizontalAccuracy)
                .livePeriod(livePeriod)
                .heading(heading)
                .proximityAlertRadius(proximityAlertRadius)
        ).message().location();
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
        Venue venue = bot.execute(new SendVenue(chatId, lat, lng, title, address)
                .foursquareId(frsqrId).foursquareType(frsqrType)
        ).message().venue();
        assertEquals(lat, venue.location().latitude(), 0f);
        assertEquals(lng, venue.location().longitude(), 0f);
        assertEquals(address, venue.address());
        assertEquals(title, venue.title());
        assertEquals(frsqrId, venue.foursquareId());
        assertEquals(frsqrType, venue.foursquareType());

        String ggId = "ggId", ggType = "library";
        venue = bot.execute(new SendVenue(chatId, lat, lng, title, address)
                .googlePlaceId(ggId).googlePlaceType(ggType)
        ).message().venue();
        assertEquals(ggId, venue.googlePlaceId());
        assertEquals(ggType, venue.googlePlaceType());
    }

    @Test
    public void sendContact() {
        String phone = "000111", name = "first", lastName = "last", vcard = "ok vcard";
        Contact contact = bot.execute(new SendContact(chatId, phone, name).lastName(lastName).vcard(vcard)).message().contact();
        assertEquals(phone, contact.phoneNumber());
        assertEquals(name, contact.firstName());
        assertEquals(lastName, contact.lastName());
        assertEquals(vcard, contact.vcard());
        assertNull(contact.userId());
    }

    @Test
    public void deleteMessage() {
        Message message = bot.execute(new SendMessage(chatId, "message for delete")).message();
        BaseResponse response = bot.execute(new DeleteMessage(chatId, message.messageId()));
        assertTrue(response.isOk());
    }

    @Test
    public void deleteMessages() {
        Message message = bot.execute(new SendMessage(chatId, "message for delete")).message();
        int[] ids = {message.messageId()};
        BaseResponse response = bot.execute(new DeleteMessages(chatId, ids));
        assertTrue(response.isOk());
    }

    @Test
    public void setMessageReaction() {
        BaseResponse response = bot.execute(new SetMessageReaction(chatId, 100, new ReactionTypeEmoji("👍")));
        assertTrue(response.isOk());
    }

    @Test
    public void getUserChatBoosts() {
        ChatBoost[] chatBoosts = bot.execute(new GetUserChatBoosts(channelId, chatId)).boosts();
        assertEquals(chatBoosts.length, 0);
    }

    @Test
    public void sendChatAction() {
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.typing.name())).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.typing)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.upload_photo)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.record_video)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.upload_video)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.record_voice)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.upload_voice)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.upload_document)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.find_location)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.record_video_note)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.upload_video_note)).isOk());
        assertTrue(bot.execute(new SendChatAction(chatId, ChatAction.choose_sticker)).isOk());
        assertTrue(bot.execute(new SendChatAction(forum, ChatAction.choose_sticker).messageThreadId(forumEditThread)).isOk());
    }

    @Test
    public void sendVideoNote() {
        SendResponse response = bot.execute(new SendVideoNote(chatId, "DQADAgADmQADYgwpSbum1JrxPsbmAg"));
        VideoNoteCheck.check(response.message().videoNote());
    }

    @Test
    public void sendVideoNoteFile() {
        SendResponse response = bot.execute(new SendVideoNote(chatId, videoNoteFile).thumb(thumbFile).length(20).duration(30));
        VideoNoteCheck.check(response.message().videoNote(), true);
        assertNotEquals("telegram should generate thumb", thumbSize, response.message().videoNote().thumb().fileSize());

        response = bot.execute(new SendVideoNote(chatId, videoNoteBytes).thumb(thumbBytes));
        VideoNoteCheck.check(response.message().videoNote(), true);
        assertNotEquals("telegram should generate thumb", thumbSize, response.message().videoNote().thumb().fileSize());
    }

    @Test
    public void setChatAdministratorCustomTitle() {
        BaseResponse response = bot.execute(new PromoteChatMember(groupId, memberBot).canPromoteMembers(true));
        assertTrue(response.isOk());

        String customTitle = "aqi " + new Random().nextInt(999999);
        response = bot.execute(new SetChatAdministratorCustomTitle(groupId, memberBot, customTitle));
        assertTrue(response.isOk());

        ChatMember member = bot.execute(new GetChatMember(groupId, memberBot)).chatMember();
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
            BaseResponse response = bot.execute(new SetChatPermissions(groupId, setPerms)
                    .useIndependentChatPermissions(false));
            assertTrue(response.isOk());

            ChatFullInfo chat = bot.execute(new GetChat(groupId)).chat();
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
        StringResponse response = bot.execute(new ExportChatInviteLink(groupId));
        assertTrue(response.isOk());
        assertNotNull(response.result());
    }

    @Test
    public void setChatPhoto() throws IOException {
        BaseResponse response = bot.execute(new SetChatPhoto(groupId, imageFile));
        assertTrue(response.isOk());

        byte[] bytes = Files.readAllBytes(imageFile.toPath());
        response = bot.execute(new SetChatPhoto(groupId, bytes));
        assertTrue(response.isOk());
    }

    @Test
    public void deleteChatPhoto() {
        BaseResponse response = bot.execute(new DeleteChatPhoto(groupId));
        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: CHAT_NOT_MODIFIED", response.description());
        }
    }

    @Test
    public void setChatTitle() {
        BaseResponse response = bot.execute(new SetChatTitle(groupId, "Test Bot Group " + System.currentTimeMillis()));
        assertTrue(response.isOk());
    }

    @Test
    public void setChatDescription() {
        BaseResponse response = bot.execute(new SetChatDescription(groupId, "New desc " + System.currentTimeMillis()));
        assertTrue(response.isOk());
    }

    @Test
    public void pinChatMessage() {
        BaseResponse response = bot.execute(new PinChatMessage(groupId, 18).disableNotification(false));
        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: CHAT_NOT_MODIFIED", response.description());
        }
    }

    @Test
    public void unpinChatMessage() {
        BaseResponse response = bot.execute(new UnpinChatMessage(groupId).messageId(3600));
        assertTrue(response.isOk());
    }

    @Test
    public void unpinAllChatMessages() {
        BaseResponse response = bot.execute(new UnpinAllChatMessages(groupId));
        assertTrue(response.isOk());
    }

    @Test
    public void getStickerSet() {
        GetStickerSetResponse response = bot.execute(new GetStickerSet(stickerSet));
        StickerSet stickerSet = response.stickerSet();
        for (Sticker sticker : response.stickerSet().stickers()) {
            StickerTest.check(sticker, true, true);
        }
        // clean up stickers, max 120 allowed
        if (stickerSet.stickers().length > 50) {
            for (int i = stickerSet.stickers().length - 1; i > stickerSet.stickers().length - 10; i--) {
                bot.execute(new DeleteStickerFromSet(stickerSet.stickers()[i].fileId()));
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
        GetFileResponse response = bot.execute(new UploadStickerFile(chatId, bytes, Sticker.Format.Static));
        FileTest.check(response.file(), false);

        response = bot.execute(new UploadStickerFile(chatId, bytes, Sticker.Format.Static));
        FileTest.check(response.file(), false);
    }

    @Test
    public void createNewPngStickerSetAndAddSticker() {
        String name = "test" + System.currentTimeMillis() + "_by_pengrad_test_bot";
        String[] emojis = new String[]{"\uD83D\uDE00"};
        InputSticker[] stickers = new InputSticker[]{new InputSticker(stickerFile, Sticker.Format.Static, emojis)};
        BaseResponse response = bot.execute(
                new CreateNewStickerSet(chatId, name, "test1", stickers)
                        .stickerType(Sticker.Type.mask));
        assertTrue(response.isOk());

        response = bot.execute(new AddStickerToSet(chatId, name,
                new InputSticker(stickerId, Sticker.Format.Static, emojis)
                        .maskPosition(new MaskPosition("eyes", 0f, 0f, 1f))));
        assertTrue(response.isOk());
    }

    @Test
    public void createNewWebmStickerSetAndAddSticker() {
        String setName = "test" + System.currentTimeMillis() + "_by_pengrad_test_bot";
        String[] emojis = new String[]{"\uD83D\uDE00"};
        InputSticker[] stickers = new InputSticker[]{new InputSticker(stickerFileVid, Sticker.Format.video, emojis)};
        BaseResponse response = bot.execute(
                new CreateNewStickerSet(chatId, setName, "test1", stickers)
                        .stickerType(Sticker.Type.regular)
        );
        assertTrue(response.isOk());
    }

    @Test
    public void addStickerToSet() {
        BaseResponse response = bot.execute(
                new AddStickerToSet(chatId, stickerSet,
                        new InputSticker("BQADAgADuAAD7yupS4eB23UmZhGuAg", Sticker.Format.Static, new String[]{"\uD83D\uDE15"})
                                .maskPosition(new MaskPosition("eyes", 0f, 0f, 1f))));
        assertTrue(response.isOk());
    }

    @Test
    public void createSetAndAddStickerTgs() {
        String setName = "test" + System.currentTimeMillis() + "_by_pengrad_test_bot";
        InputSticker[] stickers = new InputSticker[]{new InputSticker(stickerFileAnim, Sticker.Format.animated, new String[]{"\uD83D\uDE00"})};
        BaseResponse response = bot.execute(
                new CreateNewStickerSet(chatId, setName, "test1", stickers));
        assertTrue(response.isOk());
    }

    @Test
    public void createNewStickerSet() {
        String setName = "testNEW" + System.currentTimeMillis() + "_by_pengrad_test_bot";
        String title = "test112312312";
        BaseResponse response = bot.execute(
                new CreateNewStickerSet(chatId, setName, title, new InputSticker[]{
                        new InputSticker(stickerFile, Sticker.Format.Static, new String[]{"\uD83D\uDE00"})
                                .keywords(new String[]{"yes", "no"})
                                .maskPosition(new MaskPosition(MaskPosition.Point.forehead, 10f, 20f, 1f))
                }, Sticker.Format.Static)
                        .needsRepainting(false));
        assertTrue(response.isOk());

        StickerSet set = bot.execute(new GetStickerSet(setName)).stickerSet();
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

        response = bot.execute(new SetStickerSetTitle(setName, "new title"));
        assertTrue(response.isOk());

        String stickerId = stickers[0].fileId();
        response = bot.execute(new SetStickerEmojiList(stickerId, new String[]{"\uD83D\uDE00"}));
        assertTrue(response.isOk());

        response = bot.execute(new SetStickerKeywords(stickerId).keywords(new String[]{"ok"}));
        assertTrue(response.isOk());

        response = bot.execute(new SetStickerMaskPosition(stickerId)
                .maskPosition(new MaskPosition(MaskPosition.Point.mouth, 0f, 0f, 0f)));
        assertFalse(response.isOk());
        assertEquals("Bad Request: STICKER_MASK_COORDS_NOT_SUPPORTED", response.description());

        response = bot.execute(new DeleteStickerSet(setName));
        assertTrue(response.isOk());
    }

    @Test
    public void setStickerPositionInSet() {
        GetStickerSetResponse setResponse = bot.execute(new GetStickerSet(stickerSet));
        Sticker sticker = setResponse.stickerSet().stickers()[0];

        BaseResponse response = bot.execute(new SetStickerPositionInSet(sticker.fileId(), 0));
        assertTrue(response.isOk());
    }

    @Test
    public void deleteStickerFromSet() {
        InputSticker inputSticker = new InputSticker("BQADAgADuAAD7yupS4eB23UmZhGuAg", Sticker.Format.Static, new String[]{"\uD83D\uDE15"});
        BaseResponse response = bot.execute(new AddStickerToSet(chatId, stickerSet, inputSticker));
        assertTrue(response.isOk());

        GetStickerSetResponse setResponse = bot.execute(new GetStickerSet(stickerSet));
        int size = setResponse.stickerSet().stickers().length;
        Sticker sticker = setResponse.stickerSet().stickers()[size - 1];

        response = bot.execute(new DeleteStickerFromSet(sticker.fileId()));
        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: STICKERSET_NOT_MODIFIED", response.description());
        }
    }

    @Test
    public void setStickerSetThumb() {
        String thumbFile = "CAACAgIAAxkBAAJ0ll6DO4bNCynpfZmS6g-YcGY2zrP5AAIBAAPANk8TGC5zMKs_LVEYBA";
        BaseResponse response = bot.execute(new SetStickerSetThumb(stickerSetAnim, chatId, thumbFile));
        assertTrue(response.isOk());

        response = bot.execute(new SetStickerSetThumbnail(stickerSetAnim, chatId, thumbFile));
        assertTrue(response.isOk());

        StickerSet set = bot.execute(new GetStickerSet(stickerSetAnim)).stickerSet();
        assertFalse(set.isAnimated());
        PhotoSize thumb = set.thumb();
        PhotoSizeTest.checkPhotos(thumb);
        assertEquals(Integer.valueOf(100), thumb.width());
        assertEquals(Integer.valueOf(100), thumb.height());
        assertEquals(Long.valueOf(8244), thumb.fileSize());

        // clear thumb by not sending it
        response = bot.execute(new SetStickerSetThumb(stickerSetAnim, chatId));
        assertTrue(response.isOk());

        response = bot.execute(new SetStickerSetThumbnail(stickerSetAnim, chatId));
        assertTrue(response.isOk());
    }

    @Test
    public void getCustomEmojiStickers() {
        GetCustomEmojiStickersResponse response = bot.execute(new GetCustomEmojiStickers("5434144690511290129"));
        assertTrue(response.isOk());
        assertEquals(1, response.result().length);
    }

    @Test
    public void setCustomEmojiStickerSetThumbnail() {
        String setName = "custom_emoji_set_" + System.currentTimeMillis() + "_by_pengrad_test_bot";
        BaseResponse response = bot.execute(
                new CreateNewStickerSet(chatId, setName, "title",
                        new InputSticker[]{new InputSticker(stickerFileAnim, Sticker.Format.animated, new String[]{"\uD83D\uDE15"})},
                        Sticker.Format.animated
                ).stickerType(Sticker.Type.custom_emoji)
        );
        assertTrue(response.isOk());

        response = bot.execute(new SetCustomEmojiStickerSetThumbnail(setName).customEmojiId("123"));
        assertTrue(response.isOk());

        response = bot.execute(new DeleteStickerSet(setName));
        assertTrue(response.isOk());
    }

    @Test
    public void editMessageLiveLocation() {
        BaseResponse response = bot.execute(new EditMessageLiveLocation(chatId, 10009, 21, 105)
                .replyMarkup(new InlineKeyboardMarkup()));
        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: message can't be edited", response.description());
        }

        String buttonText = "btn_" + System.currentTimeMillis();
        response = bot.execute(
                new EditMessageLiveLocation("AgAAAPrwAQCj_Q4D2s-51_8jsuU", 21, 102)
                        .horizontalAccuracy(1f)
                        .heading(10)
                        .proximityAlertRadius(100)
                        .replyMarkup(new InlineKeyboardMarkup(new InlineKeyboardButton(buttonText).callbackGame(buttonText)))
        );
        assertTrue(response.isOk());
    }

    @Test
    public void stopMessageLiveLocation() {
        BaseResponse response = bot.execute(new StopMessageLiveLocation(chatId, 10009));
        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: message can't be edited", response.description());
        }

        response = bot.execute(new StopMessageLiveLocation("AgAAAPrwAQCj_Q4D2s-51_8jsuU"));
        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: message is not modified: specified new message content and reply markup are exactly the same as a current content and reply markup of the message",
                    response.description());
        }
    }

    @Test
    public void setChatStickerSet() {
        BaseResponse response = bot.execute(new SetChatStickerSet(groupId, "PengradTest"));
        assertFalse(response.isOk());
        assertEquals(400, response.errorCode());
    }

    @Test
    public void deleteChatStickerSet() {
        BaseResponse response = bot.execute(new DeleteChatStickerSet(groupId));
        assertFalse(response.isOk());
        assertEquals(400, response.errorCode());
    }

    @Test
    public void sendMediaGroup() {
        String url = "https://google.com/";
        User user = new User(memberBot);
        String language = "ru";
        MessagesResponse response = bot.execute(new SendMediaGroup(chatId,
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
                        .duration(10).width(11).height(12).supportsStreaming(true)
        ).messageThreadId(0).disableNotification(false).allowSendingWithoutReply(false).replyToMessageId(1));
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
        MessagesResponse response = bot.execute(new SendMediaGroup(chatId,
                new InputMediaDocument(docFile),
                new InputMediaDocument(docBytes).fileName("test.pdf").contentType("application/pdf")
        ));
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

        response = (SendResponse) bot.execute(new EditMessageMedia(chatId, messageId,
                new InputMediaDocument(docFile)
                        .thumb(thumbFile)
                        .disableContentTypeDetection(true)
        ).replyMarkup(new InlineKeyboardMarkup()));
        assertEquals((Long) 13264L, response.message().document().fileSize());
        assertEquals(thumbSize, response.message().document().thumb().fileSize());

        response = (SendResponse) bot.execute(new EditMessageMedia(chatId, messageId,
                new InputMediaDocument(docBytes).thumb(thumbBytes)));
        assertEquals((Long) 13264L, response.message().document().fileSize());
        assertEquals(thumbSize, response.message().document().thumb().fileSize());

        response = (SendResponse) bot.execute(new EditMessageMedia(chatId, messageId, new InputMediaDocument(docFileId)));
        MessageTest.checkMessage(response.message());
        DocumentTest.check(response.message().document());


        response = (SendResponse) bot.execute(new EditMessageMedia(chatId, messageId, new InputMediaAnimation(gifFile)));
        assertEquals(Integer.valueOf(1), response.message().animation().duration());

        int expectedSize = 160; // idk why?
        Integer durationAnim = 17, width = 21, height = 22;
        response = (SendResponse) bot.execute(new EditMessageMedia(chatId, messageId,
                new InputMediaAnimation(gifBytes).duration(durationAnim).width(width).height(height).hasSpoiler(true)
        ));
        Animation animation = response.message().animation();
        assertEquals(1, animation.duration().intValue());
        assertEquals(expectedSize, animation.width().intValue());
        assertEquals(expectedSize, animation.height().intValue());

        response = (SendResponse) bot.execute(new EditMessageMedia(chatId, messageId, new InputMediaAnimation(gifFileId)));
        assertTrue(response.isOk());
        AnimationCheck.check(response.message().animation());
        assertEquals(Integer.valueOf(3), response.message().animation().duration());
        assertNotEquals(gifFileId, response.message().animation().fileId());
        assertNotNull(response.message().document());
        assertEquals(Long.valueOf(57527), response.message().document().fileSize());
        assertEquals("video/mp4", response.message().document().mimeType());

        response = (SendResponse) bot.execute(new EditMessageMedia(chatId, messageId, new InputMediaAudio(audioFileId)));
        assertEquals(Long.valueOf(10286), response.message().audio().fileSize());
        response = (SendResponse) bot.execute(new EditMessageMedia(chatId, messageId, new InputMediaAudio(audioFile)));
        assertEquals(Long.valueOf(10286), response.message().audio().fileSize());
        response = (SendResponse) bot.execute(new EditMessageMedia(chatId, messageId, new InputMediaAudio(audioBytes)));
        assertEquals(Long.valueOf(10286), response.message().audio().fileSize());
        Integer duration = 34;
        String performer = "some performer", title = "just a title", fileName = "beep.mp3";
        response = (SendResponse) bot.execute(new EditMessageMedia(chatId, messageId,
                new InputMediaAudio(audioFile).duration(duration).performer(performer).title(title)
        ));
        Audio audio = response.message().audio();
        assertEquals(Long.valueOf(10286), audio.fileSize());
        assertEquals(duration, audio.duration());
        assertEquals(performer, audio.performer());
        assertEquals(title, audio.title());
        assertEquals(fileName, audio.fileName());

        // send multipart InputMediaPhoto, InputMediaVideo to cover getFileName and getContentType
        response = (SendResponse) bot.execute(new EditMessageMedia(chatId, messageId, new InputMediaPhoto(photoFileId).thumb(thumbFile)));
        assertNotNull(response.message().photo());
        response = (SendResponse) bot.execute(new EditMessageMedia(chatId, messageId, new InputMediaVideo(videoFileId).thumb(thumbFile)));
        assertNotNull(response.message().video());
    }

    @Test
    public void sendAnimation() {
        int expectedSize = 160; // idk why?
        int width = 340, height = 240;
        String caption = "gif *file*", captionCheck = "gif file";
        SendResponse response = bot.execute(new SendAnimation(chatId, gifFile)
                .duration(222).width(width).height(height).thumb(thumbFile)
                .caption(caption).parseMode(ParseMode.Markdown).hasSpoiler(true));
        assertTrue(response.isOk());
        Animation animation = response.message().animation();
        assertEquals((Integer) 1, animation.duration());
        assertEquals(expectedSize, animation.width().intValue());
        assertEquals(expectedSize, animation.height().intValue());
        assertNotEquals("telegram should generate thumb", thumbSize, animation.thumb().fileSize());
        assertEquals(captionCheck, response.message().caption());
        assertEquals(MessageEntity.Type.bold, response.message().captionEntities()[0].type());

        response = bot.execute(new SendAnimation(chatId, gifBytes).thumb(thumbBytes)
                .caption("caption").captionEntities(new MessageEntity(MessageEntity.Type.italic, 0, 7)));
        animation = response.message().animation();
        assertEquals((Integer) 1, animation.duration());
        assertEquals(expectedSize, animation.width().intValue());
        assertEquals(expectedSize, animation.height().intValue());
        assertNotEquals("telegram should generate thumb", thumbSize, animation.thumb().fileSize());
        MessageEntity captionEntity = response.message().captionEntities()[0];
        assertEquals(MessageEntity.Type.italic, captionEntity.type());
        assertEquals((Integer) 0, captionEntity.offset());
        assertEquals((Integer) 7, captionEntity.length());

        response = bot.execute(new SendAnimation(chatId, gifFileId));
        animation = response.message().animation();
        assertEquals((Integer) 3, animation.duration());
        assertEquals((Integer) 128, animation.width());
        assertEquals((Integer) 128, animation.height());
    }

    @Test
    public void setPassportDataErrors() {
        BaseResponse response = bot.execute(new SetPassportDataErrors(chatId,
                new PassportElementErrorDataField("personal_details", "first_name",
                        "TueU2/SswOD5wgQ6uXQ62mJrr0Jdf30r/QQ/jyETHFM=",
                        "error in page 1")
        ));
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
        SendResponse sendResponse = bot.execute(
                new SendPoll(groupId, question, answers)
                        .isAnonymous(false)
                        .type(Poll.Type.quiz)
                        .allowsMultipleAnswers(false)
                        .correctOptionId(1)
                        .isClosed(false)
                        .explanation("Some __explanation__ of poll")
                        .explanationParseMode(ParseMode.MarkdownV2)
                        .openPeriod(500)
        );
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
        SendResponse sendResponse = bot.execute(
                new SendPoll(chatId, question, answers)
                        .type("regular")
                        .allowsMultipleAnswers(true)
                        .replyMarkup(new ReplyKeyboardMarkup(
                                new KeyboardButton("all polls").requestPoll(new KeyboardButtonPollType()),
                                new KeyboardButton("quiz").requestPoll(new KeyboardButtonPollType(Poll.Type.quiz)),
                                new KeyboardButton("regular").requestPoll(new KeyboardButtonPollType("regular"))))
                        .closeDate(closeDate)
        );
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
        SendResponse sendResponse = bot.execute(new SendPoll(groupId, question, answers).messageThreadId(0));
        Integer messageId = sendResponse.message().messageId();

        PollResponse response = bot.execute(new StopPoll(groupId, messageId));
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
        assertNull(pollAnswer.voterChat());
        UserTest.checkUser(pollAnswer.user(), true);
        assertEquals(Long.valueOf(12345), pollAnswer.user().id());
        assertArrayEquals(new Integer[]{0, 2}, pollAnswer.optionIds());
    }

    @Test
    public void testAsyncCallback() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        bot.execute(new GetMe(), new Callback<GetMe, GetMeResponse>() {
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
        botClient.send(new GetMe(), new Callback<GetMe, GetMeResponse>() {
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
        assertEquals("{\"method\":\"getMe\"}", new GetMe().toWebhookResponse());
    }

    @Test
    public void loginButton() {
        String text = "login";
        String url = "https://pengrad.herokuapp.com/hello";
        SendResponse response = bot.execute(
                new SendMessage(chatId, "Login button").replyMarkup(new InlineKeyboardMarkup(
                        new InlineKeyboardButton(text).loginUrl(new LoginUrl(url)
                                .forwardText("forwarded login")
                                .botUsername("pengrad_test_bot")
                                .requestWriteAccess(true)))));
        assertTrue(response.isOk());
        InlineKeyboardButton button = response.message().replyMarkup().inlineKeyboard()[0][0];
        assertEquals(text, button.text());
        assertEquals(url, button.url());
    }

    @Test
    public void multipartNonAscii() {
        String caption = "хорошо";
        Message message = bot.execute(
                new SendPhoto(chatId, imageFile).fileName("файл.txt").caption(caption)
        ).message();
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
        SendResponse response = bot.execute(new SendDice(chatId));
        Dice dice = response.message().dice();
        assertNotNull(dice);
        assertTrue(dice.value() >= 1 && dice.value() <= 6);
        assertEquals("🎲", dice.emoji());

        response = bot.execute(new SendDice(chatId).darts());
        dice = response.message().dice();
        assertNotNull(dice);
        assertTrue(dice.value() >= 1 && dice.value() <= 6);
        assertEquals("🎯", dice.emoji());

        response = bot.execute(new SendDice(chatId).basketball());
        dice = response.message().dice();
        assertNotNull(dice);
        assertTrue(dice.value() >= 1 && dice.value() <= 5);
        assertEquals("🏀", dice.emoji());

        response = bot.execute(new SendDice(chatId).football());
        dice = response.message().dice();
        assertNotNull(dice);
        assertTrue(dice.value() >= 1 && dice.value() <= 5);
        assertEquals("⚽", dice.emoji());

        response = bot.execute(new SendDice(chatId).slotMachine());
        dice = response.message().dice();
        assertNotNull(dice);
        assertTrue(dice.value() >= 1 && dice.value() <= 64);
        assertEquals("🎰", dice.emoji());

        response = bot.execute(new SendDice(chatId).bowling());
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

        SetMyCommands cmds = new SetMyCommands(commands);
        cmds.languageCode("en");
        cmds.scope(new BotCommandScopeAllChatAdministrators());

        BaseResponse response = bot.execute(cmds);
        assertTrue(response.isOk());

        GetMyCommands getCmds = new GetMyCommands();
        getCmds.languageCode("en");
        getCmds.scope(new BotCommandScopeAllChatAdministrators());

        GetMyCommandsResponse commandsResponse = bot.execute(getCmds);
        assertTrue(commandsResponse.isOk());
        assertEquals(commands[0].command(), commandsResponse.commands()[0].command());
        assertEquals(commands[0].description(), commandsResponse.commands()[0].description());
        assertArrayEquals(commandsResponse.commands(), commands);
    }

    @Test
    public void deleteMyCommands() {
        DeleteMyCommands cmds = new DeleteMyCommands();
        cmds.languageCode("en");
        cmds.scope(new BotCommandScopeAllChatAdministrators());

        BaseResponse response = bot.execute(cmds);
        assertTrue(response.isOk());

        GetMyCommands getCmds = new GetMyCommands();
        getCmds.languageCode("en");
        getCmds.scope(new BotCommandScopeAllChatAdministrators());

        GetMyCommandsResponse commandsResponse = bot.execute(getCmds);
        assertTrue(commandsResponse.isOk());
        assertArrayEquals(commandsResponse.commands(), new BotCommand[0]);
    }

    @Test
    public void inviteLinks() {
        int memberLimit = 2;
        int expireDate = (int) (System.currentTimeMillis() / 1000) + 500;
        String name = "TestName";

        ChatInviteLinkResponse response = bot.execute(new CreateChatInviteLink(groupId)
                .expireDate(expireDate)
                .memberLimit(memberLimit)
                .name(name));
        ChatInviteLink link = response.chatInviteLink();
        assertEquals(expireDate, link.expireDate().intValue());
        assertEquals(memberLimit, link.memberLimit().intValue());
        assertFalse(link.isRevoked());
        assertTrue(link.creator().isBot());
        assertEquals(name, link.name());

        int editMemberLimit = 3;
        int editExpireDate = (int) (System.currentTimeMillis() / 1000) + 1500;
        String editName = name + "edit";
        response = bot.execute(new EditChatInviteLink(groupId, link.inviteLink())
                .expireDate(editExpireDate)
                .memberLimit(editMemberLimit)
                .name(editName));
        link = response.chatInviteLink();
        assertEquals(editExpireDate, link.expireDate().intValue());
        assertEquals(editMemberLimit, link.memberLimit().intValue());
        assertEquals(editName, link.name());
        assertFalse(link.isRevoked());

        response = bot.execute(new RevokeChatInviteLink(groupId, link.inviteLink()));
        link = response.chatInviteLink();
        assertTrue(link.isRevoked());
        assertFalse(link.isPrimary());

        response = bot.execute(new CreateChatInviteLink(groupId).createsJoinRequest(true));
        link = response.chatInviteLink();
        assertTrue(link.createsJoinRequest());
        assertNull(link.pendingJoinRequestCount());

        response = bot.execute(new EditChatInviteLink(groupId, link.inviteLink()).createsJoinRequest(false));
        assertFalse(response.chatInviteLink().createsJoinRequest());
    }

    @Test
    public void chatJoinRequest() {
        BaseResponse response = bot.execute(new ApproveChatJoinRequest(groupId, memberBot));
        assertFalse(response.isOk());
        assertEquals("Bad Request: USER_ALREADY_PARTICIPANT", response.description());

        response = bot.execute(new DeclineChatJoinRequest(groupId, memberBot));
        assertFalse(response.isOk());
        assertEquals("Bad Request: HIDE_REQUESTER_MISSING", response.description());
    }

    @Test
    public void banChatSenderChat() {
        BaseResponse response = bot.execute(new BanChatSenderChat(channelName, memberBot));
        assertTrue(response.isOk());
    }

    @Test
    public void unbanChatSenderChat() {
        BaseResponse response = bot.execute(new UnbanChatSenderChat(channelName, memberBot));
        assertTrue(response.isOk());
    }

    @Test
    public void setChatMenuButton() {
        BaseResponse response = bot.execute(new SetChatMenuButton().chatId(chatId)
                .menuButton(new MenuButtonWebApp("webapp", new WebAppInfo("https://core.telegram.org"))));
        assertTrue(response.isOk());

        response = bot.execute(new SetChatMenuButton().chatId(chatId)
                .menuButton(new MenuButtonCommands()));
        assertTrue(response.isOk());

        response = bot.execute(new SetChatMenuButton().chatId(chatId)
                .menuButton(new MenuButtonDefault()));
        assertTrue(response.isOk());
    }

    @Test
    public void getChatMenuButton() {
        MenuButton menu = new MenuButtonCommands();
        BaseResponse set = bot.execute(new SetChatMenuButton().chatId(chatId)
                .menuButton(menu));
        assertTrue(set.isOk());

        GetChatMenuButtonResponse response = bot.execute(new GetChatMenuButton().chatId(chatId));
        assertTrue(response.isOk());
        assertEquals(menu.type(), response.result().type());
    }

    @Test
    public void sendWebAppInfo() {
        String text = "gh_app";
        String url = "https://github.com/";
        SendResponse response = bot.execute(new SendMessage(chatId, "message with webApp")
                .replyMarkup(new InlineKeyboardMarkup(new InlineKeyboardButton(text).webApp(new WebAppInfo(url))))
        );
        assertTrue(response.isOk());

        InlineKeyboardMarkup markup = response.message().replyMarkup();
        assertNotNull(markup);
        assertEquals(1, markup.inlineKeyboard().length);
        assertEquals(1, markup.inlineKeyboard()[0].length);

        InlineKeyboardButton button = markup.inlineKeyboard()[0][0];
        assertEquals(text, button.text());
        assertNotNull(button.webApp());
        assertEquals(url, button.webApp().url());

        response = bot.execute(new SendMessage(chatId, "message with webApp")
                .replyMarkup(new ReplyKeyboardMarkup(new KeyboardButton(text).webAppInfo(new WebAppInfo(url))))
        );
        assertTrue(response.isOk());
    }

    @Test
    public void getMyDefaultAdministratorRights() {
        bot.execute(new SetMyDefaultAdministratorRights()
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
                        .canPostStories(false)
                        .canEditStories(false)
                        .canDeleteStories(false)
                ));
        ChatAdministratorRights rights = bot.execute(new GetMyDefaultAdministratorRights().forChannels(false)).result();
        assertFalse(rights.isAnonymous());
        assertFalse(rights.canManageChat());
        assertFalse(rights.canDeleteMessages());
        assertFalse(rights.canManageVideoChats());
        assertFalse(rights.canRestrictMembers());
        assertFalse(rights.canPromoteMembers());
        assertFalse(rights.canChangeInfo());
        assertFalse(rights.canInviteUsers());
        assertFalse(rights.canPostMessages()); // channels only
        assertFalse(rights.canEditMessages()); // channels only
        assertFalse(rights.canPinMessages());
        assertFalse(rights.canManageTopics());
        assertFalse(rights.canPostStories());
        assertFalse(rights.canEditStories());
        assertFalse(rights.canDeleteStories());
    }

    @Test
    public void getForumTopicIconStickers() {
        List<Sticker> stickers = bot.execute(new GetForumTopicIconStickers()).stickers();
        assertFalse(stickers.isEmpty());
    }

    @Test
    public void createForumTopic() {
        Integer color = 7322096;
        String emoji = "5434144690511290129";
        CreateForumTopicResponse createResponse = bot.execute(
                new CreateForumTopic(forum, "test_topic").iconColor(color).iconCustomEmojiId(emoji)
        );
        assertTrue(createResponse.isOk());
        ForumTopic topic = createResponse.forumTopic();
        assertNotNull(topic);
        assertEquals(color, topic.iconColor());
        assertEquals(emoji, topic.iconCustomEmojiId());

        String name = "test_topic_edit";
        BaseResponse response = bot.execute(
                new EditForumTopic(forum, topic.messageThreadId()).name(name).iconCustomEmojiId("")
        );
        assertTrue(response.isOk());

        response = bot.execute(new CloseForumTopic(forum, topic.messageThreadId()));
        assertTrue(response.isOk());

        response = bot.execute(new ReopenForumTopic(forum, topic.messageThreadId()));
        assertTrue(response.isOk());

        response = bot.execute(new DeleteForumTopic(forum, topic.messageThreadId()));
        assertTrue(response.isOk());
    }

    @Test
    public void unpinAllForumTopicMessages() {
        String name = "edit_thread-" + System.currentTimeMillis();
        BaseResponse response = bot.execute(new EditForumTopic(forum, forumEditThread, name, ""));
        assertTrue(response.isOk());
        response = bot.execute(new UnpinAllForumTopicMessages(forum, forumEditThread));
        assertTrue(response.isOk());
    }

    @Test
    public void unpinAllGeneralForumTopicMessages() {
        BaseResponse response = bot.execute(new UnpinAllGeneralForumTopicMessages(forum));
        assertTrue(response.isOk());
    }

    @Test
    public void editGeneralForumTopic() {
        String name = "General " + System.currentTimeMillis();
        BaseResponse response = bot.execute(new EditGeneralForumTopic(forum, name));
        assertTrue(response.isOk());

        response = bot.execute(new CloseGeneralForumTopic(forum));
        assertTrue(response.isOk());

        response = bot.execute(new HideGeneralForumTopic(forum));
        assertTrue(response.isOk());

        response = bot.execute(new UnhideGeneralForumTopic(forum));
        assertTrue(response.isOk());

        response = bot.execute(new ReopenGeneralForumTopic(forum));
        assertTrue(response.isOk());
    }

    @Test
    public void setMyDescription() {
        BaseResponse response = bot.execute(new SetMyDescription().description("desc").languageCode("en"));
        assertTrue(response.isOk());

        GetMyDescriptionResponse descResponse = bot.execute(new GetMyDescription().languageCode("en"));
        assertTrue(descResponse.isOk());
        BotDescription desc = descResponse.botDescription();
        assertNotNull(desc);
        assertEquals("desc", desc.description());
    }

    @Test
    public void setMyShortDescription() {
        BaseResponse response = bot.execute(new SetMyShortDescription().description("short_desc").languageCode("en"));
        assertTrue(response.isOk());

        GetMyShortDescriptionResponse descResponse = bot.execute(new GetMyShortDescription().languageCode("en"));
        assertTrue(descResponse.isOk());
        BotShortDescription desc = descResponse.botShortDescription();
        assertNotNull(desc);
        assertEquals("short_desc", desc.shortDescription());
    }

    @Test
    public void setMyName() {
        retry.setEnabled(false);
        BaseResponse response = bot.execute(new SetMyName().name("name").languageCode("en"));
        if (!response.isOk()) {
            assertEquals(429, response.errorCode());
            assertTrue(response.description().startsWith("Too Many Requests: retry after"));
        }
        retry.setEnabled(true);

        GetMyNameResponse nameResponse = bot.execute(new GetMyName().languageCode("en"));
        assertTrue(nameResponse.isOk());
        assertEquals("name", nameResponse.botName().name());
    }

    @Test
    public void answerWebAppQuery() {
        SentWebAppMessageResponse response = bot.execute(new AnswerWebAppQuery("123", new InlineQueryResultArticle("1", "title", "text")));
        assertFalse(response.isOk());
        assertEquals("Bad Request: query is too old and response timeout expired or query ID is invalid", response.description());
        assertNull(response.sentWebAppMessage());
    }

    @Test
    public void sendPaidMedia() {
        Integer starCount = 2;
        SendResponse response = bot.execute(new SendPaidMedia(chatId, starCount,
                new InputPaidMediaVideo(videoFile).thumbnail(thumbFile),
                new InputPaidMediaPhoto(photoFileId))
                .caption("caption")
                .parseMode(ParseMode.MarkdownV2)
                .captionEntities(new MessageEntity(MessageEntity.Type.bold, 0, 1))
                .showCaptionAboveMedia(true)
                .disableNotification(true)
                .protectContent(false)
                .replyParameters(new ReplyParameters(forwardMessageId))
                .businessConnectionId("")
                .replyMarkup(new InlineKeyboardMarkup(new InlineKeyboardButton("send")))
                .replyMarkup(new ReplyKeyboardMarkup("reply"))
                .replyMarkup(new ReplyKeyboardRemove())
                .replyMarkup(new ForceReply())
                .payload("payload")
                .allowPaidBroadcast(false)
        );
        PaidMediaInfo mediaInfo = response.message().paidMedia();
        assertTrue(response.isOk());
        assertEquals(starCount, mediaInfo.starCount());
        assertEquals(2, mediaInfo.paidMedia().length);
        assertEquals("video", mediaInfo.paidMedia()[0].type());
        VideoTest.check(((PaidMediaVideo) mediaInfo.paidMedia()[0]).getVideo());
        assertEquals("photo", mediaInfo.paidMedia()[1].type());
        PhotoSizeTest.checkPhotos(((PaidMediaPhoto) mediaInfo.paidMedia()[1]).getPhoto());
    }
}
