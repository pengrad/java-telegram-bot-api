package com.pengrad.telegrambot.model.chatsharetheme

data class EmojiTypeEmoji @JvmOverloads constructor(
    @get:JvmName("emoji") val emoji: String,
    override val type: String = EmojiType.EMOJI
) : EmojiType
