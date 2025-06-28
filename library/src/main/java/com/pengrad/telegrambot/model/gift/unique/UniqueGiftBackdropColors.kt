package com.pengrad.telegrambot.model.gift.unique

data class UniqueGiftBackdropColors(
    @get:JvmName("centerColor") val centerColor: Int,
    @get:JvmName("edgeColor") val edgeColor: Int,
    @get:JvmName("symbolColor") val symbolColor: Int,
    @get:JvmName("textColor") val textColor: Int
)