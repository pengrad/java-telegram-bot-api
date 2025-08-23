package com.pengrad.telegrambot.response

import com.pengrad.telegrambot.model.Message


data class SendChecklistResponse (val result: Message) : BaseResponse()