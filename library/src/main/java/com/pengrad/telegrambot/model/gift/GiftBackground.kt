package com.pengrad.telegrambot.model.gift

data class GiftBackground(
    @get:JvmName("centerColor") val centerColor: Int,
    @get:JvmName("edgeColor") val edgeColor: Int,
    @get:JvmName("textColor") val textColor: Int
)
