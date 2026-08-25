package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextCode @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    override val type: String = RichTextType.CODE
) : RichText
