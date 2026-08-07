package com.pengrad.telegrambot.model.request.richmessages.inputrichblock

import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockType
import com.pengrad.telegrambot.model.richmessages.richtext.RichText

data class InputRichBlockThinking(
    @get:JvmName("text") val text: RichText
) : InputRichBlock {
    override val type: String get() = RichBlockType.THINKING
}
