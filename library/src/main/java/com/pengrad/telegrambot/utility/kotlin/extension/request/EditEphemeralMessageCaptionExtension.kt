package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.ephemeral.EditEphemeralMessageCaption
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.editEphemeralMessageCaption(
    chatId: Long,
    receiverUserId: Long,
    ephemeralMessageId: Long,
    caption: String,
    modifier: EditEphemeralMessageCaption.() -> Unit = {}
) = this.execute(EditEphemeralMessageCaption(chatId, receiverUserId, ephemeralMessageId)) {
    caption(caption)
    modifier()
}

inline fun TelegramAware.editEphemeralMessageCaption(
    channelUsername: String,
    receiverUserId: Long,
    ephemeralMessageId: Long,
    caption: String,
    modifier: EditEphemeralMessageCaption.() -> Unit = {}
) = this.execute(EditEphemeralMessageCaption(channelUsername, receiverUserId, ephemeralMessageId)) {
    caption(caption)
    modifier()
}
