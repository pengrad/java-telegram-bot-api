package com.pengrad.telegrambot;

import com.google.gson.Gson;

import com.pengrad.telegrambot.impl.FileApi;
import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.impl.UpdatesHandler;
import com.pengrad.telegrambot.model.*;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.passport.PassportElementError;
import com.pengrad.telegrambot.passport.SetPassportDataErrors;
import com.pengrad.telegrambot.request.*;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

/**
 * Stas Parshin
 * 16 October 2015
 */
public class TelegramBot {

    private final String token;
    private final TelegramBotClient api;
    private final FileApi fileApi;
    private final UpdatesHandler updatesHandler;

    public TelegramBot(String botToken) {
        this(new Builder(botToken));
    }

    TelegramBot(Builder builder) {
        this.token = builder.botToken;
        this.api = builder.api;
        this.fileApi = builder.fileApi;
        this.updatesHandler = builder.updatesHandler;
    }

    public String getToken() {
        return token;
    }

    public String getFullFilePath(File file) {
        return fileApi.getFullFilePath(file.filePath());
    }

    public byte[] getFileContent(File file) throws IOException {
        String fileUrl = getFullFilePath(file);
        URLConnection connection = new URL(fileUrl).openConnection();
        try (InputStream is = connection.getInputStream()) {
            return BotUtils.getBytesFromInputStream(is);
        }
    }

	/**
	 * Use this method to add a new sticker to a set created by the bot. The format of the added sticker must match the format of the other stickers in the set. Emoji sticker sets can have up to 200 stickers. Animated and video sticker sets can have up to 50 stickers. Static sticker sets can have up to 120 stickers. Returns True on success.
	 * @deprecated Use constructor with the InputSticker type (since API v6.6)
	 * @param userId User identifier of sticker set owner
	 * @param name Sticker set name
	 * @param emojis List of 1-20 emoji associated with the sticker
	 * @param tgsSticker The added sticker. Pass a file_id as a String to send a file that already exists on the Telegram servers, upload a new one using multipart/form-data, or pass “attach://file_attach_name” to upload a new one using multipart/form-data under file_attach_name name. Animated and video stickers can't be uploaded via HTTP URL.
	 * @return The newly created command
	 */
	@Deprecated
	public AddStickerToSet addAnimatedStickerToSet(Long userId, String name, String emojis, Object tgsSticker) {
		return AddStickerToSet.tgsSticker(api, userId, name, emojis, tgsSticker);
	}

	/**
	 * Use this method to add a new sticker to a set created by the bot. The format of the added sticker must match the format of the other stickers in the set. Emoji sticker sets can have up to 200 stickers. Animated and video sticker sets can have up to 50 stickers. Static sticker sets can have up to 120 stickers. Returns True on success.
	 * @deprecated Use constructor with the InputSticker type (since API v6.6)
	 * @param userId User identifier of sticker set owner
	 * @param name Sticker set name
	 * @param emojis List of 1-20 emoji associated with the sticker
	 * @param pngSticker The added sticker. Pass a file_id as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, upload a new one using multipart/form-data, or pass “attach://file_attach_name” to upload a new one using multipart/form-data under file_attach_name name.
	 * @return The newly created command
	 */
	@Deprecated
	public AddStickerToSet addStaticStickerToSet(Long userId, String name, String emojis, Object pngSticker) {
		return AddStickerToSet.tgsSticker(api, userId, name, emojis, pngSticker);
	}

	/**
	 * Use this method to add a new sticker to a set created by the bot. The format of the added sticker must match the format of the other stickers in the set. Emoji sticker sets can have up to 200 stickers. Animated and video sticker sets can have up to 50 stickers. Static sticker sets can have up to 120 stickers. Returns True on success.
	 * @param userId User identifier of sticker set owner
	 * @param name Sticker set name
	 * @param sticker A {@link InputSticker InputSticker} object with information about the added sticker. If exactly the same sticker had already been added to the set, then the set isn't changed.
	 * @return The newly created command
	 */
	public AddStickerToSet addStickerToSet(Long userId, String name, InputSticker sticker) {
		return new AddStickerToSet(api, userId, name, sticker);
	}

	/**
	 * Use this method to add a new sticker to a set created by the bot. The format of the added sticker must match the format of the other stickers in the set. Emoji sticker sets can have up to 200 stickers. Animated and video sticker sets can have up to 50 stickers. Static sticker sets can have up to 120 stickers. Returns True on success.
	 * @deprecated Use static methods according to sticker set type - {@link #addAnimatedStickerToSet(Long, String, String, Object) for png}, {@link #addStaticStickerToSet(Long, String, String, Object) for tgs} and {@link #addVideoStickerToSet(Long, String, String, Object) for webm}
	 * @param userId User identifier of sticker set owner
	 * @param name Sticker set name
	 * @param pngSticker The added sticker. Pass a file_id as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, upload a new one using multipart/form-data, or pass “attach://file_attach_name” to upload a new one using multipart/form-data under file_attach_name name. Animated and video stickers can't be uploaded via HTTP URL.
	 * @param emojis List of 1-20 emoji associated with the sticker
	 * @return The newly created command
	 */
	@Deprecated
	public AddStickerToSet addStickerToSet(Long userId, String name, Object pngSticker, String emojis) {
		return new AddStickerToSet(api, userId, name, pngSticker, emojis);
	}

	/**
	 * Use this method to add a new sticker to a set created by the bot. The format of the added sticker must match the format of the other stickers in the set. Emoji sticker sets can have up to 200 stickers. Animated and video sticker sets can have up to 50 stickers. Static sticker sets can have up to 120 stickers. Returns True on success.
	 * @deprecated Use constructor with the InputSticker type (since API v6.6)
	 * @param userId User identifier of sticker set owner
	 * @param name Sticker set name
	 * @param emojis List of 1-20 emoji associated with the sticker
	 * @param webmSticker The added sticker. Pass a file_id as a String to send a file that already exists on the Telegram servers, upload a new one using multipart/form-data, or pass “attach://file_attach_name” to upload a new one using multipart/form-data under file_attach_name name. Animated and video stickers can't be uploaded via HTTP URL.
	 * @return The newly created command
	 */
	@Deprecated
	public AddStickerToSet addVideoStickerToSet(Long userId, String name, String emojis, Object webmSticker) {
		return AddStickerToSet.tgsSticker(api, userId, name, emojis, webmSticker);
	}

	/**
	 * Use this method to send answers to callback queries sent from inline keyboards. The answer will be displayed to the user as a notification at the top of the chat screen or as an alert. On success, True is returned.
	 * @param callbackQueryId Unique identifier for the query to be answered
	 * @return The newly created command
	 */
	public AnswerCallbackQuery answerCallbackQuery(String callbackQueryId) {
		return new AnswerCallbackQuery(api, callbackQueryId);
	}

	/**
	 * Use this method to send answers to an inline query. On success, True is returned.
	 * No more than 50 results per query are allowed.
	 * @param inlineQueryId Unique identifier for the answered query
	 * @param results A list of results for the inline query
	 * @return The newly created command
	 */
	public AnswerInlineQuery answerInlineQuery(String inlineQueryId, InlineQueryResult<?>... results) {
		return new AnswerInlineQuery(api, inlineQueryId, results);
	}

	/**
	 * Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the form of an {@link com.pengrad.telegrambot.model.Update Update} with the field pre_checkout_query. Use this method to respond to such pre-checkout queries. On success, True is returned. Note: The Bot API must receive an answer within 10 seconds after the pre-checkout query was sent.
	 * @param preCheckoutQueryId Unique identifier for the query to be answered
	 * @return The newly created command
	 */
	public AnswerPreCheckoutQuery answerPreCheckoutQuery(String preCheckoutQueryId) {
		return new AnswerPreCheckoutQuery(api, preCheckoutQueryId);
	}

	/**
	 * Once the user has confirmed their payment and shipping details, the Bot API sends the final confirmation in the form of an {@link com.pengrad.telegrambot.model.Update Update} with the field pre_checkout_query. Use this method to respond to such pre-checkout queries. On success, True is returned. Note: The Bot API must receive an answer within 10 seconds after the pre-checkout query was sent.
	 * @param preCheckoutQueryId Unique identifier for the query to be answered
	 * @param errorMessage Error message in human-readable form that explains the reason for failure to proceed with the checkout (e.g. "Sorry, somebody just bought the last of our amazing black T-shirts while you were busy filling out your payment details. Please choose a different color or garment!"). Telegram will display this message to the user.
	 * @return The newly created command
	 */
	public AnswerPreCheckoutQuery answerPreCheckoutQuery(String preCheckoutQueryId, String errorMessage) {
		return new AnswerPreCheckoutQuery(api, preCheckoutQueryId, errorMessage);
	}

	/**
	 * If you sent an invoice requesting a shipping address and the parameter is_flexible was specified, the Bot API will send an {@link com.pengrad.telegrambot.model.Update Update} with a shipping_query field to the bot. Use this method to reply to shipping queries. On success, True is returned.
	 * @param shippingQueryId Unique identifier for the query to be answered
	 * @param shippingOptions A list of available shipping options.
	 * @return The newly created command
	 */
	public AnswerShippingQuery answerShippingQuery(String shippingQueryId, ShippingOption... shippingOptions) {
		return new AnswerShippingQuery(api, shippingQueryId, shippingOptions);
	}

	/**
	 * If you sent an invoice requesting a shipping address and the parameter is_flexible was specified, the Bot API will send an {@link com.pengrad.telegrambot.model.Update Update} with a shipping_query field to the bot. Use this method to reply to shipping queries. On success, True is returned.
	 * @param shippingQueryId Unique identifier for the query to be answered
	 * @param errorMessage Error message in human-readable form that explains why it is impossible to complete the order (e.g. "Sorry, delivery to your desired address is unavailable"). Telegram will display this message to the user.
	 * @return The newly created command
	 */
	public AnswerShippingQuery answerShippingQuery(String shippingQueryId, String errorMessage) {
		return new AnswerShippingQuery(api, shippingQueryId, errorMessage);
	}

	/**
	 * Use this method to set the result of an interaction with a Web App and send a corresponding message on behalf of the user to the chat from which the query originated. On success, a {@link com.pengrad.telegrambot.model.SentWebAppMessage SentWebAppMessage} object is returned.
	 * @param web_app_query_id Unique identifier for the query to be answered
	 * @param result An {@link InlineQueryResult InlineQueryResult} object describing the message to be sent
	 * @return The newly created command
	 */
	public AnswerWebAppQuery answerWebAppQuery(String web_app_query_id, InlineQueryResult<?> result) {
		return new AnswerWebAppQuery(api, web_app_query_id, result);
	}

	/**
	 * Use this method to approve a chat join request. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canInviteUsers can_invite_users} administrator right. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param userId Unique identifier of the target user
	 * @return The newly created command
	 */
	public ApproveChatJoinRequest approveChatJoinRequest(Object chatId, long userId) {
		return new ApproveChatJoinRequest(api, chatId, userId);
	}

