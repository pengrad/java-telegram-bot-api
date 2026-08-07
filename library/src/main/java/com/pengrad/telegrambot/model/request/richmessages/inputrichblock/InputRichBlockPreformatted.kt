package com.pengrad.telegrambot.model.request.richmessages.inputrichblock

import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockType
import com.pengrad.telegrambot.model.richmessages.richtext.RichText

data class InputRichBlockPreformatted(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("language") val language: String? = null
) : InputRichBlock {
    override val type: String get() = RichBlockType.PRE
}
