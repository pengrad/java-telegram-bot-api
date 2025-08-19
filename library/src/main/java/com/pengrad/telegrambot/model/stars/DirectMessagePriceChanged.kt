package com.pengrad.telegrambot.model.stars

data class DirectMessagePriceChanged (
    @get:JvmName("areDirectMessagesEnabled") val areDirectMessagesEnabled: Boolean,
    @get:JvmName("directMessageStartCount") val directMessageStartCount: Int?
) {
}