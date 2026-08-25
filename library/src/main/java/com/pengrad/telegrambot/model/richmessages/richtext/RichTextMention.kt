package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextMention @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("username") val username: String,
    override val type: String = RichTextType.MENTION
) : RichText
