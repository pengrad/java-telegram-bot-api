package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextCashtag @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("cashtag") val cashtag: String,
    override val type: String = RichTextType.CASHTAG
) : RichText
