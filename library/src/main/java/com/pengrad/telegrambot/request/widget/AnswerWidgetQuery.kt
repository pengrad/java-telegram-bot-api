package com.pengrad.telegrambot.request.widget

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

/**
 * Answers a query from a widget. The query must be answered within 15 seconds.
 */
class AnswerWidgetQuery(
    widgetQueryId: String
) : KBaseRequest<AnswerWidgetQuery, BaseResponse>(BaseResponse::class) {

    val widgetQueryId: String by requestParameter(widgetQueryId)

    var data: String? by optionalRequestParameter()

    fun data(data: String) = applySelf { this.data = data }

}
