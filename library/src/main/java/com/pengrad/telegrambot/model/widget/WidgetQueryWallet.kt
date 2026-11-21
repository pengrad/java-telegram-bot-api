package com.pengrad.telegrambot.model.widget

import java.io.Serializable

data class WidgetQueryWallet(
    @get:JvmName("address") val address: String,
    @get:JvmName("amount") val amount: String,
    @get:JvmName("publicKey") val publicKey: String? = null,
    @get:JvmName("stateInit") val stateInit: String? = null,
) : Serializable
