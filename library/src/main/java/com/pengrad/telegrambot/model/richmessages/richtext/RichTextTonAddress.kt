package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextTonAddress @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("address") val address: String,
    override val type: String = RichTextType.TON_ADDRESS
) : RichText
