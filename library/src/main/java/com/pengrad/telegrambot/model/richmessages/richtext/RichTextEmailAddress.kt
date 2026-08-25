package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextEmailAddress @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("emailAddress") val emailAddress: String,
    override val type: String = RichTextType.EMAIL_ADDRESS
) : RichText
