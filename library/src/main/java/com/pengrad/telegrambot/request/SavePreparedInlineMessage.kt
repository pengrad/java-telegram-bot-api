package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.model.request.InlineQueryResult
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.response.SavePreparedInlineMessageResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class SavePreparedInlineMessage(
    userId: Long,
    result: InlineQueryResult<*>
) : KBaseRequest<SavePreparedInlineMessage, SavePreparedInlineMessageResponse>(
    SavePreparedInlineMessageResponse::class
) {

    val userId: Long by requestParameter(userId)
    val result: InlineQueryResult<*> by requestParameter(result)

    var allowUserChats: Boolean? by optionalRequestParameter(customParameterName = "allow_user_chats")
    var allowBotChats: Boolean? by optionalRequestParameter(customParameterName = "allow_bot_chats")
    var allowGroupChats: Boolean? by optionalRequestParameter(customParameterName = "allow_group_chats")
    var allowChannelChats: Boolean? by optionalRequestParameter(customParameterName = "allow_channel_chats")

    fun allowUserChats(allowUserChats: Boolean) = apply { this.allowUserChats = allowUserChats }

    fun allowBotChats(allowBotChats: Boolean) = apply { this.allowBotChats = allowBotChats }

    fun allowGroupChats(allowGroupChats: Boolean) = apply { this.allowGroupChats = allowGroupChats }

    fun allowChannelChats(allowChannelChats: Boolean) = apply { this.allowChannelChats = allowChannelChats }

}