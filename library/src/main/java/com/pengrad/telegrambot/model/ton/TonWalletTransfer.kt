package com.pengrad.telegrambot.model.ton

import java.io.Serializable

data class TonWalletTransfer(
    @get:JvmName("transactionId") val transactionId: String,
    @get:JvmName("peerAddress") val peerAddress: String,
    @get:JvmName("amount") val amount: String,
    @get:JvmName("comment") val comment: String? = null,
) : Serializable
