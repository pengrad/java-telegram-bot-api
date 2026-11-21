package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.widget.EditSharedWidgetData
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.editSharedWidgetData(
    widgetId: String,
    publicData: String,
    modifier: EditSharedWidgetData.() -> Unit = {}
) = this.execute(EditSharedWidgetData(widgetId, publicData), modifier)
