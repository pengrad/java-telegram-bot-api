package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.AnswerCallbackQuery
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.answerCallbackQuery(
    callbackQueryId: String,
    modifier: AnswerCallbackQuery.() -> Unit = {}
) = this.execute(AnswerCallbackQuery(callbackQueryId), modifier)