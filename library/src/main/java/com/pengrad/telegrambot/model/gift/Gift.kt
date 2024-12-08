package com.pengrad.telegrambot.model.gift

import com.pengrad.telegrambot.model.Sticker

data class Gift(
    @get:JvmName("id") val id: String,
    @get:JvmName("sticker") val sticker: Sticker,
    @get:JvmName("starCount") val starCount: Int,
    @get:JvmName("totalCount") val totalCount: Int,
    @get:JvmName("remainingCount") val remainingCount: Int
)
