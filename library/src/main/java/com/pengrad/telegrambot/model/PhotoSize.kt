package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 8/4/15.
 */
data class PhotoSize(
        @get:JvmName("fileId") val file_id: String? = null,
        @get:JvmName("fileUniqueId") val file_unique_id: String? = null,
        @get:JvmName("width") val width: Int? = null,
        @get:JvmName("height") val height: Int? = null,
        @get:JvmName("fileSize") val file_size: Int? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}