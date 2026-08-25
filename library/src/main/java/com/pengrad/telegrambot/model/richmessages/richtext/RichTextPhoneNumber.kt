package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextPhoneNumber @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("phoneNumber") val phoneNumber: String,
    override val type: String = RichTextType.PHONE_NUMBER
) : RichText
