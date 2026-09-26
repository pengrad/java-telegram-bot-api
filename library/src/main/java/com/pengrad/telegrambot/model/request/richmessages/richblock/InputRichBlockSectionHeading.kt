package com.pengrad.telegrambot.model.request.richmessages.richblock

import com.pengrad.telegrambot.model.richmessages.richtext.RichText

class InputRichBlockSectionHeading(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("size") val size: Int
) : InputRichBlock {

    override val type: String = InputRichBlockType.HEADING

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockSectionHeading
        return type == other.type &&
                text == other.text &&
                size == other.size
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + text.hashCode()
        result = 31 * result + size
        return result
    }

    override fun toString(): String =
        "InputRichBlockSectionHeading(type=$type, text=$text, size=$size)"
}
