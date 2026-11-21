package com.pengrad.telegrambot.model.chatsharetheme

import com.pengrad.telegrambot.model.gift.unique.UniqueGift

data class ChatShareThemeUniqueGift @JvmOverloads constructor(
    @get:JvmName("gift") val gift: UniqueGift,
    override val type: String = ChatShareTheme.UNIQUE_GIFT
) : ChatShareTheme
