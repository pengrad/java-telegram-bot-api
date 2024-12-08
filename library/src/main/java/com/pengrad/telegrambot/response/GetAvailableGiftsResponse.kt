package com.pengrad.telegrambot.response

import com.pengrad.telegrambot.model.gift.Gifts

data class GetAvailableGiftsResponse(val result: Gifts) : BaseResponse()
