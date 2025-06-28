package com.pengrad.telegrambot.model

data class PaidMessagePriceChanged(
    @get:JvmName("prizeStarCount") val prizeStarCount: Int
)