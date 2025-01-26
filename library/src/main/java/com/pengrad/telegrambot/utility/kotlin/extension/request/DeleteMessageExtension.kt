package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.DeleteMessage
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.deleteMessage(
    chatId: Long,
    messageId: Int,
    modifier: DeleteMessage.() -> Unit = {}
) = this.execute(DeleteMessage(chatId, messageId), modifier)

inline fun TelegramAware.deleteMessage(
    chatId: String,
    messageId: Int,
    modifier: DeleteMessage.() -> Unit = {}
) = this.execute(DeleteMessage(chatId, messageId), modifier)