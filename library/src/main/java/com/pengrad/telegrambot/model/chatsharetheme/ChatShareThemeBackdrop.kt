package com.pengrad.telegrambot.model.chatsharetheme

import com.pengrad.telegrambot.model.gift.unique.UniqueGiftBackdropColors
import java.io.Serializable

data class ChatShareThemeBackdrop(
    @get:JvmName("id") val id: Long,
    @get:JvmName("name") val name: String,
    @get:JvmName("colors") val colors: UniqueGiftBackdropColors,
) : Serializable
