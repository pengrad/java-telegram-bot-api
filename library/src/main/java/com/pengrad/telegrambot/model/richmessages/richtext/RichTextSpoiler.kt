package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextSpoiler @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    override val type: String = RichTextType.SPOILER
) : RichText
