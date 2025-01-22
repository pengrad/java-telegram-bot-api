package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class SetUserEmojiStatus(
    userId: Long,
    emojiStatusCustomEmojiId: String,
    emojiStatusExpirationDate: Int
) : KBaseRequest<SetUserEmojiStatus, BaseResponse>(BaseResponse::class) {

    val userId: Long by requestParameter(userId, customParameterName = "user_id")
    val emojiStatusCustomEmojiId: String by requestParameter(emojiStatusCustomEmojiId, customParameterName = "emoji_status_custom_emoji_id")
    val emojiStatusExpirationDate: Int by requestParameter(emojiStatusExpirationDate, customParameterName = "emoji_status_expiration_date")

}