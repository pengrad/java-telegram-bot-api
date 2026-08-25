package com.pengrad.telegrambot.model.request.richmessages.richblock

import com.pengrad.telegrambot.model.request.InputMedia
import com.pengrad.telegrambot.model.richmessages.richtext.RichText

class InputRichBlockBlockQuotation private constructor(
    @get:JvmName("blocks") val blocks: Array<InputRichBlock>,
    @get:JvmName("credit") var credit: RichText?
) : InputRichBlock {

    constructor(vararg blocks: InputRichBlock) : this(
        blocks = arrayOf(*blocks),
        credit = null
    )

    override val type: String = InputRichBlockType.BLOCKQUOTE

    override fun inputMedia(): List<InputMedia<*>> = blocks.flatMap { it.inputMedia() }

    fun credit(credit: RichText) = apply { this.credit = credit }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockBlockQuotation
        return type == other.type &&
                blocks.contentEquals(other.blocks) &&
                credit == other.credit
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + blocks.contentHashCode()
        result = 31 * result + (credit?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputRichBlockBlockQuotation(type=$type, blocks=${blocks.contentToString()}, credit=$credit)"
}
