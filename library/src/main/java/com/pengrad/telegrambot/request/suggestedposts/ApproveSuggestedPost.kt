package com.pengrad.telegrambot.request.suggestedposts

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class ApproveSuggestedPost (
    chatId: Long,
    messageId: Int,
    sendDate: Long?
): KBaseRequest<ApproveSuggestedPost, BaseResponse>(BaseResponse::class) {

    val chatId: Long by requestParameter(chatId)
    val messageId: Int by requestParameter(messageId)

    var sendDate: Long? by optionalRequestParameter(sendDate)

    fun sendDate(sendDate: Long) = applySelf { this.sendDate = sendDate }
}