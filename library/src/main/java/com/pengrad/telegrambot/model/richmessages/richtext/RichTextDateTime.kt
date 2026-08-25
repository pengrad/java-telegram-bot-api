package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextDateTime @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("unixTime") val unixTime: Long,
    @get:JvmName("dateTimeFormat") val dateTimeFormat: String,
    override val type: String = RichTextType.DATE_TIME
) : RichText
