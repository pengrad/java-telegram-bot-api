package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 23 May 2017
 */
data class VideoNote(
        @get:JvmName("fileId") val file_id: String? = null,
        @get:JvmName("fileUniqueId") val file_unique_id: String? = null,
        @get:JvmName("length") val length: Int? = null,
        @get:JvmName("duration") val duration: Int? = null,
        @get:JvmName("thumb") val thumb: PhotoSize? = null,
        @get:JvmName("fileSize") val file_size: Int? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}