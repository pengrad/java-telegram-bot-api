package com.pengrad.telegrambot.response

import com.pengrad.telegrambot.model.stars.StarAmount

data class GetMyStarBalanceResponse(val result: StarAmount) : BaseResponse()
