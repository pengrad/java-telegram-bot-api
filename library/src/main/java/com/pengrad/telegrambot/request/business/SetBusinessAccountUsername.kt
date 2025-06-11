package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class SetBusinessAccountUsername private constructor(
    businessConnectionId: String,
    username: String?
): KBaseRequest<SetBusinessAccountUsername, BaseResponse>(BaseResponse::class) {

    constructor(businessConnectionId: String) : this(
        businessConnectionId = businessConnectionId,
        username = null
    )

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")

    var username: String? by optionalRequestParameter(username, customParameterName = "username")
    fun username(username: String) = applySelf { this.username = username }

}