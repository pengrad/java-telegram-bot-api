package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup
import com.pengrad.telegrambot.request.EditMessageReplyMarkup
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.editMessageReplyMarkup(
    chatId: Long,
    messageId: Int,
    modifier: EditMessageReplyMarkup.() -> Unit = {}
) = this.execute(EditMessageReplyMarkup(chatId, messageId), modifier)

inline fun TelegramAware.editMessageReplyMarkup(
    chatId: String,
    messageId: Int,
    modifier: EditMessageReplyMarkup.() -> Unit = {}
) = this.execute(EditMessageReplyMarkup(chatId, messageId), modifier)

inline fun TelegramAware.removeInlineKeyboard(
    chatId: Long,
    messageId: Int,
    modifier: EditMessageReplyMarkup.() -> Unit = {}
) = this.editMessageReplyMarkup(chatId, messageId) {
    replyMarkup(InlineKeyboardMarkup())
    modifier()
}

inline fun TelegramAware.removeInlineKeyboard(
    chatId: String,
    messageId: Int,
    modifier: EditMessageReplyMarkup.() -> Unit = {}
) = this.editMessageReplyMarkup(chatId, messageId) {
    replyMarkup(InlineKeyboardMarkup())
    modifier()
}