package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.VerifyChat
import com.pengrad.telegrambot.request.VerifyUser
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.verifyChat(
    chatId: Long,
    customDescription: String? = null,
    modifier: VerifyChat.() -> Unit = {}
) = this.execute(VerifyChat(
    chatId = chatId
)) {
    this.customDescription = customDescription
    modifier()
}

inline fun TelegramAware.verifyChat(
    channelUsername: String,
    customDescription: String? = null,
    modifier: VerifyChat.() -> Unit = {}
) = this.execute(VerifyChat(
    channelUsername = channelUsername
)) {
    this.customDescription = customDescription
    modifier()
}