package com.pengrad.telegrambot.request.widget

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.BaseResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

/**
 * Edits public data of a shared widget created by the bot. Pass an empty string to remove the public data.
 */
class EditSharedWidgetData(
    widgetId: String,
    publicData: String
) : KBaseRequest<EditSharedWidgetData, BaseResponse>(BaseResponse::class) {

    val widgetId: String by requestParameter(widgetId)
    val publicData: String by requestParameter(publicData)

    var cacheTime: Int? by optionalRequestParameter()

    fun cacheTime(cacheTime: Int) = applySelf { this.cacheTime = cacheTime }

}
