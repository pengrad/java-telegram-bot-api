package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextMarked @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    override val type: String = RichTextType.MARKED
) : RichText
