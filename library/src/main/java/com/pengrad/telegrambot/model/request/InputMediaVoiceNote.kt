package com.pengrad.telegrambot.model.request

import com.pengrad.telegrambot.request.ContentTypes
import java.io.File

class InputMediaVoiceNote : InputMedia<InputMediaVoiceNote> {

    constructor(media: String) : super("voice_note", media)
    constructor(media: File) : super("voice_note", media)
    constructor(media: ByteArray) : super("voice_note", media)

    private var duration: Int? = null

    fun duration(duration: Int): InputMediaVoiceNote {
        this.duration = duration
        return this
    }

    override fun getDefaultFileName(): String = ContentTypes.VOICE_FILE_NAME
    override fun getDefaultContentType(): String = ContentTypes.VOICE_MIME_TYPE
}
