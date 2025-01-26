package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.model.request.InputMedia
import com.pengrad.telegrambot.request.EditMessageMedia
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.editMessageMedia(
    chatId: Long,
    messageId: Int,
    media: InputMedia<*>,
    modifier: EditMessageMedia.() -> Unit = {}
) = this.execute(EditMessageMedia(chatId, messageId, media), modifier)

inline fun TelegramAware.editMessageMedia(
    chatId: String,
    messageId: Int,
    media: InputMedia<*>,
    modifier: EditMessageMedia.() -> Unit = {}
) = this.execute(EditMessageMedia(chatId, messageId, media), modifier)