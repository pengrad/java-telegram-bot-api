package com.pengrad.telegrambot.model.request.richmessages.inputrichblock

import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockType

data class InputRichBlockAnchor(
    @get:JvmName("name") val name: String
) : InputRichBlock {
    override val type: String get() = RichBlockType.ANCHOR
}
