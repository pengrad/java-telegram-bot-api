package com.pengrad.telegrambot.model.request.richmessages.richblock

import com.pengrad.telegrambot.model.richmessages.richtext.RichText

class InputRichBlockParagraph(
    @get:JvmName("text") val text: RichText
) : InputRichBlock {

    override val type: String = InputRichBlockType.PARAGRAPH

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockParagraph
        return type == other.type &&
                text == other.text
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + text.hashCode()
        return result
    }

    override fun toString(): String =
        "InputRichBlockParagraph(type=$type, text=$text)"
}
