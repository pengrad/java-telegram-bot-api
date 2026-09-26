package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.model.request.richmessages.InputRichMessage
import com.pengrad.telegrambot.request.ephemeral.EditEphemeralMessageText
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.editEphemeralMessageText(
    chatId: Long,
    receiverUserId: Long,
    ephemeralMessageId: Long,
    text: String,
    modifier: EditEphemeralMessageText.() -> Unit = {}
) = this.execute(EditEphemeralMessageText(chatId, receiverUserId, ephemeralMessageId, text), modifier)

inline fun TelegramAware.editEphemeralMessageText(
    channelUsername: String,
    receiverUserId: Long,
    ephemeralMessageId: Long,
    text: String,
    modifier: EditEphemeralMessageText.() -> Unit = {}
) = this.execute(EditEphemeralMessageText(channelUsername, receiverUserId, ephemeralMessageId, text), modifier)

inline fun TelegramAware.editEphemeralMessageText(
    chatId: Long,
    receiverUserId: Long,
    ephemeralMessageId: Long,
    richMessage: InputRichMessage,
    modifier: EditEphemeralMessageText.() -> Unit = {}
) = this.execute(EditEphemeralMessageText(chatId, receiverUserId, ephemeralMessageId, richMessage), modifier)

inline fun TelegramAware.editEphemeralMessageText(
    channelUsername: String,
    receiverUserId: Long,
    ephemeralMessageId: Long,
    richMessage: InputRichMessage,
    modifier: EditEphemeralMessageText.() -> Unit = {}
) = this.execute(EditEphemeralMessageText(channelUsername, receiverUserId, ephemeralMessageId, richMessage), modifier)
