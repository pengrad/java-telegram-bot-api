package com.pengrad.telegrambot.utility.kotlin.extension

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.BaseRequest
import com.pengrad.telegrambot.response.BaseResponse

inline fun <T : BaseRequest<T, R>, R : BaseResponse> TelegramAware.execute(
    request: T,
    modifier: T.() -> Unit = {}
): R = execute(request.apply(modifier))