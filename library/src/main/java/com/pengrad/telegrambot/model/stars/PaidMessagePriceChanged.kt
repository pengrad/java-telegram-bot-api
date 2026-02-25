package com.pengrad.telegrambot.model.stars

data class PaidMessagePriceChanged(
    @get:JvmName("paidMessageStarCount") val paidMessageStarCount: Int
)