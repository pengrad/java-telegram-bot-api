package com.pengrad.telegrambot.request.richmessages

import com.pengrad.telegrambot.model.ephemeral.EphemeralMessageParameters
import com.pengrad.telegrambot.model.request.richmessages.InputRichMessage
import com.pengrad.telegrambot.request.AbstractSendRequest
import com.pengrad.telegrambot.utility.kotlin.checkDeprecatedConstructorParameters
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class SendRichMessage private constructor(
    chatId: Long? = null,
    channelUsername: String? = null,
    richMessage: InputRichMessage
) : AbstractSendRequest<SendRichMessage>(
    chatId = chatId,
    channelUsername = channelUsername
) {

    constructor(chatId: Long, richMessage: InputRichMessage) : this(
        chatId = chatId,
        channelUsername = null,
        richMessage = richMessage
    )

    constructor(channelUsername: String, richMessage: InputRichMessage) : this(
        chatId = null,
        channelUsername = channelUsername,
        richMessage = richMessage
    )

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendRichMessage(chatId, richMessage)"))
    constructor(chatId: Any, richMessage: InputRichMessage) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        richMessage = richMessage
    ) {
        checkDeprecatedConstructorParameters()
    }

    val richMessage: InputRichMessage by requestParameter(richMessage)

    var ephemeralMessageParameters: EphemeralMessageParameters? by optionalRequestParameter()

    fun ephemeralMessageParameters(ephemeralMessageParameters: EphemeralMessageParameters) = applySelf { this.ephemeralMessageParameters = ephemeralMessageParameters }

    private var multipart = false

    init {
        for (media in richMessage.inputMedia()) {
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

    override fun isMultipart() = multipart
}
