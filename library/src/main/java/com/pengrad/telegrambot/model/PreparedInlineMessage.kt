package com.pengrad.telegrambot.model

data class PreparedInlineMessage(
    @get:JvmName("id") val id: String,
    @get:JvmName("expirationDate") val expirationDate: Int
)
