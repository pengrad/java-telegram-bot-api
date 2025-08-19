package com.pengrad.telegrambot.model.stars

data class PaidMessagePriceChanged(
    @get:JvmName("prizeStarCount") val prizeStarCount: Int
)