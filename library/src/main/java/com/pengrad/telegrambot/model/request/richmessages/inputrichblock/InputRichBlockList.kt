package com.pengrad.telegrambot.model.request.richmessages.inputrichblock

import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockType

class InputRichBlockList(
    @get:JvmName("items") val items: Array<InputRichBlockListItem>
) : InputRichBlock {

    override val type: String get() = RichBlockType.LIST

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockList
        return items.contentEquals(other.items)
    }

    override fun hashCode(): Int = items.contentHashCode()

    override fun toString(): String = "InputRichBlockList(items=${items.contentToString()})"
}
