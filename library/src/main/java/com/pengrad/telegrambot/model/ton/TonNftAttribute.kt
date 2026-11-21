package com.pengrad.telegrambot.model.ton

import java.io.Serializable

data class TonNftAttribute(
    @get:JvmName("traitType") val traitType: String,
    @get:JvmName("value") val value: String,
) : Serializable
