package com.pengrad.telegrambot.request.ephemeral

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class DeleteEphemeralMessage private constructor(
    chatId: Long?,
    channelUsername: String?,
    receiverUserId: Long,
    ephemeralMessageId: Long
) : KBaseRequest<DeleteEphemeralMessage, BaseResponse>(BaseResponse::class) {

    constructor(chatId: Long, receiverUserId: Long, ephemeralMessageId: Long) : this(
        chatId = chatId,
        channelUsername = null,
        receiverUserId = receiverUserId,
        ephemeralMessageId = ephemeralMessageId
    )

    constructor(channelUsername: String, receiverUserId: Long, ephemeralMessageId: Long) : this(
        chatId = null,
        channelUsername = channelUsername,
        receiverUserId = receiverUserId,
        ephemeralMessageId = ephemeralMessageId
    )

    val chatId: Long? by optionalRequestParameter(chatId, customParameterName = "chat_id")
    val channelUsername: String? by optionalRequestParameter(channelUsername, customParameterName = "chat_id")
    val receiverUserId: Long by requestParameter(receiverUserId)
    val ephemeralMessageId: Long by requestParameter(ephemeralMessageId)

}
