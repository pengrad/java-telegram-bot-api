package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.model.request.Keyboard
import com.pengrad.telegrambot.model.request.ReplyParameters
import com.pengrad.telegrambot.model.suggestedposts.SuggestedPostParameters
import com.pengrad.telegrambot.response.SendResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter

abstract class AbstractSendRequest<REQ : AbstractSendRequest<REQ>>(
    chatId: Long?,
    channelUsername: String?
) : KBaseRequest<REQ, SendResponse>(SendResponse::class) {

    val chatId: Long? by optionalRequestParameter(chatId, customParameterName = "chat_id")
    val channelUsername: String? by optionalRequestParameter(channelUsername, customParameterName = "chat_id")

    var businessConnectionId: String? by optionalRequestParameter()
    var messageThreadId: Long? by optionalRequestParameter()
    var directMessagesTopicId: Long? by optionalRequestParameter()
    var disableNotification: Boolean? by optionalRequestParameter()
    var protectContent: Boolean? by optionalRequestParameter()
    var allowPaidBroadcast: Boolean? by optionalRequestParameter()
    var messageEffectId: String? by optionalRequestParameter()
    var replyParameters: ReplyParameters? by optionalRequestParameter()
    var replyMarkup: Keyboard? by optionalRequestParameter()
    var suggestedPostParameters: SuggestedPostParameters? by optionalRequestParameter()

    fun businessConnectionId(businessConnectionId: String) = applySelf { this.businessConnectionId = businessConnectionId }

    fun messageThreadId(messageThreadId: Long) = applySelf { this.messageThreadId = messageThreadId }

    fun directMessagesTopicId(directMessagesTopicId: Long) = applySelf { this.directMessagesTopicId = directMessagesTopicId }

    fun disableNotification(disableNotification: Boolean) = applySelf { this.disableNotification = disableNotification }

    fun protectContent(protectContent: Boolean) = applySelf { this.protectContent = protectContent }

    fun allowPaidBroadcast(allowPaidBroadcast: Boolean) = applySelf { this.allowPaidBroadcast = allowPaidBroadcast }

    fun messageEffectId(messageEffectId: String) = applySelf { this.messageEffectId = messageEffectId }

    fun replyParameters(replyParameters: ReplyParameters) = applySelf { this.replyParameters = replyParameters }

    fun replyMarkup(replyMarkup: Keyboard) = applySelf { this.replyMarkup = replyMarkup }

    fun suggestedPostParameters(suggestedPostParameters: SuggestedPostParameters) = applySelf { this.suggestedPostParameters = suggestedPostParameters }

}