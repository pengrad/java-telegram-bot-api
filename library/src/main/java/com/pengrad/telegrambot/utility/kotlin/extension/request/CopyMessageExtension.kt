package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.CopyMessage
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.copyMessage(
    chatId: Long,
    fromChatId: Long,
    messageId: Int,
    modifier: CopyMessage.() -> Unit = {}
) = this.execute(CopyMessage(
    chatId = chatId,
    fromChatId = fromChatId,
    messageId = messageId
), modifier)

inline fun TelegramAware.copyMessage(
    channelUsername: String,
    fromChatId: Long,
    messageId: Int,
    modifier: CopyMessage.() -> Unit = {}
) = this.execute(CopyMessage(
    channelUsername = channelUsername,
    fromChatId = fromChatId,
    messageId = messageId
), modifier)

inline fun TelegramAware.copyMessage(
    chatId: Long,
    fromChannelUsername: String,
    messageId: Int,
    modifier: CopyMessage.() -> Unit = {}
) = this.execute(CopyMessage(
    chatId = chatId,
    fromChannelUsername = fromChannelUsername,
    messageId = messageId
), modifier)

inline fun TelegramAware.copyMessage(
    channelUsername: String,
    fromChannelUsername: String,
    messageId: Int,
    modifier: CopyMessage.() -> Unit = {}
) = this.execute(CopyMessage(
    channelUsername = channelUsername,
    fromChannelUsername = fromChannelUsername,
    messageId = messageId
), modifier)