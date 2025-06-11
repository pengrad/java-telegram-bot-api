package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.model.gift.AcceptedGiftTypes
import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class SetBusinessAccountGiftSettings(
    businessConnectionId: String,
    showGiftButton: Boolean,
    acceptedGiftTypes: AcceptedGiftTypes
): KBaseRequest<SetBusinessAccountGiftSettings, BaseResponse>(BaseResponse::class) {

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")
    val showGiftButton: Boolean by requestParameter(showGiftButton, customParameterName = "show_gift_button")
    val acceptedGiftTypes: AcceptedGiftTypes by requestParameter(acceptedGiftTypes, customParameterName = "accepted_gift_types")

}