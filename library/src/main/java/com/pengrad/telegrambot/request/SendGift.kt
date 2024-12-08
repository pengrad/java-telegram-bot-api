package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class SendGift(
    userId: Long,
    giftId: String,
) : KBaseRequest<SendGift, BaseResponse>(BaseResponse::class) {

    val userId: Long by requestParameter(userId)
    val giftId: String by requestParameter(giftId, customParameterName = "gift_id")

    @set:JvmName("text") var text: String? by optionalRequestParameter()
    @set:JvmName("textParseMode") var textParseMode: ParseMode? by optionalRequestParameter(
        customParameterName = "text_parse_mode",
        valueMapper = { it?.name }
    )
    @set:JvmName("textEntities") var textEntities: Array<MessageEntity>? by optionalRequestParameter(customParameterName = "text_entities")

}