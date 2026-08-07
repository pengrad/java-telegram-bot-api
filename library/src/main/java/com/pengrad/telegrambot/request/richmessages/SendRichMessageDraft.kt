package com.pengrad.telegrambot.request.richmessages

import com.pengrad.telegrambot.model.request.richmessages.InputRichMessage
import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter
import com.pengrad.telegrambot.utility.richmessages.RichMessageAttachments

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

    private val attachmentNames = mutableSetOf<String>()

    /**
     * Drafts cannot upload new files, but a rich message may still reference already attached
     * thumbnails, so the same collection runs here to keep the payload consistent.
     */
    private fun collectAttachments() =
        RichMessageAttachments.refresh(richMessage, super.getParameters(), attachmentNames)

    override fun isMultipart(): Boolean = collectAttachments()

    override fun getParameters(): MutableMap<String, Any> {
        collectAttachments()
        return super.getParameters()
    }
}
