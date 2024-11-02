package com.pengrad.telegrambot.model.paidmedia

import com.pengrad.telegrambot.model.User

data class PaidMediaPurchased(
    @get:JvmName("user") val from: User,
    @get:JvmName("paidMediaPayload") val paidMediaPayload: String
)