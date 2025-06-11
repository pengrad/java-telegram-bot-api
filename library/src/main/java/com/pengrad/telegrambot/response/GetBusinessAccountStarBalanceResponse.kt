package com.pengrad.telegrambot.response

import com.pengrad.telegrambot.model.stars.StarAmount

data class GetBusinessAccountStarBalanceResponse(val result: StarAmount) : BaseResponse()
