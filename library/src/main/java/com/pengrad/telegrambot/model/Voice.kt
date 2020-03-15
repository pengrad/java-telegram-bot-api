package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 10/21/15.
 */
data class Voice(
        @get:JvmName("fileId") val file_id: String? = null,
        @get:JvmName("fileUniqueId") val file_unique_id: String? = null,
        @get:JvmName("duration") val duration: Int? = null,
        @get:JvmName("mimeType") val mime_type: String? = null,
        @get:JvmName("fileSize") val file_size: Int? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}