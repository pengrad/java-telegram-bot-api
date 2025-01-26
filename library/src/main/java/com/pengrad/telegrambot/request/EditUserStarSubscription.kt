package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class EditUserStarSubscription(
    userId: Long,
    telegramPaymentChargeId: String,
    isCanceled: Boolean
) : KBaseRequest<EditUserStarSubscription, BaseResponse>(BaseResponse::class) {

    val userId: Long by requestParameter(userId)
    val telegramPaymentChargeId: String by requestParameter(telegramPaymentChargeId)
    val isCanceled: Boolean by requestParameter(isCanceled)

}