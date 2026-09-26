package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextUrl @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("url") val url: String,
    override val type: String = RichTextType.URL
) : RichText
