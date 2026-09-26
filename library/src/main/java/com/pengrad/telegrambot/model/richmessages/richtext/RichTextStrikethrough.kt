package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextStrikethrough @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    override val type: String = RichTextType.STRIKETHROUGH
) : RichText
