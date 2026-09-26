package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextReferenceLink @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("referenceName") val referenceName: String,
    override val type: String = RichTextType.REFERENCE_LINK
) : RichText
