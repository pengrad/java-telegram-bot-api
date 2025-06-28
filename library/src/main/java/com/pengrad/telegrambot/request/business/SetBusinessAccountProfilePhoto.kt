package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.model.inputprofilephoto.InputProfilePhoto
import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class SetBusinessAccountProfilePhoto private constructor(
    businessConnectionId: String,
    photo: InputProfilePhoto,
    isPublic: Boolean?
) : KBaseRequest<SetBusinessAccountProfilePhoto, BaseResponse>(BaseResponse::class) {

    constructor(businessConnectionId: String, photo: InputProfilePhoto) : this(
        businessConnectionId = businessConnectionId,
        photo = photo,
        isPublic = null
    )

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")
    val photo: InputProfilePhoto by requestParameter(photo, customParameterName = "photo")

    var isPublic: Boolean? by optionalRequestParameter(isPublic, customParameterName = "is_public")
    fun isPublic(isPublic: Boolean) = applySelf { this.isPublic = isPublic }

}