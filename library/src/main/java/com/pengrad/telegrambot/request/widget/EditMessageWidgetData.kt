package com.pengrad.telegrambot.request.widget

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter

/**
 * Edits data of a widget in a message sent by the bot or via the bot (for inline bots).
 */
class EditMessageWidgetData private constructor(
    chatId: Long?,
    channelUsername: String?,
    messageId: Int?,
    inlineMessageId: String?
) : KBaseRequest<EditMessageWidgetData, BaseResponse>(BaseResponse::class) {

    constructor(chatId: Long, messageId: Int) : this(
        chatId = chatId,
        channelUsername = null,
        messageId = messageId,
        inlineMessageId = null
    )

    constructor(channelUsername: String, messageId: Int) : this(
        chatId = null,
        channelUsername = channelUsername,
        messageId = messageId,
        inlineMessageId = null
    )

    constructor(inlineMessageId: String) : this(
        chatId = null,
        channelUsername = null,
        messageId = null,
        inlineMessageId = inlineMessageId
    )

    val chatId: Long? by optionalRequestParameter(chatId, customParameterName = "chat_id")
    val channelUsername: String? by optionalRequestParameter(channelUsername, customParameterName = "chat_id")
    val messageId: Int? by optionalRequestParameter(messageId)
    val inlineMessageId: String? by optionalRequestParameter(inlineMessageId)

    var publicData: String? by optionalRequestParameter()
    var chatData: String? by optionalRequestParameter()

    fun publicData(publicData: String) = applySelf { this.publicData = publicData }

    fun chatData(chatData: String) = applySelf { this.chatData = chatData }

}
