package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.requestParameter

/**
 * Deletes a regular gift owned by a managed business account without receiving Telegram Stars for it.
 * Requires the can_convert_gifts_to_stars business bot right.
 */
class DeleteBusinessAccountGift(
    businessConnectionId: String,
    ownedGiftId: String
) : KBaseRequest<DeleteBusinessAccountGift, BaseResponse>(BaseResponse::class) {

    val businessConnectionId: String by requestParameter(businessConnectionId)
    val ownedGiftId: String by requestParameter(ownedGiftId)

}
