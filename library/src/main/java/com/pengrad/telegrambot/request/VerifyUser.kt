package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class VerifyUser(
    userId: Long
) : KBaseRequest<VerifyUser, BaseResponse>(BaseResponse::class) {

    val userId: Long by requestParameter(userId)
    var customDescription: String? by optionalRequestParameter()
    var customDescriptionParseMode: ParseMode? by optionalRequestParameter()
    var customDescriptionEntities: List<MessageEntity>? by optionalRequestParameter()

    fun customDescription(customDescription: String) = applySelf { this.customDescription = customDescription }

    fun customDescriptionParseMode(customDescriptionParseMode: ParseMode) = applySelf { this.customDescriptionParseMode = customDescriptionParseMode }

    fun customDescriptionEntities(customDescriptionEntities: List<MessageEntity>) = applySelf { this.customDescriptionEntities = customDescriptionEntities }

    fun customDescriptionEntities(vararg customDescriptionEntities: MessageEntity) = customDescriptionEntities(customDescriptionEntities.toList())

}