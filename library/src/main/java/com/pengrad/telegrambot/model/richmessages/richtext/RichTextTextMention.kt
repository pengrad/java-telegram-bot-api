package com.pengrad.telegrambot.model.richmessages.richtext

import com.pengrad.telegrambot.model.User

data class RichTextTextMention @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("user") val user: User,
    override val type: String = RichTextType.TEXT_MENTION
) : RichText
