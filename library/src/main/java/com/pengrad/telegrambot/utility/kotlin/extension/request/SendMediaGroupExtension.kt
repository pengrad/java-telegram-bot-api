package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.model.request.InputMedia
import com.pengrad.telegrambot.request.SendMediaGroup
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.sendMediaGroup(
    chatId: Long,
    media: List<InputMedia<*>>,
    modifier: SendMediaGroup.() -> Unit = {}
) = this.execute(SendMediaGroup(chatId, *media.toTypedArray()), modifier)

inline fun TelegramAware.sendMediaGroup(
    chatId: String,
    media: List<InputMedia<*>>,
    modifier: SendMediaGroup.() -> Unit = {}
) = this.execute(SendMediaGroup(chatId, *media.toTypedArray()), modifier)