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

    val userId: Long by requestParameter(userId, customParameterName = "user_id")
    val result: InlineQueryResult<*> by requestParameter(result)

    var allowUserChats: Boolean? by optionalRequestParameter()
    var allowBotChats: Boolean? by optionalRequestParameter()
    var allowGroupChats: Boolean? by optionalRequestParameter()
    var allowChannelChats: Boolean? by optionalRequestParameter()

    fun allowUserChats(allowUserChats: Boolean) = apply { this.allowUserChats = allowUserChats }

    fun allowBotChats(allowBotChats: Boolean) = apply { this.allowBotChats = allowBotChats }

    fun allowGroupChats(allowGroupChats: Boolean) = apply { this.allowGroupChats = allowGroupChats }

    fun allowChannelChats(allowChannelChats: Boolean) = apply { this.allowChannelChats = allowChannelChats }

}