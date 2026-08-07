package com.pengrad.telegrambot.model.request.richmessages.inputrichblock

import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockTableCell
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockType
import com.pengrad.telegrambot.model.richmessages.richtext.RichText

class InputRichBlockTable(
    @get:JvmName("cells") val cells: Array<Array<RichBlockTableCell>>,
    @get:JvmName("isBordered") val isBordered: Boolean? = null,
    @get:JvmName("isStriped") val isStriped: Boolean? = null,
    @get:JvmName("caption") val caption: RichText? = null
) : InputRichBlock {

    override val type: String get() = RichBlockType.TABLE

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockTable
        return cells.contentDeepEquals(other.cells) &&
                isBordered == other.isBordered &&
                isStriped == other.isStriped &&
                caption == other.caption
    }

    override fun hashCode(): Int {
        var result = cells.contentDeepHashCode()
        result = 31 * result + (isBordered?.hashCode() ?: 0)
        result = 31 * result + (isStriped?.hashCode() ?: 0)
        result = 31 * result + (caption?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputRichBlockTable(cells=${cells.contentDeepToString()}, isBordered=$isBordered, isStriped=$isStriped, caption=$caption)"
}
