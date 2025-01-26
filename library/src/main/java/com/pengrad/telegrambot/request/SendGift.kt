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
    val giftId: String by requestParameter(giftId)

    var text: String? by optionalRequestParameter()
    var textParseMode: ParseMode? by optionalRequestParameter(valueMapper = { it?.name })
    var textEntities: Array<MessageEntity>? by optionalRequestParameter()

    fun text(text: String) = apply { this.text = text }

    fun textParseMode(parseMode: ParseMode) = apply { this.textParseMode = textParseMode }

    fun textEntities(textEntities: Array<MessageEntity>) = apply { this.textEntities = textEntities }

}