	/**
	 * Use this method to ban a user in a group, a supergroup or a channel. In the case of supergroups and channels, the user will not be able to return to the chat on their own using invite links, etc., unless {@link UnbanChatMember unbanned} first. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns True on success.
	 * @param chatId Unique identifier for the target group or username of the target supergroup or channel (in the format @channel_username)
	 * @param userId Unique identifier of the target user
	 * @return The newly created command
	 */
	public BanChatMember banChatMember(Object chatId, long userId) {
		return new BanChatMember(api, chatId, userId);
	}

	/**
	 * Use this method to ban a channel chat in a supergroup or a channel. Until the chat is {@link UnbanChatMember unbanned}, the owner of the banned chat won't be able to send messages on behalf of <b>any of their channels</b>. The bot must be an administrator in the supergroup or channel for this to work and must have the appropriate administrator rights. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param sender_chat_id Unique identifier of the target sender chat
	 * @return The newly created command
	 */
	public BanChatSenderChat banChatSenderChat(Object chatId, long sender_chat_id) {
		return new BanChatSenderChat(api, chatId, sender_chat_id);
	}

	/**
	 * Use this method to close the bot instance before moving it from one local server to another. You need to delete the webhook before calling this method to ensure that the bot isn't launched again after server restart. The method will return error 429 in the first 10 minutes after the bot is launched. Returns True on success. Requires no parameters.
	 * @return The newly created command
	 */
	public Close close() {
		return new Close(api);
	}

	/**
	 * Use this method to close an open topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the can_manage_topics administrator rights, unless it is the creator of the topic. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param messageThreadId Unique identifier for the target message thread of the forum topic
	 * @return The newly created command
	 */
	@Deprecated
	public CloseForumTopic closeForumTopic(Integer chatId, Integer messageThreadId) {
		return new CloseForumTopic(api, chatId, messageThreadId);
	}

	/**
	 * Use this method to close an open topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the can_manage_topics administrator rights, unless it is the creator of the topic. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param messageThreadId Unique identifier for the target message thread of the forum topic
	 * @return The newly created command
	 */
	public CloseForumTopic closeForumTopic(Long chatId, Integer messageThreadId) {
		return new CloseForumTopic(api, chatId, messageThreadId);
	}

	/**
	 * Use this method to close an open topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the can_manage_topics administrator rights, unless it is the creator of the topic. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param messageThreadId Unique identifier for the target message thread of the forum topic
	 * @return The newly created command
	 */
	public CloseForumTopic closeForumTopic(String chatId, Integer messageThreadId) {
		return new CloseForumTopic(api, chatId, messageThreadId);
	}

	/**
	 * Use this method to close an open 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @return The newly created command
	 */
	public CloseGeneralForumTopic closeGeneralForumTopic(Long chatId) {
		return new CloseGeneralForumTopic(api, chatId);
	}

	/**
	 * Use this method to close an open 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @return The newly created command
	 */
	public CloseGeneralForumTopic closeGeneralForumTopic(String chatId) {
		return new CloseGeneralForumTopic(api, chatId);
	}

	/**
	 * Use this method to copy messages of any kind. Service messages and invoice messages can't be copied. A quiz poll can be copied only if the value of the field {@link com.pengrad.telegrambot.model.Poll#correct_option_id correct_option_id} is known to the bot. The method is analogous to the method {@link ForwardMessage forwardMessage}, but the copied message doesn't have a link to the original message. Returns the {@link MessageId} of the sent message on success.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param fromChatId Unique identifier for the chat where the original message was sent (or channel username in the format @channel_username)
	 * @param messageId Message identifier in the chat specified in from_chat_id
	 * @return The newly created command
	 */
	public CopyMessage copyMessage(Object chatId, Object fromChatId, int messageId) {
		return new CopyMessage(api, chatId, fromChatId, messageId);
	}

	/**
	 * Use this method to create an additional invite link for a chat. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. The link can be revoked using the method {@link #revokeChatInviteLink}. Returns the new invite link as {@link ChatInviteLink} object.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @return The newly created command
	 */
	public CreateChatInviteLink createChatInviteLink(Object chatId) {
		return new CreateChatInviteLink(api, chatId);
	}

	/**
	 * Use this method to create a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights. Returns information about the created topic as a {@link ForumTopic} object.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param name Topic name, 1-128 characters
	 * @return The newly created command
	 */
	@Deprecated
	public CreateForumTopic createForumTopic(Integer chatId, String name) {
		return new CreateForumTopic(api, chatId, name);
	}

	/**
	 * Use this method to create a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights. Returns information about the created topic as a {@link ForumTopic} object.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param name Topic name, 1-128 characters
	 * @return The newly created command
	 */
	public CreateForumTopic createForumTopic(Long chatId, String name) {
		return new CreateForumTopic(api, chatId, name);
	}

	/**
	 * Use this method to create a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights. Returns information about the created topic as a {@link ForumTopic} object.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param name Topic name, 1-128 characters
	 * @return The newly created command
	 */
	public CreateForumTopic createForumTopic(String chatId, String name) {
		return new CreateForumTopic(api, chatId, name);
	}

	/**
	 * Use this method to create a link for an invoice. Returns the created invoice link as String on success.
	 * @param title Product name, 1-32 characters
	 * @param description Product description, 1-255 characters
	 * @param payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
	 * @param providerToken Payment provider token, obtained via <a href="t.me/botfather">@BotFather</a>
	 * @param currency Three-letter ISO 4217 currency code, see <a href="https://core.telegram.org/bots/payments#supported-currencies">more on currencies</a>
	 * @param prices Price breakdown, a list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.)
	 * @return The newly created command
	 */
	public CreateInvoiceLink createInvoiceLink(String title, String description, String payload, String providerToken, String currency, LabeledPrice... prices) {
		return new CreateInvoiceLink(api, title, description, payload, providerToken, currency, prices);
	}

	/**
	 * Use this method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus created. Returns True on success.
	 * @param userId User identifier of created sticker set owner
	 * @param name Short name of sticker set, to be used in t.me/addstickers/ URLs (e.g., animals). Can contain only English letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores and must end in "_by_bot_username". bot_username is case-insensitive. 1-64 characters.
	 * @param title Sticker set title, 1-64 characters
	 * @param emojis List of 1-20 emoji associated with the sticker
	 * @param tgsSticker The added sticker. Pass a file_id as a String to send a file that already exists on the Telegram servers, upload a new one using multipart/form-data, or pass “attach://file_attach_name” to upload a new one using multipart/form-data under file_attach_name name. Animated and video stickers can't be uploaded via HTTP URL.
	 * @return The newly created command
	 */
	@Deprecated
	public CreateNewStickerSet createNewAnimatedStickerSet(Long userId, String name, String title, String emojis, Object tgsSticker) {
		return CreateNewStickerSet.tgsSticker(api, userId, name, title, emojis, tgsSticker);
	}

	/**
	 * Use this method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus created. Returns True on success.
	 * @param userId User identifier of created sticker set owner
	 * @param name Short name of sticker set, to be used in t.me/addstickers/ URLs (e.g., animals). Can contain only English letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores and must end in "_by_bot_username". bot_username is case-insensitive. 1-64 characters.
	 * @param title Sticker set title, 1-64 characters
	 * @param emojis List of 1-20 emoji associated with the sticker
	 * @param pngSticker The added sticker. Pass a file_id as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, upload a new one using multipart/form-data, or pass “attach://file_attach_name” to upload a new one using multipart/form-data under file_attach_name name.
	 * @return The newly created command
	 */
	@Deprecated
	public CreateNewStickerSet createNewStaticStickerSet(Long userId, String name, String title, String emojis, Object pngSticker) {
		return CreateNewStickerSet.pngSticker(api, userId, name, title, emojis, pngSticker);
	}

	/**
	 * Use this method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus created. Returns True on success.
	 * @param userId User identifier of created sticker set owner
	 * @param name Short name of sticker set, to be used in t.me/addstickers/ URLs (e.g., animals). Can contain only English letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores and must end in "_by_bot_username". bot_username is case-insensitive. 1-64 characters.
	 * @param title Sticker set title, 1-64 characters
	 * @param stickers A list of 1-50 initial stickers to be added to the sticker set
	 * @param stickerFormat Format of stickers in the set, must be one of “static”, “animated”, “video”
	 * @return The newly created command
	 */
	public CreateNewStickerSet createNewStickerSet(Long userId, String name, String title, InputSticker[] stickers, Sticker.Format stickerFormat) {
		return new CreateNewStickerSet(api, userId, name, title, stickers, stickerFormat);
	}

	/**
	 * Use this method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus created. Returns True on success.
	 * @param userId User identifier of created sticker set owner
	 * @param name Short name of sticker set, to be used in t.me/addstickers/ URLs (e.g., animals). Can contain only English letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores and must end in "_by_bot_username". bot_username is case-insensitive. 1-64 characters.
	 * @param title Sticker set title, 1-64 characters
	 * @param pngSticker The added sticker. Pass a file_id as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, upload a new one using multipart/form-data, or pass “attach://file_attach_name” to upload a new one using multipart/form-data under file_attach_name name.
	 * @param emojis List of 1-20 emoji associated with the sticker
	 * @return The newly created command
	 */
	@Deprecated
	public CreateNewStickerSet createNewStickerSet(Long userId, String name, String title, Object pngSticker, String emojis) {
		return new CreateNewStickerSet(api, userId, name, title, pngSticker, emojis);
	}

	/**
	 * Use this method to create a new sticker set owned by a user. The bot will be able to edit the sticker set thus created. Returns True on success.
	 * @param userId User identifier of created sticker set owner
	 * @param name Short name of sticker set, to be used in t.me/addstickers/ URLs (e.g., animals). Can contain only English letters, digits and underscores. Must begin with a letter, can't contain consecutive underscores and must end in "_by_bot_username". bot_username is case-insensitive. 1-64 characters.
	 * @param title Sticker set title, 1-64 characters
	 * @param emojis List of 1-20 emoji associated with the sticker
	 * @param webmSticker The added sticker. Pass a file_id as a String to send a file that already exists on the Telegram servers, upload a new one using multipart/form-data, or pass “attach://file_attach_name” to upload a new one using multipart/form-data under file_attach_name name. Animated and video stickers can't be uploaded via HTTP URL.
	 * @return The newly created command
	 */
	@Deprecated
	public CreateNewStickerSet createNewVideoStickerSet(Long userId, String name, String title, String emojis, Object webmSticker) {
		return CreateNewStickerSet.webmSticker(api, userId, name, title, emojis, webmSticker);
	}

	/**
	 * Use this method to decline a chat join request. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canInviteUsers can_invite_users} administrator right. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param userId Unique identifier of the target user
	 * @return The newly created command
	 */
	public DeclineChatJoinRequest declineChatJoinRequest(Object chatId, long userId) {
		return new DeclineChatJoinRequest(api, chatId, userId);
	}

