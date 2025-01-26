package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.SendMessage
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.sendMessage(
    chatId: Long,
    text: String,
    modifier: SendMessage.() -> Unit = {}
) = this.execute(SendMessage(chatId, text), modifier)

inline fun TelegramAware.sendMessage(
    chatId: String,
    text: String,
    modifier: SendMessage.() -> Unit = {}
) = this.execute(SendMessage(chatId, text), modifier)