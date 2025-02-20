package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.request.VerifyUser
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.verifyUser(
    userId: Long,
    customDescription: String? = null,
    modifier: VerifyUser.() -> Unit = {}
) = this.execute(VerifyUser(
    userId = userId
)) {
    this.customDescription = customDescription
    modifier()
}