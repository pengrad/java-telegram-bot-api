package com.pengrad.telegrambot.model.suggestedposts

import com.pengrad.telegrambot.model.Message
import com.pengrad.telegrambot.model.stars.StarAmount

@Suppress("unused")
data class SuggestedPostPaid (
    @get:JvmName("suggestedPostMessage") val suggestedPostMessage: Message?,
    @get:JvmName("currency") val currency: String,
    @get:JvmName("amount") val amount: Long?,
    @get:JvmName("starAmount") val starAmount: StarAmount?
){
}