package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class RemoveUserVerification(
    userId: Long
) : KBaseRequest<RemoveUserVerification, BaseResponse>(BaseResponse::class) {

    val userId: Long by requestParameter(userId)

}