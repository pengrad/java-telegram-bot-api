package com.pengrad.telegrambot.model.request.richmessages.richblock

import com.pengrad.telegrambot.model.richmessages.richtext.RichText

class InputRichBlockPreformatted private constructor(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("language") var language: String?
) : InputRichBlock {

    constructor(text: RichText) : this(
        text = text,
        language = null
    )

    override val type: String = InputRichBlockType.PRE

    fun language(language: String) = apply { this.language = language }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockPreformatted
        return type == other.type &&
                text == other.text &&
                language == other.language
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + text.hashCode()
        result = 31 * result + (language?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputRichBlockPreformatted(type=$type, text=$text, language=$language)"
}
