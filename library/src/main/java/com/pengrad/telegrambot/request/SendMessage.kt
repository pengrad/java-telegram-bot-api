package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.model.LinkPreviewOptions
import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class SendMessage private constructor(
    chatId: Long? = null,
    channelUsername: String? = null,

    text: String
) : KAbstractSendRequest<SendMessage>(
    chatId = chatId,
    channelUsername = channelUsername,
) {

    constructor(chatId: Long, text: String) : this(
        chatId = chatId,
        channelUsername = null,
        text = text
    )

    constructor(channelUsername: String, text: String) : this(
        chatId = null,
        channelUsername = channelUsername,
        text = text
    )

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendMessage(chatId, text)"))
    constructor(chatId: Any, text: String) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        text = text
    ) {
        checkDeprecatedConstructorParameters()
    }

    @Suppress("NOTHING_TO_INLINE")
    private inline fun checkDeprecatedConstructorParameters() {
        if (this.chatId == null && this.channelUsername == null) {
            throw IllegalArgumentException("chatId parameter must be either Long or String")
        }
    }

    val text: String by requestParameter(text)

    var parseMode: ParseMode? by optionalRequestParameter()
    var entities: List<MessageEntity>? by optionalRequestParameter()
    var linkPreviewOptions: LinkPreviewOptions? by optionalRequestParameter()

    fun parseMode(parseMode: ParseMode) = applySelf { this.parseMode = parseMode }

    fun entities(entities: List<MessageEntity>) = applySelf { this.entities = entities }

    fun entities(vararg entities: MessageEntity) = entities(entities.toList())

    fun linkPreviewOptions(linkPreviewOptions: LinkPreviewOptions) = applySelf { this.linkPreviewOptions = linkPreviewOptions}

}