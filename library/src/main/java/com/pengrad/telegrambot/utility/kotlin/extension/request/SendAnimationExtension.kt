package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.SendAnimation
import com.pengrad.telegrambot.utility.kotlin.extension.execute
import java.io.File

inline fun TelegramAware.sendAnimation(
    chatId: Long,
    animationUrl: String,
    modifier: SendAnimation.() -> Unit = {}
) = this.execute(SendAnimation(
    chatId = chatId,
    animationUrl = animationUrl
), modifier)

inline fun TelegramAware.sendAnimation(
    channelUsername: String,
    animationUrl: String,
    modifier: SendAnimation.() -> Unit = {}
) = this.execute(SendAnimation(
    channelUsername = channelUsername,
    animationUrl = animationUrl
), modifier)


inline fun TelegramAware.sendAnimation(
    chatId: Long,
    animationFile: File,
    modifier: SendAnimation.() -> Unit = {}
) = this.execute(SendAnimation(
    chatId = chatId,
    animationFile = animationFile
), modifier)

inline fun TelegramAware.sendAnimation(
    channelUsername: String,
    animationFile: File,
    modifier: SendAnimation.() -> Unit = {}
) = this.execute(SendAnimation(
    channelUsername = channelUsername,
    animationFile = animationFile
), modifier)


inline fun TelegramAware.sendAnimation(
    chatId: Long,
    animationBytes: ByteArray,
    modifier: SendAnimation.() -> Unit = {}
) = this.execute(SendAnimation(
    chatId = chatId,
    animationBytes = animationBytes
), modifier)

inline fun TelegramAware.sendAnimation(
    channelUsername: String,
    animationBytes: ByteArray,
    modifier: SendAnimation.() -> Unit = {}
) = this.execute(SendAnimation(
    channelUsername = channelUsername,
    animationBytes = animationBytes
), modifier)