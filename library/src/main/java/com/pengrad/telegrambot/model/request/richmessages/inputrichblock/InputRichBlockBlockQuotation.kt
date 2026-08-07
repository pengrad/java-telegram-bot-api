package com.pengrad.telegrambot.model.request.richmessages.inputrichblock

import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockType
import com.pengrad.telegrambot.model.richmessages.richtext.RichText

class InputRichBlockBlockQuotation(
    @get:JvmName("blocks") val blocks: Array<InputRichBlock>,
    @get:JvmName("credit") val credit: RichText? = null
) : InputRichBlock {

    override val type: String get() = RichBlockType.BLOCKQUOTE

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockBlockQuotation
        return blocks.contentEquals(other.blocks) && credit == other.credit
    }

    override fun hashCode(): Int {
        var result = blocks.contentHashCode()
        result = 31 * result + (credit?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String = "InputRichBlockBlockQuotation(blocks=${blocks.contentToString()}, credit=$credit)"
}
