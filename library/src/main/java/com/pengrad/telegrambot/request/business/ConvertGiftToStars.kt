package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class ConvertGiftToStars(
    businessConnectionId: String,
    ownedGiftId: String
) : KBaseRequest<ConvertGiftToStars, BaseResponse>(BaseResponse::class) {

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")
    val ownedGiftId: String by requestParameter(ownedGiftId, customParameterName = "owned_gift_id")

}