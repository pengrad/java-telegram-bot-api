package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup
import com.pengrad.telegrambot.request.ephemeral.EditEphemeralMessageReplyMarkup
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.editEphemeralMessageReplyMarkup(
    chatId: Long,
    receiverUserId: Long,
    ephemeralMessageId: Long,
    modifier: EditEphemeralMessageReplyMarkup.() -> Unit = {}
) = this.execute(EditEphemeralMessageReplyMarkup(chatId, receiverUserId, ephemeralMessageId), modifier)

inline fun TelegramAware.editEphemeralMessageReplyMarkup(
    channelUsername: String,
    receiverUserId: Long,
    ephemeralMessageId: Long,
    modifier: EditEphemeralMessageReplyMarkup.() -> Unit = {}
) = this.execute(EditEphemeralMessageReplyMarkup(channelUsername, receiverUserId, ephemeralMessageId), modifier)

inline fun TelegramAware.removeEphemeralInlineKeyboard(
    chatId: Long,
    receiverUserId: Long,
    ephemeralMessageId: Long,
    modifier: EditEphemeralMessageReplyMarkup.() -> Unit = {}
) = this.editEphemeralMessageReplyMarkup(chatId, receiverUserId, ephemeralMessageId) {
    replyMarkup(InlineKeyboardMarkup())
    modifier()
}

inline fun TelegramAware.removeEphemeralInlineKeyboard(
    channelUsername: String,
    receiverUserId: Long,
    ephemeralMessageId: Long,
    modifier: EditEphemeralMessageReplyMarkup.() -> Unit = {}
) = this.editEphemeralMessageReplyMarkup(channelUsername, receiverUserId, ephemeralMessageId) {
    replyMarkup(InlineKeyboardMarkup())
    modifier()
}
