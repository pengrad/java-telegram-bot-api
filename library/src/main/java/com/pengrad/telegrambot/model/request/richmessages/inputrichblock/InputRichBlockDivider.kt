package com.pengrad.telegrambot.model.request.richmessages.inputrichblock

import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockType

class InputRichBlockDivider : InputRichBlock {
    override val type: String get() = RichBlockType.DIVIDER

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        return other is InputRichBlockDivider
    }

    override fun hashCode(): Int = type.hashCode()

    override fun toString(): String = "InputRichBlockDivider()"
}
