package com.pengrad.telegrambot.request.ephemeral

import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup
import com.pengrad.telegrambot.model.request.InputMedia
import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class EditEphemeralMessageMedia private constructor(
    chatId: Long?,
    channelUsername: String?,
    receiverUserId: Long,
    ephemeralMessageId: Long,
    media: InputMedia<*>
) : KBaseRequest<EditEphemeralMessageMedia, BaseResponse>(BaseResponse::class) {

    constructor(chatId: Long, receiverUserId: Long, ephemeralMessageId: Long, media: InputMedia<*>) : this(
        chatId = chatId,
        channelUsername = null,
        receiverUserId = receiverUserId,
        ephemeralMessageId = ephemeralMessageId,
        media = media
    )

    constructor(channelUsername: String, receiverUserId: Long, ephemeralMessageId: Long, media: InputMedia<*>) : this(
        chatId = null,
        channelUsername = channelUsername,
        receiverUserId = receiverUserId,
        ephemeralMessageId = ephemeralMessageId,
        media = media
    )

    val chatId: Long? by optionalRequestParameter(chatId, customParameterName = "chat_id")
    val channelUsername: String? by optionalRequestParameter(channelUsername, customParameterName = "chat_id")
    val receiverUserId: Long by requestParameter(receiverUserId)
    val ephemeralMessageId: Long by requestParameter(ephemeralMessageId)
    val media: InputMedia<*> by requestParameter(media)

    var replyMarkup: InlineKeyboardMarkup? by optionalRequestParameter()

    private var multipart = false

    init {
        val attachments = media.attachments
        if (attachments != null && attachments.isNotEmpty()) {
            addAll(attachments)
            multipart = true
        }
        media.inputFile()?.let {
            add(media.inputFileId, it)
            multipart = true
        }
    }

    fun replyMarkup(replyMarkup: InlineKeyboardMarkup) = applySelf { this.replyMarkup = replyMarkup }

    override fun isMultipart() = multipart

    override fun getFileName(): String = media.fileName

    override fun getContentType(): String = media.contentType

}
