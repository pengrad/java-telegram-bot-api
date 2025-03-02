package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.SendContact
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.sendContact(
    chatId: Long,
    phoneNumber: String,
    firstName: String,
    lastName: String? = null,
    modifier: SendContact.() -> Unit = {}
) = this.execute(SendContact(
    chatId = chatId,
    phoneNumber = phoneNumber,
    firstName = firstName
)) {
    this.lastName = lastName
    modifier()
}

inline fun TelegramAware.sendContact(
    channelUsername: String,
    phoneNumber: String,
    firstName: String,
    lastName: String? = null,
    modifier: SendContact.() -> Unit = {}
) = this.execute(SendContact(
    channelUsername = channelUsername,
    phoneNumber = phoneNumber,
    firstName = firstName
)) {
    this.lastName = lastName
    modifier()
}