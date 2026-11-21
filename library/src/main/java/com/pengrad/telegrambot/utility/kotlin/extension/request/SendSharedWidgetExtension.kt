package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.widget.SendSharedWidget
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.sendSharedWidget(
    chatId: Long,
    widgetId: String,
    modifier: SendSharedWidget.() -> Unit = {}
) = this.execute(SendSharedWidget(
    chatId = chatId,
    widgetId = widgetId
), modifier)

inline fun TelegramAware.sendSharedWidget(
    channelUsername: String,
    widgetId: String,
    modifier: SendSharedWidget.() -> Unit = {}
) = this.execute(SendSharedWidget(
    channelUsername = channelUsername,
    widgetId = widgetId
), modifier)
