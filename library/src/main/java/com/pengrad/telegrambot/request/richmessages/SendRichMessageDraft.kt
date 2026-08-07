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

    /**
     * The draft endpoint cannot upload new files, so the request is never multipart. Media that
     * would need an upload — anything built from a [java.io.File] or a byte array, including
     * thumbnails and covers — is rejected here instead of being sent as an `attach://` reference
     * that Telegram would reject.
     */
    override fun isMultipart(): Boolean {
        require(RichMessageAttachments.collect(richMessage).isEmpty()) {
            "sendRichMessageDraft cannot upload new files; reference media by file_id or URL"
        }
        return false
    }
}
