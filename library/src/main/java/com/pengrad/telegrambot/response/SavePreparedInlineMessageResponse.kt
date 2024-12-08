package com.pengrad.telegrambot.response

import com.pengrad.telegrambot.model.PreparedInlineMessage

data class SavePreparedInlineMessageResponse(
    val result: PreparedInlineMessage
) : BaseResponse()