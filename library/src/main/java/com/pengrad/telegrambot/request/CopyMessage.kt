package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.request.Keyboard
import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.model.request.ReplyParameters
import com.pengrad.telegrambot.response.MessageIdResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class CopyMessage private constructor(
    chatId: Long?,
    channelUsername: String?,

    fromChatId: Long?,
    fromChannelUsername: String?,

    messageId: Int
) : KBaseRequest<CopyMessage, MessageIdResponse>(MessageIdResponse::class) {

    constructor(chatId: Long, fromChatId: Long, messageId: Int) : this(
        chatId = chatId,
        channelUsername = null,

        fromChatId = fromChatId,
        fromChannelUsername = null,

        messageId = messageId
    )

    /**
     * Backwards-compatability for Java code
     */
    constructor(chatId: java.lang.Long, fromChatId: java.lang.Long, messageId: Integer) : this(
        chatId = chatId.toLong(),
        fromChatId = fromChatId.toLong(),
        messageId = messageId.toInt()
    )


    constructor(channelUsername: String, fromChatId: Long, messageId: Int) : this(
        chatId = null,
        channelUsername = channelUsername,

        fromChatId = fromChatId,
        fromChannelUsername = null,

        messageId = messageId
    )

    /**
     * Backwards-compatability for Java code
     */
    constructor(channelUsername: String, fromChatId: java.lang.Long, messageId: Integer) : this(
        channelUsername = channelUsername,
        fromChatId = fromChatId.toLong(),
        messageId = messageId.toInt()
    )


    constructor(chatId: Long, fromChannelUsername: String, messageId: Int) : this(
        chatId = chatId,
        channelUsername = null,

        fromChatId = null,
        fromChannelUsername = fromChannelUsername,

        messageId = messageId
    )

    /**
     * Backwards-compatability for Java code
     */
    constructor(chatId: java.lang.Long, fromChannelUsername: String, messageId: Integer) : this(
        chatId = chatId.toLong(),
        fromChannelUsername = fromChannelUsername,
        messageId = messageId.toInt()
    )


    constructor(channelUsername: String, fromChannelUsername: String, messageId: Int) : this(
        chatId = null,
        channelUsername = channelUsername,

        fromChatId = null,
        fromChannelUsername = fromChannelUsername,

        messageId = messageId
    )

    /**
     * Backwards-compatability for Java code
     */
    constructor(channelUsername: String, fromChannelUsername: String, messageId: Integer) : this(
        channelUsername = channelUsername,
        fromChannelUsername = fromChannelUsername,
        messageId = messageId.toInt()
    )


    @Deprecated("Use constructor with chatId and fromChatId or channelUsername and fromChannelUsername instead", ReplaceWith("ForwardMessage(chatId, fromChatId, messageId)"))
    constructor(chatId: Any, fromChatId: Any, messageId: Int) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        fromChatId = (fromChatId as? Number)?.toLong(),
        fromChannelUsername = fromChatId as? String,
        messageId = messageId
    ) {
        if (this.chatId == null && this.channelUsername == null) {
            throw IllegalArgumentException("chatId parameter must be either Long or String")
        }

        if (this.fromChatId == null && this.fromChannelUsername == null) {
            throw IllegalArgumentException("fromChatId parameter must be either Long or String")
        }
    }

    /**
     * Backwards-compatability for Java code
     */
    @Suppress("DEPRECATION")
    @Deprecated("Use constructor with chatId and fromChatId or channelUsername and fromChannelUsername instead", ReplaceWith("ForwardMessage(chatId, fromChatId, messageId)"))
    constructor(chatId: Any, fromChatId: Any, messageId: Integer) : this(
        chatId = chatId,
        fromChatId = fromChatId,
        messageId = messageId.toInt()
    )

    val chatId: Long? by optionalRequestParameter(chatId, customParameterName = "chat_id")
    val channelUsername: String? by optionalRequestParameter(channelUsername, customParameterName = "chat_id")

    val fromChatId: Long? by optionalRequestParameter(fromChatId, customParameterName = "from_chat_id")
    val fromChannelUsername: String? by optionalRequestParameter(fromChannelUsername, customParameterName = "from_chat_id")

    val messageId: Int by requestParameter(messageId)

    var messageThreadId: Int? by optionalRequestParameter()

    var caption: String? by optionalRequestParameter()
    var parseMode: ParseMode? by optionalRequestParameter()
    var captionEntities: List<MessageEntity>? by optionalRequestParameter()

    var replyParameters: ReplyParameters? by optionalRequestParameter()
    @Deprecated("Use replyParameters instead")
    private var replyToMessageId: Int? by optionalRequestParameter()
    @Deprecated("Use replyParameters instead")
    private var allowSendingWithoutReply: Boolean? by optionalRequestParameter()

    var replyMarkup: Keyboard? by optionalRequestParameter()
    var showCaptionAboveMedia: Boolean? by optionalRequestParameter()
    var disableNotification: Boolean? by optionalRequestParameter()
    var protectContent: Boolean? by optionalRequestParameter()
    var videoStartTimestamp: Int? by optionalRequestParameter()
    var allowPaidBroadcast: Boolean? by optionalRequestParameter()

    fun messageThreadId(messageThreadId: Int) = applySelf { this.messageThreadId = messageThreadId }

    fun caption(caption: String) = applySelf { this.caption = caption }

    fun parseMode(parseMode: ParseMode) = applySelf { this.parseMode = parseMode }

    fun captionEntities(captionEntities: List<MessageEntity>) = applySelf { this.captionEntities = captionEntities }

    fun captionEntities(vararg captionEntities: MessageEntity) = applySelf { this.captionEntities = captionEntities.toList() }

    fun replyParameters(parameters: ReplyParameters) = applySelf { this.replyParameters = parameters }

    @Suppress("DEPRECATION")
    @Deprecated(
        message = "Use replyParameters instead",
        ReplaceWith(
            expression = "replyParameters(ReplyParameters(replyToMessageId))",
            imports = ["com.pengrad.telegrambot.model.request.ReplyParameters"]
        )
    )
    fun replyToMessageId(replyToMessageId: Int) = applySelf { this.replyToMessageId = replyToMessageId }

    @Suppress("DEPRECATION")
    @Deprecated(
        message = "Use replyParameters instead",
        ReplaceWith(
            expression = "replyParameters(ReplyParameters(messageId).allowSendingWithoutReply(allowSendingWithoutReply))",
            imports = ["com.pengrad.telegrambot.model.request.ReplyParameters"]
        )
    )
    fun allowSendingWithoutReply(allowSendingWithoutReply: Boolean) = applySelf { this.allowSendingWithoutReply = allowSendingWithoutReply }

    fun replyMarkup(replyMarkup: Keyboard) = applySelf { this.replyMarkup = replyMarkup }

    fun showCaptionAboveMedia(showCaptionAboveMedia: Boolean) = applySelf { this.showCaptionAboveMedia = showCaptionAboveMedia }

    fun disableNotification(disableNotification: Boolean) = applySelf { this.disableNotification = disableNotification }

    fun protectContent(protectContent: Boolean) = applySelf { this.protectContent = protectContent }

    fun videoStartTimestamp(videoStartTimestamp: Int) = applySelf { this.videoStartTimestamp = videoStartTimestamp }

    fun allowPaidBroadcast(allowPaidBroadcast: Boolean) = applySelf { this.allowPaidBroadcast = allowPaidBroadcast }

}