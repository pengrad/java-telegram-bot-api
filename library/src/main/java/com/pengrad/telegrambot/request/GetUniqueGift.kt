package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.response.GetUniqueGiftResponse
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class GetUniqueGift(
    name: String
) : KBaseRequest<GetUniqueGift, GetUniqueGiftResponse>(GetUniqueGiftResponse::class) {

    val name: String by requestParameter(name)

}
