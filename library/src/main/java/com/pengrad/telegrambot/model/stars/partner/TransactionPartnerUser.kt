package com.pengrad.telegrambot.model.stars.partner

import com.pengrad.telegrambot.model.User
import com.pengrad.telegrambot.model.gift.Gift
import com.pengrad.telegrambot.model.paidmedia.PaidMedia
import com.pengrad.telegrambot.model.stars.affiliate.AffiliateInfo
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType.USER

data class TransactionPartnerUser(
    @get:JvmName("user") val user: User,
    @get:JvmName("affiliate") val affiliate: AffiliateInfo,
    @get:JvmName("invoicePayload") val invoicePayload: String? = null,
    @get:JvmName("paidMedia") val paidMedia: Array<PaidMedia>? = null,
    @get:JvmName("paidMediaPayload") val paidMediaPayload: String? = null,
    @get:JvmName("subscriptionPeriod") val subscriptionPeriod: Int? = null,
    @get:JvmName("gift") val gift: Gift? = null
) : TransactionPartner {

    override val type: String
        get() = USER

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TransactionPartnerUser

        if (subscriptionPeriod != other.subscriptionPeriod) return false
        if (user != other.user) return false
        if (affiliate != other.affiliate) return false
        if (invoicePayload != other.invoicePayload) return false
        if (paidMedia != null) {
            if (other.paidMedia == null) return false
            if (!paidMedia.contentEquals(other.paidMedia)) return false
        } else if (other.paidMedia != null) return false
        if (paidMediaPayload != other.paidMediaPayload) return false
        if (gift != other.gift) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = subscriptionPeriod ?: 0
        result = 31 * result + user.hashCode()
        result = 31 * result + affiliate.hashCode()
        result = 31 * result + (invoicePayload?.hashCode() ?: 0)
        result = 31 * result + (paidMedia?.contentHashCode() ?: 0)
        result = 31 * result + (paidMediaPayload?.hashCode() ?: 0)
        result = 31 * result + (gift?.hashCode() ?: 0)
        result = 31 * result + type.hashCode()
        return result
    }


}