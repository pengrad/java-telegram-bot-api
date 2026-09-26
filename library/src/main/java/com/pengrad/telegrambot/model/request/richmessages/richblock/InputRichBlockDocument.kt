package com.pengrad.telegrambot.model.request.richmessages.richblock

import com.pengrad.telegrambot.model.request.InputMedia
import com.pengrad.telegrambot.model.request.InputMediaDocument
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockCaption

class InputRichBlockDocument private constructor(
    @get:JvmName("document") val document: InputMediaDocument,
    @get:JvmName("caption") var caption: RichBlockCaption?
) : InputRichBlock {

    constructor(document: InputMediaDocument) : this(
        document = document,
        caption = null
    )

    override val type: String = InputRichBlockType.DOCUMENT

    override fun inputMedia(): List<InputMedia<*>> = listOf(document)

    fun caption(caption: RichBlockCaption) = apply { this.caption = caption }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockDocument
        return type == other.type &&
                document == other.document &&
                caption == other.caption
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + document.hashCode()
        result = 31 * result + (caption?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputRichBlockDocument(type=$type, document=$document, caption=$caption)"
}
