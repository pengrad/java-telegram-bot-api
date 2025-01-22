package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.GetMe
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.getMe(
    modifier: GetMe.() -> Unit = {}
) = this.execute(GetMe(), modifier)