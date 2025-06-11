package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.request.business.TransferGift
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class GiftTelegramSubscription private constructor(
    userId: Long,
    monthCount: Int,
    starCount: Int,
    text: String?,
    textParseMode: String?,
    textEntities: Array<MessageEntity>?
): KBaseRequest<GiftTelegramSubscription, BaseResponse>(BaseResponse::class) {

    constructor(userId: Long, monthCount: Int, starCount: Int) : this(
        userId = userId,
        monthCount = monthCount,
        starCount = starCount,
        text = null,
        textParseMode = null,
        textEntities = null
    )

    val userId: Long by requestParameter(userId, customParameterName = "user_id")
    val monthCount: Int by requestParameter(monthCount, customParameterName = "month_count")
    val starCount: Int by requestParameter(starCount, customParameterName = "star_count")

    var text: String? by optionalRequestParameter(text, customParameterName = "text")
    fun text(text: String) = applySelf { this.text = text }

    var textParseMode: String? by optionalRequestParameter(textParseMode, customParameterName = "text_parse_mode")
    fun textParseMode(textParseMode: String) = applySelf { this.textParseMode = textParseMode }

    var textEntities: Array<MessageEntity>? by optionalRequestParameter(textEntities, customParameterName = "text_entities")
    fun textEntities(textEntities: Array<MessageEntity>) = applySelf { this.textEntities = textEntities }

}