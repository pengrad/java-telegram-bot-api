package com.pengrad.telegrambot.model.richmessages.richblock

import com.pengrad.telegrambot.model.richmessages.richtext.RichText

data class RichBlockExpandableBlockQuotation(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("credit") val credit: RichText? = null
) : RichBlock {
    override val type: String get() = RichBlockType.EXPANDABLE_BLOCKQUOTE
}
