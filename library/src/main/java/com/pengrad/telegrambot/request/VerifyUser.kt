package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class VerifyUser(
    userId: Long
) : KBaseRequest<VerifyUser, BaseResponse>(BaseResponse::class) {

    val userId: Long by requestParameter(userId)
    var customDescription: String? by optionalRequestParameter()

    fun customDescription(customDescription: String) = applySelf { this.customDescription = customDescription }

}