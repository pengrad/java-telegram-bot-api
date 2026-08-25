package com.pengrad.telegrambot.model.request.richmessages.richblock

import com.pengrad.telegrambot.model.richmessages.richtext.RichText

class InputRichBlockDetails private constructor(
    @get:JvmName("summary") val summary: RichText,
    @get:JvmName("blocks") val blocks: Array<InputRichBlock>,
    @get:JvmName("isOpen") var isOpen: Boolean?
) : InputRichBlock {

    constructor(summary: RichText, vararg blocks: InputRichBlock) : this(
        summary = summary,
        blocks = arrayOf(*blocks),
        isOpen = null
    )

    override val type: String = InputRichBlockType.DETAILS

    fun isOpen(isOpen: Boolean) = apply { this.isOpen = isOpen }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockDetails
        return type == other.type &&
                summary == other.summary &&
                blocks.contentEquals(other.blocks) &&
                isOpen == other.isOpen
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + summary.hashCode()
        result = 31 * result + blocks.contentHashCode()
        result = 31 * result + (isOpen?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputRichBlockDetails(type=$type, summary=$summary, blocks=${blocks.contentToString()}, isOpen=$isOpen)"
}
