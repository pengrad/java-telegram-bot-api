package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextReference @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("name") val name: String,
    override val type: String = RichTextType.REFERENCE
) : RichText
