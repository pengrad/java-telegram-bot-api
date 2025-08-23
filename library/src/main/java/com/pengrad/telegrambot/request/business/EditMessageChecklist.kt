package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.model.checklist.InputChecklist
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup
import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.EditMessageChecklistResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class EditMessageChecklist (
    businessConnectionId: String,
    chatId: Long,
    messageId: Int,
    checklist: InputChecklist,
    replyMarkup: InlineKeyboardMarkup?

): KBaseRequest<EditMessageChecklist, EditMessageChecklistResponse>(EditMessageChecklistResponse::class) {

    constructor(businessConnectionId: String, chatId: Long, messageId: Int, checklist: InputChecklist) : this(
        businessConnectionId = businessConnectionId,
        chatId = chatId,
        messageId = messageId,
        checklist = checklist,
        replyMarkup = null
    )

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")
    val chatId: Long by requestParameter(chatId, customParameterName = "chat_id")
    val messageId: Int by requestParameter(messageId, customParameterName = "message_id")
    val checklist: InputChecklist by requestParameter(checklist, customParameterName = "checklist")

    var replyMarkup: InlineKeyboardMarkup? by optionalRequestParameter(replyMarkup, customParameterName = "reply_markup")
    fun replyMarkup(replyMarkup: InlineKeyboardMarkup) = applySelf { this.replyMarkup = replyMarkup }

}