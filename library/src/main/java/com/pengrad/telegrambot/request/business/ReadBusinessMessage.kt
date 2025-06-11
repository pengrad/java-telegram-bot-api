package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class ReadBusinessMessage(
    businessConnectionId: String,
    chatId: Long,
    messageId: Int
) : KBaseRequest<ReadBusinessMessage, BaseResponse>(BaseResponse::class) {

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")
    val chatId: Long by requestParameter(chatId, customParameterName = "chat_id")
    val messageId: Int by requestParameter(messageId, customParameterName = "message_id")

}