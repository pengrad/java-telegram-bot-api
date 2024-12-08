package com.pengrad.telegrambot.model.stars.partner

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType.OTHER

class TransactionPartnerOther : TransactionPartner {

    override val type: String
        get() = OTHER

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TransactionPartnerOther

        return type == other.type
    }

    override fun hashCode(): Int {
        return type.hashCode()
    }

    override fun toString(): String {
        return "TransactionPartnerOther(type='$type')"
    }
}