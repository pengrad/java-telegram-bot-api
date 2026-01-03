package com.pengrad.telegrambot.response

import com.pengrad.telegrambot.model.gift.owned.OwnedGifts

data class GetUserGiftsResponse(val result: OwnedGifts) : BaseResponse()
