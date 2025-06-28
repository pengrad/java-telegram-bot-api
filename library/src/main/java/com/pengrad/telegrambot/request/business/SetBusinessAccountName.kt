package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class SetBusinessAccountName private constructor(
    businessConnectionId: String,
    firstName: String,
    lastName: String?
) : KBaseRequest<SetBusinessAccountName, BaseResponse>(BaseResponse::class) {

    constructor(businessConnectionId: String, firstName: String) : this(
        businessConnectionId = businessConnectionId,
        firstName = firstName,
        lastName = null
    )

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")
    val firstName: String by requestParameter(firstName, customParameterName = "first_name")

    var lastName: String? by optionalRequestParameter(lastName, customParameterName = "last_name")
    fun lastName(lastName: String) = applySelf { this.lastName = lastName }

}