	/**
	 * Use this method to delete a chat photo. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @return The newly created command
	 */
	public DeleteChatPhoto deleteChatPhoto(Object chatId) {
		return new DeleteChatPhoto(api, chatId);
	}

	/**
	 * Use this method to delete a group sticker set from a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Use the field {@link Chat#canSetStickerSet() can_set_sticker_set } optionally returned in {@link #getChat} requests to check if the bot can use this method. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @return The newly created command
	 */
	public DeleteChatStickerSet deleteChatStickerSet(Object chatId) {
		return new DeleteChatStickerSet(api, chatId);
	}

	/**
	 * Use this method to delete a forum topic along with all its messages in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canDeleteMessages can_delete_messages} administrator rights. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param messageThreadId Unique identifier for the target message thread of the forum topic
	 * @return The newly created command
	 */
	@Deprecated
	public DeleteForumTopic deleteForumTopic(Integer chatId, Integer messageThreadId) {
		return new DeleteForumTopic(api, chatId, messageThreadId);
	}

	/**
	 * Use this method to delete a forum topic along with all its messages in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canDeleteMessages can_delete_messages} administrator rights. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param messageThreadId Unique identifier for the target message thread of the forum topic
	 * @return The newly created command
	 */
	public DeleteForumTopic deleteForumTopic(Long chatId, Integer messageThreadId) {
		return new DeleteForumTopic(api, chatId, messageThreadId);
	}

	/**
	 * Use this method to delete a forum topic along with all its messages in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canDeleteMessages can_delete_messages} administrator rights. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param messageThreadId Unique identifier for the target message thread of the forum topic
	 * @return The newly created command
	 */
	public DeleteForumTopic deleteForumTopic(String chatId, Integer messageThreadId) {
		return new DeleteForumTopic(api, chatId, messageThreadId);
	}

	/**
	 * Use this method to delete a message, including service messages, with the following limitations:<br>
	 * - A message can only be deleted if it was sent less than 48 hours ago.<br>
	 * - Service messages about a supergroup, channel, or forum topic creation can't be deleted.<br>
	 * - A dice message in a private chat can only be deleted if it was sent more than 24 hours ago.<br>
	 * - Bots can delete outgoing messages in private chats, groups, and supergroups.<br>
	 * - Bots can delete incoming messages in private chats.<br>
	 * - Bots granted {@link PromoteChatMember#canPostMessages can_post_messages} permissions can delete outgoing messages in channels.<br>
	 * - If the bot is an administrator of a group, it can delete any message there.<br>
	 * - If the bot has {@link PromoteChatMember#canDeleteMessages can_delete_messages} permission in a supergroup or a channel, it can delete any message there.<br>
	 * Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param messageId Identifier of the message to delete
	 * @return The newly created command
	 */
	public DeleteMessage deleteMessage(Object chatId, int messageId) {
		return new DeleteMessage(api, chatId, messageId);
	}

	/**
	 * Use this method to delete the list of the bot's commands for the given scope and user language. After deletion, higher level commands will be shown to affected users. Returns True on success.
	 * @return The newly created command
	 */
	public DeleteMyCommands deleteMyCommands() {
		return new DeleteMyCommands(api);
	}

	/**
	 * Use this method to delete a sticker from a set created by the bot. Returns True on success.
	 * @param sticker File identifier of the sticker
	 * @return The newly created command
	 */
	public DeleteStickerFromSet deleteStickerFromSet(String sticker) {
		return new DeleteStickerFromSet(api, sticker);
	}

	/**
	 * Use this method to delete a sticker set that was created by the bot. Returns True on success.
	 * @param name Sticker set name
	 * @return The newly created command
	 */
	public DeleteStickerSet deleteStickerSet(String name) {
		return new DeleteStickerSet(api, name);
	}

	/**
	 * Use this method to remove webhook integration if you decide to switch back to {@link #getUpdates}. Returns True on success.
	 * @return The newly created command
	 */
	public DeleteWebhook deleteWebhook() {
		return new DeleteWebhook(api);
	}

	/**
	 * Use this method to edit a non-primary invite link created by the bot. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the edited invite link as a {@link ChatInviteLink} object.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param inviteLink The invite link to edit
	 * @return The newly created command
	 */
	public  EditChatInviteLink editChatInviteLink(Object chatId, String inviteLink) {
		return new EditChatInviteLink(api, chatId, inviteLink);
	}

	/**
	 * Use this method to edit name and icon of a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights, unless it is the creator of the topic. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param messageThreadId Unique identifier for the target message thread of the forum topic
	 * @return The newly created command
	 */
	@Deprecated
	public EditForumTopic editForumTopic(Integer chatId, Integer messageThreadId) {
		return new EditForumTopic(api, chatId, messageThreadId);
	}

	/**
	 * Use this method to edit name and icon of a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights, unless it is the creator of the topic. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param messageThreadId Unique identifier for the target message thread of the forum topic
	 * @return The newly created command
	 */
	public EditForumTopic editForumTopic(Long chatId, Integer messageThreadId) {
		return new EditForumTopic(api, chatId, messageThreadId);
	}

	/**
	 * Use this method to edit name and icon of a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights, unless it is the creator of the topic. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param messageThreadId Unique identifier for the target message thread of the forum topic
	 * @return The newly created command
	 */
	public EditForumTopic editForumTopic(String chatId, Integer messageThreadId) {
		return new EditForumTopic(api, chatId, messageThreadId);
	}

	/**
	 * Use this method to edit name and icon of a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights, unless it is the creator of the topic. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param messageThreadId Unique identifier for the target message thread of the forum topic
	 * @param name Topic name, 1-128 characters
	 * @param iconCustomEmojiId Unique identifier of the custom emoji shown as the topic icon. Use {@link #getForumTopicIconStickers} to get all allowed custom emoji identifiers.
	 * @return The newly created command
	 */
	@Deprecated
	public EditForumTopic editForumTopic(Integer chatId, Integer messageThreadId, String name, String iconCustomEmojiId) {
		return new EditForumTopic(api, chatId, messageThreadId, name, iconCustomEmojiId);
	}

	/**
	 * Use this method to edit name and icon of a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights, unless it is the creator of the topic. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param messageThreadId Unique identifier for the target message thread of the forum topic
	 * @param name Topic name, 1-128 characters
	 * @param iconCustomEmojiId Unique identifier of the custom emoji shown as the topic icon. Use {@link #getForumTopicIconStickers} to get all allowed custom emoji identifiers.
	 * @return The newly created command
	 */
	public EditForumTopic editForumTopic(Long chatId, Integer messageThreadId, String name, String iconCustomEmojiId) {
		return new EditForumTopic(api, chatId, messageThreadId, name, iconCustomEmojiId);
	}

	/**
	 * Use this method to edit name and icon of a topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights, unless it is the creator of the topic. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param messageThreadId Unique identifier for the target message thread of the forum topic
	 * @param name Topic name, 1-128 characters
	 * @param iconCustomEmojiId Unique identifier of the custom emoji shown as the topic icon. Use {@link #getForumTopicIconStickers} to get all allowed custom emoji identifiers.
	 * @return The newly created command
	 */
	public EditForumTopic editForumTopic(String chatId, Integer messageThreadId, String name, String iconCustomEmojiId) {
		return new EditForumTopic(api, chatId, messageThreadId, name, iconCustomEmojiId);
	}

	/**
	 * Use this method to edit the name of the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param name New topic name, 1-128 characters
	 * @return The newly created command
	 */
	public EditGeneralForumTopic editGeneralForumTopic(Long chatId, String name) {
		return new EditGeneralForumTopic(api, chatId, name);
	}

	/**
	 * Use this method to edit the name of the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param name New topic name, 1-128 characters
	 * @return The newly created command
	 */
	public EditGeneralForumTopic editGeneralForumTopic(String chatId, String name) {
		return new EditGeneralForumTopic(api, chatId, name);
	}

	/**
	 * Use this method to edit captions of messages. On success, if the edited message is not an inline message, the edited {@link Message} is returned, otherwise True is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param messageId Identifier of the message to edit
	 * @return The newly created command
	 */
	public EditMessageCaption editMessageCaption(Object chatId, int messageId) {
		return new EditMessageCaption(api, chatId, messageId);
	}

	/**
	 * Use this method to edit captions of messages. On success, if the edited message is not an inline message, the edited {@link Message} is returned, otherwise True is returned.
	 * @param inlineMessageId Identifier of the inline message
	 * @return The newly created command
	 */
	public EditMessageCaption editMessageCaption(String inlineMessageId) {
		return new EditMessageCaption(api, inlineMessageId);
	}

	/**
	 * Use this method to edit live location messages. A location can be edited until its {@link Location#livePeriod live_period} expires or editing is explicitly disabled by a call to {@link #stopMessageLiveLocation}. On success, if the edited message is not an inline message, the edited {@link Message} is returned, otherwise True is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param messageId Identifier of the message to edit
	 * @param latitude Latitude of new location
	 * @param longitude Longitude of new location
	 * @return The newly created command
	 */
	public EditMessageLiveLocation editMessageLiveLocation(Object chatId, int messageId, float latitude, float longitude) {
		return new EditMessageLiveLocation(api, chatId, messageId, latitude, longitude);
	}

	/**
	 * Use this method to edit live location messages. A location can be edited until its {@link Location#livePeriod live_period} expires or editing is explicitly disabled by a call to {@link #stopMessageLiveLocation}. On success, if the edited message is not an inline message, the edited {@link Message} is returned, otherwise True is returned.
	 * @param inlineMessageId Identifier of the inline message
	 * @param latitude Latitude of new location
	 * @param longitude Longitude of new location
	 * @return The newly created command
	 */
	public EditMessageLiveLocation editMessageLiveLocation(String inlineMessageId, float latitude, float longitude) {
		return new EditMessageLiveLocation(api, inlineMessageId, latitude, longitude);
	}

	/**
	 * Use this method to edit {@link InputMediaAnimation animation}, {@link InputMediaAudio audio}, {@link InputMediaDocument document}, {@link InputMediaPhoto photo}, or {@link InputMediaVideo video} messages. If a message is part of a message album, then it can be edited only to an audio for audio albums, only to a document for document albums and to a photo or a video otherwise. When an inline message is edited, a new file can't be uploaded; use a previously uploaded file via its file_id or specify a URL. On success, if the edited message is not an inline message, the edited {@link Message} is returned, otherwise True is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param messageId Identifier of the message to edit
	 * @param media An object for a new media content of the message
	 * @return The newly created command
	 */
	public EditMessageMedia editMessageMedia(Object chatId, int messageId, InputMedia<?> media) {
		return new EditMessageMedia(api, chatId, messageId, media);
	}

