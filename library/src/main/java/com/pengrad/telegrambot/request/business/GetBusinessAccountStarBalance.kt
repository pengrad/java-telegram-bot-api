package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.GetBusinessAccountStarBalanceResponse
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class GetBusinessAccountStarBalance(
    businessConnectionId: String
): KBaseRequest<GetBusinessAccountStarBalance, GetBusinessAccountStarBalanceResponse>(GetBusinessAccountStarBalanceResponse::class) {

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")
}