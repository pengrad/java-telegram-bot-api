package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.GetChat
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.getChat(
    chatId: Long,
    modifier: GetChat.() -> Unit = {}
) = this.execute(GetChat(chatId), modifier)

inline fun TelegramAware.getChat(
    chatId: String,
    modifier: GetChat.() -> Unit = {}
) = this.execute(GetChat(chatId), modifier)