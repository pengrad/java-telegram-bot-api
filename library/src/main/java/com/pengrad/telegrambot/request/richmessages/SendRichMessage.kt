package com.pengrad.telegrambot.request.richmessages

import com.pengrad.telegrambot.model.request.richmessages.InputRichMessage
import com.pengrad.telegrambot.request.AbstractSendRequest
import com.pengrad.telegrambot.utility.kotlin.checkDeprecatedConstructorParameters
import com.pengrad.telegrambot.utility.kotlin.requestParameter
import com.pengrad.telegrambot.utility.richmessages.RichMessageAttachments

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

    private val attachmentNames = mutableSetOf<String>()

    /**
     * Attachments are collected on send rather than on construction, so that a rich message
     * populated after the request was built is still uploaded.
     */
    private fun collectAttachments() =
        RichMessageAttachments.refresh(richMessage, super.getParameters(), attachmentNames)

    override fun isMultipart(): Boolean = collectAttachments()

    override fun getParameters(): MutableMap<String, Any> {
        collectAttachments()
        return super.getParameters()
    }
}
