package com.pengrad.telegrambot.model.request

import com.pengrad.telegrambot.request.ContentTypes

import java.io.File
import java.io.Serializable

/**
 * Stas Parshin
 * 28 July 2018
 */
class InputMediaDocument : InputMedia<InputMediaDocument>, Serializable {

    override val defaultFileName: String
        get() = ContentTypes.DOC_FILE_NAME

    override val contentType: String
        get() = ContentTypes.DOC_MIME_TYPE

    constructor(media: String) : super("document", media) {}

    constructor(media: File) : super("document", media) {}

    constructor(media: ByteArray) : super("document", media) {}

    companion object {
        private const val serialVersionUID = 0L
    }
}
