package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.SendVideo
import com.pengrad.telegrambot.utility.kotlin.extension.execute
import java.io.File

inline fun TelegramAware.sendVideo(
    chatId: Long,
    videoUrl: String,
    modifier: SendVideo.() -> Unit = {}
) = this.execute(SendVideo(
    chatId = chatId,
    videoUrl = videoUrl
), modifier)

inline fun TelegramAware.sendVideo(
    channelUsername: String,
    videoUrl: String,
    modifier: SendVideo.() -> Unit = {}
) = this.execute(SendVideo(
    channelUsername = channelUsername,
    videoUrl = videoUrl
), modifier)


inline fun TelegramAware.sendVideo(
    chatId: Long,
    videoFile: File,
    modifier: SendVideo.() -> Unit = {}
) = this.execute(SendVideo(
    chatId = chatId,
    videoFile = videoFile
), modifier)

inline fun TelegramAware.sendVideo(
    channelUsername: String,
    videoFile: File,
    modifier: SendVideo.() -> Unit = {}
) = this.execute(SendVideo(
    channelUsername = channelUsername,
    videoFile = videoFile
), modifier)


inline fun TelegramAware.sendVideo(
    chatId: Long,
    videoBytes: ByteArray,
    modifier: SendVideo.() -> Unit = {}
) = this.execute(SendVideo(
    chatId = chatId,
    videoBytes = videoBytes
), modifier)

inline fun TelegramAware.sendVideo(
    channelUsername: String,
    videoBytes: ByteArray,
    modifier: SendVideo.() -> Unit = {}
) = this.execute(SendVideo(
    channelUsername = channelUsername,
    videoBytes = videoBytes
), modifier)