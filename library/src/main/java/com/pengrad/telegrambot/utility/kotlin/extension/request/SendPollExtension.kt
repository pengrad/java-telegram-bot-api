package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.model.request.InputPollOption
import com.pengrad.telegrambot.request.SendPoll
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.sendPoll(
    chatId: Long,
    question: String,
    options: List<InputPollOption>,
    modifier: SendPoll.() -> Unit = {}
) = this.execute(SendPoll(
    chatId = chatId,
    question = question,
    options = options
), modifier)

inline fun TelegramAware.sendPoll(
    chatId: Long,
    question: String,
    vararg options: InputPollOption,
    modifier: SendPoll.() -> Unit = {}
) = this.sendPoll(
    chatId = chatId,
    question = question,
    options = options.toList(),
    modifier = modifier
)


inline fun TelegramAware.sendPoll(
    channelUsername: String,
    question: String,
    options: List<InputPollOption>,
    modifier: SendPoll.() -> Unit = {}
) = this.execute(SendPoll(
    channelUsername = channelUsername,
    question = question,
    options = options
), modifier)

inline fun TelegramAware.sendPoll(
    channelUsername: String,
    question: String,
    vararg options: InputPollOption,
    modifier: SendPoll.() -> Unit = {}
) = this.sendPoll(
    channelUsername = channelUsername,
    question = question,
    options = options.toList(),
    modifier = modifier
)

