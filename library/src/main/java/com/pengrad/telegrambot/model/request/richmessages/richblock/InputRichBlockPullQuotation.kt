package com.pengrad.telegrambot.model.request.richmessages.richblock

import com.pengrad.telegrambot.model.richmessages.richtext.RichText

class InputRichBlockPullQuotation private constructor(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("credit") var credit: RichText?
) : InputRichBlock {

    constructor(text: RichText) : this(
        text = text,
        credit = null
    )

    override val type: String = InputRichBlockType.PULLQUOTE

    fun credit(credit: RichText) = apply { this.credit = credit }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockPullQuotation
        return type == other.type &&
                text == other.text &&
                credit == other.credit
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + text.hashCode()
        result = 31 * result + (credit?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputRichBlockPullQuotation(type=$type, text=$text, credit=$credit)"
}
