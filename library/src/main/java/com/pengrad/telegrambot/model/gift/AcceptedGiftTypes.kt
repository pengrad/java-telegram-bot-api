package com.pengrad.telegrambot.model.gift

data class AcceptedGiftTypes(
    @get:JvmName("unlimitedGifts") val unlimitedGifts: Boolean,
    @get:JvmName("limitedGifts") val limitedGifts: Boolean,
    @get:JvmName("uniqueGifts") val uniqueGifts: Boolean,
    @get:JvmName("premiumSubscription") val premiumSubscription: Boolean
)