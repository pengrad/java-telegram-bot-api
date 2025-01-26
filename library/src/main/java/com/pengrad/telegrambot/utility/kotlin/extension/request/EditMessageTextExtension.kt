package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.EditMessageText
import com.pengrad.telegrambot.utility.kotlin.extension.execute

fun TelegramAware.editMessageText(
    chatId: Long,
    messageId: Int,
    text: String,
    modifier: EditMessageText.() -> Unit = {}
) = this.execute(EditMessageText(chatId, messageId, text), modifier)

fun TelegramAware.editMessageText(
    chatId: String,
    messageId: Int,
    text: String,
    modifier: EditMessageText.() -> Unit = {}
) = this.execute(EditMessageText(chatId, messageId, text), modifier)