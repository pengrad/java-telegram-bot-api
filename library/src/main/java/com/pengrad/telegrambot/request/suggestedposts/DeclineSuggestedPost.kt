package com.pengrad.telegrambot.request.suggestedposts

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class DeclineSuggestedPost (
    chatId: Long,
    messageId: Int,
    comment: String?
): KBaseRequest<DeclineSuggestedPost, BaseResponse>(BaseResponse::class) {

    val chatId: Long by requestParameter(chatId)
    val messageId: Int by requestParameter(messageId)

    var comment: String? by optionalRequestParameter(comment)

    fun comment(comment: String) = applySelf { this.comment = comment }
}