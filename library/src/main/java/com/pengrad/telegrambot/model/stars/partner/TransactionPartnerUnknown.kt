package com.pengrad.telegrambot.model.stars.partner

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType.UNKNOWN

class TransactionPartnerUnknown(override val type: String = UNKNOWN) : TransactionPartner {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TransactionPartnerUnknown

        return type == other.type
    }

    override fun hashCode(): Int {
        return type.hashCode()
    }

    override fun toString(): String {
        return "TransactionPartnerUnknown(type='$type')"
    }
}