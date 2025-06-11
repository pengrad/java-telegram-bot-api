package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class RemoveBusinessAccountProfilePhoto private constructor(
    businessConnectionId: String,
    isPublic: Boolean?
) : KBaseRequest<RemoveBusinessAccountProfilePhoto, BaseResponse>(BaseResponse::class) {

    constructor(businessConnectionId: String) : this(
        businessConnectionId = businessConnectionId,
        isPublic = null
    )

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")

    var isPublic: Boolean? by optionalRequestParameter(isPublic, customParameterName = "is_public")
    fun isPublic(isPublic: Boolean) = applySelf { this.isPublic = isPublic }

}