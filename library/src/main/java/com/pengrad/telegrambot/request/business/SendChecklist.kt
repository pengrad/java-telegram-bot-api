package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.model.checklist.InputChecklist
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup
import com.pengrad.telegrambot.model.request.ReplyParameters
import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.SendChecklistResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class SendChecklist (
    businessConnectionId: String,
    chatId: Long,
    checklist: InputChecklist,
    disableNotification: Boolean?,
    protectContent: Boolean?,
    messageEffectId: String?,
    replyParameters: ReplyParameters?,
    replyMarkup: InlineKeyboardMarkup?

): KBaseRequest<SendChecklist, SendChecklistResponse>(SendChecklistResponse::class) {

    constructor(businessConnectionId: String, chatId: Long, checklist: InputChecklist) : this(
        businessConnectionId = businessConnectionId,
        chatId = chatId,
        checklist = checklist,
        disableNotification = null,
        protectContent = null,
        messageEffectId = null,
        replyParameters = null,
        replyMarkup = null
    )

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")
    val chatId: Long by requestParameter(chatId, customParameterName = "chat_id")
    val checklist: InputChecklist by requestParameter(checklist, customParameterName = "checklist")

    var disableNotification: Boolean? by optionalRequestParameter(disableNotification, customParameterName = "disable_notification")
    fun disableNotification(disableNotification: Boolean) = applySelf { this.disableNotification = disableNotification }

    var protectContent: Boolean? by optionalRequestParameter(protectContent, customParameterName = "protect_content")
    fun protectContent(protectContent: Boolean) = applySelf { this.protectContent = protectContent }

    var messageEffectId: String? by optionalRequestParameter(messageEffectId, customParameterName = "message_effect_id")
    fun messageEffectId(messageEffectId: String) = applySelf { this.messageEffectId = messageEffectId }

    var replyParameters: ReplyParameters? by optionalRequestParameter(replyParameters, customParameterName = "reply_parameters")
    fun replyParameters(replyParameters: ReplyParameters) = applySelf { this.replyParameters = replyParameters }

    var replyMarkup: InlineKeyboardMarkup? by optionalRequestParameter(replyMarkup, customParameterName = "reply_markup")
    fun replyMarkup(replyMarkup: InlineKeyboardMarkup) = applySelf { this.replyMarkup = replyMarkup }

}