	/**
	 * Use this method to edit {@link InputMediaAnimation animation}, {@link InputMediaAudio audio}, {@link InputMediaDocument document}, {@link InputMediaPhoto photo}, or {@link InputMediaVideo video} messages. If a message is part of a message album, then it can be edited only to an audio for audio albums, only to a document for document albums and to a photo or a video otherwise. When an inline message is edited, a new file can't be uploaded; use a previously uploaded file via its file_id or specify a URL. On success, if the edited message is not an inline message, the edited {@link Message} is returned, otherwise True is returned.
	 * @param inlineMessageId Identifier of the inline message
	 * @param media An object for a new media content of the message
	 * @return The newly created command
	 */
	public EditMessageMedia editMessageMedia(String inlineMessageId, InputMedia<?> media) {
		return new EditMessageMedia(api, inlineMessageId, media);
	}

	/**
	 * Use this method to edit only the reply markup of messages. On success, if the edited message is not an inline message, the edited {@link Message} is returned, otherwise True is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param messageId Identifier of the message to edit
	 * @return The newly created command
	 */
	public EditMessageReplyMarkup editMessageReplyMarkup(Object chatId, int messageId) {
		return new EditMessageReplyMarkup(api, chatId, messageId);
	}

	/**
	 * Use this method to edit only the reply markup of messages. On success, if the edited message is not an inline message, the edited {@link Message} is returned, otherwise True is returned.
	 * @param inlineMessageId Identifier of the inline message
	 * @return The newly created command
	 */
	public EditMessageReplyMarkup editMessageReplyMarkup(String inlineMessageId) {
		return new EditMessageReplyMarkup(api, inlineMessageId);
	}

	/**
	 * Use this method to edit text and game messages. On success, if the edited message is not an inline message, the edited Message is returned, otherwise True is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param messageId Identifier of the message to edit
	 * @param text New text of the message, 1-4096 characters after entities parsing
	 * @return The newly created command
	 */
	public EditMessageText editMessageText(Object chatId, int messageId, String text) {
		return new EditMessageText(api, chatId, messageId, text);
	}

	/**
	 * Use this method to edit text and game messages. On success, if the edited message is not an inline message, the edited Message is returned, otherwise True is returned.
	 * @param inlineMessageId Identifier of the inline message
	 * @param text New text of the message, 1-4096 characters after entities parsing
	 * @return The newly created command
	 */
	public EditMessageText editMessageText(String inlineMessageId, String text) {
		return new EditMessageText(api, inlineMessageId, text);
	}

	/**
	 * Use this method to generate a new primary invite link for a chat; any previously generated primary link is revoked. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the new invite link as String on success.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @return The newly created command
	 */
	public ExportChatInviteLink exportChatInviteLink(Object chatId) {
		return new ExportChatInviteLink(api, chatId);
	}

	/**
	 * Use this method to forward messages of any kind. Service messages can't be forwarded. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param fromChatId Unique identifier for the chat where the original message was sent (or channel username in the format @channel_username)
	 * @param messageId Message identifier in the chat specified in from_chat_id
	 * @return The newly created command
	 */
	public ForwardMessage forwardMessage(Object chatId, Object fromChatId, int messageId) {
		return new ForwardMessage(api, chatId, fromChatId, messageId);
	}

	/**
	 * Use this method to get up-to-date information about the chat (current name of the user for one-on-one conversations, current username of a user, group or channel, etc.). Returns a {@link Chat} object on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format @channel_username)
	 * @return The newly created command
	 */
	public GetChat getChat(Object chatId) {
		return new GetChat(api, chatId);
	}

	/**
	 * Use this method to get a list of administrators in a chat, which aren't bots. Returns an Array of {@link ChatMember} objects.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format @channel_username)
	 * @return The newly created command
	 */
	public GetChatAdministrators getChatAdministrators(Object chatId) {
		return new GetChatAdministrators(api, chatId);
	}

	/**
	 * Use this method to get information about a member of a chat. The method is only guaranteed to work for other users if the bot is an administrator in the chat. Returns a {@link ChatMember} object on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format @channel|_username)
	 * @param userId Unique identifier of the target user
	 * @return The newly created command
	 */
	public GetChatMember getChatMember(Object chatId, long userId) {
		return new GetChatMember(api, chatId, userId);
	}

	/**
	 * Use this method to get the number of members in a chat. Returns int on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format @channel_username)
	 * @return The newly created command
	 */
	public GetChatMemberCount getChatMemberCount(Object chatId) {
		return new GetChatMemberCount(api, chatId);
	}

	/**
	 * Use this method to get the number of members in a chat. Returns int on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format @channel_username)
	 * @return The newly created command
	 */
	@Deprecated
	public GetChatMembersCount getChatMembersCount(Object chatId) {
		return new GetChatMembersCount(api, chatId);
	}

	/**
	 * Use this method to get the current value of the bot's menu button in a private chat, or the default menu button. Returns {@link MenuButton} on success.
	 * @return The newly created command
	 */
	public GetChatMenuButton getChatMenuButton() {
		return new GetChatMenuButton(api);
	}

	/**
	 * Use this method to get information about custom emoji stickers by their identifiers. Returns an Array of {@link Sticker} objects.
	 * @param customEmojiIds List of custom emoji identifiers. At most 200 custom emoji identifiers can be specified.
	 * @return The newly created command
	 */
	public GetCustomEmojiStickers getCustomEmojiStickers(String... customEmojiIds) {
		return new GetCustomEmojiStickers(api, customEmojiIds);
	}

	/**
	 * Use this method to get basic information about a file and prepare it for downloading. For the moment, bots can download files of up to 20MB in size. On success, a {@link File} object is returned. The file can then be downloaded via the link {@code https://api.telegram.org/file/bot{token}/file_path}, where file_path is taken from the response. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling {@code getFile} again.
	 * @param fileId File identifier to get information about
	 * @return The newly created command
	 */
	public GetFile getFile(String fileId) {
		return new GetFile(api, fileId);
	}

	/**
	 * Use this method to get custom emoji stickers, which can be used as a forum topic icon by any user. Requires no parameters. Returns an Array of {@link Sticker} objects.
	 * @return The newly created command
	 */
	public GetForumTopicIconStickers getForumTopicIconStickers() {
		return new GetForumTopicIconStickers(api);
	}

	/**
	 * Use this method to get data for high score tables. Will return the score of the specified user and several of their neighbors in a game. Returns an Array of GameHighScore objects.
	 * <br><br>
	 * This method will currently return scores for the target user, plus two of their closest neighbors on each side. Will also return the top three users if the user and their neighbors are not among them. Please note that this behavior is subject to change.
	 * @param userId Target user id
	 * @param inlineMessageId Identifier of the inline message
	 * @return The newly created command
	 */
	public GetGameHighScores getGameHighScores(long userId, String inlineMessageId) {
		return new GetGameHighScores(api, userId, inlineMessageId);
	}

	/**
	 * Use this method to get data for high score tables. Will return the score of the specified user and several of their neighbors in a game. Returns an Array of GameHighScore objects.
	 * <br><br>
	 * This method will currently return scores for the target user, plus two of their closest neighbors on each side. Will also return the top three users if the user and their neighbors are not among them. Please note that this behavior is subject to change.
	 * @param userId Target user id
	 * @param chatId Unique identifier for the target chat
	 * @param messageId Identifier of the sent message
	 * @return The newly created command
	 */
	public GetGameHighScores getGameHighScores(long userId, Object chatId, int messageId) {
		return new GetGameHighScores(api, userId, chatId, messageId);
	}

	/**
	 * A simple method for testing your bot's authentication token. Requires no parameters. Returns basic information about the bot in form of a {@link User} object.
	 * @return The newly created command
	 */
	public GetMe getMe() {
		return new GetMe(api);
	}

	/**
	 * Use this method to get the current list of the bot's commands for the given scope and user language. Returns an Array of {@link BotCommand} objects. If commands aren't set, an empty list is returned.
	 * @return The newly created command
	 */
	public GetMyCommands getMyCommands() {
		return new GetMyCommands(api);
	}

	/**
	 * Use this method to get the current default administrator rights of the bot. Returns {@link ChatAdministratorRights} on success.
	 * @return The newly created command
	 */
	public GetMyDefaultAdministratorRights getMyDefaultAdministratorRights() {
		return new GetMyDefaultAdministratorRights(api);
	}

	/**
	 * Use this method to get the current bot description for the given user language. Returns {@link BotDescription} on success.
	 * @return The newly created command
	 */
	public GetMyDescription getMyDescription() {
		return new GetMyDescription(api);
	}

	/**
	 * Use this method to get the current bot name for the given user language. Returns {@link BotName} on success.
	 * @return The newly created command
	 */
	public GetMyName getMyName() {
		return new GetMyName(api);
	}

	/**
	 * Use this method to get the current bot short description for the given user language. Returns {@link BotShortDescription} on success.
	 * @return The newly created command
	 */
	public GetMyShortDescription getMyShortDescription() {
		return new GetMyShortDescription(api);
	}

	/**
	 * Use this method to get a sticker set. On success, a {@link StickerSet} object is returned.
	 * @param name Name of the sticker set
	 * @return The newly created command
	 */
	public GetStickerSet getStickerSet(String name) {
		return new GetStickerSet(api, name);
	}

	/**
	 * Use this method to receive incoming updates using long polling (<a href="https://en.wikipedia.org/wiki/Push_technology#Long_polling">wiki</a>). Returns an Array of {@link Update} objects.
	 * @return The newly created command
	 */
	public GetUpdates getUpdates() {
		return new GetUpdates(api);
	}

	/**
	 * Use this method to get a list of profile pictures for a user. Returns a {@link UserProfilePhotos} object.
	 * @param userId Unique identifier of the target user
	 * @return The newly created command
	 */
	public GetUserProfilePhotos getUserProfilePhotos(long userId) {
		return new GetUserProfilePhotos(api, userId);
	}

	/**
	 * Use this method to get current webhook status. Requires no parameters. On success, returns a {@link WebhookInfo} object. If the bot is using {@link #getUpdates}, will return an object with the url field empty.
	 * @return The newly created command
	 */
	public GetWebhookInfo getWebhookInfo() {
		return new GetWebhookInfo(api);
	}

	/**
	 * Use this method to hide the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights. The topic will be automatically closed if it was open. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @return The newly created command
	 */
	public HideGeneralForumTopic hideGeneralForumTopic(Long chatId) {
		return new HideGeneralForumTopic(api, chatId);
	}

	/**
	 * Use this method to hide the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights. The topic will be automatically closed if it was open. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @return The newly created command
	 */
	public HideGeneralForumTopic hideGeneralForumTopic(String chatId) {
		return new HideGeneralForumTopic(api, chatId);
	}

	/**
	 * Use this method to kick a user from a group, a supergroup or a channel. In the case of supergroups and channels, the user will not be able to return to the chat on their own using invite links, etc., unless {@link UnbanChatMember unbanned} first. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns True on success.
	 * @deprecated since BOT API v5.3 you should use {@link #banChatMember} instead.
	 * @param chatId Unique identifier for the target group or username of the target supergroup or channel (in the format @channel_username)
	 * @param userId Unique identifier of the target user
	 * @return The newly created command
	 */
	@Deprecated
	public KickChatMember kickChatMember(Object chatId, Long userId) {
		return new KickChatMember(api, chatId, userId);
	}

