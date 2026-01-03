package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class SendMessageDraft(
    chatId: Long,
    draftId: Int,
    text: String
) : KBaseRequest<SendMessageDraft, BaseResponse>(BaseResponse::class) {

    val chatId: Long by requestParameter(chatId)
    val draftId: Int by requestParameter(draftId)
    val text: String by requestParameter(text)

    var messageThreadId: Int? by optionalRequestParameter()
    var parseMode: ParseMode? by optionalRequestParameter()
    var entities: List<MessageEntity>? by optionalRequestParameter()

    fun messageThreadId(messageThreadId: Int) = applySelf { this.messageThreadId = messageThreadId }

    fun parseMode(parseMode: ParseMode) = applySelf { this.parseMode = parseMode }

    fun entities(entities: List<MessageEntity>) = applySelf { this.entities = entities }

}
