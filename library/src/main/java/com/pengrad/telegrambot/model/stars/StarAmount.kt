package com.pengrad.telegrambot.model.stars

data class StarAmount(
    @get:JvmName("amount") val amount: Int,
    @get:JvmName("nanostarAmount") val nanostarAmount: Long
)