	/**
	 * Use this method for your bot to leave a group, supergroup or channel. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup or channel (in the format @channel_username)
	 * @return The newly created command
	 */
	public LeaveChat leaveChat(Object chatId) {
		return new LeaveChat(api, chatId);
	}

	/**
	 * Use this method to log out from the cloud Bot API server before launching the bot locally. You must log out the bot before running it locally, otherwise there is no guarantee that the bot will receive updates. After a successful call, you can immediately log in on a local server, but will not be able to log in back to the cloud Bot API server for 10 minutes. Returns True on success. Requires no parameters.
	 * @return The newly created command
	 */
	public LogOut logOut() {
		return new LogOut(api);
	}

	/**
	 * Use this method to add a message to the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canPinMessages can_pin_messages} administrator right in a supergroup or {@link PromoteChatMember#canEditMessages can_edit_messages} administrator right in a channel. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param messageId Identifier of a message to pin
	 * @return The newly created command
	 */
	public PinChatMessage pinChatMessage(Object chatId, int messageId) {
		return new PinChatMessage(api, chatId, messageId);
	}

	/**
	 * Use this method to promote or demote a user in a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Pass False for all boolean parameters to demote a user. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param userId Unique identifier of the target user
	 * @return The newly created command
	 */
	public PromoteChatMember promoteChatMember(Object chatId, long userId) {
		return new PromoteChatMember(api, chatId, userId);
	}

	/**
	 * Use this method to reopen a closed topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights, unless it is the creator of the topic. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param messageThreadId Unique identifier for the target message thread of the forum topic
	 * @return The newly created command
	 */
	@Deprecated
	public ReopenForumTopic reopenForumTopic(Integer chatId, Integer messageThreadId) {
		return new ReopenForumTopic(api, chatId, messageThreadId);
	}

	/**
	 * Use this method to reopen a closed topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights, unless it is the creator of the topic. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param messageThreadId Unique identifier for the target message thread of the forum topic
	 * @return The newly created command
	 */
	public ReopenForumTopic reopenForumTopic(Long chatId, Integer messageThreadId) {
		return new ReopenForumTopic(api, chatId, messageThreadId);
	}

	/**
	 * Use this method to reopen a closed topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights, unless it is the creator of the topic. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param messageThreadId Unique identifier for the target message thread of the forum topic
	 * @return The newly created command
	 */
	public ReopenForumTopic reopenForumTopic(String chatId, Integer messageThreadId) {
		return new ReopenForumTopic(api, chatId, messageThreadId);
	}

	/**
	 * Use this method to reopen a closed 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights. The topic will be automatically unhidden if it was hidden. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @return The newly created command
	 */
	public ReopenGeneralForumTopic reopenGeneralForumTopic(Long chatId) {
		return new ReopenGeneralForumTopic(api, chatId);
	}

	/**
	 * Use this method to reopen a closed 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights. The topic will be automatically unhidden if it was hidden. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @return The newly created command
	 */
	public ReopenGeneralForumTopic reopenGeneralForumTopic(String chatId) {
		return new ReopenGeneralForumTopic(api, chatId);
	}

	/**
	 * Use this method to restrict a user in a supergroup. The bot must be an administrator in the supergroup for this to work and must have the appropriate administrator rights. Pass True for all permissions to lift restrictions from a user. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param userId Unique identifier of the target user
	 * @param permissions An object for new user permissions
	 * @return The newly created command
	 */
	public RestrictChatMember restrictChatMember(Object chatId, long userId, ChatPermissions permissions) {
		return new RestrictChatMember(api, chatId, userId, permissions);
	}

	/**
	 * Use this method to revoke an invite_link created by the bot. If the primary link is revoked, a new link is automatically generated. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns the revoked invite link as {@link ChatInviteLink} object.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param inviteLink The invite link to edit
	 * @return The newly created command
	 */
	public RevokeChatInviteLink revokeChatInviteLink(Object chatId, String inviteLink) {
		return new RevokeChatInviteLink(api, chatId, inviteLink);
	}

	/**
	 * Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound). On success, the sent {@link Message} is returned. Bots can currently send animation files of up to 50 MB in size, this limit may be changed in the future.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param animation Animation to send. Pass a file_id as String to send an animation that exists on the Telegram servers (recommended), or pass an HTTP URL as a String for Telegram to get an animation from the Internet.
	 * @return The newly created command
	 */
	public SendAnimation sendAnimation(Object chatId, String animation) {
		return new SendAnimation(api, chatId, animation);
	}

	/**
	 * Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound). On success, the sent {@link Message} is returned. Bots can currently send animation files of up to 50 MB in size, this limit may be changed in the future.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param animation Animation to send. Upload a new animation using multipart/form-data.
	 * @return The newly created command
	 */
	public SendAnimation sendAnimation(Object chatId, java.io.File animation) {
		return new SendAnimation(api, chatId, animation);
	}

	/**
	 * Use this method to send animation files (GIF or H.264/MPEG-4 AVC video without sound). On success, the sent {@link Message} is returned. Bots can currently send animation files of up to 50 MB in size, this limit may be changed in the future.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param animation Animation to send. Upload a new animation using multipart/form-data.
	 * @return The newly created command
	 */
	public SendAnimation sendAnimation(Object chatId, byte[] animation) {
		return new SendAnimation(api, chatId, animation);
	}

	/**
	 * Use this method to send audio files, if you want Telegram clients to display them in the music player. Your audio must be in the .MP3 or .M4A format. On success, the sent {@link Message} is returned. Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.
	 * <br><br>
	 * For sending voice messages, use the {@link SendVoice} method instead.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param audio Audio file to send. Pass a file_id as String to send an audio file that exists on the Telegram servers (recommended), or pass an HTTP URL as a String for Telegram to get an audio file from the Internet.
	 * @return The newly created command
	 */
	public SendAudio sendAudio(Object chatId, String audio) {
		return new SendAudio(api, chatId, audio);
	}

	/**
	 * Use this method to send audio files, if you want Telegram clients to display them in the music player. Your audio must be in the .MP3 or .M4A format. On success, the sent {@link Message} is returned. Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.
	 * <br><br>
	 * For sending voice messages, use the {@link SendVoice} method instead.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param audio Audio file to send. Upload a new one using multipart/form-data.
	 * @return The newly created command
	 */
	public SendAudio sendAudio(Object chatId, java.io.File audio) {
		return new SendAudio(api, chatId, audio);
	}

	/**
	 * Use this method to send audio files, if you want Telegram clients to display them in the music player. Your audio must be in the .MP3 or .M4A format. On success, the sent {@link Message} is returned. Bots can currently send audio files of up to 50 MB in size, this limit may be changed in the future.
	 * <br><br>
	 * For sending voice messages, use the {@link SendVoice} method instead.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param audio Audio file to send. Upload a new one using multipart/form-data.
	 * @return The newly created command
	 */
	public SendAudio sendAudio(Object chatId, byte[] audio) {
		return new SendAudio(api, chatId, audio);
	}

	/**
	 * Use this method when you need to tell the user that something is happening on the bot's side. The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status). Returns True on success.
	 * <br><br>
	 * We only recommend using this method when a response from the bot will take a noticeable amount of time to arrive.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param action Type of action to broadcast. Choose one, depending on what the user is about to receive: <i>typing</i> for {@link SendMessage text messages}, <i>upload_photo</i> for {@link SendPhoto photos}, <i>record_video</i> or <i>upload_video</i> for {@link SendVideo videos}, <i>record_voice</i> or <i>upload_voice</i> for {@link SendVoice voice notes}, <i>upload_document</i> for {@link SendDocument general files}, <i>choose_sticker</i> for {@link SendSticker stickers}, <i>find_location</i> for {@link SendLocation location data}, <i>record_video_note</i> or <i>upload_video_note</i> for {@link SendVideoNote video notes}.
	 * @return The newly created command
	 */
	public SendChatAction sendChatAction(Object chatId, String action) {
		return new SendChatAction(api, chatId, action);
	}

	/**
	 * Use this method when you need to tell the user that something is happening on the bot's side. The status is set for 5 seconds or less (when a message arrives from your bot, Telegram clients clear its typing status). Returns True on success.
	 * <br><br>
	 * We only recommend using this method when a response from the bot will take a noticeable amount of time to arrive.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param action Type of action to broadcast. Choose one, depending on what the user is about to receive: <i>typing</i> for {@link SendMessage text messages}, <i>upload_photo</i> for {@link SendPhoto photos}, <i>record_video</i> or <i>upload_video</i> for {@link SendVideo videos}, <i>record_voice</i> or <i>upload_voice</i> for {@link SendVoice voice notes}, <i>upload_document</i> for {@link SendDocument general files}, <i>choose_sticker</i> for {@link SendSticker stickers}, <i>find_location</i> for {@link SendLocation location data}, <i>record_video_note</i> or <i>upload_video_note</i> for {@link SendVideoNote video notes}.
	 * @return The newly created command
	 */
	public SendChatAction sendChatAction(Object chatId, ChatAction action) {
		return new SendChatAction(api, chatId, action);
	}

	/**
	 * Use this method to send phone contacts. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param phoneNumber Contact's phone number
	 * @param firstName Contact's first name
	 * @return The newly created command
	 */
	public SendContact sendContact(Object chatId, String phoneNumber, String firstName) {
		return new SendContact(api, chatId, phoneNumber, firstName);
	}

	/**
	 * Use this method to send an animated emoji that will display a random value. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @return The newly created command
	 */
	public SendDice sendDice(Object chatId) {
		return new SendDice(api, chatId);
	}

	/**
	 * Use this method to send general files. On success, the sent {@link Message} is returned. Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param document File to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), or pass an HTTP URL as a String for Telegram to get a file from the Internet.
	 * @return The newly created command
	 */
	public SendDocument sendDocument(Object chatId, String document) {
		return new SendDocument(api, chatId, document);
	}

	/**
	 * Use this method to send general files. On success, the sent {@link Message} is returned. Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param document File to send. Upload a new one using multipart/form-data.
	 * @return The newly created command
	 */
	public SendDocument sendDocument(Object chatId, java.io.File document) {
		return new SendDocument(api, chatId, document);
	}

	/**
	 * Use this method to send general files. On success, the sent {@link Message} is returned. Bots can currently send files of any type of up to 50 MB in size, this limit may be changed in the future.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param document File to send. Upload a new one using multipart/form-data.
	 * @return The newly created command
	 */
	public SendDocument sendDocument(Object chatId, byte[] document) {
		return new SendDocument(api, chatId, document);
	}

