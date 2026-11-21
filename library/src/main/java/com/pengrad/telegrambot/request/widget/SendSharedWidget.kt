package com.pengrad.telegrambot.request.widget

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.request.AbstractSendRequest
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

/**
 * Sends again a shared widget created by the bot.
 */
class SendSharedWidget private constructor(
    chatId: Long? = null,
    channelUsername: String? = null,

    widgetId: String
) : AbstractSendRequest<SendSharedWidget>(
    chatId = chatId,
    channelUsername = channelUsername,
) {

    constructor(chatId: Long, widgetId: String) : this(
        chatId = chatId,
        channelUsername = null,
        widgetId = widgetId
    )

    constructor(channelUsername: String, widgetId: String) : this(
        chatId = null,
        channelUsername = channelUsername,
        widgetId = widgetId
    )

    val widgetId: String by requestParameter(widgetId)

    var chatData: String? by optionalRequestParameter()
    var caption: String? by optionalRequestParameter()
    var parseMode: ParseMode? by optionalRequestParameter()
    var captionEntities: List<MessageEntity>? by optionalRequestParameter()
    var showCaptionAboveMedia: Boolean? by optionalRequestParameter()

    fun chatData(chatData: String) = applySelf { this.chatData = chatData }

    fun caption(caption: String) = applySelf { this.caption = caption }

    fun parseMode(parseMode: ParseMode) = applySelf { this.parseMode = parseMode }

    fun captionEntities(captionEntities: List<MessageEntity>) = applySelf { this.captionEntities = captionEntities }

    fun captionEntities(vararg captionEntities: MessageEntity) = captionEntities(captionEntities.toList())

    fun showCaptionAboveMedia(showCaptionAboveMedia: Boolean) = applySelf { this.showCaptionAboveMedia = showCaptionAboveMedia }
}
