package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 16 October 2015
 */
data class File(
        @get:JvmName("fileId") val file_id: String? = null,
        @get:JvmName("fileUniqueId") val file_unique_id: String? = null,
        @get:JvmName("fileSize") val file_size: Int? = null,
        @get:JvmName("filePath") val file_path: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}