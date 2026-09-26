package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextAnchor @JvmOverloads constructor(
    @get:JvmName("name") val name: String,
    override val type: String = RichTextType.ANCHOR
) : RichText
