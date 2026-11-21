package com.pengrad.telegrambot.request.widget

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.request.AbstractSendRequest
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

/**
 * Sends a message with an HTML widget. HTML must be 1-32768 bytes and must not exceed 4096 bytes
 * when compressed by zlib with the maximum compression level.
 */
class SendWidget private constructor(
    chatId: Long? = null,
    channelUsername: String? = null,

    html: String
) : AbstractSendRequest<SendWidget>(
    chatId = chatId,
    channelUsername = channelUsername,
) {

    constructor(chatId: Long, html: String) : this(
        chatId = chatId,
        channelUsername = null,
        html = html
    )

    constructor(channelUsername: String, html: String) : this(
        chatId = null,
        channelUsername = channelUsername,
        html = html
    )

    val html: String by requestParameter(html)

    var width: Int? by optionalRequestParameter()
    var height: Int? by optionalRequestParameter()
    var publicData: String? by optionalRequestParameter()
    var chatData: String? by optionalRequestParameter()
    var caption: String? by optionalRequestParameter()
    var parseMode: ParseMode? by optionalRequestParameter()
    var captionEntities: List<MessageEntity>? by optionalRequestParameter()
    var showCaptionAboveMedia: Boolean? by optionalRequestParameter()
    var allowQueries: Boolean? by optionalRequestParameter()
    var isShared: Boolean? by optionalRequestParameter()

    fun width(width: Int) = applySelf { this.width = width }

    fun height(height: Int) = applySelf { this.height = height }

    fun publicData(publicData: String) = applySelf { this.publicData = publicData }

    fun chatData(chatData: String) = applySelf { this.chatData = chatData }

    fun caption(caption: String) = applySelf { this.caption = caption }

    fun parseMode(parseMode: ParseMode) = applySelf { this.parseMode = parseMode }

    fun captionEntities(captionEntities: List<MessageEntity>) = applySelf { this.captionEntities = captionEntities }

    fun captionEntities(vararg captionEntities: MessageEntity) = captionEntities(captionEntities.toList())

    fun showCaptionAboveMedia(showCaptionAboveMedia: Boolean) = applySelf { this.showCaptionAboveMedia = showCaptionAboveMedia }

    fun allowQueries(allowQueries: Boolean) = applySelf { this.allowQueries = allowQueries }

    fun isShared(isShared: Boolean) = applySelf { this.isShared = isShared }
}
