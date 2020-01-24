package com.pengrad.telegrambot.model.request

import com.pengrad.telegrambot.request.ContentTypes

import java.io.File
import java.io.Serializable

/**
 * Stas Parshin
 * 23 November 2017
 */
class InputMediaVideo : InputMedia<InputMediaVideo>, Serializable {

    private var width: Int? = null
    private var height: Int? = null
    private var duration: Int? = null
    private var supports_streaming: Boolean? = null

    override val defaultFileName: String
        get() = ContentTypes.VIDEO_FILE_NAME

    override val contentType: String
        get() = ContentTypes.VIDEO_MIME_TYPE

    constructor(media: String) : super("video", media) {}

    constructor(media: File) : super("video", media) {}

    constructor(media: ByteArray) : super("video", media) {}

    fun width(width: Int?): InputMediaVideo {
        this.width = width
        return this
    }

    fun height(height: Int?): InputMediaVideo {
        this.height = height
        return this
    }

    fun duration(duration: Int?): InputMediaVideo {
        this.duration = duration
        return this
    }

    fun supportsStreaming(supportsStreaming: Boolean): InputMediaVideo {
        this.supports_streaming = supportsStreaming
        return this
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}
