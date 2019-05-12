package com.pengrad.telegrambot.model.request

import com.pengrad.telegrambot.request.ContentTypes

import java.io.File
import java.io.Serializable

/**
 * Stas Parshin
 * 28 July 2018
 */
class InputMediaAudio : InputMedia<InputMediaAudio>, Serializable {

    private var duration: Int? = null
    private var performer: String? = null
    private var title: String? = null

    override val defaultFileName: String
        get() = ContentTypes.AUDIO_FILE_NAME

    override val contentType: String
        get() = ContentTypes.AUDIO_MIME_TYPE

    constructor(media: String) : super("audio", media) {}

    constructor(media: File) : super("audio", media) {}

    constructor(media: ByteArray) : super("audio", media) {}

    fun duration(duration: Int?): InputMediaAudio {
        this.duration = duration
        return this
    }

    fun performer(performer: String): InputMediaAudio {
        this.performer = performer
        return this
    }

    fun title(title: String): InputMediaAudio {
        this.title = title
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
