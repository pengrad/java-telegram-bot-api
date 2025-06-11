package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class TransferBusinessAccountStars(
    businessConnectionId: String,
    starCount: Int
): KBaseRequest<TransferBusinessAccountStars, BaseResponse>(BaseResponse::class) {

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")
    val starCount: Int by requestParameter(starCount, customParameterName = "star_count")

}