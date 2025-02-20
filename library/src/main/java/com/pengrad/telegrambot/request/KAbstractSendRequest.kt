package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.model.request.Keyboard
import com.pengrad.telegrambot.model.request.ReplyParameters
import com.pengrad.telegrambot.response.SendResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter

abstract class KAbstractSendRequest<REQ : KAbstractSendRequest<REQ>>(
    chatId: Long?,
    channelUsername: String?
) : KBaseRequest<REQ, SendResponse>(SendResponse::class) {

    val chatId: Long? by optionalRequestParameter(chatId, customParameterName = "chat_id")
    val channelUsername: String? by optionalRequestParameter(channelUsername, customParameterName = "chat_id")

    var businessConnectionId: String? by optionalRequestParameter()
    var messageThreadId: Int? by optionalRequestParameter()
    var disableNotification: Boolean? by optionalRequestParameter()
    var protectContent: Boolean? by optionalRequestParameter()
    var allowPaidBroadcast: Boolean? by optionalRequestParameter()
    var messageEffectId: String? by optionalRequestParameter()
    var replyParameters: ReplyParameters? by optionalRequestParameter()
    @Deprecated("Use replyParameters instead")
    private var replyToMessageId: Int? by optionalRequestParameter()
    @Deprecated("Use replyParameters instead")
    private var allowSendingWithoutReply: Boolean? by optionalRequestParameter()
    var replyMarkup: Keyboard? by optionalRequestParameter()

    fun businessConnectionId(businessConnectionId: String) = applySelf { this.businessConnectionId = businessConnectionId }

    fun messageThreadId(messageThreadId: Int) = applySelf { this.messageThreadId = messageThreadId }

    fun disableNotification(disableNotification: Boolean) = applySelf { this.disableNotification = disableNotification }

    fun protectContent(protectContent: Boolean) = applySelf { this.protectContent = protectContent }

    fun allowPaidBroadcast(allowPaidBroadcast: Boolean) = applySelf { this.allowPaidBroadcast = allowPaidBroadcast }

    fun messageEffectId(messageEffectId: String) = applySelf { this.messageEffectId = messageEffectId }

    fun replyParameters(replyParameters: ReplyParameters) = applySelf { this.replyParameters = replyParameters }

    @Suppress("DEPRECATION")
    @Deprecated(
        message = "Use replyParameters instead",
        ReplaceWith(
            expression = "replyParameters(ReplyParameters(replyToMessageId))",
            imports = ["com.pengrad.telegrambot.model.request.ReplyParameters"]
        )
    )
    fun replyToMessageId(replyToMessageId: Int) = applySelf { this.replyToMessageId = replyToMessageId }

    @Suppress("DEPRECATION")
    @Deprecated(
        message = "Use replyParameters instead",
        ReplaceWith(
            expression = "replyParameters(ReplyParameters(messageId).allowSendingWithoutReply(allowSendingWithoutReply))",
            imports = ["com.pengrad.telegrambot.model.request.ReplyParameters"]
        )
    )
    fun allowSendingWithoutReply(allowSendingWithoutReply: Boolean) = applySelf { this.allowSendingWithoutReply = allowSendingWithoutReply }

    fun replyMarkup(replyMarkup: Keyboard) = applySelf { this.replyMarkup = replyMarkup }

}