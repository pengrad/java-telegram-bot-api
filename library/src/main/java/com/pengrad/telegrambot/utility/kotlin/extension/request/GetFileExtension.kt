package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.GetFile
import com.pengrad.telegrambot.utility.kotlin.extension.execute

fun TelegramAware.getFile(
    fileId: String,
    modifier: GetFile.() -> Unit = {}
) = this.execute(GetFile(fileId), modifier)