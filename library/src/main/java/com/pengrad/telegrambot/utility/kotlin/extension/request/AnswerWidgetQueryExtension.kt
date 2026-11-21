package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.widget.AnswerWidgetQuery
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.answerWidgetQuery(
    widgetQueryId: String,
    modifier: AnswerWidgetQuery.() -> Unit = {}
) = this.execute(AnswerWidgetQuery(widgetQueryId), modifier)
