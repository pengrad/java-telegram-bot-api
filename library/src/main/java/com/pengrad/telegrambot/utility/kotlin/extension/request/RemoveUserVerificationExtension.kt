package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.RemoveUserVerification
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.removeUserVerification(
    userId: Long,
    modifier: RemoveUserVerification.() -> Unit = {}
) = this.execute(RemoveUserVerification(
    userId = userId
), modifier)