package com.pengrad.telegrambot.model.stars.affiliate

import com.pengrad.telegrambot.model.Chat
import com.pengrad.telegrambot.model.User

data class AffiliateInfo(
    @get:JvmName("affiliateUser") val affiliateUser: User? = null,
    @get:JvmName("affiliateChat") val affiliateChat: Chat? = null,
    @get:JvmName("commissionPerMille") val commissionPerMille: Int,
    @get:JvmName("amount") val amount: Int,
    @get:JvmName("nanostarAmount") val nanostarAmount: Int? = null
)
