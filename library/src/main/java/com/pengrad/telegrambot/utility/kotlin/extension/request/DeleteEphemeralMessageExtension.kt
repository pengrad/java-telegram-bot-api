package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.ephemeral.DeleteEphemeralMessage
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.deleteEphemeralMessage(
    chatId: Long,
    receiverUserId: Long,
    ephemeralMessageId: Long,
    modifier: DeleteEphemeralMessage.() -> Unit = {}
) = this.execute(DeleteEphemeralMessage(chatId, receiverUserId, ephemeralMessageId), modifier)

inline fun TelegramAware.deleteEphemeralMessage(
    channelUsername: String,
    receiverUserId: Long,
    ephemeralMessageId: Long,
    modifier: DeleteEphemeralMessage.() -> Unit = {}
) = this.execute(DeleteEphemeralMessage(channelUsername, receiverUserId, ephemeralMessageId), modifier)
