package com.pengrad.telegrambot.model.request.richmessages.inputrichblock

import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockType
import com.pengrad.telegrambot.model.richmessages.richtext.RichText

class InputRichBlockDetails(
    @get:JvmName("summary") val summary: RichText,
    @get:JvmName("blocks") val blocks: Array<InputRichBlock>,
    @get:JvmName("isOpen") val isOpen: Boolean? = null
) : InputRichBlock {

    override val type: String get() = RichBlockType.DETAILS

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockDetails
        return summary == other.summary && blocks.contentEquals(other.blocks) && isOpen == other.isOpen
    }

    override fun hashCode(): Int {
        var result = summary.hashCode()
        result = 31 * result + blocks.contentHashCode()
        result = 31 * result + (isOpen?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String = "InputRichBlockDetails(summary=$summary, blocks=${blocks.contentToString()}, isOpen=$isOpen)"
}
