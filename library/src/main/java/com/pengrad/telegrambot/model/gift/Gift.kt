package com.pengrad.telegrambot.model.gift

import com.pengrad.telegrambot.model.Chat
import com.pengrad.telegrambot.model.Sticker

data class Gift(
    @get:JvmName("id") val id: String,
    @get:JvmName("sticker") val sticker: Sticker,
    @get:JvmName("starCount") val starCount: Int,
    @get:JvmName("upgradeStarCount") val upgradeStarCount: Int? = null,
    @get:JvmName("totalCount") val totalCount: Int? = null,
    @get:JvmName("remainingCount") val remainingCount: Int? = null,
    @get:JvmName("personalTotalCount") val personalTotalCount: Int? = null,
    @get:JvmName("personalRemainingCount") val personalRemainingCount: Int? = null,
    @get:JvmName("isPremium") val isPremium: Boolean? = null,
    @get:JvmName("hasColors") val hasColors: Boolean? = null,
    @get:JvmName("publisherChat") val publisherChat: Chat? = null
)
