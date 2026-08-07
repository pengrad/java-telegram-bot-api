package com.pengrad.telegrambot.model.request.richmessages.inputrichblock

import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockType
import com.pengrad.telegrambot.model.richmessages.richtext.RichText

data class InputRichBlockPullQuotation(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("credit") val credit: RichText? = null
) : InputRichBlock {
    override val type: String get() = RichBlockType.PULLQUOTE
}
