package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * stas
 * 8/5/15.
 */
data class Video(
        @get:JvmName("fileId") @SerialName("file_id") val fileId: String? = null,
        @get:JvmName("fileUniqueId") @SerialName("file_unique_id") val fileUniqueId: String? = null,
        @get:JvmName("width") val width: Int? = null,
        @get:JvmName("height") val height: Int? = null,
        @get:JvmName("duration") val duration: Int? = null,
        @get:JvmName("thumb") val thumb: PhotoSize? = null,
        @get:JvmName("mimeType") @SerialName("mime_type") val mimeType: String? = null,
        @get:JvmName("fileSize") @SerialName("file_size") val fileSize: Int? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}