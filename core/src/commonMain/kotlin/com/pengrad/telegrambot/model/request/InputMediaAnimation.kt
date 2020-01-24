package com.pengrad.telegrambot.model.request

import com.pengrad.telegrambot.request.ContentTypes

import java.io.File
import java.io.Serializable

/**
 * Stas Parshin
 * 28 July 2018
 */
class InputMediaAnimation : InputMedia<InputMediaAnimation>, Serializable {

    private var width: Int? = null
    private var height: Int? = null
    private var duration: Int? = null

    override val defaultFileName: String
        get() = ContentTypes.GIF_FILE_NAME

    override val contentType: String
        get() = ContentTypes.GIF_MIME_TYPE

    constructor(media: String) : super("animation", media) {}

    constructor(media: File) : super("animation", media) {}

    constructor(media: ByteArray) : super("animation", media) {}

    fun width(width: Int?): InputMediaAnimation {
        this.width = width
        return this
    }

    fun height(height: Int?): InputMediaAnimation {
        this.height = height
        return this
    }

    fun duration(duration: Int?): InputMediaAnimation {
        this.duration = duration
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
