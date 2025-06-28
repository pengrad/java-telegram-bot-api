package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class UpgradeGift private constructor(
    businessConnectionId: String,
    ownedGiftId: String,
    keepOriginalDetails: Boolean?,
    starCount: Int?
): KBaseRequest<UpgradeGift, BaseResponse>(BaseResponse::class) {

    constructor(businessConnectionId: String, ownedGiftId: String) : this(
        businessConnectionId = businessConnectionId,
        ownedGiftId = ownedGiftId,
        keepOriginalDetails = null,
        starCount = null
    )

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")
    val ownedGiftId: String by requestParameter(ownedGiftId, customParameterName = "owned_gift_id")

    var keepOriginalDetails: Boolean? by optionalRequestParameter(keepOriginalDetails, customParameterName = "keep_original_details")
    fun keepOriginalDetails(keepOriginalDetails: Boolean) = applySelf { this.keepOriginalDetails = keepOriginalDetails }

    var starCount: Int? by optionalRequestParameter(starCount, customParameterName = "star_count")
    fun starCount(starCount: Int) = applySelf { this.starCount = starCount }

}