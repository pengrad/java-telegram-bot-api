package com.pengrad.telegrambot.request.ephemeral

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup
import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class EditEphemeralMessageCaption private constructor(
    chatId: Long?,
    channelUsername: String?,
    receiverUserId: Long,
    ephemeralMessageId: Long
) : KBaseRequest<EditEphemeralMessageCaption, BaseResponse>(BaseResponse::class) {

    constructor(chatId: Long, receiverUserId: Long, ephemeralMessageId: Long) : this(
        chatId = chatId,
        channelUsername = null,
        receiverUserId = receiverUserId,
        ephemeralMessageId = ephemeralMessageId
    )

    constructor(channelUsername: String, receiverUserId: Long, ephemeralMessageId: Long) : this(
        chatId = null,
        channelUsername = channelUsername,
        receiverUserId = receiverUserId,
        ephemeralMessageId = ephemeralMessageId
    )

    val chatId: Long? by optionalRequestParameter(chatId, customParameterName = "chat_id")
    val channelUsername: String? by optionalRequestParameter(channelUsername, customParameterName = "chat_id")
    val receiverUserId: Long by requestParameter(receiverUserId)
    val ephemeralMessageId: Long by requestParameter(ephemeralMessageId)

    var caption: String? by optionalRequestParameter()
    var parseMode: ParseMode? by optionalRequestParameter()
    var captionEntities: List<MessageEntity>? by optionalRequestParameter()
    var showCaptionAboveMedia: Boolean? by optionalRequestParameter()
    var replyMarkup: InlineKeyboardMarkup? by optionalRequestParameter()

    fun caption(caption: String) = applySelf { this.caption = caption }

    fun parseMode(parseMode: ParseMode) = applySelf { this.parseMode = parseMode }

    fun captionEntities(captionEntities: List<MessageEntity>) = applySelf { this.captionEntities = captionEntities }

    fun captionEntities(vararg captionEntities: MessageEntity) = captionEntities(captionEntities.toList())

    fun showCaptionAboveMedia(showCaptionAboveMedia: Boolean) = applySelf { this.showCaptionAboveMedia = showCaptionAboveMedia }

    fun replyMarkup(replyMarkup: InlineKeyboardMarkup) = applySelf { this.replyMarkup = replyMarkup }

}
