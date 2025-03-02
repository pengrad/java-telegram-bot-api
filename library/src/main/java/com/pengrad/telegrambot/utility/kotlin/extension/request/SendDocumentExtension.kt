package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.SendDocument
import com.pengrad.telegrambot.utility.kotlin.extension.execute
import java.io.File

inline fun TelegramAware.sendDocument(
    chatId: Long,
    documentUrl: String,
    modifier: SendDocument.() -> Unit = {}
) = this.execute(SendDocument(
    chatId = chatId,
    documentUrl = documentUrl
), modifier)

inline fun TelegramAware.sendDocument(
    channelUsername: String,
    documentUrl: String,
    modifier: SendDocument.() -> Unit = {}
) = this.execute(SendDocument(
    channelUsername = channelUsername,
    documentUrl = documentUrl
), modifier)


inline fun TelegramAware.sendDocument(
    chatId: Long,
    documentFile: File,
    modifier: SendDocument.() -> Unit = {}
) = this.execute(SendDocument(
    chatId = chatId,
    documentFile = documentFile
), modifier)

inline fun TelegramAware.sendDocument(
    channelUsername: String,
    documentFile: File,
    modifier: SendDocument.() -> Unit = {}
) = this.execute(SendDocument(
    channelUsername = channelUsername,
    documentFile = documentFile
), modifier)


inline fun TelegramAware.sendDocument(
    chatId: Long,
    documentBytes: ByteArray,
    modifier: SendDocument.() -> Unit = {}
) = this.execute(SendDocument(
    chatId = chatId,
    documentBytes = documentBytes
), modifier)

inline fun TelegramAware.sendDocument(
    channelUsername: String,
    documentBytes: ByteArray,
    modifier: SendDocument.() -> Unit = {}
) = this.execute(SendDocument(
    channelUsername = channelUsername,
    documentBytes = documentBytes
), modifier)