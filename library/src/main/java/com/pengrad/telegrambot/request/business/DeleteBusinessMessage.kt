package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class DeleteBusinessMessage(
    businessConnectionId: String,
    messageIds: Array<Int>
) : KBaseRequest<DeleteBusinessMessage, BaseResponse>(BaseResponse::class) {

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")
    val messageIds: Array<Int> by requestParameter(messageIds, customParameterName = "message_ids")

}