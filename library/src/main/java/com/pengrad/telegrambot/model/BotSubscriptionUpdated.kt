package com.pengrad.telegrambot.model

import java.io.Serializable

data class BotSubscriptionUpdated(
    @get:JvmName("user") val user: User,
    @get:JvmName("invoicePayload") val invoicePayload: String,
    @get:JvmName("state") val state: String,
) : Serializable
