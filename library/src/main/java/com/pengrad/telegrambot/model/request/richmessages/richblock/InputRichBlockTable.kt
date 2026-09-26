package com.pengrad.telegrambot.model.request.richmessages.richblock

import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockTableCell
import com.pengrad.telegrambot.model.richmessages.richtext.RichText

class InputRichBlockTable private constructor(
    @get:JvmName("cells") val cells: Array<Array<RichBlockTableCell>>,
    @get:JvmName("isBordered") var isBordered: Boolean?,
    @get:JvmName("isStriped") var isStriped: Boolean?,
    @get:JvmName("isCompact") var isCompact: Boolean?,
    @get:JvmName("caption") var caption: RichText?
) : InputRichBlock {

    constructor(cells: Array<Array<RichBlockTableCell>>) : this(
        cells = cells,
        isBordered = null,
        isStriped = null,
        isCompact = null,
        caption = null
    )

    override val type: String = InputRichBlockType.TABLE

    fun isBordered(isBordered: Boolean) = apply { this.isBordered = isBordered }

    fun isStriped(isStriped: Boolean) = apply { this.isStriped = isStriped }

    fun isCompact(isCompact: Boolean) = apply { this.isCompact = isCompact }

    fun caption(caption: RichText) = apply { this.caption = caption }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockTable
        return type == other.type &&
                cells.contentDeepEquals(other.cells) &&
                isBordered == other.isBordered &&
                isStriped == other.isStriped &&
                isCompact == other.isCompact &&
                caption == other.caption
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + cells.contentDeepHashCode()
        result = 31 * result + (isBordered?.hashCode() ?: 0)
        result = 31 * result + (isStriped?.hashCode() ?: 0)
        result = 31 * result + (isCompact?.hashCode() ?: 0)
        result = 31 * result + (caption?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputRichBlockTable(type=$type, cells=${cells.contentDeepToString()}, isBordered=$isBordered, isStriped=$isStriped, isCompact=$isCompact, caption=$caption)"
}
