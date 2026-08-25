package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextSuperscript @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    override val type: String = RichTextType.SUPERSCRIPT
) : RichText
