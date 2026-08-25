package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.model.request.InputMedia
import com.pengrad.telegrambot.request.ephemeral.EditEphemeralMessageMedia
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.editEphemeralMessageMedia(
    chatId: Long,
    receiverUserId: Long,
    ephemeralMessageId: Long,
    media: InputMedia<*>,
    modifier: EditEphemeralMessageMedia.() -> Unit = {}
) = this.execute(EditEphemeralMessageMedia(chatId, receiverUserId, ephemeralMessageId, media), modifier)

inline fun TelegramAware.editEphemeralMessageMedia(
    channelUsername: String,
    receiverUserId: Long,
    ephemeralMessageId: Long,
    media: InputMedia<*>,
    modifier: EditEphemeralMessageMedia.() -> Unit = {}
) = this.execute(EditEphemeralMessageMedia(channelUsername, receiverUserId, ephemeralMessageId, media), modifier)
