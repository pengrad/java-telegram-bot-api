package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class VerifyChat private constructor(
    chatId: Long?,
    channelUsername: String?
) : KBaseRequest<VerifyChat, BaseResponse>(BaseResponse::class) {

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

    var customDescription: String? by optionalRequestParameter()

    fun customDescription(customDescription: String) = applySelf { this.customDescription = customDescription }

}