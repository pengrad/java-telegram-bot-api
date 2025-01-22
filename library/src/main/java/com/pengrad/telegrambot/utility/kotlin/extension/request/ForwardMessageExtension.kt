package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.ForwardMessage
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.forwardMessage(
    chatId: Long,
    fromChatId: Long,
    messageId: Int,
    modifier: ForwardMessage.() -> Unit = {}
) = this.execute(ForwardMessage(chatId, fromChatId, messageId), modifier)

inline fun TelegramAware.forwardMessage(
    chatId: String,
    fromChatId: Long,
    messageId: Int,
    modifier: ForwardMessage.() -> Unit = {}
) = this.execute(ForwardMessage(chatId, fromChatId, messageId), modifier)