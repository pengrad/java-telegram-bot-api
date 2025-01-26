package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.AnswerPreCheckoutQuery
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.answerPreCheckoutQuery(
    preCheckoutId: String,
    modifier: AnswerPreCheckoutQuery.() -> Unit = {}
) = this.execute(AnswerPreCheckoutQuery(preCheckoutId), modifier)

inline fun TelegramAware.answerPreCheckoutQuery(
    preCheckoutId: String,
    errorMessage: String,
    modifier: AnswerPreCheckoutQuery.() -> Unit = {}
) = this.execute(AnswerPreCheckoutQuery(preCheckoutId, errorMessage), modifier)