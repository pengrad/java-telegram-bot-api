package com.pengrad.telegrambot.request

import kotlin.jvm.JvmField

/**
 * stas
 * 5/1/16.
 */
object ContentTypes {

    @JvmField
    val PHOTO_MIME_TYPE = "image/jpeg"
    @JvmField val AUDIO_MIME_TYPE = "audio/mpeg"
    @JvmField val DOC_MIME_TYPE = "text/plain"
    @JvmField val VIDEO_MIME_TYPE = "video/mp4"
    @JvmField val VOICE_MIME_TYPE = "audio/ogg"
    @JvmField val GIF_MIME_TYPE = "image/gif"
    @JvmField val PHOTO_FILE_NAME = "file.jpg"
    @JvmField val AUDIO_FILE_NAME = "file.mp3"
    @JvmField val DOC_FILE_NAME = "file.txt"
    @JvmField val VIDEO_FILE_NAME = "file.mp4"
    @JvmField val VOICE_FILE_NAME = "file.ogg"
    @JvmField val GIF_FILE_NAME = "file.gif"
    @JvmField val GENERAL_MIME_TYPE = "application/x-www-form-urlencoded"
    @JvmField val GENERAL_FILE_NAME = DOC_FILE_NAME
}
