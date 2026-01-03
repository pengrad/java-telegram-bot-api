package com.pengrad.telegrambot.model.gift.unique

import com.pengrad.telegrambot.model.Chat

@Suppress("unused")
data class UniqueGift(
    @get:JvmName("baseName") val baseName: String,
    @get:JvmName("name") val name: String,
    @get:JvmName("number") val number: Int,
    @get:JvmName("model") val model: UniqueGiftModel,
    @get:JvmName("symbol") val symbol: UniqueGiftSymbol,
    @get:JvmName("backdrop") val backdrop: UniqueGiftBackdrop,
    @get:JvmName("publisherChat") val publisherChat: Chat? = null,
    @get:JvmName("giftId") val giftId: String? = null
)