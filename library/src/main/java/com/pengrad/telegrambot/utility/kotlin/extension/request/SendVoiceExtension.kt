package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.SendVoice
import com.pengrad.telegrambot.utility.kotlin.extension.execute
import java.io.File

inline fun TelegramAware.sendVoice(
    chatId: Long,
    voiceUrl: String,
    modifier: SendVoice.() -> Unit = {}
) = this.execute(SendVoice(
    chatId = chatId,
    voiceUrl = voiceUrl
), modifier)

inline fun TelegramAware.sendVoice(
    channelUsername: String,
    voiceUrl: String,
    modifier: SendVoice.() -> Unit = {}
) = this.execute(SendVoice(
    channelUsername = channelUsername,
    voiceUrl = voiceUrl
), modifier)


inline fun TelegramAware.sendVoice(
    chatId: Long,
    voiceFile: File,
    modifier: SendVoice.() -> Unit = {}
) = this.execute(SendVoice(
    chatId = chatId,
    voiceFile = voiceFile
), modifier)

inline fun TelegramAware.sendVoice(
    channelUsername: String,
    voiceFile: File,
    modifier: SendVoice.() -> Unit = {}
) = this.execute(SendVoice(
    channelUsername = channelUsername,
    voiceFile = voiceFile
), modifier)


inline fun TelegramAware.sendVoice(
    chatId: Long,
    voiceBytes: ByteArray,
    modifier: SendVoice.() -> Unit = {}
) = this.execute(SendVoice(
    chatId = chatId,
    voiceBytes = voiceBytes
), modifier)

inline fun TelegramAware.sendVoice(
    channelUsername: String,
    voiceBytes: ByteArray,
    modifier: SendVoice.() -> Unit = {}
) = this.execute(SendVoice(
    channelUsername = channelUsername,
    voiceBytes = voiceBytes
), modifier)