	/**
	 * Use this method to send a game. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat
	 * @param gameShortName Short name of the game, serves as the unique identifier for the game. Set up your games via <a href="t.me/botfather">@BotFather</a>.
	 * @return The newly created command
	 */
	public SendGame sendGame(Object chatId, String gameShortName) {
		return new SendGame(api, chatId, gameShortName);
	}

	/**
	 * Use this method to send invoices. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param title Product name, 1-32 characters
	 * @param description Product description, 1-255 characters
	 * @param payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
	 * @param providerToken Payment provider token, obtained via <a href="t.me/botfather">@BotFather</a>
	 * @param currency Three-letter ISO 4217 currency code, see <a href="https://core.telegram.org/bots/payments#supported-currencies">more on currencies</a>
	 * @param prices Price breakdown, a list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.)
	 * @return The newly created command
	 */
	public SendInvoice sendInvoice(Long chatId, String title, String description, String payload, String providerToken, String currency, LabeledPrice... prices) {
		return new SendInvoice(api, chatId, title, description, payload, providerToken, currency, prices);
	}

	/**
	 * Use this method to send invoices. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param title Product name, 1-32 characters
	 * @param description Product description, 1-255 characters
	 * @param payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user, use for your internal processes.
	 * @param providerToken Payment provider token, obtained via <a href="t.me/botfather">@BotFather</a>
	 * @param startParameter Unique deep-linking parameter. If left empty, forwarded copies of the sent message will have a Pay button, allowing multiple users to pay directly from the forwarded message, using the same invoice. If non-empty, forwarded copies of the sent message will have a URL button with a deep link to the bot (instead of a Pay button), with the value used as the start parameter
	 * @param currency Three-letter ISO 4217 currency code, see <a href="https://core.telegram.org/bots/payments#supported-currencies">more on currencies</a>
	 * @param prices Price breakdown, a list of components (e.g. product price, tax, discount, delivery cost, delivery tax, bonus, etc.)
	 * @return The newly created command
	 */
	public SendInvoice sendInvoice(Long chatId, String title, String description, String payload, String providerToken, String startParameter, String currency, LabeledPrice... prices) {
		return new SendInvoice(api, chatId, title, description, payload, providerToken, startParameter, currency, prices);
	}

	/**
	 * Use this method to send point on the map. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param latitude Latitude of the location
	 * @param longitude Longitude of the location
	 * @return The newly created command
	 */
	public SendLocation sendLocation(Object chatId, float latitude, float longitude) {
		return new SendLocation(api, chatId, latitude, longitude);
	}

	/**
	 * Use this method to send a group of photos, videos, documents or audios as an album. Documents and audio files can be only grouped in an album with messages of the same type. On success, an array of {@link Message Messages} that were sent is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param media An array describing messages to be sent, must include 2-10 items
	 * @return The newly created command
	 */
	public SendMediaGroup sendMediaGroup(Object chatId, InputMedia<?>... media) {
		return new SendMediaGroup(api, chatId, media);
	}

	/**
	 * Use this method to send text messages. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param text Text of the message to be sent, 1-4096 characters after entities parsing
	 * @return The newly created command
	 */
	public SendMessage sendMessage(Object chatId, String text) {
		return new SendMessage(api, chatId, text);
	}

	/**
	 * Use this method to send photos. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param photo Photo to send. Pass a file_id as String to send a photo that exists on the Telegram servers (recommended), or pass an HTTP URL as a String for Telegram to get a photo from the Internet. The photo must be at most 10 MB in size. The photo's width and height must not exceed 10000 in total. Width and height ratio must be at most 20.
	 * @return The newly created command
	 */
	public SendPhoto sendPhoto(Object chatId, String photo) {
		return new SendPhoto(api, chatId, photo);
	}

	/**
	 * Use this method to send photos. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param photo Photo to send. Upload a new photo using multipart/form-data. The photo must be at most 10 MB in size. The photo's width and height must not exceed 10000 in total. Width and height ratio must be at most 20.
	 * @return The newly created command
	 */
	public SendPhoto sendPhoto(Object chatId, java.io.File photo) {
		return new SendPhoto(api, chatId, photo);
	}

	/**
	 * Use this method to send photos. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param photo Photo to send. Upload a new photo using multipart/form-data. The photo must be at most 10 MB in size. The photo's width and height must not exceed 10000 in total. Width and height ratio must be at most 20.
	 * @return The newly created command
	 */
	public SendPhoto sendPhoto(Object chatId, byte[] photo) {
		return new SendPhoto(api, chatId, photo);
	}

	/**
	 * Use this method to send a native poll. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param question Poll question, 1-300 characters
	 * @param options A list of answer options, 2-10 strings 1-100 characters each
	 * @return The newly created command
	 */
	public SendPoll sendPoll(Object chatId, String question, String... options) {
		return new SendPoll(api, chatId, question, options);
	}

	/**
	 * Use this method to send static .WEBP, animated .TGS, or video .WEBM stickers. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param sticker Sticker to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), or pass an HTTP URL as a String for Telegram to get a .WEBP sticker from the Internet. Video stickers can only be sent by a file_id. Animated stickers can't be sent via an HTTP URL.
	 * @return The newly created command
	 */
	public SendSticker sendSticker(Object chatId, String sticker) {
		return new SendSticker(api, chatId, sticker);
	}

	/**
	 * Use this method to send static .WEBP, animated .TGS, or video .WEBM stickers. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param sticker Sticker to send. Upload a new .WEBP or .TGS sticker using multipart/form-data. Video stickers can only be sent by a file_id. Animated stickers can't be sent via an HTTP URL.
	 * @return The newly created command
	 */
	public SendSticker sendSticker(Object chatId, java.io.File sticker) {
		return new SendSticker(api, chatId, sticker);
	}

	/**
	 * Use this method to send static .WEBP, animated .TGS, or video .WEBM stickers. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param sticker Sticker to send. Upload a new .WEBP or .TGS sticker using multipart/form-data. Video stickers can only be sent by a file_id. Animated stickers can't be sent via an HTTP URL.
	 * @return The newly created command
	 */
	public SendSticker sendSticker(Object chatId, byte[] sticker) {
		return new SendSticker(api, chatId, sticker);
	}

	/**
	 * Use this method to send information about a venue. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param latitude Latitude of the venue
	 * @param longitude Longitude of the venue
	 * @param title Name of the venue
	 * @param address Address of the venue
	 * @return The newly created command
	 */
	public SendVenue sendVenue(Object chatId, float latitude, float longitude, String title, String address) {
		return new SendVenue(api, chatId, latitude, longitude, title, address);
	}

	/**
	 * Use this method to send video files, Telegram clients support MPEG4 videos (other formats may be sent as {@link Document}). On success, the sent {@link Message} is returned. Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param video Video to send. Pass a file_id as String to send a video that exists on the Telegram servers (recommended), or pass an HTTP URL as a String for Telegram to get a video from the Internet.
	 * @return The newly created command
	 */
	public SendVideo sendVideo(Object chatId, String video) {
		return new SendVideo(api, chatId, video);
	}

	/**
	 * Use this method to send video files, Telegram clients support MPEG4 videos (other formats may be sent as {@link Document}). On success, the sent {@link Message} is returned. Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param video Video to send. Upload a new video using multipart/form-data.
	 * @return The newly created command
	 */
	public SendVideo sendVideo(Object chatId, java.io.File video) {
		return new SendVideo(api, chatId, video);
	}

	/**
	 * Use this method to send video files, Telegram clients support MPEG4 videos (other formats may be sent as {@link Document}). On success, the sent {@link Message} is returned. Bots can currently send video files of up to 50 MB in size, this limit may be changed in the future.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param video Video to send. Upload a new video using multipart/form-data.
	 * @return The newly created command
	 */
	public SendVideo sendVideo(Object chatId, byte[] video) {
		return new SendVideo(api, chatId, video);
	}

	/**
	 * As of v.4.0, Telegram clients support rounded square MPEG4 videos of up to 1 minute long. Use this method to send video messages. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param videoNote Video note to send. Pass a file_id as String to send a video note that exists on the Telegram servers (recommended). Sending video notes by a URL is currently unsupported.
	 * @return The newly created command
	 */
	public SendVideoNote sendVideoNote(Object chatId, String videoNote) {
		return new SendVideoNote(api, chatId, videoNote);
	}

	/**
	 * As of v.4.0, Telegram clients support rounded square MPEG4 videos of up to 1 minute long. Use this method to send video messages. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param videoNote Video note to send. Upload a new video using multipart/form-data.
	 * @return The newly created command
	 */
	public SendVideoNote sendVideoNote(Object chatId, java.io.File videoNote) {
		return new SendVideoNote(api, chatId, videoNote);
	}

	/**
	 * As of v.4.0, Telegram clients support rounded square MPEG4 videos of up to 1 minute long. Use this method to send video messages. On success, the sent {@link Message} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param videoNote Video note to send. Upload a new video using multipart/form-data.
	 * @return The newly created command
	 */
	public SendVideoNote sendVideoNote(Object chatId, byte[] videoNote) {
		return new SendVideoNote(api, chatId, videoNote);
	}

	/**
	 * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message. For this to work, your audio must be in an .OGG file encoded with OPUS (other formats may be sent as {@link Audio} or {@link Document}). On success, the sent {@link Message} is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param voice Audio file to send. Pass a file_id as String to send a file that exists on the Telegram servers (recommended), or pass an HTTP URL as a String for Telegram to get a file from the Internet.
	 * @return The newly created command
	 */
	public SendVoice sendVoice(Object chatId, String voice) {
		return new SendVoice(api, chatId, voice);
	}

	/**
	 * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message. For this to work, your audio must be in an .OGG file encoded with OPUS (other formats may be sent as {@link Audio} or {@link Document}). On success, the sent {@link Message} is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param voice Audio file to send. Upload a new one using multipart/form-data.
	 * @return The newly created command
	 */
	public SendVoice sendVoice(Object chatId, java.io.File voice) {
		return new SendVoice(api, chatId, voice);
	}

	/**
	 * Use this method to send audio files, if you want Telegram clients to display the file as a playable voice message. For this to work, your audio must be in an .OGG file encoded with OPUS (other formats may be sent as {@link Audio} or {@link Document}). On success, the sent {@link Message} is returned. Bots can currently send voice messages of up to 50 MB in size, this limit may be changed in the future.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param voice Audio file to send. Upload a new one using multipart/form-data.
	 * @return The newly created command
	 */
	public SendVoice sendVoice(Object chatId, byte[] voice) {
		return new SendVoice(api, chatId, voice);
	}

	/**
	 * Use this method to set a custom title for an administrator in a supergroup promoted by the bot. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param userId Unique identifier of the target user
	 * @param customTitle New custom title for the administrator; 0-16 characters, emoji are not allowed
	 * @return The newly created command
	 */
	public SetChatAdministratorCustomTitle setChatAdministratorCustomTitle(Object chatId, long userId, String customTitle) {
		return new SetChatAdministratorCustomTitle(api, chatId, userId, customTitle);
	}

