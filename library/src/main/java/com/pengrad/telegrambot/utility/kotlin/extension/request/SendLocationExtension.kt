package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.SendLocation
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.sendLocation(
    chatId: Long,
    latitude: Float,
    longitude: Float,
    modifier: SendLocation.() -> Unit = {}
) = this.execute(SendLocation(
    chatId = chatId,
    latitude = latitude,
    longitude = longitude,
), modifier)

inline fun TelegramAware.sendLocation(
    channelUsername: String,
    latitude: Float,
    longitude: Float,
    modifier: SendLocation.() -> Unit = {}
) = this.execute(SendLocation(
    channelUsername = channelUsername,
    latitude = latitude,
    longitude = longitude,
), modifier)