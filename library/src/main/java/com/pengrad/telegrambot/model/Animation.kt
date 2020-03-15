package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 03 October 2016
 */
data class Animation(
        @get:JvmName("fileId") val file_id: String? = null,
        @get:JvmName("fileUniqueId") val file_unique_id: String? = null,
        @get:JvmName("width") val width: Int? = null,
        @get:JvmName("height") val height: Int? = null,
        @get:JvmName("duration") val duration: Int? = null,
        @get:JvmName("thumb") val thumb: PhotoSize? = null,
        @get:JvmName("fileName") val file_name: String? = null,
        @get:JvmName("mimeType") val mime_type: String? = null,
        @get:JvmName("fileSize") val file_size: Int? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}