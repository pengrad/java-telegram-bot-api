package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextItalic @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    override val type: String = RichTextType.ITALIC
) : RichText
