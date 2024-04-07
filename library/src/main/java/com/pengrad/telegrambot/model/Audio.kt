package com.pengrad.telegrambot.model

/**
 * stas
 * 8/5/15.
 */
data class Audio(
        @get:JvmName("fileId") val fileId: String? = null,
        @get:JvmName("fileUniqueId") val fileUniqueId: String? = null,
        @get:JvmName("duration") val duration: Int? = null,
        @get:JvmName("performer") val performer: String? = null,
        @get:JvmName("title") val title: String? = null,
        @get:JvmName("fileName") val fileName: String? = null,
        @get:JvmName("mimeType") val mimeType: String? = null,
        @get:JvmName("fileSize") val fileSize: Long? = null,
        @get:JvmName("thumbnail") val thumbnail: PhotoSize? = null,
)
