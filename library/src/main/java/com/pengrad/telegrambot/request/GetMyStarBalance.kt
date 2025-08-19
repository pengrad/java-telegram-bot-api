package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.response.GetMyStarBalanceResponse

class GetMyStarBalance : KBaseRequest<GetMyStarBalance, GetMyStarBalanceResponse>(
    GetMyStarBalanceResponse::class
)