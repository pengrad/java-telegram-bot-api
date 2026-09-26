package com.pengrad.telegrambot.request.ephemeral

import com.pengrad.telegrambot.model.LinkPreviewOptions
import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup
import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.model.request.richmessages.InputRichMessage
import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class EditEphemeralMessageText private constructor(
    chatId: Long?,
    channelUsername: String?,
    receiverUserId: Long,
    ephemeralMessageId: Long,
    text: String?,
    richMessage: InputRichMessage?
) : KBaseRequest<EditEphemeralMessageText, BaseResponse>(BaseResponse::class) {

    constructor(chatId: Long, receiverUserId: Long, ephemeralMessageId: Long, text: String) : this(
        chatId = chatId,
        channelUsername = null,
        receiverUserId = receiverUserId,
        ephemeralMessageId = ephemeralMessageId,
        text = text,
        richMessage = null
    )

    constructor(channelUsername: String, receiverUserId: Long, ephemeralMessageId: Long, text: String) : this(
        chatId = null,
        channelUsername = channelUsername,
        receiverUserId = receiverUserId,
        ephemeralMessageId = ephemeralMessageId,
        text = text,
        richMessage = null
    )

    constructor(chatId: Long, receiverUserId: Long, ephemeralMessageId: Long, richMessage: InputRichMessage) : this(
        chatId = chatId,
        channelUsername = null,
        receiverUserId = receiverUserId,
        ephemeralMessageId = ephemeralMessageId,
        text = null,
        richMessage = richMessage
    )

    constructor(channelUsername: String, receiverUserId: Long, ephemeralMessageId: Long, richMessage: InputRichMessage) : this(
        chatId = null,
        channelUsername = channelUsername,
        receiverUserId = receiverUserId,
        ephemeralMessageId = ephemeralMessageId,
        text = null,
        richMessage = richMessage
    )

    val chatId: Long? by optionalRequestParameter(chatId, customParameterName = "chat_id")
    val channelUsername: String? by optionalRequestParameter(channelUsername, customParameterName = "chat_id")
    val receiverUserId: Long by requestParameter(receiverUserId)
    val ephemeralMessageId: Long by requestParameter(ephemeralMessageId)
    val text: String? by optionalRequestParameter(text)
    val richMessage: InputRichMessage? by optionalRequestParameter(richMessage)

    var parseMode: ParseMode? by optionalRequestParameter()
    var entities: List<MessageEntity>? by optionalRequestParameter()
    var linkPreviewOptions: LinkPreviewOptions? by optionalRequestParameter()
    var replyMarkup: InlineKeyboardMarkup? by optionalRequestParameter()

    private var multipart = false

    init {
        richMessage?.inputMedia()?.forEach { media ->
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
    }

    fun parseMode(parseMode: ParseMode) = applySelf { this.parseMode = parseMode }

    fun entities(entities: List<MessageEntity>) = applySelf { this.entities = entities }

    fun entities(vararg entities: MessageEntity) = entities(entities.toList())

    fun linkPreviewOptions(linkPreviewOptions: LinkPreviewOptions) = applySelf { this.linkPreviewOptions = linkPreviewOptions }

    fun replyMarkup(replyMarkup: InlineKeyboardMarkup) = applySelf { this.replyMarkup = replyMarkup }

    override fun isMultipart() = multipart

}
