package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.RemoveChatVerification
import com.pengrad.telegrambot.request.RemoveUserVerification
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.removeChatVerification(
    chatId: Long,
    modifier: RemoveChatVerification.() -> Unit = {}
) = this.execute(RemoveChatVerification(
    chatId = chatId
), modifier)

inline fun TelegramAware.removeChatVerification(
    channelUsername: String,
    modifier: RemoveChatVerification.() -> Unit = {}
) = this.execute(RemoveChatVerification(
    channelUsername = channelUsername
), modifier)