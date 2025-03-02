package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.SendSticker
import com.pengrad.telegrambot.utility.kotlin.extension.execute
import java.io.File

inline fun TelegramAware.sendSticker(
    chatId: Long,
    stickerUrl: String,
    modifier: SendSticker.() -> Unit = {}
) = this.execute(SendSticker(
    chatId = chatId,
    stickerUrl = stickerUrl
), modifier)

inline fun TelegramAware.sendSticker(
    channelUsername: String,
    stickerUrl: String,
    modifier: SendSticker.() -> Unit = {}
) = this.execute(SendSticker(
    channelUsername = channelUsername,
    stickerUrl = stickerUrl
), modifier)


inline fun TelegramAware.sendSticker(
    chatId: Long,
    stickerFile: File,
    modifier: SendSticker.() -> Unit = {}
) = this.execute(SendSticker(
    chatId = chatId,
    stickerFile = stickerFile
), modifier)

inline fun TelegramAware.sendSticker(
    channelUsername: String,
    stickerFile: File,
    modifier: SendSticker.() -> Unit = {}
) = this.execute(SendSticker(
    channelUsername = channelUsername,
    stickerFile = stickerFile
), modifier)


inline fun TelegramAware.sendSticker(
    chatId: Long,
    stickerBytes: ByteArray,
    modifier: SendSticker.() -> Unit = {}
) = this.execute(SendSticker(
    chatId = chatId,
    stickerBytes = stickerBytes
), modifier)

inline fun TelegramAware.sendSticker(
    channelUsername: String,
    stickerBytes: ByteArray,
    modifier: SendSticker.() -> Unit = {}
) = this.execute(SendSticker(
    channelUsername = channelUsername,
    stickerBytes = stickerBytes
), modifier)