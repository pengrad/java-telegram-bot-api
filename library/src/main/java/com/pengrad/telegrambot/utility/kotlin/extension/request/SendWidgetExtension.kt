package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.widget.SendWidget
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.sendWidget(
    chatId: Long,
    html: String,
    modifier: SendWidget.() -> Unit = {}
) = this.execute(SendWidget(
    chatId = chatId,
    html = html
), modifier)

inline fun TelegramAware.sendWidget(
    channelUsername: String,
    html: String,
    modifier: SendWidget.() -> Unit = {}
) = this.execute(SendWidget(
    channelUsername = channelUsername,
    html = html
), modifier)