	/**
	 * Use this method to change the description of a group, a supergroup or a channel. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param description New chat description, 0-255 characters
	 * @return The newly created command
	 */
	public SetChatDescription setChatDescription(Object chatId, String description) {
		return new SetChatDescription(api, chatId, description);
	}

	/**
	 * Use this method to change the bot's menu button in a private chat, or the default menu button. Returns True on success.
	 * @return The newly created command
	 */
	public SetChatMenuButton setChatMenuButton() {
		return new SetChatMenuButton(api);
	}

	/**
	 * Use this method to set default chat permissions for all members. The bot must be an administrator in the group or a supergroup for this to work and must have the {@link PromoteChatMember#canRestrictMembers can_restrict_members} administrator rights. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param permissions An object for new default chat permissions
	 * @return The newly created command
	 */
	public SetChatPermissions setChatPermissions(Object chatId, ChatPermissions permissions) {
		return new SetChatPermissions(api, chatId, permissions);
	}

	/**
	 * Use this method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param photo New chat photo, uploaded using multipart/form-data
	 * @return The newly created command
	 */
	public SetChatPhoto setChatPhoto(Object chatId, java.io.File photo) {
		return new SetChatPhoto(api, chatId, photo);
	}

	/**
	 * Use this method to set a new profile photo for the chat. Photos can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param photo New chat photo, uploaded using multipart/form-data
	 * @return The newly created command
	 */
	public SetChatPhoto setChatPhoto(Object chatId, byte[] photo) {
		return new SetChatPhoto(api, chatId, photo);
	}

	/**
	 * Use this method to set a new group sticker set for a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Use the field {@link Chat#canSetStickerSet() can_set_sticker_set } optionally returned in {@link #getChat} requests to check if the bot can use this method. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param stickerSetName Name of the sticker set to be set as the group sticker set
	 * @return The newly created command
	 */
	public SetChatStickerSet setChatStickerSet(Object chatId, String stickerSetName) {
		return new SetChatStickerSet(api, chatId, stickerSetName);
	}

	/**
	 * Use this method to change the title of a chat. Titles can't be changed for private chats. The bot must be an administrator in the chat for this to work and must have the appropriate administrator rights. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param title New chat title, 1-128 characters
	 * @return The newly created command
	 */
	public SetChatTitle setChatTitle(Object chatId, String title) {
		return new SetChatTitle(api, chatId, title);
	}

	/**
	 * Use this method to set the thumbnail of a custom emoji sticker set. Returns True on success.
	 * @param name Sticker set name
	 * @return The newly created command
	 */
	public SetCustomEmojiStickerSetThumbnail setCustomEmojiStickerSetThumbnail(String name) {
		return new SetCustomEmojiStickerSetThumbnail(api, name);
	}

	/**
	 * Use this method to set the score of the specified user in a game message. On success, if the message is not an inline message, the {@link Message} is returned, otherwise True is returned. Returns an error, if the new score is not greater than the user's current score in the chat and force is False.
	 * @param userId User identifier
	 * @param score New score, must be non-negative
	 * @param inlineMessageId Identifier of the inline message
	 * @return The newly created command
	 */
	public SetGameScore setGameScore(long userId, int score, String inlineMessageId) {
		return new SetGameScore(api, userId, score, inlineMessageId);
	}

	/**
	 * Use this method to set the score of the specified user in a game message. On success, if the message is not an inline message, the {@link Message} is returned, otherwise True is returned. Returns an error, if the new score is not greater than the user's current score in the chat and force is False.
	 * @param userId User identifier
	 * @param score New score, must be non-negative
	 * @param chatId Unique identifier for the target chat
	 * @param messageId Identifier of the sent message
	 * @return The newly created command
	 */
	public SetGameScore setGameScore(long userId, int score, Object chatId, int messageId) {
		return new SetGameScore(api, userId, score, chatId, messageId);
	}

	/**
	 * Use this method to change the list of the bot's commands. See <a href="https://core.telegram.org/bots/features#commands">this manual</a> for more details about bot commands. Returns True on success.
	 * @param commands A list of bot commands to be set as the list of the bot's commands. At most 100 commands can be specified.
	 * @return The newly created command
	 */
	public SetMyCommands setMyCommands(BotCommand... commands) {
		return new SetMyCommands(api, commands);
	}

	/**
	 * Use this method to change the default administrator rights requested by the bot when it's added as an administrator to groups or channels. These rights will be suggested to users, but they are free to modify the list before adding the bot. Returns True on success.
	 * @return The newly created command
	 */
	public SetMyDefaultAdministratorRights setMyDefaultAdministratorRights() {
		return new SetMyDefaultAdministratorRights(api);
	}

	/**
	 * Use this method to change the bot's description, which is shown in the chat with the bot if the chat is empty. Returns True on success.
	 * @return The newly created command
	 */
	public SetMyDescription setMyDescription() {
		return new SetMyDescription(api);
	}

	/**
	 * Use this method to change the bot's name. Returns True on success.
	 * @return The newly created command
	 */
	public SetMyName setMyName() {
		return new SetMyName(api);
	}

	/**
	 * Use this method to change the bot's short description, which is shown on the bot's profile page and is sent together with the link when users share the bot. Returns True on success.
	 * @return The newly created command
	 */
	public SetMyShortDescription setMyShortDescription() {
		return new SetMyShortDescription(api);
	}

	/**
	 * Informs a user that some of the Telegram Passport elements they provided contains errors. The user will not be able to re-submit their Passport to you until the errors are fixed (the contents of the field for which you returned the error must change). Returns True on success.
	 * <br><br>
	 * Use this if the data submitted by the user doesn't satisfy the standards your service requires for any reason. For example, if a birthday date seems invalid, a submitted document is blurry, a scan shows evidence of tampering, etc. Supply some details in the error message to make sure the user knows how to correct the issues.
	 * @param userId User identifier
	 * @param errors An array describing the errors
	 * @return The newly created command
	 */
	public SetPassportDataErrors setPassportDataErrors(long userId, PassportElementError... errors) {
		return new SetPassportDataErrors(api, userId, errors);
	}

	/**
	 * Use this method to change the list of emoji assigned to a regular or custom emoji sticker. The sticker must belong to a sticker set created by the bot. Returns True on success.
	 * @param sticker File identifier of the sticker
	 * @param emojiList A list of 1-20 emoji associated with the sticker
	 * @return The newly created command
	 */
	public SetStickerEmojiList setStickerEmojiList(String sticker, String[] emojiList) {
		return new SetStickerEmojiList(api, sticker, emojiList);
	}

	/**
	 * Use this method to change search keywords assigned to a regular or custom emoji sticker. The sticker must belong to a sticker set created by the bot. Returns True on success.
	 * @param sticker File identifier of the sticker
	 * @return The newly created command
	 */
	public SetStickerKeywords setStickerKeywords(String sticker) {
		return new SetStickerKeywords(api, sticker);
	}

	/**
	 * Use this method to change the {@link MaskPosition mask position} of a mask sticker. The sticker must belong to a sticker set that was created by the bot. Returns True on success.
	 * @param sticker File identifier of the sticker
	 * @return The newly created command
	 */
	public SetStickerMaskPosition setStickerMaskPosition(String sticker) {
		return new SetStickerMaskPosition(api, sticker);
	}

	/**
	 * Use this method to move a sticker in a set created by the bot to a specific position. Returns True on success.
	 * @param sticker File identifier of the sticker
	 * @param position New sticker position in the set, zero-based
	 * @return The newly created command
	 */
	public SetStickerPositionInSet setStickerPositionInSet(String sticker, int position) {
		return  new SetStickerPositionInSet(api, sticker, position);
	}

	/**
	 * Use this method to set the thumbnail of a regular or mask sticker set. The format of the thumbnail file must match the format of the stickers in the set. Returns True on success.
	 * @param name Sticker set name
	 * @param userId User identifier of the sticker set owner
	 * @return The newly created command
	 */
	@Deprecated
	public SetStickerSetThumb setStickerSetThumb(String name, Long userId) {
		return new SetStickerSetThumb(api, name, userId);
	}

	/**
	 * Use this method to set the thumbnail of a regular or mask sticker set. The format of the thumbnail file must match the format of the stickers in the set. Returns True on success.
	 * @param name Sticker set name
	 * @param userId User identifier of the sticker set owner
	 * @param thumb A .WEBP or .PNG image with the thumbnail, must be up to 128 kilobytes in size and have a width and height of exactly 100px, or a .TGS animation with a thumbnail up to 32 kilobytes in size (see <a href="https://core.telegram.org/stickers#animated-sticker-requirements">https://core.telegram.org/stickers#animated-sticker-requirements</a> for animated sticker technical requirements), or a WEBM video with the thumbnail up to 32 kilobytes in size; see <a href="https://core.telegram.org/stickers#video-sticker-requirements">https://core.telegram.org/stickers#video-sticker-requirements</a> for video sticker technical requirements. Pass a file_id as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. Animated and video sticker set thumbnails can't be uploaded via HTTP URL. If omitted, then the thumbnail is dropped and the first sticker is used as the thumbnail.
	 * @return The newly created command
	 */
	@Deprecated
	public SetStickerSetThumb setStickerSetThumb(String name, Long userId, Object thumb) {
		return new SetStickerSetThumb(api, name, userId, thumb);
	}

	/**
	 * Use this method to set the thumbnail of a regular or mask sticker set. The format of the thumbnail file must match the format of the stickers in the set. Returns True on success.
	 * @param name Sticker set name
	 * @param userId User identifier of the sticker set owner
	 * @return The newly created command
	 */
	public SetStickerSetThumbnail setStickerSetThumbnail(String name, Long userId) {
		return new SetStickerSetThumbnail(api, name, userId);
	}

	/**
	 * Use this method to set the thumbnail of a regular or mask sticker set. The format of the thumbnail file must match the format of the stickers in the set. Returns True on success.
	 * @param name Sticker set name
	 * @param userId User identifier of the sticker set owner
	 * @param thumbnail A .WEBP or .PNG image with the thumbnail, must be up to 128 kilobytes in size and have a width and height of exactly 100px, or a .TGS animation with a thumbnail up to 32 kilobytes in size (see <a href="https://core.telegram.org/stickers#animated-sticker-requirements">https://core.telegram.org/stickers#animated-sticker-requirements</a> for animated sticker technical requirements), or a WEBM video with the thumbnail up to 32 kilobytes in size; see <a href="https://core.telegram.org/stickers#video-sticker-requirements">https://core.telegram.org/stickers#video-sticker-requirements</a> for video sticker technical requirements. Pass a file_id as a String to send a file that already exists on the Telegram servers, pass an HTTP URL as a String for Telegram to get a file from the Internet, or upload a new one using multipart/form-data. Animated and video sticker set thumbnails can't be uploaded via HTTP URL. If omitted, then the thumbnail is dropped and the first sticker is used as the thumbnail.
	 * @return The newly created command
	 */
	public SetStickerSetThumbnail setStickerSetThumbnail(String name, Long userId, Object thumbnail) {
		return new SetStickerSetThumbnail(api, name, userId, thumbnail);
	}

