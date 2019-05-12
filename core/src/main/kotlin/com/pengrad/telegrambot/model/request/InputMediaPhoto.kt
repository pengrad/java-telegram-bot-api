package com.pengrad.telegrambot.model.request

import com.pengrad.telegrambot.request.ContentTypes

import java.io.File
import java.io.Serializable

/**
 * Stas Parshin
 * 23 November 2017
 */
class InputMediaPhoto : InputMedia<InputMediaPhoto>, Serializable {

    override val defaultFileName: String
        get() = ContentTypes.PHOTO_FILE_NAME

    override val contentType: String
        get() = ContentTypes.PHOTO_MIME_TYPE

    constructor(media: String) : super("photo", media) {}

    constructor(media: File) : super("photo", media) {}

    constructor(media: ByteArray) : super("photo", media) {}

    companion object {
        private const val serialVersionUID = 1L
    }
}
