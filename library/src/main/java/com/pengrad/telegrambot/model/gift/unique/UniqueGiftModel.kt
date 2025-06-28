package com.pengrad.telegrambot.model.gift.unique

import com.pengrad.telegrambot.model.Sticker

data class UniqueGiftModel(
    @get:JvmName("name") val name: String,
    @get:JvmName("sticker") val sticker: Sticker,
    @get:JvmName("rarityPerMille") val rarityPerMille: Int
)