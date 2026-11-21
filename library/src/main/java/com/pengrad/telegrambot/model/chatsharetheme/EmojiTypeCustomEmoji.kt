package com.pengrad.telegrambot.model.chatsharetheme

data class EmojiTypeCustomEmoji @JvmOverloads constructor(
    @get:JvmName("customEmojiId") val customEmojiId: String,
    override val type: String = EmojiType.CUSTOM_EMOJI
) : EmojiType
