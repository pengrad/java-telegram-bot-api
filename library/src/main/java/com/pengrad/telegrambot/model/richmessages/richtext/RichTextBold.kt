package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextBold @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    override val type: String = RichTextType.BOLD
) : RichText
