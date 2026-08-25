package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextBotCommand @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("botCommand") val botCommand: String,
    override val type: String = RichTextType.BOT_COMMAND
) : RichText
