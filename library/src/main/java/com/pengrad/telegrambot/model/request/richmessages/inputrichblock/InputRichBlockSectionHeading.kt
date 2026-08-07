package com.pengrad.telegrambot.model.request.richmessages.inputrichblock

import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockType
import com.pengrad.telegrambot.model.richmessages.richtext.RichText

data class InputRichBlockSectionHeading(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("size") val size: Int
) : InputRichBlock {
    override val type: String get() = RichBlockType.HEADING
}
