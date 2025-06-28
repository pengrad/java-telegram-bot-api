package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class TransferGift private constructor(
    businessConnectionId: String,
    ownedGiftId: String,
    newOwnerChatId: Long,
    starCount: Int?
): KBaseRequest<TransferGift, BaseResponse>(BaseResponse::class) {

    constructor(businessConnectionId: String, ownedGiftId: String, newOwnerChatId: Long) : this(
        businessConnectionId = businessConnectionId,
        ownedGiftId = ownedGiftId,
        newOwnerChatId = newOwnerChatId,
        starCount = null
    )

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")
    val ownedGiftId: String by requestParameter(ownedGiftId, customParameterName = "owned_gift_id")
    val newOwnerChatId: Long by requestParameter(newOwnerChatId, customParameterName = "new_owner_chat_id")

    var starCount: Int? by optionalRequestParameter(starCount, customParameterName = "star_count")
    fun starCount(starCount: Int) = applySelf { this.starCount = starCount }

}