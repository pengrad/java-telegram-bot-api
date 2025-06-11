package com.pengrad.telegrambot.model.gift.unique

data class UniqueGiftBackdrop(
    @get:JvmName("name") val name: String,
    @get:JvmName("colors") val colors: UniqueGiftBackdropColors,
    @get:JvmName("rarityPerMille") val rarityPerMille: Int
)