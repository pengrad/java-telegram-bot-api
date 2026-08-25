package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextCustomEmoji @JvmOverloads constructor(
    @get:JvmName("customEmojiId") val customEmojiId: String,
    @get:JvmName("alternativeText") val alternativeText: String,
    override val type: String = RichTextType.CUSTOM_EMOJI
) : RichText
