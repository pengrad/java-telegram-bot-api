package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextAnchorLink @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("anchorName") val anchorName: String,
    override val type: String = RichTextType.ANCHOR_LINK
) : RichText
