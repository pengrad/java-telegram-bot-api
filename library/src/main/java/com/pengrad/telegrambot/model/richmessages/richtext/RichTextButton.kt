package com.pengrad.telegrambot.model.richmessages.richtext

import com.pengrad.telegrambot.model.richmessages.RichMessageButton

data class RichTextButton @JvmOverloads constructor(
    @get:JvmName("button") val button: RichMessageButton,
    override val type: String = RichTextType.BUTTON
) : RichText
