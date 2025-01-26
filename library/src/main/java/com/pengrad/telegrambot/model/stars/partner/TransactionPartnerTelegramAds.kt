package com.pengrad.telegrambot.model.stars.partner

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType.TELEGRAM_ADS

class TransactionPartnerTelegramAds : TransactionPartner {

    override val type: String
        get() = TELEGRAM_ADS

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TransactionPartnerTelegramAds

        return type == other.type
    }

    override fun hashCode(): Int {
        return type.hashCode()
    }

    override fun toString(): String {
        return "TransactionPartnerTelegramAds(type='$type')"
    }
}