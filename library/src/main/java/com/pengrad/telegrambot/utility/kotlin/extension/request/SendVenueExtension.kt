package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.SendVenue
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.sendVenue(
    chatId: Long,
    latitude: Float,
    longitude: Float,
    title: String,
    address: String,
    modifier: SendVenue.() -> Unit = {}
) = this.execute(SendVenue(
    chatId = chatId,
    latitude = latitude,
    longitude = longitude,
    title = title,
    address = address,
), modifier)

inline fun TelegramAware.sendVenue(
    channelUsername: String,
    latitude: Float,
    longitude: Float,
    title: String,
    address: String,
    modifier: SendVenue.() -> Unit = {}
) = this.execute(SendVenue(
    channelUsername = channelUsername,
    latitude = latitude,
    longitude = longitude,
    title = title,
    address = address,
), modifier)