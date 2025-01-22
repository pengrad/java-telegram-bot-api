package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class EditUserStarSubscription(
    userId: Long,
    telegramPaymentChargeId: String,
    isCanceled: Boolean
) : KBaseRequest<EditUserStarSubscription, BaseResponse>(BaseResponse::class) {

    val userId: Long by requestParameter(userId, customParameterName = "user_id")
    val telegramPaymentChargeId: String by requestParameter(telegramPaymentChargeId, customParameterName = "telegram_payment_charge_id")
    val isCanceled: Boolean by requestParameter(isCanceled, customParameterName = "is_canceled")

}