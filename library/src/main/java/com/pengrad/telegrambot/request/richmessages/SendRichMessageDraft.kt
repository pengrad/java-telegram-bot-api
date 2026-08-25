package com.pengrad.telegrambot.request.richmessages

import com.pengrad.telegrambot.model.request.richmessages.InputRichMessage
import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class SendRichMessageDraft(
    chatId: Long,
    draftId: Int,
    richMessage: InputRichMessage
) : KBaseRequest<SendRichMessageDraft, BaseResponse>(BaseResponse::class) {

    val chatId: Long by requestParameter(chatId)
    val draftId: Int by requestParameter(draftId)
    val richMessage: InputRichMessage by requestParameter(richMessage)

    var messageThreadId: Long? by optionalRequestParameter()

    fun messageThreadId(messageThreadId: Long) = applySelf { this.messageThreadId = messageThreadId }

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
