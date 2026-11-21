package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.widget.EditMessageWidgetData
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.editMessageWidgetData(
    chatId: Long,
    messageId: Int,
    modifier: EditMessageWidgetData.() -> Unit = {}
) = this.execute(EditMessageWidgetData(chatId, messageId), modifier)

inline fun TelegramAware.editMessageWidgetData(
    channelUsername: String,
    messageId: Int,
    modifier: EditMessageWidgetData.() -> Unit = {}
) = this.execute(EditMessageWidgetData(channelUsername, messageId), modifier)

inline fun TelegramAware.editMessageWidgetData(
    inlineMessageId: String,
    modifier: EditMessageWidgetData.() -> Unit = {}
) = this.execute(EditMessageWidgetData(inlineMessageId), modifier)
