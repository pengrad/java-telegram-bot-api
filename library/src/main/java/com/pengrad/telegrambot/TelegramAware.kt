package com.pengrad.telegrambot

import com.pengrad.telegrambot.request.BaseRequest
import com.pengrad.telegrambot.response.BaseResponse

interface TelegramAware {

    fun <REQ : BaseRequest<REQ, RES>, RES : BaseResponse> execute(request: BaseRequest<REQ, RES>): RES

}