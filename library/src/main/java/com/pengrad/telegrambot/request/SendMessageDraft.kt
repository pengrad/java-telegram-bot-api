package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class SendMessageDraft(
    chatId: Long,
    draftId: Int,
) : KBaseRequest<SendMessageDraft, BaseResponse>(BaseResponse::class) {

    constructor(chatId: Long, draftId: Int, text: String) : this(chatId, draftId) {
        this.text = text
    }

    val chatId: Long by requestParameter(chatId)
    val draftId: Int by requestParameter(draftId)

    var text: String? by optionalRequestParameter()
    var messageThreadId: Long? by optionalRequestParameter()
    var parseMode: ParseMode? by optionalRequestParameter()
    var entities: List<MessageEntity>? by optionalRequestParameter()
    var canStop: Boolean? by optionalRequestParameter()
    var keepOnStop: Boolean? by optionalRequestParameter()

    fun text(text: String) = applySelf { this.text = text }

    fun messageThreadId(messageThreadId: Long) = applySelf { this.messageThreadId = messageThreadId }

    fun parseMode(parseMode: ParseMode) = applySelf { this.parseMode = parseMode }

    fun entities(entities: List<MessageEntity>) = applySelf { this.entities = entities }

    fun canStop(canStop: Boolean) = applySelf { this.canStop = canStop }

    fun keepOnStop(keepOnStop: Boolean) = applySelf { this.keepOnStop = keepOnStop }

}
