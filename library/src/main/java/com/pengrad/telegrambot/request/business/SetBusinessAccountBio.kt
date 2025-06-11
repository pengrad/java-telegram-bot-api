package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class SetBusinessAccountBio private constructor(
    businessConnectionId: String,
    bio: String?
): KBaseRequest<SetBusinessAccountBio, BaseResponse>(BaseResponse::class) {

    constructor(businessConnectionId: String) : this(
        businessConnectionId = businessConnectionId,
        bio = null
    )

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")

    var bio: String? by optionalRequestParameter(bio, customParameterName = "bio")
    fun bio(bio: String) = applySelf { this.bio = bio }

}