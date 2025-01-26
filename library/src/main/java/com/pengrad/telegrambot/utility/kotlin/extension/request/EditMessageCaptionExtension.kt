package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.EditMessageCaption
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.editMessageCaption(
    chatId: Long,
    messageId: Int,
    caption: String,
    modifier: EditMessageCaption.() -> Unit = {}
) = this.execute(EditMessageCaption(chatId, messageId)) {
    caption(caption)
    modifier()
}

inline fun TelegramAware.editMessageCaption(
    chatId: String,
    messageId: Int,
    caption: String,
    modifier: EditMessageCaption.() -> Unit = {}
) = this.execute(EditMessageCaption(chatId, messageId)) {
    caption(caption)
    modifier()
}