package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.SendGift
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.sendGift(
    chatId: Long,
    giftId: String,
    modifier: SendGift.() -> Unit = {}
) = this.execute(SendGift(
    chatId = chatId,
    giftId = giftId
), modifier)

inline fun TelegramAware.sendGift(
    channelUsername: String,
    giftId: String,
    modifier: SendGift.() -> Unit = {}
) = this.execute(SendGift(
    channelUsername = channelUsername,
    giftId = giftId
), modifier)