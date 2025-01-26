package com.pengrad.telegrambot.model.stars.partner

import com.pengrad.telegrambot.model.User
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType.AFFILIATE_PROGRAM

data class TransactionPartnerAffiliateProgram(
    @get:JvmName("sponsorUser") val sponsorUser: User? = null,
    @get:JvmName("commissionPerMille") val commissionPerMille: Int
) : TransactionPartner {

    override val type: String
        get() = AFFILIATE_PROGRAM

}
