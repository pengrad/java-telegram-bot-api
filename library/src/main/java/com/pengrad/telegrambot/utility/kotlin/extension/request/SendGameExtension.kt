package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.SendGame
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.sendGame(
    chatId: Long,
    gameShortName: String,
    modifier: SendGame.() -> Unit = {}
) = this.execute(SendGame(
    chatId = chatId,
    gameShortName = gameShortName
), modifier)

inline fun TelegramAware.sendGame(
    channelUsername: String,
    gameShortName: String,
    modifier: SendGame.() -> Unit = {}
) = this.execute(SendGame(
    channelUsername = channelUsername,
    gameShortName = gameShortName
), modifier)