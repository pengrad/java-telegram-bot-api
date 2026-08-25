package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextSubscript @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    override val type: String = RichTextType.SUBSCRIPT
) : RichText
