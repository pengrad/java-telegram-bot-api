package com.pengrad.telegrambot.model.stars.partner

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType.FRAGMENT
import com.pengrad.telegrambot.model.stars.withdrawal.RevenueWithdrawalState

data class TransactionPartnerFragment(
    @get:JvmName("withdrawalState") val withdrawalState: RevenueWithdrawalState? = null
) : TransactionPartner {

    override val type: String
        get() = FRAGMENT

}