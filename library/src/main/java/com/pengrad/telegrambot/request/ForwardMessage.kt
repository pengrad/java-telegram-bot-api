@file:Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.response.SendResponse
import com.pengrad.telegrambot.utility.kotlin.JavaInteger
import com.pengrad.telegrambot.utility.kotlin.JavaLong
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class ForwardMessage private constructor(
    chatId: Long?,
    channelUsername: String?,

    fromChatId: Long?,
    fromChannelUsername: String?,

    messageId: Int
) : KBaseRequest<ForwardMessage, SendResponse>(SendResponse::class) {

    constructor(chatId: Long, fromChatId: Long, messageId: Int) : this(
        chatId = chatId,
        channelUsername = null,

        fromChatId = fromChatId,
        fromChannelUsername = null,

        messageId = messageId
    )

    /**
     * Backwards-compatibility for Java code
     */
    constructor(chatId: JavaLong, fromChatId: JavaLong, messageId: JavaInteger) : this(
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
     * Backwards-compatibility for Java code
     */
    constructor(channelUsername: String, fromChatId: JavaLong, messageId: JavaInteger) : this(
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
     * Backwards-compatibility for Java code
     */
    constructor(chatId: JavaLong, fromChannelUsername: String, messageId: JavaInteger) : this(
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
     * Backwards-compatibility for Java code
     */
    constructor(channelUsername: String, fromChannelUsername: String, messageId: JavaInteger) : this(
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
     * Backwards-compatibility for Java code
     */
    @Suppress("DEPRECATION")
    @Deprecated("Use constructor with chatId and fromChatId or channelUsername and fromChannelUsername instead", ReplaceWith("ForwardMessage(chatId, fromChatId, messageId)"))
    constructor(chatId: Any, fromChatId: Any, messageId: JavaInteger) : this(
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
    var disableNotification: Boolean? by optionalRequestParameter()
    var protectContent: Boolean? by optionalRequestParameter()
    var videoStartTimestamp: Int? by optionalRequestParameter()

    fun messageThreadId(messageThreadId: Int) = applySelf { this.messageThreadId = messageThreadId }

    fun disableNotification(disableNotification: Boolean) = applySelf { this.disableNotification = disableNotification }

    fun protectContent(protectContent: Boolean) = applySelf { this.protectContent = protectContent }

    fun videoStartTimestamp(videoStartTimestamp: Int) = applySelf { this.videoStartTimestamp = videoStartTimestamp }

}