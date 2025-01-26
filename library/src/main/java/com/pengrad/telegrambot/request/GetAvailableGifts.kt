package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.response.GetAvailableGiftsResponse

class GetAvailableGifts : KBaseRequest<GetAvailableGifts, GetAvailableGiftsResponse>(
    GetAvailableGiftsResponse::class
)