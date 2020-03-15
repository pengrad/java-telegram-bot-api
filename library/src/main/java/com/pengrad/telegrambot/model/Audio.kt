package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 8/5/15.
 */
data class Audio(
        @get:JvmName("fileId") val file_id: String? = null,
        @get:JvmName("fileUniqueId") val file_unique_id: String? = null,
        @get:JvmName("duration") val duration: Int? = null,
        @get:JvmName("performer") val performer: String? = null,
        @get:JvmName("title") val title: String? = null,
        @get:JvmName("mimeType") val mime_type: String? = null,
        @get:JvmName("fileSize") val file_size: Int? = null,
        @get:JvmName("thumb") val thumb: PhotoSize? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}