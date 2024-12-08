package com.pengrad.telegrambot.model.stars.partner

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType.TELEGRAM_API

data class TransactionPartnerTelegramApi(
    @get:JvmName("requestCount") val requestCount: Int
) : TransactionPartner {

    override val type: String
        get() = TELEGRAM_API

}
