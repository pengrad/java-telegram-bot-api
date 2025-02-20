package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class RemoveChatVerification(
    chatId: Long?,
    channelUsername: String?
) : KBaseRequest<RemoveChatVerification, BaseResponse>(BaseResponse::class) {

    constructor(chatId: Long) : this(
        chatId = chatId,
        channelUsername = null
    )

    constructor(channelUsername: String) : this(
        chatId = null,
        channelUsername = channelUsername
    )

    val chatId: Long? by optionalRequestParameter(chatId, customParameterName = "chat_id")
    val channelUsername: String? by optionalRequestParameter(channelUsername, customParameterName = "chat_id")

}