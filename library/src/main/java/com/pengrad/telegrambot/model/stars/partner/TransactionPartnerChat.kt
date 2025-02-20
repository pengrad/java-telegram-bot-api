package com.pengrad.telegrambot.model.stars.partner

import com.pengrad.telegrambot.model.Chat
import com.pengrad.telegrambot.model.User
import com.pengrad.telegrambot.model.gift.Gift
import com.pengrad.telegrambot.model.paidmedia.PaidMedia
import com.pengrad.telegrambot.model.stars.affiliate.AffiliateInfo
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType.CHAT
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType.USER

data class TransactionPartnerChat(
    @get:JvmName("chat") val chat: Chat,
    @get:JvmName("gift") val gift: Gift? = null
) : TransactionPartner {

    override val type: String
        get() = CHAT

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TransactionPartnerChat

        if (chat != other.chat) return false
        if (gift != other.gift) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = chat.hashCode()
        result = 31 * result + (gift?.hashCode() ?: 0)
        return result
    }


}