package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.SendDice
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.sendDice(
    chatId: Long,
    emoji: String? = null,
    modifier: SendDice.() -> Unit = {}
) = this.execute(SendDice(
    chatId = chatId
)) {
    this.emoji = emoji
    modifier()
}

inline fun TelegramAware.sendDice(
    channelUsername: String,
    emoji: String? = null,
    modifier: SendDice.() -> Unit = {}
) = this.execute(SendDice(
    channelUsername = channelUsername
)) {
    this.emoji = emoji
    modifier()
}


inline fun TelegramAware.sendDartsDice(
    chatId: Long,
    modifier: SendDice.() -> Unit = {}
) = this.execute(SendDice(
    chatId = chatId
)) {
    this.emoji = SendDice.DARTS_EMOJI
    modifier()
}

inline fun TelegramAware.sendDartsDice(
    channelUsername: String,
    modifier: SendDice.() -> Unit = {}
) = this.execute(SendDice(
    channelUsername = channelUsername
)) {
    this.emoji = SendDice.DARTS_EMOJI
    modifier()
}


inline fun TelegramAware.sendBasketballDice(
    chatId: Long,
    modifier: SendDice.() -> Unit = {}
) = this.execute(SendDice(
    chatId = chatId
)) {
    this.emoji = SendDice.BASKETBALL_EMOJI
    modifier()
}

inline fun TelegramAware.sendBasketballDice(
    channelUsername: String,
    modifier: SendDice.() -> Unit = {}
) = this.execute(SendDice(
    channelUsername = channelUsername
)) {
    this.emoji = SendDice.BASKETBALL_EMOJI
    modifier()
}


inline fun TelegramAware.sendFootballDice(
    chatId: Long,
    modifier: SendDice.() -> Unit = {}
) = this.execute(SendDice(
    chatId = chatId
)) {
    this.emoji = SendDice.FOOTBALL_EMOJI
    modifier()
}

inline fun TelegramAware.sendFootballDice(
    channelUsername: String,
    modifier: SendDice.() -> Unit = {}
) = this.execute(SendDice(
    channelUsername = channelUsername
)) {
    this.emoji = SendDice.FOOTBALL_EMOJI
    modifier()
}


inline fun TelegramAware.sendBowlingDice(
    chatId: Long,
    modifier: SendDice.() -> Unit = {}
) = this.execute(SendDice(
    chatId = chatId
)) {
    this.emoji = SendDice.BOWLING_EMOJI
    modifier()
}

inline fun TelegramAware.sendBowlingDice(
    channelUsername: String,
    modifier: SendDice.() -> Unit = {}
) = this.execute(SendDice(
    channelUsername = channelUsername
)) {
    this.emoji = SendDice.BOWLING_EMOJI
    modifier()
}


inline fun TelegramAware.sendSlotMachineDice(
    chatId: Long,
    modifier: SendDice.() -> Unit = {}
) = this.execute(SendDice(
    chatId = chatId
)) {
    this.emoji = SendDice.SLOT_MACHINE_EMOJI
    modifier()
}

inline fun TelegramAware.sendSlotMachineDice(
    channelUsername: String,
    modifier: SendDice.() -> Unit = {}
) = this.execute(SendDice(
    channelUsername = channelUsername
)) {
    this.emoji = SendDice.SLOT_MACHINE_EMOJI
    modifier()
}