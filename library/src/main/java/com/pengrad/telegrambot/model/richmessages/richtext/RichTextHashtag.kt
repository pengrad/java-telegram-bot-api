package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextHashtag @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("hashtag") val hashtag: String,
    override val type: String = RichTextType.HASHTAG
) : RichText
