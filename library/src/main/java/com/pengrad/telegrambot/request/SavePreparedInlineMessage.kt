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

    @set:JvmName("allowUserChats") var allowUserChats: Boolean? by optionalRequestParameter(customParameterName = "allow_user_chats")
    @set:JvmName("allowBotChats") var allowBotChats: Boolean? by optionalRequestParameter(customParameterName = "allow_bot_chats")
    @set:JvmName("allowGroupChats") var allowGroupChats: Boolean? by optionalRequestParameter(customParameterName = "allow_group_chats")
    @set:JvmName("allowChannelChats") var allowChannelChats: Boolean? by optionalRequestParameter(customParameterName = "allow_channel_chats")

}