	/**
	 * Use this method to set the title of a created sticker set. Returns True on success.
	 * @param name Sticker set name
	 * @param title Sticker set title, 1-64 characters
	 * @return The newly created command
	 */
	public SetStickerSetTitle setStickerSetTitle(String name, String title) {
		return new SetStickerSetTitle(api, name, title);
	}

	/**
	 * Use this method to specify a URL and receive incoming updates via an outgoing webhook. Whenever there is an update for the bot, we will send an HTTPS POST request to the specified URL, containing a JSON-serialized {@link Update}. In case of an unsuccessful request, we will give up after a reasonable amount of attempts. Returns True on success.
	 * <br><br>
	 * If you'd like to make sure that the webhook was set by you, you can specify secret data in the parameter secret_token. If specified, the request will contain a header “X-Telegram-Bot-Api-Secret-Token” with the secret token as content.
	 * @return The newly created command
	 */
	public SetWebhook setWebhook() {
		return new SetWebhook(api);
	}

	/**
	 * Use this method to stop updating a live location message before {@link Location#livePeriod live_period} expires. On success, if the message is not an inline message, the edited {@link Message} is returned, otherwise True is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param messageId Identifier of the message with live location to stop
	 * @return The newly created command
	 */
	public StopMessageLiveLocation stopMessageLiveLocation(Object chatId, int messageId) {
		return new StopMessageLiveLocation(api, chatId, messageId);
	}

	/**
	 * Use this method to stop updating a live location message before {@link Location#livePeriod live_period} expires. On success, if the message is not an inline message, the edited {@link Message} is returned, otherwise True is returned.
	 * @param inlineMessageId Identifier of the inline message
	 * @return The newly created command
	 */
	public StopMessageLiveLocation stopMessageLiveLocation(String inlineMessageId) {
		return new StopMessageLiveLocation(api, inlineMessageId);
	}

	/**
	 * Use this method to stop a poll which was sent by the bot. On success, the stopped {@link Poll} is returned.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param messageId Identifier of the original message with the poll
	 * @return The newly created command
	 */
	public StopPoll stopPoll(Object chatId, int messageId) {
		return new StopPoll(api, chatId, messageId);
	}

	/**
	 * Use this method to unban a previously banned user in a supergroup or channel. The user will <b>not</b> return to the group or channel automatically, but will be able to join via link, etc. The bot must be an administrator for this to work. By default, this method guarantees that after the call the user is not a member of the chat, but will be able to join it. So if the user is a member of the chat they will also be <b>removed</b> from the chat. If you don't want this, use the parameter only_if_banned. Returns True on success.
	 * @param chatId Unique identifier for the target group or username of the target supergroup or channel (in the format @channel_username)
	 * @param userId Unique identifier of the target user
	 * @return The newly created command
	 */
	public UnbanChatMember unbanChatMember(Object chatId, long userId) {
		return new UnbanChatMember(api, chatId, userId);
	}

	/**
	 * Use this method to unban a previously banned channel chat in a supergroup or channel. The bot must be an administrator for this to work and must have the appropriate administrator rights. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @param senderChatId Unique identifier of the target sender chat
	 * @return The newly created command
	 */
	public UnbanChatSenderChat unbanChatSenderChat(Object chatId, long senderChatId) {
		return new UnbanChatSenderChat(api, chatId, senderChatId);
	}

	/**
	 * Use this method to unhide the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @return The newly created command
	 */
	public UnhideGeneralForumTopic unhideGeneralForumTopic(Long chatId) {
		return new UnhideGeneralForumTopic(api, chatId);
	}

	/**
	 * Use this method to unhide the 'General' topic in a forum supergroup chat. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canManageTopics can_manage_topics} administrator rights. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @return The newly created command
	 */
	public UnhideGeneralForumTopic unhideGeneralForumTopic(String chatId) {
		return new UnhideGeneralForumTopic(api, chatId);
	}

	/**
	 * Use this method to clear the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canPinMessages can_pin_messages} administrator right in a supergroup or {@link PromoteChatMember#canEditMessages can_edit_messages} administrator right in a channel. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @return The newly created command
	 */
	public UnpinAllChatMessages unpinAllChatMessages(Object chatId) {
		return new UnpinAllChatMessages(api, chatId);
	}

	/**
	 * Use this method to clear the list of pinned messages in a forum topic. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canPinMessages can_pin_messages} administrator right in the supergroup. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param messageThreadId Unique identifier for the target message thread of the forum topic
	 * @return The newly created command
	 */
	@Deprecated
	public UnpinAllForumTopicMessages unpinAllForumTopicMessages(Integer chatId, Integer messageThreadId) {
		return new UnpinAllForumTopicMessages(api, chatId, messageThreadId);
	}

	/**
	 * Use this method to clear the list of pinned messages in a forum topic. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canPinMessages can_pin_messages} administrator right in the supergroup. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param messageThreadId Unique identifier for the target message thread of the forum topic
	 * @return The newly created command
	 */
	public UnpinAllForumTopicMessages unpinAllForumTopicMessages(Long chatId, Integer messageThreadId) {
		return new UnpinAllForumTopicMessages(api, chatId, messageThreadId);
	}

	/**
	 * Use this method to clear the list of pinned messages in a forum topic. The bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canPinMessages can_pin_messages} administrator right in the supergroup. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target supergroup (in the format @supergroup_username)
	 * @param messageThreadId Unique identifier for the target message thread of the forum topic
	 * @return The newly created command
	 */
	public UnpinAllForumTopicMessages unpinAllForumTopicMessages(String chatId, Integer messageThreadId) {
		return new UnpinAllForumTopicMessages(api, chatId, messageThreadId);
	}

	/**
	 * Use this method to remove a message from the list of pinned messages in a chat. If the chat is not a private chat, the bot must be an administrator in the chat for this to work and must have the {@link PromoteChatMember#canPinMessages can_pin_messages} administrator right in a supergroup or {@link PromoteChatMember#canEditMessages can_edit_messages} administrator right in a channel. Returns True on success.
	 * @param chatId Unique identifier for the target chat or username of the target channel (in the format @channel_username)
	 * @return The newly created command
	 */
	public UnpinChatMessage unpinChatMessage(Object chatId) {
		return new UnpinChatMessage(api, chatId);
	}

	/**
	 * Use this method to upload a file with a sticker for later use in the {@link #createNewStickerSet} and {@link #addStickerToSet} methods (the file can be used multiple times). Returns the uploaded {@link File} on success.
	 * @param userId User identifier of sticker file owner
	 * @param pngSticker A file with the sticker in .PNG format.
	 * @return The newly created command
	 */
	@Deprecated
	public UploadStickerFile uploadStickerFile(Long userId, Object pngSticker) {
		return new UploadStickerFile(api, userId, pngSticker);
	}

	/**
	 * Use this method to upload a file with a sticker for later use in the {@link #createNewStickerSet} and {@link #addStickerToSet} methods (the file can be used multiple times). Returns the uploaded {@link File} on success.
	 * @param userId User identifier of sticker file owner
	 * @param sticker A file with the sticker in .WEBP, .PNG, .TGS, or .WEBM format. See <a href="https://core.telegram.org/stickers">https://core.telegram.org/stickers</a> for technical requirements.
	 * @param stickerFormat Format of the sticker, must be one of “static”, “animated”, “video”
	 * @return The newly created command
	 */
	public UploadStickerFile uploadStickerFile(Long userId, Object sticker, Sticker.Format stickerFormat) {
		return new UploadStickerFile(api, userId, sticker, stickerFormat);
	}

    public void setUpdatesListener(UpdatesListener listener) {
        setUpdatesListener(listener, new GetUpdates(api));
    }

    public void setUpdatesListener(UpdatesListener listener, GetUpdates request) {
        setUpdatesListener(listener, null, request);
    }

    public void setUpdatesListener(UpdatesListener listener, ExceptionHandler exceptionHandler) {
        setUpdatesListener(listener, exceptionHandler, new GetUpdates(api));
    }

    public void setUpdatesListener(UpdatesListener listener, ExceptionHandler exceptionHandler, GetUpdates request) {
        updatesHandler.start(this, listener, exceptionHandler, request);
    }

    public void removeGetUpdatesListener() {
        updatesHandler.stop();
    }

    public void shutdown() {
        api.shutdown();
    }

    public static final class Builder {

        static final String API_URL = "https://api.telegram.org/bot";

        private final String botToken;
        private FileApi fileApi;
        private TelegramBotClient api;
        private UpdatesHandler updatesHandler;

        private OkHttpClient okHttpClient;
        private String apiUrl;
        private String fileApiUrl;
        private boolean useTestServer = false;

        public Builder(String botToken) {
            this.botToken = botToken;
            api = new TelegramBotClient(client(null), gson(), apiUrl(API_URL, botToken, useTestServer));
            fileApi = new FileApi(botToken);
            updatesHandler = new UpdatesHandler(100);
        }

        public Builder debug() {
            okHttpClient = client(httpLoggingInterceptor());
            return this;
        }

        public Builder okHttpClient(OkHttpClient client) {
            okHttpClient = client;
            return this;
        }

        public Builder apiUrl(String apiUrl) {
            this.apiUrl = apiUrl;
            return this;
        }

        public Builder fileApiUrl(String fileApiUrl) {
            this.fileApiUrl = fileApiUrl;
            return this;
        }

        public Builder updateListenerSleep(long millis) {
            updatesHandler = new UpdatesHandler(millis);
            return this;
        }

        public Builder useTestServer(boolean useTestServer) {
            this.useTestServer = useTestServer;
            return this;
        }

        public TelegramBot build() {
            if (okHttpClient != null || apiUrl != null) {
                OkHttpClient client = okHttpClient != null ? okHttpClient : client(null);
                String baseUrl = apiUrl(apiUrl != null ? apiUrl : API_URL, botToken, useTestServer);
                api = new TelegramBotClient(client, gson(), baseUrl);
            }
            if (fileApiUrl != null) {
                fileApi = new FileApi(fileApiUrl, botToken);
            }
            return new TelegramBot(this);
        }

        private static OkHttpClient client(Interceptor interceptor) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .connectTimeout(75, TimeUnit.SECONDS)
                    .writeTimeout(75, TimeUnit.SECONDS)
                    .readTimeout(75, TimeUnit.SECONDS);
            if (interceptor != null) builder.addInterceptor(interceptor);
            return builder.build();
        }

        private static Interceptor httpLoggingInterceptor() {
            return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        private static Gson gson() {
            return new Gson();
        }

        private static String apiUrl(String apiUrl, String botToken, boolean useTestServer) {
            return apiUrl + botToken + (useTestServer ? "/test/" : "/");
        }
    }
}
