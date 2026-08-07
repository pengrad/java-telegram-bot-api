package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.model.request.richmessages.InputRichMessage
import com.pengrad.telegrambot.request.richmessages.SendRichMessage
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.sendRichMessage(
    chatId: Long,
    richMessage: InputRichMessage,
    modifier: SendRichMessage.() -> Unit = {}
) = this.execute(SendRichMessage(
    chatId = chatId,
    richMessage = richMessage
), modifier)

inline fun TelegramAware.sendRichMessage(
    channelUsername: String,
    richMessage: InputRichMessage,
    modifier: SendRichMessage.() -> Unit = {}
) = this.execute(SendRichMessage(
    channelUsername = channelUsername,
    richMessage = richMessage
), modifier)
